package com.threadstudy;

//通过实现Runnable接口来实现多线程
public class ThreadStudy2 implements  Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000 ; i++) {
            System.out.println("我在进行多线程：" + i );
        }
    }

    public static void main(String[] args) {
        ThreadStudy2 threadStudy2 = new ThreadStudy2();
        new Thread(threadStudy2).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("我在看代码：" + i);
        }
    }
}
