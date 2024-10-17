package com.itwill.class07;

// this의 의미:
// (1) 자기 자신 클래스 타입으로 생성된 객체(인스턴스).
//     (예) 필드 참조 - this.x, 메서드 호출 - this.method()
// (2) 같은 클래스의 다른(오버로딩된) 생성자.
//     (예) 생성자 호출 - this(x), this(x, y)
//     (주의) this(...) 생성자 호출 코드는 다른 실행문들보다 먼저 실행되어야 함!
//     (주의) this(...) 생성자 호출에서는 new 키워드를 사용하지 않음.

public class TestCls {
    // field
    int x;
    int y;
    int z;
    
    // constructor
    public TestCls() {}
    
    public TestCls(int x, int y, int z) {
        // this: TestCls 타입으로 생성된 객체.
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public TestCls(int x) {
        this(); // TestCls 클래스의 기본 생성자 호출. 
        this.x = x;
    }
    
    public TestCls(int x, int y) {
        this(x, y, 0); // TestCls 클래스의 아규먼트 3개를 갖는 생성자를 호출.
    }

    public void info() {
        System.out.printf("x=%d, y=%d, z=%d\n", this.x, this.y, this.z);
    }
    
}
