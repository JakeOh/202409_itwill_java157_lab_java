package com.itwill.inheritance05;

/*
 * java.lang.Object 클래스: 자바의 최상위 클래스.
 * 자바의 모든 클래스는 Object 클래스를 확장(상속).
 * Object 클래스의 public 메서드들은 자바의 모든 클래스에서 사용할 수 있음.
 * Object 클래스의 final이 아닌 메서드들은 자바의 모든 클래스에서 override(재정의)를 할 수 있음.
 * (예) toString(), equals(), hashCode(), ...
 * - toString() 메서드: 객체의 문자열 표현식을 리턴.
 *   "패키지이름.클래스이름@참조값" 형식의 문자열을 만들어서 리턴.
 *   System.out.println(Object x) 메서드는 toString() 메서드의 리턴 값을 콘솔에 출력.
 * - equals(): 객체 동등 비교 메서드. 두 객체가 같은 지(true), 다른 지(false)를 리턴.
 *   힙(heap)에 생성된 객체의 주소(참조값)가 같으면 true, 그렇지 않으면 false를 리턴.
 */

class T {
    int x;
    
    @Override // 상위 타입 Object 클래스의 toString 메서드를 재정의.
    public String toString() {
        return "T 타입 인스턴스";
    }
    
    @Override // Object 클래스의 equals 메서드를 재정의.
    public boolean equals(Object x) {
        return true;
    }
}

public class InheritanceMain05 {
    
    public static void main(String[] args) {
        T t = new T();
        System.out.println(t.toString());
        System.out.println(t);
        System.out.println(t.x);
        
        T t2 = new T();
        System.out.println(t2);
        System.out.println(t2.x);
        
        System.out.println(t.equals(t2));
        
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s2); // 지역 변수가 저장하고 있는 주소(참조값) 비교 -> false.
        System.out.println(s1.equals(s2)); // String 클래스에서 재정의된 equals -> true.
        
    }

}
