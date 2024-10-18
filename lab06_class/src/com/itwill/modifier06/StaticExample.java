package com.itwill.modifier06;

public class StaticExample {
    // field
    int x; // 인스턴스(static이 아닌) 필드 -> 힙(heap).
    static int y; // static 필드 -> 메서드(method) 영역.
    //-> 프로그램 로딩 시점에 메모리 메서드 영역에 변수가 생성되고, (기본값으로) 초기화됨.
    
    // 인스턴스(static이 아닌) 메서드
    public void printFields() {
        System.out.println("--- 인스턴스 메서드 ---");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("-----------------------");
    }
    
    // static 메서드
    public static void printFields2() {
        System.out.println("--- static 메서드 ---");
        // System.out.println("x = " + x); //-> static 메서드는 static이 아닌 멤버를 사용할 수 없음!
        System.out.println("y = " + y); //-> static 메서드는 static 멤버만 사용할 수 있음.
        System.out.println("---------------------");
    }

}
