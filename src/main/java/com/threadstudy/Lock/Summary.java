package com.threadstudy.Lock;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

//多线程总结
public class Summary {

    public static void main(String[] args) {
        new MyThread1().start();

        new Thread(new MyThread2()).start();

        FutureTask<Integer> future = new FutureTask<Integer>(new MyThread3());
        new Thread(future).start();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

//方法一：继承Thread类
class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

//方法二：实现Runnable接口
class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

//方法三：实现Callable接口
class MyThread3 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return 100;
    }
}

