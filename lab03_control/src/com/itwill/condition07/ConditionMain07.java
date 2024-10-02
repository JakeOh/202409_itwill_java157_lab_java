package com.itwill.condition07;

import java.util.Scanner;

public class ConditionMain07 {

    public static void main(String[] args) {
        // Scanner 타입 변수를 생성하고 초기화.
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("정수 입력>>> ");
        int number = scanner.nextInt();
        
        // 변수 number에 저장된 값이 짝수(even number)이면 "짝수", 
        // 홀수(odd number)이면 "홀수"를 저장하기 위한 변수. 
        String evenOrOdd = (number % 2 == 0) ? "짝수" : "홀수";
        System.out.println(evenOrOdd);
        
    }

}
