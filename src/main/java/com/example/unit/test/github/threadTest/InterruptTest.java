package com.example.unit.test.github.threadTest;

import java.util.concurrent.TimeUnit;

public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread("test"){
            @Override
            public void run() {
                try {
                    TimeUnit.MINUTES.sleep(2);  //当前线程睡眠2分钟
                } catch (InterruptedException e) {
                    //如果thread线程在running状态的线程 被中断了  会抛出这个异常
                    e.printStackTrace();
                }
            }
        };

        thread.start();

        TimeUnit.SECONDS.sleep(1);

        thread.interrupt();//去中断新创建的这个线程
    }

}
