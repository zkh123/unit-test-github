package com.example.unit.test.github.threadTest.produceAndConsume;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class SynchronizedDefault {

    public synchronized void syncMethod(){
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDefault synchronizedDefault = new SynchronizedDefault();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedDefault.syncMethod();
            }
        },"thread01").start();

        TimeUnit.MILLISECONDS.sleep(2);

        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedDefault.syncMethod();
            }
        },"thread02");
        thread02.start();

       log.info("end...");
    }

}
