package com.example.unit.test.github.threadTest;

import java.util.concurrent.TimeUnit;

public class IsInterruptTest2 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread("test2"){
            @Override
            public void run() {
                try {
                    TimeUnit.MINUTES.sleep(2);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    System.out.println("error : " + this.isInterrupted());
                }
            }
        };

//        thread.setDaemon(true);
        thread.start();

        TimeUnit.SECONDS.sleep(2);

        System.out.println("step1 thread : " + thread.isInterrupted());
        thread.interrupt();  // interrupt() 方法只是改变中断状态而已，它不会中断一个正在运行的线程。
        TimeUnit.SECONDS.sleep(2);
        System.out.println("step2 thread : " + thread.isInterrupted());

        System.out.println("end...");

    }

}
