package com.itwill.thread02;

/*
 * 자바는 다중상속을 허용하지 않음: class A extends B, C {} -> 문법 오류
 * 이미 다른 클래스를 상속하고 있는 클래스는 Thread 클래스를 상속할 수 없음.
 * 자바는 인터페이스의 구현 개수는 제한이 없음: class A extends B implements C, D, E {}
 * 
 * 쓰레드 사용법 2
 * 1. Runnable 인터페이스를 구현하는 클래스를 선언.
 * 2. 1에서 선언한 클래스에서 인터페이스의 run() 메서드를 override - 쓰레드가 할 일 정의.
 * 3. Thread 객체 생성: Thread 클래스의 생성자 중에서 Runnable 타입을 아규먼트로 갖는 생성자를 호출.
 *    생성자를 호출할 때 2에서 작성한 클래스의 객체를 생성해서 아규먼트로 전달.
 * 4. 3에서 생성된 Thread 객체의 start() 메서드를 호출 - 쓰레드 스케쥴링(실행).
 */

public class ThreadMain02 {

    public static void main(String[] args) {
        // 1. Runnable 구현 클래스 선언
        class MyRunnable implements Runnable {
            private String name;
            
            public MyRunnable(String name) {
                this.name = name;
            }
            
            // 2. Runnable 인터페이스의 run()을 재정의:
            @Override
            public void run() {
                // 쓰레드가 할 일
                for (int i = 0; i < 100; i++) {
                    System.out.println(i + " - " + name);
                    try {
                        Thread.sleep(50); // 50ms=0.05초 쉼.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } // end class MyRunnable

        // 3. Thread 타입 객체 생성:
        Thread th1 = new Thread(new MyRunnable("지역 클래스(local class)"));
        
        // 익명 클래스를 사용한 Thread 타입 객체 생성:
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i + " - 익명 클래스(anonymous class)");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        
        // 람다 표현식을 사용한 쓰레드 객체 생성
        Thread th3 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i + " - 람다(lambda)");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        // 4. 쓰레드 실행.
        th1.start();
        th2.start();
        th3.start();
        
        try {
            th1.join();
            th2.join();
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(">>>>> main() 종료 <<<<<");
    } // end main()

}
