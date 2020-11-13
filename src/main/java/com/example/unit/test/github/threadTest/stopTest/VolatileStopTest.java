package com.example.unit.test.github.threadTest.stopTest;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class VolatileStopTest {

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        myThread.start();

        TimeUnit.SECONDS.sleep(2);
        log.info("close");
        myThread.close();
    }

    static class MyThread extends Thread{

        private volatile boolean close = false;

        @Override
        public void run() {
            while (!close && !this.isInterrupted()){
                log.info("thread run...");
            }
        }

        public void close(){
            close = true;
            this.interrupt();
        }
    }

    /**
     * 13:39:53.475 [Thread-0] INFO com.example.unit.test.github.threadTest.stopTest.VolatileStopTest - thread run...
     * 13:39:53.475 [Thread-0] INFO com.example.unit.test.github.threadTest.stopTest.VolatileStopTest - thread run...
     * 13:39:53.475 [Thread-0] INFO com.example.unit.test.github.threadTest.stopTest.VolatileStopTest - thread run...
     * 13:39:53.199 [main] INFO com.example.unit.test.github.threadTest.stopTest.VolatileStopTest - close
     * 13:39:53.475 [Thread-0] INFO com.example.unit.test.github.threadTest.stopTest.VolatileStopTest - thread run...
     * 13:39:53.475 [Thread-0] INFO com.example.unit.test.github.threadTest.stopTest.VolatileStopTest - thread run...
     * 13:39:53.475 [Thread-0] INFO com.example.unit.test.github.threadTest.stopTest.VolatileStopTest - thread run...
     */
}
