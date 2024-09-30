package com.itwill.variable03;

public class VariableMain03 {

    public static void main(String[] args) {
        // 변수 사용할 때의 주의할 점:
        // (1) 변수는 사용하기 전에 반드시 초기화(값을 할당)해야 함.
        int x = 1; // 변수 선언과 초기화를 한 문장으로 작성.
        System.out.println(x);
        
        int y; // 변수 선언.
        y = 2; // 변수 y를 초기화.
        System.out.println(y);
        
        // (2) 같은 이름으로 변수를 2번 이상 선언할 수 없음.
        // int x = 3; //-> 이미 x라는 이름의 변수가 선언되어 있기 때문에 에러.
        x = 3; //-> 기존에 선언되어 있던 변수 x에 새로운 값 3을 재할당(저장).
        System.out.println(x);
    }

}
