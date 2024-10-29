package com.itwill.list03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListMain03 {

    public static void main(String[] args) {
        // 1. 정수를 저장할 수 있는 List(ArrayList 또는 LinkedList)를 선언(numbers), 객체 생성.
        List<Integer> numbers = new ArrayList<>(); // 다형성
        
        // 2. numbers에 [0, 100) 범위(0 이상 100 미만)의 난수 20개를 저장.
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(100));
        }
        
        // 3. numbers를 출력.
        System.out.println(numbers);
        
        // 4. 정수를 저장할 수 있는 List를 선언(odds), 객체 생성.
        List<Integer> odds = new ArrayList<>();
        
        // 5. numbers에 저장된 숫자들 중에서 홀수들을 찾아서 odds에 저장.
        for (Integer n : numbers) {
            if (n % 2 == 1) {
                odds.add(n);
            }
        }
        
        // 6. odds를 출력.
        System.out.println(odds);
        
        // 7. 정수를 저장할 수 있는 List를 선언(evenSquares), 객체 생성.
        List<Integer> evenSquares = new ArrayList<>();
        
        // 8. numbers에 저장된 숫자들 중에서 짝수를 찾아서 짝수의 제곱을 evenSquares에 저장.
        for (Integer n : numbers) {
            if (n % 2 == 0) {
                evenSquares.add(n * n);
            }
        }
        
        // 9. evenSquares를 출력.
        System.out.println(evenSquares);
        
    }

}
