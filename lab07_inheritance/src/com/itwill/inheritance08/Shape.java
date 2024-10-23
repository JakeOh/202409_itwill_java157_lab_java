package com.itwill.inheritance08;

public abstract class Shape {
    // field
    protected String type; // 직사각형, 원, ...
    
    // constructor -> 상속하는 하위 클래스에서만 호출 가능.
    public Shape(String type) {
        this.type = type;
    }
    
    // 추상 메서드: body를 갖지 않는 메서드.
    public abstract double area(); // 도형의 넓이를 리턴하는 메서드.
    public abstract double perimeter(); // 도형의 둘레 길이를 리턴하는 메서드.

    // final 메서드: 하위 클래스에서 override할 수 없는 메서드.
    public final void draw() {
        String msg = String.format("%s [넓이: %f, 둘레: %f]\n", 
                type, area(), perimeter());
        System.out.println(msg);
    }
    
}
