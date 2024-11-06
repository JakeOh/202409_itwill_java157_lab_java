package com.itwill.lambda04;

public class Employee {
    private int id; // 사번
    private String name; // 이름
    private String dept; // 부서(department) 이름
    private String jobTitle; // 직급(사원, 대리, 과장, ...)
    private double salary; // 급여
    
    // 생성자
    public Employee(int id, String name, String dept, String jobTitle, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    // TODO: getters & setters, toString
    
}
