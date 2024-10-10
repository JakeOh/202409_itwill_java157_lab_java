package com.itwill.array06;

public class ArrayMain06 {

    public static void main(String[] args) {
        int a = 1;
        int b = a;
        System.out.println("a=" + a + ", b=" + b);
        
        b = 2;
        System.out.println("a=" + a + ", b=" + b);
        
        // 향상된 for 문장 사용할 때 주의점:
        // 향상된 for 블록 안에서는 배열 원소의 값을 변경할 수 없음!
        int[] array = new int[5];
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
        
        for (int x : array) {
            x = 100; // 지역변수 x의 값을 변경. 배열 array의 원소를 변경한 것은 아님!
        }
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            array[i] = i; // 배열 array의 인덱스 i번째 위치의 원소의 값을 변경.
        }
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
        
    }

}
