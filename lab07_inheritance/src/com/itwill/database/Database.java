package com.itwill.database;

public interface Database {
    // field - 상수(public static final 생략 가능)
    int VERSION = 1;
    
    // method - 추상 메서드(public abstract 생략 가능)
    /**
     * 데이터베이스의 테이블에서 자료를 검색하고 검색된 자료의 개수를 리턴.
     * @return 검색된 자료의 개수.
     */
    int select();
    
    /**
     * 데이터베이스의 테이블에 자료를 저장하고, 성공하면 1, 실패하면 0을 리턴.
     * @param name 테이블에 저장할 이름(String).
     * @param phone 테이블에 저장할 전화번호(String).
     * @return 성공하면 1, 실패하면 0.
     */
    int insert(String name, String phone);
    
}
