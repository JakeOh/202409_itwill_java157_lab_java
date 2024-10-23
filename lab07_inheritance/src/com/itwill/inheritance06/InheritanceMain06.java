package com.itwill.inheritance06;

public class InheritanceMain06 {

    public static void main(String[] args) {
        // Point 타입의 객체(들)을 생성, toString, equals, hashCode 메서드 테스트.
        Point pt1 = new Point();
        
        System.out.println(pt1);
        //-> toString() 오버라이드 전: com.itwill.inheritance06.Point@54bedef2
        //-> toString() 오버라이드 후: Point(x=0.0, y=0.0)
        
        System.out.println(pt1.hashCode());
        //-> hashCode() 오버라이드 전: 1421795058(10진수) = 0x54bedef2(16진수)
        //-> hashCode() 오버라이드 후: 961
        
        Point pt2 = new Point(0, 0);
        System.out.println(pt2);
        System.out.println(pt2.hashCode());
        //-> hashCode()를 오버라이드한 후에는 pt1의 hashCode와 pt2의 hashCode는 같아야.

        System.out.println(pt1.equals(pt2));
        //-> equals() 오버라이드 전: false
        //-> equals() 오버라이드 후: true
        
        Point pt3 = new Point(1, 2);
        System.out.println(pt3);
        System.out.println(pt3.hashCode());
        System.out.println(pt1.equals(pt3));
        
    }

}
