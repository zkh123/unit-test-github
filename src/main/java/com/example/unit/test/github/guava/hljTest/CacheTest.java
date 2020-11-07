package com.example.unit.test.github.guava.hljTest;

import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.*;
import com.google.common.util.concurrent.ListenableFuture;
import javafx.util.Callback;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheTest {
    public static void main(String[] args) throws Exception{
//        Cache<String,Object> cache = CacheBuilder.newBuilder()
//                .listener(new DefaultListener())//设置监听器
//                .factor(0.1)                    //设置缓存淘汰因子（Cap类型时有效）
//                .interval(1000)                 //执行淘汰的工作线程执行的频率，单位ms
//                .ttl(5000)                      //缓存的过期时间，单位ms
//                .maximum(20)                    //最大缓存数量
//                .monitor(MonitorType.TTL)       //淘汰策略设置
//                .build(new CacheLoader<String,Object>(){
//                    @Override                   //CacheLoader设置
//                    public Object load(String key) {
//                        return key+"-aaaa";
//                    }
//                });
//        for(int i=0;i<30;i++){
//            cache.put("key"+i,"value"+i);
//            Thread.sleep(200);
//        }
//
//        Thread.sleep(6000);
//        System.out.println(cache.get("java"));
    }

    private void test01(){
        Cache<String, List<TypeThatsTooLongForItsOwnGood>> cache = CacheBuilder.newBuilder()
                .maximumSize(1000L)
                .build(new CacheLoader() {
                    @Override
                    public Object load(Object o) throws Exception {
                        return null;
                    }

                    @Override
                    public Map loadAll(Iterable keys) throws Exception {
                        return super.loadAll(keys);
                    }

                    @Override
                    public ListenableFuture reload(Object key, Object oldValue) throws Exception {
                        return super.reload(key, oldValue);
                    }
                });

        String key = "";

        List<TypeThatsTooLongForItsOwnGood> result = Collections.emptyList();
        try {
                result = cache.get(key,()->{
                List<TypeThatsTooLongForItsOwnGood> list = new ArrayList<>();
                list.add(new TypeThatsTooLongForItsOwnGood("ppd",12));
                list.add(new TypeThatsTooLongForItsOwnGood("ljs",20));
                return list;
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(JSONObject.toJSON(result));
    }

    private void test02(){
        Cache<Integer,String> cache = CacheBuilder.newBuilder()
                .expireAfterWrite(20L, TimeUnit.MINUTES)
                .maximumSize(1000L)
                .removalListener(new RemovalListener() {
                    @Override
                    public void onRemoval(RemovalNotification removalNotification) {

                    }
                })
                .build();

        Integer param = 0;

        try {
            String o = cache.get(param,new Callable<String>(){
                @Override
                public String call() throws Exception {
                    return doThingsTheHardWay(param);
                }

            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private String doThingsTheHardWay(Integer param) {
        return "";
    }


    private static Cache<String, String> cache = CacheBuilder.newBuilder().build();

    @Test
    public void test() throws ExecutionException {
        cache.put("a1", "b");
        String a1 = cache.get("a1", () -> "@");//b
        String a2 = cache.get("a2", () -> "@");//@

        System.out.println("a1=" + a1 + " ,a2="+a2);  // a1=b ,a2=@

        cache.invalidateAll();

    }
}