package com.example.unit.test.github.threadTest.group;

public class ThreadConstruction {

    public static void main(String[] args) {
        Thread t1 = new Thread("t1");


        ThreadGroup group = new ThreadGroup("TestGroup");
        Thread t2 = new Thread(group,"t2");

        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();

        System.out.println("t1属于线程组为: " + t1.getThreadGroup());
        System.out.println("t2属于线程组为: " + t2.getThreadGroup());
        System.out.println("主线程属于线程组为: " + mainThreadGroup);

        /**
         * t1属于线程组为: java.lang.ThreadGroup[name=main,maxpri=10]
         * t2属于线程组为: java.lang.ThreadGroup[name=TestGroup,maxpri=10]
         * 主线程属于线程组为: java.lang.ThreadGroup[name=main,maxpri=10]
         */
    }

}
