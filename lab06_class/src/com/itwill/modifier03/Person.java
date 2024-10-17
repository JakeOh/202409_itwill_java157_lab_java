package com.itwill.modifier03;

public class Person {
    // field
    private String name; // 읽기 전용
    private int age; // 읽기/쓰기 가능
    
    // constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // getter & setter
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            // 경고 메시지를 출력하거나 예외(Exception) 발생
        }
    }

}
