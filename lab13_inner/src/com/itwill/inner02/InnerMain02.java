package com.itwill.inner02;

public class InnerMain02 {

    public static void main(String[] args) {
        // Book 타입 변수 선언, 초기화.
        Book book1 = new Book("일론 머스크", "월터 아이작슨", "21세기북스");
        System.out.println(book1);
        
        // BookBuilder를 사용한 Book 타입 객체 생성:
        Book book2 = Book.builder()
                .title("일론 머스크")
                .author("월터 아이작슨")
                .publisher("21세기북스")
                .build();
        System.out.println(book2);

    }

}
