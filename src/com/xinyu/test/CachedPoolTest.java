package com.xinyu.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CachedPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory() {
            private AtomicInteger integer = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,""+(integer.incrementAndGet()));
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

        Thread.sleep(6000);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());

            }
        });



//        for (int i = 0 ; i < 20 ; i++){
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(TimeUnit.MINUTES.toMillis(1));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//        }
//        int n = 20;
    }
}
