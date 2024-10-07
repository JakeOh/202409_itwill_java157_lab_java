package com.itwill.loop06;

public class LoopMain06 {

    public static void main(String[] args) {
        // 중첩 반복문: 반복문 안에 반복문을 사용.
        for (int x = 2; x < 10; x++) {
            System.out.println("--- " + x + "단 ---");
            for (int y = 1; y < 10; y++) {
                System.out.printf("%d x %d = %d\n", x, y, x * y);
            } // for (y)
        } // for (x)
    
    }

}
