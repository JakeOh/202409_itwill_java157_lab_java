package com.itwill.class03;

public class ClassMain03 {
    
    public static void main(String[] args) {
        // Person 타입의 변수를 선언, 기본 생성자(default constructor)를 호출해서 초기화.
        Person p1 = new Person();
        System.out.println("p1=" + p1); //-> package.ClassName@....
        System.out.println("p1.name=" + p1.name); //-> null
        System.out.println("p1.age=" + p1.age); //-> 0
        
        p1.name = "오쌤";
        p1.age = 16;
        p1.sayHello();
        
    }

}
