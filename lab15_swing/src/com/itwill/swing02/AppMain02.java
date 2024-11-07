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
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼이 할 일을 작성
                // textField에 입력된 내용 읽기 -> lblTitle에 입력된 내용 쓰기 -> textField 지움.
                String text = textField.getText();
                lblTitle.setText(text);
                textField.setText("");
            }
        });
        btnInput.setFont(new Font("D2Coding", Font.BOLD, 26));
        btnInput.setBounds(12, 206, 760, 88);
        frame.getContentPane().add(btnInput);
    }
}
