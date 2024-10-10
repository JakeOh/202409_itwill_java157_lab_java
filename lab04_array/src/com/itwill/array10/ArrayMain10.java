package com.itwill.array10;

public class ArrayMain10 {

    public static void main(String[] args) {
        // 2차원 배열 선언, 초기화 2: 모든 값들을 타입의 기본값으로 초기화.
        
        // (1) 2차원 배열이 직사각형 모양인 경우: 모든 1차원 배열들이 같은 개수의 원소를 가질 때.
        // 타입[][] 변수이름 = new 타입[행의 개수][열의 개수];
        // - 행의 개수: 2차원 배열이 가지고 있는 1차원 배열들의 개수.
        // - 열의 개수: 1차원 배열의 원소 개수.
        
        int[][] array1 = new int[2][3];
        for (int[] arr : array1) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        
        System.out.println("---------------");
        
        // (2) 2차원 배열이 가지고 있는 행의 개수는 결정되어 있고, 열의 개수가 결정되지 않은 경우:
        // 타입[][] 변수이름 = new 타입[행의 개수][];
        
        int[][] array2 = new int[3][];
        
        array2[0] = new int[3];
        array2[1] = new int[4];
        array2[2] = new int[2];
        
        for (int[] arr : array2) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

    }

}
