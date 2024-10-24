package com.itwill.interface02;

/*
 * 인터페이스의 멤버들 - Java 8 버전 이후의 변경 사항.
 * 1. [public static final] 필드 - 상수
 * 2. [public abstract] 메서드 - 추상 메서드
 * 3. [public] static 메서드 - Java 8 부터.
 *    -> body가 있는 메서드.
 *    -> 객체 생성 없이, 인터페이스 이름으로 참조해서 호출하는 메서드.
 * 4. [public] default 메서드 - Java 8 부터.
 *    -> body가 있는 메서드.
 *    -> 인터페이스를 구현한 하위 타입의 객체를 생성한 후에 호출할 수 있는 메서드.
 * 5. private static 메서드 - Java 9 부터.
 *    -> body가 있는 메서드.
 *    -> [public] static 메서드와 default 메서드에서 사용하기 위한 비공개 메서드.
 * 6. private 메서드 - Java 9 부터.
 *    -> body가 있는 메서드.
 *    -> default 메서드에서만 호출하기 위한 목적의 메서드.
 */

public interface Test {
    // 1. [public static final] field
    int VERSION = 1;
    
    // 2. [public abstract] method
    void test();
    
    // 3. [public] static method
    static void staticMethod() {
        System.out.println("공개 정적(public static) 메서드");
        privateStaticMethod();
        //privateInstanceMethod(); //-> static 메서드 안에서 static이 아닌 메서드를 호출할 수 없음.
        System.out.println("-------------------------------");
    }
    
    // 4. [public] default method
    default void defaultMethod() {
        System.out.println("공개 기본(public default) 메서드");
        privateStaticMethod();
        privateInstanceMethod();
        System.out.println("--------------------------------");
    }
    
    // 5. private static method
    private static void privateStaticMethod() {
        System.out.println(">>> 비공개 static 메서드");
        //privateInstanceMethod();
    }
    
    // 6. private method
    private void privateInstanceMethod() {
        System.out.println(">>> 비공개 인스턴스(body가 구현된) 메서드");
    }
    
}
