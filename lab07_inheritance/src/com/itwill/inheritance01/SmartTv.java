package com.itwill.inheritance01;

// 스마트TV은 기본TV을 확장(상속)한다.
// BasicTv: 상위(super), 부모(parent), 기본(base) 클래스
// SmartTv: 하위(sub), 자식(child), 유도된(derived) 클래스
// 모든 클래스의 최상위 클래스는 java.lang.Object 클래스.
// 상위 클래스가 Object인 경우 extends Object 선언은 생략 가능.
public class SmartTv extends BasicTv {
    // field
    private String ip;
    
    // getter & setter
    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }
}
