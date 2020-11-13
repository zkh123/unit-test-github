package com.example.unit.test.github.threadTest;

import java.util.concurrent.TimeUnit;

public class MutexTest2 {

    public void accessResource(){
        synchronized (this){
            try {
                TimeUnit.MINUTES.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MutexTest2 mutexTest = new MutexTest2();

        for (int i = 0 ; i < 5 ; i++){
            new Thread("MutexTest-accessResource***-"+i){
                @Override
                public void run() {
                    mutexTest.accessResource();
                }
            }.start();
        }

    }

}
