package com.itwill.list05;

import java.util.ArrayList;
import java.util.Scanner;

public class ListMain05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Member 타입을 저장하는 리스트 선언, 객체 생성.
        ArrayList<Member> members = new ArrayList<>(); // new ArrayList<Member>();

        // 5번 반복. id와 password를 입력. Member 타입 객체 생성. 리스트에 Member 객체를 저장.
        for (int i = 0; i < 5; i++) {
            System.out.print("ID> ");
            String id = scanner.nextLine();
            System.out.print("Password> ");
            String password = scanner.nextLine();
            Member m = new Member(id, password);
            members.add(m);
        }
        
        // Member 리스트의 원소들을 출력.
        System.out.println(members);
        for (Member m : members) {
            System.out.println(m);
        }
        
        // id 검색어를 입력 받고, id에 검색어가 포함된 멤버들의 리스트를 만들고 출력.
        // 검색어는 대/소문자 구분없이 검색이 가능해야 함.
        ArrayList<Member> searchResult = new ArrayList<>();
        
        System.out.print("ID 검색어> ");
        String keyword = scanner.nextLine();
        
        for (Member m : members) {
            if (m.getId().toLowerCase().contains(keyword.toLowerCase())) {
                searchResult.add(m);
            }
        }
        System.out.println(searchResult);
        
        // 삭제할 id를 입력 받고, 처음 id가 일치하는 멤버 객체를 리스트에서 삭제.
        // 삭제 후 리스트를 출력.
        System.out.print("삭제할 ID> ");
        String idToDel = scanner.nextLine();
        Member memToDel = new Member(idToDel, null);
        members.remove(memToDel);
        System.out.println(members);
        
        System.out.print("삭제할 ID 2> ");
        String id = scanner.nextLine();
        for (Member m : members) {
            if (m.getId().equals(id)) {
                members.remove(m);
                break;
            }
        }
        System.out.println(members);
        
    }

}
