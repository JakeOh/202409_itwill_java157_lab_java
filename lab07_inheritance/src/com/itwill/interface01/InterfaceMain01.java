package com.itwill.interface01;

import com.itwill.database.Database;
import com.itwill.database.mysql.MySqlDatabase;
import com.itwill.database.oracle.OracleDatabase;

/*
 * 인터페이스(interface):
 * 사용 목적: 팀/회사 간의 분업/협업을 하기 위해서 메서드의 signature를 약속하기 위해서.
 * 인터페이스가 가질 수 있는 멤버:
 *   (1) public static final 필드(상수) - public static final 수식어는 생략 가능.
 *   (2) public abstract 메서드(추상 메서드) - public abstract 수식어는 생략 가능.
 * 인터페이스를 선언할 때는 interface 키워드를 사용.
 * 인터페이스는 아주 특별한 추상 클래스. (변수 타입으로 사용.)
 * 인터페이스는 객체를 생성할 수 없음.
 * 인터페이스를 "구현"하는 클래스를 선언하면 객체를 생성할 수 있음.
 *   - class ClassName extends SuperClass {}
 *   - class ClassName implements InterfaceName {}
 * 클래스는 단일 상속만 가능하지만, 인터페이스는 구현하는 개수에 제한이 없음.
 *   - class ClassName implements A, B, C {}
 * 인터페이스는 상위 인터페이스를 상속(확장)할 수 있음. 인터페이스는 다중 상속이 가능.
 *   - interface InterfaceName extends SuperInterface {}
 *   - interface InterfaceName extends A, B, C {}
 */

public class InterfaceMain01 {

    public static void main(String[] args) {
        System.out.println(Database.VERSION); //-> public static
//        Database.VERSION = 2; //-> final
        
        // OracleDatabase 객체를 생성하고, 메서드들을 사용.
        // MySqlDatabase 객체를 생성, 메서드 사용.
        Database db = new MySqlDatabase();
        
        int result = db.insert("오쌤", "1234-5678");
        System.out.println("insert result = " + result);
        
        result = db.select();
        System.out.println("select result = " + result);
    }

}
