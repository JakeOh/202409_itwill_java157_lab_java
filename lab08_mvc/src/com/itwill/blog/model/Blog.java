package com.itwill.blog.model;

// MVC(Model-View-Controller) 아키텍쳐에서 Model(데이터)을 담당하는 클래스.
// VO(Value Object): 값(데이터)를 저장하는 객체. 
// DTO(Data Transfer Object): 데이터를 전달할 때 사용하는 객체. 메서드의 파라미터 또는 리턴 타입으로 사용되는 객체.
public class Blog {
    private String title; // 제목
    private String content; // 내용
    private String author; // 작성자
    
    public Blog() {}
    
    public Blog(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    @Override
    public String toString() {
        return String.format("Blog(title=%s, content=%s, author=%s)", 
                title, content, author);
    }
    
}
