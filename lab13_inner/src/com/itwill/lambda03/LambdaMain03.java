package com.itwill.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * 람다 표현식: (파라미터 선언) -> { 코드; return 값; }
 * - 메서드 몸통이 한 문장만 있는 경우: (파라미터) -> 문장
 * - 메서드 몸통이 return 문장만 있는 경우: (파라미터) -> 리턴값
 * 
 * "메서드 참조(method reference)"를 사용한 람다 표현식
 * (1) 람다 표현식이 파라미터가 1개이고, 람다 표현식의 몸통이 그 파라미터에서 
 * "아규먼트를 갖지 않는" 메서드를 호출하는 경우:
 *     (예) x -> x.toUpperCase() 람다 표현식인 경우, String::toUpperCase
 * (2) 람다 표현식이 파라미터가 1개이고, 람다 표현식의 몸통이 메서드 호출로만 이루어진 한 문장이고,
 * 호출한 메서드가 람다 표현식의 파라미터만 아규먼트로 갖는 경우:
 *     (예) x -> System.out.println(x) 람다 표현식인 경우, System.out::println
 */

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
        ArrayList<Integer> odds = new ArrayList<>();
        for (Integer x : numbers) {
            if (x % 2 == 1) {
                odds.add(x);
            }
        }
        System.out.println(odds);
        
        // 스트림과 람다 표현식을 사용:
        List<Integer> odds2 = numbers.stream().filter(x -> x % 2 == 1).toList();
        System.out.println(odds2);
        
        // 리스트 numbers의 원소들의 제곱을 저장하는 리스트를 만듦.
        List<Integer> squares = new ArrayList<>();
        for (Integer x : numbers) {
            squares.add(x * x);
        }
        System.out.println(squares);
        
        // Stream과 Lambda를 사용:
        List<Integer> squares2 = numbers.stream().map(x -> x * x).toList();
        System.out.println(squares2);
        
        // 리스트 numbers에서 홀수들의 제곱을 저장하는 리스트
        List<Integer> oddSquares = new ArrayList<>();
        for (Integer x : numbers) {
            if (x % 2 == 1) {
                oddSquares.add(x * x);
            }
        }
        System.out.println(oddSquares);
        
        List<Integer> oddSquares2 = numbers.stream()
                .filter(x -> x % 2 == 1)
                .map(x -> x * x)
                .toList();
        System.out.println(oddSquares2);
        
        // 문자열을 원소로 갖는 리스트.
        List<String> names = Arrays.asList("Java", "SQL", "HTML", "JavaScript", "Python", "C#", "Kotlin", "Swift");
        
        // names에서 5글자 이상인 문자열들만 필터링한 리스트.
        List<String> longNames = names.stream().filter(x -> x.length() >= 5).toList();
        System.out.println(longNames);
        
        // names의 문자열들을 모두 대문자로 변환(매핑)한 리스트.
        List<String> upperCases = names.stream()
                .map(String::toUpperCase) //.map(x -> x.toUpperCase())
                .toList();
        System.out.println(upperCases);
        
        // names의 문자열들을 그 길이로 매핑한 리스트.
        List<Integer> lengths = names.stream()
                .map(String::length) //.map(x -> x.length())
                .toList();
        System.out.println(lengths);
        
        // names에서 5글자 이상인 문자열들을 모두 대문자로 변환한 리스트.
        List<String> result = names.stream()
                .filter(x -> x.length() >= 5)
                .map(x -> x.toUpperCase())
                .toList();
        System.out.println(result);
        
//        result.forEach(x -> System.out.println(x));
        result.forEach(System.out::println);
    }

}
