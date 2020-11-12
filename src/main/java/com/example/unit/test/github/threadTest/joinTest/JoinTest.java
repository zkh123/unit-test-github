package com.example.unit.test.github.threadTest.joinTest;

import java.util.concurrent.TimeUnit;

public class JoinTest {

    public static void main(String[] args) {

        Thread thread01 = createThread("thread01");
        Thread thread02 = createThread("thread02");
        thread01.start();
        thread02.start();

        try {
            thread01.join();
        } catch (InterruptedException e) {  // InterruptedException 这个异常 (中断异常)
            e.printStackTrace();
        }
        try {
            thread02.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0 ; i < 10 ; i++){
            System.out.println("i : " + i);
        }

    }

    private static Thread createThread(String threadName){
         return new Thread(threadName){
             @Override
             public void run() {
                 System.out.println("thread name : " + threadName);
                 try {
                     TimeUnit.SECONDS.sleep(10);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }

             }
         };
    }

}
