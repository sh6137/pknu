create or replace PACKAGE BODY PKG_PDS AS

  PROCEDURE  PROC_PDS_INSERT
  (
      IN_MENU_ID   IN  VARCHAR2,  
      IN_TITLE     IN  VARCHAR2,      
      IN_CONT      IN  VARCHAR2,
      IN_WRITER    IN  VARCHAR2,           
      IN_BNUM      IN  NUMBER,
      IN_LVL       IN  NUMBER,
      IN_STEP      IN  NUMBER,
      IN_NREF      IN  NUMBER
      
      -- 파일업로드에 대한 추가 항목
     , IN_FILENAME   IN   FILE_ARRAY
     , IN_FILEEXT    IN   FILE_ARRAY
     , IN_SFILENAME  IN   FILE_ARRAY
 
  ) AS
       V_BNUM    NUMBER(5, 0);   
       V_LVL     NUMBER(5, 0);
       V_STEP    NUMBER(5, 0);
       V_NREF    NUMBER(5, 0);
  
       V_MAXIDX  NUMBER(5, 0);
  BEGIN
      
       IF  IN_BNUM = 0 THEN  -- 새글 처리
           SELECT  NVL(MAX(BNUM), 0) + 1 INTO V_BNUM  FROM  BOARD
            WHERE  MENU_ID = IN_MENU_ID;
           V_LVL   := 0;
           V_STEP  := 0;
           SELECT  NVL(MAX(NREF), 0) + 1 INTO V_NREF  FROM  BOARD
            WHERE  MENU_ID = IN_MENU_ID;
       ELSE   -- 답글 처리
           V_BNUM := IN_BNUM;
           V_LVL  := IN_LVL  + 1;
           V_STEP := IN_STEP + 1;
           V_NREF := IN_NREF;
           
           -- 기존답글에 대한 순서 + 1
            UPDATE  BOARD 
             SET    STEP    =  STEP + 1
             WHERE  MENU_ID =  IN_MENU_ID
              AND   NREF    =  IN_NREF
              AND   STEP    > IN_STEP;
       END IF;
      
      -- 게시글 처리 
       INSERT INTO  BOARD
       (   
           IDX,            MENU_ID,    TITLE,    CONT,    WRITER, 
           REGDATE,                              READCOUNT, 
           BNUM,     LVL,     STEP,     NREF          
       ) VALUES (
           BRDSEQ.NEXTVAL, IN_MENU_ID, IN_TITLE, IN_CONT, IN_WRITER,
           TO_CHAR(SYSDATE, 'YYYY-MM-DD'),       0,
           V_BNUM,   V_LVL,   V_STEP,   V_NREF 
       );
      
      -- 가장 마지막에 추가된 글 IDX
      SELECT MAX(IDX) 
        INTO V_MAXIDX 
        FROM BOARD;    
      
     --여러 파일의 업로드 처리
      IF   IN_FILENAME(1) IS NOT NULL THEN  
          FOR  I  IN IN_FILENAME.FIRST .. IN_FILENAME.LAST
          LOOP
             INSERT INTO FILES
              VALUES
              (
                  ( SELECT NVL(MAX(FILE_NUM), 0) + 1 FROM FILES ),
                  V_MAXIDX,       -- 마지막에 추가된 게시글 번호
                  IN_FILENAME(I),
                  IN_FILEEXT(I),
                  IN_SFILENAME(I)
              );
          END LOOP;
      END IF;
  
      
  END PROC_PDS_INSERT;

    PROCEDURE   PROC_PDS_LIST
   (
        IN_MENU_ID       IN     VARCHAR2
       
       ,IN_NOWPAGE       IN     NUMBER      -- 보여룾 페이지 번호
       ,IN_PAGECOUNT     IN     NUMBER      -- 한 페이지 에 보여줄 LINE 수
       
       ,OUT_RECORDCOUNT  OUT    NUMBER      -- 전체 자료수      
       
       ,O_CUR       OUT     SYS_REFCURSOR
   ) AS
     STARTNUM      NUMBER(5, 0);
     ENDNUM        NUMBER(5, 0);
  BEGIN
    
     -- 전체 자료수
     SELECT    COUNT( IDX ) INTO   OUT_RECORDCOUNT
      FROM     BOARD
      WHERE    MENU_ID = IN_MENU_ID;
    
     STARTNUM := ( IN_NOWPAGE-1 ) * IN_PAGECOUNT + 1; 
     ENDNUM   := IN_NOWPAGE    *  IN_PAGECOUNT;  
     
     IF  OUT_RECORDCOUNT  <= ENDNUM   THEN
         ENDNUM  := OUT_RECORDCOUNT;
     END IF;
    
     OPEN O_CUR FOR
       SELECT   *   FROM 
       (
          SELECT
             ROW_NUMBER() OVER (ORDER BY NREF DESC, STEP ASC) AS RN,
             IDX, MENU_ID,
             LPAD(' ', 2*B.LVL) || DECODE( LVL, 0,  ' ', '[답변]') || TITLE as TITLE, 
             WRITER, REGDATE, READCOUNT,
             (
               SELECT  NVL(COUNT(FILENAME), 0)
                FROM   FILES
                WHERE  IDX  = B.IDX  
             ) FILESCOUNT,
             BNUM, LVL, STEP, NREF, DELNUM
          FROM   BOARD  B          
          WHERE  MENU_ID = IN_MENU_ID      
       )  T
       WHERE  RN  BETWEEN  STARTNUM  AND  ENDNUM
         ORDER BY NREF DESC, STEP ASC;       
    
  END PROC_PDS_LIST;

  PROCEDURE  PROC_PDS_CONTENT
   (
       IN_IDX     IN     NUMBER,
       O_CUR      OUT    SYS_REFCURSOR
   ) AS
  BEGIN
       OPEN   O_CUR   FOR
         SELECT  
            IDX, MENU_ID, TITLE, CONT, WRITER, REGDATE, READCOUNT, 
            BNUM, LVL, STEP, NREF, DELNUM         
          FROM   BOARD
          WHERE  IDX   = IN_IDX;

  END PROC_PDS_CONTENT;

  PROCEDURE  PROC_PDS_FILELIST 
   (
      IN_IDX     IN     NUMBER,
      O_CUR      OUT    SYS_REFCURSOR
   ) AS
  BEGIN
      
      OPEN    O_CUR  FOR
        SELECT   FILE_NUM, IDX, 
                 FILENAME, FILEEXT, SFILENAME
         FROM    FILES
         WHERE   IDX = IN_IDX;
      
  END PROC_PDS_FILELIST;

  PROCEDURE  PROC_PDS_UPDATE
   (
      IN_IDX       IN     NUMBER,
      IN_TITLE     IN     VARCHAR2,
      IN_CONT      IN     VARCHAR2
   ) AS
  BEGIN
  
       UPDATE     BOARD
        SET      TITLE    =  IN_TITLE,
                 CONT     =  IN_CONT
       WHERE     IDX      =  IN_IDX;
       
  END PROC_PDS_UPDATE;

  PROCEDURE  PROC_PDS_DELETE
   (
      IN_IDX       IN     NUMBER,     
      IN_LVL       IN     NUMBER,
      IN_STEP      IN     NUMBER,
      IN_NREF      IN     NUMBER
   ) AS
  BEGIN
     SAVEPOINT   SP_DELETE_PTR;     
        
       UPDATE BOARD SET  DELNUM = 1
         WHERE IDX = IN_IDX;
         
       -- 답글이 존재하지 않으면 지운다
       DELETE  FROM  BOARD
         WHERE NOT EXISTS (
            SELECT 1 FROM BOARD
            WHERE NREF = IN_NREF
             AND  LVL  = IN_LVL + 1
             AND  STEP = IN_STEP+ 1
         )
         AND IDX = IN_IDX;  
         
        DELETE FROM FILES
        WHERE NOT EXISTS
        (
           SELECT 1 FROM BOARD
           WHERE  NREF = IN_NREF
           AND   LVL   = IN_LVL + 1
           AND   STEP  = IN_STEP + 1 
        )
        AND  IDX = IN_IDX;
         
        COMMIT;
      EXCEPTION
        WHEN  OTHERS THEN
           ROLLBACK TO SP_DELETE_PTR;
           RAISE;    
  END PROC_PDS_DELETE;

END PKG_PDS;