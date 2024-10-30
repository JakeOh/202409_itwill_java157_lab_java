package com.itwill.list05;

import java.util.Objects;

public class Member {
    // field
    private String id;
    private String password;
    
    // 생성자: (1) 기본 생성자, (2) id, password를 아규먼트로 갖는 생성자
    public Member() {}
    
    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }
    
    // getters(id, password) & setter(password)
    public String getId() {
        return id;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    // toString
    @Override
    public String toString() {
        return "Member(id=" + id
                + ", password=" + password
                + ")";
    }
    
    // hashCode & equals - id 필드만 사용.
    @Override
    public int hashCode() {
//        return id.hashCode(); // String 클래스에서 override한 hashCode를 이용.
        return Objects.hash(id); // java.util.Objects 클래스의 메서드를 이용.
    }
    
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof Member) {
            Member other = (Member) o;
            result = this.id.equals(other.id);
        }
        
        return result;
    }

}
