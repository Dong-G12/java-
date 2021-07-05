package com.yjd.demo01;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {
//        new Thread().start();
        //获取CPU的核数
        System.out.println(Runtime.getRuntime().availableProcessors());
        //TimeUnit.DAYS.sleep(1);

        //TimeUnit.SECONDS.sleep(2);
    }
}
