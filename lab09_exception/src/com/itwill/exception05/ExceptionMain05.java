package com.itwill.exception05;

import java.util.Scanner;

public class ExceptionMain05 {
    
    private Scanner scanner = new Scanner(System.in);
    
    private int inputInteger() {
        int input = 0;
        while (true) {
            try {
                System.out.print("정수 입력> ");
                input = Integer.parseInt(scanner.nextLine());
                break; // 무한 반복문(while (true))을 끝냄.
            } catch (NumberFormatException e) {
                System.out.println("입력값은 정수여야 합니다.");
            }
        }
        
        return input;
    }
    
    // 재귀 메서드(recursive method)
    private int inputInteger2() {
        try {
            System.out.print("정수 입력> ");
            int x = Integer.parseInt(scanner.nextLine());
            return x;
        } catch (NumberFormatException e) {
            System.out.println("입력값은 정수로...");
            return inputInteger2(); // 메서드 재귀 호출.
        }
    }

    public static void main(String[] args) {
        ExceptionMain05 app = new ExceptionMain05();
//        int result = app.inputInteger();
        int result = app.inputInteger2();
        System.out.println("입력한 정수 = " + result);
    }

}
