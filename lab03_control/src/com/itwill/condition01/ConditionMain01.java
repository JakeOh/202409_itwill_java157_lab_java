package com.itwill.condition01;

public class ConditionMain01 {

    public static void main(String[] args) {
        // 조건문(conditional statement)

        int number = 3;

        // if 구문: 조건식을 만족할 때만 실행되는 문장(들).
        if (number % 2 == 0) { // 만약 number를 2로 나눈 나머지가 0이면
            System.out.println("짝수");
        }

        // if-else 구문: 조건식을 만족할 때와 조건식을 만족하지 못할 때를 구분해서 작성.
        if (number % 2 == 0) {
            // 조건식이 참일 때(조건식을 만족할 때) 실행할 문장(들)
            System.out.println("number = 짝수");
        } else {
            // 조건식이 거짓일 때(조건식을 만족하지 못할 때) 실행할 문장(들)
            System.out.println("number = 홀수");
        }
        
        System.out.println("=== 프로그램 끝 ===");
    } // end main

} // end class
