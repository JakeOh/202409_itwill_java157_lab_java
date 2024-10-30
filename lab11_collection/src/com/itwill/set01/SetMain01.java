package com.itwill.set01;

import java.util.TreeSet;

/*
 * Collection<E>
 * |__ List<E>
 *     |__ ArrayList<E>, LinkedList<E>, ...
 * 
 * Collection<E>
 * |__ Set<E>
 *     |__ HashSet<E>, TreeSet<E>, ...
 * 
 * Set<E> 특징:
 * (1) 같은 값(equals() true인 값)을 저장하지 못함. (예) {1, 2, 2, 3, 3, 3} = {1, 2, 3}
 * (2) 저장하는 순서가 중요하지 않음. (예) {1, 2} = {2, 1}
 * (3) 인덱스가 없음.
 * 
 * HashSet<E>: Hash 알고리즘(검색을 빠르게 하기 위한 알고리즘)을 사용한 집합(Set).
 * TreeSet<E>: Tree 알고리즘(정렬을 빠르게 하기 위한 알고리즘)을 사용한 집합(Set).
 */

public class SetMain01 {

    public static void main(String[] args) {
        // 정수들을 저장하는 TreeSet을 선언, 초기화:
        TreeSet<Integer> numbers = new TreeSet<>();
        
        System.out.println(numbers);
        System.out.println("size = " + numbers.size());
        
        // Set<E>에 원소 저장: add(E e)
        numbers.add(1);
        numbers.add(100);
        numbers.add(-1);
        numbers.add(16);
        
        System.out.println(numbers);
        System.out.println("size = " + numbers.size());
        
        // Set<E>은 get(int index) 메서드를 제공하지 않음!
        // for (int i = 0; i < set.size(); i++) 구문을 사용할 수 없음.
        // 향상된 for 문장은 사용 가능.
        for (Integer n : numbers) {
            System.out.print(n + ", ");
        }
        System.out.println();
        
        // Set<E>은 remove(int index) 메서드는 제공하지 않음.
        // remove(Object o) 메서드만 있음.
        numbers.remove(16);
        System.out.println(numbers);

    }

}
