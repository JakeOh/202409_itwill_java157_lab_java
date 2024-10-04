package com.itwill.loop01;

public class LoopMain01 {

    public static void main(String[] args) {
        System.out.println("Java 1");
        System.out.println("Java 2");
        System.out.println("Java 3");
        System.out.println("Java 4");
        System.out.println("Java 5");
        
        System.out.println("---------------");
        
        // for 반복문
        for (int n = 1; n <= 5; n++) {
            System.out.println("Java " + n);
        }
        
        // 증가/감소 연산자: ++(값을 1 증가), --(값을 1 감소).
        // 증가/감소 연산자는 변수의 앞 또는 뒤에서 사용 가능: ++n, n++
        // 증가/감소 연산자가 변수 앞에 사용된 경우에는 다른 연산보다 먼저 증가/감소 연산이 수행.
        // 증가/감소 연산자가 변수 뒤에 사용된 경우에는 다른 연산을 수행한 후에 증가/감소가 수행.
        int a = 1;
        int b = 1;
        int c = a + ++b; // b++; c = a + b;
        System.out.println("b = " + b + ", c = " + c);
        
        b = 1;
        c = a + b++; // c = a + b; b++;
        System.out.println("b = " + b + ", c = " + c);
        
        // 복합 할당(대입) 연산자: +=, -=, *=, /=, %=, ...
        int x = 1;
        System.out.println("x = " + x);
        x++;
        // x += 1;
        // x = x + 1;
        System.out.println("x = " + x);
    }

}
