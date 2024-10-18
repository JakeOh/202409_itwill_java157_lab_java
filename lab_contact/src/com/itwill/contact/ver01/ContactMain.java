package com.itwill.contact.ver01;

import java.util.Scanner;

public class ContactMain {
    // 상수 정의
    private static final int MAX_LENGTH = 10;
    
    // ContactMain 클래스의 field를 선언과 동시에 초기화.
    private Scanner scanner = new Scanner(System.in); // 콘솔 입력을 위해서
    private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처를 저장하기 위한 배열
    private int count = 0; // 현재까지 연락처 배열 contacts에 저장된 연락처의 개수를 저장.
    // 배열 contacts에 새로운 연락처가 저장될 때마다 값을 1씩 증가시킴.

    public static void main(String[] args) {
        System.out.println("*** 연락처 프로그램 v0.1 ***");
        
        // ContactMain 타입의 변수 선언, 초기화: ContactMain의 static이 아닌 멤버들을 사용하기 위해서.
        ContactMain app = new ContactMain();
        
        boolean run = true; // while 문을 계속 반복할 지 여부를 결정.
        while (run) {
            int menu = app.selectMainMenu();
            switch (menu) {
            case 0:
                run = false;
                break;
            case 1:
                app.saveNewContact();
                break;
            case 2:
                app.printContactList();
                break;
            case 3:
                break;
            default:
            }
        }

        System.out.println("*** 프로그램 종료 ***");
    }
    
    public int selectMainMenu() {
        System.out.println("\n--------------------------------------------");
        System.out.println("0.종료 | 1.저장 | 2.리스트 | 3.검색 | 4.수정");
        System.out.println("--------------------------------------------");
        System.out.print("선택> ");
        int menu = Integer.parseInt(scanner.nextLine());
        
        return menu;
    }
    
    public void saveNewContact() {
        System.out.println("\n--- 새 연락처 저장 ---");
        
        System.out.print("이름 입력> ");
        String name = scanner.nextLine();
        
        System.out.print("전화번호 입력> ");
        String phone = scanner.nextLine();
        
        System.out.print("이메일 입력> ");
        String email = scanner.nextLine();
        
        // Contact 타입 객체 생성
        Contact c = new Contact(name, phone, email);
        
        contacts[count] = c; // 연락처 배열에 저장
        count++; // 배열에 저장된 개수를 1 증가.
        
        System.out.println(">>> 연락처 저장 성공");
    }

    public void printContactList() {
        for (int i = 0; i < count; i++) {
            System.out.printf("[%d] ", i);
            contacts[i].info();
        }
    }
    
}
