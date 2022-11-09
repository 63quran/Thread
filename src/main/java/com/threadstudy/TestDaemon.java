package com.threadstudy;

//测试守护线程

public class TestDaemon {

    public static void main(String[] args) {
        YOU you = new YOU();
        GOD god = new GOD();

        Thread thread = new Thread(god);
        thread.setDaemon(true);//设置守护进行，默认false为用户线程

        thread.start();

        new Thread(you).start();



    }
}

class GOD implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑着你！");
        }
    }
}

class YOU implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你开心的活着！");
        }
        System.out.println("=======goodbye!world!=========");
    }
}