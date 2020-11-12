package com.example.unit.test.github.threadTest;

import java.util.concurrent.TimeUnit;

public class TryConcurrency {
    public static void main(String[] args) {
        browseNews();
        enjoyMusic();
    }

    /**
     * browseNews
     * browseNews
     * browseNews
     * browseNews
     * browseNews
     * browseNews
     * browseNews
     * browseNews
     * browseNews
     * browseNews
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
