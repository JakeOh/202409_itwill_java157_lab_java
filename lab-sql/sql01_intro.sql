/*
 * 블록 주석(block comment).
 * 워크시트: SQL 문장들을 저장하는 파일. 스크립트.
 * Alt+F10: 새 워크시트(빈 파일) 생성.
 * Ctrl+Enter: SQL 문장 실행.
 *   (1) 커서가 있는 위치의 한 문장을 실행.
 *   (2) 마우스 드래그로 선택된 문장을 실행.
 * F5: 스크립트(파일) 전체 실행.
 *
 * SQL(Structured Query Language): 관계형 데이터베이스 시스템에서 데이터를 
 * 관리하기 위한 언어.
 * SQL 키워드는 대/소문자를 구분하지 않음.
 * (주의) 문자열을 비교할 때는 대/소문자를 구분함!
 * SQL 문장은 세미콜론(;)으로 끝남.
 */
-- 한 줄 주석(inline comment).

select sysdate from dual;
SELECT sysdate FROM dual;
SELECT SYSDATE FROM DUAL;
