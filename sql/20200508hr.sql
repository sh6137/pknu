hr : human resource

SELECT * FROM TAB;

SELECT * FROM EMPLOYEES;
DESC EMPLOYEES;

��� ��� ������ȣ, �̸�, ��ȭ��ȣ ��ȸ
SELECT  EMPLOYEE_ID, fIRST_NAME, lAST_NAME, PHONE_NUMBER, SALARY
 FROM   EMPLOYEES;
 
 ��� ��� ������ȣ, �̸�, ��ȭ��ȣ ��ȸ, �� ���޼� ������������
 SELECT    EMPLOYEE_ID, FIRST_NAME,LAST_NAME, SALARY
  FROM     EMPLOYEES
  ORDER BY SALARY DESC;
  
  ��� ����� �̸������� ���, �� ���� 10000 �̻�
  SELECT      *
   FROM       EMPLOYEES
   WHERE      SALARY >= 10000
   ORDER BY   FIRST_NAME ASC
  
���ڿ� ���� ( || )
 Į�� AS ����  : Į���� ������ �ο� (AS ��������)
SELECT        EMPLOYEE_ID AS ���, FIRST_NAME || ' ' || LAST_NAME  �̸�
 FROM         EMPLOYEES  

60�� �μ� ������ �̸��� �̸���
SELECT   FIRST_NAME || ' ' || LAST_NAME �̸�, 
         LOWER(EMAIL || '@PKNU.AC.KR')  �̸���, 
         DEPARTMENT_ID �μ���ȣ
 FROM    EMPLOYEES
 WHERE   DEPARTMENT_ID = 60;
 
SELECT  EMPLOYEE_ID, FIRST_NAME , 'HELLO'
 FROM   EMPLOYEES 

���迬����   >, <, >=, <=, =, <>(!=) 
��������   NOT, AND , OR

--������ 10000 �� �μ���ȣ 60, 90 �μ��������
SELECT   EMPLOYEE_ID, 
         FIRST_NAME || ' ' || LAST_NAME ,
         SALARY, 
         DEPARTMENT_ID
 FROM    EMPLOYEES
 WHERE   SALARY        >= 100
  AND   ( DEPARTMENT_ID  =  60
   OR    DEPARTMENT_ID  =  90 )
  
--- �μ�, 60, 90, 100 �μ������� ���   
SELECT  *
 FROM   EMPLOYEES
 WHERE ( DEPARTMENT_ID  = 60
  OR      DEPARTMENT_ID  = 90
  OR      DEPARTMENT_ID  = 100) 
 
 SELECT  *
 FROM   EMPLOYEES
 WHERE  DEPARTMENT_ID  IN (60, 90, 100)
  
 -- ����(SALALRY * 12)�� 100000 �̻��� ������ �̸��� �μ�����
 SELECT      FIRST_NAME || ' ' || LAST_NAME  �̸�, 
             DEPARTMENT_ID �μ���ȣ, 
             (SALARY* 12 )����
  FROM       EMPLOYEES
  WHERE      (SALARY * 12) >= 100000 
  -- ORDER BY   ����  ASC
  -- ORDER BY SALARY * 12  ASC
  ORDER BY    3  ASC
 
 -- ������ 10000~20000 ������ �������
 SELECT      FIRST_NAME, LAST_NAME, SALARY 
  FROM       EMPLOYEES
 WHERE       10000 <= SALARY AND SALARY <= 20000
 ORDER BY    SALARY DESC; 
  
 SELECT    FIRST_NAME, LAST_NAME, SALARY
  FROM     EMPLOYEES
  WHERE    SALARY BETWEEN 10000 AND 20000;
  
 SELECT * FROM EMPLOYEES;  
 
 -- NULL �򱳴� IS , IS NOT
 -- �������� ���޴� ��� ���
 SELECT  EMPLOYEE_ID, SALARY, COMMISSION_PCT
  FROM   EMPLOYEES
-- WHERE  COMMISSION_PCT = NULL -- ¥������
  WHERE  COMMISSION_PCT IS NULL

 -- �������� �޴� ��� ���
 =-- ���ʽ� SALARY * 12 * COMMISSION_PCT
 SELECT  EMPLOYEE_ID, SALARY, COMMISSION_PCT,
         NVL(SALARY * 12 * COMMISSION_PCT, 0) AS BONUS
  FROM   EMPLOYEES
  WHERE  COMMISSION_PCT IS NOT NULL
 
 -- NVL(Į��, ��) : Į���� NULL �̸� ������ ��ü�Ѵ� : NULL VALUE
 -- NULL �� ��꿡 �����ص� NULL
 SELECT   FIRST_NAME, LAST_NAME, SALARY, SALARY*12 ����,
          SALARY*12 + (SALARY*12) * NVL( COMMISSION_PCT, 0 )    �����Ѿ�
  FROM    EMPLOYEEs
  
 -- 50�� �μ��� �����̸�
 SELECT   FIRST_NAME, LAST_NAME, DEPARTMENT_ID
  FROM    EMPLOYEES
  WHERE   DEPARTMENT_ID = 50
 -- WHERE   DEPARTMENT_ID = '50'  -- �۵������� ���߿� ����
 
 SELECT * FROM EMPLOYEES;
 SELECT * FROM DEPARTMENTS;
 
 --IT �μ��� ������ �̸�
 SELECT   DEPARTMENT_ID
  FROM    DEPARTMENTS
  WHERE   DEPARTMENT_NAME = 'IT'
 
 SELECT   DEPARTMENT_ID, FIRST_NAME, LAST_NAME
  FROM    EMPLOYEES
  WHERE   DEPARTMENT_ID = 60; 
 
 -- SUBQUERY : SELECT �ȿ� SELECT �� ��� () �ȿ� ���
 SELECT   DEPARTMENT_ID, FIRST_NAME, LAST_NAME
  FROM    EMPLOYEES
  WHERE   DEPARTMENT_ID = (
     SELECT   DEPARTMENT_ID
       FROM    DEPARTMENTS
       WHERE   DEPARTMENT_NAME = 'IT'
  ); 
  
  -- �μ��� IT �� �����ϴ� �μ����� �� �̸�
  -- ���ڿ����� �˻�
  -- _ : 1 ���� ����      '��_' : '���'(��) , '��'(x)
  -- % : 0 �� �̻��� ��� ����
  -- LIKE '��%'  : '������ �����ϴ�',  '��', '������', '���', '�� ����'
  -- LIKE '%��'  : '��'���� ������',   '������', '��ݱ�'. '��'
  -- LIKE '%��%' : '��'�� �����ϴ� ��� '��', '�߻���', '������'
  
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
 
 -- Marketing, IT, Sales, Accounting �μ��� ���� �̸�, ����
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
 
 -- �Ի����� 02/06/07 �� ������ ã��.
 SELECT    EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE
  FROM     EMPLOYEES
  WHERE    HIRE_DATE = '02/06/07'
 
 -- 07�� 06�� 2��
 -- 07�� 02�� 6��
 -- 02 �� 6�� 7�� (����)
 
 -------------------------------------------------------
 -- 2020.05.11  ����
 -- �μ��� �����̸�
 SELECT   DEPARTMENT_ID, FIRST_NAME
  FROM    EMPLOYEES
  
  -- EMPLOYEES ���̺��� �μ���ȣ
  SELECT   DEPARTMENT_ID
   FROM   EMPLOYEES
   ORDER BY DEPARTMENT_ID ASC;
 
  -- �ߺ������� ��� (DISTINCT) - NULL ���� 12��
  SELECT     DISTINCT DEPARTMENT_ID
   FROM      EMPLOYEES
   ORDER BY DEPARTMENT_ID ASC;
   
  -- �μ����̺��� �μ���ȣ�� ��� - 27��
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
  
  -- �����Լ�(  BUILT-IN FUNCTION )
  ---- �ϰ��ǰ��� �����ϴ� �����α׷�
  -- ����Լ� : SUM(), MAX(), MIN(0, SUM(), AVG()
  ---- Ư�� : NULL ����꿡 �����Ѵ�
  ---- �Ի� ���� : �ٸ� ROW �� ���� COLUMN�� ��������Ѵ�
  ------ ��ü������
  SELECT  SALARY   FROM   EMPLOYEES
  SELECT SUM(SALARY) FROM EMPLOYEES;
  
  SELECT   COUNT(EMPLOYEE_ID), SUM(SALARY), AVG(SALARY)
   FROM    EMPLOYEES
   WHERE   DEPARTMENT_ID = 60
  
  ------ ��ü�������
  SELECT AVG(SALARY) FROM EMPLOYEES;
  
  SELECT 10 / 3 FROM DUAL;
  SELECT SYSDATE FROM DUAL;  -- 20/05/11
  
  SELECT ROUND(10 / 3, 2) FROM DUAL;
  
   -- PRIMARY KEY : NOT NULL(�ʼ��Է�) + UNIQUE(�ߺ��Ұ�)
  
  -- ������ : COUNT()
  SELECT COUNT(*)              FROM EMPLOYEES;     --  107
  SELECT COUNT(EMPLOYEE_ID)    FROM EMPLOYEES;     --  107 
  SELECT COUNT(DEPARTMENT_ID)  FROM EMPLOYEES;   --  1
  
  -- ǥ������(STDDEV, �л�
  
  -- 60 �� �μ��M ��������, �ִ����
  SELECT       MIN(SALARY), MAX(SALARY) 
   FROM        EMPLOYEES
   WHERE       DEPARTMENT_ID = 60; 
   
-- SALEE �μ��� �ִ�, ��������, ���� ���
  SELECT DEPARTMENT_ID FROM DEPARTMENTS
   WHERE  DEPARTMENT_NAME = 'Sales';
  
  SELECT  MAX(SALARY), MIN(SALARY), SUM(SALARY), 
          ROUND(AVG(SALARY), 3), COUNT(SALARY)
   FROM   EMPLOYEES
   WHERE  DEPARTMENT_ID = 80;
   
  SELECT  FIRST_NAME, lAST_NAME
   FROM   EMPLOYEES
   
  --��ȭ��ȣ�� ������ȣ�� 590���� ���۵Ǵ� ����� �̸�, �μ���ȣ-
  SELECT     FIRST_NAME || ' ' || LAST_NAME AS "���� �̸�", 
             DEPARTMENT_ID �μ���ȣ, 
             PHONE_NUMBER
   FROM      EMPLOYEES  
   WHERE     PHONE_NUMBER LIKE  '590%';
   
  --��ȭ��ȣ�� 4567�� ������ ���� �̸�, �μ���ȣ,��ȭ��ȣ
  SELECT   FIRST_NAME || ' '  || LAST_NAME "���� �̸�", 
           DEPARTMENT_ID �μ���ȣ,
           PHONE_NUMBER ��ȭ��ȣ           
   FROM    EMPLOYEES
   WHERE   PHONE_NUMBER LIKE '%4567';
     
  --��ȭ��ȣ�� 23�� ���Ե� �����̸�, �μ���ȣ, ��ȭ ��ȣ
  SELECT   FIRST_NAME || ' '  || LAST_NAME "���� �̸�", 
           DEPARTMENT_ID �μ���ȣ,
           PHONE_NUMBER ��ȭ��ȣ           
   FROM    EMPLOYEES
   WHERE   PHONE_NUMBER LIKE '%23%';
  
  --��ȭ��ȣ�� 6��°�� 2 �� 7��° �ڸ��� 3�� �����̸�, �μ���ȣ, ��ȭ ��ȣ
  SELECT   FIRST_NAME || ' '  || LAST_NAME "���� �̸�", 
           DEPARTMENT_ID �μ���ȣ,
           PHONE_NUMBER ��ȭ��ȣ           
   FROM    EMPLOYEES
   WHERE   PHONE_NUMBER LIKE '_____23_____';
    
  --03/06/17 - 03�� 06�� 17�� �Ի��������� ���
  SELECT   FIRST_NAME || ' ' || LAST_NAME ������, HIRE_DATE �Ի���
   FROM    EMPLOYEES
   WHERE   HIRE_DATE = '03/06/17'; -- 03��06��17��
   
  --�Ի��� ������ ���
 SELECT  * 
  FROM   EMPLOYEES
  ORDER BY HIRE_DATE ASC;
  
  --�Ի��� �������� ��� 
  SELECT  * 
  FROM   EMPLOYEES
  ORDER BY HIRE_DATE DESC;
  
  -- �ּ��Ի��� �ִ��̻���
  SELECT  MIN(HIRE_DATE), MAX(HIRE_DATE)
   FROM   EMPLOYEES
   
   -- ��������Ի��� �ϸ��� ���, �̸�
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
 
  --08�� �Ի��� ���
 SELECT   EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
  FROM    EMPLOYEES
  --WHERE   HIRE_DATE LIKE '08%'
  -- WHERE   '08/01/01' <= HIRE_DATE AND HIRE_DATE < '09/01/01'
  WHERE   HIRE_DATE BETWEEN '08/01/01' AND '08/12/31 00:00:00.000'; 
  
  SELECT  * FROM DEPARTMENTS
  
  
  --08�� 2���Ի��� ���
  SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE, DEPARTMENT_ID
   FROM   EMPLOYEES
   WHERE  HIRE_DATE BETWEEN '08/02/01' AND '08/02/29'
  
  --08�� 2���Ի��� IT�μ� ���� ���
  SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
   FROM   EMPLOYEES
   WHERE  HIRE_DATE BETWEEN '08/02/01' AND '08/02/29'
    AND   DEPARTMENT_ID = ( 
       SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE lower(DEPARTMENT_NAME) = 'it'   
    );
   
   --08�� 2���Ի��� Shipping(50)�μ� ���� ��� - ����
  SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
   FROM   EMPLOYEES
   WHERE  HIRE_DATE BETWEEN '08/02/01' AND '08/02/29'
    AND   DEPARTMENT_ID = ( 
       SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME = 'Shipping'   
    );
   -------------------------------------------------------------------------
   -- �����Լ�
   -- �빮��, �ҹ���, ù���ڸ� �빮��
  SELECT  'Oracle Mania'
          , UPPER('Oracle Mania')
          , LOWER('Oracle mania')
          , INITCAP('Oracle mania')
          , CHR(65), ASCII('a')
   FROM   DUAL;    
   
  -- ���ڱ��� : length �� ���ڼ� : 9��
  --           lengthb : byte ���� utf-8 �̹Ƿ� �ѱ�1�ڴ� 3����Ʈ : 15 ����Ʈ
  SELECT '����Ŭ Mania', LENGTH('����Ŭ Mania'), LENGTHB('����Ŭ Mania')
   FROM   DUAL;
   
 -- CONCAT : ���ڿ� ����
 SELECT 'Oracle', 'mania', concat('Oracle', 'mania'), 'Oracle' || 'mania'   
  FROM  DUAL; 
   
 -- SUBSTR : SUBSTR('���ڿ�', ������ġ(1~), ���ڼ�) : ���ڿ� ����
 SELECT  SUBSTR('851225-1110211', 1, 6),
         SUBSTR('851225-1110211', 8, 1)         
  FROM   DUAL;
 --             1    45     
 SELECT SUBSTR('����Ŭ Mania', 4, 3) ,  -- ' Ma'
        SUBSTRB('����Ŭ Mania', 4, 3)   -- '��' 
  from  dual;      
 
 -- INSTR : ���ڿ��ȿ��� ����ã��
 ---      ��ã���� 0
 --   
SELECT  INSTR('CORPORATE FLOOR', 'OR')
        ,INSTR('CORPORATE FLOOR', 'OR', 2+1)
        ,INSTR('CORPORATE FLOOR', 'OR', 5+1)
        ,INSTR('CORPORATE FLOOR', 'or', 5+1)
        ,INSTR(lower('CORPORATE FLOOR'), 'or', 5+1)
 FROM   DUAL;
 
 -- ������JOB �� CLERK �� �˻��ϼ���
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
  
  -- TRIM : ������ (����) ���ڸ� �����Ѵ�
 select 'ASKLDFJSADLOJFSALKFJASKLOracle Mania��1234----',
        TRIM('    ABCDE FKSDJHFKASDJ     '),
        trim('O' from 'ASKLDFJSADLOJFSALKFJASKLOracle ManiaO1234----'),
        trim('O' from 'OOOOJFSALKFJASKLOracle ManiaOOOO')
  from dual;      

select 'Oracle Mania', '     Oracle Mania     ',
        trim('     Oracle Mania     ')
  from dual;      
  
  ---------------------------------------------------
  -- �����Լ�
  SELECT ABS(-12.3), SIGN(-5) 
   FROM  DUAL;
  
  -- �ݿø�
  SELECT   98.7654,
           ROUND(98.7654, 2),
           ROUND(98.7654, 0),
           ROUND(20098.7654, -2),
           ROUND(20034.7654, -2),
           ROUND(987654, -2)
   FROM DUAL;        
  
  -- ������ ����
  SELECT   98.7654,
           TRUNC(98.7654, 2),
           TRUNC(98.7654, 0),
           TRUNC(20098.7654, -2), -- 100������ ����
           TRUNC(20034.7654, -2),
           TRUNC(987654, -2)
   FROM DUAL;        
   
   -- ������
   SELECT MOD(10, 3) FROM DUAL; -- 10%3 -> 1
   
   -- ����Ŭ �Լ�Ȯ�� - ����
   -- ������ �� 
   SELECT MOD(10.7, 2.3) FROM DUAL;
   SELECT REMAINDER(10.7, 2.3) FROM DUAL;
  
   -- ��� �ﰢ�Լ��� RADIAN ������ �Ի��ؾ��Ѵ�
   -- 30�� * ���ַ�/ 180 => RADIAN
   -- 30EH * 0.01745
   SELECT  ROUND( SIN(30*0.01745), 2), 
           ROUND( COS(30*0.01745), 2) , 
           ROUND( TAN(30*0.01745), 2) FROM DUAL;
   
   SELECT  SQRT(16) FROM DUAL;
   SELECT  4*4 FROM DUAL;
   SELECT  POWER(4, 2) FROM DUAL;
   SELECT  POWER(4, 0.5) FROM DUAL;
   SELECT  POWER(4, 3/2) FROM DUAL;
   
   -- CEIL() -- �ø�
   -- FLOOR() --������
   SELECT CEIL(3.8), FLOOR(3.8) FROM DUAL;
   SELECT CEIL(3.1), FLOOR(3.9) FROM DUAL;
   SELECT CEIL(-3.8), FLOOR(-3.8) FROM DUAL;
   
   ==========================================================
   ��¥
   
   -- ���ó�¥
   SELECT SYSDATE FROM DUAL;  -- 20/05/11
   
   ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD';
   SELECT SYSDATE FROM DUAL; 
   
   -- �ӽ������� ��¥�� ����� �����Ѵ�
   ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD HH24:MI:SS';
      
   -- ���ó�¥
   SELECT SYSDATE FROM DUAL; 
   -- ���� ��¥
   SELECT  SYSDATE - 1  FROM DUAL
   -- 1���� ���� ��¥
   SELECT  SYSDATE  + 7  FROM DUAL
   -- ��¥ + ���� : SYSDATE + 3 : ���ú��� 3�� ��
   -- ��¥ - ���� : SYSDATE - 3 : ���ú��� 3�� ��
   
 -- �������� �ٹ��ϼ��� ���
 -- ��¥ - ��¥ : �� ��¥������ ����( ~��)
 -- ROUND(,0) : ����/���Ľð� �� ����
 SELECT  EMPLOYEE_ID, 
         HIRE_DATE �Ի���, 
         SYSDATE - HIRE_DATE �ٹ��ϼ�,
         ROUND(SYSDATE - HIRE_DATE, 0) 
  FROM   EMPLOYEES
  
  SELECT  ROUND( SYSDATE - TO_DATE('2020-01-29'), 2) FROM DUAL;
  
  --�ٹ��ϼ�
  SELECT  EMPLOYEE_ID, HIRE_DATE, 
          ROUND((SYSDATE - HIRE_DATE)/365.2422, 2) �ٹ��ϼ� 
   FROM   EMPLOYEES

-- EMPLOYEES �� �θ��� ������ �߰�
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
     '����',   '��' ,      'JYLEE',         '010.1234.4567',
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
     '��ȣ',   '��' ,      'TigerLEE',         '010.4567.4567',
     SYSDATE,   'AD_ASST',    1000,      NULL,     107,
     10
 );

COMMIT
SELECT * FROM EMPLOYEES;

-- ������
SELECT  COUNT(*), COUNT(EMPLOYEE_ID), COUNT(DEPARTMENT_ID), COUNT(SALARY)
 FROM   EMPLOYEES;

-- ���� ������
SELECT SUM(SALARY) FROM EMPLOYEES;  -- 692416
-- ���� �������
SELECT ROUND(AVG(SALARY),3) FROM EMPLOYEES; -- 6411.259

SELECT ROUND( SUM(SALARY) / COUNT(*) , 3) FROM EMPLOYEES; -- 6352.44

-- �����Ի��� ����� ����� ���
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
   
 -- �Ի����� '2020-05-12' �� ���
 SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
  FROM   EMPLOYEES
  WHERE   HIRE_DATE LIKE '2020-05-12%'
 
  SELECT  EMPLOYEE_ID, FIRST_NAME, HIRE_DATE
  FROM   EMPLOYEES
  WHERE  '2020-05-12' <=  HIRE_DATE AND HIRE_DATE < '2020-05-13';
 
  --------------------------------------------
  ��¥ �Լ���
  
  -- 2002-02 �� ������ ��¥
  SELECT LAST_DAY('2020-11-05') FROM DUAL;
  
  SELECT HIRE_DATE, LAST_DAY(HIRE_DATE) FROM EMPLOYEES;
  
  SELECT MONTHS_BETWEEN('2020-12-25', SYSDATE  ) FROM DUAL;
  
  SELECT SYSDATE + 3  FORM DUAL;  -- 3����
  SELECT ADD_MONTHS(SYSDATE, 3) FROM DUAL; - ����� ���� 3�� �� ��¥
  
  SELECT NEXT_DAY(SYSDATE, '��') FROM DUAL; -- ���ƿ��� �����ϳ�¥  
  SELECT NEXT_DAY(SYSDATE, '��') FROM DUAL; -- ���� ����ϳ�¥
  SELECT NEXT_DAY(SYSDATE, 2)    FROM DUAL; -- ���� ��(2)���ϳ�¥ (1:�Ͽ���)
  
  SELECT ROUND(SYSDATE), TRUNC(SYSDATE) FROM DUAL; -- ���� 12�ñ���
  
  -- �Ի����� 10���� ���� ������
    
  -- �Ի����� ��������� ���
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

-- �߸��� ǥ��    
 SELECT EMPLOYEE_ID, MIN(HIRE_DATE)
 FROM   EMPLOYEES 
  
-- �μ��� ������
SELECT DISTINCT DEPARTMENT_ID 
 FROM   EMPLOYEES
 
SELECT     DEPARTMENT_ID, COUNT(EMPLOYEE_ID)
 FROM      EMPLOYEES
 GROUP BY  DEPARTMENT_ID
 ORDER BY  DEPARTMENT_ID

-- �μ���, JOB_ID �� ������, ������
SELECT     DEPARTMENT_ID, JOB_ID, COUNT(*), SUM(SALARY)
 FROM      EMPLOYEES
 GROUP BY  DEPARTMENT_ID, JOB_ID
 
--  �� ���忡 ���� �߰�
----- �μ���ȣ�� 10, 60, 110

 SELECT    DEPARTMENT_ID, JOB_ID, COUNT(*), SUM(SALARY)
 FROM      EMPLOYEES
 WHERE     DEPARTMENT_ID IN (10, 60, 110)
 GROUP BY  DEPARTMENT_ID, JOB_ID
 -- HAVING
 
 --- �� ���ǿ� �������� 20000 �̻��� �ڷ�
  SELECT    DEPARTMENT_ID, JOB_ID, COUNT(*), SUM(SALARY)
  FROM      EMPLOYEES
 -- WHERE     SUM(SALARY) >= 20000 -- ERROR WHERE �����Լ� ���Ұ�
  GROUP BY  DEPARTMENT_ID, JOB_ID
   HAVING   SUM(SALARY) >= 20000
 
 --   UNION, UNION ALL
 ---- �������̺��� �ϳ��� ��ģ��
 SELECT * FROM EMPLOYEES 
   WHERE DEPARTMENT_ID = 10;
 
 SELECT * FROM EMPLOYEES 
   WHERE DEPARTMENT_ID = 60;
      
 SELECT * FROM EMPLOYEES 
   WHERE DEPARTMENT_ID IN ( 10, 60);


-- UNION �� �� ���̺��� ���������� �����ϴ°� 
-- ���� : ĭ�� ������ ������ Ÿ���� ���ӿ��Ѵ�
SELECT * FROM EMPLOYEES 
   WHERE DEPARTMENT_ID = 10
UNION  
 SELECT * FROM EMPLOYEES 
   WHERE DEPARTMENT_ID = 60;
   
 SELECT EMPLOYEE_ID, FIRST_NAME        FROM EMPLOYEES  
 UNION
 SELECT DEPARTMENT_ID, DEPARTMENT_NAME FROM  DEPARTMENTS
   
 -- ������ 
  UNION     : ROW �ߺ�����
  UNION ALL : ROW �ߺ�����
 
 -- ������
  INTERSECT 
  
 -- ������
   MINUS
  -
  
--------------------------------------------------
  -- �μ��� �ִ� ����
  SELECT     DEPARTMENT_ID,  TO_CHAR( MAX(SALARY) , 'L99,999.99')
   FROM      EMPLOYEES 
   GROUP BY  DEPARTMENT_ID
   ORDER BY  DEPARTMENT_ID
  
  -- �Ի����� �����λ�����
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
  
  -- 2020�� 5�� 11�� ȭ���� 15�� 32�� 10��  
  -- 2020Ҵ 5�� 11�� ������ 15�� 32�� 10��
  
  SELECT  FIRST_NAME
         ,HIRE_DATE
         , TO_CHAR ( HIRE_DATE, 'YYYY' ) || 'Ҵ ' || 
           TO_CHAR ( HIRE_DATE, 'MM'   ) || '�� ' ||
           TO_CHAR ( HIRE_DATE, 'DD'   ) || '�� ' ||             
           CASE 
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '��'  THEN '��'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '��'  THEN '��'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = 'ȭ'  THEN '��'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '��'  THEN '�'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '��'  THEN '��'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '��'  THEN '��'
              WHEN TO_CHAR ( HIRE_DATE, 'DY' ) = '��'  THEN '��'           
           END
           || '���� ' ||
           CASE
             WHEN  TO_CHAR( HIRE_DATE, 'HH24' ) < 12  THEN '���� '
             ELSE  '���� '
           END   ||
           TO_CHAR ( HIRE_DATE, 'HH24' ) || '�� ' ||
           TO_CHAR ( HIRE_DATE, 'MI'   ) || '�� ' || 
           TO_CHAR ( HIRE_DATE, 'SS'   ) || '��'  AS "�Ի���"
   FROM   EMPLOYEES
   
 SELECT  FIRST_NAME
         ,HIRE_DATE
         , TO_CHAR ( HIRE_DATE, 'YYYY' ) || 'Ҵ ' || 
           TO_CHAR ( HIRE_DATE, 'MM'   ) || '�� ' ||
           TO_CHAR ( HIRE_DATE, 'DD'   ) || '�� ' ||             
           CASE TO_CHAR ( HIRE_DATE, 'DY' )              
              WHEN  '��'  THEN '��'
              WHEN  '��'  THEN '��'
              WHEN  'ȭ'  THEN '��'
              WHEN  '��'  THEN '�'
              WHEN  '��'  THEN '��'
              WHEN  '��'  THEN '��'
              WHEN  '��'  THEN '��'           
           END
           || '���� ' ||
           CASE
             WHEN  TO_CHAR( HIRE_DATE, 'HH24' ) < 12  THEN '���� '
             ELSE  '���� '
           END   ||
           TO_CHAR ( HIRE_DATE, 'HH24' ) || '�� ' ||
           TO_CHAR ( HIRE_DATE, 'MI'   ) || '�� ' || 
           TO_CHAR ( HIRE_DATE, 'SS'   ) || '��'  AS "�Ի���"
   FROM   EMPLOYEES
   
    
  SELECT   TO_CHAR(12345,    '999999'), 
           TO_CHAR(12345,    '0999999'), 
           TO_CHAR(1243.4567, '099,999.999'), 
           TO_CHAR(1234567, 'L99,999') ,  -- �ڸ��� ���ڶ�� #���� ��µȴ�
           TO_CHAR(1234567, 'L9,999,999') ,
           TO_CHAR(1234567, '$9,999,999')
   FROM DUAL;

  SELECT 1 + '3' FROM DUAL;
  SELECT 1 + '3.7' FROM DUAL;
  SELECT 1 + 'A' FROM DUAL;
 --       12345678901234    
  SELECT '750913-1113042',
         CASE
           WHEN SUBSTR('750913-1113042', 8, 1) = '1' THEN '����'
           WHEN SUBSTR('750913-1113042', 8, 1) = '2' THEN '����'
         END "����",
         DECODE( SUBSTR('750913-3113153', 8, 1),'1', '����', '����') "����",
         DECODE( MOD(SUBSTR('750913-4113153', 8, 1), 2),1, '����', '����') "����"
         
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
               '�׿�'
            )  �μ���
    FROM   EMPLOYEES;       
  

  

