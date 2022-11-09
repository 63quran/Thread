package com.threadstudy;

//测试join方法。插队
public class TestJoin implements Runnable{

    public static void main(String[] args) throws InterruptedException {
       TestJoin testJoin = new TestJoin();
       Thread thread = new Thread(testJoin);
       thread.start();

        for (int i = 0; i < 200; i++) {
            if (i == 100){
                thread.join();
                System.out.println("主线程" + i);
            }
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("vip线程来了"+ i);
        }
    }
}
