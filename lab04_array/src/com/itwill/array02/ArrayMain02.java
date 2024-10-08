package com.itwill.array02;

public class ArrayMain02 {

    public static void main(String[] args) {
        // 배열 선언과 초기화 1:
        // 타입[] 변수이름 = new 타입[원소 개수];
        // -> 배열의 모든 원소들을 그 타입의 기본값으로 초기화해 줌.
        // -> 정수의 기본값 0, 실수의 기본값 0.0, boolean의 기본값은 false, 
        // 그 이외의 나머지 모든 타입의 기본값은 null.
        
        int[] integerArray = new int[3];
        for (int i = 0; i < integerArray.length; i++) {
            System.out.print(integerArray[i] + " ");
        }
        System.out.println();
        
        // 배열의 특정 인덱스(위치)의 값을 변경: array[index] = value;
        integerArray[0] = 100;
        integerArray[1] = 50;
        for (int i = 0; i < integerArray.length; i++) {
            System.out.print(integerArray[i] + " ");
        }
        System.out.println();
        
        // boolean 4개를 저장하는 배열을 선언, (기본값으로) 초기화:
        boolean[] booleanArray = new boolean[4];
        for (int i = 0; i < booleanArray.length; i++) {
            System.out.print(booleanArray[i] + " ");
        }
        System.out.println();
        
        booleanArray[1] = true;
        booleanArray[2] = true;
        for (int i = 0; i < booleanArray.length; i++) {
            System.out.print(booleanArray[i] + " ");
        }
        System.out.println();
    }

}
