package com.itwill.swing03;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class AppMain03 {

    private JFrame frame;
    private JLabel lblImage;
    private JButton btnPrev;
    private JButton btnNext;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain03 window = new AppMain03();
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
    public AppMain03() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 464, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        lblImage = new JLabel("");
        lblImage.setIcon(new ImageIcon("images/photo1.jpg"));
        lblImage.setBounds(12, 10, 400, 400);
        frame.getContentPane().add(lblImage);
        
        btnPrev = new JButton("<");
        btnPrev.setFont(new Font("D2Coding", Font.BOLD, 26));
        btnPrev.setBounds(12, 420, 97, 64);
        frame.getContentPane().add(btnPrev);
        
        btnNext = new JButton(">");
        btnNext.setFont(new Font("D2Coding", Font.BOLD, 26));
        btnNext.setBounds(315, 420, 97, 64);
        frame.getContentPane().add(btnNext);
    }

}
