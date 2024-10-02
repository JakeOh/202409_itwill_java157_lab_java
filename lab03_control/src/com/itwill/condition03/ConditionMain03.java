package com.itwill.condition03;

import java.util.Scanner; // Scanner 타입 이름을 가져옴.

public class ConditionMain03 {

    public static void main(String[] args) {
        // Scanner 타입 변수 선언, 초기화:
        Scanner scanner = new Scanner(System.in);
        
        // 국어 점수를 입력받고 저장.
        System.out.print("국어 점수 입력>>> ");
        int korean = scanner.nextInt();

        // 영어 점수를 입력받고 저장.
        System.out.print("영어 점수 입력>>> ");
        int english = scanner.nextInt();
        
        // 수학 점수를 입력받고 저장.
        System.out.print("수학 점수 입력>>> ");
        int math = scanner.nextInt();
        
        // ctrl+space: 코드 추천. 자동완성.
        
        // 세 과목의 점수를 출력.
        System.out.println("국어: " + korean);
        System.out.println("영어: " + english);
        System.out.println("수학: " + math);
        
        // 세 과목의 평균을 (소수점까지) 계산해서 (double 타입) 변수에 저장.
        double average = (double) (korean + english + math) / 3;
        
        // 평균을 출력.
        System.out.println("평균: " + average);
        
        // 평균이 90점 이상이면, "A"라고 출력.
        // 평균이 80점 이상이면, "B"라고 출력.
        // 평균이 70점 이상이면, "C"라고 출력.
        // 평균이 70점 미만이면, "F"라고 출력.
        if (average >= 90) {
            System.out.println("A");
        } else if (average >= 80) {
            System.out.println("B");
        } else if (average >= 70) {
            System.out.println("C");
        } else {
            System.out.println("F");
        }
        
    }

}
