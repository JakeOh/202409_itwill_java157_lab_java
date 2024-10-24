package com.itwill.interface04;

class A {}
class B extends A {}
class C extends B {}

class D {}
class E {}
// class F extends D, E {} //-> Java는 다중 상속을 지원하지 않음.

interface I {}
interface J {}
class K implements I, J {} //-> 구현하는 인터페이스의 개수는 제한이 없음.

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
    }

}
