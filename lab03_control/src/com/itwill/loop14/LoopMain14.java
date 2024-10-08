package com.itwill.loop14;

public class LoopMain14 {

    public static void main(String[] args) {
        // 교재 연습문제 5
        for (int x = 1; x <= 4; x++) { // x: line 번호
            for (int y = 1; y <= x; y++) { // y: 출력할 "*"의 개수
                System.out.print("*");
            }
            System.out.println(); // 줄바꿈
        }
        
        System.out.println("----------");
        
        for (int x = 1; x <= 4; x++) { // x: 줄 번호
            for (int y = 1; y <= 4; y++) { // y: 출력할 *의 개수
                System.out.print("*");
                if (y == x) { // 출력한 * 개수가 줄 번호와 같으면
                    break; // 출력을 멈춤.
                }
            }
            System.out.println();
        }
        
        System.out.println("----------");
        
        // 교재 연습문제 6.
        for (int x = 1; x <= 4; x++) { // x: 행(가로) 번호
            for (int y = 1; y <= 4; y++) { // y: 열(세로) 번호
                if (y <= 4 - x) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        
        System.out.println("----------");
        
        for (int x = 1; x <= 4; x++) {
            for (int y = 4; y >= 1; y--) {
                if (y > x) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        
        System.out.println("----------");
        
        for (int x = 1; x <= 4; x++) { // x: 줄 번호
            for (int y = 1; y <= 4 - x; y++) { // y: 공백 개수
                System.out.print(" ");
            }
            for (int y = 1; y <= x; y++) { // y: * 개수
                System.out.print("*");
            }
            System.out.println();
        }
        
    }

}
