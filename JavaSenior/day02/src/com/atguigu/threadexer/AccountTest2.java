package com.atguigu.threadexer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个储户分别向同一个账户存3000元，每次存1000，存3次。
 * 实现Runnable接口创建线程；使用lock锁解决安全问题
 * @author KeyboardHero
 * @create 2021-08-03 13:50
 */

class Account2{
    private double balance;
    //private ReentrantLock lock=new ReentrantLock();
    public Account2(double balance) {
        this.balance = balance;
    }

    public void deposite(double amt){
        if (amt > 0) {


            balance += amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
        }
    }
}


class Customer2 implements Runnable{
    private Account2 acct2;
    private ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                lock.lock();
                acct2.deposite(1000);
                lock.unlock();
            }
        } finally {
            return;
        }

    }

    public Customer2(Account2 acct2) {
        this.acct2=acct2;
    }
}


public class AccountTest2 {
    public static void main(String[] args) {
        Customer2 customer2=new Customer2(new Account2(0));

        Thread t1=new Thread(customer2);
        Thread t2=new Thread(customer2);

        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();
    }
}
