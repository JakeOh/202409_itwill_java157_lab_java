package com.itwill.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

// MVC 아키텍쳐 Controller를 담당하는 객체. DAO(Data Access Object).
// DB 테이블에서 select, insert, update, delete 쿼리를 실행하고 결과를 리턴하는 기능.
public enum BlogDao {
    INSTANCE; // BlogDao 타입의 싱글톤(singleton) 객체.
    
    // 생성자 - enum 타입의 생성자는 private만 가능. private은 생략.
    BlogDao() {
        try {
            // 오라클 JDBC 드라이버(라이브러리)를 등록(메모리에 로딩).
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void closeResources(Connection conn, Statement stmt) {
        closeResources(conn, stmt, null);
    }
    
}
