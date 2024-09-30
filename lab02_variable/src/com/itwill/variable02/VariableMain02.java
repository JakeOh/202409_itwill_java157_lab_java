package com.itwill.variable02;

public class VariableMain02 {

    public static void main(String[] args) {
        // 정수를 저장하는 변수 x를 선언하고, 100을 저장(초기화).
        int x = 100;
        
        // 정수를 저장하는 변수 y를 선언하고, 3을 저장.
        int y = 3;
        
        // 덧셈(x + y) 결과 출력
        System.out.println(x + y);
        
        // 뺄셈(x - y) 결과 출력
        System.out.println("x - y = " + (x - y));
        
        // 곱셈(x * y) 결과 출력
        System.out.printf("%d x %d = %d\n", x, y, (x * y));
        
        // 나눗셈(x / y) 결과 출력
        System.out.println("몫: " + (x / y));
        System.out.println("나머지: " + (x % y)); // 정수 % 정수 = 나머지
        
        // 나누기 연산자(/):
        // (1) 정수/정수 결과는 나눈 "몫".
        // (2) 실수/실수, 실수/정수, 정수/실수 결과는 소수점까지 계산.
        System.out.println(100.0 / 3);
    }

}
