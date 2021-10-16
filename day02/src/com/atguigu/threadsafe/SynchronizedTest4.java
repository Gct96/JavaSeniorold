package com.atguigu.threadsafe;

/**
 * 创建三个卖票窗口，使用同步方法方式解决继承Thread类的线程的安全问题
 * @author KeyboardHero
 * @create 2021-08-02 17:45
 */

class Window4 extends Thread{
    private static int ticket=100;

    @Override
    public void run() {
        while(true){
            show();
        }
    }

    private static synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}


public class SynchronizedTest4 {
    public static void main(String[] args) {
        Window4 w1=new Window4();
        Window4 w2=new Window4();
        Window4 w3=new Window4();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
