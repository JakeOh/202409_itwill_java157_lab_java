/*
 * DML(Data Manipulation Language): insert, update, delete
 */

-- insert into table_name (column, ...) values (value, ...);
--> 테이블에 1개의 행을 삽입.

-- insert select 구문: 다른 테이블에서 검색한 행(들)을 삽입.
-- insert into table_name select column, ... from another_table [where, ...];
-- emp 테이블에서 comm이 null이 아닌 행들을 bonus 테이블에 삽입.

insert into bonus
select ename, job, sal, comm from emp 
where comm is not null;
--> 4개 행이 삽입.

commit;


-- update 문장: 테이블 데이터 업데이트(수정).
-- update table_name set column_name = value, ... [where 조건식];

-- emp 테이블에서 sal(급여)를 1000으로 변경.
update emp
set sal = 1000;
--> where 절이 없는 경우에는 모든 행의 급여 컬럼이 업데이트됨.

rollback;
--> 직전 commit 상태로 되돌림.

-- 사번이 1004인 직원의 급여를 2000으로 업데이트.
update emp
set sal = 2000
where empno = 1004;

-- 사번 1004인 직원의 업무를 MANAGER, 입사날짜를 '2000/12/31'로 업데이트.
update emp
set job = 'MANAGER', hiredate = '2000/12/31'
where empno = 1004;

-- 1982/01/01 이후에 입사한 직원들의 급여를 10% 인상.
update emp
set sal = sal * 1.1
where hiredate > '1982/01/01';

-- ACCOUNTING 부서에서 일하는 직원들의 급여를 10% 인상.
update emp
set sal = sal * 1.1
where deptno = (
    select deptno from dept where dname = 'ACCOUNTING'
);

-- salgrade가 1인 직원들의 급여를 25% 인상.
update emp
set sal = sal * 1.25
where sal between 
    (select losal from salgrade where grade = 1) 
    and
    (select hisal from salgrade where grade = 1);

select * from emp;

commit;


-- delete 문장: 테이블에서 행을 삭제하는 DML.
-- delete from table_name [where 조건식];
-- where 절이 없는 경우에는 모든 행이 삭제됨.
-- where 절이 있는 경우에는 조건을 만족하는 행(들)이 삭제됨.

-- 사번이 1004인 직원의 레코드(행)을 삭제.
delete from emp where empno = 1004;

select * from emp;

commit;

delete from emp;
rollback;

-- 1987년에 입사한 직원들을 삭제.

