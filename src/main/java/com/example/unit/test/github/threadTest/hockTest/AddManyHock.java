package com.example.unit.test.github.threadTest.hockTest;

import java.util.concurrent.TimeUnit;

public class AddManyHock {

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread("hock-thread-01"){
            @Override
            public void run() {
                try {
                    System.out.println("hock-thread-01 is running");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hock-thread-01 is over");
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread("hock-thread-02"){
            @Override
            public void run() {
                try {
                    System.out.println("hock-thread-02 is running");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("hock-thread-02 is over");
            }
        });

        System.out.println("main over...");
    }
    /**
     * main over...
     * hock-thread-01 is running
     * hock-thread-02 is running
     * hock-thread-02 is over
     * hock-thread-01 is over
     */
}
