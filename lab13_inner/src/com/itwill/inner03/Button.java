package com.itwill.inner03;

public class Button {
    //public static 내부 인터페이스 -> static 생략 가능.
    public interface OnClickListener {
        void onClick(); // public abstract 생략.
    }
    
    // class Button의 필드.
    private String name;
    private OnClickListener onClickListener;
    
    // class Button의 생성자.
    public Button(String name) {
        this.name = name;
    }
    
    // class Button의 setter
    public void setOnClickListener(OnClickListener listener) {
        this.onClickListener = listener;
    }
    
    // class Button의 메서드
    public void click() {
        System.out.print(name + " 버튼: ");
        onClickListener.onClick();
    }

}
