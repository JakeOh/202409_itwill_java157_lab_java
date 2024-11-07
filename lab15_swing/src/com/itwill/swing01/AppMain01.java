package com.itwill.swing01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AppMain01 {
    // field
    private JFrame frame;
    private JLabel lblTitle;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        // JRE에 의해서 실행될 쓰레드를 등록함.
        // invokeLater 메서드의 아규먼트 Runnable - 쓰레드가 할 일(task)
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    AppMain01 window = new AppMain01(); // AppMain01 타입 객체 생성.
                    window.frame.setVisible(true); // JFrame 객체를 화면에 보여줌.
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application. 생성자.
     */
    public AppMain01() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame(); // JFrame 객체 생성
        
        // JFrame의 시작 좌표(x, y)와 크기(width, height)를 설정
        frame.setBounds(400, 400, 600, 400);
        
        // JFrame 오른쪽 위에 있는 닫기 버튼(X)의 동작을 설정 - EXIT_ON_CLOSE(프로그램 종료)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // JLabel 타입 객체 생성
        lblTitle = new JLabel("안녕하세요, Swing!");
        // 레이블 문자열의 정렬 위치 - 가운데로 설정.
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        // 레이블의 폰트 설정
        lblTitle.setFont(new Font("D2Coding", Font.BOLD, 26));
        // JFrame의 컨텐트 패널에 레이블을 추가 -> 레이블이 보이게 됨.
        frame.getContentPane().add(lblTitle, BorderLayout.CENTER);
    }

}
