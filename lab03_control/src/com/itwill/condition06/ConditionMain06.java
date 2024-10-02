package com.itwill.condition06;

import java.util.Scanner;

public class ConditionMain06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 타입의 변수를 생성하고 초기화.
        
        System.out.print("첫번째 정수 입력>>> ");
        int x = scanner.nextInt(); // 콘솔창에서 입력한 정수를 변수 x에 저장.
        
        System.out.print("두번째 정수 입력>>> ");
        int y = scanner.nextInt();

        int big; // x, y 중에서 더 큰(크거나 같은) 정수를 저장하기 위한 변수.
        if (x > y) {
            big = x;
        } else {
            big = y;
        }
        System.out.println("big = " + big);
        
        // 삼항 연산자: if-else를 간단히 쓰는 문법.
        // (조건식) ? (조건식이 참일 때 선택할 값) : (조건식이 거짓일 때 선택할 값)
        int big2 = (x > y) ? x : y;
        System.out.println("big2 = " + big2);
        
    }

}
