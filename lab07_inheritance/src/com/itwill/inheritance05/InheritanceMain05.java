package com.itwill.inheritance05;

/*
 * java.lang.Object 클래스: 자바의 최상위 클래스.
 * 자바의 모든 클래스는 Object 클래스를 확장(상속).
 * Object 클래스의 public 메서드들은 자바의 모든 클래스에서 사용할 수 있음.
 * Object 클래스의 final이 아닌 메서드들은 자바의 모든 클래스에서 override(재정의)를 할 수 있음.
 * (예) toString(), equals, hashCode(), ...
 */

class T {
    
}

public class InheritanceMain05 {
    
    public static void main(String[] args) {
        T t = new T();
        System.out.println(t.toString());
    }

}
