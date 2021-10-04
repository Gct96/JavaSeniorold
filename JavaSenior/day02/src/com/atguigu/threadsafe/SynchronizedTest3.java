package com.atguigu.threadsafe;

/**
 * 创建三个卖票窗口，使用同步方法方式解决实现Runnable的线程的安全问题
 *
 * @author KeyboardHero
 * @create 2021-08-02 17:22
 */

class Window3 implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private synchronized void show(){
        if (ticket > 0) {
            try {//因为在同步代码块中，所以就算sleep也不会释放临界资源ticket
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}


public class SynchronizedTest3 {
    public static void main(String[] args) {
        Window3 window3=new Window3();

        Thread t1=new Thread(window3);
        Thread t2=new Thread(window3);
        Thread t3=new Thread(window3);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
