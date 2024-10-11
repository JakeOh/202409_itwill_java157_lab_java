package com.itwill.method01;

import java.util.Random;

/*
 * 메서드(method): 클래스 안에서 작성하는 함수(function), 기능.
 * - 프로그램에서 필요한 기능을 코드 블록으로 작성한 것.
 * - 기능이 필요한 곳에 불러서(호출해서) 사용하기 위한 코드 블록.
 * - 자바 언어는 클래스 안에서만 함수를 작성할 수 있음! (자바는 메서드만 작성할 수 있음)
 * - 자바 언어는 클래스 밖에서 함수를 작성할 수 없음!
 * 
 * argument(아규먼트, 인수): 메서드를 호출하는 곳에서 메서드에게 전달하는 "값".
 * - 메서드를 호출할 때 항상 아규먼트를 전달하는 것은 아님. 아규먼트가 없을 수도 있음.
 * parameter(파라미터, 매개변수, 인자): 아규먼트를 저장하기 위해서 선언하는 "변수".
 * return value(반환값): 메서드가 기능을 모두 수행한 후에 메서드를 호출한 곳으로 반환하는 값.
 * - 메서드에 따라서 반환값이 있을 수도 있고, 반환값이 없을 수도 있음.
 */

public class MethodMain01 {

    public static void main(String[] args) {
        System.out.println("안녕하세요."); //-> println() 메서드 호출.
        //-> 아규먼트: "안녕하세요."
        //-> 파라미터: public void println(String x) {...} 메서드 선언에서 "String x" 변수.
        //-> println() 메서드는 반환값이 없는 메서드. return 하지 않는 메서드.
        
        Random rand = new Random();
        int x = rand.nextInt(10); // nextInt(정수) 메서드: 정수 난수를 반환(return).
        //-> nextInt()는 반환값이 있는 메서드.
        System.out.println("x = " + x);
    }

}
