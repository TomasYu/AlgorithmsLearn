package com.xinyu.test.java.thread;

public class ThreadTest {

    public static void main(String[] args) {

        TestThread testThread = new TestThread("A");
        testThread.start();

        Thread thread = new Thread(new TestRun(),"B");
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //我们在这里断点  可以看到只有A线程存在 因为B已经执行完挂了
        int a = 30;


    }


    static class TestThread extends Thread{

        public TestThread(String a) {
            super(a);
        }

        @Override
        public void run() {
            super.run();
            System.out.println("TestThread");
        }
    }

    static class TestRun implements Runnable{

        @Override
        public void run() {
            System.out.println("TestRun");
            while (true){

            }
        }
    }
}
