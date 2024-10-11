package com.itwill.method04;

import java.util.Random;

public class MethodMain04 {

    // 과제: main 메서드에서 컴파일 에러가 발생하지 않도록 필요한 메서드들을 작성하세요.
    public static void main(String[] args) {
        Random random = new Random();
        
        int number = random.nextInt(100);
        System.out.println("number = " + number);
        
        boolean result = isEven(number);
        System.out.println("result = " + result);
        
        int x = random.nextInt(100);
        int y = random.nextInt(100);
        System.out.println("x=" + x + ", y=" + y);
        
        int big = whoIsBig(x, y);
        System.out.println("big=" + big);
        
        int code = random.nextInt(1, 5);
        String gender = parseGenderCode(code);
        System.out.println("code=" + code + ", gender=" + gender);
    }

    /**
     * isEven.
     * 아규먼트로 전달된 정수가 짝수인 지, 홀수인 지를 리턴하는 메서드.
     * 
     * @param x 정수(int). 짝수/홀수를 검사할 정수.
     * @return x가 짝수이면 true, 그렇지 않으면 false.
     */
    // TODO: 
    
    /**
     * whoIsbig.
     * 두 수 x와 y 중에서 크거나 같은 수를 리턴.
     * 
     * @param x 정수(int). 크기를 비교할 정수.
     * @param y 정수(int). 크기를 비교할 정수.
     * @return x > y 이면 x, 그렇지 않으면 y.
     */
    // TODO:
    
    /**
     * parseGenderCode.
     * 성별 코드(정수)를 문자열로 변환해서 리턴.
     * 
     * @param code 성별 코드. 성별 코드는 1, 2, 3, 또는 4만 사용됨.
     * @return 코드 값이 1 또는 3이면 "male", 코드 값이 2 또는 4이면 "female".
     * 만약 그 이외의 코드 값인 경우에는 "unknown"을 리턴.
     */
    // TODO:
    
}
