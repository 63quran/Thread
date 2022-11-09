package com.threadstudy.Lock;


import java.util.ArrayList;

//测试生产者消费者问题
public class TestProducer {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        //消费者和生产者同时对缓冲池进行操作
        new Producter(buffer).start();
        new Consumer(buffer).start();
    }
}

//生产者
class Producter extends  Thread{

    Buffer buffer = new Buffer();

    public Producter(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            buffer.push(new Product(i));
            System.out.println("生产了第" + i + "只鸡");
        }
    }
}


//消费者
class Consumer extends Thread{

    Buffer buffer = new Buffer();

    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了-->" + buffer.pop().id + "只鸡");
        }
    }
}

//产品
class Product{
    int id;//产品编号

    public Product(int id) {
        this.id = id;
    }
}


//缓冲池
class Buffer{
    //定义容器大小
    Product[] products = new Product[10];
    //容器计数器
    int count;

    //生产者生产
    public synchronized void push(Product product){
        //如果容器满了，就需要消费者进行消费
        if (count == products.length){
            //生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //容器没有满，生产者生产
        products[count] = product;
        count++;

        //可以通知消费者消费了
        this.notifyAll();
    }

    //消费者消费
    public synchronized Product pop(){
        //如果容器空了，则消费者等待生产者生产
        if (count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        Product product = products[count];
        //消费完通知生产者生产
        this.notifyAll();
        return product;
    }


}

