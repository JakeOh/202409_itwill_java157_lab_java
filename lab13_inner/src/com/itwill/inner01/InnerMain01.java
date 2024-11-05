package com.itwill.inner01;

import com.itwill.inner01.Enclosing.Nested;

/*
 * 변수 선언 위치:
 * 1. 필드: 클래스의 멤버로 선언하는 변수. 접근 수식어(private, protected, public)를 사용할 수 있음.
 *    (1) 인스턴스(non-static) 필드: static이 아닌 필드.
 *        - 객체를 생성한 후에 그 참조변수(인스턴스)로 참조해서 사용하는 필드.
 *    (2) 정적(static) 필드: static으로 선언한 필드.
 *        - 프로그램 로딩 시점에, 클래스 로더에 의해서 메모리에 로딩되는 변수.
 *        - 객체를 생성하지 않고, 클래스 이름으로 접근해서 사용하는 필드.
 * 2. 지역변수: 메서드 안에서 선언하는 변수. 접근 수식어를 사용할 수 없음.
 *    - 선언된 위치에서부터 변수가 포함된 블록({})이 끝날 때까지만 사용 가능.
 *    - 메서드 파라미터도 지역변수의 일종.
 *    - 지역변수에는 static을 사용할 수 없음.
 * 
 * 내부 클래스/인터페이스(inner class/interface):
 *   - 다른 클래스/인터페이스 안에서 선언된 클래스/인터페이스.
 * 외부 클래스/인터페이스(outer, enclosing class/interface):
 *   - 내부 클래스/인터페이스를 감싸고 있는 클래스/인터페이스.
 * 내부 클래스/인터페이스를 선언할 수 있는 위치:
 *   1. 멤버 내부 클래스
 *      (1) 인스턴스 내부 클래스: static이 아닌 멤버 내부 클래스.
 *          - 외부 클래스의 객체를 먼저 생성한 후에, 그 참조변수로 참조해서
 *          객체를 생성(생성자 호출)하고 사용할 수 있는 내부 클래스.
 *      (2) static 내부 클래스
 *          - 외부 클래스의 객체 생성 여부와 상관 없이 사용할 수 있는 내부 클래스.
 *          - 중첩 클래스(nested class)
 *          - 멤버 내부 인터페이스는 static만 가능. static 선언은 보통 생략.
 *   2. 지역 (내부) 클래스(local class)
 *      - 선언된 (메서드) 블록 안에서만 객체를 생성하고 사용할 수 있는 클래스.
 *   3. 익명 클래스(anonymous class): 이름이 없는 클래스.
 *      - 클래스 선언과 동시에 객체 생성까지를 해야만 하는 클래스.
 *      - 람다 표현식(lambda expression): 일부 익명 클래스를 간단히 작성하는 문법.
 */

public class InnerMain01 {
    
    public static void main(String[] args) {
        // Outer 타입 변수를 선언, 객체 생성 초기화.
        Outer outer1 = new Outer(1, 2, "Java");
        System.out.println(outer1.toString());
        
        // Outer.Inner 타입의 변수를 선언, 객체 생성 초기화.
        Outer.Inner inner1 = outer1.new Inner(100);
        System.out.println(inner1);
        inner1.info();
        
        Outer.Inner inner2 = outer1.new Inner(123);
        inner2.info();
        
        outer1.setX(0);
        inner1.info();
        inner2.info();
        
        Outer.Inner inner3 = new Outer(0, 0, "hello").new Inner(1);
        inner3.info();
        
        // (static으로 선언된) Enclosing.Nested 타입의 변수를 선언, 객체 생성 초기화.
        Enclosing.Nested nested1 = new Enclosing.Nested(123);
        nested1.info();
        
        // static 내부 클래스(중첩 클래스) 이름을 import한 경우:
        // import com.itwill.inner01.Enclosing.Nested; 문장이 있는 경우:
        Nested nested2 = new Nested(0);
        nested2.info();
        //-> static 내부 클래스는 외부 클래스의 인스턴스와는 아무 상관이 없는 클래스.
    }

}
