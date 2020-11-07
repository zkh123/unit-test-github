package com.example.unit.test.github.guava.hljTest;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GuavaRefreshWhenCacheIsNullTest {

    public static void main(String[] args) {
        testGuavaRefreshWhenCacheIsNullThrowsException();
    }

    static CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
            .refreshAfterWrite(10, TimeUnit.SECONDS)
            .expireAfterWrite(20, TimeUnit.SECONDS);


    public static void testGuavaRefreshWhenCacheIsNullThrowsException() {
        LoadingCache<String, String> refreshWarehouseCache = cacheBuilder.build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                if ("ValueOfKeyIsNull".equals(key)) {
                    return null;
                }
                return "1234567890";
            }

            @Override
            public ListenableFuture<String> reload(String key, String oldValue) {
                System.out.println("testGuavaRefresh reload : key=" + key);
                return Futures.immediateFuture(load(key));
            }
        });

        try {
            String myValue = refreshWarehouseCache.get("myKey");
            myValue = refreshWarehouseCache.get("ValueOfKeyIsNull");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void testGuavaRefreshWhenCacheIsNullReturnDefaultNullValue() {

        String nullValue = "nullValue";

        LoadingCache<String, String> refreshWarehouseCache = cacheBuilder.build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                if ("ValueOfKeyIsNull".equals(key)) {
                    return nullValue;
                }
                return "1234567890";
            }

            @Override
            public ListenableFuture<String> reload(String key, String oldValue) {
                System.out.println("testGuavaRefresh reload : key=" + key);
                return Futures.immediateFuture(load(key));
            }
        });

        try {
            String myValue = refreshWarehouseCache.get("myKey");

            //throws Exception
            myValue = refreshWarehouseCache.get("ValueOfKeyIsNull");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void testGuavaRefreshWhenCacheIsNullReturnNull() {
        CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
                .refreshAfterWrite(10, TimeUnit.SECONDS)
                .expireAfterWrite(20, TimeUnit.SECONDS);

        LoadingCache<String, Optional<String>> refreshWarehouseCache = cacheBuilder.build(new CacheLoader<String, Optional<String>>() {
            @Override
            public Optional<String> load(String key) {
                if ("ValueOfKeyIsNull".equals(key)) {
                    return Optional.empty();
                }
                return Optional.of("1234567890");
            }

            @Override
            public ListenableFuture<Optional<String>> reload(String key, Optional<String> oldValue) {
                System.out.println("testGuavaRefresh reload : key=" + key);
                return Futures.immediateFuture(load(key));
            }
        });

        try {
            Optional<String> myValue = refreshWarehouseCache.get("myKey");
            myValue = refreshWarehouseCache.get("ValueOfKeyIsNull");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
