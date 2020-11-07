package com.example.unit.test.github.controller;

import com.example.unit.test.github.entity.DroolsVersionRecord;
import com.example.unit.test.github.service.CacheService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.util.concurrent.ListenableFuture;
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

    /**
     * 内存回收
     * 1,容器回收           CacheBuilder.maximumSize(long)
     * 2,定时回收           expireAfterAccess(long, TimeUnit); expireAfterWrite(long, TimeUnit)
     * 3,基于引用回收
     *      使用弱引用的键     CacheBuilder.weakKeys();
     *      或弱引用的值       CacheBuilder.weakValues()
     *      或软引用的值       CacheBuilder.softValues()
     */

    @Autowired
    private CacheService cacheService;
    /**
     * 创建缓存对象 设置属性
     */
    private Cache<Long,String> cache1 = CacheBuilder.newBuilder()
            .expireAfterWrite(30L, TimeUnit.MINUTES)
            .maximumSize(1000L)
            .build();

    private Cache<Long,DroolsVersionRecord> cache2 = CacheBuilder.newBuilder()
            .expireAfterWrite(5L, TimeUnit.MINUTES)
            .maximumSize(4L)
            .build(new CacheLoader() {
                @Override
                public Object load(Object o) throws Exception {
                    return null;
                }

                @Override
                public ListenableFuture reload(Object key, Object oldValue) throws Exception {
                    return super.reload(key, oldValue);
                }
            });

    /**
     * @param key
     * @return
     */
    @GetMapping(value = "test1")
    public Object testCache1(@RequestParam(value = "key")Long key){

        try {
            return cache1.get(key,() ->{
                String drlversion = cacheService.testCache1(key);
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

    /**
     * @param key
     * @return
     */
    @GetMapping(value = "test2")
    public Object testCache2(@RequestParam(value = "key")Long key){

        try {
            return cache2.get(key,() ->{
                DroolsVersionRecord result = cacheService.testCache2(key);
                return result;
            });
        } catch (ExecutionException e) {
            log.error("加载缓存失败，userId:{}, e:{}", key, e);
        }
        return null;
    }

}