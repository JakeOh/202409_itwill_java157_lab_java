package com.itwill.scanner;

import java.util.Scanner;

public class ScannerMain2 {

    public static void main(String[] args) {
        // Integer.parseInt(문자열): 문자열을 정수(int)로 변환해서 반환.
        // Double.parseDouble(문자열): 문자열을 실수(double)로 변환해서 반환.
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("학생수 입력> ");
        int studentNum = scanner.nextInt(); //-> 정수를 읽은 후에 입력 버퍼에 엔터가 남아있음.
        scanner.nextLine(); //-> 입력 버퍼를 지움.
        System.out.println("studentNum = " + studentNum);
        
        System.out.print("정수 입력> ");
        int num = Integer.parseInt(scanner.nextLine());
        System.out.println("num = " + num);
        
        System.out.print("실수 입력> ");
        double x = Double.parseDouble(scanner.nextLine());
        System.out.println("x = " + x);
        
    }

}
