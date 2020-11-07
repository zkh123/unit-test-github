package com.example.unit.test.github.controller;

import com.example.unit.test.github.service.DroolsVersionRecordService;
import com.example.unit.test.github.service.RedissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jingzhidematong
 * @date 2020/10/28
 */
@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private DroolsVersionRecordService droolsVersionRecordService;
    @Autowired
    private RedissonService redissonService;

    @GetMapping(value = "/1")
    public Object test1(){
        System.out.println("hello world!");
        return "ok";
    }

    @GetMapping(value = "/2")
    public Object test02(){
        return droolsVersionRecordService.selectByPrimaryKey(1l);
    }

    @GetMapping(value = "/3")
    public Object test03(@RequestParam(value = "userId")String userId){
        redissonService.testRedisLock(userId);
        return "test03 ok";
    }
}