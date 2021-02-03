package com.xinyu.test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduleThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {


        ScheduledExecutorService executorService = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2,new ThreadFactory() {
            private AtomicInteger integer = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"t-"+(integer.incrementAndGet()));
            }
        });

        //看不懂和scheduleWithFixedDelay 有什么区别
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        },1,1,TimeUnit.SECONDS);

        //第一次延迟一定时间后  每隔一段时间执行一下
//        executorService.scheduleWithFixedDelay(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("1");
//            }
//        },1,1,TimeUnit.SECONDS);

        //延迟执行  只执行一次
//        executorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("1");
//            }
//        },1,TimeUnit.SECONDS);


    }
}
