package com.itwill.loop15;

import java.util.Scanner;

public class LoopMain15 {

    public static void main(String[] args) {
        // 교재 연습문제 7.
        boolean run = true; // while 반복문을 계속 실행할 지, 종료할 지를 결정하기 위한 변수
        int balance = 0; // 은행 잔고를 저장하기 위한 변수
        Scanner scanner = new Scanner(System.in); // 콘솔 입력 도구
        
        while (run) {
            System.out.println("-----------------------------------");
            System.out.println("1.입금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("-----------------------------------");
            System.out.print("선택> ");
            
            int menu = scanner.nextInt();
            switch (menu) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                run = false;
                break; // switch 종료
            default:
                
            }
            
        }

        System.out.println("프로그램 종료");
    }

}
