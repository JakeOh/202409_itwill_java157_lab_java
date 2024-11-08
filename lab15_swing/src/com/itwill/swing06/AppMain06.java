package com.itwill.swing06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain06 {

    private JFrame frame;
    private JRadioButton rbPrivate;
    private JRadioButton rbPackage;
    private JRadioButton rbProtected;
    private JRadioButton rbPublic;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JCheckBox cbAbstract;
    private JCheckBox cbFinal;
    private JCheckBox cbStatic;
    private JComboBox<String> comboBox;
    private JButton btnInfo;
    private JScrollPane scrollPane;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain06 window = new AppMain06();
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
    public AppMain06() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 631, 407);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        rbPrivate = new JRadioButton("private");
        rbPrivate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRadioButtonClick(e);
            }
        });
        rbPrivate.setSelected(true);
        buttonGroup.add(rbPrivate);
        rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 24));
        rbPrivate.setBounds(8, 6, 140, 60);
        frame.getContentPane().add(rbPrivate);
        
        rbPackage = new JRadioButton("package");
        rbPackage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRadioButtonClick(e);
            }
        });
        buttonGroup.add(rbPackage);
        rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 24));
        rbPackage.setBounds(152, 6, 140, 60);
        frame.getContentPane().add(rbPackage);
        
        rbProtected = new JRadioButton("protected");
        rbProtected.addActionListener(e -> handleRadioButtonClick(e));
        buttonGroup.add(rbProtected);
        rbProtected.setFont(new Font("D2Coding", Font.PLAIN, 24));
        rbProtected.setBounds(296, 6, 140, 60);
        frame.getContentPane().add(rbProtected);
        
        rbPublic = new JRadioButton("public");
        rbPublic.addActionListener(this::handleRadioButtonClick);
        buttonGroup.add(rbPublic);
        rbPublic.setFont(new Font("D2Coding", Font.PLAIN, 24));
        rbPublic.setBounds(440, 6, 140, 60);
        frame.getContentPane().add(rbPublic);
        
        cbAbstract = new JCheckBox("abstract");
        cbAbstract.setFont(new Font("D2Coding", Font.PLAIN, 24));
        cbAbstract.setBounds(8, 68, 140, 60);
        frame.getContentPane().add(cbAbstract);
        
        cbFinal = new JCheckBox("final");
        cbFinal.setFont(new Font("D2Coding", Font.PLAIN, 24));
        cbFinal.setBounds(152, 68, 140, 60);
        frame.getContentPane().add(cbFinal);
        
        cbStatic = new JCheckBox("static");
        cbStatic.setFont(new Font("D2Coding", Font.PLAIN, 24));
        cbStatic.setBounds(296, 68, 140, 60);
        frame.getContentPane().add(cbStatic);
        
        comboBox = new JComboBox<>();
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 24));
        
        final String[] items = { "naver.com", "kakao.com", "gmail.com", "yahoo.com" };
        final DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
        comboBox.setModel(model);
        
        comboBox.setBounds(8, 134, 284, 60);
        frame.getContentPane().add(comboBox);
        
        btnInfo = new JButton("확인");
        btnInfo.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btnInfo.setBounds(296, 134, 284, 60);
        frame.getContentPane().add(btnInfo);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(8, 212, 572, 144);
        frame.getContentPane().add(scrollPane);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("D2Coding", Font.PLAIN, 24));
        scrollPane.setViewportView(textArea);
    }
    
    private void handleRadioButtonClick(ActionEvent e) {
        // 4개의 라디오버튼들 중에서 누가 클릭됐는 지 확인:
        JRadioButton btn = (JRadioButton) e.getSource(); // 이벤트가 발생한 GUI 컴포넌트
        String text = btn.getText(); // 라디오버튼의 텍스트
        boolean selected = btn.isSelected(); // 라디오버튼의 선택 여부
        textArea.setText(text + " - " + selected);
    }
    
}
