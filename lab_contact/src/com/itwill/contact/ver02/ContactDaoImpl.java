package com.itwill.contact.ver02;

import com.itwill.contact.ver01.Contact;

public class ContactDaoImpl implements ContactDao {
    //-----> singleton
    private static ContactDaoImpl instance = null;
    
    private ContactDaoImpl() {}
    
    public static ContactDaoImpl getInstance() {
        if (instance == null) {
            instance = new ContactDaoImpl();
        }
        
        return instance;
    }
    //<----- singleton
    
    // 배열에 저장할 수 있는 원소의 최댓값:
    private static final int MAX_LENGTH = 3;
    
    // 연락처를 저장할 배열:
    private Contact[] contacts = new Contact[MAX_LENGTH];
    
    // 배열에 저장된 Contact 객체의 개수. create()가 호출될 때마다 1씩 증가.
    int count = 0;

    /**
     * 연락처를 저장하는 배열의 가용 여부를 확인하기 위한 메서드.
     * @return 배열에 최대 개수까지 저장되어 있으면 true, 그렇지 않으면 false를 리턴.
     */
    public boolean isMemoryFull() {
        return (count == MAX_LENGTH);
    }
    
    /**
     * 연락처를 저장하는 배열의 유효한 인덱스인 지를 확인하는 메서드. 
     * @param index 유효한 지를 확인할 인덱스. 정수.
     * @return index가 0 이상이고, 배열에 저장된 원소 개수보다 작으면 true, 그렇지 않으면 false.
     */
    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < count);
    }
    
    @Override
    public int create(Contact contact) {
        if (isMemoryFull()) {
            return 0;
        }
        
        contacts[count] = contact;
        count++;
        
        return 1;
    }

    @Override
    public Contact[] read() {
        // 배열 contacts에 실제 저장된 개수만큼만 복사해서 리턴.
        Contact[] result = new Contact[count];
        for (int i = 0; i < count; i++) {
            result[i] = contacts[i];
        }
        
        return result;
    }

    @Override
    public Contact read(int index) {
        if (isValidIndex(index)) {
            return contacts[index];
        } else {
            return null;
        }
    }

    @Override
    public int update(int index, Contact contact) {
        if (!isValidIndex(index)) {
            return 0;
        }
        
        contacts[index].setName(contact.getName());
        contacts[index].setPhone(contact.getPhone());
        contacts[index].setEmail(contact.getEmail());
        
//        contacts[index] = contact;
        
        return 1;
    }

}
