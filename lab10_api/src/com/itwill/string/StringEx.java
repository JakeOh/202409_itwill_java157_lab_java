package com.itwill.string;

public class StringEx {

    public static void main(String[] args) {
        System.out.println("Ex. 1 ---");
        // String.charAt(int index) 사용법:
        String ssn = "991028-2234567";
        System.out.println(ssn.charAt(7));
        
        System.out.println("Ex. 2 ---");
        // String.split(String s) 사용법:
        String date = "2024-10-28";
        String[] result = date.split("-");
        for (String s : result) {
            System.out.print(s + "\t");
        }
        System.out.println();
        
        System.out.println("Ex. 3 ---");
        String[] languages = {"Java", "SQL", "JavaScript", "Python", "Kotlin", "HTML"};
        // 배열 languages에서 5글자 이상인 문자열들만 출력.
        for (String s : languages) {
            if (s.length() >= 5) {
                System.out.print(s + " ");
            }
        }
        System.out.println();
        
        System.out.println("Ex. 4 ---");
        String[] names = {"오쌤", "홍길동", "Gildong"};
        // 배열 names에서 문자열 "홍길동"이 처음 등장하는 인덱스를 출력.
        // 배열에 "홍길동" 문자열이 없으면 -1을 출력.
        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals("홍길동")) {
                index = i;
                break;
            }
        }
        System.out.println("index = " + index);
        
        System.out.println("Ex. 5 ---");
        String[] tests = {"테스트", "test", "Test", "문자열 TEST", "tEST"};
        // 배열 tests에서 대소문자 구분없이 "est"를 포함하는 문자열들을 출력.
        for (String s : tests) {
            if (s.toLowerCase().contains("est")) {
                System.out.print(s + "\t");
            }
        }
        System.out.println();
        
        System.out.println("Ex. 6 ---");
        String today = "2024/10/28";
        // 문자열 today(YYYY/MM/DD)에서 년/월/일 정보를 int 타입 변수(들)에 저장.
        // 년/월/일을 출력.
        String[] strArray = today.split("/");
        int year = Integer.parseInt(strArray[0]);
        int month = Integer.parseInt(strArray[1]);
        int day = Integer.parseInt(strArray[2]);
        System.out.printf("year=%d, month=%d, day=%d\n", year, month, day);
        
    }

}
