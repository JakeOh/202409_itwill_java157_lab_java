package com.itwill.jdbc.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class BlogDetailsFrame extends JFrame {
    
    public interface UpdateNotify {
        void notifyUpdateSuccess();
    }

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JLabel lblId;
    private JTextField textId;
    private JLabel lblTitle;
    private JTextField textTitle;
    private JLabel lblContent;
    private JScrollPane scrollPane;
    private JTextArea textContent;
    private JLabel lblAuthor;
    private JTextField textAuthor;
    private JLabel lblCreatedTime;
    private JTextField textCreatedTime;
    private JLabel lblModifidedTime;
    private JTextField textModifiedTime;
    private JButton btnUpdate;
    private JButton btnCancel;

    private Component parentComponent;
    private UpdateNotify app;
    
    /**
     * Launch the application.
     */
    public static void showBlogDetailsFrame(Component parentComponent, UpdateNotify app) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    BlogDetailsFrame frame = new BlogDetailsFrame(parentComponent, app);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 생성자
    private BlogDetailsFrame(Component parentComponent, UpdateNotify app) {
        this.parentComponent = parentComponent;
        this.app = app;
        initialize();
    }
    
    /**
     * UI 컴포넌트 생성, 초기화.
     */
    public void initialize() {
        setTitle("블로그 상세보기");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setBounds(100, 100, 450, 600);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        mainPanel = new JPanel();
        contentPane.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(null);
        
        lblId = new JLabel("번호");
        lblId.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblId.setBounds(12, 10, 100, 40);
        mainPanel.add(lblId);
        
        textId = new JTextField();
        textId.setBounds(124, 10, 288, 40);
        mainPanel.add(textId);
        textId.setColumns(10);
        
        lblTitle = new JLabel("제목");
        lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblTitle.setBounds(12, 60, 100, 40);
        mainPanel.add(lblTitle);
        
        textTitle = new JTextField();
        textTitle.setColumns(10);
        textTitle.setBounds(124, 60, 288, 40);
        mainPanel.add(textTitle);
        
        lblContent = new JLabel("내용");
        lblContent.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblContent.setBounds(12, 110, 100, 40);
        mainPanel.add(lblContent);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 160, 400, 140);
        mainPanel.add(scrollPane);
        
        textContent = new JTextArea();
        textContent.setFont(new Font("D2Coding", Font.PLAIN, 20));
        scrollPane.setViewportView(textContent);
        
        lblAuthor = new JLabel("작성자");
        lblAuthor.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblAuthor.setBounds(12, 310, 100, 40);
        mainPanel.add(lblAuthor);
        
        textAuthor = new JTextField();
        textAuthor.setColumns(10);
        textAuthor.setBounds(124, 310, 288, 40);
        mainPanel.add(textAuthor);
        
        lblCreatedTime = new JLabel("작성시간");
        lblCreatedTime.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblCreatedTime.setBounds(12, 360, 100, 40);
        mainPanel.add(lblCreatedTime);
        
        textCreatedTime = new JTextField();
        textCreatedTime.setColumns(10);
        textCreatedTime.setBounds(124, 360, 288, 40);
        mainPanel.add(textCreatedTime);
        
        lblModifidedTime = new JLabel("수정시간");
        lblModifidedTime.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblModifidedTime.setBounds(12, 410, 100, 40);
        mainPanel.add(lblModifidedTime);
        
        textModifiedTime = new JTextField();
        textModifiedTime.setColumns(10);
        textModifiedTime.setBounds(124, 410, 288, 40);
        mainPanel.add(textModifiedTime);
        
        buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        btnUpdate = new JButton("업데이트");
        btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 20));
        buttonPanel.add(btnUpdate);
        
        btnCancel = new JButton("취소");
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 20));
        buttonPanel.add(btnCancel);
    }

}
