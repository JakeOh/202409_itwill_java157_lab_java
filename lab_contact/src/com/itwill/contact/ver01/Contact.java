package com.itwill.contact.ver01;

// 연락처 데이터(이름, 전화번호, 이메일) 저장하는 클래스.
public class Contact {
    // field
    private String name;
    private String phone;
    private String email;
    
    // constructor
    // (1) 기본 생성자.
    public Contact() {}
    
    // (2) name, phone, email을 아규먼트로 갖는 생성자.
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    // method
    // getters & setters
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    // 연락처 정보를 출력.
    public void info() {
        System.out.printf("Contact(name=%s, phone=%s, email=%s)\n",
                this.name, this.phone, this.email);
    }
    
    public String toString() {
        return "Contact(name=" + this.name
                + ", phone=" + this.phone
                + ", email=" + this.email
                + ")";
    }

}
