package com.threadstudy.stopthread;

import com.threadstudy.ThreadStudy3;

//模拟网络延时：放大问题的发生行
public class TestSleep implements Runnable{
    //定义票数
    private int ticket = 10;

    @Override
    public void run() {
        while (true){
            if (ticket <= 0){
                break;
            }
            //模拟延时
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
