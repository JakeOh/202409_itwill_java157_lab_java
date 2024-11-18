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







