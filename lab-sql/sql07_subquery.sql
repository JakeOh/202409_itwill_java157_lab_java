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
-- 2. ALLEN과 같은 업무를 담당하는 직원들의 사번, 이름, 부서번호, 업무, 급여를 출력.
-- 3. SALESMAN의 급여 최댓값보다 더 많은 급여를 받는 직원들의 사번, 이름, 급여, 업무를 출력.
-- 4. WARD의 연봉보다 더 많은 연봉을 받는 직원들의 이름, 급여, 수당, 연봉을 출력.
--    연봉 = sal * 12 + comm. comm(수당)이 null인 경우에는 0으로 계산.
--    연봉 내림차순 정렬.
-- 5. SCOTT과 같은 급여를  받는 직원들의 이름과 급여를 출력. 단, SCOTT은 제외.
-- 6. ALLEN보다 늦게 입사한 직원들의 이름, 입사날짜를 최근입사일부터 출력.
-- 7. 매니저가 KING인 직원들의 사번, 이름, 매니저 사번을 검색.
-- 8. ACCOUNTING 부서에 일하는 직원들의 이름, 급여, 부서번호를 검색.
-- 9. CHICAGO에서 근무하는 직원들의 이름, 급여, 부서 번호를 검색.