package com.example.unit.test.github.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class InitThreadPool {

    static ExecutorService threadPool = new ThreadPoolExecutor(1, 90, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>
            (1024), new ThreadPoolExecutor.AbortPolicy());

    public static ExecutorService getThreadPool(){
        return InitThreadPool.threadPool;
    }
}
