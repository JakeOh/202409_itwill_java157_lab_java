package com.itwill.inheritance02;

public class InheritanceMain02 {

    public static void main(String[] args) {
        // BusinessPerson 타입 객체 선언, 초기화.
        BusinessPerson p1 = new BusinessPerson();
        
        System.out.println("-----");
        
        BusinessPerson p2 = new BusinessPerson("아이티윌");

        System.out.println("-----");
        
        BusinessPerson p3 = new BusinessPerson("오쌤", "아이티윌");
    }

}
