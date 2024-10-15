package com.itwill.class04;

public class ClassMain04 {

    public static void main(String[] args) {
        // Rectangle 타입 변수 선언, 기본 생성자로 초기화
        Rectangle rect1 = new Rectangle();
        System.out.println(rect1);
        
        // Rectangle 객체의 메서드 호출
        System.out.println("rect1 넓이 = " + rect1.area());
        System.out.println("rect1 둘레 = " + rect1.perimeter());
        
        // Rectangle 타입의 변수 선언, 아규먼트를 갖는 생성자로 초기화.
        Rectangle rect2 = new Rectangle(4, 3);
        System.out.println(rect2);
        System.out.println("rect2 넓이 = " + rect2.area());
        System.out.println("rect2 둘레 = " + rect2.perimeter());
        
    }

}
