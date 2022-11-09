package com.threadstudy;

//多个线程操作同一个对象
//例：抢票问题

//出现问题：多个线程操作一个资源的时候，出现线程不安全，数据紊乱
public class ThreadStudy3 implements Runnable{

    //定义票数
    private int ticket = 10;

    @Override
    public void run() {
        while (true){
            if (ticket <= 0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticket-- + "张票");
        }
    }

    public static void main(String[] args) {
        ThreadStudy3 threadStudy3 = new ThreadStudy3();


        new Thread(threadStudy3,"小明").start();
        new Thread(threadStudy3,"小红").start();
        new Thread(threadStudy3,"黄牛").start();
    }
}
