package com.itwill.swing09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputScoreToTable();
            }
        });
        
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btnSave.setBounds(12, 222, 120, 60);
        frame.getContentPane().add(btnSave);
        
        btnDelete = new JButton("삭제");
        
        btnDelete.addActionListener(e -> deleteScoreFromTable());
        
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
    
    private void deleteScoreFromTable() {
        // JTable에서 선택된 행의 인덱스를 찾음.
        int index = table.getSelectedRow();
        if (index == -1) { // 테이블에서 선택된 행이 없을 때
            JOptionPane.showMessageDialog(
                    frame, // 부모 컴포넌트 
                    "삭제할 행을 먼저 선택하세요!", // 메시지
                    "경고", // 타이틀
                    JOptionPane.WARNING_MESSAGE // 메시지 타입
            );
            
            return;
        }
        
        // 삭제 여부를 사용자에게 확인.
        int confirm = JOptionPane.showConfirmDialog(
                frame, // 부모 컴포넌트
                "정말 삭제할까요?", // 메시지
                "삭제 확인", // 타이틀
                JOptionPane.YES_NO_OPTION // 옵션 타입
        );
        
        // 사용자가 YES를 선택했을 때 테이블 모델에서 행을 삭제.
        if (confirm == JOptionPane.YES_OPTION) {
            model.removeRow(index);
        }
    }
    
    private void inputScoreToTable() {
        // 1. JTextField에 입력된 과목 점수들을 읽음.
        int korean = 0;
        int english = 0;
        int math = 0;
        try {
            korean = Integer.parseInt(textKorean.getText());
            english = Integer.parseInt(textEnglish.getText());
            math = Integer.parseInt(textMath.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    frame, // 부모 컴포넌트
                    "국어, 영어, 수학 점수는 정수로 입력하세요!", // 메시지
                    "입력 오류", // 타이틀(제목)
                    JOptionPane.ERROR_MESSAGE // 메시지 타입
            );
            
            return; // 메서드 종료
        }
        
        // 2. Score 타입 객체 생성.
        Score score = new Score(korean, english, math);
        
        // 3. JTable에 행(row)을 추가.
        Object[] row = {
                score.getKorean(),
                score.getEnglish(),
                score.getMath(),
                score.getTotal(),
                score.getMean(),
        };
        model.addRow(row);
        
        // 4. JTextField에 입력된 내용들을 지움.
        textKorean.setText("");
        textEnglish.setText("");
        textMath.setText("");
    }
    
}
