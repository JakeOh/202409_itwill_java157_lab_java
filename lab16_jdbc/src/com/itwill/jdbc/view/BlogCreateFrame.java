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

public class BlogCreateFrame extends JFrame {
    
    public interface CreateNotify {
        void notifyCreateSuccess();
    }

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JLabel lblTitle;
    private JTextField textTitle;
    private JLabel lblContent;
    private JScrollPane scrollPane;
    private JTextArea textContent;
    private JLabel lblAuthor;
    private JTextField textAuthor;
    private JButton btnSave;
    private JButton btnCancel;
    
    private BlogDao blogDao;
    private Component parentComponent;
    private CreateNotify app;

    /**
     * Launch the application.
     */
    public static void showBlogCreateFrame(Component parentComponent, CreateNotify app) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    BlogCreateFrame frame = new BlogCreateFrame(parentComponent, app);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 생성자
    private BlogCreateFrame(Component parentComponent, CreateNotify app) {
        this.blogDao = BlogDao.INSTANCE;
        this.parentComponent = parentComponent;
        this.app = app;
        initialize();
    }
    
    /**
     * UI 컴포넌트들을 초기화.
     */
    public void initialize() {
        // JFrame의 타이틀 설정.
        setTitle("새 블로그 작성");
        
        // 기본 닫기 버튼(x)의 동작 - 현재 창만 닫기.
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        setBounds(100, 100, 450, 500);
        
        // 부모 컴포넌트의 가운데 위치에 창을 띄움.
        // 부모 컴포넌트가 null이면 화면의 가운데 위치에 창을 띄움.
        setLocationRelativeTo(parentComponent);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        mainPanel = new JPanel();
        contentPane.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(null);
        
        lblTitle = new JLabel("제목");
        lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblTitle.setBounds(12, 10, 400, 40);
        mainPanel.add(lblTitle);
        
        textTitle = new JTextField();
        textTitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textTitle.setBounds(12, 60, 400, 40);
        mainPanel.add(textTitle);
        textTitle.setColumns(10);
        
        lblContent = new JLabel("내용");
        lblContent.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblContent.setBounds(12, 110, 400, 40);
        mainPanel.add(lblContent);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 160, 400, 120);
        mainPanel.add(scrollPane);
        
        textContent = new JTextArea();
        textContent.setFont(new Font("D2Coding", Font.PLAIN, 20));
        scrollPane.setViewportView(textContent);
        
        lblAuthor = new JLabel("작성자");
        lblAuthor.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblAuthor.setBounds(12, 290, 400, 40);
        mainPanel.add(lblAuthor);
        
        textAuthor = new JTextField();
        textAuthor.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textAuthor.setColumns(10);
        textAuthor.setBounds(12, 340, 400, 40);
        mainPanel.add(textAuthor);
        
        buttonPanel = new JPanel();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        btnSave = new JButton("저장");
        btnSave.addActionListener(e -> createNewBlog());
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 20));
        buttonPanel.add(btnSave);
        
        btnCancel = new JButton("취소");
        btnCancel.addActionListener(e -> dispose());
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 20));
        buttonPanel.add(btnCancel);
    }
    
    private void createNewBlog() {
        // 제목, 내용, 작성자에 입력된 문자열을 읽고, DAO의 메서드를 호출해서 DB에 insert.
        String title = textTitle.getText();
        String content = textContent.getText();
        String author = textAuthor.getText();
        
        // 제목, 내용, 작성자가 비어 있으면 사용자에게 경고 메시지를 주고 메서드를 종료.
        if (title.equals("") || content.equals("") || author.equals("")) {
            JOptionPane.showMessageDialog(
                    BlogCreateFrame.this, 
                    "제목, 내용, 작성자는 반드시 입력해야 합니다.", 
                    "경고", 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Blog 객체 생성
        Blog blog = Blog.builder().title(title).content(content).author(author).build(); 
        
        // DAO의 메서드 호출.
        int result = blogDao.create(blog);
        if (result == 1) { // 1개 행이 삽입됨.
            JOptionPane.showMessageDialog(BlogCreateFrame.this, "새 블로그 작성 성공");
            
            // 메인 창(BlogMain)에게 insert 성공했다고 알려줌.
            app.notifyCreateSuccess();
            
            dispose(); // 창 닫기.
        } else { // insert 실패.
            JOptionPane.showMessageDialog(BlogCreateFrame.this, "새 블로그 작성 실패");
        }
        
    }
    
}
