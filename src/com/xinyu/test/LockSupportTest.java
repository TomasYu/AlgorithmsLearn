package com.xinyu.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);
                    LockSupport.unpark(thread);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
        LockSupport.park(new Object());


        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(2));
        System.out.println(1);
    }
}
