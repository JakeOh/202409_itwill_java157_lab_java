package com.itwill.class04;

public class Rectangle {
    // field
    double width; // 직사각형의 가로 길이
    double height; // 직사각형의 세로 길이
    
    // constructor
    // (1) 기본 생성자
    public Rectangle() {}
    
    // (2) 가로/세로 길이를 아규먼트로 전달받아서 초기화하는 생성자
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    // method
    // (1) area: 직사각형의 넓이를 리턴.
    public double area() {
        return this.width * this.height; // width * height;
    }
    
    // (2) perimeter: 직사각형의 둘레 길이를 리턴.
    public double perimeter() {
        return (this.width + this.height) * 2; // (width + height) * 2;
    }
    
}
