package com.itwill.modifier03;

public class Member {
    // field
    private String id; // 읽기 전용 -> getter만 작성
    private String password; // 읽기/쓰기 가능 -> getter, setter 작성
    
    // constructor
    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }
    
    // method
    // getter method: private으로 감춰진 필드의 값을 읽을 수 있도록 해주는 메서드.
    // 필드의 값을 리턴하는 메서드.
    public String getId() {
        return this.id;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    // setter method: private으로 감춰진 필드의 값을 변경할 수 있도록 해주는 메서드.
    // 필드 값을 전달받은 아규먼트로 변경(재할당)하는 메서드.
    public void setPassword(String password) {
        this.password = password;
    }
    
}
