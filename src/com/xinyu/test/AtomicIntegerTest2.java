package com.xinyu.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest2 {
    public AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerTest2 atomicIntegerTest = new AtomicIntegerTest2();
        int threadCount = 5;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    for (int j = 0; j < 10000; j++) {
                        atomicIntegerTest.count.incrementAndGet();
                    }
                    countDownLatch.countDown();
                }
            }.start();
        }

        countDownLatch.await();
        System.out.println(atomicIntegerTest.count);
    }
}
