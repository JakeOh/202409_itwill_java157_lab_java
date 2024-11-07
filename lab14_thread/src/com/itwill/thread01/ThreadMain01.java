package com.itwill.thread01;

/*
 * 쓰레드 사용법 1
 * 1. Thread 클래스를 상속하는 클래스를 선언.
 * 2. 1에서 선언한 클래스에서 run() 메서드를 override(재정의) - 쓰레드가 할 일.
 * 3. 2에서 작성한 클래스의 객체를 생성.
 * 4. 3에서 생성한 객체의 start() 메서드를 호출 -> 쓰레드가 실행됨.
 * (주의) Thread 타입 객체의 run() 메서드를 직접 호출하면 안 됨!
 * 이유: start() 호출 -> JRE에서 쓰레드를 초기화(메모리 할당, 스케쥴링, ...) -> run() 자동 실행.
 */

public class ThreadMain01 {

    public static void main(String[] args) {
        // 1. Thread 클래스를 상속하는 클래스를 선언.
        class MyThread extends Thread {
            private String name;
            
            public MyThread(String name) {
                this.name = name;
            }
            
            // 2. run() 메서드를 override
            @Override
            public void run() {
                // 쓰레드 객체가 할 일을 작성.
                for (int i = 0; i < 100; i++) {
                    System.out.println(i + ": " + name);
                    try {
                        sleep(100); // Thread.sleep(long ms) - 100ms=0.1초
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } // end class Thread

        // 3. MyThread 타입 객체 생성
        MyThread th1 = new MyThread("쓰레드 I");
        MyThread th2 = new MyThread("Thread II");
        MyThread th3 = new MyThread("안녕하세요...");
        
        long start = System.currentTimeMillis(); // 쓰레드 시작 시간.
        
        // 4. 쓰레드 객체의 start() 메서드를 호출
        th1.start();
        th2.start();
        th3.start();
        
        try {
            th1.join(); // main 쓰레드(프로세스)가 th1 쓰레드가 끝날 때까지 기다림.
            th2.join(); // main 쓰레드(프로세스)가 th2 쓰레드가 끝날 때까지 기다림.
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // 모든 쓰레드의 실행이 종료된 후:
        long end = System.currentTimeMillis(); // 쓰레드 종료 시간
        System.out.println("경과 시간: " + (end - start) + "ms");
        
        System.out.println(">>>>> main() 종료 <<<<<");
    } // end main()

}
