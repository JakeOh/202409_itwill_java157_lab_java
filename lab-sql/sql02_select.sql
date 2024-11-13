/*
 * 기본 Query 문장: 테이블에서 데이터 검색하기.
 *   select 컬럼이름, ... from 테이블이름;
 * 테이블의 모든 컬럼들을 검색:
 *   select * from 테이블이름;
 */

-- 직원 테이블에서 사번, 이름을 검색
select empno, ename from emp;

-- 직원 테이블의 모든 컬럼을 검색
select * from emp;
--> 테이블이 만들어진 컬럼 순서대로 출력.

select 
    deptno, empno, ename, job, hiredate, sal, comm, mgr
from emp;
--> select에서 나열한 컬럼 순서대로 출력.

-- 컬럼 이름에 별명(alias) 주기: 컬럼이름 as "별명"
-- as는 생략 가능.
-- 별명에 공백이 없는 경우에는 큰따옴표("")를 생략 가능.
-- 별명에서는 작은따옴표('')를 사용하면 안됨!
-- (주의) SQL에서 작은따옴표는 문자열로 사용. (예) ename = 'SCOTT'
select 
    empno 사번, ename "이름", mgr as "매니저 사번"
from emp;

-- 부서 테이블에서 부서 번호, 부서 이름, 부서 위치(도시)를 출력.
-- 컬럼 별명: "부서 번호", "부서 이름", "부서 위치"
select
    deptno as "부서 번호", dname as "부서 이름", loc as "부서 위치"
from dept;

-- 연결 연산자(||): 2개 이상의 컬럼(또는 문자열)을 합쳐서 하나의 컬럼으로 출력.
-- '부서번호-부서이름' 형식의 문자열을 "부서"라는 컬럼 이름으로 출력.
select
    deptno || '-' || dname as "부서"
from dept;

-- 부서 테이블을 검색해서 'A(이름)부서는 B에 있습니다.' 형식으로 출력.
select
    dname || '부서는 ' || loc || '에 있습니다.' as "부서 위치"
from dept;

-- 직원 테이블을 검색해서 'A(이름)의 급여는 B입니다.' 형식으로 출력.
select
    ename || '의 급여는 ' || sal || '입니다.' as "직원 급여"
from emp;

-- 검색 결과를 (오름차순, 내림차순) 정렬해서 출력:
-- select ... from 테이블 order by 컬럼, ... [asc/desc];
-- asc: 오름차순 정렬(ascending order). 생략 가능.
-- desc: 내림차순 정렬(descending order).

-- 사번, 이름을 검색. 사번 오름차순 정렬.
select empno, ename from emp order by empno;

-- 사번, 이름을 검색. 사번 내림차순 정렬.
select empno, ename from emp order by empno desc;

-- 부서 번호, 사번, 이름 검색. (1) 부서 번호, (2) 사번 오름차순 정렬.
select 
    deptno, empno, ename
from emp
order by deptno, empno;

-- 사번, 이름, 급여를 검색. 급여 내림차순 정렬.
select 
    empno, ename, sal
from emp
order by sal desc;

-- 부서 번호, 이름, 급여를 검색. 부서 오름차순, 급여 내림차순 정렬.
select 
    deptno, ename, sal
from emp
order by deptno asc, sal desc;
--> asc는 생략 가능.
