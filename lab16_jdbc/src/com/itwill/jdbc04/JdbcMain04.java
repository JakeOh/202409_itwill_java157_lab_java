package com.itwill.jdbc04;

import static com.itwill.jdbc.oracle.OracleJdbc.PASSWORD;
import static com.itwill.jdbc.oracle.OracleJdbc.URL;
import static com.itwill.jdbc.oracle.OracleJdbc.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JdbcMain04 {

    public static void main(String[] args) {
        // delete 문장 실행, 결과 처리.
        // 삭제할 블로그 아이디를 입력받고, 해당 아이디의 블로그를 삭제.

        Scanner scanner = new Scanner(System.in);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            final String sql = "delete from blogs where id = ?";
            stmt = conn.prepareStatement(sql);
            
            System.out.print("삭제할 아이디>>> ");
            int id = Integer.parseInt(scanner.nextLine());
            stmt.setInt(1, id);
            
            int result = stmt.executeUpdate();
            System.out.println(result + "개 행이 삭제됐습니다.");
            
        } catch (Exception e) {
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
