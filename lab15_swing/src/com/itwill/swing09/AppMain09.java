package com.itwill.swing09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AppMain09 {
    // 테이블 컬럼 이름
    private static final String[] COLUMN_NAMES = {
            "국어", "영어", "수학", "총점", "평균",
    };

    private JFrame frame;
    private JLabel lblKorean;
    private JTextField textKorean;
    private JLabel lblEnglish;
    private JTextField textEnglish;
    private JLabel lblMath;
    private JTextField textMath;
    private JButton btnSave;
    private JButton btnDelete;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel model;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain09 window = new AppMain09();
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
    public AppMain09() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 502);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        lblKorean = new JLabel("국어");
        lblKorean.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblKorean.setBounds(12, 10, 120, 60);
        frame.getContentPane().add(lblKorean);
        
        textKorean = new JTextField();
        textKorean.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textKorean.setBounds(144, 10, 278, 60);
        frame.getContentPane().add(textKorean);
        textKorean.setColumns(10);
        
        lblEnglish = new JLabel("영어");
        lblEnglish.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblEnglish.setBounds(12, 82, 120, 60);
        frame.getContentPane().add(lblEnglish);
        
        textEnglish = new JTextField();
        textEnglish.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textEnglish.setColumns(10);
        textEnglish.setBounds(144, 82, 278, 60);
        frame.getContentPane().add(textEnglish);
        
        lblMath = new JLabel("수학");
        lblMath.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblMath.setBounds(12, 152, 120, 60);
        frame.getContentPane().add(lblMath);
        
        textMath = new JTextField();
        textMath.setFont(new Font("D2Coding", Font.PLAIN, 24));
        textMath.setColumns(10);
        textMath.setBounds(144, 152, 278, 60);
        frame.getContentPane().add(textMath);
        
        btnSave = new JButton("저장");
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btnSave.setBounds(12, 222, 120, 60);
        frame.getContentPane().add(btnSave);
        
        btnDelete = new JButton("삭제");
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btnDelete.setBounds(144, 222, 120, 60);
        frame.getContentPane().add(btnDelete);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 292, 410, 161);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable();
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        scrollPane.setViewportView(table);
    }
}
