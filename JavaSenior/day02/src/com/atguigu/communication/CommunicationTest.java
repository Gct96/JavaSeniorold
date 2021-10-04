package com.atguigu.communication;

/**
 * 生产者消费者问题
 * @author KeyboardHero
 * @create 2021-08-03 16:35
 */

class Clerk{
    private int productCount=0;
    //生产产品
    public synchronized void produceProduct() {
        if(productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+":开始生产第"+productCount+"个产品");
            notifyAll();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费产品
    public synchronized void consumeProduct() {
        if(productCount>0){
            System.out.println(Thread.currentThread().getName()+":开始消费第"+productCount+"个产品");
            productCount--;
            notifyAll();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始生产产品.....");
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}


class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始消费产品.....");
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}


public class CommunicationTest {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Producer p1=new Producer(clerk);
        p1.setName("生产者1");
        Consumer c1=new Consumer(clerk);
        c1.setName("消费者1");
        Consumer c2=new Consumer(clerk);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();
    }
}
