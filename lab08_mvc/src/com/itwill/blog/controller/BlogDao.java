package com.itwill.blog.controller;

import com.itwill.blog.model.Blog;

// MVC 아키텍쳐에서 Controller(기능, 로직)를 담당하는 인터페이스.
// DAO(Data Access Object)
public interface BlogDao {
    /**
     * 블로그(제목, 내용, 작성자)를 배열에 저장하는 메서드.
     * @param blog Blog 타입의 모델 객체. 제목, 내용, 작성자를 데이터로 갖는 객체.
     * @return 블로그 객체를 배열에 저장 성공하면 1, 실패하면 0을 리턴.
     */
    int create(Blog blog);
    
    /**
     * 블로그 전체 목록 검색.
     * @return 블로그들이 저장된 배열을 리턴.
     */
    Blog[] read();
    
    /**
     * 인덱스를 사용해서 블로그 1개를 검색.
     * @param index 검색에 필요한 인덱스. 0 이상의 정수.
     * @return 블로그 배열에서 index 위치에 있는 블로그 객체.
     */
    Blog read(int index);
    
    /**
     * 블로그 업데이트 기능. 해당 인덱스 위치의 블로그 제목과 내용을 업데이트.
     * @param index 업데이트할 블로그의 배열 인덱스. 0 이상의 정수.
     * @param blog 업데이트할 새로운 제목과 내용을 저장하고 있는 객체. 
     * @return 업데이트 성공하면 1, 실패하면 0.
     */
    int update(int index, Blog blog);

}
