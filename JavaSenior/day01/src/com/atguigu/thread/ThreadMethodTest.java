package com.atguigu.thread;

/**
 * Thread类中常用方法的测试
 * @author KeyboardHero
 * @create 2021-08-01 16:51
 */

class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority()+":"+ i);
            }
//            if(i%20==0){
//                yield();
//            }
        }
    }

    public HelloThread(String name){
        super(name);
    }
}


public class ThreadMethodTest {
    public static void main(String[] args) {

        HelloThread h1=new HelloThread("线程1");
        //给h1线程命名
//        h1.setName("线程一");
        //设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();
        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority()+":"+ i);
            }
//            if(i==19){
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

        }
        System.out.println(h1.isAlive());
    }
}
