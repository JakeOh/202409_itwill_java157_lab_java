package com.itwill.loop02;

public class LoopMain02 {

    public static void main(String[] args) {
        // (문제 1) 5 4 3 2 1 출력
        for (int n = 5; n > 0; n--) {
            System.out.print(n + " ");
        }
        System.out.println();
        
        // (문제 2) 0 2 4 6 8 10 출력
        for (int n = 0; n <= 10; n += 2) {
            System.out.print(n + " ");
        }
        System.out.println();

        // 지역 변수(local variable):
        // 선언된 위치에서부터 지역 변수가 포함된 블록({...}) 안에서만 사용됨.
        // 선언된 블록 바깥으로 나가면 자동으로 지워지는 변수.
        
    }

}
