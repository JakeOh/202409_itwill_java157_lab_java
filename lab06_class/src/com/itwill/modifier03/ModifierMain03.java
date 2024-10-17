package com.itwill.modifier03;

/*
 * 데이터 캡슐화(data encapsulation):
 * 클래스 필드들을 private으로 선언해서 클래스 외부에서는 보이지 않도록 감추고,
 * 대신에 필요한 경우에 한해서 public으로 공개된 메서드를 제공해서
 * 간접적으로 필드의 값을 읽거나 변경하는 것을 허용하는 객체지향 설계 기법.
 * - getter: 값을 읽어옴. private 필드의 값을 리턴하는 메서드.
 * - setter: 값을 세팅함. private 필드의 값을 변경하는 메서드.
 * 
 * 데이터의 보안과 무결성을 유지하기 위해서 캡슐화를 사용.
 */

public class ModifierMain03 {

    public static void main(String[] args) {
        // Member 타입 변수 선언, 초기화.
        Member m1 = new Member("admin", "1234");
        
        // Member 객체의 id는 private으로 감춰져 있기 때문에 m1.id와 같이 직접 접근할 수 없음.
        // 대신에 public으로 공개된 getId() 메서드가 id 필드의 값을 리턴해 줌.
        System.out.println("m1 id: " + m1.getId());
        System.out.println("m1 pw: " + m1.getPassword());
        
        // Member 객체의 password는 private으로 감춰져 있기 때문에, 값을 직접 변경할 수 없음.
        // m1.password = "new password";
        // 대신에, public으로 공개된 setPassword(String) 메서드를 호출하면 값을 변경할 수 있음.
        m1.setPassword("!@#$");
        System.out.println("변경 후 m1 pw: " + m1.getPassword());

        // Person 타입의 객체를 선언, 초기화.
        Person p1 = new Person("홍길동", 16);
        System.out.println("이름: " + p1.getName());
        System.out.println("나이: " + p1.getAge());
        
        p1.setAge(-1);
        System.out.println("나이: " + p1.getAge());
        
    }

}
