package com.xinyu.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class AtomicIntegerTest {
    public int count;

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        int threadCount = 5;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    for (int j = 0; j < 10000; j++) {
                        atomicIntegerTest.count++;
                    }
                    countDownLatch.countDown();
                }
            }.start();
        }

        countDownLatch.await();
        System.out.println(atomicIntegerTest.count);
    }
}
