hr : human resource

SELECT * FROM TAB;

SELECT * FROM EMPLOYEES;
DESC EMPLOYEES;

¸ðµç »ç¿ø Á÷¿ø¹øÈ£, ÀÌ¸§, ÀüÈ­¹øÈ£ Á¶È¸
SELECT  EMPLOYEE_ID, fIRST_NAME, lAST_NAME, PHONE_NUMBER, SALARY
 FROM   EMPLOYEES;
 
 ¸ðµç »ç¿ø Á÷¿ø¹øÈ£, ÀÌ¸§, ÀüÈ­¹øÈ£ Á¶È¸, ´Ü ¿ù±Þ¼ø ³»¸²Â÷¼øÀ¸·Î
 SELECT    EMPLOYEE_ID, FIRST_NAME,LAST_NAME, SALARY
  FROM     EMPLOYEES
  ORDER BY SALARY DESC;
  
  ¸ðµç »ç¿øÀ» ÀÌ¸§¼øÀ¸·Î Ãâ·Â, ´Ü ¿ù±Þ 10000 ÀÌ»ó
  SELECT      *
   FROM       EMPLOYEES
   WHERE      SALARY >= 10000
   ORDER BY   FIRST_NAME ASC
  
¹®ÀÚ¿­ °áÇÕ ( || )
 Ä®·³ AS º°¸í  : Ä®·³¸í¿¡ º°¸íÀ» ºÎ¿© (AS »ý·«°¡´É)
SELECT        EMPLOYEE_ID AS »ç¹ø, FIRST_NAME || ' ' || LAST_NAME  ÀÌ¸§
 FROM         EMPLOYEES  

60¹ø ºÎ¼­ Á÷¿øÀÇ ÀÌ¸§°ú ÀÌ¸ÞÀÏ
SELECT   FIRST_NAME || ' ' || LAST_NAME ÀÌ¸§, 
         LOWER(EMAIL || '@PKNU.AC.KR')  ÀÌ¸ÞÀÏ, 
         DEPARTMENT_ID ºÎ¼­¹øÈ£
 FROM    EMPLOYEES
 WHERE   DEPARTMENT_ID = 60;
 
SELECT  EMPLOYEE_ID, FIRST_NAME , 'HELLO'
 FROM   EMPLOYEES 

°ü°è¿¬»êÀÚ   >, <, >=, <=, =, <>(!=) 
³í¸®¿¬»êÀÚ   NOT, AND , OR

--¿ù±ÞÀÌ 10000 ÀÎ ºÎ¼­¹øÈ£ 60, 90 ºÎ¼­Á÷¿øÃâ·Â
SELECT   EMPLOYEE_ID, 
         FIRST_NAME || ' ' || LAST_NAME ,
         SALARY, 
         DEPARTMENT_ID
 FROM    EMPLOYEES
 WHERE   SALARY        >= 100
  AND   ( DEPARTMENT_ID  =  60
   OR    DEPARTMENT_ID  =  90 )
  
--- ºÎ¼­, 60, 90, 100 ºÎ¼­Á÷¿ø¸¸ Ãâ·Â   
SELECT  *
 FROM   EMPLOYEES
 WHERE ( DEPARTMENT_ID  = 60
  OR      DEPARTMENT_ID  = 90
  OR      DEPARTMENT_ID  = 100) 
 
 SELECT  *
 FROM   EMPLOYEES
 WHERE  DEPARTMENT_ID  IN (60, 90, 100)
  
 -- ¿¬ºÀ(SALALRY * 12)ÀÌ 100000 ÀÌ»óÀÎ Á÷¿øÀÇ ÀÌ¸§°ú ºÎ¼­Á¤º¸
 SELECT      FIRST_NAME || ' ' || LAST_NAME  ÀÌ¸§, 
             DEPARTMENT_ID ºÎ¼­¹øÈ£, 
             (SALARY* 12 )¿¬ºÀ
  FROM       EMPLOYEES
  WHERE      (SALARY * 12) >= 100000 
  -- ORDER BY   ¿¬ºÀ  ASC
  -- ORDER BY SALARY * 12  ASC
  ORDER BY    3  ASC
 
 -- ¿ù±ÞÀÌ 10000~20000 »çÀÌÀÎ Á÷¿ø¸í´Ü
 SELECT      FIRST_NAME, LAST_NAME, SALARY 
  FROM       EMPLOYEES
 WHERE       10000 <= SALARY AND SALARY <= 20000
 ORDER BY    SALARY DESC; 
  
 SELECT    FIRST_NAME, LAST_NAME, SALARY
  FROM     EMPLOYEES
  WHERE    SALARY BETWEEN 10000 AND 20000;
  
 SELECT * FROM EMPLOYEES;  
 
 -- NULL ºò±³´Â IS , IS NOT
 -- ¼º°ú±ÞÀ» ¸ø¹Þ´Â »ç¶÷ ¸ñ·Ï
 SELECT  EMPLOYEE_ID, SALARY, COMMISSION_PCT
  FROM   EMPLOYEES
-- WHERE  COMMISSION_PCT = NULL -- Â¥°ø¾ÈÇÔ
  WHERE  COMMISSION_PCT IS NULL

 -- ¼º°ú±ÞÀ» ¹Þ´Â »ç¶÷ ¸ñ·Ï
 =-- º¸³Ê½º SALARY * 12 * COMMISSION_PCT
 SELECT  EMPLOYEE_ID, SALARY, COMMISSION_PCT,
         NVL(SALARY * 12 * COMMISSION_PCT, 0) AS BONUS
  FROM   EMPLOYEES
  WHERE  COMMISSION_PCT IS NOT NULL
 
 -- NVL(Ä®·³, °ª) : Ä®·³¿¡ NULL ÀÌ¸é °ªÀ¸·Î ´ëÃ¼ÇÑ´Ù : NULL VALUE
 -- NULL Àº °è»ê¿¡ Æ÷ÇÔÇØµµ NULL
 SELECT   FIRST_NAME, LAST_NAME, SALARY, SALARY*12 ¿¬ºÀ,
          SALARY*12 + (SALARY*12) * NVL( COMMISSION_PCT, 0 )    ¿¬ºÀÃÑ¾×
  FROM    EMPLOYEEs
  
 -- 50¹ø ºÎ¼­ÀÇ Á÷¿øÀÌ¸§
 SELECT   FIRST_NAME, LAST_NAME, DEPARTMENT_ID
  FROM    EMPLOYEES
  WHERE   DEPARTMENT_ID = 50
 -- WHERE   DEPARTMENT_ID = '50'  -- ÀÛµ¿ÇÏÁö¸¸ ³ªÁß¿¡ ¿¡·¯
 
 SELECT * FROM EMPLOYEES;
 SELECT * FROM DEPARTMENTS;
 
 --IT ºÎ¼­ÀÇ Á÷¿øÀÇ ÀÌ¸§
 SELECT   DEPARTMENT_ID
  FROM    DEPARTMENTS
  WHERE   DEPARTMENT_NAME = 'IT'
 
 SELECT   DEPARTMENT_ID, FIRST_NAME, LAST_NAME
  FROM    EMPLOYEES
  WHERE   DEPARTMENT_ID = 60; 
 
 -- SUBQUERY : SELECT ¾È¿¡ SELECT ¸¦ »ç¿ë () ¾È¿¡ »ç¿ë
 SELECT   DEPARTMENT_ID, FIRST_NAME, LAST_NAME
  FROM    EMPLOYEES
  WHERE   DEPARTMENT_ID = (
     SELECT   DEPARTMENT_ID
       FROM    DEPARTMENTS
       WHERE   DEPARTMENT_NAME = 'IT'
  ); 
  
  -- ºÎ¼­¸í¿¡ IT ¸¦ Æ÷ÇÔÇÏ´Â ºÎ¼­Á÷¿ø ÀÇ ÀÌ¸§
  -- ¹®ÀÚ¿­Æ÷ÇÔ °Ë»ö
  -- _ : 1 ±ÛÀÚ ´ëÀÀ      '±è_' : '±è¹ä'(¤Â) , '±è'(x)
  -- % : 0 ÀÚ ÀÌ»óÀÇ ¸ðµç ±ÛÀÚ
  -- LIKE '±è%'  : '±èÀ¸·Î ½ÃÀÛÇÏ´Â',  '±è', '±èÁ¤Àº', '±è¹ä', '±è À¯½Å'
  -- LIKE '%±è'  : '±è'À¸·Î ³¡³ª´Â',   '¸ø»ý±è', '¾ç¹Ý±è'. '±è'
  -- LIKE '%±è%' : '±è'À» Æ÷ÇÔÇÏ´Â ¸ðµç '±è', 'Àß»ý±è', '±èÁ¤ÀÏ'
  
  SELECT   DEPARTMENT_ID, DEPARTMENT_NAME 
   FROM    DEPARTMENTS
   WHERE   DEPARTMENT_NAME LIKE '%IT%'
  
  SELECT   DEPARTMENT_ID, FIRST_NAME, LAST_NAME
  FROM    EMPLOYEES
  WHERE   DEPARTMENT_ID IN (
      SELECT   DEPARTMENT_ID
       FROM    DEPARTMENTS
       WHERE   DEPARTMENT_NAME LIKE '%IT%'  
  ); 
 
 -- Marketing, IT, Sales, Accounting ºÎ¼­ÀÇ Á÷¿ø ÀÌ¸§, ¿ù±Þ
 SELECT   department_id
  FROM    DEPARTMENTS
  WHERE   DEPARTMENT_NAME = 'Marketing'
    OR    DEPARTMENT_NAME =  'IT'
    OR    DEPARTMENT_NAME =  'Sales'
    OR     DEPARTMENT_NAME = 'Accounting'
    
SELECT   department_id
  FROM    DEPARTMENTS
  WHERE   DEPARTMENT_NAME in ( 'Marketing', 'IT', 'Sales', 'Accounting'  )
 
 SELECT   first_name, last_name, salary, department_id
  FROM    EMPLOYEES
  WHERE   department_id in (
     SELECT   department_id
      FROM    DEPARTMENTS
      WHERE   DEPARTMENT_NAME in ( 'Marketing', 'IT', 'Sales', 'Accounting')   
  );
 
 -- ÀÔ»çÀÏÀÌ 02/06/07 ÀÎ Á÷¿øÀ» Ã£±â.
 SELECT    EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE
  FROM     EMPLOYEES
  WHERE    HIRE_DATE = '02/06/07'
 
 -- 07³â 06¿ù 2ÀÏ
 -- 07³â 02¿ù 6ÀÏ
 -- 02 ³â 6¿ù 7ÀÏ (Á¤´ä)
 
 -------------------------------------------------------
 -- 2020.05.11  ¼ö¾÷
 -- ºÎ¼­º° Á÷¿øÀÌ¸§
 SELECT   DEPARTMENT_ID, FIRST_NAME
  FROM    EMPLOYEES
  
  -- EMPLOYEES Å×ÀÌºíÀÇ ºÎ¼­¹øÈ£
  SELECT   DEPARTMENT_ID
   FROM   EMPLOYEES
   ORDER BY DEPARTMENT_ID ASC;
 
  -- Áßº¹Á¦°ÅÈÄ Ãâ·Â (DISTINCT) - NULL Æ÷ÇÔ 12°³
  SELECT     DISTINCT DEPARTMENT_ID
   FROM      EMPLOYEES
   ORDER BY DEPARTMENT_ID ASC;
   
  -- ºÎ¼­Å×ÀÌºíÀÇ ºÎ¼­¹øÈ£¸¦ Ãâ·Â - 27°³
  SELECT     DEPARTMENT_ID
   FROM      DEPARTMENTS
   ORDER BY  DEPARTMENT_ID;
   
  SELECT  DISTINCT DEPARTMENT_ID, FIRST_NAME
   FROM   EMPLOYEES
   ORDER BY DEPARTMENT_ID ASC;
   
  SELECT EMPLOYEE_ID, FIRST_NAME, HIRE_DATE 
   FROM EMPLOYEES
   WHERE HIRE_DATE  = '07/02/07' ;
   
   -- ANY, ALL, SOME
   
   SELECT     EMPLOYEE_ID, FIRST_NAME, SALARY
    FROM      EMPLOYEES
    WHERE     SALARY = 2000   
     OR       SALARY = 3000
     OR       SALARY = 4000
    ORDER BY  EMPLOYEE_ID;

  SELECT     EMPLOYEE_ID, FIRST_NAME, SALARY
    FROM      EMPLOYEES
    WHERE     SALARY IN( 2000, 3000, 4000) 
    ORDER BY  EMPLOYEE_ID; - 187, 192, 197
 
 SELECT   SALARY
  FROM    EMPLOYEES
  WHERE   EMPLOYEE_ID = 187
    OR      EMPLOYEE_ID = 192
    OR      EMPLOYEE_ID = 197
 
 SELECT     EMPLOYEE_ID, FIRST_NAME, SALARY
    FROM      EMPLOYEES
    WHERE     SALARY >=ANY ( SELECT   SALARY
  FROM    EMPLOYEES
  WHERE   EMPLOYEE_ID = 187
    OR      EMPLOYEE_ID = 192
    OR      EMPLOYEE_ID = 197 ) 
    ORDER BY  EMPLOYEE_ID; 
 
 SELECT     EMPLOYEE_ID, FIRST_NAME, SALARY
    FROM      EMPLOYEES
    WHERE     SALARY >= ( SELECT  MIN( SALARY )
  FROM    EMPLOYEES
  WHERE   EMPLOYEE_ID = 187
    OR      EMPLOYEE_ID = 192
    OR      EMPLOYEE_ID = 197 ) 
    ORDER BY  EMPLOYEE_ID; 
          
 SELECT     EMPLOYEE_ID, FIRST_NAME, SALARY
    FROM      EMPLOYEES
    WHERE     SALARY IN( 2000, 3000, 4000 ) 
    ORDER BY  EMPLOYEE_ID; 
  
   SELECT     EMPLOYEE_ID, FIRST_NAME, SALARY
    FROM      EMPLOYEES
    WHERE     SALARY >= ANY ( 2000, 3000, 4000) 
    ORDER BY  EMPLOYEE_ID
    -- ; SALARY >= 2000
    
    SELECT
    
  
  SELECT     EMPLOYEE_ID, FIRST_NAME, SALARY
    FROM      EMPLOYEES
    WHERE     SALARY >= ALL ( 2000, 3000, 4000) 
    ORDER BY  EMPLOYEE_ID;
  
  
  SELECT     EMPLOYEE_ID, FIRST_NAME, SALARY
    FROM      EMPLOYEES
    WHERE     SALARY = SOME ( 2000, 3000, 4000) 
    ORDER BY  EMPLOYEE_ID; 
  
  -- ³»ÀåÇÔ¼ö(  BUILT-IN FUNCTION )
  ---- ÇÏ°³ÀÇ°ªÀ» ¸®ÅÏÇÏ´Â ºÎÇÁ·Î±×·¥
  -- Àâ°èÇÔ¼ö : SUM(), MAX(), MIN(0, SUM(), AVG()
  ---- Æ¯¼º : NULL Àº°è»ê¿¡ Á¦¿ÜÇÑ´Ù
  ---- °Ô»ê ´ÜÀ§ : ´Ù¸¥ ROW ÀÇ °°Àº COLUMNÀ» ´ë»óÀ¸·ÎÇÑ´Ù
  ------ ÀüÃ¼¿ù±ÞÇÕ
  SELECT  SALARY   FROM   EMPLOYEES
  SELECT SUM(SALARY) FROM EMPLOYEES;
  
  SELECT   COUNT(EMPLOYEE_ID), SUM(SALARY), AVG(SALARY)
   FROM    EMPLOYEES
   WHERE   DEPARTMENT_ID = 60
  
  ------ ÀüÃ¼¿ù±ÞÆò±Õ
  SELECT AVG(SALARY) FROM EMPLOYEES;
  
  SELECT 10 / 3 FROM DUAL;
  SELECT SYSDATE FROM DUAL;  -- 20/05/11
  
  SELECT ROUND(10 / 3, 2) FROM DUAL;
  
   -- PRIMARY KEY : NOT NULL(ÇÊ¼öÀÔ·Â) + UNIQUE(Áßº¹ºÒ°¡)
  
  -- Á÷¿ø¼ö : COUNT()
  SELECT COUNT(*)              FROM EMPLOYEES;     --  107
  SELECT COUNT(EMPLOYEE_ID)    FROM EMPLOYEES;     --  107 
  SELECT COUNT(DEPARTMENT_ID)  FROM EMPLOYEES;   --  1
  
  -- Ç¥ÁØÆíÂ÷(STDDEV, ºÐ»ê
  
  -- 60 ¹ø ºÎ¼­¯M ÃÖÀú¿ù±Þ, ÃÖ´ë¿ù±Þ
  SELECT       MIN(SALARY), MAX(SALARY) 
   FROM        EMPLOYEES
   WHERE       DEPARTMENT_ID = 60; 
   
-- SALEE ºÎ¼­ÀÇ ÃÖ´ë, ÃÖÀú¿ù±Þ, ¿ù±Þ Æò±Õ
  SELECT DEPARTMENT_ID FROM DEPARTMENTS
   WHERE  DEPARTMENT_NAME = 'Sales';
  
  SELECT  MAX(SALARY), MIN(SALARY), SUM(SALARY), 
          ROUND(AVG(SALARY), 3), COUNT(SALARY)
   FROM   EMPLOYEES
   WHERE  DEPARTMENT_ID = 80;
   
  SELECT  FIRST_NAME, lAST_NAME
   FROM   EMPLOYEES
   
  --ÀüÈ­¹øÈ£ÀÇ Áö¿ª¹øÈ£ÀÌ 590À¸·Î ½ÃÀÛµÇ´Â »ç¶÷ÀÇ ÀÌ¸§, ºÎ¼­¹øÈ£-
  SELECT     FIRST_NAME || ' ' || LAST_NAME AS "Á÷¿ø ÀÌ¸§", 
             DEPARTMENT_ID ºÎ¼­¹øÈ£, 
             PHONE_NUMBER
   FROM      EMPLOYEES  
   WHERE     PHONE_NUMBER LIKE  '590%';
   
  --ÀüÈ­¹øÈ£°¡ 4567·Î ³¡³ª´Â Á÷¿ø ÀÌ¸§, ºÎ¼­¹øÈ£,ÀüÈ­¹øÈ£
  SELECT   FIRST_NAME || ' '  || LAST_NAME "Á÷¿ø ÀÌ¸§", 
           DEPARTMENT_ID ºÎ¼­¹øÈ£,
           PHONE_NUMBER ÀüÈ­¹øÈ£           
   FROM    EMPLOYEES
   WHERE   PHONE_NUMBER LIKE '%4567';
     
  --ÀüÈ­¹øÈ£°¡ 23ÀÌ Æ÷ÇÔµÈ Á÷¿øÀÌ¸§, ºÎ¼­¹øÈ£, ÀüÈ­ ¹øÈ£
  SELECT   FIRST_NAME || ' '  || LAST_NAME "Á÷¿ø ÀÌ¸§", 
           DEPARTMENT_ID ºÎ¼­¹øÈ£,
           PHONE_NUMBER ÀüÈ­¹øÈ£           
   FROM    EMPLOYEES
   WHERE   PHONE_NUMBER LIKE '%23%';
  
  --ÀüÈ­¹øÈ£°¡ 6¹øÂ°°¡ 2 ¿Í 7¹øÂ° ÀÚ¸®°¡ 3ÀÎ Á÷¿øÀÌ¸§, ºÎ¼­¹øÈ£, ÀüÈ­ ¹øÈ£
  SELECT   FIRST_NAME || ' '  || LAST_NAME "Á÷¿ø ÀÌ¸§", 
           DEPARTMENT_ID ºÎ¼­¹øÈ£,
           PHONE_NUMBER ÀüÈ­¹øÈ£           
   FROM    EMPLOYEES
   WHERE   PHONE_NUMBER LIKE '_____23_____';
    
  --03/06/17 - 03³â 06¿ù 17ÀÏ ÀÔ»çÀÏÀÎÁ÷¿ø Ãâ·Â
  SELECT   FIRST_NAME || ' ' || LAST_NAME Á÷¿ø¸í, HIRE_DATE ÀÔ»çÀÏ
   FROM    EMPLOYEES
   WHERE   HIRE_DATE = '03/06/17'; -- 03³â06¿ù17ÀÏ
   
  --ÀÔ»çÀÏ ¼øÀ¸·Î Ãâ·Â
 SELECT  * 
  FROM   EMPLOYEES
  ORDER BY HIRE_DATE ASC;
  
  --ÀÔ»çÀÏ ¿ª¼øÀ¸·Î Ãâ·Â 
  SELECT  * 
  FROM   EMPLOYEES
  ORDER BY HIRE_DATE DESC;
  
  -- ÃÖ¼ÒÀÔ»çÀÏ ÃÖ´ëÀÌ»çÀÏ
  SELECT  MIN(HIRE_DATE), MAX(HIRE_DATE)
   FROM   EMPLOYEES
   
   -- °¡Àå´ÁÁ¦ÀÔ»çÇÑ ÇÏ¸¶ÀÇ »ç¾÷, ÀÌ¸§
   SELECT   MAX(HIRE_DATE)
    FROM    EMPLOYEES;     -- 08/04/21
   
   SELECT   FIRST_NAME, HIRE_DATE
    FROM    EMPLOYEES
    WHERE   HIRE_DATE = '08/04/21';
    
   SELECT   FIRST_NAME, HIRE_DATE
    FROM    EMPLOYEES
    WHERE   HIRE_DATE = (
     SELECT   MIN(HIRE_DATE)
      FROM    EMPLOYEES    
    );
 
  --08³â ÀÔ»çÀÚ Ãâ·Â
 SELECT   EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
  FROM    EMPLOYEES
  --WHERE   HIRE_DATE LIKE '08%'
  -- WHERE   '08/01/01' <= HIRE_DATE AND HIRE_DATE < '09/01/01'
  WHERE   HIRE_DATE BETWEEN '08/01/01' AND '08/12/31 00:00:00.000'; 
  
  SELECT  * FROM DEPARTMENTS
  
  
  --08³â 2¿ùÀÔ»çÀÚ Ãâ·Â
  SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE, DEPARTMENT_ID
   FROM   EMPLOYEES
   WHERE  HIRE_DATE BETWEEN '08/02/01' AND '08/02/29'
  
  --08³â 2¿ùÀÔ»çÇÑ ITºÎ¼­ Á÷¿ø Ãâ·Â
  SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
   FROM   EMPLOYEES
   WHERE  HIRE_DATE BETWEEN '08/02/01' AND '08/02/29'
    AND   DEPARTMENT_ID = ( 
       SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE lower(DEPARTMENT_NAME) = 'it'   
    );
   
   --08³â 2¿ùÀÔ»çÇÑ Shipping(50)ºÎ¼­ Á÷¿ø Ãâ·Â - ¹°·ù
  SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
   FROM   EMPLOYEES
   WHERE  HIRE_DATE BETWEEN '08/02/01' AND '08/02/29'
    AND   DEPARTMENT_ID = ( 
       SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME = 'Shipping'   
    );
   -------------------------------------------------------------------------
   -- ¹®ÀÚÇÔ¼ö
   -- ´ë¹®ÀÚ, ¼Ò¹®ÀÚ, Ã¹±ÛÀÚ¸¸ ´ë¹®ÀÚ
  SELECT  'Oracle Mania'
          , UPPER('Oracle Mania')
          , LOWER('Oracle mania')
          , INITCAP('Oracle mania')
          , CHR(65), ASCII('a')
   FROM   DUAL;    
   
  -- ¹®ÀÚ±æÀÌ : length ´Â ±ÛÀÚ¼ö : 9ÀÚ
  --           lengthb : byte ´ÜÀ§ utf-8 ÀÌ¹Ç·Î ÇÑ±Û1ÀÚ´Â 3¹ÙÀÌÆ® : 15 ¹ÙÀÌÆ®
  SELECT '¿À¶óÅ¬ Mania', LENGTH('¿À¶óÅ¬ Mania'), LENGTHB('¿À¶óÅ¬ Mania')
   FROM   DUAL;
   
 -- CONCAT : ¹®ÀÚ¿­ °áÇÕ
 SELECT 'Oracle', 'mania', concat('Oracle', 'mania'), 'Oracle' || 'mania'   
  FROM  DUAL; 
   
 -- SUBSTR : SUBSTR('¹®ÀÚ¿­', ½ÃÀÛÀ§Ä¡(1~), ±ÛÀÚ¼ö) : ¹®ÀÚ¿­ ÃßÃâ
 SELECT  SUBSTR('851225-1110211', 1, 6),
         SUBSTR('851225-1110211', 8, 1)         
  FROM   DUAL;
 --             1    45     
 SELECT SUBSTR('¿À¶óÅ¬ Mania', 4, 3) ,  -- ' Ma'
        SUBSTRB('¿À¶óÅ¬ Mania', 4, 3)   -- '¶ó' 
  from  dual;      
 
 -- INSTR : ¹®ÀÚ¿­¾È¿¡¼­ ¹®ÀÚÃ£±â
 ---      ¸øÃ£À¸¸é 0
 --   
SELECT  INSTR('CORPORATE FLOOR', 'OR')
        ,INSTR('CORPORATE FLOOR', 'OR', 2+1)
        ,INSTR('CORPORATE FLOOR', 'OR', 5+1)
        ,INSTR('CORPORATE FLOOR', 'or', 5+1)
        ,INSTR(lower('CORPORATE FLOOR'), 'or', 5+1)
 FROM   DUAL;
 
 -- Á÷¿øÁßJOB ÀÌ CLERK À» °Ë»öÇÏ¼¼¿ä
  SELECT FIRST_NAME, JOB_ID 
  FROM EMPLOYEES;
 
 -- LIKE
 SELECT    FIRST_NAME, JOB_ID
  FROM     EMPLOYEES
  WHERE    JOB_ID LIKE '%CLERK'
  ORDER BY JOB_ID; 
  
 -- INSTR
 SELECT  FIRST_NAME, JOB_ID
  FROM   EMPLOYEES
  WHERE  INSTR( JOB_ID, 'CLERK' ) > 0
    ORDER BY JOB_ID; 
  
 -- SUBSTR
 SELECT  FIRST_NAME, JOB_ID
  FROM   EMPLOYEES
  WHERE  SUBSTR( JOB_ID, 4, 5) =  'CLERK';
  
  -- LPAD
  SELECT  SALARY AS "AAAAAAAAAAAAAAAA",  LPAD (SALARY, 10, '*')
   FROM   EMPLOYEES
   
 SELECT  SALARY AS "AAAAAAAAAAAAAAAA",  RPAD (SALARY, 10, '*')
   FROM   EMPLOYEES
  
  -- TRIM : ¾ÕÀ§ÀÇ (°ø¹é) ¹®ÀÚ¸¦ Á¦°ÅÇÑ´Ù
 select 'ASKLDFJSADLOJFSALKFJASKLOracle Mania¤Â1234----',
        TRIM('    ABCDE FKSDJHFKASDJ     '),
        trim('O' from 'ASKLDFJSADLOJFSALKFJASKLOracle ManiaO1234----'),
        trim('O' from 'OOOOJFSALKFJASKLOracle ManiaOOOO')
  from dual;      

select 'Oracle Mania', '     Oracle Mania     ',
        trim('     Oracle Mania     ')
  from dual;      
  
  ---------------------------------------------------
  -- ¼ýÀÚÇÔ¼ö
  SELECT ABS(-12.3), SIGN(-5) 
   FROM  DUAL;
  
  -- ¹Ý¿Ã¸²
  SELECT   98.7654,
           ROUND(98.7654, 2),
           ROUND(98.7654, 0),
           ROUND(20098.7654, -2),
           ROUND(20034.7654, -2),
           ROUND(987654, -2)
   FROM DUAL;        
  
  -- ¿ø´ÜÀ§ Àý»ç
  SELECT   98.7654,
           TRUNC(98.7654, 2),
           TRUNC(98.7654, 0),
           TRUNC(20098.7654, -2), -- 100¿ø´ÜÀ§ Àý»ç
           TRUNC(20034.7654, -2),
           TRUNC(987654, -2)
   FROM DUAL;        
   
   -- ³ª¸ÓÁö
   SELECT MOD(10, 3) FROM DUAL; -- 10%3 -> 1
   
   -- ¿À¶óÅ¬ ÇÔ¼öÈ®ÀÎ - ¼÷Á¦
   -- Â÷ÀÌÁ¡ ºñ±³ 
   SELECT MOD(10.7, 2.3) FROM DUAL;
   SELECT REMAINDER(10.7, 2.3) FROM DUAL;
  
   -- ¸ðµç »ï°¢ÇÔ¼ö´Â RADIAN °ªÀ¸·Î °Ô»êÇØ¾ßÇÑ´Ù
   -- 30µµ * ¿øÁÖ·ü/ 180 => RADIAN
   -- 30EH * 0.01745
   SELECT  ROUND( SIN(30*0.01745), 2), 
           ROUND( COS(30*0.01745), 2) , 
           ROUND( TAN(30*0.01745), 2) FROM DUAL;
   
   SELECT  SQRT(16) FROM DUAL;
   SELECT  4*4 FROM DUAL;
   SELECT  POWER(4, 2) FROM DUAL;
   SELECT  POWER(4, 0.5) FROM DUAL;
   SELECT  POWER(4, 3/2) FROM DUAL;
   
   -- CEIL() -- ¿Ã¸²
   -- FLOOR() --°ª¹ö¸²
   SELECT CEIL(3.8), FLOOR(3.8) FROM DUAL;
   SELECT CEIL(3.1), FLOOR(3.9) FROM DUAL;
   SELECT CEIL(-3.8), FLOOR(-3.8) FROM DUAL;
   
   ==========================================================
   ³¯Â¥
   
   -- ¿À´Ã³¯Â¥
   SELECT SYSDATE FROM DUAL;  -- 20/05/11
   
   ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
   SELECT SYSDATE FROM DUAL; 
   
   -- ÀÓ½ÃÀûÀ¸·Î ³¯Â¥ÀÇ ¸ð¾çÀ» º¯°æÇÑ´Ù
   ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
      
   -- ¿À´Ã³¯Â¥
   SELECT SYSDATE FROM DUAL; 
   -- ¾îÁ¦ ³¯Â¥
   SELECT  SYSDATE - 1  FROM DUAL
   -- 1ÁÖÀÏ ÈÄÀÇ ³¯Â¥
   SELECT  SYSDATE  + 7  FROM DUAL
   -- ³¯Â¥ + ¼ýÀÚ : SYSDATE + 3 : ¿À´ÃºÎÅÍ 3ÀÏ ÈÄ
   -- ³¯Â¥ - ¼ýÀÚ : SYSDATE - 3 : ¿À´ÃºÎÅÍ 3ÀÏ Àü
   
 -- Á÷¿øµéÀÇ ±Ù¹«ÀÏ¼ö¸¦ Ãâ·Â
 -- ³¯Â¥ - ³¯Â¥ : µÎ ³¯Â¥»çÀÌÀÇ °£°Ý( ~ÀÏ)
 -- ROUND(,0) : ¿ÀÀü/¿ÀÈÄ½Ã°£ À» ±âÁØ
 SELECT  EMPLOYEE_ID, 
         HIRE_DATE ÀÔ»çÀÏ, 
         SYSDATE - HIRE_DATE ±Ù¹«ÀÏ¼ö,
         ROUND(SYSDATE - HIRE_DATE, 0) 
  FROM   EMPLOYEES
  
  SELECT  ROUND( SYSDATE - TO_DATE('2020-01-29'), 2) FROM DUAL;
  
  --±Ù¹«ÀÏ¼ö
  SELECT  EMPLOYEE_ID, HIRE_DATE, 
          ROUND((SYSDATE - HIRE_DATE)/365.2422, 2) ±Ù¹«ÀÏ¼ö 
   FROM   EMPLOYEES

-- EMPLOYEES ¿¡ µÎ¸íÀÇ Á÷¿øÀ» Ãß°¡
INSERT INTO EMPLOYEES 
( 
    EMPLOYEE_ID,
    FIRST_NAME, LAST_NAME, EMAIL,          PHONE_NUMBER, 
    HIRE_DATE,   JOB_ID,     SALARY,       COMMISSION_PCT,  MANAGER_ID,
    DEPARTMENT_ID
)
  VALUES
 (
     (SELECT MAX(EMPLOYEE_ID)+1 FROM EMPLOYEES), 
     'ÁöÀº',   'ÀÌ' ,      'JYLEE',         '010.1234.4567',
     SYSDATE,   'IT_PROG',       NULL,      NULL,     107,
     NULL
 );

INSERT INTO EMPLOYEES 
( 
    EMPLOYEE_ID,
    FIRST_NAME, LAST_NAME, EMAIL,          PHONE_NUMBER, 
    HIRE_DATE,   JOB_ID,     SALARY,       COMMISSION_PCT,  MANAGER_ID,
    DEPARTMENT_ID
)
  VALUES
 (
     (SELECT MAX(EMPLOYEE_ID)+1 FROM EMPLOYEES), 
     '´ëÈ£',   'ÀÌ' ,      'TigerLEE',         '010.4567.4567',
     SYSDATE,   'AD_ASST',    1000,      NULL,     107,
     10
 );

COMMIT
SELECT * FROM EMPLOYEES;

-- Á÷¿ø¼ö
SELECT  COUNT(*), COUNT(EMPLOYEE_ID), COUNT(DEPARTMENT_ID), COUNT(SALARY)
 FROM   EMPLOYEES;

-- Á÷¿ø ¿ù±ÞÇÕ
SELECT SUM(SALARY) FROM EMPLOYEES;  -- 692416
-- Á÷¿ø ¿ù±ÞÆò±Õ
SELECT ROUND(AVG(SALARY),3) FROM EMPLOYEES; -- 6411.259

SELECT ROUND( SUM(SALARY) / COUNT(*) , 3) FROM EMPLOYEES; -- 6352.44

-- ¿À´ÃÀÔ»çÇÑ »ç¶÷ÇÑ »ç¶÷À» Ãâ·Â
 SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
  FROM   EMPLOYEES
 WHERE   HIRE_DATE = '2020-05-12'
 
SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
  FROM   EMPLOYEES
 WHERE   HIRE_DATE = '2020-05-12  00:00:00' 
  
  ALTER SESSION SET NLS_DATE_FORMAT='YYYY-MM-DD HH24:MI:SS'
  
 SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
  FROM   EMPLOYEES
  WHERE   SYSDATE - HIRE_DATE < = 1
   
 -- ÀÔ»çÀÏÀÌ '2020-05-12' ÀÎ »ç¶÷
 SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
  FROM   EMPLOYEES
  WHERE   HIRE_DATE LIKE '2020-05-12%'
 
  SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
  FROM   EMPLOYEES
  WHERE  '2020-05-12' <=  HIRE_DATE AND HIRE_DATE < '2020-05-13';
 
  --------------------------------------------
  ³¯Â¥ ÇÔ¼öµé
  
  -- 2002-02 À§ ¸¶Áö¸· ³¯Â¥
  SELECT LAST_DAY('2020-11-05') FROM DUAL;
  
  SELECT HIRE_DATE, LAST_DAY(HIRE_DATE) FROM EMPLOYEES;
  
  SELECT MONTHS_BETWEEN('2020-12-25', SYSDATE  ) FROM DUAL;
  
  SELECT SYSDATE + 3  FORM DUAL;  -- 3ÀÏÈÄ
  SELECT ADD_MONTHS(SYSDATE, 3) FROM DUAL; - ÇöÀç·Î ºÎÅÍ 3´Þ ÈÄ ³¯Â¥
  
  SELECT NEXT_DAY(SYSDATE, '¿ù') FROM DUAL; -- µ¹¾Æ¿À´Â ¿ù¿äÀÏ³¯Â¥  
  SELECT NEXT_DAY(SYSDATE, 'Åä') FROM DUAL; -- ´ÙÀ½ Åä¿äÀÏ³¯Â¥
  SELECT NEXT_DAY(SYSDATE, 2)    FROM DUAL; -- ´ÙÀ½ ¿ù(2)¿äÀÏ³¯Â¥ (1:ÀÏ¿äÀÏ)
  
  SELECT ROUND(SYSDATE), TRUNC(SYSDATE) FROM DUAL; -- ¿ÀÀü 12½Ã±âÁØ
  
  -- ÀÔ»çÇÑÁö 10³âÀÌ Áö³­ »ç¶÷Ãâ·Â
    
  -- ÀÔ»çÇÑÁö °¡Àå¿À·¡µÈ »ç¶÷
SELECT  MIN(HIRE_DATE)
 FROM   EMPLOYEES

SELECT  EMPLOYEE_ID
 FROM   EMPLOYEES
 WHERE  HIRE_DATE = '2001-01-13 00:00:00';
  
SELECT  EMPLOYEE_ID
 FROM   EMPLOYEES
 WHERE  HIRE_DATE = (
    SELECT  MIN(HIRE_DATE) FROM   EMPLOYEES 
 );

-- Àß¸øµÈ Ç¥Çö    
 SELECT EMPLOYEE_ID, MIN(HIRE_DATE)
 FROM   EMPLOYEES 
  
-- ºÎ¼­º° Á÷¿ø¼ö
SELECT DISTINCT DEPARTMENT_ID 
 FROM   EMPLOYEES
 
SELECT     DEPARTMENT_ID, COUNT(EMPLOYEE_ID)
 FROM      EMPLOYEES
 GROUP BY  DEPARTMENT_ID
 ORDER BY  DEPARTMENT_ID

-- ºÎ¼­º°, JOB_ID º° Á÷¿ø¼ö, ¿ù±ÞÇÕ
SELECT     DEPARTMENT_ID, JOB_ID, COUNT(*), SUM(SALARY)
 FROM      EMPLOYEES
 GROUP BY  DEPARTMENT_ID, JOB_ID
 
--  À§ ¹®Àå¿¡ Á¶°Ç Ãß°¡
----- ºÎ¼­¹øÈ£°¡ 10, 60, 110

 SELECT    DEPARTMENT_ID, JOB_ID, COUNT(*), SUM(SALARY)
 FROM      EMPLOYEES
 WHERE     DEPARTMENT_ID IN (10, 60, 110)
 GROUP BY  DEPARTMENT_ID, JOB_ID
 -- HAVING
 
 --- À§ Á¶°Ç¿¡ ¿ù±ÞÇÕÀÌ 20000 ÀÌ»óÀÎ ÀÚ·á
  SELECT    DEPARTMENT_ID, JOB_ID, COUNT(*), SUM(SALARY)
  FROM      EMPLOYEES
 -- WHERE     SUM(SALARY) >= 20000 -- ERROR WHERE µú°èÇÔ¼ö »ç¿ëºÒ°¡
  GROUP BY  DEPARTMENT_ID, JOB_ID
   HAVING   SUM(SALARY) >= 20000
 
 --   UNION, UNION ALL
 ---- ¿©·¯Å×ÀÌºíÀ» ÇÏ³ª·Î ÇÕÄ£´Ù
 SELECT * FROM EMPLOYEES 
   WHERE DEPARTMENT_ID = 10;
 
 SELECT * FROM EMPLOYEES 
   WHERE DEPARTMENT_ID = 60;
      
 SELECT * FROM EMPLOYEES 
   WHERE DEPARTMENT_ID IN ( 10, 60);


-- UNION Àº µÎ Å×ÀÌºíÀ» ¹°¸®ÀûÀ¸·Î °áÇÕÇÏ´Â°Í 
-- Á¶°Ç : Ä­ÀÇ °¹¼ö¿Í µ¥ÀÌÅÍ Å¸ÀÔÀº °°¾Ó¿µÇÑ´Ù
SELECT * FROM EMPLOYEES 
   WHERE DEPARTMENT_ID = 10
UNION  
 SELECT * FROM EMPLOYEES 
   WHERE DEPARTMENT_ID = 60;
   
 SELECT EMPLOYEE_ID, FIRST_NAME        FROM EMPLOYEES  
 UNION
 SELECT DEPARTMENT_ID, DEPARTMENT_NAME FROM  DEPARTMENTS
   
 -- ÇÕÁýÇÕ 
  UNION     : ROW Áßº¹Á¦°Å
  UNION ALL : ROW Áßº¹Æ÷ÇÔ
 
 -- ±³ÁýÇÕ
  INTERSECT 
  
 -- Â÷ÁýÇÕ
   MINUS
  -
  
--------------------------------------------------
  -- ºÎ¼­º° ÃÖ´ë ¿ù±Þ
  SELECT     DEPARTMENT_ID,  TO_CHAR( MAX(SALARY) , 'L99,999.99')
   FROM      EMPLOYEES 
   GROUP BY  DEPARTMENT_ID
   ORDER BY  DEPARTMENT_ID
  
  -- ÀÔ»çÀÏÀÌ ¿À´ÃÀÎ»ç¶÷Ãâ·Â
  SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
   FROM   EMPLOYEES
   WHERE  TRUNC(HIRE_DATE) = '2020-05-12'
\  

SELECT  SYSDATE
       , TO_CHAR(SYSDATE, 'YYYY')  YYYY
       , TO_CHAR(SYSDATE, 'YY')    YY
       , TO_CHAR(SYSDATE, 'YEAR')  YEAR
       , TO_CHAR(SYSDATE, 'MM')    MM
       , TO_CHAR(SYSDATE, 'MON')   MON
       , TO_CHAR(SYSDATE, 'MONTH') MONTH
       , TO_CHAR(SYSDATE, 'DD')    DD
       , TO_CHAR(SYSDATE, 'DY')    DY
       , TO_CHAR(SYSDATE, 'DAY')   DAY
  FROM  DUAL;
  
  -- 2020³â 5¿ù 11ÀÏ È­¿äÀÏ 15½Ã 32ºÐ 10ÃÊ  
  -- 2020Ò´ 5êÅ 11ìí ûýèøìí 15ãÁ 32ÝÂ 10õ¤
  
  SELECT  FIRST_NAME
         ,HIRE_DATE
         , TO_CHAR ( HIRE_DATE, 'YYYY' ) || 'Ò´ ' || 
           TO_CHAR ( HIRE_DATE, 'MM'   ) || 'êÅ ' ||
           TO_CHAR ( HIRE_DATE, 'DD'   ) || 'ìí ' ||             
           CASE 
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = 'ÀÏ'  THEN 'ìí'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '¿ù'  THEN 'êÅ'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = 'È­'  THEN 'ûý'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '¼ö'  THEN 'â©'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '¸ñ'  THEN 'ÙÊ'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '±Ý'  THEN 'ÐÝ'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = 'Åä'  THEN '÷Ï'           
           END
           || 'èøìí ' ||
           CASE
             WHEN  TO_CHAR( HIRE_DATE, 'HH24' ) < 12  THEN 'çíîñ '
             ELSE  'çíý­ '
           END   ||
           TO_CHAR ( HIRE_DATE, 'HH24' ) || 'ãÁ ' ||
           TO_CHAR ( HIRE_DATE, 'MI'   ) || 'ÝÂ ' || 
           TO_CHAR ( HIRE_DATE, 'SS'   ) || 'õ¤'  AS "ÀÔ»çÀÏ"
   FROM   EMPLOYEES
   
 SELECT  FIRST_NAME
         ,HIRE_DATE
         , TO_CHAR ( HIRE_DATE, 'YYYY' ) || 'Ò´ ' || 
           TO_CHAR ( HIRE_DATE, 'MM'   ) || 'êÅ ' ||
           TO_CHAR ( HIRE_DATE, 'DD'   ) || 'ìí ' ||             
           CASE TO_CHAR ( HIRE_DATE, 'DY' )              
              WHEN  'ÀÏ'  THEN 'ìí'
              WHEN  '¿ù'  THEN 'êÅ'
              WHEN  'È­'  THEN 'ûý'
              WHEN  '¼ö'  THEN 'â©'
              WHEN  '¸ñ'  THEN 'ÙÊ'
              WHEN  '±Ý'  THEN 'ÐÝ'
              WHEN  'Åä'  THEN '÷Ï'           
           END
           || 'èøìí ' ||
           CASE
             WHEN  TO_CHAR( HIRE_DATE, 'HH24' ) < 12  THEN 'çíîñ '
             ELSE  'çíý­ '
           END   ||
           TO_CHAR ( HIRE_DATE, 'HH24' ) || 'ãÁ ' ||
           TO_CHAR ( HIRE_DATE, 'MI'   ) || 'ÝÂ ' || 
           TO_CHAR ( HIRE_DATE, 'SS'   ) || 'õ¤'  AS "ÀÔ»çÀÏ"
   FROM   EMPLOYEES
   
    
  SELECT   TO_CHAR(12345,    '999999'), 
           TO_CHAR(12345,    '0999999'), 
           TO_CHAR(1243.4567, '099,999.999'), 
           TO_CHAR(1234567, 'L99,999') ,  -- ÀÚ¸®°¡ ¸ðÀÚ¶ó¸é #À¸·Î Ãâ·ÂµÈ´Ù
           TO_CHAR(1234567, 'L9,999,999') ,
           TO_CHAR(1234567, '$9,999,999')
   FROM DUAL;

  SELECT 1 + '3' FROM DUAL;
  SELECT 1 + '3.7' FROM DUAL;
  SELECT 1 + 'A' FROM DUAL;
 --       12345678901234    
  SELECT '750913-1113042',
         CASE
           WHEN SUBSTR('750913-1113042', 8, 1) = '1' THEN '³²ÀÚ'
           WHEN SUBSTR('750913-1113042', 8, 1) = '2' THEN '¿©ÀÚ'
         END "¼ºº°",
         DECODE( SUBSTR('750913-3113153', 8, 1),'1', '³²ÀÚ', '¿©ÀÚ') "¼ºº°",
         DECODE( MOD(SUBSTR('750913-4113153', 8, 1), 2),1, '³²ÀÚ', '¿©ÀÚ') "¼ºº°"
         
   FROM  DUAL;
   
   ---------------------------------------------
   SELECT  *    FROM   DEPARTMENTS;   
   SELECT  *    FROM   EMPLOYEES;   
   
   SELECT   EMPLOYEE_ID,
            FIRST_NAME,            
            DECODE( DEPARTMENT_ID,
               10,  'Administration',
               20,  'Marketing',
               30,  'Purchasing',
               40,  'Human Resources',
               50,  'Shipping',
               60,  'IT',
               '±×¿Ü'
            )  ºÎ¼­¸í
    FROM   EMPLOYEES;       
  

  

