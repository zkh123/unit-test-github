package com.example.unit.test.github.threadTest.ticket;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TicketWindowRunnable implements Runnable {

    // index 是共享资源  线程不安全
    private int index;

    private final static int MAX = 200;

    @Override
    public void run() {
        //具体业务逻辑
        while (index < MAX){
            log.info(Thread.currentThread()+" 的号码 : " + (index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        TicketWindowRunnable task = new TicketWindowRunnable();

        Thread windowThread01 = new Thread(task,"一号窗口");
        Thread windowThread02 = new Thread(task,"二号窗口");
        Thread windowThread03 = new Thread(task,"三号窗口");
        Thread windowThread04 = new Thread(task,"四号窗口");

        windowThread01.start();
        windowThread02.start();
        windowThread03.start();
        windowThread04.start();
    }
}
