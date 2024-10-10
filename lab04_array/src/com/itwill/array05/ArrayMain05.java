package com.itwill.array05;

import java.util.Random;

public class ArrayMain05 {

    public static void main(String[] args) {
        final int LENGTH = 10;
        //-> final 변수: 초기화된 이후에는 값을 변경할 수 없는 변수.
        
        // 난수를 생성하는 Random 타입 변수를 선언하고, 초기화.
        Random rand = new Random();
        
        // 정수(int) 10개를 저장할 수 있는 배열 codes를 선언하고, (기본값으로) 초기화.
        int[] codes = new int[LENGTH];
        
        // for 문장을 사용해서, 배열 codes에 1 이상 4 이하의 정수 난수들을 저장(10번 반복).
        for (int i = 0; i < LENGTH; i++) {
            codes[i] = rand.nextInt(1, 5);
        }
        
        // 배열 codes의 원소들을 출력.
        for (int x : codes) {
            System.out.print(x + "\t");
        }
        System.out.println();
        
        // 문자열(String) 10개를 저장할 수 있는 배열 genders를 선언하고, (기본값으로) 초기화.
        String[] genders = new String[LENGTH];
        
        // 배열 genders에는 배열 codes의 값에 따라서 문자열을 저장:
        // -> codes의 원소가 1또는 3이면 "남성"을, codes의 원소가 2또는 4이면 "여성"을 저장.
        // -> 만약 codes가 {1, 4, 2, 3} 이면, genders는 {"남성", "여성", "여성", "남성}.
        for (int i = 0; i < LENGTH; i++) {
//            String s = null;
//            if (codes[i] == 1 || codes[i] == 3) {
//                s = "남성";
//            } else {
//                s = "여성";
//            }
//            switch (codes[i]) {
//            case 1, 3:
//                s = "남성";
//                break;
//            case 2, 4:
//                s = "여성";
//                break;
//            }
            
            String s = (codes[i] == 1 || codes[i] == 3) ? "남성" : "여성";
            genders[i] = s;
        }
        
//        int i  = 0;
//        for (int c : codes) {
//            genders[i] = (c == 1 || c == 3) ? "남성" : "여성";
//            i++;
//        }

        // 배열 genders의 원소들을 출력.
        for (String g : genders) {
            System.out.print(g + "\t");
        }
        System.out.println();
        
    }

}
