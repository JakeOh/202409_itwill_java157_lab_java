package com.itwill.inheritance01;

public class BasicTv {
    // 상수 선언
    public static final int MAX_CHANNEL = 3;
    public static final int MIN_CHANNEL = 0;
    public static final int MAX_VOLUME = 3;
    public static final int MIN_VOLUME = 0;
    
    // field
    private boolean powerOn; // 전원 상태(true: ON, false: OFF)
    private int channel; // 현재 채널 번호
    private int volume; // 현재 음량 크기
    
    // 생성자
    // (1) 기본 생성자
    public BasicTv() {}
    
    // (2) powerOn, channel, volume을 아규먼트로 전달받는 생성자.
    public BasicTv(boolean powerOn, int channel, int volume) {
        this.powerOn = powerOn;
        this.channel = channel;
        this.volume = volume;
    }
    
    // method
    // (1) getters & setters
    public boolean isPowerOn() {
        return this.powerOn;
    }
    
    public void setPowerOn(boolean powerOn) {
        this.powerOn = powerOn;
    }
    
    public int getChannel() {
        return this.channel;
    }
    
    public void setChannel(int channel) {
        this.channel = channel;
    }
    
    public int getVolume() {
        return this.volume;
    }
    
    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    /**
     * powerOnOff. TV가 켜져 있으면 끄고, TV가 꺼져 있는 켬.
     * 필드 powerOn의 값이 true이면 false로 변경, powerOn의 값이 false이면 true로 변경.
     * 
     * @return powerOn의 값.
     */
    public boolean powerOnOff() {
        if (powerOn) { // TV가 켜져 있으면
            powerOn = false; // TV를 끔.
        } else { // TV가 꺼져 있으면
            powerOn = true; // TV를 켬.
        }
        
        return powerOn;
    }
    
    /**
     * channelUp. TV가 켜져 있을 때 현재 채널의 값을 1 증가.
     * 만약 현재 채널 값이 채널의 최댓값(MAX_CHANNEL)인 경우, 채널의 최솟값(MIN_CHANNEL)으로 변경.
     * 
     * @return 바뀐 현재 채널 값.
     */
    public int channelUp() {
        channel++;
        
        return channel;
    }
    
    /**
     * channelDown. TV가 켜져 있을 때 현재 채널의 값을 1 감소.
     * 만약 현재 채널 값이 채널의 최솟값(MIN_CHANNEL)인 경우, 채널의 최댓값(MAX_CHANNEL)으로 변경.
     * 
     * @return 바뀐 현재 채널 값.
     */
    public int channelDown() {
        channel--;
        
        return channel;
    }
    
    /**
     * volumeUp. TV가 켜져 있을 때 현재 음량의 값을 1 증가.
     * 만약 현재 음량 값이 음량의 최댓값(MAX_VOLUME)인 경우, 음량을 변경하지 않음.
     * 
     * @return 바뀐 현재 음량 값.
     */
    public int volumeUp() {
        volume++;
        
        return volume;
    }
    
    /**
     * volumeDown. TV가 켜져 있을 때 현재 음량의 값을 1 감소.
     * 만약 현재 음량 값이 음량의 최솟값(MIN_VOLUME)인 경우, 음량을 변경하지 않음.
     * 
     * @return 바뀐 현재 음량 값.
     */
    public int volumeDown() {
        volume--;
        
        return volume;
    }
    
    public String toString() {
        return "BasicTv(powerOn=" + this.powerOn
                + ", channel=" + this.channel
                + ", volume=" + this.volume
                + ")";
    }
    
}
