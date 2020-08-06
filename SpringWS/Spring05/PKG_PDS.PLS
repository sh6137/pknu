create or replace PACKAGE PKG_PDS AS 
   
   PROCEDURE  PROC_PDS_INSERT(
       IN_MENU_ID    IN     VARCHAR2,
       IN_TITLE      IN     VARCHAR2,
       IN_CONT       IN     VARCHAR2,
       IN_WRITER     IN     VARCHAR2,
       IN_BNUM       IN     NUMBER,
       IN_LVL        IN     NUMBER,
       IN_STEP       IN     NUMBER,
       IN_NREF       IN     NUMBER,
       
       IN_FILENAME   IN     FILE_ARRAY,
       IN_FILEEXT    IN     FILE_ARRAY,
       IN_SFILENAME  IN     FILE_ARRAY  
   );
   
   PROCEDURE   PROC_PDS_LIST
   (
        IN_MENU_ID       IN     VARCHAR2
       
       ,IN_NOWPAGE       IN     NUMBER      -- 보여룾 페이지 번호
       ,IN_PAGECOUNT     IN     NUMBER      -- 한 페이지 에 보여줄 LINE 수
       
       ,OUT_RECORDCOUNT  OUT    NUMBER      -- 전체 자료수      
       
       ,O_CUR       OUT     SYS_REFCURSOR
   );
  
   -- 내용보기
   PROCEDURE  PROC_PDS_CONTENT
   (
       IN_IDX     IN     NUMBER,
       O_CUR      OUT    SYS_REFCURSOR
   );
  
   -- 첨부파일 목록
   PROCEDURE  PROC_PDS_FILELIST 
   (
      IN_IDX     IN     NUMBER,
      O_CUR      OUT    SYS_REFCURSOR
   );
  
   PROCEDURE  PROC_PDS_UPDATE
   (
      IN_IDX       IN     NUMBER,
      IN_TITLE     IN     VARCHAR2,
      IN_CONT      IN     VARCHAR2
   );
  
   PROCEDURE  PROC_PDS_DELETE
   (
      IN_IDX       IN     NUMBER,     
      IN_LVL       IN     NUMBER,
      IN_STEP      IN     NUMBER,
      IN_NREF      IN     NUMBER     
   );
  
END PKG_PDS;