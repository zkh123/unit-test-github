package com.example.unit.test.github.threadTest.pool;

import java.util.Timer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {

    public static void main(String[] args) {
        testExecutor();
        testExecutorService();
        /**
         * ExecutorService 是 Executor的升级接口
         * 有更多的功能
         * 可以管理线程池等众多方法
         */
    }



    private static void testExecutor(){
        Executor exec = Executors.newFixedThreadPool(100);
        exec.execute(getRunnable());
    }

    /**
     * ExecutorService状态: 运行，关闭，已终止
     */
    private static void testExecutorService(){
        ExecutorService execs = Executors.newFixedThreadPool(100);
        execs.execute(getRunnable());

        /**
         * 关闭线程池
         */
        execs.shutdown();
    }


    private static Runnable getRunnable(){
        Runnable task = new Runnable(){
            @Override
            public void run() {
                //TODO
            }
        };
        return task;
    }

}
