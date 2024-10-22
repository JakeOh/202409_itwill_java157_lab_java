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
 * - hashCode(): 객체의 해시 코드(정수)를 리턴.
 *   객체의 참조값(heap 메모리 주소)로 해시 코드를 만듦.
 *   해시 코드가 만족해야 하는 조건:
 *   (1) 같은 객체에서 hashCode() 메서드를 여러번 호출하더라도 항상 같은 정수를 리턴해야 함.
 *   (2) equals() 메서드의 결과가 true인 두 객체의 해시 코드는 같아야 함.
 *   (3) 해시 코드 값이 같은 두 객체의 equals() 메서드의 리턴 값이 항상 true일 필요는 없음.
 */

class T {
    int num;
    
    @Override // 상위 타입 Object 클래스의 toString 메서드를 재정의.
    public String toString() {
        // return "T 타입 인스턴스";
        return "T(num=" + num + ")";
    }
    
    @Override // Object 클래스의 equals 메서드를 재정의.
    public boolean equals(Object x) {
        boolean result = false;
        if (x instanceof T) { // 아규먼트 x가 클래스 T 타입의 객체이면
            T other = (T) x; // 강제 타입 변환(casting)
            result = (this.num == other.num); // 두 객체의 필드 num의 값이 같으면 true.
        }
        
        return result;
    }
    
    @Override
    public int hashCode() {
        return num;
    }
}

public class InheritanceMain05 {
    
    public static void main(String[] args) {
        T t = new T();
        System.out.println(t.toString());
        System.out.println(t);
        System.out.println(t.num);
        
        T t2 = new T();
        System.out.println(t2);
        System.out.println(t2.num);
        
        System.out.println("t equals t2: " + t.equals(t2));
        System.out.println("t hash code: " + t.hashCode());
        System.out.println("t2 hash code: " + t2.hashCode());
        
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println("비교 연산자(==) 결과: " + (s1 == s2)); // 지역 변수가 저장하고 있는 주소(참조값) 비교 -> false.
        System.out.println("s1 equals s2: " + s1.equals(s2)); // String 클래스에서 재정의된 equals -> true.
        System.out.println("s1 hash code: " + s1.hashCode());
        System.out.println("s2 hash code: " + s2.hashCode());
    }

}
