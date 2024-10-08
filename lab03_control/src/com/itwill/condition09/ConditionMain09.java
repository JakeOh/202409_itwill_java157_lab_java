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
        int dice1 = rand.nextInt(1, 7); // 1 이상 7 미만의 난수를 저장.
        int dice2 = rand.nextInt(1, 7);
        
        // 두 주사위의 숫자들을 출력.
        System.out.printf("(%d, %d)\n", dice1, dice2);
        
        // 두 주사위 숫자의 차이를 출력.
        int diff;
        if (dice1 > dice2) {
            diff = dice1 - dice2;
        } else {
            diff = dice2 - dice1;
        }
        System.out.println(diff);
        
        int diff2 = (dice1 > dice2) ? (dice1 - dice2) : (dice2 - dice1);
        System.out.println(diff2);
        
    }

}
