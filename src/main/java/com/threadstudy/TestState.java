package com.threadstudy;

//测试线程状态
public class TestState {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("==================================");
        });

        //观察线程状态,NEW
        Thread.State state = thread.getState();
        System.out.println(state);

        //启动线程
        thread.start();
        state = thread.getState();
        System.out.println(state);

        while ( state != Thread.State.TERMINATED){//只要线程不是终止状态，就一直输出状态
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = thread.getState();
            System.out.println(state);
        }

    }
}
