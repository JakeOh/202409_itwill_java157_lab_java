package com.itwill.array11;

import java.util.Random;

public class ArrayMain11 {

    public static void main(String[] args) {
        // 2차원 배열 연습:
        
        // 1차원 정수(int) 배열 3개를 갖는 2차원 배열을 선언, (기본값으로) 초기화.
        int[][] numbers = new int[3][];
        
        // 난수를 만들기 위해서, Random 타입 변수를 선언, 초기화.
        Random rand = new Random();
        
        // 2차원 배열의 첫번째 원소(1차원 배열)는 난수 2개를 저장하는 1차원 배열.
        // 2차원 배열의 두번째 원소는 난수 3개를 저장하는 1차원 배열.
        // 2차원 배열의 세번째 원소는 난수 4개를 저장하는 1차원 배열.
        // 난수의 범위는 0 이상 10 미만.
//        numbers[0] = new int[2];
//        numbers[1] = new int[3];
//        numbers[2] = new int[4];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new int[i + 2];
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = rand.nextInt(10);
            }
        }
        
        // 2차원 배열의 모든 원소들을 출력.
        for (int[] arr : numbers) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        // 2차원 배열에 저장된 9개 숫자들의 합을 계산하고 출력.
        int sum = 0;
        for (int[] arr : numbers) {
            for (int x : arr) {
                sum += x;
            }
        }
        System.out.println("sum = " + sum);
        
        // 2차원 배열에 저장된 9개 숫자들 중에서 최댓값을 찾고 출력.
        int max = numbers[0][0];
        for (int[] arr : numbers) {
            for (int x : arr) {
                if (x > max) {
                    max = x;
                }
            }
        }
        System.out.println("max = " + max);
        
    }

}
