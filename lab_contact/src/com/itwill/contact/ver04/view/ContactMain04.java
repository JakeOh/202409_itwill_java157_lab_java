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
            case READ_BY_INDEX:
                app.readContactByIndex();
                break;
            case UPDATE:
                app.updateContact();
                break;
            case DELETE:
                app.deleteContact();
                break;
            default:
                System.out.println(">>> 메뉴(0 ~ 5)를 다시 선택하세요.");
            }
        }
        
        
        System.out.println("*** 프로그램 종료 ***");
    }
    
    private void deleteContact() {
        System.out.println("\n--- 연락처 삭제 ---");
        
        System.out.print("삭제할 인덱스>> ");
        int index = inputInteger();
        
        int result = dao.delete(index);
        if (result == 1) {
            System.out.println(">>> 연락처 삭제 성공");
        } else {
            System.out.println(">>> 해당 인덱스에는 삭제할 연락처 정보가 없습니다.");
        }
    }

    private void updateContact() {
        System.out.println("\n--- 연락처 업데이트 ---");
        
        System.out.print("수정할 인덱스>> ");
        int index = inputInteger();
        if (!dao.isValidIndex(index)) {
            System.out.println(">>> 해당 인덱스에는 연락처 정보가 없습니다.");
            return;
        }
        
        Contact before = dao.read(index);
        System.out.println("수정 전>>> " + before);
        
        System.out.print("이름>> ");
        String name = scanner.nextLine();
        
        System.out.print("전화번호>> ");
        String phone = scanner.nextLine();
        
        System.out.print("이메일>> ");
        String email = scanner.nextLine();
        
        Contact after = new Contact(null, name, phone, email);
        
        int result = dao.update(index, after);
        if (result == 1) {
            System.out.println(">>> 연락처 업데이트 성공");
        } else {
            System.out.println(">>> 연락처 업데이트 실패");
        }
    }

    private void readContactByIndex() {
        System.out.println("\n--- 인덱스 검색 ---");
        
        System.out.print("인덱스>> ");
        int index = inputInteger();
        
        Contact contact = dao.read(index);
        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println(">>> 해당 인덱스에는 연락처 정보가 없습니다.");
        }
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
