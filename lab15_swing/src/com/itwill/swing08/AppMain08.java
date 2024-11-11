package com.itwill.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain08 {

    private JFrame frame;
    private JButton btnMsgDlg;
    private JButton btnConfirmDlg;
    private JButton btnInputDlg;
    private JButton btnCustomDlg;
    private JButton btnCustomFrame;

    public void saveInputMessage(String msg) {
        btnCustomFrame.setText(msg);
    }
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain08 window = new AppMain08();
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
    public AppMain08() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 420, 474);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        btnMsgDlg = new JButton("Message Dialog");
        
        btnMsgDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 메시지 다이얼로그 보여주기:
                // JOptionPane.showMessageDialog(frame, "안녕하세요!");
                JOptionPane.showMessageDialog(
                        frame,                    // 부모 컴포넌트 - 메시지 다이얼로그가 보여지는 위치가 결정. 
                        "안녕하세요, swing!",     // 다이얼로그에서 보여 줄 메시지.
                        "메시지",                 // 다이얼로그 타이틀(제목줄) 
                        JOptionPane.INFORMATION_MESSAGE // 메시지 타입
                );
            }
        });
        
        btnMsgDlg.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btnMsgDlg.setBounds(12, 10, 380, 48);
        frame.getContentPane().add(btnMsgDlg);
        
        btnConfirmDlg = new JButton("Confirm Dialog");
        
        btnConfirmDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Confirm(확인) 다이얼로그 보여주기:
                // int result = JOptionPane.showConfirmDialog(frame, "정말 삭제?");
                int result = JOptionPane.showConfirmDialog(
                        frame,                       // 부모 컴포넌트 
                        "정말 삭제할까요?",          // 메시지 
                        "삭제 확인",                 // 타이틀 
                        JOptionPane.YES_NO_OPTION,   // 옵션 타입(확인 버튼 종류, 개수) 
                        JOptionPane.QUESTION_MESSAGE // 메시지 타입(메시지 옆의 아이콘 설정)
                );
                
                btnConfirmDlg.setText("confirm dialog result = " + result);
            }
        });
        
        btnConfirmDlg.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btnConfirmDlg.setBounds(12, 68, 380, 48);
        frame.getContentPane().add(btnConfirmDlg);
        
        btnInputDlg = new JButton("Input Dialog");
        
        btnInputDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 입력(Input) 다이얼로그 보여주기:
                // String result = JOptionPane.showInputDialog("검색어");
                
                final String[] selectionValues = { "인*", "너튜브", "X" };
                Object result  = JOptionPane.showInputDialog(
                        frame, // 부모 컴포넌트
                        "검색어 입력", // 메시지
                        "검색", // 타이틀
                        JOptionPane.QUESTION_MESSAGE, // 메시지 타입 
                        null, // 아이콘
                        selectionValues, // 선택 값들의 배열 
                        selectionValues[1] // 초기 선택 값
                );
                // selectionValues가 null인 경우에는 입력 다이얼로그에 텍스트 필드가 보임.
                // selectionValues가 배열인 경우에는 콤보박스가 보임.
                
                btnInputDlg.setText("input dialog result = " + result);
            }
        });
        
        btnInputDlg.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btnInputDlg.setBounds(12, 126, 380, 48);
        frame.getContentPane().add(btnInputDlg);
        
        btnCustomDlg = new JButton("Custom Dialog");
        
        btnCustomDlg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyDialog.showMyDialog(frame);
            }
        });
        
        btnCustomDlg.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btnCustomDlg.setBounds(12, 184, 380, 48);
        frame.getContentPane().add(btnCustomDlg);
        
        btnCustomFrame = new JButton("Custom Frame");
        
        btnCustomFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame.showMyFrame(frame, AppMain08.this);
            }
        });
        
        btnCustomFrame.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btnCustomFrame.setBounds(12, 242, 380, 48);
        frame.getContentPane().add(btnCustomFrame);
    }

}
