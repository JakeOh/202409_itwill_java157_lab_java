package com.itwill.menu;

// enum: 상수(들)을 선언하는 특별한 종류의 "클래스(타입)".
// - Java의 Enum 클래스를 상속하는 하위 클래스 -> Enum에서 작성된 메서드들을 상속받음.
// - 필드, 생성자, 메서드를 작성할 수 있음.
public enum Menu {
    // 상수(들)을 선언 - public static final Menu
    QUIT, 
    CREATE, 
    READ_ALL, 
    READ_BY_INDEX, 
    UPDATE, 
    DELETE, 
    UNKNOWN;
    
    /**
     * 정수에 해당하는 Menu 상수를 리턴.
     * @param i Menu 상수를 찾기 위한 값. ordinal() 함수 값의 범위.
     * @return values() 메서드가 리턴하는 Menu 배열에서 i번째 원소를 리턴.
     * 파라미터 i가 0보다 작거나 Menu 배열의 원소 개수보다 크거나 같으면 UNKNOWN 리턴.
     */
    public static Menu getMenu(int i) {
        Menu[] menu = values(); // Enum 클래스에서 상속받은 static 메서드.
        int size = menu.length;
        
        if (i >= 0 && i < size) {
            return menu[i];
        } else {
            return UNKNOWN; // Menu 타입에서 선언된 가장 마지막 상수.
        }
    }
    
}
