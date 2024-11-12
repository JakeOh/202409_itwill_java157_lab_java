package com.itwill.contact.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ContactCreateFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JLabel lblName;
    private JTextField textName;
    private JLabel lblPhone;
    private JTextField textPhone;
    private JLabel lblEmail;
    private JTextField textEmail;
    private JButton btnSave;
    private JButton btnCancel;

    /**
     * Launch the application.
     */
    public static void showContactCreateFrame() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactCreateFrame frame = new ContactCreateFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    private ContactCreateFrame() {
        initialize();
    }
    
    private void initialize() {
        setTitle("새 연락처 추가");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        mainPanel = new JPanel();
        contentPane.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(null);
        
        lblName = new JLabel("이름");
        lblName.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblName.setBounds(12, 10, 120, 40);
        mainPanel.add(lblName);
        
        textName = new JTextField();
        textName.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textName.setBounds(144, 10, 268, 40);
        mainPanel.add(textName);
        textName.setColumns(10);
        
        lblPhone = new JLabel("전화번호");
        lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblPhone.setBounds(12, 60, 120, 40);
        mainPanel.add(lblPhone);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textPhone.setColumns(10);
        textPhone.setBounds(144, 60, 268, 40);
        mainPanel.add(textPhone);
        
        lblEmail = new JLabel("이메일");
        lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblEmail.setBounds(12, 110, 120, 40);
        mainPanel.add(lblEmail);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textEmail.setColumns(10);
        textEmail.setBounds(144, 110, 268, 40);
        mainPanel.add(textEmail);
        
        buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        btnSave = new JButton("저장");
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 24));
        buttonPanel.add(btnSave);
        
        btnCancel = new JButton("취소");
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 24));
        buttonPanel.add(btnCancel);
    }
}
