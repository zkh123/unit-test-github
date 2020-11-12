package com.example.unit.test.github.threadTest.joinTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FightQueryTask extends Thread implements FightQuery {

    private final String origin;
    private final String destination;
    private final List<String> flightList = new ArrayList<>();


    public FightQueryTask(String airline,String origin, String destination) {
        super(airline);
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public void run() {
        int randomVal = ThreadLocalRandom.current().nextInt(10);

        try {
            TimeUnit.SECONDS.sleep(randomVal);
            this.flightList.add(this.getName() + "_" + randomVal);  //查询航空公司的数据 添加到flightList集合中
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> get() {
        return this.flightList;
    }
}
