package com.itwill.jdbc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.itwill.jdbc.controller.BlogDao;
import com.itwill.jdbc.model.Blog;
import com.itwill.jdbc.view.BlogCreateFrame.CreateNotify;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// MVC 아키텍쳐에서 View를 담당하는 객체.
public class BlogMain implements CreateNotify {
    
    // JComboBox의 아이템 이름들을 상수로 선언.
    private static final String[] SEARCH_TYPE = {
            "제목", "내용", "제목+내용", "작성자"
    };
    
    // JTable의 컬럼 이름들을 상수로 선언.
    private static final String[] COLUMN_NAMES = {
            "번호", "제목", "작성자", "작성시간"
    };

    private JFrame frame;
    private JPanel searchPanel;
    private JComboBox<String> comboBox;
    private JTextField textSearchKeyword;
    private JButton btnSearch;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel model;
    private JPanel buttonPanel;
    private JButton btnReadAll;
    private JButton btnCreate;
    private JButton btnDetails;
    private JButton btnDelete;
    
    // MVC 아키텍쳐에서 Controller 객체.
    private BlogDao blogDao;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
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
        blogDao = BlogDao.INSTANCE;
        initialize();
        initializeTable();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("블로그 앱 v1.0");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        searchPanel = new JPanel();
        frame.getContentPane().add(searchPanel, BorderLayout.NORTH);
        
        comboBox = new JComboBox<>();
        
        // JComboBox의 아이템 설정.
        final DefaultComboBoxModel<String> comboBoxModel = 
                new DefaultComboBoxModel<String>(SEARCH_TYPE);
        comboBox.setModel(comboBoxModel);
        
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 20));
        searchPanel.add(comboBox);
        
        textSearchKeyword = new JTextField();
        textSearchKeyword.setFont(new Font("D2Coding", Font.PLAIN, 20));
        searchPanel.add(textSearchKeyword);
        textSearchKeyword.setColumns(20);
        
        btnSearch = new JButton("검색");
        btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 20));
        searchPanel.add(btnSearch);
        
        scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        // JTable의 컬럼 이름 설정.
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        
        buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        btnReadAll = new JButton("목록 보기");
        btnReadAll.setFont(new Font("D2Coding", Font.PLAIN, 20));
        buttonPanel.add(btnReadAll);
        
        btnCreate = new JButton("새 블로그 작성");
        btnCreate.addActionListener(e -> 
                BlogCreateFrame.showBlogCreateFrame(frame, BlogMain.this));
        btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 20));
        buttonPanel.add(btnCreate);
        
        btnDetails = new JButton("상세보기");
        btnDetails.setFont(new Font("D2Coding", Font.PLAIN, 20));
        buttonPanel.add(btnDetails);
        
        btnDelete = new JButton("삭제");
        btnDelete.addActionListener(e -> deleteBlog());
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 20));
        buttonPanel.add(btnDelete);
    }
    
    private void deleteBlog() {
        // JTable에서 선택된 행을 찾음.
        int index = table.getSelectedRow();
        if (index == -1) { // 선택된 행이 없는 경우
            JOptionPane.showMessageDialog(
                    frame, 
                    "테이블에서 삭제할 행을 먼저 선택하세요.", 
                    "경고", 
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // 사용자에게 삭제 여부를 확인.
        int confirm = JOptionPane.showConfirmDialog(
                frame, 
                "정말 삭제할까요?", 
                "삭제 확인", 
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // TODO: JTable에서 선택된 행의 첫번째 컬럼(번호 - 블로그 아이디) 값을 읽고,
            // DAO 메서드를 호출해서, DB 테이블에서 행을 삭제.
        }
        
    }
    
    private void initializeTable() {
        // Controller(DAO)의 메서드를 호출해서 DB에 저장된 데이터를 읽어옴.
        List<Blog> list = blogDao.read();
        resetTableModel(list);
    }
    
    private void resetTableModel(List<Blog> list) {
        model = new DefaultTableModel(null, COLUMN_NAMES);
        
        for (Blog b : list) {
            Object[] rowData = {
                    b.getId(), b.getTitle(), b.getAuthor(), b.getCreatedTime()
            };
            model.addRow(rowData);
        }
        
        table.setModel(model);
    }

    // BlogCreateFrame.CreateNotify 인터페이스를 구현(implements)하기 위해서.
    @Override
    public void notifyCreateSuccess() {
        initializeTable();
    }

}
