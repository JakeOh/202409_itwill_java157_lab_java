package com.itwill.exception01;

import java.util.Scanner;

public class ExceptionMain01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("정수 x = ");
        int x = Integer.parseInt(scanner.nextLine());
        //-> NumberFormatException 발생할 수 있음.
        
        System.out.print("정수 y = ");
        int y = Integer.parseInt(scanner.nextLine());
        //-> NumberFormatException 발생할 수 있음.
        
        if (y != 0) {
            int z = x / y; // x를 y로 나눈 몫.
            //-> ArithmeticException이 발생할 수 있음.
            System.out.println("몫 = " + z);
        } else {
            System.out.println("0으로는 나눌 수 없음.");
        }
        
        // 예외 (상황) 처리 방법: if-else 구문 (예) NullPointerException
        // if-else로 처리되지 않는 예외들도 있을 수 있음 -> try-catch 구문.

    }

}
