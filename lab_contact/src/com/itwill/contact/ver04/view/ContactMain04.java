package com.itwill.contact.ver04.view;

import java.util.List;
import java.util.Scanner;

import com.itwill.contact.ver04.controller.ContactDao;
import com.itwill.contact.ver04.model.Contact;

// MVC 아키텍쳐에서 View 역할 담당.
public class ContactMain04 {
    
    private Scanner scanner;
    private ContactDao dao;
    
    public ContactMain04() {
        scanner = new Scanner(System.in);
        dao = ContactDao.INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println("*** 연락처 프로그램 v0.4 ***");
        
        ContactMain04 app = new ContactMain04();
        
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
            default:
                System.out.println(">>> 메뉴(0 ~ 5)를 다시 선택하세요.");
            }
        }
        
        
        System.out.println("*** 프로그램 종료 ***");
    }
    
    private void readAllContacts() {
        System.out.println("\n--- 연락처 목록 ---");
        
        List<Contact> list = dao.read();
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("[%d] %s\n", i, list.get(i));
        }
        System.out.println("-------------------");
    }
    
    private void createNewContact() {
        System.out.println("\n--- 새 연락처 저장 ---");
        
        System.out.print("이름>> ");
        String name = scanner.nextLine();
        
        System.out.print("전화번호>> ");
        String phone = scanner.nextLine();
        
        System.out.print("이메일>> ");
        String email = scanner.nextLine();
        
        Contact contact = new Contact(null, name, phone, email);
        int result = dao.create(contact);
        if (result == 1) {
            System.out.println(">>> 연락처 저장 성공");
        } else {
            System.out.println(">>> 연락처 저장 실패");
        }
    }
    
    private MainMenu selectMainMenu() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("0.종료 | 1.저장 | 2.목록 | 3.검색 | 4.수정 | 5.삭제");
        System.out.println("---------------------------------------------------");
        System.out.print("선택> ");
        int choice = inputInteger();
        
        return MainMenu.getMainMenu(choice);
    }
    
    private int inputInteger() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("정수 입력>> ");
            }
        }
    }

}
