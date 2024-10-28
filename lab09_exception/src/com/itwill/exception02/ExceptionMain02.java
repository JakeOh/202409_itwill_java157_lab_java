package com.itwill.exception02;

import java.util.Scanner;

/*
 * try-catch 문장을 사용한 예외 처리:
 * 
 * try {
 *     정상적인 경우에 실행할 코드 블록  // (1)
 * } catch (Exception 타입의 변수 선언) {
 *     예외 상황이 발생했을 때 실행할 코드 블록  // (2)
 * } finally {
 *     예외 발생 여부와 상관없이 항상 실행할 코드 블록  // (3)
 * }
 * 
 * 예외가 발생하지 않을 경우: (1) -> (3)
 * 예외가 발생한 경우: (1) -- 예외 발생 --> (2) -> (3)
 * 
 * try-catch 문장에서 catch 블록은 반드시 1개 이상 있어야 함.
 * catch 블록은 처리하려는 예외의 종류에 따라서 여러개를 작성할 수 있음.
 * finally 블록은 선택(옵션).
 */

public class ExceptionMain02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("정수 x = ");
            int x = Integer.parseInt(scanner.nextLine());
            
            System.out.print("정수 y = ");
            int y = Integer.parseInt(scanner.nextLine());
            
            int z = x / y;
            System.out.println("몫 = " + z);
        } catch (NumberFormatException e) {
            System.out.println("x와 y는 모두 정수여야 합니다.");
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("나누는 수 y는 0이 될 수 없음.");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("--- finally ---");
        }

        System.out.println("--- 프로그램 종료 ----");
    }

}
