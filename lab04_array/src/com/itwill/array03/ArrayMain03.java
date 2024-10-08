package com.itwill.array03;

public class ArrayMain03 {

    public static void main(String[] args) {
        // 배열 선언, 초기화 2:
        // 배열이 가지고 있는 원소들을 나열하면서 배열을 초기화.
        // 타입[] 변수이름 = new 타입[] {값1, 값2, ...}; -> (주의) 원소 개수를 표기하지 않음!
        // 타입[] 변수이름 = {값1, 값2, ...};

        // 10보다 작은 양의 홀수들(1, 3, 5, 7, 9)을 저장하는 배열:
        int[] odds = new int[] { 1, 3, 5, 7, 9 };
        for (int i = 0; i < odds.length; i++) {
            System.out.print(odds[i] + " ");
        }
        System.out.println();
        
        // 문자열 "Hello", "안녕하세요", "Bon jour"를 저장하는 배열:
        String[] array = { "Hello", "안녕하세요", "Bon jour" }; // new String[] { "" }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " : ");
        }
        System.out.println();
        
        // 향상된 for 문장(enhanced for statement): for-each 구문.
        // for (변수 선언 : 배열이름) { 실행문; }
        for (String s : array) {
            System.out.print(s + " | ");
        }
        System.out.println();
        
        // 배열 odds의 모든 원소들을 향상된 for 문장을 사용해서 순서대로 출력.
        for (int n : odds) {
            System.out.print(n + " | ");
        }
        System.out.println();
        
    }

}
