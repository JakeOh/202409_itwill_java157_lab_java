package com.itwill.jdbc.controller;

import static com.itwill.jdbc.model.Blog.Entity.COL_AUTHOR;
import static com.itwill.jdbc.model.Blog.Entity.COL_CONTENT;
import static com.itwill.jdbc.model.Blog.Entity.COL_CREATED_TIME;
import static com.itwill.jdbc.model.Blog.Entity.COL_ID;
import static com.itwill.jdbc.model.Blog.Entity.COL_MODIFIED_TIME;
import static com.itwill.jdbc.model.Blog.Entity.COL_TITLE;
import static com.itwill.jdbc.model.Blog.Entity.TBL_BLOGS;
import static com.itwill.jdbc.oracle.OracleJdbc.PASSWORD;
import static com.itwill.jdbc.oracle.OracleJdbc.URL;
import static com.itwill.jdbc.oracle.OracleJdbc.USER;

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
// CRUD(Create, Read, Update, Delete):
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
    
    // Read(select 문장)을 실행하는 메서드.
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
    
    // 새 블로그 작성에서 사용할 SQL 문장.
    private static final String SQL_INSERT = String.format(
            "insert into %s (%s, %s, %s, %s, %s) values (?, ?, ?, systimestamp, systimestamp)", 
            TBL_BLOGS, COL_TITLE, COL_CONTENT, COL_AUTHOR, COL_CREATED_TIME, COL_MODIFIED_TIME);
    
    // Create(insert 문장)을 실행하는 메서드.
    public int create(Blog blog) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // DB 서버에 접속.
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Statement 객체 생성.
            stmt = conn.prepareStatement(SQL_INSERT);
            
            // PreparedStatement의 파라미터(?)를 값으로 채움(parameter binding).
            stmt.setString(1, blog.getTitle());
            stmt.setString(2, blog.getContent());
            stmt.setString(3, blog.getAuthor());
            
            // SQL 문장을 DB 서버에서 실행.
            result = stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 사용했던 리소스 해제.
            closeResources(conn, stmt);
        }
        
        return result;
    }
    
    // 블로그 아이디(PK)로 행 1개를 삭제하는 SQL.
    private static final String SQL_DELETE_BY_ID = String.format(
            "delete from %s where %s = ?", 
            TBL_BLOGS, COL_ID);
    
    // Delete를 실행하는 메서드.
    public int delete(Integer id) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // DB 접속.
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // Statement 생성.
            stmt = conn.prepareStatement(SQL_DELETE_BY_ID);
            
            // PreparedStatement parameter binding
            stmt.setInt(1, id);
            
            // SQL 실행
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }
    
    // 블로그 아이디(PK)로 행 1개를 검색하는 SQL.
    // select * from blogs where id = ?
    private static final String SQL_SELECT_BY_ID = String.format(
            "select * from %s where %s = ?", 
            TBL_BLOGS, COL_ID);
    
    // PK로 검색하는 메서드.
    public Blog read(Integer id) {
        Blog blog = null;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            if (rs.next()) {
                blog = getBlogFromResultSet(rs);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return blog;
    }
    
    // 해당 블로그 아이디의 제목, 내용, 수정시간을 업데이튼 하는 SQL.
    // update blogs set title = ?, content = ?, modified_time = systimestamp where id = ?
    private static final String SQL_UPDATE_BY_ID = String.format(
            "update %s set %s = ?, %s = ?, %s = systimestamp where %s = ?", 
            TBL_BLOGS, COL_TITLE, COL_CONTENT, COL_MODIFIED_TIME, COL_ID);
    
    // private int update(String title, String content, Integer id) {}
    public int update(Blog blog) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            stmt = conn.prepareStatement(SQL_UPDATE_BY_ID);
            stmt.setString(1, blog.getTitle());
            stmt.setString(2, blog.getContent());
            stmt.setInt(3, blog.getId());
            
            result = stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }
    
    // 대/소문자 구분없이 제목에 포함된 문자열로 검색하기.
    // "select * from %s where upper(%s) like upper('%%' || ? || '%%') order by %s desc"
    private static final String SQL_SELECT_BY_TITLE = String.format(
            "select * from %s where upper(%s) like upper(?) order by %s desc",
            TBL_BLOGS, COL_TITLE, COL_ID);
    
    // 대/소문자 구분없이 내용에 포함된 문자열로 검색하기.
    private static final String SQL_SELECT_BY_CONTENT = String.format(
            "select * from %s where upper(%s) like upper(?) order by %s desc", 
            TBL_BLOGS, COL_CONTENT, COL_ID);
    
    // 대/소문자 구분없이 작성자에 포함된 문자열로 검색하기.
    private static final String SQL_SELECT_BY_AUTHOR = String.format(
            "select * from %s where upper(%s) like upper(?) order by %s desc", 
            TBL_BLOGS, COL_AUTHOR, COL_ID);
    
    // 대/소문자 구분없이 제목 또는 내용에 포함된 문자열로 검색하기.
    private static final String SQL_SELECT_BY_TITLE_OR_CONTENT = String.format(
            "selct * from %s where upper(%s) like upper(?) or upper(%s) like upper(?) order by %s desc", 
            TBL_BLOGS, COL_TITLE, COL_CONTENT, COL_ID);
    
    // 제목, 내용, 제목+내용, 작성자 검색을 수행하는 메서드.
    public List<Blog> read(int type, String keyword) {
        List<Blog> result = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            // like 검색을 사용하기 위해서, 검색어에 "%"를 붙임.
            String searchKeyword = "%" + keyword + "%";
            switch (type) {
            case 0: // 제목 검색
                stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE);
                stmt.setString(1, searchKeyword);
                break;
            case 1: // 내용 검색
                stmt = conn.prepareStatement(SQL_SELECT_BY_CONTENT);
                stmt.setString(1, searchKeyword);
                break;
            case 2: // 제목+내용 검색
                stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE_OR_CONTENT);
                stmt.setString(1, searchKeyword);
                stmt.setString(2, searchKeyword);
                break;
            case 3: // 작성자 검색
                stmt = conn.prepareStatement(SQL_SELECT_BY_AUTHOR);
                stmt.setString(1, searchKeyword);
                break;
            }
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                Blog blog = getBlogFromResultSet(rs);
                result.add(blog);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return result;
    }
    
}
