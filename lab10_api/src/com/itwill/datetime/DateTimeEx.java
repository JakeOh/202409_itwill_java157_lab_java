package com.itwill.datetime;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeEx {

    public static void main(String[] args) {
        // java.util 패키지의 Date, Calendar 클래스.
        // Java 8 버전부터 새로 생긴 java.time 패키지의 날짜/시간 관련 클래스.

        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.getYear());
        System.out.println(today.getMonth()); //-> Month enum 상수 리턴.
        System.out.println(today.getMonthValue()); //-> 정수(1 ~ 12) 리턴.
        System.out.println(today.getDayOfMonth());
        System.out.println(today.getDayOfWeek()); //-> DayOfWeek enum 상수 리턴.
        System.out.println(today.isLeapYear()); //-> 윤년 여부(true/false) 리턴.
        System.out.println(today.plusDays(7));
        System.out.println(today.minusWeeks(2));
        
        LocalDate birthday = LocalDate.of(2000, 12, 31);
        System.out.println(birthday);
        
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        
        LocalDateTime time = LocalDateTime.of(2024, 10, 29, 12, 10);
        System.out.println(time);
        
        // 데이터베이스에 날짜/시간을 저장하거나, 저장된 시간을 읽어올 때는
        // java.sql 패키지의 Date, Timestamp 타입을 사용함.
        // LocalDateTime ---> Timestamp 변환
        Timestamp ts = Timestamp.valueOf(time);
        System.out.println(ts);
        System.out.println(ts.getTime());
        // 1970-01-01 00:00:00를 기준으로 1/1000초마다 1씩 증가하는 정수.
        
        // Timestamp ---> LocalDateTime 변환
        LocalDateTime dt = ts.toLocalDateTime();
        System.out.println(dt);
    }

}
