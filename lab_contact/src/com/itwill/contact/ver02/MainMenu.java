package com.itwill.contact.ver02;

// ContactMain (UI)의 switch-case 구문에서 사용할 상수들을 선언.
public enum MainMenu {
    QUIT,
    CREATE,
    READ_ALL,
    READ_BY_INDEX,
    UPDATE,
    UNKNOWN;
    
    /**
     * 정수를 enum 상수로 변환. 정수 n에 해당하는(n번째) MainMenu 타입 상수를 리턴.
     * 정수 n에 해당하는 상수가 없는 경우에는 UNKNOWN을 리턴.
     * @param n enum 상수의 순서(ordinal).
     * @return n번째 MainMenu 타입 상수.
     */
    public static MainMenu getMainMenu(int n) {
        MainMenu[] menu = values();
        int size = menu.length;
        
        return (n >= 0 && n < size) ? menu[n] : UNKNOWN;
    }
}
