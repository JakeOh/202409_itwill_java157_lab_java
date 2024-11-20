package com.itwill.jdbc.controller;

import static com.itwill.jdbc.model.Blog.Entity.*;
import static com.itwill.jdbc.oracle.OracleJdbc.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.itwill.jdbc.model.Blog;

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
    
    private Blog getBlogFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt(COL_ID);
        String title = rs.getString(COL_TITLE);
        String content = rs.getString(COL_CONTENT);
        String author = rs.getString(COL_AUTHOR);
        Timestamp createdTime = rs.getTimestamp(COL_CREATED_TIME);
        Timestamp modifiedTime = rs.getTimestamp(COL_MODIFIED_TIME);
        
//        return new Blog(id, title, content, author, 
//                createdTime.toLocalDateTime(), modifiedTime.toLocalDateTime());
        return Blog.builder()
                .id(id)
                .title(title)
                .content(content)
                .author(author)
                .createdTime(createdTime)
                .modifiedTime(modifiedTime)
                .build();
    }
    
    // 전체 목록 보기에서 사용할 SQL 문장.
    private static final String SQL_SELECT_ALL = String.format(
            "select * from %s order by %s desc", 
            TBL_BLOGS, COL_ID);
    
    public List<Blog> read() {
        // DB 테이블에서 검색한 레코드들을 저장할 리스트를 생성.
        List<Blog> blogs = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // DB 서버에 접속.
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // DB 서버로 전송할 Statement 객체.
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            
            // SQL 문장을 DB 서버에서 실행하고, 그 결과를 처리.
            rs = stmt.executeQuery();
            while (rs.next()) {
                Blog blog = getBlogFromResultSet(rs);
                blogs.add(blog);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 사용했던 리소스들을 해제.
            closeResources(conn, stmt, rs);
        }
        
        return blogs;
    }
    
}
