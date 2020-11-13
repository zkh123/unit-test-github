package com.example.unit.test.github.threadTest.hockTest;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class CaptureThreadException {

    public static void main(String[] args) {

        //设置回调接口
        Thread.setDefaultUncaughtExceptionHandler((thread,throwable) ->{
            log.info(thread.getName() + " 发生异常了。");
            throwable.printStackTrace();

            /**
             * 能拿到线程异常 的情况 就可以进行异常的相应处理
             * sendEmail()
             */

        });

        Thread thread = new Thread(() ->{
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("start..");
            //搞个报错
            int s = 1/0;
            log.info("end...");
        },"CaptureThreadException-thread-test");

        thread.start();

        log.info("...over...");

    }

    /**
     * 20:30:55.429 [main] INFO com.example.unit.test.github.threadTest.hockTest.CaptureThreadException - ...over...
     * 20:31:05.437 [CaptureThreadException-thread-test] INFO com.example.unit.test.github.threadTest.hockTest.CaptureThreadException - start..
     * Exception in thread "CaptureThreadException-thread-test" java.lang.ArithmeticException: / by zero
     * 	at com.example.unit.test.github.threadTest.hockTest.CaptureThreadException.lambda$main$0(CaptureThreadException.java:26)
     * 	at java.lang.Thread.run(Thread.java:748)
     * 	------------------------------------------------------------------------------------------------------------------------------------
     * 20:31:47.157 [main] INFO com.example.unit.test.github.threadTest.hockTest.CaptureThreadException - ...over...
     * 20:31:57.164 [CaptureThreadException-thread-test] INFO com.example.unit.test.github.threadTest.hockTest.CaptureThreadException - start..
     * 20:31:57.165 [CaptureThreadException-thread-test] INFO com.example.unit.test.github.threadTest.hockTest.CaptureThreadException - CaptureThreadException-thread-test 发生异常了。
     * java.lang.ArithmeticException: / by zero
     * 	at com.example.unit.test.github.threadTest.hockTest.CaptureThreadException.lambda$main$1(CaptureThreadException.java:26)
     * 	at java.lang.Thread.run(Thread.java:748)
     */

}
