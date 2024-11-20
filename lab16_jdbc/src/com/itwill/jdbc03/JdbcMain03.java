package com.itwill.jdbc03;

import static com.itwill.jdbc.oracle.OracleJdbc.PASSWORD;
import static com.itwill.jdbc.oracle.OracleJdbc.URL;
import static com.itwill.jdbc.oracle.OracleJdbc.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JdbcMain03 {

    public static void main(String[] args) {
        // update 문장 실행, 결과 처리
        // 해당 id의 제목(title)과 내용(content)을 업데이트.
        
        Scanner scanner = new Scanner(System.in);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 1. 오라클 JDBC 드라이버를 등록(메모리에 로딩).
            DriverManager.registerDriver(new OracleDriver());
            
            // 2. 오라클 데이터베이스 서버 접속.
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // 3. Statement 객체 생성.
            final String sql = 
                    "update blogs "
                    + "set title = ?, content = ?, modified_time = systimestamp "
                    + "where id = ?";
            stmt = conn.prepareStatement(sql);
            
            // 업데이트할 블로그 글의 아이디, 제목, 내용을 입력받음.
            System.out.print("blog id>>> ");
            int id = Integer.parseInt(scanner.nextLine());
            
            System.out.print("제목>>> ");
            String title = scanner.nextLine();
            
            System.out.print("내용>>> ");
            String content = scanner.nextLine();
            
            // PreparedStatement 객체에서 ? 부분을 입력 값들로 채움(binding).
            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setInt(3, id);
            
            // 4. SQL을 데이터베이스 서버에서 실행.
            int result = stmt.executeUpdate();
            System.out.println(result + "개 행이 업데이트됐습니다.");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. 리소스들을 해제.
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
