--�μ��� �����̸�
SELECT employee_id, first_name
FROM employees;
--employees �� ���̺��� �μ���ȣ
SELECT department_id
FROM employees
ORDER BY DEPARTMENT_ID ASC;

--�ߺ��� �����ϰ� ��� (distinct) -null ���� 12��
SELECT DISTINCT department_id
FROM employees
ORDER BY  DEPARTMENT_ID ASC;

--�μ� ���̺��� �μ���ȣ�� ��� -27��
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

--�Լ� (FUNCTION)
--�����Լ� (BUILT-IN FUNCTION)
--�ϰ��� ���� �����ϴ� �����α׷�
--�����Լ� : SUM(), MAX(), MIN(), AVG()
----Ư�� : NULL �� ��꿡 �����Ѵ�.
----������ : �ٸ� ROW �� ���� COLUMN�� ������� �Ѵ�.

------��ü������
SELECT SALARY
FROM EMPLOYEES;

SELECT SUM(SALARY) FROM EMPLOYEES;
------��ü�������
SELECT AVG(SALARY) FROM EMPLOYEES;

SELECT 10/3 FROM DUAL;
SELECT SYSDATE FROM DUAL; --��°��  20/05/11

SELECT ROUND(10/3,2) FROM DUAL;

--PRIMARY KEY : NOT NULL(�ʼ��Է�) + UNIQUE(�ߺ��Ұ�)


--������ : COUNT()
SELECT COUNT(*) FROM EMPLOYEES;
SELECT COUNT(EMPLOYEE_ID) FROM EMPLOYEES;
SELECT COUNT(DEPARTMENT_ID) FROM EMPLOYEES;

--60�� �μ��� ��������, �ִ����
SELECT  MIN(SALARY),MAX(SALARY)
FROM    EMPLOYEES
WHERE   DEPARTMENT_ID = 90;

--SALE �μ��� ���� �ְ�

SELECT DEPARTMENT_ID FROM DEPARTMENTS
WHERE DEPARTMENT_NAME = 'Sales';

SELECT MAX(SALARY), MIN(SALARY), SUM(SALARY), ROUND(AVG(SALARY),3), COUNT(SALARY)
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 80;

SELECT FIRST_NAME, LAST_NAME
FROM EMPLOYEES;

------------------------------------------------------------------------
--��ȭ��ȣ�� �޴�����ȣ��ȣ 590���� ���۵Ǵ� ����� �̸�, �μ���ȣ
SELECT FIRST_NAME, LAST_NAME , DEPARTMENT_ID, PHONE_NUMBER
FROM EMPLOYEES 
WHERE PHONE_NUMBER LIKE '590%';

--��ȭ��ȣ�� 4567�� ������ ���� �̸�, �μ� ,��ȭ��ȣ
SELECT FIRST_NAME, LAST_NAME , DEPARTMENT_ID, PHONE_NUMBER
FROM EMPLOYEES
WHERE PHONE_NUMBER LIKE '%4567';

--��ȭ��ȣ�� 23�� ���Ե� ���� �̸�, �μ���ȣ , ��ȭ��ȣ
SELECT FIRST_NAME, LAST_NAME , DEPARTMENT_ID, PHONE_NUMBER
FROM EMPLOYEES
WHERE PHONE_NUMBER LIKE '%23%';

--��ȭ��ȣ�� 6��°�� 7��° �ڸ��� 23�� �����̸�, �μ���ȣ, ��ȭ��ȣ
SELECT FIRST_NAME, LAST_NAME , DEPARTMENT_ID, PHONE_NUMBER
FROM EMPLOYEES
WHERE PHONE_NUMBER LIKE '_____23%';

--03/06/17  - �Ի��� �� ���� ���
SELECT FIRST_NAME, LAST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE = '03/06/17';

--�Ի��� ������ ���
SELECT FIRST_NAME, LAST_NAME, HIRE_DATE
FROM EMPLOYEES
ORDER BY HIRE_DATE;

--�Ի��� �������� ���
SELECT FIRST_NAME, LAST_NAME, HIRE_DATE
FROM EMPLOYEES
ORDER BY HIRE_DATE DESC;

--�ּ��Ի��� �ִ��Ի���
SELECT MIN(HIRE_DATE),MAX(HIRE_DATE)
FROM EMPLOYEES;

--���� �ʰ� �Ի��� �Ի��� 

SELECT first_name||' '||last_name, HIRE_DATE
FROM EMPLOYEES;


SELECT first_name||' '||last_name, HIRE_DATE
FROM    EMPLOYEES
WHERE HIRE_DATE = (
    SELECT MIN(HIRE_DATE)
    FROM EMPLOYEES
);

--08�� �Ի��� ���
SELECT FIRST_NAME, LAST_NAME, HIRE_DATE, DEPARTMENT_ID
FROM EMPLOYEES
    --WHERE HIRE_DATE LIKE '08/%' ORDER BY HIRE_DATE ASC;
    --WHERE '08/01/01' <= HIRE_DATE and HIRE_DATE <='08/12/31'
WHERE HIRE_DATE BETWEEN '08/01/01' and '08/12/31';

--08�� 2�� �Ի��� IT �μ� ���� ���
SELECT FIRST_NAME, LAST_NAME, HIRE_DATE
FROM EMPLOYEES
-- WHERE HIRE_DATE LIKE '08/01%'
WHERE HIRE_DATE BETWEEN '08/02/01' and '08/02/29'
AND department_id = (
    SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME = 'IT'
);
--08�� 2�� �Ի��� Shipping(50)�μ� ���� ��� - ����
SELECT FIRST_NAME, LAST_NAME, HIRE_DATE
FROM EMPLOYEES
WHERE HIRE_DATE LIKE '08/02%'
AND department_id = (
 SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME = 'Shipping'
);

------------------------------------------------------------------------
--�����Լ�
SELECT 'Oracle Mania'
        , UPPER('Oracle Mania')
        , Lower('Oracle Mania')
        , INITCAP('oracle mania')
FROM DUAL;
--���ڱ��� length : ���� 1byte
--          lengthb : �ѱ� 3byte, ���� 1btye
SELECT '����Ŭ Mania', LENGTH('����Ŭ Mania'), LENGTHB('����Ŭ Mania')
FROM DUAL;

SELECT 'Oracle', 'mania', concat('Oracle','mania'), 'Oracle' || 'mania' FROM DUAL;

--SUBSTR : SUBSTR('���ڿ�',������ġ, ����) : ���ڿ� ����

SELECT SUBSTR('851225-1110211',1,6),
        SUBSTR('851225-1110211',8,1)
        FROM DUAL;

SELECT SUBSTR('����Ŭ Mania',4,3),
        SUBSTRB('����Ŭ Mania',4,3)
        FROM DUAL;
--INSTR : ���ڿ� �ȿ��� ���� ã��
    --��ã���� 0;
SELECT INSTR ('CORPORATE FLOOR','OR'),
        INSTR ('CORPORATE FLOOR','OR',2+1),
        INSTR ('CORPORATE FLOOR','OR',5+1)
FROM DUAL;

--������ JOB �� CLERK �� �˻��ϼ���
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

SELECT salary as "����������մϴ�.", LPAD( SALARY,10,'*')
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
--���� �Լ�
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
--������
SELECT MOD(10,3) FROM DUAL;
SELECT MOD(10.7,2.3) FROM DUAL;
--��� �ﰢ�Լ��� RADIAN ������ ����ؾ��Ѵ�.
--30�� * ������/180 => RADIAN
--30�� * 0.01745
SELECT SIN(30*0.01745) FROM DUAL;

SELECT SQRT(16) FROM DUAL;
SELECT 4*4 FROM DUAL;
SELECT POWER(4,2) FROM DUAL;
SELECT POWER(4,0.5) FROM DUAL;
SELECT POWER(4,3/2) FROM DUAL;
SELECT CEIL(3.8), FLOOR(3.8) FROM DUAL;
SELECT CEIL(-3.8), FLOOR(-3.8) FROM DUAL;
------------------------------------------------------------------------
--��¥
--���ó�¥
SELECT SYSDATE FROM DUAL; --20/05/11

ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
SELECT SYSDATE FROM DUAL; --2020-05-11

--��¥�� ����� �ӽ������� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
SELECT SYSDATE FROM DUAL; -- 2020-05-11 17:05:32

--���ó�¥

--������¥
    SELECT SYSDATE -1 FROM DUAL;
--������ ���� ��¥
    SELECT SYSDATE +7 FROM DUAL;
    --��¥ + ���� : ���ڴ� �ϼ��� ����
-- �������� �ٹ��ϼ��� ���
--  ��¥ -��¥ : �� ��¥ ������ ����(��)
-- ROUND(,0)  : ����/���� �ð��� �������� 
    SELECT EMPLOYEE_ID, HIRE_DATE �ϻ���, SYSDATE-HIRE_DATE �ٹ��ϼ�,
        ROUND(SYSDATE-HIRE_DATE ,0)
    FROM EMPLOYEES;
    

--�ٹ�����
    SELECT
    FROM EMPLOYEES;
--�ٹ����� 20�� �̻�
    
    
------------------------------------------------------------------------

-- ���� ���Ϻ� like     'a%' :  startswith
--              like    '%a' :  endswith
--              like    '%a%':  contains
--����
-- 20 <= age and age >=60
-- between age 20 and 60

-- department_id =10
-- OR department_id =60
-- OR department_id =90

-- DEPARTMENT_ID IN(10,60,90)

-- ����, ��¥�� ''�ȿ� ǥ��



-- ALL >
-- ANY >