package com.example.unit.test.github.threadTest;

import java.util.concurrent.TimeUnit;

public class TryConcurrencyUpdate {

    /**
     * browseNews和 enjoyMusic 都是两个死循环的方法
     * @param args
     */
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
//                super.run();
                browseNews();
            }
        }.start();
//        browseNews();
        enjoyMusic();
    }

    /**
     * enjoyMusic
     * browseNews
     * enjoyMusic
     * browseNews
     * enjoyMusic
     * browseNews
     * enjoyMusic
     * browseNews
     */

    private static void browseNews(){
        for (;;){
            System.out.println("browseNews");
            sleep(1);
        }
    }

    private static void enjoyMusic(){
        for (;;){
            System.out.println("enjoyMusic");
            sleep(1);
        }
    }

    private static void sleep(int second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
