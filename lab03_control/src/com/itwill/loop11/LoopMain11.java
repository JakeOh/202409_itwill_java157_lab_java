package com.itwill.loop11;

public class LoopMain11 {

    public static void main(String[] args) {
        // for (... ; 조건식; ...) 반복문과 while (조건식) 반복문은
        // 블록({...})을 실행하기 전에 조건식을 먼저 검사하기 때문에,
        // 처음부터 조건식이 false가 되는 경우에는 블록이 한 번도 실행되지 않을 수 있음.
        int x = 1;
        while (x < 0) {
            System.out.println("x = " + x);
            x--;
        }
        
        // do {...} while (조건식);
        int y = 1;
        do {
            System.out.println("y = " + y);
            y--;
        } while (y < 0);

    }

}
