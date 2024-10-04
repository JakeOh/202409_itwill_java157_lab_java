package com.itwill.switch01;

public class SwitchMain01 {

    public static void main(String[] args) {
        // switch 구문:
        
        int number = 10;
        switch (number % 2) {
        case 0:
            System.out.println("짝수");
            break;
        case 1:
            System.out.println("홀수");
            // break; // 마지막 break 문장은 생략 가능.
        }

    }

}
