/*
 * alter table: 테이블 (정의) 변경 - DDL
 * (1) 이름 변경: alter table ... rename ... to ...;
 * (2) 추가: alter table ... add ...;
 * (3) 삭제: alter table ... drop ...;
 * (4) 수정: alter table ... modify ...;
 */

-- 1. 이름 변경:
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


-- 4. 수정(modify)
