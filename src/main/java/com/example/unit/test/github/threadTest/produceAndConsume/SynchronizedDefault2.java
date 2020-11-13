package com.example.unit.test.github.threadTest.produceAndConsume;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class SynchronizedDefault2 {

    public synchronized void syncMethod(){
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedDefault2 synchronizedDefault = new SynchronizedDefault2();

        new Thread(() -> {
            synchronizedDefault.syncMethod();
        },"thread01").start();

        TimeUnit.MILLISECONDS.sleep(2);

        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizedDefault.syncMethod();
            }
        },"thread02");
        thread02.start();

        TimeUnit.MILLISECONDS.sleep(2);

        log.info(" step01 : "+ thread02.isInterrupted());
        thread02.interrupt();
        log.info(" step02 : "+ thread02.isInterrupted());

        log.info(thread02.getState().name());

    }

}
