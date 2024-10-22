package com.itwill.inheritance03;

public class InheritanceMain03 {

    public static void main(String[] args) {
        // Car 타입의 객체 생성:
        Car car1 = new Car(50, 30);
        car1.drive();
        
        // HybridCar 타입의 객체 생성:
        HybridCar car2 = new HybridCar(20, 55, 50);
        car2.charge(100);
        car2.drive();

        // 다형성(polymorphism):
        // 상위 타입으로 선언된 변수에 하위 타입의 객체를 할당하는 것.
        // SuperType var = new SubType();
        Car car3 = new HybridCar(0, 0, 0);
        
        // (주의) 하위 타입으로 선언된 변수에 상위 타입의 객체를 할당할 수는 없음.
        // HybridCar hcar = new Car(0, 0);

        // car3.charge();
        //-> 상위 타입으로 선언된 변수이기 때문에 하위 타입에서 선언된 메서드를 호출할 수 없음.
        
        ((HybridCar) car3).charge(100);
        //-> 변수를 casting(강제 타입 변환)하면 하위 타입의 메서드도 호출할 수 있음.

        car3.drive();
        //-> 다형성으로 선언된 변수에서 오버라이드된 메서드를 호출하면,
        // 하위 타입에서 재정의된 내용이 실행됨!

        
    }

}
