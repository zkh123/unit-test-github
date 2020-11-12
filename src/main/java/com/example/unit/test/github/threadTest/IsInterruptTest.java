package com.example.unit.test.github.threadTest;

import java.util.concurrent.TimeUnit;

public class IsInterruptTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread("test"){
            @Override
            public void run() {
                while (true){
                    System.out.println("run...");
                }
            }
        };

        thread.start();

        System.out.println("step1 thread : " + thread.isInterrupted());
        thread.interrupt();  // interrupt() 方法只是改变中断状态而已，它不会中断一个正在运行的线程。
        System.out.println("step2 thread : " + thread.isInterrupted());

        TimeUnit.SECONDS.sleep(10);
        System.out.println("end...");

    }

}
