package com.xinyu.test;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>(true);

        new Thread("TEST"){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronousQueue.offer(2);
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        try {
            Integer take2 = synchronousQueue.take();
            System.out.println(take2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}


