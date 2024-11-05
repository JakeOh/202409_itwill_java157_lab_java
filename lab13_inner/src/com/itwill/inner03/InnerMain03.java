package com.itwill.inner03;

import com.itwill.inner03.Button.OnClickListener;

public class InnerMain03 {

    public static void main(String[] args) {
        // Button 타입 객체 생성
        Button btnFinish = new Button("종료");
        
        // 생성된 Button 타입 객체의 setter 호출: 리스너 객체를 세팅
        // 리스너 객체의 역할: 버튼이 클릭됐을 때 할 일을 정의.
        OnClickListener listener = new FinishButtonListener(); // 다형성
        btnFinish.setOnClickListener(listener);
        
        // 종료 버튼을 클릭
        btnFinish.click();

    }

}
