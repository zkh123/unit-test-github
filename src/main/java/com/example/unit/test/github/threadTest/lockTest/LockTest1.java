package com.example.unit.test.github.threadTest.lockTest;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest1 {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

    }

    /**
     * 悲观锁的调用方式
     */
    private static void test1(){
        lock.lock();
        doSomething();
        lock.unlock();
    }

    /**
     * 悲观锁的调用方式
     */
    private synchronized static void test11(){
        doSomething();
    }

    /**
     * 乐观锁的实现方式
     */
    private static AtomicInteger atomicInteger = new AtomicInteger();
    private static void test2(){
        atomicInteger.incrementAndGet();
    }


    /**
     * 需要同步的资源
     */
    private static void doSomething(){
        System.out.println("do something...");
    }

}