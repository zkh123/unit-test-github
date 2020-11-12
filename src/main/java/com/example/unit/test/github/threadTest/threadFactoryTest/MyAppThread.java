package com.example.unit.test.github.threadTest.threadFactoryTest;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyAppThread extends Thread {

    private static final String DEFAULT_NAME = "MyAppThread";
    private static volatile boolean debugLifecycle = false;
    private static final AtomicInteger created = new AtomicInteger();
    private static final AtomicInteger alive = new AtomicInteger();
    private static final Logger log = Logger.getAnonymousLogger();

    public MyAppThread(Runnable target) {
        this(target,MyAppThread.DEFAULT_NAME);
    }

    public MyAppThread(Runnable target, String name) {
        super(target, name);
        setUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler(){
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        log.log(Level.SEVERE,"UNCAUGHT in thread " + t.getName(), e);
                    }
                }
        );
    }

    @Override
    public void run() {
        super.run();
    }


}
