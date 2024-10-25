package com.itwill.contact.ver02;

import com.itwill.contact.ver01.Contact;

// MVC 아키텍쳐에서 Controller 역할을 담당하는 인터페이스.
//-> TODO: 인터페이스 구현 클래스 작성.
public interface ContactDao {

    int create(Contact contact);
    Contact[] read();
    Contact read(int index);
    int update(int index, Contact contact);
    
}
