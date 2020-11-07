package com.example.unit.test.github.service;

import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TestService {


//    private Cache<Long, String> cache = CacheBuilder.newBuilder()
//            .expireAfterWrite(30L, TimeUnit.MINUTES)
//            .maximumSize(1000L)
//            .build();


    public void test(){
        CacheBuilder.newBuilder()
                .expireAfterWrite(30L,TimeUnit.MINUTES)
                .maximumSize(1000L)
                .build();
    }

}
