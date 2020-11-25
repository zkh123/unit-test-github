package com.example.unit.test.github.threadTest.singletonTest;

/**
 * 懒汉式 + 同步方法
 */
// final 不能被继承
public final class Singleton3 {

    // 加载的时候 不会马上被实例化
    private byte[] bytes = new byte[1024];

    private static Singleton3 singleton2 = null;

    private Singleton3(){
    }

    /**
     * 同步 线程安全
     * @return
     */
    public static synchronized Singleton3 getSingleton(){
        if (null == singleton2){
            singleton2 = new Singleton3();
        }
        return singleton2;
    }

    public static void main(String[] args) {
        Singleton3.getSingleton();
    }
}
