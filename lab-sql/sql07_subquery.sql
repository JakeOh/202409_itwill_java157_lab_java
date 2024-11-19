/*
 * subquery(서브쿼리): SQL 문장의 일부로 다른 SQL 문장이 포함되는 것.
 */

-- 전체 직원의 급여 평균보다 더 많은 급여를 받는 직원들?
select avg(sal) from emp;
select * from emp where sal > 1968.3;

--> subquery로 작성:
select * from emp
where sal > (
    select avg(sal) from emp
);

-- 1. ALLEN보다 적은 급여를 받는 직원들의 사번, 이름, 급여를 출력.
select
    empno, ename, sal
from emp
where sal < (
    select sal from emp where ename = 'ALLEN'
);

-- 2. ALLEN과 같은 업무를 담당하는 직원들의 사번, 이름, 부서번호, 업무, 급여를 출력.
select
    empno, ename, deptno, job, sal
from emp
where job = (
    select job from emp where ename = 'ALLEN'
);

-- 3. SALESMAN의 급여 최댓값보다 더 많은 급여를 받는 직원들의 사번, 이름, 급여, 업무를 출력.
select
    empno, ename, sal, job
from emp
where sal > (
    select max(sal) from emp where job = 'SALESMAN'
);

-- 4. WARD의 연봉보다 더 많은 연봉을 받는 직원들의 이름, 급여, 수당, 연봉을 출력.
--    연봉 = sal * 12 + comm. comm(수당)이 null인 경우에는 0으로 계산.
--    연봉 내림차순 정렬.
select
    ename, sal, comm, sal * 12 + nvl(comm, 0) as "ANNUAL_SAL"
from emp
where sal * 12 + nvl(comm, 0) > (
    select sal * 12 + nvl(comm, 0)
    from emp
    where ename = 'WARD'
)
order by ANNUAL_SAL desc;

-- 5. SCOTT과 같은 급여를  받는 직원들의 이름과 급여를 출력. 단, SCOTT은 제외.
select
    ename, sal
from emp
where ename != 'SCOTT'
    and
    sal = (
        select sal from emp where ename = 'SCOTT'
    );

-- 6. ALLEN보다 늦게 입사한 직원들의 이름, 입사날짜를 최근입사일부터 출력.
select
    ename, hiredate
from emp
where hiredate > (
    select hiredate from emp where ename = 'ALLEN'
)
order by hiredate desc;

-- 7. 매니저가 KING인 직원들의 사번, 이름, 매니저 사번을 검색.
select
    empno, ename, mgr
from emp
where mgr = (
    select empno from emp where ename = 'KING'
);

-- 8. ACCOUNTING 부서에 일하는 직원들의 이름, 급여, 부서번호를 검색.
select
    ename, sal, deptno
from emp
where deptno = (
    select deptno from dept where dname = 'ACCOUNTING'
);

select 
    e.ename, e.sal, d.deptno
from emp e
    join dept d on e.deptno = d.deptno
where d.dname = 'ACCOUNTING';

select
    e.ename, e.sal, d.deptno
from emp e, dept d
where e.deptno = d.deptno
    and d.dname = 'ACCOUNTING';

-- 9. CHICAGO에서 근무하는 직원들의 이름, 급여, 부서 번호를 검색.
select
    ename, sal, deptno
from emp
where deptno = (
    select deptno from dept where loc = 'CHICAGO'
);

select
    e.ename, e.sal, d.deptno
from emp e
    join dept d on e.deptno = d.deptno
where d.loc = 'CHICAGO';

select
    e.ename, e.sal, d.deptno
from emp e, dept d
where e.deptno = d.deptno
    and d.loc = 'CHICAGO';
