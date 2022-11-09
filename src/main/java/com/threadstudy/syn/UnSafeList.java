package com.threadstudy.syn;

import java.util.ArrayList;
import java.util.List;

//线程不安全的集合
//高并发操作时，list.add可能会出现覆盖操作，所以是线程不安全的
//只是加同步锁，没有加延时，arraylist仍然是线程不安全的
public class UnSafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}

