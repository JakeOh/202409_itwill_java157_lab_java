package com.itwill.contact.ver01;

import java.util.Scanner;

public class ContactMain {
    // 상수 정의
    private static final int MAX_LENGTH = 3;
    
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
                app.selectContactByIndex();
                break;
            case 4:
                app.updateContactByIndex();
                break;
            default:
                System.out.println("메뉴 번호를 다시 선택...");
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
        if (count == MAX_LENGTH) {
            System.out.println(">>> 저장 공간 부족");
            return; // 메서드 종료
        }
        
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
        System.out.println("\n--- 연락처 리스트 ---");
        
        for (int i = 0; i < count; i++) {
            System.out.printf("[%d] %s\n", i, contacts[i].toString());
        }
        
        System.out.println("---------------------");
    }
    
    public void selectContactByIndex() {
        System.out.println("\n--- 인덱스 검색 ---");
        System.out.print("검색할 연락처 인덱스 입력> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        if (index >= 0 && index < count) { 
            // 해당 인덱스의 배열 원소를 출력.
            System.out.println(contacts[index].toString());
        } else {
            System.out.println(">>> 해당 인덱스에는 연락처 정보가 없습니다.");
        }
    }
    
    public void updateContactByIndex() {
        System.out.println("\n--- 연락처 수정 ---");
        
        System.out.print("수정할 연락처 인덱스 입력> ");
        int index = Integer.parseInt(scanner.nextLine());
        if (index < 0 || index >= count) {
            System.out.println(">>> 해당 인덱스에는 수정할 연락처 정보가 없습니다.");
            return; // 메서드 종료
        }
        
        System.out.print(">>> 수정 전: ");
        System.out.println(contacts[index].toString());
        
        System.out.print("이름 입력> ");
        String name = scanner.nextLine();
        
        System.out.print("전화번호 입력> ");
        String phone = scanner.nextLine();
        
        System.out.print("이메일 입력> ");
        String email = scanner.nextLine();
        
//        contacts[index].setName(name);
//        contacts[index].setPhone(phone);
//        contacts[index].setEmail(email);
        contacts[index] = new Contact(name, phone, email);
        
        System.out.print(">>> 수정 후: ");
        System.out.println(contacts[index].toString());
    }
    
}
