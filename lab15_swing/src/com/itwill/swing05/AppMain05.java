package com.itwill.swing05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain05 {

    private JFrame frame;
    private JLabel lblNumber1;
    private JTextField textNumber1;
    private JTextField textNumber2;
    private JLabel lblNumber2;
    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnMultiply;
    private JButton btnDivide;
    private JTextArea textResult;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain05 window = new AppMain05();
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
    public AppMain05() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 517, 433);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        lblNumber1 = new JLabel("Number1");
        lblNumber1.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblNumber1.setBounds(12, 10, 128, 60);
        frame.getContentPane().add(lblNumber1);
        
        textNumber1 = new JTextField();
        textNumber1.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textNumber1.setBounds(152, 10, 337, 60);
        frame.getContentPane().add(textNumber1);
        textNumber1.setColumns(10);
        
        lblNumber2 = new JLabel("Number2");
        lblNumber2.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblNumber2.setBounds(12, 80, 128, 60);
        frame.getContentPane().add(lblNumber2);
        
        textNumber2 = new JTextField();
        textNumber2.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textNumber2.setColumns(10);
        textNumber2.setBounds(152, 80, 337, 60);
        frame.getContentPane().add(textNumber2);
        
        btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(e);
            }
        });
        btnPlus.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnPlus.setBounds(12, 150, 60, 60);
        frame.getContentPane().add(btnPlus);
        
        btnMinus = new JButton("-");
        btnMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(e);
            }
        });
        btnMinus.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnMinus.setBounds(84, 150, 60, 60);
        frame.getContentPane().add(btnMinus);
        
        btnMultiply = new JButton("x");
        btnMultiply.addActionListener(e -> handleButtonClick(e));
        btnMultiply.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnMultiply.setBounds(152, 150, 60, 60);
        frame.getContentPane().add(btnMultiply);
        
        btnDivide = new JButton("/");
        btnDivide.addActionListener(this::handleButtonClick);
        btnDivide.setFont(new Font("D2Coding", Font.BOLD, 24));
        btnDivide.setBounds(224, 150, 60, 60);
        frame.getContentPane().add(btnDivide);
        
        textResult = new JTextArea();
        textResult.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textResult.setBounds(12, 220, 477, 164);
        frame.getContentPane().add(textResult);
    }
    
    // +,-,x,/ 버튼들이 할 일(이벤트 리스너)
    private void handleButtonClick(ActionEvent e) {
        System.out.println(e);
        System.out.println("action command = " + e.getActionCommand());
        System.out.println("event type id = " + e.getID());
        
        Object source = e.getSource();
        System.out.println("event source = " + source);
        if (source instanceof JButton) {
            JButton btn = (JButton) source;
            System.out.println(btn.getText());
        }
        
    }

}
