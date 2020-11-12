package com.example.unit.test.github.threadTest;

public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread("test"){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000L);
                        System.out.println("当前线程的名称: " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

//        thread.setDaemon(true);  主线程结束了

        thread.start();

//        System.out.println("thread: " + thread.isDaemon());

        Thread.sleep(2000L);

        System.out.println("end..." + Thread.currentThread().getName());

    }
}
