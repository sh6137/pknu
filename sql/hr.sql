--부서별 직원이름
SELECT employee_id, first_name
FROM employees;
--employees 의 테이블의 부서번호
SELECT department_id
FROM employees
ORDER BY DEPARTMENT_ID ASC;

--중복을 제거하고 출력 (distinct) -null 포함 12개
SELECT DISTINCT department_id
FROM employees
ORDER BY  DEPARTMENT_ID ASC;

--부서 테이블의 부서번호를 출력 -27개
SELECT DEPARTMENT_ID
FROM    DEPARTMENTS
ORDER BY  DEPARTMENT_ID;

SELECT DEPARTMENT_ID, FIRST_NAME
FROM EMPLOYEES
ORDER by DEPARTMENT_ID ASC;

SELECT first_name
FROM employees
where DEPARTMENT_ID = 10;

SELECT EMPLOYEE_ID,FIRST_NAME, HIRE_DATE 
FROM EMPLOYEES
WHERE HIRE_DATE =  '07/02/07';


--ANY ALL SOME

SELECT EMPLOYEE_ID FIRST_NAME, SALARY
FROM    EMPLOYEES
WHERE SALARY =2000
OR    SALARY =3000
OR    SALARY =4000;

SELECT EMPLOYEE_ID FIRST_NAME, SALARY
FROM    EMPLOYEES
WHERE SALARY IN(2000 ,3000 ,4000)
ORDER BY EMPLOYEE_ID;

SELECT SALARY
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 187
OR EMPLOYEE_ID = 192
OR EMPLOYEE_ID = 197;

SELECT EMPLOYEE_ID FIRST_NAME, SALARY
FROM    EMPLOYEES
WHERE SALARY = ANY(2000 ,3000 ,4000)
ORDER BY EMPLOYEE_ID;

SELECT EMPLOYEE_ID FIRST_NAME, SALARY
FROM    EMPLOYEES
WHERE SALARY = ALL(2000 ,3000 ,4000)
ORDER BY EMPLOYEE_ID;

SELECT EMPLOYEE_ID FIRST_NAME, SALARY
FROM    EMPLOYEES
WHERE SALARY = SOME(2000 ,3000 ,4000)
ORDER BY EMPLOYEE_ID;

--함수 (FUNCTION)
--내장함수 (BUILT-IN FUNCTION)
--하개의 값을 리턴하는 부프로그램
--집계함수 : SUM(), MAX(), MIN(), AVG()
----특성 : NULL 은 계산에 제외한다.
----계산단위 : 다른 ROW 의 같은 COLUMN을 대상으로 한다.

------전체월급함
SELECT SALARY
FROM EMPLOYEES;

SELECT SUM(SALARY) FROM EMPLOYEES;
------전체월급평균
SELECT AVG(SALARY) FROM EMPLOYEES;

SELECT 10/3 FROM DUAL;
SELECT SYSDATE FROM DUAL; --출력결과  20/05/11

SELECT ROUND(10/3,2) FROM DUAL;

--PRIMARY KEY : NOT NULL(필수입력) + UNIQUE(중복불가)


--직원수 : COUNT()
SELECT COUNT(*) FROM EMPLOYEES;
SELECT COUNT(EMPLOYEE_ID) FROM EMPLOYEES;
SELECT COUNT(DEPARTMENT_ID) FROM EMPLOYEES;

--60번 부서의 최저월급, 최대월급
SELECT  MIN(SALARY),MAX(SALARY)
FROM    EMPLOYEES
WHERE   DEPARTMENT_ID = 90;

--SALE 부서의 최저 최고

SELECT DEPARTMENT_ID FROM DEPARTMENTS
WHERE DEPARTMENT_NAME = 'Sales';

SELECT MAX(SALARY), MIN(SALARY), SUM(SALARY), ROUND(AVG(SALARY),3), COUNT(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 80;

SELECT FIRST_NAME, LAST_NAME
FROM EMPLOYEES;

------------------------------------------------------------------------
--전화번호의 휴대폰번호번호 590으로 시작되는 사람의 이름, 부서번호
SELECT FIRST_NAME, LAST_NAME , DEPARTMENT_ID, PHONE_NUMBER
FROM EMPLOYEES 
WHERE PHONE_NUMBER LIKE '590%';

--전화번호가 4567로 끝나는 직원 이름, 부서 ,전화번호
SELECT FIRST_NAME, LAST_NAME , DEPARTMENT_ID, PHONE_NUMBER
FROM EMPLOYEES
WHERE PHONE_NUMBER LIKE '%4567';

--전화번호가 23이 포함된 직원 이름, 부서번호 , 전화번호
SELECT FIRST_NAME, LAST_NAME , DEPARTMENT_ID, PHONE_NUMBER
FROM EMPLOYEES
WHERE PHONE_NUMBER LIKE '%23%';

--전화번호가 6번째와 7번째 자리가 23인 직원이름, 부서번호, 전화번호
SELECT FIRST_NAME, LAST_NAME , DEPARTMENT_ID, PHONE_NUMBER
FROM EMPLOYEES
WHERE PHONE_NUMBER LIKE '_____23%';

--03/06/17  - 입사일 인 직원 출력
SELECT FIRST_NAME, LAST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE = '03/06/17';

--입사일 순으로 출력
SELECT FIRST_NAME, LAST_NAME, HIRE_DATE
FROM EMPLOYEES
ORDER BY HIRE_DATE;

--입사일 역순으로 출력
SELECT FIRST_NAME, LAST_NAME, HIRE_DATE
FROM EMPLOYEES
ORDER BY HIRE_DATE DESC;

--최소입사일 최대입사일
SELECT MIN(HIRE_DATE),MAX(HIRE_DATE)
FROM EMPLOYEES;

--가장 늦게 입사한 입사입 

SELECT first_name||' '||last_name, HIRE_DATE
FROM EMPLOYEES;


SELECT first_name||' '||last_name, HIRE_DATE
FROM    EMPLOYEES
WHERE HIRE_DATE = (
    SELECT MIN(HIRE_DATE)
    FROM EMPLOYEES
);

--08년 입사자 출력
SELECT FIRST_NAME, LAST_NAME, HIRE_DATE, DEPARTMENT_ID
FROM EMPLOYEES
    --WHERE HIRE_DATE LIKE '08/%' ORDER BY HIRE_DATE ASC;
    --WHERE '08/01/01' <= HIRE_DATE and HIRE_DATE <='08/12/31'
WHERE HIRE_DATE BETWEEN '08/01/01' and '08/12/31';

--08년 2월 입사한 IT 부서 직원 출력
SELECT FIRST_NAME, LAST_NAME, HIRE_DATE
FROM EMPLOYEES
-- WHERE HIRE_DATE LIKE '08/01%'
WHERE HIRE_DATE BETWEEN '08/02/01' and '08/02/29'
AND department_id = (
    SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME = 'IT'
);
--08년 2월 입사한 Shipping(50)부서 직원 출력 - 물류
SELECT FIRST_NAME, LAST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE LIKE '08/02%'
AND department_id = (
 SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME = 'Shipping'
);

------------------------------------------------------------------------
--문자함수
SELECT 'Oracle Mania'
        , UPPER('Oracle Mania')
        , Lower('Oracle Mania')
        , INITCAP('oracle mania')
FROM DUAL;
--문자길이 length : 문자 1byte
--          lengthb : 한글 3byte, 영어 1btye
SELECT '오라클 Mania', LENGTH('오라클 Mania'), LENGTHB('오라클 Mania')
FROM DUAL;

SELECT 'Oracle', 'mania', concat('Oracle','mania'), 'Oracle' || 'mania' FROM DUAL;

--SUBSTR : SUBSTR('문자열',시작위치, 갯수) : 문자열 추출

SELECT SUBSTR('851225-1110211',1,6),
        SUBSTR('851225-1110211',8,1)
        FROM DUAL;

SELECT SUBSTR('오라클 Mania',4,3),
        SUBSTRB('오라클 Mania',4,3)
        FROM DUAL;
--INSTR : 문자열 안에서 문자 찾기
    --못찾으면 0;
SELECT INSTR ('CORPORATE FLOOR','OR'),
        INSTR ('CORPORATE FLOOR','OR',2+1),
        INSTR ('CORPORATE FLOOR','OR',5+1)
FROM DUAL;

--직원중 JOB 이 CLERK 을 검색하세요
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE JOB_ID LIKE '%CLERK';
--LIKE
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE JOB_ID LIKE '%CLERK';
--INSTR
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE INSTR(JOB_ID,'CLERK') >0;
--SUBSTR
SELECT FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE SUBSTR(JOB_ID,4,5)='CLERK';
--LPAD
SELECT LPAD( SALARY,10,'*')
FROM EMPLOYEES;

SELECT salary as "월급을출력합니다.", LPAD( SALARY,10,'*')
FROM EMPLOYEES;

SELECT RPAD( SALARY,10,'*')
FROM EMPLOYEES;

--TRIM
SELECT 'Oracle Mania',
    trim('O' from 'sadfasdfasdOracle Mania')
    from DUAL;
    
SELECT 'Oracle Mania',
    trim('      Oracle Mania       ')
    from DUAL;
    
SELECT JOB_ID, TRIM('_'FROM JOB_ID)
FROM employees;

------------------------------------------------------------------------
--숫자 함수
    SELECT 98.7654,
            ROUND(98.7654,2),
            ROUND(98.7654,0),
            ROUND(20098.7654,-1),
            ROUND(987654,-2)
            from DUAL;
    SELECT 98.7654,
            TRUNC(98.7654,2),
            TRUNC(98.7654,0),
            TRUNC(20098.7654,-1),
            TRUNC(987654,-2)
            from DUAL;
--나머지
SELECT MOD(10,3) FROM DUAL;
SELECT MOD(10.7,2.3) FROM DUAL;
--모든 삼각함수는 RADIAN 값으로 계산해야한다.
--30도 * 원주율/180 => RADIAN
--30도 * 0.01745
SELECT SIN(30*0.01745) FROM DUAL;

SELECT SQRT(16) FROM DUAL;
SELECT 4*4 FROM DUAL;
SELECT POWER(4,2) FROM DUAL;
SELECT POWER(4,0.5) FROM DUAL;
SELECT POWER(4,3/2) FROM DUAL;
SELECT CEIL(3.8), FLOOR(3.8) FROM DUAL;
SELECT CEIL(-3.8), FLOOR(-3.8) FROM DUAL;
------------------------------------------------------------------------
--날짜
--오늘날짜
SELECT SYSDATE FROM DUAL; --20/05/11

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
SELECT SYSDATE FROM DUAL; --2020-05-11

--날짜의 모양을 임시적으로 변경
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
SELECT SYSDATE FROM DUAL; -- 2020-05-11 17:05:32

--오늘날짜

--어제날짜
    SELECT SYSDATE -1 FROM DUAL;
--일주일 후의 날짜
    SELECT SYSDATE +7 FROM DUAL;
    --날짜 + 숫자 : 숫자는 일수를 뜻함
-- 직원들의 근무일수를 출력
--  날짜 -날짜 : 두 날짜 사이의 간격(일)
-- ROUND(,0)  : 오전/오후 시간을 기준으로 
    SELECT EMPLOYEE_ID, HIRE_DATE 일사일, SYSDATE-HIRE_DATE 근무일수,
        ROUND(SYSDATE-HIRE_DATE ,0)
    FROM EMPLOYEES;
    

--근무연수
    SELECT
    FROM EMPLOYEES;
--근무연수 20년 이상
    
    
------------------------------------------------------------------------

-- 문자 패턴비교 like     'a%' :  startswith
--              like    '%a' :  endswith
--              like    '%a%':  contains
--범위
-- 20 <= age and age >=60
-- between age 20 and 60

-- department_id =10
-- OR department_id =60
-- OR department_id =90

-- DEPARTMENT_ID IN(10,60,90)

-- 문자, 날짜는 ''안에 표시



-- ALL >
-- ANY >