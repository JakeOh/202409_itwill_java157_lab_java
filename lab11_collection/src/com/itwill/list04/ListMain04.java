package com.itwill.list04;

import java.util.Arrays;
import java.util.List;

public class ListMain04 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "java", 
                "sql", 
                "html",
                "css",
                "javascript",
                "servlet/jsp",
                "spring"
        );
        System.out.println(names);
        
        // 리스트 names에서 5글자 이상인 문자열들을 대문자로 변환해서 저장한 ArrayList를 만들고 출력.
        
        // 리스트 names 원소의 글자수들을 저장하는 ArrayList를 만들고 출력.
        
        List<Integer> codes = Arrays.asList(1, 0, 1, 1, 0, 1, 0);
        System.out.println(codes);

        // 리스트 codes의 원소가 0이면 "남성", 1이면 "여성"을 저장하는 ArrayList를 만들고 출력.
        
    }

}
