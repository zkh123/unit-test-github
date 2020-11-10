package com.example.unit.test.github.threadTest.hashMapTest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Memoizer2<A,V> implements Computable<A,V> {

    private final Map<A,V> cache = new <A,V>ConcurrentHashMap();  //线程安全的map集合
    private final Computable<A,V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    /**
     * ConcurrentHashMap 保证的操作的线程安全性
     * 但是
     * 问题: 同一时刻 只能有一个线程操作compute这个方法
     * @param arg
     * @return
     */
    @Override
    public V compute(A arg) {
        V result = cache.get(arg);
        if (null == result){
            result = c.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }
}
