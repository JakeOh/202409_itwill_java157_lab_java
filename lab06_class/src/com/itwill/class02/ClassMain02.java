package com.itwill.class02;

public class ClassMain02 {

    public static void main(String[] args) {
        // 같은 패키지의 클래스 이름은 import 문 없이도 사용 가능.
        // Score 타입의 객체 선언, Score 객체 생성하고 변수에 할당.
        Score score1 = new Score();
        System.out.println(score1);
        
        // score1 인스턴스의 필드 값들을 변경.
        score1.korean = 100;
        score1.english = 90;
        score1.math = 50;
        
        // score1 인스턴스의 메서드 호출:
        System.out.println("총점: " + score1.getTotal());
        
    }

}
