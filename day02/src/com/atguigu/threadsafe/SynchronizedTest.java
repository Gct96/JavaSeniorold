package com.atguigu.threadsafe;

/**
 * 创建三个卖票窗口，使用同步代码块方式解决实现Runnable的线程的安全问题，注意同步监视器的使用
 * @author KeyboardHero
 * @create 2021-08-02 15:54
 */

class Window implements Runnable{
    private int ticket=100;
//    Object obj=new Object();同步监视器方式二
    @Override
    public void run() {
        while(true){
            try {//给其余两个线程抢到锁的机会
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(this) {//（obj）是同步监视器方式二
                if (ticket > 0) {
                    try {//因为在同步代码块中，所以就算sleep也不会释放临界资源ticket
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class SynchronizedTest {
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
