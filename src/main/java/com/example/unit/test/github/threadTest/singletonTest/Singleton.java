package com.example.unit.test.github.threadTest.singletonTest;

/**
 * 饿汉式
 */
// final 不能被继承
public final class Singleton {

    // 加载的时候 就会被实例化
    private byte[] bytes = new byte[1024];

    private static Singleton singleton = new Singleton();

    private Singleton(){
    }

    public static Singleton getSingleton(){
        return singleton;
    }

    public static void main(String[] args) {
        Singleton.getSingleton();
    }
}
