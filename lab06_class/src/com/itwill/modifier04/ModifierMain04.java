package com.itwill.modifier04;

import com.itwill.modifier05.PublicClassExample;
//import com.itwill.modifier05.PackageClassExample;
//-> 패키지 범위의 클래스는 다른 패키지의 클래스에서 import할 수 없음.

/*
 * 클래스 멤버의 접근 수식어: private < (package) < protected < public
 * 클래스의 접근 수식어:
 * (1) (package): 수식어 없는 경우. 같은 패키지 안에서만 공개된 클래스.
 * (2) public: 어디서든지(모든 패키지에서) 공개된 클래스.
 * (주의) public 클래스의 이름은 java 파일의 이름과 같아야 함!
 * 하나의 java 파일 안에서 여러개의 클래스들을 선언하는 것은 가능.
 * 하나의 java 파일 안에는 public 클래스는 오직 1개만 선언해야 함.
 * 하나의 java 파일 안에 여러개의 클래스를 선언한 경우, 컴파일 후에는
 * 각각의 클래스 파일(바이트 코드)들이 만들어 짐.
 */

class A {}

class B {}

public class ModifierMain04 {

    public static void main(String[] args) {
        // com.itwill.modifier05.PublicClassExample 타입의 변수 선언, 초기화.
        PublicClassExample ex = new PublicClassExample();
        
        // com.itwill.modifier05.PackageClassExample 타입 변수 선언?
        // com.itwill.modifier05.PackageClassExample ex2; //-> not visible

    }

}
