package com.itwill.map02;

import java.util.Set;
import java.util.TreeMap;

public class MapMain02 {

    public static void main(String[] args) {
        // 문자열을 key로 하고, 정수를 값(value)으로 하는 TreeMap을 생성, 초기화.
        TreeMap<String, Integer> menu = new TreeMap<>();
        
        menu.put("짜장면", 8000);
        menu.put("탕수육", 20000);
        menu.put("짬뽕", 9000);
        menu.put("볶음밥", 9000);
        
        System.out.println(menu); //-> key의 오름차순(ascending) 정렬.
        // 내림차순(descending)
        
        // TreeMap<K, V>.keySet(): "오름차순" 정렬된 key들의 집합(Set<K>)을 리턴.
        Set<String> keySet = menu.keySet();
        for (String k : keySet) {
            System.out.println(k + "=" + menu.get(k));
        }
        
        System.out.println("----------");
        
        // TreeMap<K, V>.descendingKeySet(): "내림차순" 정렬된 key들의 집합을 리턴.
        Set<String> descKeySet = menu.descendingKeySet();
        for (String k : descKeySet) {
            System.out.println(k + ":" + menu.get(k));
        }
        
    }

}
