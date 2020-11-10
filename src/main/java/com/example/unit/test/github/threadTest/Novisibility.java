package com.example.unit.test.github.threadTest;

public class Novisibility {

    /**
     * 共享变量
     * ready,number 没有同步机制  会出现线程安全的问题
     *
     */

    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            // 读操作 新开的线程操作
            while (!ready){
                Thread.yield();;
                System.out.println(number);  //可能这里会打印出来 0   (知识点: 重排序 Reordering)
            }
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();

        //写操作 (赋值)   主线程
        number = 42;
        ready = true;
    }
}
