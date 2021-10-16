package com.atguigu.thread;

/**
 * 多线程的创建方式一：继承于thread类
 * @author KeyboardHero
 * @create 2021-08-01 15:59
 */

//创建一个继承于Thread类的子类
class MyThread extends Thread{
    //重写Thread类的run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(i);
            }
        }

    }
}


public class ThreadTest {
    public static void main(String[] args) {
        //创建Thread类的子类的对象
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        t1.start();
        t2.start();

        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(i+"*******main*******");
            }
        }
    }
}
