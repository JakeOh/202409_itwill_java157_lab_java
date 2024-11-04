package com.itwill.contact.ver04.view;

public enum MainMenu {
    QUIT,
    CREATE,
    READ_ALL,
    READ_BY_INDEX,
    UPDATE,
    DELETE,
    UNKNOWN;
    
    public static MainMenu getMainMenu(int index) {
        MainMenu[] menu = values();
        
        return (index >= 0) && (index < menu.length) ? menu[index] : UNKNOWN;
    }

}
