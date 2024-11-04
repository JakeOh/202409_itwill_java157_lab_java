package com.itwill.contact.ver04.controller;

import java.util.List;

import com.itwill.contact.ver04.model.Contact;

// import static 문장 - 클래스(인터페이스, enum)에서 static으로 선언된 필드/메서드 이름을 import.
import static com.itwill.contact.ver04.util.FileUtil.*;

// MVC 아키텍쳐에서 Controller 역할을 담당하는 객체. DAO(Data Access Object).
// 연락처 저장, 검색(목록, 인덱스), 업데이트, 삭제 기능을 제공.
public enum ContactDao {
    INSTANCE; // ContactDao 타입의 싱글턴 객체 선언.

    // 필드
    private List<Contact> contacts; // 연락처(들)의 리스트 - 파일에서 읽어 올 데이터. 파일에 쓸 데이터.
    
    // 생성자 - enum 타입의 생성자는 private만 가능. private 수식어는 생략 가능.
    ContactDao() {
        // 데이터 폴더 초기화: 폴더가 없는 경우에 폴더를 새로 만듦.
        initializeDataDir();
        
        // 연락처 데이터 초기화: 데이터 파일에서 리스트를 읽어 오거나, 또는 빈 리스트를 생성. 
        contacts = initializeData();
    }
    
    // 메서드
    /**
     * 연락처 데이터를 리스트에 추가하고, 변경된 리스트를 파일에 씀.
     * @param contact - 이름, 전화번호, 이메일 정보를 저장하고 있는 연락처 데이터.
     * @return 성공하면 1, 실패하면 0.
     */
    public int create(Contact contact) {
        contacts.add(contact); // (메모리) 리스트에 연락처 데이터를 추가.
        writeDataToFile(contacts); // (메모리) 리스트를 파일에 씀.
        
        return 1;
    }
    
}
