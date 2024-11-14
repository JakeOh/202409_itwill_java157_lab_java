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
 * 조건식(1): 그룹을 묶기 전에 행들을 선택할 조건식.
 * 조건식(2): 그룹을 묶은 후에 행들을 선택할 조건식.
 */