package com.itwill.menu;

public class SeasonTest {

    public static void main(String[] args) {
        // Season1 s = new Season1(); //-> private 생성자이기 때문에
        int s1 = Season1.FALL;
        int s2 = 100;
        
        // Season2 s = new Season2();
        Season2 s3 = Season2.WINTER;
        System.out.println(s3.getName());
    }

}
