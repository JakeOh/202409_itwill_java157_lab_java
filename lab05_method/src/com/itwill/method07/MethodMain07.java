package com.itwill.method07;

public class MethodMain07 {
    // 가변길이 인수(variable-length arguments):
    // 메서드의 아규먼트 개수가 정해져 있지 않은 경우.
    // 메서드를 호출할 때마다 아규먼트 개수가 임의로 달라질 수 있는 경우.

    public static void main(String[] args) {
        System.out.printf("hello\n");
        System.out.printf("안녕하세요, %s!\n", "오쌤");
        System.out.printf("%d x %d = %d\n", 2, 3, 6);
    }
    
}
