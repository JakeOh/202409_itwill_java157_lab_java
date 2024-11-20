package com.itwill.jdbc.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class BlogMain {

    private JFrame frame;
    private JPanel searchPanel;
    private JComboBox comboBox;
    private JTextField textSearchKeyword;
    private JButton btnSearch;
    private JScrollPane scrollPane;
    private JTable table;
    private JPanel buttonPanel;
    private JButton btnReadAll;
    private JButton btnCreate;
    private JButton btnDetails;
    private JButton btnDelete;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogMain window = new BlogMain();
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
    public BlogMain() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        searchPanel = new JPanel();
        frame.getContentPane().add(searchPanel, BorderLayout.NORTH);
        
        comboBox = new JComboBox();
        searchPanel.add(comboBox);
        
        textSearchKeyword = new JTextField();
        searchPanel.add(textSearchKeyword);
        textSearchKeyword.setColumns(10);
        
        btnSearch = new JButton("검색");
        searchPanel.add(btnSearch);
        
        scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        btnReadAll = new JButton("목록 보기");
        btnReadAll.setFont(new Font("D2Coding", Font.PLAIN, 20));
        buttonPanel.add(btnReadAll);
        
        btnCreate = new JButton("새 블로그 작성");
        btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 20));
        buttonPanel.add(btnCreate);
        
        btnDetails = new JButton("상세보기");
        btnDetails.setFont(new Font("D2Coding", Font.PLAIN, 20));
        buttonPanel.add(btnDetails);
        
        btnDelete = new JButton("삭제");
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 20));
        buttonPanel.add(btnDelete);
    }

}
