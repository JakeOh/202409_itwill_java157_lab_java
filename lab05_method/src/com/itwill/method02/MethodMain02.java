package com.itwill.method02;

/*
 * 메서드 선언(정의) 방법:
 * [수식어] 리턴타입 메서드이름([파라미터 선언, ...]) { ...; ...; }
 * - 수식어는 생략 가능.
 * - 수식어 종류: public, protected, private, static, abstract, final
 * - 아규먼트를 전달받지 않는 메서드는 파라미터를 선언하지 않음.
 * - 파라미터가 여러개일 때는 쉼표(,)로 구분.
 * - 반환값이 있는 메서드는 반환값의 타입을 메서드 이름 앞에 명시.
 * - 반환값이 없는 메서드는 메서드 이름 앞에 "void"라고 명시.
 * - 메서드는 클래스 안에서만 작성!
 * - 메서드 안에서 또다른 메서드를 작성할 수 없음!
 * - 메서드 이름은 변수 이름과 같이 소문자로 시작하는 camel 표기법을 권장.
 * - 메서드 이름의 규칙(문법)은 변수 이름 규칙과 동일.
 */

public class MethodMain02 {

    public static void main(String[] args) {
        // 아규먼트가 있고, 리턴 값도 있는 메서드 작성 연습:
        
        // 메서드는 호출해야 실행이 됨!
        double result = add(1.0, 2.0);
        System.out.println("result = " + result);
        
        result = add(10.0, 2.0);
        System.out.println("result = " + result);
    
        // subtract() 메서드를 호출하고 그 결과를 출력.
        result = subtract(1.0, 2.0);
        System.out.println("result = " + result);
        
        result = subtract(2.0, 1.0);
        System.out.println("result = " + result);
        
        // mulitply() 메서드를 호출하고 그 결과를 출력.
        result = multiply(3, 2);
        System.out.println("result = " + result);
        
        // divide() 메서드를 호출하고 그 결과를 출력.
        result = divide(1, 2);
        System.out.println("result = " + result);
    }
    
    // 메서드 선언 -> 문서 주석(documentation comment)를 함께 작성할 수 있음.
    /**
     * 아규먼트로 전달받은 두 숫자 x와 y의 덧셈 결과를 리턴.
     * 
     * @param x {@code double}.
     * @param y {@code double}.
     * @return {@code x + y}.
     */
    public static double add(double x, double y) {
        return x + y;
    }
    
    /**
     * 숫자 2개를 전달받아서, 두 숫자의 뺄셈 결과({@code x - y})를 리턴.
     * 
     * @param x double.
     * @param y double.
     * @return x - y.
     */
    public static double subtract(double x, double y) {
        return x - y;
    }
    
    /**
     * multiply. 숫자 2개를 전달받아서, 두 숫자의 곱셈 결과를 리턴하는 메서드.
     * 
     * @param x double.
     * @param y double.
     * @return x * y.
     */
    public static double multiply(double x, double y) {
        return x * y;
    }
    
    /**
     * divide. 숫자 2개를 전달받아서, 첫번째 아규먼트를 두번째 아규먼트로 나눈 값을 리턴.
     * 
     * @param x double.
     * @param y double.
     * @return x / y.
     */
    public static double divide(double x, double y) {
        return x / y;
    }
    
}
