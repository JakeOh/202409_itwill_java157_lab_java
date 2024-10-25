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
    
    /**
     * 블로그를 저장하는 배열이 가득 차 있으면 true, 빈 공간(null)이 있으면 false를 리턴.
     * @return true/false
     */
    public boolean isMemoryFull() {
        return (count == MAX_LENGTH);
    }
    
    @Override
    public int create(Blog blog) {
        if (isMemoryFull()) {
            return 0;
        }
        
        // 배열 blogs에 원소를 저장하고 count를 증가.
        blogs[count] = blog;
        count++;
        
        return 1;
    }

    @Override
    public Blog[] read() {
        // 배열 blogs에서 null이 아닌 원소들만 복사해서 리턴.
        Blog[] result = new Blog[count]; // 현재까지 저장된 원소 개수로 배열을 생성.
        for (int i = 0; i < count; i++) {
            result[i] = blogs[i]; // 배열 blogs의 원소를 result에 복사.
        }
        
        return result;
    }

    @Override
    public Blog read(int index) {
        
        return blogs[index];
    }

    @Override
    public int update(int index, Blog blog) {
        blogs[index].setTitle(blog.getTitle());
        blogs[index].setContent(blog.getContent());
        
        return 1;
    }

}
