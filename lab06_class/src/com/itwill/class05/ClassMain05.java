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
        
        // Student 타입 변수 선언, 초기화
        Student student1 = new Student();
        System.out.println(student1);
        student1.info();
        
        Student student2 = new Student(1, "오쌤", subject1);
        System.out.println(student2);
        student2.info();
        
        Student student3 = new Student(2, "김민석", subject2);
        student3.info();

    }

}
