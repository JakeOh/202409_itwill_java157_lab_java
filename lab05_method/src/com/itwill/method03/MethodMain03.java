package com.itwill.method03;

public class MethodMain03 {

    public static void main(String[] args) {
        // 반환값(return value)가 없는 메서드 작성 연습:
        countdown(5); // 메서드 호출
        System.out.println("--------------");
        countdown(-5);
    }
    
    /**
     * 양의 정수 start를 전달받아서, 숫자를 1씩 감소하면서 0까지를 출력.
     * 아규먼트가 0또는 음의 정수이면, "양의 정수를 전달해야 함!"라는 메시지를 출력.
     * 
     * @param start 카운트다운 시작 값. 양의 정수.
     */
    public static void countdown(int start) {
        if (start <= 0) {
            System.out.println("양의 정수를 전달해야 함!");
            return; // 메서드를 끝냄. 메소드를 호출한 곳으로 되돌아감.
        }
        
        for (int n = start; n >= 0; n--) {
            System.out.println(n);
        }
    }

}
