package com.itwill.condition04;

import java.util.Random;

public class ConditionMain04 {

    public static void main(String[] args) {
        // Random 타입의 변수를 선언, 초기화.
        Random rand = new Random(); // Random: 난수를 만들어 주는 도구.
        int number = rand.nextInt(3); // 0 이상 3 미만의 난수를 생성.
        System.out.println(number);
        
        // 가위(0), 바위(1), 보(2)
        // 컴퓨터의 선택 - 난수, 사용자의 선택 - Scanner(콘솔 입력)
        // 누가 이겼는 지 결과 출력.
    }

}
