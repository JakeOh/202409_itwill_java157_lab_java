package com.itwill.inheritance08;

public class Rectangle extends Shape {
    
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super("직사각형"); //-> 하위 클래스의 생성자는 상위 클래스(추상 클래스)의 생성자를 호출.
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
    }
    
}
