package com.itwill.class07;

public class ClassMain07 {

    public static void main(String[] args) {
        // TestCls 클래스 타입의 인스턴스를 여러가지 생성자를 이용해서 생성
        TestCls c1 = new TestCls();
        c1.info();
        
        TestCls c2 = new TestCls(100);
        c2.info();

        TestCls c3 = new TestCls(1, 2);
        c3.info();
        
        TestCls c4 = new TestCls(1, 2, 3);
        c4.info();
    }

}
