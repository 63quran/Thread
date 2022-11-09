package com.threadstudy.syn;

//不安全的抢票
//线程不安全，有负数
public class UnSaeBuyTicket {

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"老师").start();
        new Thread(buyTicket,"学生").start();
        new Thread(buyTicket,"黄牛党").start();
    }
}

class BuyTicket implements  Runnable{

    //定义票数
    private  int ticket = 10;
    boolean flag = true;
    @Override
    public void run()  {
        try {
            while (flag){
                buy();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if (ticket <= 0){
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(100);
        //买票

            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticket--);

    }
}

