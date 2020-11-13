package com.example.unit.test.github.threadTest.stopTest;

import java.util.concurrent.TimeUnit;

public class InterruptThreadExit2 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread("test2"){
            @Override
            public void run() {
                System.out.println("thread start..");
                while (true){
                    try {
                        System.out.println("work...");
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("thread end...");
            }
        };

        thread.start();

        System.out.println("sleep start");
        TimeUnit.SECONDS.sleep(11);
        System.out.println("sleep end");

        thread.interrupt();
    }

    /**
     * sleep start
     * thread start..
     * work...
     * work...
     * work...
     * work...
     * work...
     * work...
     * sleep end
     * java.lang.InterruptedException: sleep interrupted
     * 	at java.lang.Thread.sleep(Native Method)
     * 	at java.lang.Thread.sleep(Thread.java:340)
     * 	at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
     * 	at com.example.unit.test.github.threadTest.stopTest.InterruptThreadExit2$1.run(InterruptThreadExit2.java:15)
     * thread end...
     */

}
