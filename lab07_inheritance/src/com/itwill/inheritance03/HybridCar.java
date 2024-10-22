package com.itwill.inheritance03;

public class HybridCar extends Car {
    // field
    private int battery;
    
    // constructor
    public HybridCar(int fuel, int speed, int battery) {
        super(fuel, speed);
        this.battery = battery;
    }
    
    // method
    public void charge(int battery) {
        this.battery = battery;
        System.out.println("충전중: battery = " + battery);
    }
    
    /*
     * 메서드 오버라이딩(method overriding):
     * - 상위 타입(superclass)에서 선언된 메서드를 하위 타입(subclass)에서 재정의하는 것.
     * - 리턴 타입, 메서드 이름, 파라미터 선언이 모두 같아야 함.
     * - 접근 수식어는 상위 타입 수식어의 가시성과 같거나 더 넓어지는 것은 가능.
     * 
     * 메서드 오버로딩(method overloading):
     * - 파라미터가 다르면 같은 이름으로 메서드를 여러개 선언할 수 있는 것.
     */
    
    @Override // 애너테이션(annotation) - 자바 컴파일러가 사용.
    public void drive() {
        // super.drive(); //-> 상위 타입의 메서드를 명시적으로 호출.
        System.out.printf("하이브리드 자동차 운전중(속력: %d, 연료: %d, 배터리:%d)\n",
                getSpeed(), getFuel(), battery); 
    }
    
}
