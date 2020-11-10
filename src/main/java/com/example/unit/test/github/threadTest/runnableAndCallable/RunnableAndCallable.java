package com.example.unit.test.github.threadTest.runnableAndCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class RunnableAndCallable {

    /**
     * Runnable    public abstract void run();
     * Callable    V call() throws Exception;
     * 抽象的计算任务
     * @param args
     */
    public static void main(String[] args) {
        runnableTest();
        callableTest();
    }

    private static void runnableTest(){
        Runnable task = new Runnable(){
            @Override
            public void run() {
                //TODO
                System.out.println("runnable...");
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    private static void callableTest(){
        Callable callable = new Callable<Object>(){
            @Override
            public Object call() throws Exception {
                return null;
            }
        };
       FutureTask<Object> futureTask = new FutureTask<Object>(callable);
       futureTask.run();
    }

}
