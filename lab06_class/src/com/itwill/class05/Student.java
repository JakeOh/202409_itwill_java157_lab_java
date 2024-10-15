package com.itwill.class05;

public class Student {
    // field
    int id; // 학생 번호
    String name; // 학생 이름
    Subject subject; // 수강 과목(java, sql, html, javascript) 점수들
    
    // constructor
    // (1) 기본 생성자
    public Student() {}
    
    // (2) 번호/이름/과목점수를 초기화하는(아규먼트 3개를 갖는) 생성자
    public Student(int id, String name, Subject subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }
    
    // method
    // (1) info: 학생 번호, 이름, 과목 점수들, 총점, 평균을 출력.
    public void info() {
        System.out.println("--- 학생 정보 ---");
        System.out.println("번호: " + this.id);
        System.out.println("이름: " + this.name);
        if (this.subject != null) {
            this.subject.info();
        } else {
            System.out.println("과목: null");
        }
        System.out.println("------------------");
    }
    
}
