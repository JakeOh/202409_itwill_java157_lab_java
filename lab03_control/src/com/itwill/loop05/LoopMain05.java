package com.itwill.loop05;

public class LoopMain05 {

    public static void main(String[] args) {
        // 반복문에서 break와 continue

        // 1. break: 반복문 블록을 실행 중에 break; 문장을 만나면, 
        // break가 포함된 가장 가까운 반복문 블록을 끝냄.
        for (int x = 0; x <= 5; x++) {
            if (x == 3) {
                break;
            }
            
            System.out.println(x);
        }
        
        System.out.println("----------");
        
        // 2. continue: 반복문 블록을 실행 중에 continue 문장을 만나면,
        // continue 아래의 문장들은 실행하지 않고, 그 다음 반복 과정을 계속 실행.
        for (int x = 0; x <= 5; x++) {
            if (x == 3) {
                continue;
            }
            
            System.out.println(x);
        }
        
        System.out.println("----------");
        
        // 무한 반복문 실행 중에 특정 조건을 만족하면 반복을 종료시키기 위해서 break를 사용.
        for (int x = 1; ; x++) { // for ()에서 조건식이 없는 경우, 무한 반복문!
            System.out.println(x);
            if (x == 5) { // 반복문을 끝내는 조건
                break; // 반복문을 끝냄.
            }
        }
        
    }

}
