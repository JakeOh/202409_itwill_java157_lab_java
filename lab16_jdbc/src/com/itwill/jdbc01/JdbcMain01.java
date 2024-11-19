package com.itwill.jdbc01;

/*
 * JDBC(Java Database Connectivity):
 * 자바 프로그램에서 데이터베이스 서버에 접속하고, SQL 문장을 실행해서 그 결과를 처리.
 * 
 * 1. Oracle JDBC 라이브러리(jar 파일)을 다운로드하고, 이클립스 프로젝트의 빌드 패스에 추가.
 *    (1) Oracle JDBC 다운로드 페이지에서 ojdbc17.jar 파일을 다운로드.
 *    (2) 이클립스 프로젝트에 lib 폴더를 만들고, 다운로드한 jar 파일을 복사.
 *    (3) jar 파일을 오른쪽 클릭 -> Build Path -> Add to build path
 * 2. 데이터베이스(Oracle) 서버에 접속하기 위한 정보들(URL, USER, PASSWORD)을 상수로 정의.
 * 3. 프로그램에서 JDBC 라이브러리를 메모리에 로딩.
 * 4. 데이터베이스 서버에 접속.
 * 5. Statement 타입 객체를 생성 - DB에서 실행할 SQL 문장을 작성하고 실행할 수 있는 객체.
 * 6. Statement 인스턴스의 메서드를 호출해서 SQL 문장을 실행.
 *    (1) executeQuery(): select 문장 실행.
 *    (2) executeUpdate(): insert/update/delete 문장 실행.
 * 7. 메서드 실행 결과(리턴 값)을 처리.
 * 8. 사용했던 모든 리소스들을 해제(close).
 */

public class JdbcMain01 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
