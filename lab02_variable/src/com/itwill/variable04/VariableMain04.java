package com.itwill.variable04;

public class VariableMain04 {

    public static void main(String[] args) {
        // 문자(character) 타입 char:
        // 문자 1개의 유니코드 값(2바이트 정수)를 저장하는 타입.
        // 문자는 작은따옴표('a')를 사용. 문자열은 큰따옴표("hello")를 사용.
        // 'a': 문자 a, "a": (문자 1개로 이루어진) 문자열
        
        char ch1 = 'b';
        System.out.println(ch1); // 문자를 출력
        System.out.println((int) ch1); // 문자의 유니코드 값(정수)를 출력
        
        // char는 문자의 유니코드 값을 저장하는 특별한 종류의 정수 타입.
        char ch2 = (char) (ch1 + 1);
        System.out.println(ch2);
        
        char ch3 = (char) (ch1 - 1);
        System.out.println(ch3);
        
        // 변수에는 선언된 타입의 값만 저장할 수 있음.
        // 큰 범위의 타입에는 작은 타입의 값을 저장할 수 있음(암묵적 타입 변환).
        // 작은 범위의 타입에 큰 범위의 값을 저장하려고 하면 에러.
        // 정수 리터럴(literal, 상수)의 타입은 int(4바이트).
        // 정수 리터럴은 범위만 넘지 않으면 자동으로 byte 또는 short 타입 변수에 저장됨.
        // 실수 리터럴의 타입은 double(8바이트).
        // 강제 타입 변환(cating): 변수의 타입을 강제로 바꿈. (타입) 변수(식).
    }

}
