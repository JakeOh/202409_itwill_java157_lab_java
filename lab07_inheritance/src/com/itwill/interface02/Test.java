package com.itwill.interface02;

/*
 * 인터페이스의 멤버들 - Java 8 버전 이후의 변경 사항.
 * 1. [public static final] 필드 - 상수
 * 2. [public abstract] 메서드 - 추상 메서드
 * 3. [public] static 메서드 - Java 8 부터.
 *    -> 객체 생성 없이, 인터페이스 이름으로 참조해서 호출하는 메서드.
 */

public interface Test {
    // 1. [public static final] field
    int VERSION = 1;
    
    // 2. [public abstract] method
    void test();
    
    // 3. [public] static method
    static void staticMethod() {
        System.out.println("공개 정적(static) 메서드");
        System.out.println("------------------------");
    }
    
}
