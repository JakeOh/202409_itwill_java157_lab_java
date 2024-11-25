package com.itwill.jdbc.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;

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

    private BlogDao blogDao;
    private Component parentComponent;
    private UpdateNotify app;
    private final Integer id;
    
    /**
     * Launch the application.
     */
    public static void showBlogDetailsFrame(Component parentComponent, UpdateNotify app, 
            Integer id) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    BlogDetailsFrame frame = new BlogDetailsFrame(parentComponent, app, id);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 생성자
    private BlogDetailsFrame(Component parentComponent, UpdateNotify app, Integer id) {
        this.blogDao = BlogDao.INSTANCE;
        this.parentComponent = parentComponent;
        this.app = app;
        this.id = id;
        
        initialize(); // UI 컴포넌트들을 생성, 초기화.
        initializeBlog(); // 아이디(PK)로 검색한 블로그 내용을 JTextField와 JTextArea에 씀.
    }
    
    /**
     * UI 컴포넌트 생성, 초기화.
     */
    public void initialize() {
        setTitle("블로그 상세보기");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setBounds(100, 100, 450, 600);
        setLocationRelativeTo(parentComponent);
        
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
        textId.setEditable(false);
        textId.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textId.setBounds(124, 10, 288, 40);
        mainPanel.add(textId);
        textId.setColumns(10);
        
        lblTitle = new JLabel("제목");
        lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblTitle.setBounds(12, 60, 100, 40);
        mainPanel.add(lblTitle);
        
        textTitle = new JTextField();
        textTitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
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
        textAuthor.setEditable(false);
        textAuthor.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textAuthor.setColumns(10);
        textAuthor.setBounds(124, 310, 288, 40);
        mainPanel.add(textAuthor);
        
        lblCreatedTime = new JLabel("작성시간");
        lblCreatedTime.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblCreatedTime.setBounds(12, 360, 100, 40);
        mainPanel.add(lblCreatedTime);
        
        textCreatedTime = new JTextField();
        textCreatedTime.setEditable(false);
        textCreatedTime.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textCreatedTime.setColumns(10);
        textCreatedTime.setBounds(124, 360, 288, 40);
        mainPanel.add(textCreatedTime);
        
        lblModifidedTime = new JLabel("수정시간");
        lblModifidedTime.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblModifidedTime.setBounds(12, 410, 100, 40);
        mainPanel.add(lblModifidedTime);
        
        textModifiedTime = new JTextField();
        textModifiedTime.setEditable(false);
        textModifiedTime.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textModifiedTime.setColumns(10);
        textModifiedTime.setBounds(124, 410, 288, 40);
        mainPanel.add(textModifiedTime);
        
        buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        btnUpdate = new JButton("업데이트");
        btnUpdate.addActionListener(e -> updateBlog());
        btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 20));
        buttonPanel.add(btnUpdate);
        
        btnCancel = new JButton("취소");
        btnCancel.addActionListener(e -> dispose());
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 20));
        buttonPanel.add(btnCancel);
    }
    
    private void updateBlog() {
        // 제목, 내용을 읽음.
        String title = textTitle.getText();
        String content = textContent.getText();
        if (title.equals("") || content.equals("")) {
            JOptionPane.showMessageDialog(
                    BlogDetailsFrame.this, 
                    "제목과 내용은 반드시 입력해야 합니다.", 
                    "경고", 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // DAO의 메서드를 호출해서 업데이트를 실행.
        Blog blog = Blog.builder().id(id).title(title).content(content).build();
        int result = blogDao.update(blog);
        if (result == 1) { // 1개 행이 업데이트됨.
            JOptionPane.showMessageDialog(BlogDetailsFrame.this, "업데이트 성공");
            app.notifyUpdateSuccess(); // BlogMain 창에게 업데이트 성공을 알려줌.
            dispose(); // 현재 창 닫기.
        } else { // 업데이트 실패
            JOptionPane.showMessageDialog(BlogDetailsFrame.this, "업데이트 실패");
        }
        
    }
    
    private void initializeBlog() {
        Blog blog = blogDao.read(id);
        
        textId.setText(blog.getId().toString());
        textTitle.setText(blog.getTitle());
        textContent.setText(blog.getContent());
        textAuthor.setText(blog.getAuthor());
        textCreatedTime.setText(blog.getCreatedTime().toString());
        textModifiedTime.setText(blog.getModifiedTime().toString());
    }

}
