package com.threadstudy;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class ThreadStudyCallable implements Callable<Boolean> {

    private String url;//图片链接
    private String name;

    public ThreadStudyCallable (String url,String name){
        this.name = name;
        this.url = url;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url,name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadStudyCallable t1 = new ThreadStudyCallable("https://i0.hdslb.com/bfs/archive/ca375eb31fa90b8e23b88ed3433c2f60de1c2e6e.png","1.jpg");
        ThreadStudyCallable t2 = new ThreadStudyCallable("https://i0.hdslb.com/bfs/space/265ecddc52d74e624dc38cf0cff13317085aedf7.png@2560w_400h_100q_1o.webp","2.jpg");
        ThreadStudyCallable t3 = new ThreadStudyCallable("https://i0.hdslb.com/bfs/space/cb1c3ef50e22b6096fde67febe863494caefebad.png@2560w_400h_100q_1o.webp","3.jpg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r1.get();
        boolean rs3 = r1.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        //关闭服务
        ser.shutdownNow();
    }


}

