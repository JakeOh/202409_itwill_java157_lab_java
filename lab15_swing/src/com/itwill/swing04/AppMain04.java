package com.itwill.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain04 {

    private JFrame frame;
    private JLabel lblName;
    private JTextField textName;
    private JLabel lblPhone;
    private JTextField textPhone;
    private JLabel lblEmail;
    private JTextField textEmail;
    private JButton btnInput;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain04 window = new AppMain04();
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
    public AppMain04() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        lblName = new JLabel("이름");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setForeground(Color.WHITE);
        lblName.setOpaque(true);
        lblName.setBackground(SystemColor.activeCaption);
        lblName.setFont(new Font("D2Coding", Font.BOLD, 24));
        lblName.setBounds(12, 10, 120, 60);
        frame.getContentPane().add(lblName);
        
        textName = new JTextField();
        textName.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textName.setBounds(144, 10, 328, 60);
        frame.getContentPane().add(textName);
        textName.setColumns(10);
        
        lblPhone = new JLabel("전화번호");
        lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhone.setOpaque(true);
        lblPhone.setBackground(SystemColor.activeCaption);
        lblPhone.setForeground(Color.WHITE);
        lblPhone.setFont(new Font("D2Coding", Font.BOLD, 24));
        lblPhone.setBounds(12, 80, 120, 60);
        frame.getContentPane().add(lblPhone);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textPhone.setColumns(10);
        textPhone.setBounds(144, 80, 328, 60);
        frame.getContentPane().add(textPhone);
        
        lblEmail = new JLabel("이메일");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setOpaque(true);
        lblEmail.setBackground(SystemColor.activeCaption);
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("D2Coding", Font.BOLD, 24));
        lblEmail.setBounds(12, 150, 120, 60);
        frame.getContentPane().add(lblEmail);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textEmail.setColumns(10);
        textEmail.setBounds(144, 150, 328, 60);
        frame.getContentPane().add(textEmail);
        
        btnInput = new JButton("입력");
        btnInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputContactInfo();
            }
        });
        btnInput.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnInput.setBounds(12, 220, 460, 60);
        frame.getContentPane().add(btnInput);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textArea.setBounds(12, 290, 460, 161);
        frame.getContentPane().add(textArea);
    }
    
    // btnInput 버튼의 이벤트 리스너가 할 일(기능)
    private void inputContactInfo() {
        // 텍스트 필드에 입력된 내용을 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        StringBuffer buf = new StringBuffer();
        buf.append("이름: ").append(name).append("\n")
            .append("전화번호: ").append(phone).append("\n")
            .append("이메일: ").append(email).append("\n");
        
        // textArea에 내용을 씀.
        textArea.setText(buf.toString());
        
        // 모든 텍스트 필드의 입력 내용을 지움.
        textName.setText("");
        textPhone.setText("");
        textEmail.setText("");
    }
    
}
