package com.itwill.exception06;

public class Calculator {
    
    public int divide(int x, int y) throws Exception {
        if (y != 0) {
            return x / y;
        }
        
        // Exception 타입의 객체를 생성해서 던짐(throw).
        throw new Exception("y는 0이 될 수 없음.");
    }

}
