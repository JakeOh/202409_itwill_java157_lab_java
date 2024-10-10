package com.itwill.array08;

public class ArrayMain08 {

    public static void main(String[] args) {
        // 다차원 배열: 배열들을 원소로 갖는 배열.
        // 2차원 배열: 1차원 배열들을 원소로 갖는 배열.
        // - 2차원 배열은 인덱스를 2개 갖음.
        
        // 문자열을 원소로 갖는 1차원 배열:
        String[] apink = { "손나은", "박초롱", "정은지", "오하영", "윤보미" };
        String[] qwer = { "쵸단", "마젠타", "히나", "시연" };
        String[] blackpink = { "제니", "지수", "로제", "리사" };

        // 문자열 배열들을 원소로 갖는 (2차원) 배열:
        String[][] idols = { apink, qwer, blackpink };
//        String[][] idols = {
//                { "손나은", "박초롱", "정은지", "오하영", "윤보미" },
//                { "쵸단", "마젠타", "히나", "시연" },
//                { "제니", "지수", "로제", "리사" }
//        };
        
        // 배열 length 속성: 배열의 원소들의 개수.
        System.out.println("idols length = " + idols.length);
        
        System.out.println(idols[0]);
        //-> 2차원 배열 idols의 첫번째 원소: apink(문자열 배열)
        
        System.out.println("idols[0] length = " + idols[0].length); //-> apink.length
        
        System.out.println(idols[0][0]); //-> 손나은
        System.out.println(idols[2][2]); //-> 로제
        
        // for 문장을 사용해서 2차원 배열의 모든 원소를 출력:
        for (int i = 0; i < idols.length; i++) {
            for (int j = 0; j < idols[i].length; j++) {
                System.out.print(idols[i][j] + "\t");
            }
            System.out.println();
        }
        
        // 향상된 for 문장을 사용해서 2차원 배열의 모든 원소를 출력:
        for (String[] group : idols) {
            for (String name : group) {
                System.out.print(name + "\t");
            }
            System.out.println();
        }
        
    }

}
