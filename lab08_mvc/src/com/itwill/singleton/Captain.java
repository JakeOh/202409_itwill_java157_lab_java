package com.itwill.singleton;

public class Captain {
    // field
    private String name;
    
    // (1) private static field
    private static Captain instance = null;
    
    // (2) private constructor
    private Captain() {
        this.name = "캡틴 아메리카";
    }
    
    // (3) public static 메서드 -> 싱글톤 객체 생성, 리턴.
    public static Captain getInstance() {
        if (instance == null) {
            instance = new Captain(); // 같은 클래스 안에서는 private 생성자를 호출할 수 있음.
        }
        
        return instance;
    }
    
    // getter & setter
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
