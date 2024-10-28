package com.itwill.exception06;

public class AgeFormatException extends Exception {

    public AgeFormatException() {
        super("나이는 0 이상이어야 함.");
    }
    
}
