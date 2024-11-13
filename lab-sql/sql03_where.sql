/*
 * 조건 검색 where
 *
 * 테이블에서 데이터 검색:
 * (1) projection: 테이블에서 원하는 컬럼(들)을 선택.
 * (2) selection: 테이블에서 조건을 만족하는 행(들)을 선택.
 *
 * select 컬럼, ... from 테이블 where 조건식 order by 컬럼, ...;
 * 조건식에서 사용되는 연산자들:
 *   (1) 비교 연산자: =, !=, >, >=, <, <=, is null, is not null, ...
 *   (2) 논리 연산자: and, or, not
 */

-- 10번 부서에서 근무하는 직원들의 부서번호, 사번, 이름을 출력.
-- 정렬 순서: 사번 오름차순
select
    deptno, empno, ename
from emp
where deptno = 10
order by empno;
 
-- 수당(comm)이 null이 아닌 직원들의 부서번호, 사번, 이름, 급여, 수당을 출력.
-- 정렬 순서: (1) 부서번호, (2) 사번
select
    deptno, empno, ename, sal, comm
from emp
where comm is not null
order by deptno, empno;
--> (주의) SQL에서는 null 여부를 비교할 때는 =, != 사용할 수 없음.
--> 반드시 is null, is not null을 사용해야 함.
 
-- 급여(sal)가 2000 이상인 직원들의 이름, 업무, 급여를 출력.
-- 정렬 순서: 급여 내림차순.
select
    ename, job, sal
from emp
where sal >= 2000
order by sal desc;

-- 급여가 2000 이상 3000 이하인 직원들의 이름, 업무, 급여를 출력.
-- 정렬 순서: 급여 내림차순.
select
    ename, job, sal
from emp
where sal >= 2000 and sal <= 3000
order by sal desc;

select
    ename, job, sal
from emp
where sal between 2000 and 3000
order by sal desc;

-- 10번 또는 20번 부서에서 근무하는 직원들의 부서번호, 이름, 급여를 출력.
-- 정렬: (1) 부서번호 오름차순, (2) 급여 내림차순.
select
    deptno, ename, sal
from emp
where deptno = 10 or deptno = 20
order by deptno, sal desc;
--> where deptno = 10 or 20 (x)

select 
    deptno, ename, sal
from emp
where deptno in (10, 20)
order by deptno, sal desc;

-- 업무가 'CLERK'인 직원들의 이름, 업무, 급여를 출력. 이름순으로 출력.
select
    ename, job, sal
from emp
where job = 'CLERK'
order by ename;
--> 문자열 비교에서는 대/소문자를 구분!
--> 문자열 비교 연산자도 =, != 연산자를 사용.

-- 업무가 'CLERK' 또는 'MANAGER'인 직원들의 이름, 업무, 급여를 출력.
-- 정렬: (1) 업무, (2) 급여
select
    ename, job, sal
from emp
where job = 'CLERK' or job = 'MANAGER'
order by job, sal;

select
    ename, job, sal
from emp
where job in ('CLERK', 'MANAGER')
order by job, sal;

-- 20번 부서에서 근무하는 'CLERK'의 모든 레코드(모든 컬럼)를 출력.
select *
from emp
where deptno = 20 and job = 'CLERK';

-- CLERK, ANALYST, MANAGER가 아닌 직원들의 사번, 이름, 업무, 급여를 사번순 출력.
select
    empno, ename, job, sal
from emp
where job != 'CLERK' and job != 'ANALYST' and job != 'MANAGER'
order by empno;

select 
    empno, ename, job, sal
from emp
where job not in ('CLERK', 'ANALYST', 'MANAGER')
order by empno;

-- like 검색: 특정 문자열로 시작하거나 또는 특정 문자열이 포함된 값을 찾는 검색.
-- like 검색에서 사용되는 wildcard:
-- (1) %: 글자수 제한 없음.
-- (2) _: 밑줄이 있는 자리의 한 글자가 어떤 문자여도 상관 없음.

select * from emp where job like '_LERK'; --> 5개 행
select * from emp where job like '_ERK'; --> 0개 행
select * from emp where job like '__ERK'; --> 5개 행
select * from emp where job like 'C___K';

select * from emp where job like 'C%';
select * from emp where job like '%K';
select * from emp where job like 'C%K';
select * from emp where job like '%R%';

-- 이름에 'A'가 포함된 직원들의 모든 레코드 출력.
select * 
from emp
where ename like '%A%';
--> like 검색에서도 문자열은 대/소문자를 구분함.

-- 30번 부서에서 근무하고, 업무에 'MAN' 단어가 포함된 직원들의
-- 사번, 부서번호, 이름, 업무, 급여를 사번순 출력.
select
    empno, deptno, ename, job, sal
from emp
where deptno = 30 and job like '%MAN%'
order by empno;

-- SQL에서는 숫자 타입뿐만 아니라, 날짜/문자열 타입 등도 크기 비교를 할 수 있음.
-- '1982/01/01' 이후에 입사한 직원들의 레코드를 입사일 순 출력.
select *
from emp
where hiredate >= '1982/01/01'
order by hiredate;
--> 암묵적(자동) 타입 변환:
-- 오라클은 날짜 타입과 문자열 타입의 크기를 비교할 때,
-- 문자열을 날짜 타입으로 변환한 후 크기 비교를 수행함.
-- 과거 < 현재 < 미래
-- 만약, 문자열을 날짜 타입으로 변환할 수 없는 경우에는 오류가 발생.

-- 문자열이 날짜 타입으로 자동 변환될 때, 
-- [도구]->[환경설정]->[데이터베이스]->[NLS] 설정에 따라서 변환되는 내용이 달라짐.

-- 명시적 타입 변환:
-- to_date(날짜로 변환할 문자열, 날짜 포맷 문자열)
select to_date('1982/03/01', 'YYYY/MM/DD') from dual;
select to_date('03/01/1982', 'MM/DD/YYYY') from dual;
select to_date('01/03/1982', 'DD/MM/YYYY') from dual;
select to_date('24/11/13', 'RR/MM/DD') from dual; --> 2024/11/13
select to_date('99/11/13', 'RR/MM/DD') from dual; --> 1999/11/13
select to_date('99/11/13', 'YY/MM/DD') from dual; --> 2099/11/13

select * 
from emp
where hiredate >= to_date('1982/01/01', 'YYYY/MM/DD')
order by hiredate;
