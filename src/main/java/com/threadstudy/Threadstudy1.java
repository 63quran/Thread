package com.threadstudy;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PipedInputStream;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class Threadstudy1 extends Thread{

    private String url;//图片链接
    private String name;

    public Threadstudy1 (String url,String name){
        this.name = name;
        this.url = url;
    }

    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url,name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        Threadstudy1 t1 = new Threadstudy1("https://i0.hdslb.com/bfs/archive/ca375eb31fa90b8e23b88ed3433c2f60de1c2e6e.png","1.jpg");
        Threadstudy1 t2 = new Threadstudy1("https://i0.hdslb.com/bfs/space/265ecddc52d74e624dc38cf0cff13317085aedf7.png@2560w_400h_100q_1o.webp","2.jpg");
        Threadstudy1 t3 = new Threadstudy1("https://i0.hdslb.com/bfs/space/cb1c3ef50e22b6096fde67febe863494caefebad.png@2560w_400h_100q_1o.webp","3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

//下载器
class WebDownLoader{

    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题！");
        }
    }


    //方法二：实现Runnable接口创建多线程下载图片
    static class Theod2 implements Runnable{

        private String url;

        private String name;

        public Theod2(String url,String name){
            this.url = url;
            this.name = name;
        }

        @Override
        public void run() {
            WebDownLoader webDownLoader = new WebDownLoader();
            webDownLoader.downloader(url,name);
            System.out.println("下载了：" + name);
        }

        public static void main(String[] args) {
            Threadstudy1 t1 = new Threadstudy1("https://i0.hdslb.com/bfs/archive/ca375eb31fa90b8e23b88ed3433c2f60de1c2e6e.png","1.jpg");
            Threadstudy1 t2 = new Threadstudy1("https://i0.hdslb.com/bfs/space/265ecddc52d74e624dc38cf0cff13317085aedf7.png@2560w_400h_100q_1o.webp","2.jpg");
            Threadstudy1 t3 = new Threadstudy1("https://i0.hdslb.com/bfs/space/cb1c3ef50e22b6096fde67febe863494caefebad.png@2560w_400h_100q_1o.webp","3.jpg");

            new Thread(t1).start();
            new Thread(t2).start();
            new Thread(t3).start();
        }
    }

}