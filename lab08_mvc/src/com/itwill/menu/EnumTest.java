package com.itwill.menu;

import java.util.Scanner;

public class EnumTest {

    public static void main(String[] args) {
        // Menu menu = new Menu(); //-> 컴파일 에러: enum 타입은 생성자를 호출할 수 없음(객체를 생성할 수 없음).
        Menu menu = Menu.CREATE;
        System.out.println(menu);
        System.out.println(menu.ordinal()); // enum에서 상수가 선언된 순서를 리턴.
        
        Menu[] menus = Menu.values(); // static method
        for (Menu m : menus) {
            System.out.print(m + " ");
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 선택> ");
        int i = Integer.parseInt(sc.nextLine());
        Menu m = Menu.getMenu(i);
        System.out.println(m);
        
    }

}
