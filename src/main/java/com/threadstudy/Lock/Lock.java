package com.threadstudy.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class Lock {

    public static void main(String[] args) {
        TestLock testLock = new TestLock();

        new Thread(testLock).start();
        new Thread(testLock).start();
        new Thread(testLock).start();
    }
}

class TestLock implements Runnable{

    int ticket = 10;
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){

                lock.lock();//加锁
            try {
                if (ticket>0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticket--);
                }else {
                    break;
                }
            }finally {
                lock.unlock();//解锁
            }

        }
    }
}