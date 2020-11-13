package com.example.unit.test.github.threadTest.stopTest;

import java.util.concurrent.TimeUnit;

public class InterruptThreadExit {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread("test"){
            @Override
            public void run() {
                System.out.println("thread start..");
                while (!this.isInterrupted()){
                    System.out.println("work...");
                }
                System.out.println("thread end...");
            }
        };

        thread.start();

        System.out.println("sleep start");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("sleep end");

        thread.interrupt();
    }

    /**
     * work...
     * sleep end
     * work...
     * work...
     * work...
     * work...
     * work...
     * work...
     * work...
     * thread end...
     */

}
