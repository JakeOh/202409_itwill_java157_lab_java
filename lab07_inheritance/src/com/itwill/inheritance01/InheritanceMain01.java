package com.itwill.inheritance01;

public class InheritanceMain01 {

    public static void main(String[] args) {
        // BasicTv 타입 변수 선언, 초기화.
        BasicTv tv1 = new BasicTv();
        System.out.println(tv1.toString());
        
        tv1.powerOnOff();
        System.out.println(tv1.toString());
        
        tv1.channelUp();
        tv1.channelUp();
        System.out.println(tv1.toString());
        
        tv1.powerOnOff();
        System.out.println(tv1.toString());
    }

}
