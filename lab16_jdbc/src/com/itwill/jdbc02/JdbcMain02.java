package com.itwill.jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.oracle.OracleJdbc.*;

public class JdbcMain02 {

    public static void main(String[] args) {
        // insert 문장 실행, 결과 처리
        
        Scanner scanner = new Scanner(System.in); // 콘솔 입력
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 오라클 JDBC 드라이버를 등록(메모리에 로딩).
            DriverManager.registerDriver(new OracleDriver());
            
            // DB에 접속.
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Statement 객체 생성.
            final String sql = 
                    "insert into blogs (title, content, author, created_time, modified_time) "
                    + "values (?, ?, ?, systimestamp, systimestamp)";
            stmt = conn.prepareStatement(sql);
            
            // 제목, 내용, 작성자를 콘솔에서 입력받음.
            System.out.print("제목>>> ");
            String title = scanner.nextLine();
            
            System.out.print("내용>>> ");
            String content = scanner.nextLine();
            
            System.out.print("작성자>>> ");
            String author = scanner.nextLine();
            
            // PreparedStatement 인스턴스 SQL 문장에서 ? 부분을 입력받은 값으로 채움.
            stmt.setString(1, title); // 첫번째 ?를 title 값으로 채움.
            stmt.setString(2, content);
            stmt.setString(3, author);
            
            // SQL을 DB 서버로 전송해서 실행.
            int result = stmt.executeUpdate();
            System.out.println(result + "개 행이 삽입됐습니다.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제.
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
