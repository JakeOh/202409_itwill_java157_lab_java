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
