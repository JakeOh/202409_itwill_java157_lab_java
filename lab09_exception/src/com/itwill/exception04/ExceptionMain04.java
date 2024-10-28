package com.itwill.exception04;

import java.util.Scanner;

/*
 * multi-catch 구문: 하나의 catch 구문에서 여러개의 예외(Exception) 타입들을 처리하는 방법.
 * 
 * try {
 *     실행 블록
 * } catch (ExceptionType1 | ExceptionType2 | ... e) {
 *     // 예외 처리 블록
 * } [finally {...}]
 * 
 * (주의) 상속 관계에 있는(Super-Sub 관계가 있는) 예외 클래스들은 multi-catch를 사용할 수 없음.
 * multi-catch 예: catch (ArithmeticException | NumberformatException e)
 * multi-catch 사용 불가 예: catch (ArithmeticException | Exception e) -> 컴파일 에러.
 */

public class ExceptionMain04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("x = ");
            int x = Integer.parseInt(scanner.nextLine());
            
            System.out.print("y = ");
            int y = Integer.parseInt(scanner.nextLine());
            
            int z = x / y;
            System.out.println("몫 = " + z);
            
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }

}
