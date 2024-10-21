package com.itwill.inheritance01;

public class BasicTv {
    // field
    private boolean powerOn; // 전원 상태(true: ON, false: OFF)
    private int channel; // 현재 채널 번호
    private int volume; // 현재 음량 크기
    
    // 생성자
    // (1) 기본 생성자
    // (2) powerOn, channel, volume을 아규먼트로 전달받는 생성자.
    
    // method
    // (1) getters & setters
    // (2) powerOnOff: TV가 꺼져 있으면 키고, 켜져 있으면 끔. 현재 전원 상태를 리턴.
    // (3) channelUp: 채널 값을 1 증가. 증가된 채널 값을 리턴.
    // (4) channelDown: 채널 값을 1 감소. 감소된 채널 값을 리턴.
    // (5) volumeUp: 음량 1 증가. 증가된 음량 값을 리턴.
    // (6) volumeDown: 음량 1 감소. 감소된 음량 값을 리턴.
    // (7) toString: TV 객체의 정보를 문자열로 리턴.
}
