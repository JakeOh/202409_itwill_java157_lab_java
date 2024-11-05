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
    public int getX() {
        return x; // this.x
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    @Override
    public String toString() {
        return String.format("Outer(x=%d, y=%d, s=%s)", x, y, s);
    }
    
    // static이 아닌(non-static) 멤버 내부 클래스
    public class Inner {
        // field
        private int x;
        
        // constructor
        public Inner(int x) {
            this.x = x;
        }
        
        // method
        public void info() {
            System.out.println("--- Inner class ---");
            System.out.println("Inner.x = " + x); // this.x, Inner.this.x
            System.out.println("Outer.x = " + Outer.this.x);
            System.out.println("Outer.y = " + y); // Outer.this.y
            System.out.println("Outer.s = " + s); // Outer.this.s
            //-> 내부 클래스에서는 외부 클래스의 멤버 (필드/메서드)를 사용할 수 있음.
            // ClassName.this: ClassName 타입으로 생성된 인스턴스.
            // ClassName.super: ClassName의 상위 타입으로 생성된 인스턴스.
            
            System.out.println("-------------------");
        }
    }

}
