package com.itwill.menu;

public enum Captain2 {
    INSTANCE("캡틴 아메리카");
    
    private String name;
    
    Captain2(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
