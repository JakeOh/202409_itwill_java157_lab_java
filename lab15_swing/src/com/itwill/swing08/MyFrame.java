package com.itwill.swing08;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class MyFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    // JFrame의 부모 컴포넌트를 저장하기 위해서.
    private Component parentComponent; 
    
    private JLabel lblTitle;
    private JTextField textField;
    private JButton btnSave;
    
    /**
     * Launch the application.
     */
    public static void showMyFrame(Component parentComponent) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyFrame frame = new MyFrame(parentComponent);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame. 생성자.
     */
    public MyFrame(Component parentComponent) {
        this.parentComponent = parentComponent;
        initialize();
    }
    
    public void initialize() {
        // JFrame 기본 닫기 버튼의 동작을 설정.
        // - EXIT_ON_CLOSE: 프로그램 종료.
        // - DISPOSE_ON_CLOSE: 현재 창(JFrame)만 닫고(종료하고) 메인 프로세스는 계속 진행.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // JFrame의 좌표(x, y)와 크기(width, height) 설정.
        int x = 100;
        int y = 100;
        if (parentComponent != null) {
            x = parentComponent.getX(); // 부모 컴포넌트의 x 좌표
            y = parentComponent.getY(); // 부모 컴포넌트의 y 좌표
        }
        setBounds(x, y, 519, 356);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        // JPanel 객체를 컨텐트 페인으로 설정.
        setContentPane(contentPane);
        
        // 컨텐트 페인의 레이아웃을 absolute layout으로 설정.
        contentPane.setLayout(null);
        
        lblTitle = new JLabel("입력하세요.");
        lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblTitle.setBounds(12, 10, 479, 62);
        contentPane.add(lblTitle);
        
        textField = new JTextField();
        textField.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textField.setBounds(12, 78, 479, 62);
        contentPane.add(textField);
        textField.setColumns(10);
        
        btnSave = new JButton("저장");
        
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO AppMain08 클래스의 saveInputMessage() 메서드 호출
                
            }
        });
        
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btnSave.setBounds(12, 150, 479, 62);
        contentPane.add(btnSave);
    }
}
