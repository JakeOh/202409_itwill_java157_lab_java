package com.itwill.swing08;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPanel;
    private JPanel buttonPanel;
    private JButton cancelButton;
    private JButton okButton;
    
    // MyDialog의 부모 컴포넌트를 저장하기 위해서.
    private Component parentComponent;

    /**
     * Launch the application.
     */
    public static void showMyDialog(Component parentComponent) {
        try {
            MyDialog dialog = new MyDialog(parentComponent);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog. 생성자.
     */
    public MyDialog(Component parentComponent) {
        this.parentComponent = parentComponent;
        initialize();
    }
    
    public void initialize() {
        // 다이얼로그의 기본 닫기 버튼(x)의 동작을 설정:
        // DISPOSE_ON_CLOSE: 현재 다이얼로그만 닫고(종료), 메인 프로세스는 계속 실행.
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        // 다이얼로그가 보여지는 좌표(x, y)와 다이얼로그의 크기(width, height)를 설정:
        setBounds(100, 100, 450, 300);
        if (parentComponent != null) {
            setLocationRelativeTo(parentComponent);
            //-> setBounds 메서드에서 설정한 x, y 좌표를 무시하고, 
            // 부모 컴포넌트에 상대적으로(부모의 가운데 위치에) 다이얼로그를 배치.
        }

        // 컨텐트 페인의 레이아웃 설정
        getContentPane().setLayout(new BorderLayout());

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        // 컨텐트 패널의 레이아웃을 absolute layout으로 설정.
        contentPanel.setLayout(null);

        // ctrl+shitf+F: 코드 들여쓰기 자동 맞춤

        buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        cancelButton = new JButton("Cancel");
        cancelButton.setActionCommand("Cancel");
        buttonPanel.add(cancelButton);

        okButton = new JButton("OK");
        okButton.setActionCommand("OK");
        buttonPanel.add(okButton);
        getRootPane().setDefaultButton(okButton);

    }

}
