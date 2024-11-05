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
    
    @Override
    public String toString() {
        return String.format("Book(title=%s, author=%s, publisher=%s)", 
                title, author, publisher);
    }
    
    //---> Builder(Factory) 디자인 패턴
    // (2) static 메서드 -> static 내부 클래스 타입 객체를 리턴.
    public static BookBuilder builder() {
        return new BookBuilder();
        //-> 외부 클래스는 내부 클래스의 private 생성자를 호출할 수 있음!
    }
    
    // (1) static 내부 클래스 -> 외부 클래스 타입의 객체(Book)를 생성하는 기능.
    public static class BookBuilder {
        // (3) 외부 클래스 객체를 생성할 때 필요한 필드들을 선언.
        private String title;
        private String author;
        private String publisher;
        
        // (4) private 생성자 -> (외부 클래스를 제외한) 다른 클래스에서는 객체 생성을 못하게 하기 위해서.
        private BookBuilder() {}
        
        // (5) 필드의 값을 변경하는, 내부 클래스 타입을 리턴하는 메서드들
        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }
        
        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }
        
        public BookBuilder publisher(String publisher) {
            this.publisher = publisher;
            return this;
        }
        
        // (6) 외부 클래스 타입을 리턴하는 메서드
        public Book build() {
            return new Book(title, author, publisher);
        }
    }
    
}
