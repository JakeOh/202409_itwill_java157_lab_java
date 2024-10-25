package com.itwill.blog.controller;

import com.itwill.blog.model.Blog;

// MVC 아키텍쳐에서 Controller 역할을 담당하는 구현 클래스.
public class BlogDaoImpl implements BlogDao {
    
    //-----> singleton 구현 시작
    private static BlogDaoImpl instance = null;
    
    private BlogDaoImpl() {}
    
    public static BlogDaoImpl getInstance() {
        if (instance == null) {
            instance = new BlogDaoImpl();
        }
        
        return instance;
    }
    //<----- singleton 구현 끝

    private static final int MAX_LENGTH = 3; // 블로그 배열의 길이(원소 개수).
    
    private Blog[] blogs = new Blog[MAX_LENGTH]; // 블로그들을 저장할 배열.
    
    private int count = 0; // 배열 blogs에 저장된 원소 개수. 새 블로그가 저장될 때마다 ++.
    
    @Override
    public int create(Blog blog) {
        // 배열 blogs에 원소를 저장하고 count를 증가.
        blogs[count] = blog;
        count++;
        
        return 1;
    }

    @Override
    public Blog[] read() {
        System.out.println("블로그 목록 보기");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Blog read(int index) {
        System.out.println("블로그 상세 보기");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int update(int index, Blog blog) {
        System.out.println("블로그 업데이트");
        // TODO Auto-generated method stub
        return 0;
    }

}
