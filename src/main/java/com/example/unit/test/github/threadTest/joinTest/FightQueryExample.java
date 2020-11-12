package com.example.unit.test.github.threadTest.joinTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FightQueryExample {

    private static List<String> fightCompany = Arrays.asList("CSA","CEA","HEA");

    public static void main(String[] args) {
        List<String> results = search("SH","BJ");

        //打印结果
        results.forEach(System.out::println);
    }

    private static List<String> search(String original, String dest){
        final List<String> result = new ArrayList<>();

        //创建三家公司查询数据的线程
        List<FightQueryTask> tasks = fightCompany.stream()
                .map(f ->createSearchTask(f,original,dest))
                .collect(toList());

        //开启线程
        tasks.forEach(Thread::start);

        //每个线程进行join()操作
        tasks.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //结果汇集
        tasks.stream()
                .map(FightQueryTask::get)
                .forEach(result::addAll);

        return result;
    }


    private static FightQueryTask createSearchTask(String fight, String original, String dest){
        return new FightQueryTask(fight,original,dest);
    }
}
