package com.example.unit.test.github.threadTest.monitorTest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class MonitorObject01 {

    /**
     * 对象锁
     */
    public synchronized void test01(){
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("MonitorObject01 test01");
    }

    public synchronized void test02(){
        log.info("MonitorObject01 test02");
    }

    public static void main(String[] args) {
        MonitorObject01 monitorObject01 = new MonitorObject01();


        new Thread(monitorObject01::test01,"MonitorObject01-thread01").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                monitorObject01.test02();
            }
        },"MonitorObject01-thread02").start();
    }

    /**
     * 上面两个线程 分别调用了test01 test02两个方法 但是要的是同一个锁 monitor
     */

}
