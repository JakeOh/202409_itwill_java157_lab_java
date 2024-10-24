package com.itwill.singleton;

/*
 * 싱글톤(singleton): 힙에 오직 한 개만 존재하는 객체.
 * 싱글톤 디자인 패턴(singleton design pattern):
 *   클래스를 설계할 때 객체를 오직 하나만 생성할 수 있도록 하는 방법.
 *   (1) private static field - 싱글톤 객체의 참조값(주소)를 저장하기 위해서.
 *   (2) private constructor - 다른 클래스에서 객체를 생성할 수 없도록.
 *   (3) public static method - 싱글톤 객체 생성, 리턴.
 */

public class SingletonMain {

    public static void main(String[] args) {
        Captain captain1 = Captain.getInstance();
        System.out.println("captain1 = " + captain1);
        
        Captain captain2 = Captain.getInstance();
        System.out.println("captain2 = " + captain2);
        System.out.println("captain2 name = " + captain2.getName());
        
        captain2.setName("아이언맨");
        System.out.println("captain2 name = " + captain2.getName());
        System.out.println("captain1 name = " + captain1.getName());
    }

}
