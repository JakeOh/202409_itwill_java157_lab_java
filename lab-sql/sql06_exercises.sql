-- 과제
-- ex1. 직원 이름, 직원 근무 도시를 검색. 근무 도시 오름차순 정렬.
select
    e.ename, d.loc
from emp e
    join dept d on e.deptno = d.deptno
order by d.loc;

select
    e.ename, d.loc
from emp e, dept d
where e.deptno = d.deptno
order by d.loc;

-- left/right outer join
select
    e.ename, d.loc
from emp e, dept d
where e.deptno(+) = d.deptno
order by d.loc;

-- ex2. 직원 이름, 매니저 이름, 급여, 급여 등급을 검색.
--      정렬순서: (1)매니저, (2)급여 등급
select
    e1.ename as "직원", e2.ename as "매니저",
    e1.sal, s.grade
from emp e1
    join emp e2 on e1.mgr = e2.empno
    join salgrade s on e1.sal between s.losal and s.hisal
order by "매니저", s.grade;

select
    e1.ename as "직원", e2.ename as "매니저",
    e1.sal, s.grade
from emp e1, emp e2, salgrade s
where e1.mgr = e2.empno
    and e1.sal between s.losal and s.hisal
order by "매니저", s.grade;

-- ex3. 직원 이름, 부서 이름, 급여, 급여 등급을 검색.
--      정렬 순서: (1)부서 이름, (2)급여 등급
select
    e.ename, d.dname, e.sal, s.grade
from emp e
    join dept d on e.deptno = d.deptno
    join salgrade s on e.sal between s.losal and s.hisal
order by d.dname, s.grade;

select
    e.ename, d.dname, e.sal, s.grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno
    and e.sal between s.losal and s.hisal
order by d.dname, s.grade;

-- ex4. 부서 이름, 부서 위치, 부서의 직원수를 검색. 부서 번호 오름 차순.
select
    d.dname, d.loc, count(*) as "직원수"
from dept d
    join emp e on d.deptno = e.deptno
group by d.deptno, d.dname, d.loc
order by d.deptno;

select
    d.dname, d.loc, count(*) as "직원수"
from dept d, emp e
where d.deptno = e.deptno
group by d.deptno, d.dname, d.loc
order by d.deptno;

-- ex5. 부서 번호, 부서 이름, 부서 직원수, 부서의 급여 최솟값, 
--      부서의 급여 최댓값 검색. 부서 번호 오름 차순.
select
    d.deptno, d.dname, count(*) as "직원수", 
    min(sal) as "MIN_SAL", max(sal) as "MAX_SAL"
from dept d
    join emp e on d.deptno = e.deptno
group by d.deptno, d.dname
order by d.deptno;

select
    d.deptno, d.dname, count(*) as "직원수",
    min(sal) as "MIN_SAL", max(sal) as "MAX_SAL"
from emp e, dept d
where e.deptno = d.deptno
group by d.deptno, d.dname
order by d.deptno;

-- ex6. 부서 번호, 부서 이름, 사번, 이름, 매니저 사번, 매니저 이름, 
--      급여, 급여 등급을 검색. 급여가 2000 이상인 직원들만 검색.
--      정렬 순서: (1) 부서 번호, (2) 사번 오름차순.
select
    d.deptno, d.dname, 
    e1.empno as "사번", e1.ename as "직원 이름",
    e2.empno as "매니저 사번", e2.ename as "매니저 이름",
    e1.sal, s.grade
from dept d
    join emp e1 on d.deptno = e1.deptno
    join emp e2 on e1.mgr = e2.empno
    join salgrade s on e1.sal between s.losal and s.hisal
where e1.sal >= 2000
order by d.deptno, e1.empno;

select
    d.deptno, d.dname,
    e1.empno as "사번", e1.ename as "직원 이름",
    e2.empno as "매니저 사번", e2.ename as "매니저 이름",
    e1.sal, s.grade
from dept d, emp e1, emp e2, salgrade s
where d.deptno = e1.deptno
    and e1.mgr = e2.empno
    and e1.sal between s.losal and s.hisal
    and e1.sal >= 2000
order by d.deptno, e1.empno;
