package com.itwill.lambda03;

import java.util.ArrayList;
import java.util.Random;

public class LambdaMain03 {

    public static void main(String[] args) {
        // 스트림(Stream) 클래스와 람다 표현식
        
        Random random = new Random();
        
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100));
        }
        System.out.println(numbers);

        // for 반복문을 사용해서 numbers의 원소들을 출력
        for (Integer x : numbers) {
            System.out.print(x + " ");
        }
        System.out.println();
        
        // 람다 표현식을 사용한 리스트 원소 출력
        numbers.forEach(x -> System.out.print(x + " "));
        System.out.println();
        
        // 리스트 numbers의 원소들 중에서 홀수들만 저장한 리스트를 만듦.
        // 빈 리스트 만듦.
        // numbers 원소들 반복
        //   홀수이면 결과에 저장.
        
    }

}
