package com.itwill.contact.ver05.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactMain05 {
    // 테이블 컬럼 이름
    private static final String[] COLUMN_NAMES = { "이름", "전화번호" };

    private JFrame frame;
    private JPanel buttonPanel;
    private JButton btnSave;
    private JButton btnSearch;
    private JButton btnUpdate;
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
                    ContactMain05 window = new ContactMain05();
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
    public ContactMain05() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 468, 468);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("연락처 v0.5");
        
        buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        btnSave = new JButton("추가");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactCreateFrame.showContactCreateFrame();
            }
        });
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 24));
        buttonPanel.add(btnSave);
        
        btnSearch = new JButton("검색");
        btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 24));
        buttonPanel.add(btnSearch);
        
        btnUpdate = new JButton("수정");
        btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 24));
        buttonPanel.add(btnUpdate);
        
        btnDelete = new JButton("삭제");
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 24));
        buttonPanel.add(btnDelete);
        
        scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        
        scrollPane.setViewportView(table);
    }

}
