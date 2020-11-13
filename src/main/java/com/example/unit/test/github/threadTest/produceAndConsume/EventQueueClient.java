package com.example.unit.test.github.threadTest.produceAndConsume;

public class EventQueueClient {

    public static void main(String[] args) {

        EventQueue eventQueue = new EventQueue();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int k = 1;
                while (true){
                    eventQueue.offer(new EventQueue.Event("producer" + k++));
                }
            }
        },"producer").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    eventQueue.take();
                }
            }
        },"consumer").start();
    }

}