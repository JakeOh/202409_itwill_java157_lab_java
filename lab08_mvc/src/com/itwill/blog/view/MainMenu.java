package com.itwill.blog.view;

public enum MainMenu {
    QUIT, 
    CREATE, 
    READ_ALL, 
    READ_BY_INDEX, 
    UPDATE, 
    UNKONWN;
    
    // 정수 -> enum 상수 변환 메서드:
    public static MainMenu getMainMenu(int n) {
        MainMenu[] menu = values();
        int size = menu.length;
        
        return (n >= 0 && n < size) ? menu[n] : UNKONWN;
    }
    
}
