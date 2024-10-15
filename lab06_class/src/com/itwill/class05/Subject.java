package com.itwill.class05;

public class Subject {
    // field
    int java; // 자바 과목 점수
    int sql; // SQL 과목 점수
    int html; // HTML 과목 점수
    int javascript; // JavaScript 과목 점수

    // constructor
    // (1) 기본 생성자
    public Subject() {}
    
    // (2) 4과목의 점수를 초기화하는 (아규먼트 4개를 갖는) 생성자
    public Subject(int java, int sql, int html, int javascript) {
        this.java = java;
        this.sql = sql;
        this.html = html;
        this.javascript = javascript;
    }
    
    // method
    // (1) getTotal: 4과목의 총점을 리턴.
    public int getTotal() {
        return this.java + this.sql + this.html + this.javascript;
//        return java + sql + html + javascript;
    }
    
    // (2) getMean: 4과목의 평균(double)을 리턴.
    public double getMean() {
        return (double) getTotal() / 4;
    }
    
    // (3) info: 4과목의 점수, 총점, 평균을 출력.
    public void info() {
        System.out.println("Java: " + this.java);
        System.out.println("SQL: " + this.sql);
        System.out.println("HTML: " + this.html);
        System.out.println("JavaScript: " + this.javascript);
        System.out.println("총점: " + this.getTotal());
        System.out.println("평균: " + this.getMean());
    }
    
}
