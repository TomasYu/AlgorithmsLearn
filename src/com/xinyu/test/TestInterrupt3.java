package com.xinyu.test;

public class TestInterrupt3 {
    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        testThread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testThread.stopWork();
    }


    public static class TestThread extends Thread{
        private boolean mStopWork = false;

        public void stopWork() {
            this.mStopWork = true;
        }

        @Override
        public void run() {
            super.run();
            while (!mStopWork){
                System.out.println("testThread");
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }



}
