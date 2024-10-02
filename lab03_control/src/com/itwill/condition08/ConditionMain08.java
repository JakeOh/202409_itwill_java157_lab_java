package com.itwill.condition08;

import java.util.Scanner;

public class ConditionMain08 {

    public static void main(String[] args) {
        // 조건문, 비교 연산자, 논리 연산자 연습
        // 자바(Java), SQL, 자바스크립트(JavaScript) 점수를 콘솔에서 입력받고 저장.
        // 세 과목이 모두 40점 이상이고, 평균이 60점 이상이면 "합격",
        // 그렇지 않으면 "불합격" 출력.

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("자바 점수 입력>>> ");
        int java = scanner.nextInt();
        
        System.out.print("SQL 점수 입력>>> ");
        int sql = scanner.nextInt();
        
        System.out.print("자바스크립트 점수 입력>>> ");
        int javascript = scanner.nextInt();
        
        double average = (double) (java + sql + javascript) / 3;
        System.out.println("평균 = " + average);
        
        if (java >= 40 && sql >= 40 && javascript >= 40 && average >= 60) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }
        
        if (java >= 40 && sql >= 40 && javascript >= 40) {
            if (average >= 60) {
                System.out.println("Pass"); // 합격
            } else {
                System.out.println("Fail"); // 불합격
            }
        } else {
            System.out.println("Fail"); // 불합격
        }
        
    }

}
