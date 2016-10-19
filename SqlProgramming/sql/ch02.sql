-- 1.1 문장과 절
select * from emp;
-- 1.2 특정 데이터만 보기
select empno, ename from emp;
-- 1.3 산술 연산자
select ename, sal, sal*12 from emp;
-- 1.4 NULL연산 시 주의할 점
select ename, comm from emp;
select ename, sal, comm, sal*12+comm from emp;
select ename, sal, comm, sal*12+nvl(comm,0) from emp;
-- 1.5 컬럼 이름에 별칭 지정하기
select ename as 이름, sal 월급, comm "보너스", sal*12+nvl(comm,0) as 연봉 from emp;
-- 1.6 Concatenation 연산자(문자열 결합)
select empno, ename from emp;
select empno || '-' || ename as 이름, ename from emp;
select ename || '의 직급은 '|| job || '입니다.' as 직급 from emp;
-- 1.7 DISTINCT 키워드 (중복제거)
-- 사원이 있는 부서 번호는?
select distinct deptno from emp;
-----------------------------------------------------------------------------
-- 조건절 작성
select ename from emp where deptno=20;
-- 2.1.1 비교 연산자
select ename from emp where deptno!=20;
select ename from emp where deptno<>20;
select ename from emp where sal>=500;
select * from emp where ename='이문세';
-- 2.1.2 날짜 데이터 조회
-- 2005년 1월 1일 이전에 입사한 사원의 정보
select * from emp where hiredate < '05/01/01';
select * from emp where hiredate < '2005/01/01';
select * from emp where hiredate < '2005.01.01';
select * from emp where hiredate < '2005-01-01';
select * from emp where hiredate < to_date('2005/01/01','YYYY/MM/DD');--예전 방식
-- 2.2 논리 연산자
-- 2.2.1 AND 연산자
--10번 부서에 소속된 사원중에서 직급이 과장인 사원
select * from emp where deptno =10 and job='과장';
--월급이 400이상 500이하 사원
select * from emp where sal>=400 and sal<=500;
-- 2.2.1 OR 연산자
--10번 부서에 소속된 사원 또는 직급이 과장인 사원
select * from emp where deptno =10 or job='과장';
-- 2.2.3 NOT 연산자
--10번 부서가 아닌 사원
select * from emp where deptno!=10;
select * from emp where deptno =10 or job='과장';
select * from emp where not deptno=10;
-- 2.3 BETWEEN AND 연산자
--월급이 400이상 500이하 사원
select * from emp where sal>=400 and sal<=500;
select * from emp where sal between 400 and 500;
-- 2.4 IN 연산자
--보너스가 80이거나 100이거나 200인 사원
select * from emp where comm=80 or comm=100 or comm=200;
select * from emp where comm in(80,100,200);
-- 2.5 LIKE 연산자와 와일드 카드
-- 2.5.1 와일드 카드(%)사용하기
--성이 이씨인 사원
select * from emp where ename between '이' and '익';
select * from emp where ename like '이%';
--이름 중에 '성'이 포함된 사원
select * from emp where ename like '%성%';
-- 2.5.1 와일드 카드(_)사용하기
--이름 중에 두번째 글자가 '성'이 포함된 사원
select * from emp where ename like '_성%';
--이름 중에 '성'이 포함되지 사원
select * from emp where not ename like '%성%';
-- 2.6 NULL을 위한 연산자
--보너스가 없는(null)인 사원
select * from emp where comm is null;
select * from emp where comm is not null;
----------------------------------------------------------------------------
--3.1 오름차순 정렬을 위한 ASC
select * from emp order by sal asc;
--3.2 내림차순 정렬을 위한 DESC
select * from emp order by sal desc;
select * from emp order by hiredate desc;
--입사날 순서(1차정렬) -> 이름순(2차 정렬)
select * from emp order by hiredate desc, ename asc;
--30부서에서 월급이 400이상인 사원의 번호,이름,연봉(내림차순)
select empno,ename,(sal*12+nvl(comm,0)) as yearsal 
from emp 
where sal >=400 and deptno =30 
order by hiredate desc, ename asc;











