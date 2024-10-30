package com.itwill.contact.ver03;

import java.util.ArrayList;
import java.util.List;

import com.itwill.contact.ver01.Contact;

// MVC 아키텍쳐에서 Controller 역할 담당.
public enum ContactDao {
    INSTANCE; // ConatactDao 타입의 싱클턴 객체.
    
    // field:
    // 연락처들을 저장할 리스트.
    private List<Contact> contacts = new ArrayList<>();
    
    // methods:
    /**
     * 연락처 객체를 리스트(ArrayList)에 저장.
     * @param contact - 리스트에 저장할 연락처 타입 객체.
     * @return 성공이면 1, 실패면 0.
     */
    public int create(Contact contact) {
        // 필드에서 선언된 연락처 리스트에 아규먼트로 전달받은 연락처 객체를 저장:
        contacts.add(contact);
        
        return 1;
    }
    
    /**
     * 연락처(들)을 저장하고 있는 리스트(List<Contact>)를 리턴.
     * @return contacts
     */
    public List<Contact> read() {
        return contacts;
    }
    
    /**
     * 정수 index가 연락처를 저장하는 리스트에서 사용할 수 있는 유효한 인덱스인 지 여부를 리턴.
     * @param index - 유효한 인덱스인 지 검사할 정수.
     * @return index >= 0 이고 index가 연락처를 저장하는 배열의 크기(size())보다 작으면 true,
     * 그렇지 않으며 false.
     */
    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < contacts.size());
    }
    
    /**
     * 연락처 리스트에서 index 위치에 있는 연락처 객체를 리턴.
     * @param index - 리스트의 인덱스. 리스트에서 연락처의 위치.
     * @return (index >= 0 && index < size())이면 리스트에서 index 위치에 저장된 
     * Contact 타입 객체, 그렇지 않으면 null.
     */
    public Contact read(int index) {
        if (isValidIndex(index)) {
            return contacts.get(index);
        } else {
            return null;
        }
    }
    
    /**
     * 연락처 리스트에서 특정 위치의 연락처 정보(이름, 전화번호, 이메일)를 업데이트.
     * @param index - 연락처 리스트에서 업데이트할 위치(인덱스).
     * @param contact - 업데이트할 새로운 연락처 정보.
     * @return 업데이트 성공이면 1, 실패면 0.
     */
    public int update(int index, Contact contact) {
        if (!isValidIndex(index)) {
            return 0;
        }
        
//        Contact old = contacts.get(index);
//        old.setName(contact.getName());
//        old.setPhone(contact.getPhone());
//        old.setEmail(contact.getEmail());
        contacts.set(index, contact);
        
        return 1;
    }
    
    /**
     * 연락처 리스트에서 특정 위치의 연락처를 삭제.
     * @param index - 연락처를 삭제하기 위한 리스트에서의 위치(인덱스).
     * @return (index >= 0 && index < size())이면 삭제 성공(1), 그렇지 않으면 실패(0).
     */
    public int delete(int index) {
        if (isValidIndex(index)) {
            contacts.remove(index);
            return 1;
        } else {
            return 0;
        }
    }
    
}
