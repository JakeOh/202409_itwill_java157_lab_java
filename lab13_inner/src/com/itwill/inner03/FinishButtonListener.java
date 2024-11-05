package com.itwill.inner03;

import com.itwill.inner03.Button.OnClickListener;

// Button.OnClickListener 인터페이스를 구현하는 클래스
public class FinishButtonListener implements OnClickListener {

    @Override
    public void onClick() {
        System.out.println("종료하고 창 닫기.");
    }

}
