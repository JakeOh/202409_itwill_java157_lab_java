package com.itwill.exception06;

import java.util.Scanner;

/*
 * throws 선언문이 있는 메서드들 중에서
 * RuntimeException을 상속하는 예외 타입들은 try-catch를 사용하지 않아도 컴파일 에러가 없음.
 * (예) NullPointerException, ArrayIndexOutOfBoundsException, NumberFormatException, ...
 * 
 * RuntimeException을 상속하지 않는 예외 타입들은 반드시
 * (1) try-catch 문장을 사용하거나, 또는
 * (2) throws 선언문을 추가해야 됨.
 * (예) IOException, SQLException, ...
 */

public class ExceptionMain06 {

    public static void main(String[] args) {
        // Calculator 타입 객체 생성
        Calculator calc = new Calculator();
        try {
            int result = calc.divide(123, 0);
            System.out.println("result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            int age = inputAge();
            System.out.println("age = " + age);
        } catch (AgeFormatException e) {
            e.printStackTrace();
        }
        
    }
    
    public static int inputAge() throws AgeFormatException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("나이 입력> ");
            int age = Integer.parseInt(scanner.nextLine());
            if (age >= 0) {
                return age;
            } else {
                throw new AgeFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("나이는 정수로 입력...");
            return 0;
        }
    }

}
