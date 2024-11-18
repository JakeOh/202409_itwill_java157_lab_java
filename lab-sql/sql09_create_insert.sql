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
-- 영문자/숫자/특수기호 - 1byte. 한글 - 3 byte.
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
