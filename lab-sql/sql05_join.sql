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

-- left outer join
-- (1) ANSI
select
    e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e
    left outer join dept d on e.deptno = d.deptno;
--> left outer join에서 outer는 생략 가능.

-- (2) Oracle
select
    e.empno, e.ename, d.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno(+);

-- right outer join
-- (1) ANSI
select
    e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e
    right join dept d on e.deptno = d.deptno;

-- (2) Oracle
select
    e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e, dept d
where e.deptno(+) = d.deptno;

-- full outer join
-- (1) ANSI
select 
    e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e
    full join dept d on e.deptno = d.deptno;

-- (2) Oracle: full outer join 문법이 없음.
-- left outer join과 right outer join의 합집합으로 full outer join의 결과를 만들 수 있음.
select 
    e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e, dept d
where e.deptno = d.deptno(+)
union
select 
    e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e, dept d
where e.deptno(+) = d.deptno;

-- equi join: join의 조건식이 = 연산자를 사용해서 만들어진 경우.
-- non-equi join: join의 조건식이 부등호를 사용해서 만들어진 경우.

-- non-equi join에서 inner/outer join을 테스트하기 위해서.
update emp set sal = 500 where empno = 1004;
commit;

-- 직원(emp) 테이블과 급여등급(salgrade) 테이블에서 사번, 이름, 급여, 급여등급 출력.
-- ANSI inner join
select 
    e.empno, e.ename, e.sal, s.grade
from emp e
    join salgrade s on e.sal between s.losal and s.hisal;

-- Oracle inner join
select
    e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal;

-- ANSI left join
select 
    e.empno, e.ename, e.sal, s.grade
from emp e
    left join salgrade s on e.sal between s.losal and s.hisal;

-- Oracle left join
select
    e.empno, e.ename, e.sal, s.grade
from emp e, salgrade s
where e.sal between s.losal(+) and s.hisal(+);

-- self join: 같은 테이블에서 join하는 방법.
-- 사번, 이름, 매니저 사번, 매니저 이름 출력.

-- ANSI inner join
select
    e1.empno, e1.ename, e1.mgr, 
    e2.empno as "매니저 사번", e2.ename as "매니저 이름"
from emp e1
    join emp e2 on e1.mgr = e2.empno;

-- Oracle inner join
select
    e1.empno, e1.ename, e1.mgr, 
    e2.empno as "매니저 사번", e2.ename as "매니저 이름"
from emp e1, emp e2
where e1.mgr = e2.empno;

-- ANSI left outer join
select
    e1.empno, e1.ename, e1.mgr, 
    e2.empno as "매니저 사번", e2.ename as "매니저 이름"
from emp e1
    left join emp e2 on e1.mgr = e2.empno;

-- Oracle left outer join
select
    e1.empno, e1.ename, e1.mgr, 
    e2.empno as "매니저 사번", e2.ename as "매니저 이름"
from emp e1, emp e2
where e1.mgr = e2.empno(+);
