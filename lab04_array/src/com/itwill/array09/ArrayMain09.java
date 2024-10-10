package com.itwill.array09;

public class ArrayMain09 {

    public static void main(String[] args) {
        // 2차원 배열 선언, 초기화 방법 1:
        // 타입[][] 변수이름 = new 타입[][] { {...}, {...}, ... };
        // 타입[][] 변수이름 = { {...}, {...}, ... };
        
        int[][] array = {
                { 1, 2, 3, 4 },
                { 5, 6, 7 },
                { 8, 9, 10, 11, 12 }
        };
        
        System.out.println(array); //-> [[I (정수 2차원 배열)
        System.out.println("array length = " + array.length); //-> 3
        System.out.println(array[0]); //-> [I (정수 1차원 배열)
        System.out.println("array[0] length = " + array[0].length); //-> 4
        System.out.println(array[0][1]); //-> 2

        // for 문을 사용한 원소 출력
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        // 향상된 for 문을 사용한 원소 출력
        for (int[] arr : array) {
            for (int x : arr) {
                System.out.print(x + "\t");
            }
            System.out.println();
        }
        
    }

}
