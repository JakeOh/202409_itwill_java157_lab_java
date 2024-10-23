package com.itwill.interface03;

import com.itwill.interface02.Test;
import com.itwill.interface02.TestImpl;

public class InterfaceMain03 {

    public static void main(String[] args) {
        // 인터페이스의 멤버들 사용:
        
        // Test 인터페이스의 static 멤버:
        System.out.println(Test.VERSION);
        Test.staticMethod();
        
        // Test 인터페이스의 static이 아닌 멤버:
        Test t = new TestImpl();
        t.defaultMethod();
        t.test();

    }

}
