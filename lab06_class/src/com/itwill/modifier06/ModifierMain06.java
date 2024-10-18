package com.itwill.modifier06;
// "java.", "javax."으로 시작하는 패키지 이름은 JDK에서만 사용 가능. JDK 이외에서는 사용 불가.

/*
 * 접근 수식어(access modifier)들은 클래스의 멤버(필드, 생성자, 메서드)에서만 사용 가능.
 * 지역 변수에서는 접근 수식어를 사용할 수 없음.
 * 
 * final 수식어:
 * - 클래스, 클래스 멤버, 지역 변수에서 사용 가능.
 * - final 의미: 바꿀 수 없는.
 * - final 필드/지역 변수: 한 번 초기화가 되면 더이상 값을 변경할 수 없는 변수. 상수(constant).
 * - final 필드는 반드시
 *   (1) 선언과 동시에 초기화를 하거나, 또는
 *   (2) 생성자에서 final 필드를 명시적으로 초기화해야 함!
 * - final class, final 메서드는 상속을 학습한 이후에...
 */

public class ModifierMain06 {
    // final field
    private final int VERSION = 1; // 선언과 동시에 초기화한 final 필드
    
    private final String message; // 생성자에서 명시적으로 초기화할 final 필드
    
    public ModifierMain06(String message) {
        this.message = message; // final 필드를 명시적으로 초기화.
    }
    
    // field
    private int x;
    
    // setter
    public void setX(int x) {
        this.x = x;
    }

    public static void main(String[] args) {
        int n = 0;
        n = 100;
        
        final int version = 1;
        // version = 2; //-> final 지역 변수는 값을 재할당(변경)할 수 없음.
    }

}
