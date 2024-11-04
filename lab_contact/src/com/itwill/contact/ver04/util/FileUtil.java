package com.itwill.contact.ver04.util;

import java.io.File;
import java.util.List;

import com.itwill.contact.ver04.model.Contact;

// 도우미 클래스(helper class): 파일 관련(읽기, 쓰기, 폴더 생성) 기능을 제공하는 클래스.
// - 객체를 생성하지 못하도록 작성. 모든 메서드들을 public static으로 작성.
public class FileUtil {
    public static final String DATA_DIR = "data"; // 데이터 파일을 저장할 폴더 이름.
    public static final String DATA_FILE = "contacts.dat"; // 데이터 파일 이름.
    
    // private 생성자 -> 다른 클래스에서는 객체를 생성할 수 없음.
    private FileUtil() {}
    
    /**
     * 연락처(Contact)의 리스트(List<E>)가 저장된 데이터 파일을 읽고, 그 결과를 리턴.
     * 
     * @return List<Contact> 타입 객체.
     */
    public static List<Contact> readDataFromFile() {
        List<Contact> list = null;
        
        File file = new File(DATA_DIR, DATA_FILE);
        // TODO
        
        return null;
    }
    
    /**
     * 연락처(Contact)의 리스트(List<E>)를 파일에 쓰는 메서드.
     * 
     * @param list - 파일에 쓸 데이터. 연락처들의 리스트(List<Contact>).
     */
    public static void writeDataToFile(List<Contact> list) {
        File file = new File(DATA_DIR, DATA_FILE);
        // TODO
    }
    
}
