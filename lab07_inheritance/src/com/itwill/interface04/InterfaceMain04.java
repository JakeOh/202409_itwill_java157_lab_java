package com.itwill.interface04;

class A {}
class B extends A {}
class C extends B {}

class D {}
class E {}
// class F extends D, E {} //-> Java는 클래스 다중 상속을 지원하지 않음.

interface I {}
interface J {}
class K implements I, J {} //-> 클래스가 구현하는 인터페이스의 개수는 제한이 없음.

// interface L implements I {} //-> 인터페이스는 다른 인터페이스를 "구현"할 수 없음.
interface L extends I {} // 인터페이스는 다른 인터페이스를 "확장(상속)"할 수 있음.
interface M extends I, J {} // 인터페이스는 확장하는 인터페이스 개수 제한이 없음. 인터페이스는 다중 상속 가능.

class N extends A implements I, J {}

interface Clickable {
    void click();
}

interface Scrollable {
    void scroll();
}

class Mouse implements Clickable, Scrollable {
    @Override
    public void scroll() {
        System.out.println("마우스 휠 스크롤");
    }

    @Override
    public void click() {
        System.out.println("마우스 버튼 클릭");
    }
}

public class InterfaceMain04 {

    public static void main(String[] args) {
        // 다형성:
        A a = new A();
        B b = new B();
        A b2 = new B();
        C c = new C();
        B c2 = new C();
        A c3 = new C();
        Object o = new C(); // System.out.println(Object x)
        
        K k = new K();
        I k2 = new K(); // InterfaceName varName = new ImplementClass(); - 다형성
        J k3 = new K(); // 인터페이스: super type, 구현 클래스: sub type.
        
        // Mouse 타입 객체 생성:
        Mouse m1 = new Mouse();
        m1.click();
        m1.scroll();
        
        // 다형성
        Clickable m2 = new Mouse();
        m2.click();
        if (m2 instanceof Mouse) {
            ((Mouse) m2).scroll();
        }
        
    }

}
