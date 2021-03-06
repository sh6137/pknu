hr : human resource

SELECT * FROM TAB;

SELECT * FROM EMPLOYEES;
DESC EMPLOYEES;

모든 사원 직원번호, 이름, 전화번호 조회
SELECT  EMPLOYEE_ID, fIRST_NAME, lAST_NAME, PHONE_NUMBER, SALARY
 FROM   EMPLOYEES;
 
 모든 사원 직원번호, 이름, 전화번호 조회, 단 월급순 내림차순으로
 SELECT    EMPLOYEE_ID, FIRST_NAME,LAST_NAME, SALARY
  FROM     EMPLOYEES
  ORDER BY SALARY DESC;
  
  모든 사원을 이름순으로 출력, 단 월급 10000 이상
  SELECT      *
   FROM       EMPLOYEES
   WHERE      SALARY >= 10000
   ORDER BY   FIRST_NAME ASC
  
문자열 결합 ( || )
 칼럼 AS 별명  : 칼럼명에 별명을 부여 (AS 생략가능)
SELECT        EMPLOYEE_ID AS 사번, FIRST_NAME || ' ' || LAST_NAME  이름
 FROM         EMPLOYEES  

60번 부서 직원의 이름과 이메일
SELECT   FIRST_NAME || ' ' || LAST_NAME 이름, 
         LOWER(EMAIL || '@PKNU.AC.KR')  이메일, 
         DEPARTMENT_ID 부서번호
 FROM    EMPLOYEES
 WHERE   DEPARTMENT_ID = 60;
 
SELECT  EMPLOYEE_ID, FIRST_NAME , 'HELLO'
 FROM   EMPLOYEES 

관계연산자   >, <, >=, <=, =, <>(!=) 
논리연산자   NOT, AND , OR

--월급이 10000 인 부서번호 60, 90 부서직원출력
SELECT   EMPLOYEE_ID, 
         FIRST_NAME || ' ' || LAST_NAME ,
         SALARY, 
         DEPARTMENT_ID
 FROM    EMPLOYEES
 WHERE   SALARY        >= 100
  AND   ( DEPARTMENT_ID  =  60
   OR    DEPARTMENT_ID  =  90 )
  
--- 부서, 60, 90, 100 부서직원만 출력   
SELECT  *
 FROM   EMPLOYEES
 WHERE ( DEPARTMENT_ID  = 60
  OR      DEPARTMENT_ID  = 90
  OR      DEPARTMENT_ID  = 100) 
 
 SELECT  *
 FROM   EMPLOYEES
 WHERE  DEPARTMENT_ID  IN (60, 90, 100)
  
 -- 연봉(SALALRY * 12)이 100000 이상인 직원의 이름과 부서정보
 SELECT      FIRST_NAME || ' ' || LAST_NAME  이름, 
             DEPARTMENT_ID 부서번호, 
             (SALARY* 12 )연봉
  FROM       EMPLOYEES
  WHERE      (SALARY * 12) >= 100000 
  -- ORDER BY   연봉  ASC
  -- ORDER BY SALARY * 12  ASC
  ORDER BY    3  ASC
 
 -- 월급이 10000~20000 사이인 직원명단
 SELECT      FIRST_NAME, LAST_NAME, SALARY 
  FROM       EMPLOYEES
 WHERE       10000 <= SALARY AND SALARY <= 20000
 ORDER BY    SALARY DESC; 
  
 SELECT    FIRST_NAME, LAST_NAME, SALARY
  FROM     EMPLOYEES
  WHERE    SALARY BETWEEN 10000 AND 20000;
  
 SELECT * FROM EMPLOYEES;  
 
 -- NULL 빅교는 IS , IS NOT
 -- 성과급을 못받는 사람 목록
 SELECT  EMPLOYEE_ID, SALARY, COMMISSION_PCT
  FROM   EMPLOYEES
-- WHERE  COMMISSION_PCT = NULL -- 짜공안함
  WHERE  COMMISSION_PCT IS NULL

 -- 성과급을 받는 사람 목록
 =-- 보너스 SALARY * 12 * COMMISSION_PCT
 SELECT  EMPLOYEE_ID, SALARY, COMMISSION_PCT,
         NVL(SALARY * 12 * COMMISSION_PCT, 0) AS BONUS
  FROM   EMPLOYEES
  WHERE  COMMISSION_PCT IS NOT NULL
 
 -- NVL(칼럼, 값) : 칼럼에 NULL 이면 값으로 대체한다 : NULL VALUE
 -- NULL 은 계산에 포함해도 NULL
 SELECT   FIRST_NAME, LAST_NAME, SALARY, SALARY*12 연봉,
          SALARY*12 + (SALARY*12) * NVL( COMMISSION_PCT, 0 )    연봉총액
  FROM    EMPLOYEEs
  
 -- 50번 부서의 직원이름
 SELECT   FIRST_NAME, LAST_NAME, DEPARTMENT_ID
  FROM    EMPLOYEES
  WHERE   DEPARTMENT_ID = 50
 -- WHERE   DEPARTMENT_ID = '50'  -- 작동하지만 나중에 에러
 
 SELECT * FROM EMPLOYEES;
 SELECT * FROM DEPARTMENTS;
 
 --IT 부서의 직원의 이름
 SELECT   DEPARTMENT_ID
  FROM    DEPARTMENTS
  WHERE   DEPARTMENT_NAME = 'IT'
 
 SELECT   DEPARTMENT_ID, FIRST_NAME, LAST_NAME
  FROM    EMPLOYEES
  WHERE   DEPARTMENT_ID = 60; 
 
 -- SUBQUERY : SELECT 안에 SELECT 를 사용 () 안에 사용
 SELECT   DEPARTMENT_ID, FIRST_NAME, LAST_NAME
  FROM    EMPLOYEES
  WHERE   DEPARTMENT_ID = (
     SELECT   DEPARTMENT_ID
       FROM    DEPARTMENTS
       WHERE   DEPARTMENT_NAME = 'IT'
  ); 
  
  -- 부서명에 IT 를 포함하는 부서직원 의 이름
  -- 문자열포함 검색
  -- _ : 1 글자 대응      '김_' : '김밥'(ㅒ) , '김'(x)
  -- % : 0 자 이상의 모든 글자
  -- LIKE '김%'  : '김으로 시작하는',  '김', '김정은', '김밥', '김 유신'
  -- LIKE '%김'  : '김'으로 끝나는',   '못생김', '양반김'. '김'
  -- LIKE '%김%' : '김'을 포함하는 모든 '김', '잘생김', '김정일'
  
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
 
 -- Marketing, IT, Sales, Accounting 부서의 직원 이름, 월급
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
 
 -- 입사일이 02/06/07 인 직원을 찾기.
 SELECT    EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE
  FROM     EMPLOYEES
  WHERE    HIRE_DATE = '02/06/07'
 
 -- 07년 06월 2일
 -- 07년 02월 6일
 -- 02 년 6월 7일 (정답)
 
 -------------------------------------------------------
 -- 2020.05.11  수업
 -- 부서별 직원이름
 SELECT   DEPARTMENT_ID, FIRST_NAME
  FROM    EMPLOYEES
  
  -- EMPLOYEES 테이블의 부서번호
  SELECT   DEPARTMENT_ID
   FROM   EMPLOYEES
   ORDER BY DEPARTMENT_ID ASC;
 
  -- 중복제거후 출력 (DISTINCT) - NULL 포함 12개
  SELECT     DISTINCT DEPARTMENT_ID
   FROM      EMPLOYEES
   ORDER BY DEPARTMENT_ID ASC;
   
  -- 부서테이블의 부서번호를 출력 - 27개
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
  
  -- 내장함수(  BUILT-IN FUNCTION )
  ---- 하개의값을 리턴하는 부프로그램
  -- 잡계함수 : SUM(), MAX(), MIN(0, SUM(), AVG()
  ---- 특성 : NULL 은계산에 제외한다
  ---- 게산 단위 : 다른 ROW 의 같은 COLUMN을 대상으로한다
  ------ 전체월급합
  SELECT  SALARY   FROM   EMPLOYEES
  SELECT SUM(SALARY) FROM EMPLOYEES;
  
  SELECT   COUNT(EMPLOYEE_ID), SUM(SALARY), AVG(SALARY)
   FROM    EMPLOYEES
   WHERE   DEPARTMENT_ID = 60
  
  ------ 전체월급평균
  SELECT AVG(SALARY) FROM EMPLOYEES;
  
  SELECT 10 / 3 FROM DUAL;
  SELECT SYSDATE FROM DUAL;  -- 20/05/11
  
  SELECT ROUND(10 / 3, 2) FROM DUAL;
  
   -- PRIMARY KEY : NOT NULL(필수입력) + UNIQUE(중복불가)
  
  -- 직원수 : COUNT()
  SELECT COUNT(*)              FROM EMPLOYEES;     --  107
  SELECT COUNT(EMPLOYEE_ID)    FROM EMPLOYEES;     --  107 
  SELECT COUNT(DEPARTMENT_ID)  FROM EMPLOYEES;   --  1
  
  -- 표준편차(STDDEV, 분산
  
  -- 60 번 부서츼 최저월급, 최대월급
  SELECT       MIN(SALARY), MAX(SALARY) 
   FROM        EMPLOYEES
   WHERE       DEPARTMENT_ID = 60; 
   
-- SALEE 부서의 최대, 최저월급, 월급 평균
  SELECT DEPARTMENT_ID FROM DEPARTMENTS
   WHERE  DEPARTMENT_NAME = 'Sales';
  
  SELECT  MAX(SALARY), MIN(SALARY), SUM(SALARY), 
          ROUND(AVG(SALARY), 3), COUNT(SALARY)
   FROM   EMPLOYEES
   WHERE  DEPARTMENT_ID = 80;
   
  SELECT  FIRST_NAME, lAST_NAME
   FROM   EMPLOYEES
   
  --전화번호의 지역번호이 590으로 시작되는 사람의 이름, 부서번호-
  SELECT     FIRST_NAME || ' ' || LAST_NAME AS "직원 이름", 
             DEPARTMENT_ID 부서번호, 
             PHONE_NUMBER
   FROM      EMPLOYEES  
   WHERE     PHONE_NUMBER LIKE  '590%';
   
  --전화번호가 4567로 끝나는 직원 이름, 부서번호,전화번호
  SELECT   FIRST_NAME || ' '  || LAST_NAME "직원 이름", 
           DEPARTMENT_ID 부서번호,
           PHONE_NUMBER 전화번호           
   FROM    EMPLOYEES
   WHERE   PHONE_NUMBER LIKE '%4567';
     
  --전화번호가 23이 포함된 직원이름, 부서번호, 전화 번호
  SELECT   FIRST_NAME || ' '  || LAST_NAME "직원 이름", 
           DEPARTMENT_ID 부서번호,
           PHONE_NUMBER 전화번호           
   FROM    EMPLOYEES
   WHERE   PHONE_NUMBER LIKE '%23%';
  
  --전화번호가 6번째가 2 와 7번째 자리가 3인 직원이름, 부서번호, 전화 번호
  SELECT   FIRST_NAME || ' '  || LAST_NAME "직원 이름", 
           DEPARTMENT_ID 부서번호,
           PHONE_NUMBER 전화번호           
   FROM    EMPLOYEES
   WHERE   PHONE_NUMBER LIKE '_____23_____';
    
  --03/06/17 - 03년 06월 17일 입사일인직원 출력
  SELECT   FIRST_NAME || ' ' || LAST_NAME 직원명, HIRE_DATE 입사일
   FROM    EMPLOYEES
   WHERE   HIRE_DATE = '03/06/17'; -- 03년06월17일
   
  --입사일 순으로 출력
 SELECT  * 
  FROM   EMPLOYEES
  ORDER BY HIRE_DATE ASC;
  
  --입사일 역순으로 출력 
  SELECT  * 
  FROM   EMPLOYEES
  ORDER BY HIRE_DATE DESC;
  
  -- 최소입사일 최대이사일
  SELECT  MIN(HIRE_DATE), MAX(HIRE_DATE)
   FROM   EMPLOYEES
   
   -- 가장늑제입사한 하마의 사업, 이름
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
 
  --08년 입사자 출력
 SELECT   EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
  FROM    EMPLOYEES
  --WHERE   HIRE_DATE LIKE '08%'
  -- WHERE   '08/01/01' <= HIRE_DATE AND HIRE_DATE < '09/01/01'
  WHERE   HIRE_DATE BETWEEN '08/01/01' AND '08/12/31 00:00:00.000'; 
  
  SELECT  * FROM DEPARTMENTS
  
  
  --08년 2월입사자 출력
  SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE, DEPARTMENT_ID
   FROM   EMPLOYEES
   WHERE  HIRE_DATE BETWEEN '08/02/01' AND '08/02/29'
  
  --08년 2월입사한 IT부서 직원 출력
  SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
   FROM   EMPLOYEES
   WHERE  HIRE_DATE BETWEEN '08/02/01' AND '08/02/29'
    AND   DEPARTMENT_ID = ( 
       SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE lower(DEPARTMENT_NAME) = 'it'   
    );
   
   --08년 2월입사한 Shipping(50)부서 직원 출력 - 물류
  SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
   FROM   EMPLOYEES
   WHERE  HIRE_DATE BETWEEN '08/02/01' AND '08/02/29'
    AND   DEPARTMENT_ID = ( 
       SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME = 'Shipping'   
    );
   -------------------------------------------------------------------------
   -- 문자함수
   -- 대문자, 소문자, 첫글자만 대문자
  SELECT  'Oracle Mania'
          , UPPER('Oracle Mania')
          , LOWER('Oracle mania')
          , INITCAP('Oracle mania')
          , CHR(65), ASCII('a')
   FROM   DUAL;    
   
  -- 문자길이 : length 는 글자수 : 9자
  --           lengthb : byte 단위 utf-8 이므로 한글1자는 3바이트 : 15 바이트
  SELECT '오라클 Mania', LENGTH('오라클 Mania'), LENGTHB('오라클 Mania')
   FROM   DUAL;
   
 -- CONCAT : 문자열 결합
 SELECT 'Oracle', 'mania', concat('Oracle', 'mania'), 'Oracle' || 'mania'   
  FROM  DUAL; 
   
 -- SUBSTR : SUBSTR('문자열', 시작위치(1~), 글자수) : 문자열 추출
 SELECT  SUBSTR('851225-1110211', 1, 6),
         SUBSTR('851225-1110211', 8, 1)         
  FROM   DUAL;
 --             1    45     
 SELECT SUBSTR('오라클 Mania', 4, 3) ,  -- ' Ma'
        SUBSTRB('오라클 Mania', 4, 3)   -- '라' 
  from  dual;      
 
 -- INSTR : 문자열안에서 문자찾기
 ---      못찾으면 0
 --   
SELECT  INSTR('CORPORATE FLOOR', 'OR')
        ,INSTR('CORPORATE FLOOR', 'OR', 2+1)
        ,INSTR('CORPORATE FLOOR', 'OR', 5+1)
        ,INSTR('CORPORATE FLOOR', 'or', 5+1)
        ,INSTR(lower('CORPORATE FLOOR'), 'or', 5+1)
 FROM   DUAL;
 
 -- 직원중JOB 이 CLERK 을 검색하세요
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
  
  -- TRIM : 앞위의 (공백) 문자를 제거한다
 select 'ASKLDFJSADLOJFSALKFJASKLOracle Maniaㅒ1234----',
        TRIM('    ABCDE FKSDJHFKASDJ     '),
        trim('O' from 'ASKLDFJSADLOJFSALKFJASKLOracle ManiaO1234----'),
        trim('O' from 'OOOOJFSALKFJASKLOracle ManiaOOOO')
  from dual;      

select 'Oracle Mania', '     Oracle Mania     ',
        trim('     Oracle Mania     ')
  from dual;      
  
  ---------------------------------------------------
  -- 숫자함수
  SELECT ABS(-12.3), SIGN(-5) 
   FROM  DUAL;
  
  -- 반올림
  SELECT   98.7654,
           ROUND(98.7654, 2),
           ROUND(98.7654, 0),
           ROUND(20098.7654, -2),
           ROUND(20034.7654, -2),
           ROUND(987654, -2)
   FROM DUAL;        
  
  -- 원단위 절사
  SELECT   98.7654,
           TRUNC(98.7654, 2),
           TRUNC(98.7654, 0),
           TRUNC(20098.7654, -2), -- 100원단위 절사
           TRUNC(20034.7654, -2),
           TRUNC(987654, -2)
   FROM DUAL;        
   
   -- 나머지
   SELECT MOD(10, 3) FROM DUAL; -- 10%3 -> 1
   
   -- 오라클 함수확인 - 숙제
   -- 차이점 비교 
   SELECT MOD(10.7, 2.3) FROM DUAL;
   SELECT REMAINDER(10.7, 2.3) FROM DUAL;
  
   -- 모든 삼각함수는 RADIAN 값으로 게산해야한다
   -- 30도 * 원주률/ 180 => RADIAN
   -- 30EH * 0.01745
   SELECT  ROUND( SIN(30*0.01745), 2), 
           ROUND( COS(30*0.01745), 2) , 
           ROUND( TAN(30*0.01745), 2) FROM DUAL;
   
   SELECT  SQRT(16) FROM DUAL;
   SELECT  4*4 FROM DUAL;
   SELECT  POWER(4, 2) FROM DUAL;
   SELECT  POWER(4, 0.5) FROM DUAL;
   SELECT  POWER(4, 3/2) FROM DUAL;
   
   -- CEIL() -- 올림
   -- FLOOR() --값버림
   SELECT CEIL(3.8), FLOOR(3.8) FROM DUAL;
   SELECT CEIL(3.1), FLOOR(3.9) FROM DUAL;
   SELECT CEIL(-3.8), FLOOR(-3.8) FROM DUAL;
   
   ==========================================================
   날짜
   
   -- 오늘날짜
   SELECT SYSDATE FROM DUAL;  -- 20/05/11
   
   ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
   SELECT SYSDATE FROM DUAL; 
   
   -- 임시적으로 날짜의 모양을 변경한다
   ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
      
   -- 오늘날짜
   SELECT SYSDATE FROM DUAL; 
   -- 어제 날짜
   SELECT  SYSDATE - 1  FROM DUAL
   -- 1주일 후의 날짜
   SELECT  SYSDATE  + 7  FROM DUAL
   -- 날짜 + 숫자 : SYSDATE + 3 : 오늘부터 3일 후
   -- 날짜 - 숫자 : SYSDATE - 3 : 오늘부터 3일 전
   
 -- 직원들의 근무일수를 출력
 -- 날짜 - 날짜 : 두 날짜사이의 간격( ~일)
 -- ROUND(,0) : 오전/오후시간 을 기준
 SELECT  EMPLOYEE_ID, 
         HIRE_DATE 입사일, 
         SYSDATE - HIRE_DATE 근무일수,
         ROUND(SYSDATE - HIRE_DATE, 0) 
  FROM   EMPLOYEES
  
  SELECT  ROUND( SYSDATE - TO_DATE('2020-01-29'), 2) FROM DUAL;
  
  --근무일수
  SELECT  EMPLOYEE_ID, HIRE_DATE, 
          ROUND((SYSDATE - HIRE_DATE)/365.2422, 2) 근무일수 
   FROM   EMPLOYEES

-- EMPLOYEES 에 두명의 직원을 추가
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
     '지은',   '이' ,      'JYLEE',         '010.1234.4567',
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
     '대호',   '이' ,      'TigerLEE',         '010.4567.4567',
     SYSDATE,   'AD_ASST',    1000,      NULL,     107,
     10
 );

COMMIT
SELECT * FROM EMPLOYEES;

-- 직원수
SELECT  COUNT(*), COUNT(EMPLOYEE_ID), COUNT(DEPARTMENT_ID), COUNT(SALARY)
 FROM   EMPLOYEES;

-- 직원 월급합
SELECT SUM(SALARY) FROM EMPLOYEES;  -- 692416
-- 직원 월급평균
SELECT ROUND(AVG(SALARY),3) FROM EMPLOYEES; -- 6411.259

SELECT ROUND( SUM(SALARY) / COUNT(*) , 3) FROM EMPLOYEES; -- 6352.44

-- 오늘입사한 사람한 사람을 출력
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
   
 -- 입사일이 '2020-05-12' 인 사람
 SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
  FROM   EMPLOYEES
  WHERE   HIRE_DATE LIKE '2020-05-12%'
 
  SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
  FROM   EMPLOYEES
  WHERE  '2020-05-12' <=  HIRE_DATE AND HIRE_DATE < '2020-05-13';
 
  --------------------------------------------
  날짜 함수들
  
  -- 2002-02 위 마지막 날짜
  SELECT LAST_DAY('2020-11-05') FROM DUAL;
  
  SELECT HIRE_DATE, LAST_DAY(HIRE_DATE) FROM EMPLOYEES;
  
  SELECT MONTHS_BETWEEN('2020-12-25', SYSDATE  ) FROM DUAL;
  
  SELECT SYSDATE + 3  FORM DUAL;  -- 3일후
  SELECT ADD_MONTHS(SYSDATE, 3) FROM DUAL; - 현재로 부터 3달 후 날짜
  
  SELECT NEXT_DAY(SYSDATE, '월') FROM DUAL; -- 돌아오는 월요일날짜  
  SELECT NEXT_DAY(SYSDATE, '토') FROM DUAL; -- 다음 토요일날짜
  SELECT NEXT_DAY(SYSDATE, 2)    FROM DUAL; -- 다음 월(2)요일날짜 (1:일요일)
  
  SELECT ROUND(SYSDATE), TRUNC(SYSDATE) FROM DUAL; -- 오전 12시기준
  
  -- 입사한지 10년이 지난 사람출력
    
  -- 입사한지 가장오래된 사람
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

-- 잘못된 표현    
 SELECT EMPLOYEE_ID, MIN(HIRE_DATE)
 FROM   EMPLOYEES 
  
-- 부서별 직원수
SELECT DISTINCT DEPARTMENT_ID 
 FROM   EMPLOYEES
 
SELECT     DEPARTMENT_ID, COUNT(EMPLOYEE_ID)
 FROM      EMPLOYEES
 GROUP BY  DEPARTMENT_ID
 ORDER BY  DEPARTMENT_ID

-- 부서별, JOB_ID 별 직원수, 월급합
SELECT     DEPARTMENT_ID, JOB_ID, COUNT(*), SUM(SALARY)
 FROM      EMPLOYEES
 GROUP BY  DEPARTMENT_ID, JOB_ID
 
--  위 문장에 조건 추가
----- 부서번호가 10, 60, 110

 SELECT    DEPARTMENT_ID, JOB_ID, COUNT(*), SUM(SALARY)
 FROM      EMPLOYEES
 WHERE     DEPARTMENT_ID IN (10, 60, 110)
 GROUP BY  DEPARTMENT_ID, JOB_ID
 -- HAVING
 
 --- 위 조건에 월급합이 20000 이상인 자료
  SELECT    DEPARTMENT_ID, JOB_ID, COUNT(*), SUM(SALARY)
  FROM      EMPLOYEES
 -- WHERE     SUM(SALARY) >= 20000 -- ERROR WHERE 딪계함수 사용불가
  GROUP BY  DEPARTMENT_ID, JOB_ID
   HAVING   SUM(SALARY) >= 20000
 
 --   UNION, UNION ALL
 ---- 여러테이블을 하나로 합친다
 SELECT * FROM EMPLOYEES 
   WHERE DEPARTMENT_ID = 10;
 
 SELECT * FROM EMPLOYEES 
   WHERE DEPARTMENT_ID = 60;
      
 SELECT * FROM EMPLOYEES 
   WHERE DEPARTMENT_ID IN ( 10, 60);


-- UNION 은 두 테이블을 물리적으로 결합하는것 
-- 조건 : 칸의 갯수와 데이터 타입은 같앙영한다
SELECT * FROM EMPLOYEES 
   WHERE DEPARTMENT_ID = 10
UNION  
 SELECT * FROM EMPLOYEES 
   WHERE DEPARTMENT_ID = 60;
   
 SELECT EMPLOYEE_ID, FIRST_NAME        FROM EMPLOYEES  
 UNION
 SELECT DEPARTMENT_ID, DEPARTMENT_NAME FROM  DEPARTMENTS
   
 -- 합집합 
  UNION     : ROW 중복제거
  UNION ALL : ROW 중복포함
 
 -- 교집합
  INTERSECT 
  
 -- 차집합
   MINUS
  -
  
--------------------------------------------------
  -- 부서별 최대 월급
  SELECT     DEPARTMENT_ID,  TO_CHAR( MAX(SALARY) , 'L99,999.99')
   FROM      EMPLOYEES 
   GROUP BY  DEPARTMENT_ID
   ORDER BY  DEPARTMENT_ID
  
  -- 입사일이 오늘인사람출력
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
  
  -- 2020년 5월 11일 화요일 15시 32분 10초  
  -- 2020年 5月 11日 火曜日 15時 32分 10炒
  
  SELECT  FIRST_NAME
         ,HIRE_DATE
         , TO_CHAR ( HIRE_DATE, 'YYYY' ) || '年 ' || 
           TO_CHAR ( HIRE_DATE, 'MM'   ) || '月 ' ||
           TO_CHAR ( HIRE_DATE, 'DD'   ) || '日 ' ||             
           CASE 
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '일'  THEN '日'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '월'  THEN '月'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '화'  THEN '火'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '수'  THEN '水'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '목'  THEN '木'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '금'  THEN '金'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '토'  THEN '土'           
           END
           || '曜日 ' ||
           CASE
             WHEN  TO_CHAR( HIRE_DATE, 'HH24' ) < 12  THEN '午前 '
             ELSE  '午後 '
           END   ||
           TO_CHAR ( HIRE_DATE, 'HH24' ) || '時 ' ||
           TO_CHAR ( HIRE_DATE, 'MI'   ) || '分 ' || 
           TO_CHAR ( HIRE_DATE, 'SS'   ) || '炒'  AS "입사일"
   FROM   EMPLOYEES
   
 SELECT  FIRST_NAME
         ,HIRE_DATE
         , TO_CHAR ( HIRE_DATE, 'YYYY' ) || '年 ' || 
           TO_CHAR ( HIRE_DATE, 'MM'   ) || '月 ' ||
           TO_CHAR ( HIRE_DATE, 'DD'   ) || '日 ' ||             
           CASE TO_CHAR ( HIRE_DATE, 'DY' )              
              WHEN  '일'  THEN '日'
              WHEN  '월'  THEN '月'
              WHEN  '화'  THEN '火'
              WHEN  '수'  THEN '水'
              WHEN  '목'  THEN '木'
              WHEN  '금'  THEN '金'
              WHEN  '토'  THEN '土'           
           END
           || '曜日 ' ||
           CASE
             WHEN  TO_CHAR( HIRE_DATE, 'HH24' ) < 12  THEN '午前 '
             ELSE  '午後 '
           END   ||
           TO_CHAR ( HIRE_DATE, 'HH24' ) || '時 ' ||
           TO_CHAR ( HIRE_DATE, 'MI'   ) || '分 ' || 
           TO_CHAR ( HIRE_DATE, 'SS'   ) || '炒'  AS "입사일"
   FROM   EMPLOYEES
   
    
  SELECT   TO_CHAR(12345,    '999999'), 
           TO_CHAR(12345,    '0999999'), 
           TO_CHAR(1243.4567, '099,999.999'), 
           TO_CHAR(1234567, 'L99,999') ,  -- 자리가 모자라면 #으로 출력된다
           TO_CHAR(1234567, 'L9,999,999') ,
           TO_CHAR(1234567, '$9,999,999')
   FROM DUAL;

  SELECT 1 + '3' FROM DUAL;
  SELECT 1 + '3.7' FROM DUAL;
  SELECT 1 + 'A' FROM DUAL;
 --       12345678901234    
  SELECT '750913-1113042',
         CASE
           WHEN SUBSTR('750913-1113042', 8, 1) = '1' THEN '남자'
           WHEN SUBSTR('750913-1113042', 8, 1) = '2' THEN '여자'
         END "성별",
         DECODE( SUBSTR('750913-3113153', 8, 1),'1', '남자', '여자') "성별",
         DECODE( MOD(SUBSTR('750913-4113153', 8, 1), 2),1, '남자', '여자') "성별"
         
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
               '그외'
            )  부서명
    FROM   EMPLOYEES;       
  

  

