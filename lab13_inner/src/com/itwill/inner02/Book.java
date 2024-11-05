package com.itwill.inner02;

public class Book {
    private String title; // 제목
    private String author; // 저자
    private String publisher; // 출판사
    
    // 생성자 overloading
    public Book() {}
    
    public Book(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }
    
    public Book(String title) {
        this(title, null, null); // overloading된 다른 생성자 호출.
//        this.title = title;
    }
    
//    public Book(String author) {}
//    public Book(String publisher) {}
    //-> Book(String title)과 파라미터 타입/개수가 같기 때문에 overloading할 수 없음!
    
    public Book(String title, String author) {
        this(title, author, null);
//        this.title = title;
//        this.author = author;
    }
    
//    public Book(String title, String publisher) {}
//    public Book(String author, String publisher) {}
    
}
