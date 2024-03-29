package com.xinyu.test;

public class TestInterrupt4 {
    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        testThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testThread.interrupt();
    }


    public static class TestThread extends Thread{
        @Override
        public void run() {
            super.run();
            while (!isInterrupted()){
                System.out.println("testThread");
            }
        }
    }

}
