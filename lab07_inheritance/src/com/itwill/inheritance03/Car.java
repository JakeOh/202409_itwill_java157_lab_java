package com.itwill.inheritance03;

// 하이브리드 자동차는 자동차이다.
// IS-A 관계: 자동차 - 상위 타입(superclass), 하이브리드 자동차 - 하위 타입(subclass)
// class HybridCar extends Car

public class Car {
    // field
    private int fuel;
    private int speed;
    
    // constructor(생성자)
    public Car(int fuel, int speed) {
        // super(); 명시적 호출은 생략(omit) 가능.
        this.fuel = fuel;
        this.speed = speed;
    }

    // getters & setters
    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    // method
    public void drive() {
        System.out.println("자동차 운전중(속력: " + speed + ", 연료: " + fuel + ")");
    }
    
}
