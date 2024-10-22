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

        // 다형성의 장점: 코드의 재사용성이 높아짐.
        // (예) 배열 선언 - 상위 타입의 배열을 선언하면, 상위 타입 객체 뿐만 아니라 하위 타입 객체들도 저장할 수 있음.
        // (예) 파라미터 선언 - 파라미터를 상위 타입으로 선언하면, 상위 타입 객체 뿐만 아니라 하위 타입 객체들도 아규먼트로 전달할 수 있음.
        // (예) 리턴 타입 선언 - 리턴 타입을 상위 타입으로 선언하면, 상위 타입 객체 뿐만 아니라 하위 타입 객체들도 리턴할 수 있음.
        
        Car[] cars = new Car[3];
        cars[0] = car1; // new Car(...)
        cars[1] = car2; // new HybridCar(...)
        cars[2] = car3; // new HybridCar(...)
        
        for (Car c : cars) {
            test(c);
            c.drive();
        }
    }
    
    public static void test(Car car) {
        // instanceof 연산자: 객체가 어떤 타입인 지를 검사하는 연산자.
        // 변수 instanceof 클래스이름: 변수가 클래스 타입이면 true, 그렇지 않으면 false.
        if (car instanceof HybridCar) {
            System.out.println("하이브리드 자동차 정비...");
        } else if (car instanceof Car) {
            System.out.println("자동차 정비...");
        }
    }
//    public static void test(HybridCar c) {
//        System.out.println("자동차 정비...");
//    }
    //-> 다형성이 있어서 오버로딩하는 메서드들의 개수가 줄어듦.

}
