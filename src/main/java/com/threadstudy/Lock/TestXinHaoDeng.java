package com.threadstudy.Lock;

//生产者、消费者---信号灯法
public class TestXinHaoDeng {

    public static void main(String[] args) {
        Tv tv = new Tv();

        new Actor(tv).start();
        new Watcher(tv).start();
    }
}

//生产者--演员
class Actor extends Thread{
    Tv tv = new Tv();
    public Actor(Tv tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2 == 0){
                tv.product("白夜追凶2");
            }else {
                tv.product("战狼3");
            }
        }
    }
}


//消费者--观众
class Watcher extends Thread{
    Tv tv = new Tv();
    public Watcher(Tv tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.play();
        }
    }
}

//产品--电视
class Tv{
    //产品需要的属性
    String voice;
    boolean flag = true;
    //生产者生产
    public synchronized void product(String voice){
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("演员正在拍" + voice);
        this.voice = voice;
        this.notifyAll();
        this.flag = !this.flag;
    }
    
    //消费者消费
    public synchronized void play(){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("观众正在看" + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }

}