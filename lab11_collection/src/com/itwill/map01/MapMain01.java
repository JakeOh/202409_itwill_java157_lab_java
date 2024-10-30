package com.itwill.map01;

import java.util.HashMap;
import java.util.Set;

/*
 * Collection<E>
 * |__ List<E>, Set<E>, ...
 * 
 * Map<K, V>
 * |__ HashMap<K, V>, TreeMap<K, V>
 * 
 * Map<K, V>: 키(Key)와 값(Value)의 쌍으로 구성된 데이터를 저장하는 자료 구조.
 * (1) Key: 중복된 값을 가질 수 없음. Map에서 하나의 값을 찾기 위한 인덱스와 비슷한 역할.
 *     - 정수일 필요는 없음. 0부터 시작하거나 연속된 정수일 필요는 없음.
 *     - 데이터를 저장/검색/수정/삭제할 때 값을 찾기 위한 용도.
 * (2) Value: 중복된 값을 가질 수 있음.
 * 
 * HashMap<K, V>: Key를 기준으로 검색을 빠르게 할 수 있는 Map.
 * TreeMap<K, V>: Key를 기준으로 정렬을 빠르게 할 수 있는 Map.
 */

public class MapMain01 {

    public static void main(String[] args) {
        // 정수를 key로 하고, 문자열을 value로 갖는 HashMap을 선언, 초기화.
        HashMap<Integer, String> students = new HashMap<>(); // new HashMap<Integer, String>();

        System.out.println(students);
        System.out.println("size = " + students.size());
        
        // Map에 key-value 데이터를 저장: put(key, value)
        students.put(1, "김민석");
        students.put(2, "김종후");
        students.put(10, "최호철");
        
        System.out.println(students);
        System.out.println("size = " + students.size());
        
        // put(key, value) 메서드:
        // (1) key가 Map에 존재하지 않으면, 새로운 데이터(key-value)를 추가.
        // (2) key가 Map에 존재하면, key에 매핑된 값(value)만 변경.
        students.put(10, "오쌤");
        System.out.println(students);
        
        // Map에 key에 매핑된 값(value) 찾기: get(key)
        System.out.println(students.get(1)); // key가 맵에 존재하면, 매핑된 값을 리턴.
        System.out.println(students.get(3)); // key가 맵에 없으면, null을 리턴.
        
        // getOrDefault(key, defaultValue):
        // (1) key가 맵에 존재하면, key에 매핑된 값을 리턴.
        // (2) key가 맵에 없으면, defaultValue를 리턴.
        System.out.println(students.getOrDefault(1, "무명씨"));
        System.out.println(students.getOrDefault(3, "무명씨"));
        
        // keySet(): 맵이 가지고 있는 key들의 집합(Set<K>)을 리턴.
        Set<Integer> keySet = students.keySet();
        for (Integer k : keySet) {
            System.out.println(k + " : " + students.get(k));
        }
        
        // remove(key): key에 매핑된 key-value 데이터를 삭제.
        students.remove(10);
        System.out.println(students);
        
    }

}
