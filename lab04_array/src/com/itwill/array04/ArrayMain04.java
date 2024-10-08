package com.itwill.array04;

import java.util.Scanner;

public class ArrayMain04 {

    public static void main(String[] args) {
        // 성적 처리 프로그램:
        // 정수 5개를 저장할 수 있는 배열을 선언, (기본값으로) 초기화.
        int[] scores = new int[5];
        
        // 콘솔 입력을 받기 위해 Scanner 타입 변수를 선언.
        Scanner scanner = new Scanner(System.in);
        
        // for 문장을 사용해서, 시험 점수(정수)를 입력받고 배열에 저장(5번 반복).
        for (int i = 0; i < scores.length; i++) {
            System.out.print("점수 입력>>> ");
            scores[i] = scanner.nextInt();
        }
        
        // 향상된 for 문장을 사용해서 배열에 저장된 값들을 출력.
        for (int s : scores) {
            System.out.print(s + " ");
        }
        System.out.println();
        
        // 배열에 저장된 시험 점수들의 총점을 계산하고 출력.
        int sum = 0;
//        for (int i = 0; i < scores.length; i++) {
//            sum += scores[i];
//        }
        for (int s : scores) {
            sum += s;
        }
        System.out.println("총점: " + sum);
        
        // 배열에 저장된 시험 점수들의 평균을 계산하고 출력.
        double average = (double) sum / scores.length;
        System.out.println("평균: " + average);

    }

}
