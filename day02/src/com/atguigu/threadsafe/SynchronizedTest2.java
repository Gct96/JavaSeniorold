package com.atguigu.threadsafe;

/**
 * 创建三个卖票窗口，使用同步代码块方式解决继承Thread类的线程的安全问题，注意同步监视器的使用
 * @author KeyboardHero
 * @create 2021-08-02 16:46
 */
class Window2 extends Thread{
    private static int ticket=100;
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Window2.class) {     //使用当前类充当同步监视器
                if (ticket > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class SynchronizedTest2 {
    public static void main(String[] args) {
        Window2 w1=new Window2();
        Window2 w2=new Window2();
        Window2 w3=new Window2();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
