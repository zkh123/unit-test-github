package com.example.unit.test.github.threadTest.timerTest;

import java.util.Timer;
import java.util.TimerTask;

import static java.util.concurrent.TimeUnit.SECONDS;

public class OutOfTime {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();

        timer.schedule(new ThrowTask(),1);

        Thread.sleep(1000);
//        SECONDS.sleep(1);//停止1秒
        timer.schedule(new ThrowTask(),1);
        SECONDS.sleep(5);//停止5秒
    }

    static class ThrowTask extends TimerTask{
        @Override
        public void run() {
            //模拟一个异常抛出
            throw new RuntimeException();
        }
    }
}
