package com.yjd.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo2 {
    public static void main(String[] args) {
        //三大方法
        ExecutorService threadPool = Executors.newCachedThreadPool();  //  可伸缩的，遇强则强，遇弱则弱
        ExecutorService threadPool2 = Executors.newFixedThreadPool(5);  //固定的线程
         ExecutorService threadPool3 = Executors.newSingleThreadExecutor();  //单个线程

        try {
            for(int i = 0;i<50;i++){
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

        //线程池用完，程序结束，关闭线程池


    }
}
