package com.example.unit.test.github.threadTest;

import java.util.concurrent.TimeUnit;

public class MutexTest {

    /**
     * 五个线程 用的五个不同的锁对象
     */
    private final static Object object = new Object();

    public void accessResource(){
        synchronized (object){
            try {
                TimeUnit.MINUTES.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MutexTest mutexTest = new MutexTest();

        for (int i = 0 ; i < 5 ; i++){
            new Thread("MutexTest-accessResource@@@-"+i){
                @Override
                public void run() {
                    mutexTest.accessResource();
                }
            }.start();

        }

    }

}
