package com.itwill.class06;

public class ClassMain06 {

    public static void main(String[] args) {
        // Account 객체를 생성하고, 모든 메서드들의 기능을 테스트.
        
        Account acc1 = new Account(123456789, 10_000);
        System.out.println(acc1);
        acc1.info();
        
        Account acc2 = new Account(123456780, 100_000);
        System.out.println(acc2);
        acc2.info();

        // acc1 계좌에 100,000원 입금
        int balance = acc1.deposit(100_000);
        System.out.println("입금 후 잔고: " + balance);
        acc1.info();
        
        // acc1 계좌에서 10,000원 출금.
        acc1.withdraw(10_000);
        acc1.info();
        
        // acc1 계좌에서 50,000원을 acc2 계좌로 이체.
        acc1.transfer(50_000, acc2);
        acc1.info();
        acc2.info();
        
    }

}
