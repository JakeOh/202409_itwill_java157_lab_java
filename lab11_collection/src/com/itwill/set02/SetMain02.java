package com.itwill.set02;

import java.util.HashSet;
import java.util.Random;

public class SetMain02 {

    public static void main(String[] args) {
        Random random = new Random();
        
        // 정수를 저장하는 HashSet을 선언, 초기화.
        // [0, 10) 범위의 난수 5개를 HashSet에 저장.
        // HashSet의 원소들을 출력.
        HashSet<Integer> numbers = new HashSet<>();
        while (numbers.size() < 5) {
            int x = random.nextInt(10);
            System.out.println("x = " + x);
            
            numbers.add(x);
            System.out.println(numbers);
        }

    }

}
