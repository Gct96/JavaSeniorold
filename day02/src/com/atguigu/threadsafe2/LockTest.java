package com.atguigu.threadsafe2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：lock锁
 * @author KeyboardHero
 * @create 2021-08-03 10:48
 */
class Window implements Runnable{
    private int ticket=100;
    //实例化
    private ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while(true){
            try{
                lock.lock();
                if(ticket>0){
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":售票，票号为"+ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                lock.unlock();
            }

        }
    }
}


public class LockTest {
    public static void main(String[] args) {
        Window window=new Window();

        Thread t1=new Thread(window);
        Thread t2=new Thread(window);
        Thread t3=new Thread(window);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
