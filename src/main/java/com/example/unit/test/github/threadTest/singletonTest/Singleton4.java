package com.example.unit.test.github.threadTest.singletonTest;

import java.net.Socket;
import java.sql.Connection;

/**
 * 懒汉式 + 同步方法
 */
// final 不能被继承
public final class Singleton4 {

    // 加载的时候 不会马上被实例化
    private byte[] bytes = new byte[1024];

    private static Singleton4 singleton4 = null;

    /**
     * 未实例化
     */
    Connection connection;
    Socket socket;

    private Singleton4(){
        /**
         * 对Connection和Socket进行实例化
         */
        this.connection = null;
        this.socket = null;
    }

    /**
     * 同步 线程安全 + 非第一次可以并发获取对象
     * @return
     */
    public static Singleton4 getSingleton(){
        if (null == singleton4){

            synchronized (Singleton4.class){
                if (null == singleton4){
                    singleton4 = new Singleton4();
                }
            }

        }
        return singleton4;
    }

    public static void main(String[] args) {
        Singleton4.getSingleton();
    }
}
