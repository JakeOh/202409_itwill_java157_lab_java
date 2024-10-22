package com.itwill.inheritance04;

/*
 * final: 변경할 수 없는.
 * 1. final 지역 변수: 값을 초기화한 후에는 그 값을 변경할 수 없는(재할당할 수 없는) 지역 변수.
 * 2. final 필드: 반드시 한 번 명시적으로 초기화해야 하고, 초기화한 후에는 값을 변경할 수 없는 필드.
 *    (1) final 필드를 선언과 동시에 초기화.
 *    (2) 생성자에서 final 필드를 명시적으로 초기화.
 * 3. final 메서드: 변경할 수 없는 메서드. 재정의(override)할 수 없는 메서드.
 * 4. final 클래스: 변경할 수 없는 클래스. 상속(확장)할 수 없는 클래스.
 */

class A {
    public void test1() {
        System.out.println("test1");
    }
    
    public final void test2() {
        System.out.println("test2");
    }
}

class B extends A {
    @Override
    public void test1() {
        System.out.println("B overrides test1");
    }
    
//    public void test2() {
//        System.out.println("B overrides test2");
//    }
    //-> 상위 클래스에서 final로 선언된 메서드는 하위 클래스에서 override(재정의)할 수 없음!
}

class C {} // final이 아닌 클랫스.
class D extends C {} // final이 아닌 클래스는 상속(확장)할 수 있음.

final class E {} // final 클래스.
//class F extends E {} // final 클래스의 하위 클래스를 선언할 수 없음!

// JDK에 포함된 많은 클래스들이 final인 경우가 많음.
// class MyString extends String {}
// class MySystem extends System {}

public class InheritanceMain04 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
