--Section01 DUAL 테이블
select * from dual; --실체가 없는, 오라클이 사용하는 가상 테이블
select 10+20 from emp; --select 는 행 단위!
select 10+20 from dual;
select sysdate from dual;--괄호가 없는 함수=프로시저
--Section02 숫자 함수
--2.1 절대값을 구하는 ABS 함수
select abs(-10) from dual;
select abs(-15) from dual;
update emp set sal = sal/7;
select * from emp;
rollback;

--소수 첫째자리까지 나타내기(반올림)
select sal,round(sal, 1) from emp;
--바로 아래 정수(소수를 정수로 만든는 방법)
select sal,floor(sal) from emp;
select sal,round(sal) from emp;
--바로 위 정수
select sal, ceil(sal) from emp;
--소수 첫째자리까지 나타내기(짤라내기)
select trunc(sal,1) from emp;

--Section03 문자 처리 함수
--3.1 대소문자 변환함수
select * from employees;
select phone_number from employees where lower(first_name)='steven';--시험문제 나옴
--3.3 문자 조작 함수
--3.3.1 문자열 일부만 추출하는 SUBSTR 함수
select * from employees;
select substr(first_name,1,5) from employees;--시험문제 나옴
--3.3.5 특정 기호로 채우는 LPAD/RPAD 함수
select lpad('oracle',20,'*') from dual;
select rpad('oracle',20,'*') from dual;
--10자리 공간에 사원 이름을 5자리까지만 나오게 하고 나머지는 오른쪽 *처리
select rpad(substr(first_name,1,5),10,'*') from employees;--시험문제 나옴

--Section04 형 변환 함수
--4.1.1 날짜형을 문자형으로 변환하기--db에서 application으로 데이터 가져올 때
select hire_date, to_char(hire_date,'YYYY.MM.DD DAY') from employees;
select hire_date, to_char(hire_date,'YYYY.MM.DD DAY') from employees;
--4.2 문자형을 날짜형으로 변환하기--application에서 db에 있는 데이터 접근하고 연산하고자 할 때
select first_name,hire_date from employees where hire_date=to_date('06-17-2003','MM-DD-YYYY');--시험문제 나옴

--Section05 날짜함수
--5.1 DBMS의 현재 날짜
select sysdate from dual;
--DBMS의 현재 날짜를 2016.10.17 울요일 형태로 변환
select to_char(sysdate,'YYYY.MM.DD DAY') from dual;--시험문제 나옴

--Section06 NULL을 다른 값으로 변환하는 NVL 함수
select salary*12 + nvl(commission_pct,0)*salary from employees;
select nvl2(commission_pct,salary*12+commission_pct*salary,salary*12) from employees;--첫번째 매개변수가 null이 아니면 두번째 계산, null이면 세번째 계산











