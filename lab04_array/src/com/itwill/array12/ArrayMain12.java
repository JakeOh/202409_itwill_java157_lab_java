package com.itwill.array12;

import java.util.Scanner;

public class ArrayMain12 {

    public static void main(String[] args) {
        boolean run = true; // 반복문을 계속할 지를 결정하는 변수.
        int studentNum = 0; // 입력받은 학생수를 저장할 변수.
        int[] scores = null; // 학생들의 점수를 저장할 배열. 배열의 길이는 학생 수가 되어야 함.
        Scanner scanner = new Scanner(System.in);
        
        while (run) {
            System.out.println("-------------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("-------------------------------------------------------");
            System.out.print("선택> ");
            int selectNo = scanner.nextInt(); // Integer.parseInt(scanner.nextLine());
            
            switch (selectNo) {
            case 1:
                System.out.print("학생수 입력>> ");
                studentNum = scanner.nextInt(); // Integer.parseInt(scanner.nextLine());
                scores = new int[studentNum]; // 배열의 길이를 학생수만큼 생성.
                break;
            case 2:
                if (studentNum > 0) {
                    for (int i = 0; i < studentNum; i++) {
                        System.out.print("점수 입력>> ");
                        scores[i] = scanner.nextInt(); // Integer.parseInt(scanner.nextLine());
                    }
                } else {
                    System.out.println("학생수를 먼저 입력하세요...");
                }
                break;
            case 3:
                if (studentNum > 0) {
//                    int i = 0;
//                    for (int s : scores) {
//                        System.out.printf("scores[%d] %d\n", i, s);
//                        i++;
//                    }
                    for (int i = 0; i < studentNum; i++) {
                        System.out.printf("scores[%d] %d\n", i, scores[i]);
                    }
                } else {
                    System.out.println("학생수를 먼저 입력하세요...");
                }
                break;
            case 4:
                if (studentNum > 0) {
                    int max = scores[0];
                    for (int s : scores) {
                        max = (s > max) ? s : max;
                    }
                    
                    int sum = 0;
                    for (int s : scores) {
                        sum += s;
                    }
                    
                    double average = (double) sum / studentNum;
                    
                    System.out.println("최고 점수: " + max);
                    System.out.println("평균 점수: " + average);
                } else {
                    System.out.println("학생수를 먼저 입력하세요...");
                }
                break;
            case 5:
                run = false;
                break;
            default:
                System.out.println("메뉴 번호를 다시 선택하세요...");
            }
        }

        System.out.println("프로그램 종료");
    }

}
