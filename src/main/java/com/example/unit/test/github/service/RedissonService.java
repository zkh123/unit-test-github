package com.example.unit.test.github.service;

import com.alibaba.fastjson.JSONObject;
import com.example.unit.test.github.enums.ExceptionEnum;
import com.example.unit.test.github.exception.ExceptionCatch;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RedissonService {

    ExecutorService threadPool = new ThreadPoolExecutor(1, 90, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>
            (1024), new ThreadPoolExecutor.AbortPolicy());

    @Resource
    private RedissonClient redissonClient;


    public void testRedisLock(String userId){

        threadPool.execute(() -> {
            int i = 10000;
            while (true){
                if (i>0){
                    String flowNo = UUID.randomUUID().toString().replaceAll("-", "");

                    //创建锁对象
                    RLock lock = redissonClient.getLock(String.format("unit:test:github:send:%s",flowNo));
                    try {
                        //尝试获取锁对象
                        if (!lock.tryLock(10,TimeUnit.MINUTES)){
                            log.error("抱歉 两次了{}" + flowNo);
                            throw new ExceptionCatch(ExceptionEnum.SEND_REPEAT);
                        }
                        //干正事
                        doSomething(flowNo,Long.valueOf(userId));
                        System.out.println("flowNo = " + flowNo);
                        i--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        });

    }

    private Map<String,Object> doSomething(String flowNo,Long userId){
        Map<String,Object> map = new HashMap<>();
        map.put(flowNo,userId);
        log.info(JSONObject.toJSONString(map));
        return map;
    }

}
