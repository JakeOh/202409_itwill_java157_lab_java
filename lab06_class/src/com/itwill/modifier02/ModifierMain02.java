package com.itwill.modifier02;

import com.itwill.modifier01.AccessExample;
// 다른 패키지에서 선언된 클래스 이름으로 변수를 선언하려면
// (1) import 문장을 작성하고, 변수 선언에서는 클래스 이름만 사용하거나, 또는
// (2) import 문장 없이, 패키지 이름을 포함하는 전체 클래스 이름으로 변수를 선언.
// java.lang 패키지에 포함된 클래스들은 import 문장 없이 클래스 이름만으로 변수를 선언할 수 있음.
// (예) java.lang.String, java.lang.Object, java.lang.System, java.lang.Math, ...

public class ModifierMain02 {

    public static void main(String[] args) {
        // com.itwill.modifier01.AccessExample 타입의 변수 선언, 초기화.
        // (1) import 문장이 있는 경우:
        AccessExample ex = new AccessExample(1, 2, 3, 4);
        
        // (2) import 문장이 없는 경우:
//        com.itwill.modifier01.AccessExample ex = 
//                new com.itwill.modifier01.AccessExample(0, 0, 0, 0);

        // ex.b = 100; //-> not visible
        ex.info();
        //-> 다른 패키지의 클래스에서는 public으로 공개된 멤버들만 접근(사용) 가능.
    }

}
