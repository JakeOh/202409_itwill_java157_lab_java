package com.itwill.lambda01;

import com.itwill.lambda01.Calculator.Calculable;

public class LambdaMain01 {

    public static void main(String[] args) {
        // Calculator 타입 객체 생성
        Calculator calculator = new Calculator(1, 2);
        
        //--- 별도의 java 파일에서 인터페이스를 구현하는 클래스를 작성, 그 객체를 생성.
        Calculable adder = new Adder(); // 다형성
        
        // Calculator 객체에서 calculate(x, y) 메서드를 호출해서 계산.
        double result = calculator.calculate(adder);
        System.out.println("result = " + result);

    }

}
