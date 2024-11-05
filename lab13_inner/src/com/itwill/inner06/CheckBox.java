package com.itwill.inner06;

//교재 연습문제 3.
public class CheckBox {
    OnSelectListener listener;
    
    void setOnSelectListener(OnSelectListener listener) {
        this.listener = listener;
    }
    
    void select() {
        listener.onSelect();
    }
    
    interface OnSelectListener {
        void onSelect();
    }

}
