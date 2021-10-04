package com.atguigu.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式四：使用线程池
 * @author KeyboardHero
 * @create 2021-08-04 17:11
 */

class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}


class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}







public class ThreadTest4 {
    public static void main(String[] args) {
        //创建ExecutorService接口实现类ThreadPoolExecutor的对象,提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1=(ThreadPoolExecutor) service;

        //设置线程池的属性
        //System.out.println(service.getClass());
        service1.setCorePoolSize(15);
        //service1.setKeepAliveTime();

        //执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        //service.submit();//有返回值适合使用于Callable
        service1.execute(new NumberThread());//适合使用于Runnable
        service1.execute(new NumberThread1());//适合使用于Runnable
        //关闭连接池
        service.shutdown();
    }
}
