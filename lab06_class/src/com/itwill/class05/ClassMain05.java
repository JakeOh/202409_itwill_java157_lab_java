package com.itwill.class05;

public class ClassMain05 {

    public static void main(String[] args) {
        // Subject 타입 변수 선언, 초기화.
        Subject subject1 = new Subject();
        System.out.println(subject1);
        subject1.info();
        
        Subject subject2 = new Subject(100, 90, 85, 75);
        System.out.println(subject2);
        subject2.info();

    }

}
