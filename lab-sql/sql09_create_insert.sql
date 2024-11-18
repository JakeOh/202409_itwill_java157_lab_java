/*
 * SQL 종류:
 * (1) DQL(Data Query Language): select
 * (2) DDL(Data Definition Language): create, alter, trunctate, drop
 * (3) DML(Data Manipulation Language): insert, update, delete
 * (4) TCL(Transaction Control Language): commit, rollback
 *     - commit: 데이터베이스 테이블의 변경 내용을 영구히 저장.
 *     - rollback: 직전 commit 상태로 되돌리기.
 *
 * 테이블 생성:
 * create table 테이블이름 (
 *     컬럼이름 데이터타입 [제약조건 기본값],
 *     ...
 * );
 *
 * 데이터 타입으로 사용되는 키워드들은 데이터베이스 종류에 따라서 다름.
 * Oracle 데이터 타입: number, varchar2(가변길이 문자열), date, timestamp, 
 *                     clob(character large object), blob(binary large object), ...
 */

/*
 * 테이블 이름: ex_students
 * 컬럼:
 *   - stuno: 학생 번호. 숫자(6자리 정수).
 *   - stuname: 학생 이름. 문자열(최대 5글자).
 *   - birthday: 학생 생일. 날짜.
 */
create table ex_students (
    stuno       number(6, 0),
    stuname     varchar2(5 char),
    birthday    date
);


/*
 * 테이블에 행(row)을 추가: insert
 * insert into 테이블 (컬럼, ...) values (값, ...);
 *
 * 테이블에 삽입하는 값들의 개수가 컬럼 개수와 같고, 
 * 값들의 순서가 테이블을 만들 때 컬럼 순서와 같으면
 * insert into 테이블 values (값, ...);
 */

insert into ex_students (stuno, stuname)
values (1, '홍길동');

insert into ex_students (stuno, stuname, birthday)
values (2, '오쌤', '2000/11/18');
--> 오라클은 문자열을 날짜 타입으로 자동 변환해서 insert를 수행.

-- values의 개수가 컬럼 개수와 같고, 순서가 테이블 컬럼의 순서와 같은 경우:
insert into ex_students
values (3, 'Qwert', sysdate);

insert into ex_students
values(4, 'Qwer');
--> ORA-00947: 값의 수가 충분하지 않습니다.

insert into ex_students (stuno) values (1234567);
--> ORA-00947: 값의 수가 충분하지 않습니다.
--> stuno는 6자리까지만 가능한데, 7자리 정수를 insert하려고 해서 오류.

insert into ex_students (stuname) values ('Asdfgh');
--> ORA-12899: "SCOTT"."EX_STUDENTS"."STUNAME" 열에 대한 값이 너무 큼(실제: 6, 최대값: 5)

insert into ex_students values (10, '홍길동', 'yyyy/mm/dd');
--> ORA-01841: 년은 영이 아닌 -4713 과 +4713 사이의 값으로 지정해야 합니다.
--> 날짜 타입으로 변환할 수 없는 문자열을 insert하려고 해서 오류.

insert into ex_students (birthday, stuno, stuname)
values ('1999/12/31', 100, '홍길동');

commit;

select * from ex_students;

-- 문자열 타입 varchar2 단위: char(글자수), byte(바이트)
-- 오라클에서 문자열을 저장할 때 인코딩을 utf-8을 사용하는 경우,
-- 영문자/숫자/특수기호 - 1 byte. 한글 - 3 byte.
-- varchar2의 기본 단위는 byte! 단위를 생략하면 byte로 취급.
-- (예) varchar2(10) = varchar2(10 byte)
create table ex_byte (
    stuname varchar2(5 byte)
);

insert into ex_byte values ('asdfg');
--> insert 성공

insert into ex_byte values('길동');
--> ORA-12899: "SCOTT"."EX_BYTE"."STUNAME" 열에 대한 값이 너무 큼(실제: 6, 최대값: 5)

select * from ex_byte;

commit;

/*
 * 제약조건(constraint) 종류:
 * (1) primary key(PK, 고유키): 테이블에서 유일한 행 1개를 검색할 수 있는 컬럼(들).
 *     - PK인 컬럼은 null 값을 가질 수 없고, 중복되는 값을 가질 수 없음.
 * (2) not null(NN): 반드시 값을 가져야 하는 컬럼. null 값을 가질 수 없는 컬럼.
 * (3) unique: 중복된 값을 가질 수 없는 컬럼. null은 가질 수 있음.
 * (4) check: 컬럼의 값이 조건을 만족하는 값들로만 제한.
 * (5) foreign key(FK, 외래키): 다른 테이블의 PK를 참조하는 컬럼.
 *     - (예) emp 테이블에서 deptno 컬럼 - FK. dept 테이블에서 deptno 컬럼 - PK.
 */

-- 테이블을 생성할 때 제약조건 만들기 1: 제약조건 이름을 설정하지 않는 경우.
-- 오라클에서 제약조건의 이름을 자동으로 부여. (예) SYS_C001234
create table ex_emp1 (
    eno     number(4, 0) primary key,
    ename   varchar2(5 char) not null,
    email   varchar2(100 char) unique,
    age     number(3, 0) check (age >= 0),
    memo    varchar2(100 char)
);

insert into ex_emp1
values (1001, '홍길동', 'hgd@itwill.com', 20, '안녕하세요');

insert into ex_emp1 (eno, ename)
values (1001, '홍길동');
--> ORA-00001: 무결성 제약 조건(SCOTT.SYS_C008351)에 위배됩니다
--> PK 제약조건을 위배 - 중복된 값은 insert될 수 없음.

-- 제약조건을 설정하는 이유: 데이터의 무결성을 유지하기 위해서.

insert into ex_emp1 (eno, ename)
values (null, '홍길동');
--> ORA-01400: NULL을 ("SCOTT"."EX_EMP1"."ENO") 안에 삽입할 수 없습니다
--> PK 제약조건을 위배 - null이 될 수 없음.

insert into ex_emp1 (eno) values (2001);
--> ORA-01400: NULL을 ("SCOTT"."EX_EMP1"."ENAME") 안에 삽입할 수 없습니다
--> NN 제약조건을 위배.

insert into ex_emp1 (eno, ename, email)
values (1002, '홍길동', 'hgd@itwill.com');
--> ORA-00001: 무결성 제약 조건(SCOTT.SYS_C008352)에 위배됩니다
--> unique 제약조건 위배 - email 컬럼은 중복된 값을 가질 수 없음.

insert into ex_emp1(eno, ename, age)
values (1003, '홍길동', -1);
--> ORA-02290: 체크 제약조건(SCOTT.SYS_C008350)이 위배되었습니다
--> age 컬럼은 0 이상의 정수만 insert 가능.

select * from ex_emp1;

commit;


-- 테이블을 생성할 때 제약조건 만들기 2: 제약조건 이름 설정.
create table ex_emp2 (
    id      number(4, 0) 
            constraint pk_ex_emp2_id primary key,
    ename   varchar2(5 char) 
            constraint nn_ex_emp2_ename not null,
    email   varchar2(100 char) 
            constraint uq_ex_emp2_email unique,
    age     number(3, 0) 
            constraint ck_ex_emp2_age check (age >= 0),
    memo    varchar2(100 char)
);

-- 테이블을 생성할 때 제약조건 만들기 3: 컬럼 정의 따로, 제약조건 정의 따로.
create table ex_emp3 (
    -- 컬럼 정의(컬럼 이름, 데이터 타입, 기본값)
    id      number(4, 0),
    ename   varchar2(5 char),
    email   varchar2(100 char),
    age     number(3, 0),
    memo    varchar2(100 char),
    -- 제약조건 정의(제약조건 이름, 내용)
    constraint pk_ex_emp3_id primary key (id),
    constraint nn_ex_emp3_ename check (ename is not null),
    constraint uq_ex_emp3_email unique (email),
    constraint ck_ex_emp3_age check (age >= 0)
);

-- Foreign Key(FK, 외래키): 다른 테이블의 PK를 참조하는 제약조건.
-- ex_emp4 테이블의 deptno 컬럼 - FK, ex_dept 테이블의 deptno 컬럼 - PK.
-- PK를 갖는 테이블을 먼저 생성, 그 PK를 참조하는 FK를 갖는 테이블을 나중에 생성.

-- (1) PK를 갖는 테이블 생성.
create table ex_dept (
    deptno  number(2, 0),
    dname   varchar2(10 char),
    constraint pk_ex_dept_deptno primary key (deptno),
    constraint nn_ex_dept_dname check (dname is not null)
);

-- (2) 다른 테이블의 PK를 참조하는 FK를 갖는 테이블을 생성.
create table ex_emp4 (
    id      number(4, 0)
            constraint pk_ex_emp4_id primary key,
    ename   varchar2(5 char)
            constraint nn_ex_emp4_ename not null,
    deptno  number(2, 0)
            constraint fk_ex_emp4_deptno references ex_dept (deptno)
);


