package com.threadstudy.DeadLock;

import javax.swing.plaf.SliderUI;

//测试死锁
public class TestDeadLock {
    public static void main(String[] args) {
        makeUp g1 = new makeUp(0,"卡莎");
        makeUp g2 = new makeUp(1,"VN");

        new Thread(g1).start();
        new Thread(g2).start();
    }


}

//口红
class LipStick{
}

//镜子
class Mirtror{
}


class makeUp implements Runnable{

    //需要的资源只有一份，用static保证唯一
    static LipStick lipStick = new LipStick();
    static Mirtror mirtror = new Mirtror();

    int choice;
    String girlName;

    makeUp(int choice ,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeUp() throws InterruptedException {
        if (choice == 0){
            synchronized (lipStick){//获得口红锁
                System.out.println(this.girlName + "获得口红锁！");
                Thread.sleep(1000);
            }
            synchronized (mirtror){//获得镜子锁
                System.out.println(this.girlName + "获得镜子锁！");
            }

        }
        else {
            synchronized (mirtror){//获得镜子锁
                System.out.println(this.girlName + "获得镜子锁！");
                Thread.sleep(2000);
            }
            synchronized (lipStick){//获得口红锁
                System.out.println(this.girlName + "获得口红锁！");
            }
        }
    }
}
