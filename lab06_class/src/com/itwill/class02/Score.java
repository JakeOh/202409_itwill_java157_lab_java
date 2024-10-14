package com.itwill.class02;

// 클래스: 객체 설계도. 데이터(필드) + 기능(메서드) + 생성자 => 변수 타입.
public class Score {
    // 필드(field)/멤버 변수 선언:
    // 필드: 같은 클래스의 메서드들에서 사용할 수 있는 변수.
    int korean;
    int english;
    int math;
    
    // 메서드 선언:
    // 메서드는 필드에 할당(저장)된 값들을 사용할 수 있음.
    public int getTotal() {
        return korean + english + math;
    }
    
}
