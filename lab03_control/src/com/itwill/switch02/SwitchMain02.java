package com.itwill.switch02;

import java.util.Random;

public class SwitchMain02 {

    public static void main(String[] args) {
        // Random 타입의 변수를 선언, 초기화:
        Random rand = new Random();
        
        // 정수 타입 변수에 1 이상 4 이하(5 미만)의 난수를 저장:
        int code = rand.nextInt(1, 5);
        System.out.println("code = " + code);
        
        // code 값이 1 또는 3이면 "남성", 2 또는 4이면 "여성"을 출력.
        switch (code) {
        case 1:
        case 3:
            System.out.println("남성");
            break;
        case 2:
        case 4:
            System.out.println("여성");
            break;
        default:
            System.out.println("몰라요~");
        }

    }

}
