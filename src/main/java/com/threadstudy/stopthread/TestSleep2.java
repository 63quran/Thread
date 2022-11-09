package com.threadstudy.stopthread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep2 implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        //模拟倒计时
        TestSleep2 thread = new TestSleep2();
        new Thread(thread).start();

        //打印当前时间
        Date startTime = new Date(System.currentTimeMillis());//获取系统当前时间
        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            startTime = new Date(System.currentTimeMillis());//更新当前时间
        }
    }

    @Override
    public void run() {
        int num = 10;
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num--);
            if (num<=0){
                break;
            }
        }
    }
}
