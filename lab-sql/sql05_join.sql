/*
 * join: 2개 이상의 테이블에서 데이터를 검색하는 방법.
 * join의 종류:
 * 1. inner join
 * 2. outer join
 *    (1) left outer join
 *    (2) right outer join
 *    (3) full outer join
 * join 문법:
 * 1. ANSI 표준 문법:
 *    select 컬럼, ...
 *    from 테이블1 join종류 테이블2 on 조건식;
 * 2. Oracle 문법:
 *    select 컬럼, ...
 *    from 테이블1, 테이블2, ...
 *    where 조건식;
 */

-- inner join과 outer join의 차이점을 설명하기 위한 데이터.
insert into emp (empno, ename, sal, deptno)
values (1004, '오쌤', 3500, 50);

commit; -- 테이블의 변경 내용을 영구 저장.

select * from emp;
select * from dept;

-- 사번, 이름, 부서번호, 부서이름 출력. inner join.
-- (1) ANSI
select
    e.empno, e.ename, e.deptno, d.dname
from emp e
    inner join dept d on e.deptno = d.deptno;
--> inner join에서 inner는 생략 가능.

-- (2) Oracle
select
    e.empno, e.ename, e.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno;
