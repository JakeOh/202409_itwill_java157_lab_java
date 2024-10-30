package com.itwill.set03;

import java.util.HashSet;

public class SetMain03 {

    public static void main(String[] args) {
        // Score 타입 객체를 저장할 수 있는 HashSet을 선언, 초기화.
        HashSet<Score> scores = new HashSet<>(); // new HashSet<Score>();
        
        Score s1 = new Score(0, 0, 0);
        System.out.println("s1 hash: " + s1.hashCode());
        scores.add(s1);
        System.out.println(scores);
        
        Score s2 = new Score(0, 0, 0);
        System.out.println("s2 hash: " + s2.hashCode());
        System.out.println("s1 equals s2: " + s1.equals(s2));
        scores.add(s2);
        System.out.println(scores);
        
        scores.add(new Score(100, 90, 80));
        System.out.println(scores);

    }

}
