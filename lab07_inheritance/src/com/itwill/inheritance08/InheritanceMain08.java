package com.itwill.inheritance08;

public class InheritanceMain08 {

    public static void main(String[] args) {
        // Rectangle 타입 객체 생성:
        Shape rect = new Rectangle(8, 4);
        rect.draw();
        
        // Circle 타입 객체 생성:
        Shape c = new Circle(10);
        c.draw();
        
    }

}
