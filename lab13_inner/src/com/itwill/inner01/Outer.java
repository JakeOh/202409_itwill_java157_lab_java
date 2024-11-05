package com.itwill.inner01;

public class Outer {
    // field
    private int x;
    private int y;
    private String s;
    
    // constructor
    public Outer(int x, int y, String s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }
    
    // method
    @Override
    public String toString() {
        return String.format("Outer(x=%d, y=%d, s=%s)", x, y, s);
    }
    
    // static이 아닌(non-static) 멤버 내부 클래스
    public class Inner {
        
    }

}
