package com.itwill.inner06;

import com.itwill.inner06.CheckBox.OnSelectListener;

//교재 연습문제 3.
public class CheckBoxExample {

    public static void main(String[] args) {
        CheckBox checkBox = new CheckBox();
        
        checkBox.setOnSelectListener(new OnSelectListener() {
            @Override
            public void onSelect() {
                System.out.println("배경을 변경합니다.");
            }
        });
        
        checkBox.select();
    }

}
