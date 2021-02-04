package com.xinyu.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanTest {
    public AtomicBoolean aBoolean = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {
        AtomicBooleanTest atomicIntegerTest = new AtomicBooleanTest();

        new Thread("1"){
            @Override
            public void run() {
                super.run();
                if (atomicIntegerTest.aBoolean.compareAndSet(true,false)) {
                    System.out.println(currentThread().getName() + "true");
                }else {
                    System.out.println(currentThread().getName() + "false");
                }
            }
        }.start();

        new Thread("2"){
            @Override
            public void run() {
                super.run();
                if (atomicIntegerTest.aBoolean.compareAndSet(true,false)) {
                    System.out.println(currentThread().getName() + "true");
                }else {
                    System.out.println(currentThread().getName() + "false");
                }
            }
        }.start();

    }
}
