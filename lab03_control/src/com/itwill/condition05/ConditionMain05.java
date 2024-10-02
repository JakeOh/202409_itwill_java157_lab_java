package com.itwill.condition05;

public class ConditionMain05 {

    public static void main(String[] args) {
        // 중첩 조건문: if 블록 또는 else 블록 안에 또다른 조건문이 있는 경우.

        int number = 0;
        if (number > 0) {
            System.out.println("양수");
        } else {
            if (number == 0) {
                System.out.println("영");
            } else {
                System.out.println("음수");
            }
        }
        
    }

}
