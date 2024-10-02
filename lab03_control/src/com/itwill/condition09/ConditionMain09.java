package com.itwill.condition09;

import java.util.Random;

public class ConditionMain09 {

    public static void main(String[] args) {
        // Random 타입: 난수를 만들어 주는 도구.
        Random rand = new Random();
        
        int number = rand.nextInt(); // nextInt(): int 범위의 난수를 생성.
        System.out.println(number);
        
        number = rand.nextInt(10); // nextInt(bound): 0 이상 bound 미만의 난수를 생성.
        System.out.println(number);

        number = rand.nextInt(1, 3); // nextInt(a, b): a 이상 b 미만의 난수를 생성.
        System.out.println(number);
        
        // 주사위 2개를 던져서 나온 눈을 변수(들)에 저장.
        // int dice1 = ?; int dice2 = ?;
        // 두 주사위의 숫자들을 출력.
        // 두 주사위 숫자의 차이를 출력.
        
    }

}
