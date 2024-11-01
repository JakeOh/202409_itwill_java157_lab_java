package com.itwill.file04;

import java.io.Serializable;
//-> Serializable 인터페이스는 반드시 구현해야 할 추상 메서드가 없음.
//-> 파일에 자바 객체를 직렬화해서 쓰기 위해서.
//-> 파일에서 읽은 이진 데이터를 자바 객체로 역직렬화하기 위해서.

public class Product implements Serializable {
    // 직렬화 가능한 객체에 부여하는 아이디(옵션, 선택사항):
    private static final long serialVersionUID = 4856050309281817531L;
   
    private int code; // 상품 코드
    private String name; // 상품 이름
    private double price; // 상품 가격
    
    public Product() {}

    public Product(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [code=" + code + ", name=" + name + ", price=" + price + "]";
    }
    
}
