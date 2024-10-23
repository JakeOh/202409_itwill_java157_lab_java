package com.itwill.inheritance07;

/*
 * 추상 메서드(abstract method):
 * - 메서드의 signature(수식어, 리턴 타입, 이름, 파라미터 선언)만 있고,
 * 메서드의 body(몸통)이 구현되어 있지 않은 메서드.
 * - 추상 메서드는 반드시 "abstract" 키워드로 수식해야 함.
 * - 추상 메서드 선언은 반드시 세미콜론(;)으로 끝내야 함.
 * 
 * 추상 클래스(abstract class):
 * - "abstract" 키워드가 사용된 클래스.
 * - 대부분의 추상 클래스는 추상 메서드를 가지고 있는 경우가 많음.
 * - 추상 메서드를 가지고 있는 경우에는 반드시 "abstract"로 선언해야 함.
 * - 추상 클래스는 객체를 생성할 수 없음.
 * - 추상 클래스를 상속하는 클래스를 선언하고, 모든 추상 메서드들을 구현(override)한 후에
 * 객체를 생성할 수 있음.
 */

// 추상 클래스
abstract class Animal {
    public abstract void move(); // 추상 메서드
}

class Dog extends Animal {
    @Override
    public void move() {
        System.out.println("강아지 총총총...");
    }
}

public class InheritanceMain07 {
    
    public static void main(String[] args) {
        // Animal animal = new Animal(); //-> 추상 클래스는 객체를 생성(instantiate)할 수 없음.

        Animal dog = new Dog(); // 다형성
        dog.move();
        
    }

}
