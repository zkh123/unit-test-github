package com.example.unit.test.github.threadTest.monitorTest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class MonitorObject02 {

    /**
     * 对象锁 (this)
     */
    public synchronized void test01(){
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("MonitorObject02 test01");
    }

    public void test02(){
        synchronized (this){
            log.info("MonitorObject02 test02");
        }
    }

    public static void main(String[] args) {
        MonitorObject02 monitorObject02 = new MonitorObject02();


        new Thread(monitorObject02::test01,"MonitorObject02-thread01").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                monitorObject02.test02();
            }
        },"MonitorObject02-thread02").start();
    }

    /**
     * 上面两个线程 分别调用了test01 test02两个方法 但是要的是同一个锁 monitor
     */

}
