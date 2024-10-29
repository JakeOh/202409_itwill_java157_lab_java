package com.itwill.wrapper;

/*
 * wrapper 클래스: 자바의 기본 타입의 값을 하나만 저장하는(포장하는, 감싸는) 클래스(타입).
 * 기본 타입: boolean, byte, short, int, long, char, float, double
 * wrapper: Boolean, Byte, Short, Integer, Long, Character, Float, Double
 * - java.lang 패키지에 있기 때문에 import 문장이 필요 없음.
 * - 목적:
 *   (1) 기본 타입의 값을 사용한 기능(메서드)들을 제공.
 *   (2) 상속/다형성 이용 가능.
 *   (3) generic class(List, Set, Map)에서 이용하기 위해서.
 */

public class WrapperEx {

    public static void main(String[] args) {
        // int 타입의 값을 아규먼트로 전달받아서 Integer 타입의 객체 생성(int -> Integer)
        Integer number1 = Integer.valueOf(1);
        System.out.println(number1);
        
        // 문자열(String)을 아규먼트로 전달받아서 Integer 타입의 객체 생성(String -> Integer)
        Integer number2 = Integer.valueOf("123");
        System.out.println(number2);
        
        // 문자열(String)을 int 타입의 정수로 변환(String -> int)
        int number3 = Integer.parseInt("100");
        System.out.println(number3);
        
        int result = number1 - number2; // auto-unboxing: Integer 객체 값을 자동으로 리턴.
        System.out.println(result);
        
        Integer number4 = 4; // auto-boxing: 기본 타입의 값을 wrapper 객체로 (자동) 변환.
        
    }

}
