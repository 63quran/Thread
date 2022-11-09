package com.threadstudy;

//测试线程优先级
public class TestPriority {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());

        MyPriority my = new MyPriority();

        Thread t1 = new Thread(my);
        Thread t2 = new Thread(my);
        Thread t3 = new Thread(my);
        Thread t4 = new Thread(my);
        Thread t5 = new Thread(my);
        Thread t6 = new Thread(my);

        t1.setPriority(1);
        t1.start();

        t2.setPriority(4);
        t2.start();

        t3.setPriority(5);
        t3.start();

        t4.setPriority(10);
        t4.start();

        t5.setPriority(-1);
        t5.start();

        t6.setPriority(11);
        t6.start();


    }

}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}
