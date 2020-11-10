package com.example.unit.test.github.threadTest;

import com.example.unit.test.github.config.InitThreadPool;

import java.util.concurrent.atomic.AtomicLong;

public class CountingFactorizer {

    private final AtomicLong count = new AtomicLong(0);  //

    public void service(){
       long resultCount = count.incrementAndGet();
        System.out.println(resultCount);
    }


    public static void main(String[] args) {
        CountingFactorizer countingFactorizer = new CountingFactorizer();

        for (int i = 0 ; i < 100 ; i++){
            InitThreadPool.getThreadPool().execute(()->{
                countingFactorizer.service();
            });
        }
    }

}
