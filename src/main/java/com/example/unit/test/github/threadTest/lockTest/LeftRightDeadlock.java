package com.example.unit.test.github.threadTest.lockTest;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class LeftRightDeadlock {
    private final Object left = new Object();
    private final Object right = new Object();

    /**
     * 顺序死锁
     */
    public void leftRight(){
        synchronized (left){
            synchronized (right){
                doSomething();
            }
        }
    }
    public void rightLeft(){
        synchronized (right){
            synchronized (left){
                doSomething();
            }
        }
    }


    public void doSomething(){
        System.out.println("do something...");
//        Lock
//        ReentrantLock
//        ReadWriteLock
//        ReentrantReadWriteLock
    }

    private void test1() throws InterruptedException {
        Object object = new Object();
        object.wait();  //释放锁
        object.notify();
        object.notifyAll();

        Condition condition = null;
        condition.await();
    }
}
