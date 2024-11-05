package com.itwill.inner04;

//교재 연습문제 1.
public class Anonymous {
//    class Designer extends Worker {
//        @Override
//        public void start() {
//            System.out.println("디자인을 합니다.");
//        }
//    }
//    
//    Worker field = new Designer();
    
    Worker field = new Worker() {
        @Override
        public void start() {
            System.out.println("디자인을 합니다.");
        }
    };
    
    void method1() {
        Worker localVar = new Worker() {
            @Override
            public void start() {
                System.out.println("개발을 합니다.");
            }
        };
        localVar.start();
    }
    
    void method2(Worker worker) {
        worker.start();
    }
}
