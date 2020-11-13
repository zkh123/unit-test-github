package com.example.unit.test.github.threadTest.produceAndConsume;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 线程安全
 */
@Slf4j
public class EventQueue2 {

    static class Event{
        private String param;

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public Event(String param) {
            this.param = param;
        }
    }

    //存储事件event的队列
    private final LinkedList<Event> linkedList = new LinkedList();
    //队列最大长度
    private final static int MAX_SIZE = 10;

    //生产
    public void offer(Event event){
        synchronized (linkedList){
            while(linkedList.size() >= MAX_SIZE){
                console("队列已满");
                try {
                    linkedList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            linkedList.addLast(event);
            console("往队列中添加Event : " + event.getParam());
            linkedList.notifyAll();
        }
    }

    //消费
    public void take(){
        synchronized (linkedList){
            while(linkedList.size() == 0){
                console("队列为空");
                try {
                    linkedList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                TimeUnit.SECONDS.sleep(2);  //消费速度相对较慢
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            EventQueue2.Event event = linkedList.removeFirst();
            console("从队列中消费Event : " + event.getParam());
            linkedList.notifyAll();
        }
    }

    private void console(String message){
        log.info(Thread.currentThread().getName() + " message " + message);
    }

}
