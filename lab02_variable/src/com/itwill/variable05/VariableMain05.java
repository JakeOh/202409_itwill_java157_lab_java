package com.itwill.variable05;

public class VariableMain05 {

    public static void main(String[] args) {
        // boolean 타입: true/false 만을 저장하는 타입.
        // boolean 타입은 비교 연산, 논리 연산의 결과를 저장할 때 사용.
        // 비교 연산자: ==, !=, >, >=, <, <=
        // 논리 연산자: &&, ||, !

        int x = 2;
        int y = 3;
        
        boolean isEqual = (x == y);
        System.out.println("isEqual = " + isEqual);
        
        boolean isNotEqual = (x != y);
        System.out.println("isNotEqual = " + isNotEqual);
        
        boolean lessThan = (x < y);
        System.out.println("lessThan = " + lessThan);
        
        boolean b = (x > 0) && (x < 10);
        System.out.println("b = " + b);
        
    }

}
