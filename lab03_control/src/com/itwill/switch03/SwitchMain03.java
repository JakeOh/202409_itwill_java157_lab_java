package com.itwill.switch03;

public class SwitchMain03 {

    public static void main(String[] args) {
        // switch 구문에서 enum을 사용하는 방법:

        // Season enum 타입의 변수를 선언, 초기화
        Season s = Season.SUMMER;
        switch (s) {
        case SPRING:
            System.out.println("봄");
            break;
        case SUMMER:
            System.out.println("여름");
            break;
        case FALL:
            System.out.println("가을");
            break;
        case WINTER:
            System.out.println("겨울");
            break;
        }
    }

}
