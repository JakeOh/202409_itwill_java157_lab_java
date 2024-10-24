package com.itwill.menu;

public class Season2 {
    // public static final 필드(상수)
    public static final Season2 SPRING = new Season2("봄");
    public static final Season2 SUMMER = new Season2("여름");
    public static final Season2 FALL = new Season2("가을");
    public static final Season2 WINTER = new Season2("겨울");

    // 필드
    private String name;
    
    // private 생성자
    private Season2(String name) {
        this.name = name;
    }
    
    // getter
    public String getName() {
        return name;
    }
    
}
