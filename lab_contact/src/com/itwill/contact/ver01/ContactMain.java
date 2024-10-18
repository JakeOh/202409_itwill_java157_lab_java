package com.itwill.contact.ver01;

import java.util.Scanner;

public class ContactMain {
    // ContactMain 클래스의 field를 선언과 동시에 초기화.
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("*** 연락처 프로그램 v0.1 ***");
        
        // ContactMain 타입의 변수 선언, 초기화: ContactMain의 static이 아닌 멤버들을 사용하기 위해서.
        ContactMain app = new ContactMain();
        
        boolean run = true; // while 문을 계속 반복할 지 여부를 결정.
        while (run) {
            System.out.println("---------------------------------");
            System.out.println("1.저장 | 2.검색 | 3.수정 | 0.종료");
            System.out.println("---------------------------------");
            System.out.print("선택> ");
            int menu = Integer.parseInt(app.scanner.nextLine());
            switch (menu) {
            case 0:
                run = false;
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
            }
        }

        System.out.println("*** 프로그램 종료 ***");
    }

}
