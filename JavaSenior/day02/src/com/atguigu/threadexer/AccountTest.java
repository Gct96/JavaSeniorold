package com.atguigu.threadexer;

/**
 * 两个储户分别向同一个账户存3000元，每次存1000，存3次。
 * 继承Thread类方式创建线程；synchronized方法解决安全问题
 * @author KeyboardHero
 * @create 2021-08-03 13:26
 */

class Account{
    private double balance;

    public Account(double balance){
        this.balance=balance;
    }

    public synchronized void deposite(double amt){
        if(amt>0){
            balance+=amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"存钱成功，余额为："+balance);
        }
    }
}

class Customer extends Thread{
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposite(1000);
        }
        
    }
}








public class AccountTest {
    public static void main(String[] args) {
        Account acct=new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
