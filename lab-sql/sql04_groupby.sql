/*
 * 오라클 함수(function):
 * 1. 단일 행 함수:
 *    행(row)이 하나씩 함수의 아규먼트로 전달되고, 행 마다 하나씩 결과가 리턴되는 함수.
 *    (예) to_date, to_char, lower, upper, nvl, ...
 * 2. 다중 행 함수:
 *    여러 개의 행들이 함수의 아규먼트로 전달되고, 하나의 결과가 리턴되는 함수.
 *    (예) 통계 관련 함수: count, sum, avg, max, min, variance(분산), stddev(표준편차), ...
 */

-- 단일 행 함수 예 - 모든 행의 문자열을 소문자로 바꾸기.
select
    ename, lower(ename), job, lower(job)
from emp;

-- to_char(arg, format): arg를 format 형식의 문자열로 변환.
select 
    hiredate, to_char(hiredate, 'YYYY-MM-DD'),
    to_char(hiredate, 'YYYY')
from emp;
--> SQL Developer에서 날짜 타입의 컬럼을 출력하면, 환경설정(데이터베이스->NLS)에 따름.

-- nvl(var, value): var가 null이면 value를 리턴하고, 그렇지 않으면 원래 var 값을 리턴.
-- nvl2(var, value1, value2): var가 null이 아니면 value1을 리턴, null이면 value2를 리턴.
select
    comm, nvl(comm, 0), nvl2(comm, comm, 0), nvl2(comm, 'T', 'F')
from emp;

-- 이름이 대/소문자 구분없이 'a'로 시작하는 직원들의 이름을 출력.
select 
    ename
from emp
where upper(ename) like 'A%';

-- 사번, 이름, 급여, 수당, 연봉을 출력.
-- 연봉 = 급여 * 12 + 수당
select
    empno, ename, sal, comm,
    sal * 12 + nvl(comm, 0) as "ANNUAL_SAL"
from emp;

-- 다중 행 함수 예:
-- count(컬럼): 컬럼에서 null이 아닌 값들의 개수를 리턴.
select
    count(empno), count(mgr)
from emp;

-- 테이블의 행의 개수:
select count(*) from emp;

-- 통계: 합계, 평균, 최댓값, 최솟값, 분산, 표준편차(standard deviation)
select
    sum(sal), round(avg(sal), 2), max(sal), min(sal),
    round(variance(sal), 2), round(stddev(sal), 2)
from emp;

-- 단일 행 함수와 다중 행 함수는 함께 사용할 수 없음!
-- select sal, sum(sal) from emp; --> 에러 발생
-- select nvl(comm, 0), sum(comm) from emp; --> 에러 발생

/*
 * 그룹별 쿼리:
 * (예) 부서별 직원수, 부서별 급여 평균, ...
 * 
 * select 컬럼, 그룹함수(), ...
 * from 테이블
 * where 조건식(1)
 * group by 컬럼(그룹을 묶을 수 있는 변수), ...
 * having 조건식(2)
 * order by 컬럼(정렬 기준이 되는 변수), ...;
 *
 * 조건식(1): 그룹을 묶기 전에 조건을 만족하는 행들을 선택하기 위한 조건식.
 * 조건식(2): 그룹을 묶은 후에 조건을 만족하는 그룹들을 선택하기 위한 조건식.
 *
 * group by에 없는 컬럼은 select에서 사용할 수 없음!
 */

-- 부서별 급여 평균
select
    deptno, round(avg(sal), 2)
from emp
group by deptno
order by deptno;

-- 부서별 급여 평균, 최댓값, 최솟값
select
    deptno, round(avg(sal), 2) as "AVG_SAL", 
    max(sal) as "MAX_SAL", min(sal) as "MIN_SAL"
from emp
group by deptno
order by deptno;

-- 업무별 직원수, 급여 최댓값, 급여 최솟값, 급여 평균을 업무 오름차순 출력.
select
    job, count(job), max(sal), min(sal), round(avg(sal), 2)
from emp
group by job
order by job;

-- 부서별 업무별 부서번호, 업무, 직원수, 급여 평균을 출력.
-- 정렬: (1) 부서번호, (2) 업무
select
    deptno, job, count(*), round(avg(sal), 2)
from emp
group by deptno, job
order by deptno, job;

-- 입사연도별 사원수를 출력. (힌트) to_char(hiredate, 'YYYY') 이용.
select
    to_char(hiredate, 'YYYY') as "YEAR", count(*) as "EMP_COUNT"
from emp
group by to_char(hiredate, 'YYYY')
order by YEAR;
--> select 절에서 설정한 별명(alias)는 where, group by, having 절에 사용할 수 없음.
--> order by 절에서는 사용할 수 있음.

-- 부서별 급여 평균을 출력. 부서별 급여 평균이 2000 이상인 부서만 선택.
select
    deptno, round(avg(sal), 2)
from emp
group by deptno
having avg(sal) >= 2000
order by deptno;

-- mgr(매니저 사번) 컬럼이 null이 아닌 직원들 중에서
-- 부서별 급여 평균을 부서번호 오름차순 출력.
select 
    deptno, round(avg(sal), 2)
from emp
where mgr is not null
group by deptno
order by deptno;

-- PRESIDENT는 제외하고, 업무별 사원수를 업무 이름 순 출력.
-- 업무별 사원수가 3명 이상인 업무만 선택.
select
    job, count(*)
from emp
where job != 'PRESIDENT'
group by job
having count(*) >= 3
order by job;

select 
    job, count(*)
from emp
group by job
having job != 'PRESIDENT' and count(*) >= 3
order by job;

-- 입사연도별, 부서별 사원수 출력. 1980년은 검색에서 제외.
-- 연도별 부서별 사원수가 2명 이상인 경우만 출력.
-- 정렬: (1) 연도, (2) 부서번호
select
    to_char(hiredate, 'YYYY') as "YEAR", deptno, count(*) as "COUNT"
from emp
where to_char(hiredate, 'YYYY') != '1980'
group by to_char(hiredate, 'YYYY'), deptno
having count(*) >= 2
order by YEAR, deptno;

select
    to_char(hiredate, 'YYYY') as "YEAR", deptno, count(*) as "COUNT"
from emp
group by to_char(hiredate, 'YYYY'), deptno
having to_char(hiredate, 'YYYY') != '1980' and count(*) >= 2
order by YEAR, deptno;