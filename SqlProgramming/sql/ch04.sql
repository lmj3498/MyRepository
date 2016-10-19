--Section01 그룹함수(직계함수) : 아무 곳이나 쓸 수 없음에 유의: select 절 안에 와야 함
--사원들의 전체 월급의 합
select sum(sal) from emp;
--월급을 가장 많이 받아가는 사원의 정보
select * from emp where sal=(select max(sal) from emp);
--평균 월급 보다 많이 받아가는 사원의 정보
select * from emp where sal>(select avg(sal) from emp);
--전 사원의 수 = 전체 행수
select count(*) from emp;--전체 행 수
select count(empno) from emp;--empno의 행 수
select count(comm) from emp;--null을 제외하고 카운팅
--평균 월급 보다 많이 받아가는 사원의 수
select count(empno) from emp where sal>(select avg(sal) from emp);
--1.1 그룹 함수와 NULL 값
--1.2 그룹 함수와 단순 컬럼--null을 제외
select avg(comm) as from emp;
select sum(comm) / count(comm) from emp;
select sum(comm) / count(*) from emp;
--사원의 직급 개수는?
select count(distinct job) from emp; 

--Section02 데이터 그룹 : GROUP BY 절
--부서별로 평균 봉급은?
select deptno, sal from emp order by deptno;
select deptno,round(avg(sal),1) from emp group by deptno order by deptno;
--group by 뒤에는 그룹지을 컬럼명&select안에 있어야(그룹함수와 함께 쓰임)

--직급별 평균 봉급은?
select job,round(avg(sal),1) from emp group by job;
--부서별(1차 그룹핑) 직급별(2차 그룹핑) 평균 봉급은?
select deptno,job,round(avg(sal),1) from emp group by deptno, job order by deptno;

--Section03 그룹 결과 제한 : HAVING 절
--부서별 평균 봉급이 500이상인 부서 번호와 평균 봉급은?
select deptno, avg(sal) from emp group by deptno having avg(sal)>500;
--그룹핑 전의 조건 : where
--그룹핑 후의 조건 : having

--사원중에서 부서별 평균 봉급이 300이상인 부서와 평균 봉급은?
select deptno,avg(sal) from (select * from emp where job = '사원') group by deptno having avg(sal)>=300;
select deptno,avg(sal) from emp where job = '사원' group by deptno having avg(sal)>=300;
--사원중에서 부서별 평균 봉급이 300이상인 부서와 사원의 평균 봉급 및 수?
select deptno, avg(sal), count(empno) 
from emp 
where job = '사원' 
group by deptno 
having avg(sal) >=300;
--급여 총액이 1000을 넘는 직급(별)에 대해서 직급과 급여 총액을 표시하되 직급이 사원인 사람은 제외시킨 후 급여 총액에 따라 정렬하시오.
select job, count(*), sum(sal)
from emp
where job != '사원'
group by job
having sum(sal)>1000
order by sum(sal);
--문제
select job, sum(sal) as salary from emp where job != '사원' group by job having sum(sal)>1000 order by salary;


