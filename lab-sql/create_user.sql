-- Oracle 12c 버전부터 사용자 계정 이름을 "c##"을 접두사로 붙여서 사용하게끔 변경.
-- "c##" 접두사 없이 사용자 계정을 만들기 위해서.
alter session set "_ORACLE_SCRIPT" = true;

-- 아이디 hr, 비밀번호 hr인 사용자 계정을 생성.
create user hr identified by hr;

-- 생성된 사용자 계정에 권한을 부여.
grant dba to hr;
