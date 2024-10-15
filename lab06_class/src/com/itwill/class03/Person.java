package com.itwill.class03;

public class Person {
    // field(필드)
    String name;
    int age;
    
    // constructor(생성자)
    public Person() {
        
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // method(메서드)
    public void sayHello() {
        System.out.println("안녕하세요, 저는 " + this.name + "입니다.");
        System.out.println("제 나이는 " + this.age + "입니다.");
    }
    
}
