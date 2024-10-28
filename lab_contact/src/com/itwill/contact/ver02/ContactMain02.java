package com.itwill.contact.ver02;

import java.util.Scanner;

import com.itwill.contact.ver01.Contact;

// MVC 아키텍쳐에서 View(UI) 역할을 담당하는 클래스.
public class ContactMain02 {
    
    private Scanner scanner = new Scanner(System.in);
    private ContactDao dao = ContactDaoImpl.getInstance();

    public static void main(String[] args) {
        System.out.println("*** 연락처 프로그램 v0.2 ***");
        
        ContactMain02 app = new ContactMain02();
        
        boolean run = true;
        while (run) {
            MainMenu menu = app.selectMainMenu();
            switch (menu) {
            case QUIT:
                run = false;
                break;
            case CREATE:
                app.createNewContact();
                break;
            case READ_ALL:
                app.readAllContacts();
                break;
            case READ_BY_INDEX:
                app.readContactByIndex();
                break;
            case UPDATE:
                app.updateContact();
                break;
            default:
                System.out.println("메뉴(0 ~ 4)를 다시 선택하세요.");
            }
        }

        
        System.out.println("*** 프로그램 종료 ***");
    }

    private void updateContact() {
        System.out.println("\n--- 연락처 업데이트 ---");
        
        System.out.print("수정할 인덱스> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        ContactDaoImpl daoImpl = (ContactDaoImpl) dao;
        if (!daoImpl.isValidIndex(index)) {
            System.out.println(">>> 해당 인덱스에는 수정할 연락처 정보가 없습니다.");
            return; // 메서드 종료
        }
        
        // 컨트롤러 메서드를 호출해서 업데이트 전의 연락처 정보를 읽어옴.
        Contact before = dao.read(index);
        System.out.println(">>> 수정 전: " + before);
        
        System.out.print("이름 입력> ");
        String name = scanner.nextLine();
        
        System.out.print("전화번호 입력> ");
        String phone = scanner.nextLine();
        
        System.out.print("이메일 입력> ");
        String email = scanner.nextLine();
        
        Contact after = new Contact(name, phone, email);
        
        // 컨트롤러 메서드를 호출해서 해당 인덱스의 연락처 정보를 업데이트함.
        int result = dao.update(index, after);
        if (result == 1) {
            System.out.println(">>> 연락처 업데이트 성공");
        } else {
            System.out.println(">>> 연락처 업데이트 실패");
        }
    }

    private void readContactByIndex() {
        System.out.println("\n--- 인덱스 검색 ---");
        
        System.out.print("인덱스> ");
        int index = Integer.parseInt(scanner.nextLine());
        
        ContactDaoImpl daoImpl = (ContactDaoImpl) dao;
        if (!daoImpl.isValidIndex(index)) {
            System.out.println(">>> 해당 인덱스에는 연락처 정보가 없습니다.");
            return;
        }
        
        // 컨트롤러 메서드를 호출해서 해당 인덱스의 연락처 정보를 검색.
        Contact contact = dao.read(index);
        System.out.println(contact);
    }

    private void readAllContacts() {
        System.out.println("\n--- 연락처 목록 ---");
        
        // 컨트롤러 메서드를 호출해서 연락처 목록(배열)을 읽어옴.
        Contact[] contacts = dao.read();
        for (int i = 0; i < contacts.length; i++) {
            System.out.printf("[%d] %s\n", i, contacts[i]);
        }
    }

    private void createNewContact() {
        System.out.println("\n--- 새 연락처 저장 ---");
        
        ContactDaoImpl daoImpl = (ContactDaoImpl) dao;
        if (daoImpl.isMemoryFull()) {
            System.out.println(">>> 연락처를 저장할 공간이 부족합니다.");
            return;
        }
        
        System.out.print("이름 입력> ");
        String name = scanner.nextLine();
        
        System.out.print("전화번호 입력> ");
        String phone = scanner.nextLine();
        
        System.out.print("이메일 입력> ");
        String email = scanner.nextLine();
        
        Contact contact = new Contact(name, phone, email);
        
        // 컨트롤러의 메서드를 호출해서 입력받은 연락처 정보를 배열에 저장.
        int result = dao.create(contact);
        if (result == 1) {
            System.out.println(">>> 새 연락처 저장 성공");
        } else {
            System.out.println(">>> 새 연락처 저장 실패");
        }
    }

    private MainMenu selectMainMenu() {
        System.out.println("\n--------------------------------------------");
        System.out.println("0.종료 | 1.저장 | 2.리스트 | 3.검색 | 4.수정");
        System.out.println("--------------------------------------------");
        System.out.print("선택> ");
        int choice = Integer.parseInt(scanner.nextLine());
        
        return MainMenu.getMainMenu(choice);
    }

}
