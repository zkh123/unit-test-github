package com.example.unit.test.github.threadTest.semaphoreTest;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;

public class BounderExecutor {

    private final Executor exec;
    private final Semaphore semaphore;


    public BounderExecutor(Executor exec, int bound) {
        this.exec = exec;
//        this.semaphore = semaphore;
        this.semaphore = new Semaphore(bound);
    }


    public void submitTask(Runnable command) throws InterruptedException {
        semaphore.acquire();
        try {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        command.run();
                    }finally {
                        semaphore.release();
                    }
                }
            });
        }catch (Exception e){
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };
    }

}
