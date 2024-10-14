package com.itwill.class02;

// 클래스: 객체 설계도. 데이터(필드) + 기능(메서드) + 생성자 => 변수 타입.
public class Score {
    // 필드(field)/멤버 변수 선언:
    // 필드: 같은 클래스의 메서드들에서 사용할 수 있는 변수.
    int korean;
    int english;
    int math;
    
    // 생성자 선언:
    public Score() {
        // 실행문이 없으면 필드의 모든 값들은 그 타입의 기본값으로 초기화됨.
    }
    
    public Score(int korean, int english, int math) {
        // this: Score 타입으로 생성된 객체.
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
    
    // 메서드 선언:
    // 메서드는 필드에 할당(저장)된 값들을 사용할 수 있음.
    public int getTotal() {
        return korean + english + math;
    }
    
    public double getMean() {
        return (double) getTotal() / 3;
    }
    
}
