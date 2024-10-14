package com.itwill.class02;

// 클래스: 객체 설계도. 데이터(필드) + 기능(메서드) + 생성자 => 변수 타입.

// 생성자(constructor):
// 객체를 생성하고, 객체의 필드들을 초기화하는 역할.
// 생성자의 이름은 반드시 클래스의 이름과 같아야 함!
// 생성자를 작성하는 방법은 메서드 작성방법과 비슷하지만, 리턴 타입이 없음!
// 클래스를 선언할 때 생성자를 하나도 정의하지 않으면,
// 자바 컴파일러가 "기본 생성자"를 자동으로 작성해 줌.
// 클래스를 선언할 때 생성자를 직접 정의한 경우에는,
// 자바 컴파일러가 기본 생성자를 자동으로 만들어 주지 않음!
// 생성자 오버로딩: 파라미터가 다른 생성자를 여러개 만들 수 있음.

public class Score {
    // 필드(field)/멤버 변수 선언:
    // 필드: 같은 클래스의 메서드들에서 사용할 수 있는 변수.
    int korean;
    int english;
    int math;
    
    // 생성자 선언:
    // 기본 생성자(default constructor)
    public Score() {
        // 실행문이 없으면 필드의 모든 값들은 그 타입의 기본값으로 초기화됨.
    }
    
    // 아규먼트를 갖는 생성자
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
