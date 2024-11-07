package com.itwill.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 {

    private JFrame frame;
    private JLabel lblTitle;
    private JTextField textField;
    private JButton btnInput;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain02 window = new AppMain02();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AppMain02() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 396);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 컨텐트 패널의 기본 레이아웃은 BorderLayout.
        // -> 컨텐트 패널의 레이아웃을 absolute 레이아웃으로 변경.
        frame.getContentPane().setLayout(null);
        
        lblTitle = new JLabel("텍스트를 입력하세요...");
        lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 26));
        lblTitle.setBounds(12, 10, 760, 88);
        frame.getContentPane().add(lblTitle);
        
        textField = new JTextField();
        textField.setFont(new Font("D2Coding", Font.PLAIN, 26));
        textField.setBounds(12, 108, 772, 88);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        btnInput = new JButton("저장");
        
        // 버튼의 이벤트 리스너(핸들러)를 설정(등록) - 버튼 (클릭) 기능을 작성.
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 내부 클래스는 바깥 클래스의 멤버(필드, 메서드)를 사용할 수 있음.
                handleBtnInputClick();
            }
        });
//        btnInput.addActionListener(e -> handleBtnInputClick());
        
        btnInput.setFont(new Font("D2Coding", Font.BOLD, 26));
        btnInput.setBounds(12, 206, 760, 88);
        frame.getContentPane().add(btnInput);
    }
    
    // btnInput 버튼을 클릭했을 때 할 일(기능)을 작성:
    private void handleBtnInputClick() {
        // 1. textField에 입력된 내용을 읽어 옴.
        String text = textField.getText();
        
        // 2. 입력 내용을 lblTitle에 씀.
        lblTitle.setText(text);
        
        // 3. textField에 입력된 내용을 지움.
        textField.setText("");
    }
    
}
