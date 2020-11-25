package com.example.unit.test.github.threadTest.classLoaderTest;

public class Singleton {

    //mark02
    private static Singleton singleton = new Singleton();
    /**
     * 0
     * 1
     */

    //mark01
    private static int x = 0;

    private static int y;

    //mark02
//    private static Singleton singleton = new Singleton();
    /**
     * 1
     * 1
     */

    private Singleton(){
        x++;
        y++;
    }

    public static Singleton getInstance(){
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }

}
