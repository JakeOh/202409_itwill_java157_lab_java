package com.itwill.loop03;

public class LoopMain03 {

    public static void main(String[] args) {
        /*
         * (문제 1) 아래와 같이 구구단 2단을 출력.
         * 2 x 1 = 2
         * 2 x 2 = 4
         * 2 x 3 = 6
         * ...
         * 2 x 8 = 16
         * 2 x 9 = 18
         */
        for (int n = 1; n < 10; n++) {
//            System.out.println("2 x " + n + " = " + (2 * n));
            System.out.printf("2 x %d = %d\n", n, n * 2);
        }
        
        /*
         * (문제 2) 아래와 같이 1 ~ 100까지 숫자들을 한 줄에 10개씩 출력.
         * 1    2    3  ... 9    10 
         * 11   12   13 ... 19   20 
         * ...
         * 91   92   93 ... 99   100 
         */
        for (int n = 1; n <= 100; n++) {
            System.out.print(n + "\t");
            if (n % 10 == 0) {
                System.out.println();
            }
        }

    }

}
