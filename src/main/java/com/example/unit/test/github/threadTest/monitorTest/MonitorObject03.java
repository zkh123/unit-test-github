package com.example.unit.test.github.threadTest.monitorTest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class MonitorObject03 {

    /**
     * class锁
     */
    public static synchronized void test01(){
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("MonitorObject03 test01");
    }

    public static synchronized void test02(){
        log.info("MonitorObject03 test02");
    }

    public static void main(String[] args) {

        new Thread(MonitorObject03::test01,"MonitorObject03-thread01").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                MonitorObject03.test02();
            }
        },"MonitorObject03-thread02").start();
    }

    /**
     * 上面两个线程 分别调用了test01 test02两个方法 但是要的是同一个锁 monitor
     */

}
