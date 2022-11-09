package com.threadstudy;

//模拟龟兔赛跑
public class Race implements Runnable {

    private String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //让兔子快到终点的时候睡一会儿
            if (Thread.currentThread().getName().equals("兔子") && i>90){
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag =gameOver(i);
            if (flag == true){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-->跑了：" + i +"步" );
        }
    }

    public boolean gameOver(int steps){
        if (winner != null){
            return true;
        }{
            if (steps == 100){
                winner = Thread.currentThread().getName();
                System.out.println("胜利者是"+ winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
