package com.itwill.loop08;

public class LoopMain08 {

    public static void main(String[] args) {
        // while 반복문
        
        System.out.println("--- [1] ---");
        // 1 2 3 4 5 출력
        int n = 1;
        while (n <= 5) {
            System.out.print(n + " ");
            n++;
        }
        System.out.println();
        // System.out.println("n = " + n);
        
        System.out.println("--- [2] ---");
        // while 반복문을 사용해서 5 4 3 2 1 출력
        n = 5;
        while (n > 0) {
            System.out.print(n + " ");
            n--;
        }
        System.out.println();
        
        System.out.println("--- [3] ---");
        // while 반복문을 사용해서 1 3 5 7 9 출력
        n = 1;
        while (n < 10) {
            System.out.print(n + " ");
            n += 2;
        }
        System.out.println();
        
        n = 1;
        while (n < 10) {
            if (n % 2 == 1) {
                System.out.print(n + " ");
            }
            n++;
        }
    }

}
