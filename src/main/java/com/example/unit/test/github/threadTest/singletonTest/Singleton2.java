package com.example.unit.test.github.threadTest.singletonTest;

/**
 * 懒汉式
 */
// final 不能被继承
public final class Singleton2 {

    // 加载的时候 不会马上被实例化
    private byte[] bytes = new byte[1024];

    private static Singleton2 singleton2 = null;

    private Singleton2(){
    }

    public static Singleton2 getSingleton(){
        if (null == singleton2){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

    public static void main(String[] args) {
        Singleton2.getSingleton();
    }
}
