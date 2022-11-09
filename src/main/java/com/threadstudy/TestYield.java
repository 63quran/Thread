package com.threadstudy;

public class TestYield {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield,"蜘蛛侠").start();
        new Thread(myYield,"钢铁侠").start();
    }
}


class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行任务");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "结束任务");
    }
}