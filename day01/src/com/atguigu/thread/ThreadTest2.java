package com.atguigu.thread;

/**
 * 创建多线程的方式二：实现Runnable接口
 * @author KeyboardHero
 * @create 2021-08-01 18:04
 */

class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}


public class ThreadTest2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        Thread t1 = new Thread(myThread2);
        t1.setName("线程1");
        t1.start();

        //再启动一个线程
        Thread t2=new Thread(myThread2);
        t2.setName("线程2");
        t2.start();
    }
}
