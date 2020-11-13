package com.example.unit.test.github.threadTest;

import java.util.concurrent.TimeUnit;

public class MutexTest1 {

    public void accessResource(Object object){
        synchronized (object){
            try {
                TimeUnit.MINUTES.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final  Object object = new Object();
        MutexTest1 mutexTest = new MutexTest1();

        for (int i = 0 ; i < 5 ; i++){
            new Thread("MutexTest-accessResource&&&-"+i){
                @Override
                public void run() {
                    mutexTest.accessResource(object);
                }
            }.start();

        }

    }

}
