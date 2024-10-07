package com.itwill.loop10;

public class LoopMain10 {

    public static void main(String[] args) {
        // while 반복문 사용해서 구구단 출력. 1단은 1x1, 2단은 2x2, 3단은 3x3, ... 9단까지 출력.
        // (1) break 사용.
        int x = 1;
        while (x < 10) {
            System.out.println("--- " + x + "단 ---");

            int y = 1;
            while (y < 10) {
                System.out.printf("%d x %d = %d\n", x, y, x * y);
                if (x == y) {
                    break;
                }
                y++;
            }

            x++;
        }
        
        System.out.println();
        
        // (2) break 사용하지 않기.
        x = 1;
        while (x < 10) {
            System.out.println("--- " + x + "단 ---");
            
            int y = 1;
            while (y <= x) {
                System.out.printf("%d x %d = %d\n", x, y, x * y);
                y++;
            }
            
            x++;
        }
        
    }

}
