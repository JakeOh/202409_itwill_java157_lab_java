package com.itwill.swing07;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppMain07 {
    private static final String[] PROVINCES = { "서울시", "경기도", "부산시" };
    private static final String[] SEOUL_CITIES = { "강남구", "강동구", "강북구", "강서구" };
    private static final String[] GG_CITIES = { "고양시", "성남시", "파주시" };
    private static final String[] BUSAN_CITIES = { "수영구", "연제구", "해운대구" };
    private static final String[][] CITIES = { SEOUL_CITIES, GG_CITIES, BUSAN_CITIES };

    private JFrame frame;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private DefaultComboBoxModel<String> model1;
    private DefaultComboBoxModel<String> model2;
    private JButton btnConfirm;
    private JLabel lblResult;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain07 window = new AppMain07();
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
    public AppMain07() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 658, 312);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        comboBox1 = new JComboBox<>();
        
        model1 = new DefaultComboBoxModel<>(PROVINCES);
        comboBox1.setModel(model1);
        
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = comboBox1.getSelectedIndex();
                model2 = new DefaultComboBoxModel<>(CITIES[index]);
                comboBox2.setModel(model2);
            }
        });
        
        comboBox1.setFont(new Font("D2Coding", Font.PLAIN, 24));
        comboBox1.setBounds(12, 10, 200, 62);
        frame.getContentPane().add(comboBox1);
        
        comboBox2 = new JComboBox<>();
        
        model2 = new DefaultComboBoxModel<>(SEOUL_CITIES);
        comboBox2.setModel(model2);
        
        comboBox2.setFont(new Font("D2Coding", Font.PLAIN, 24));
        comboBox2.setBounds(224, 10, 200, 62);
        frame.getContentPane().add(comboBox2);
        
        btnConfirm = new JButton("확인");
        
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = comboBox1.getSelectedItem() + " " + comboBox2.getSelectedItem();
                lblResult.setText(msg);
            }
        });
        
        btnConfirm.setFont(new Font("D2Coding", Font.PLAIN, 24));
        btnConfirm.setBounds(436, 10, 200, 62);
        frame.getContentPane().add(btnConfirm);
        
        lblResult = new JLabel("선택");
        lblResult.setFont(new Font("D2Coding", Font.PLAIN, 24));
        lblResult.setBounds(12, 82, 618, 62);
        frame.getContentPane().add(lblResult);
    }
}
