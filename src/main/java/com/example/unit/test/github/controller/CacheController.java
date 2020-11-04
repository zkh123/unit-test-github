package com.example.unit.test.github.controller;

import com.example.unit.test.github.entity.DroolsVersionRecord;
import com.example.unit.test.github.service.CacheService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


@Slf4j
@RestController
@RequestMapping(value = "cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;
    /**
     * 创建缓存对象 设置属性
     */
    private Cache<Long,String> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(5L, TimeUnit.MINUTES)
            .maximumSize(4L)
            .build();

    /**
     * @param key
     * @return
     */
    @GetMapping(value = "test1")
    public Object testCache1(@RequestParam(value = "key")Long key){

        try {
            return cache.get(key,() ->{
                String drlversion = cacheService.testCache(key);
                if (!StringUtils.isBlank(drlversion)){
                    return drlversion;
                }
                return "";
            });
        } catch (ExecutionException e) {
            log.error("加载缓存失败，userId:{}, e:{}", key, e);
        }
        return null;
    }


}