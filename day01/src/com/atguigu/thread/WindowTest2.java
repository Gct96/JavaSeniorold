package com.atguigu.thread;

/**
 * 创建三个窗口卖票，票数共100，使用实现Runnable方式
 * @author KeyboardHero
 * @create 2021-08-02 10:20
 */

class Window2 implements Runnable{
    private int ticket=100;

    @Override
    public void run() {
        while(true){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+":卖票，票号为："+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}


public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w=new Window2();

        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
