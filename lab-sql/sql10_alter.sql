/*
 * alter table: 테이블 (정의) 변경 - DDL
 * 1. 이름 변경: alter table ... rename ... to ...;
 * 2. 추가: alter table ... add ...;
 * 3. 삭제: alter table ... drop ...;
 * 4. 수정: alter table ... modify ...;
 */

-- 1. 이름 변경(rename)
-- (1) 테이블 이름 변경: 테이블 ex_students를 students로 이름 변경.
alter table ex_students rename to students;

-- (2) 테이블 컬럼 이름 변경: students 테이블에서 컬럼 stuno를 student_id로 이름 변경.
alter table students rename column stuno to student_id;

-- students 테이블에서 컬럼 stuname을 student_name으로 이름 변경.
alter table students rename column stuname to student_name;

describe students; -- Oracle: 컬럼 이름, Null 가능 여부, 데이터 타입.

-- (3) 제약조건 이름 변경: ex_emp1 테이블에서 제약조건 SYS_C008351을 pk_emp1로 이름 변경.
alter table ex_emp1 rename constraint SYS_C008351 to pk_emp1;


-- 2. 추가(add)
-- (1) 제약조건 추가: students 테이블의 student_id 컬럼에 PK 제약조건을 추가.
alter table students add constraint pk_students primary key (student_id);

-- students 테이블의 student_name 컬럼에 NN 제약조건을 추가.
alter table students 
add constraint nn_students check (student_name is not null);

-- (2) 컬럼 추가: students 테이블에 department_id(2자리 정수) 컬럼 추가.
alter table students add department_id number(2, 0);
describe students;

--> add column은 문법 오류:
-- alter table students add column professor varchar2(10 char);


-- 3. 삭제(drop)
-- 제약조건 메타 테이블에서 제약조건 이름 검색:
-- (주의) 메타 테이블에서 테이블 이름, 컬럼 이름, 제약조건 이름은 대문자로 저장되어 있음.
select constraint_name from user_constraints 
where table_name = 'STUDENTS';

-- (1) 제약조건 삭제: students 테이블에서 nn_students 제약조건을 삭제.
alter table students drop constraint nn_students;

-- (2) 컬럼 삭제: students 테이블에서 birthday 컬럼을 삭제.
alter table students drop column birthday;
describe students;


-- 4. 수정(modify): 컬럼 정의(데이터 타입, 기본값, null 여부)를 수정.
-- students 테이블에서 student_name 컬럼의 데이터 타입을
-- varchar2(5 char)에서 varchar2(40 char)로 변경 & NN 제약조건 추가.
alter table students modify student_name varchar2(40 char) not null;
desc students;
-- describe students;

-- students 테이블에서 department_id 컬럼의 데이터 타입을 number(4)로 변경
-- check (department_id between 1000 and 9999) 제약조건을 추가.
alter table students
modify department_id number(4, 0)
    constraint ck_departmetn_id check (department_id between 1000 and 9999);

-- modify 구문은 제약조건의 정의 변경할 수 없음.
-- drop constraint 구문으로 제약조건을 삭제하고, add constraint로 제약조건 추가.


-- DDL(Data Definition Language): create, alter, truncate, drop
-- create table as select 구문: 테이블 모양(컬럼, 데이터 타입)과 데이터를 복사.
-- emp 테이블을 ex_emp6으로 복사
create table ex_emp6
as select * from emp;

select * from ex_emp6;

-- emp 테이블에서 사번이 1004인 직원을 제외하고 새로운 ex_emp7 테이블로 복사.
create table ex_emp7
as select * from emp where empno != 1004;

select * from ex_emp7;

-- emp 테이블 컬럼 이름, 데이터 타입이 모두 같은 새로운 테이블 ex_emp8을 생성.
-- 데이터는 복사하지 않고.
create table ex_emp8
as select * from emp where empno = -1;

select * from ex_emp8;

-- emp 테이블에서 empno, ename, sal, comm 컬럼을 복사해서 새로운 테이블 ex_emp9을 생성.
create table ex_emp9
as select empno, ename, sal, comm from emp;

select * from ex_emp9;


-- truncate table 테이블이름;
-- 테이블의 모든 행을 삭제하는 DDL.
truncate table ex_emp9;
select * from ex_emp9;

-- drop table 테이블이름;
-- 테이블을 데이터베이스에서 삭제하는 DDL.
drop table ex_emp9;
