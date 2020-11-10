package com.example.unit.test.github.threadTest.hashMapTest;

import java.util.HashMap;
import java.util.Map;

public class Memoizerl<A,V> implements Computable<A,V> {

    private final Map<A,V> cache = new HashMap<A,V>();
    private final Computable<A,V> c;

    public Memoizerl(Computable<A, V> c) {
        this.c = c;
    }

    /**
     * 添加synchronized compute方法进行了同步 保证了线程安全性
     * 问题: 同一时刻 只能有一个线程操作compute这个方法
     * @param arg
     * @return
     */
    @Override
    public synchronized V compute(A arg) {
        V result = cache.get(arg);
        if (null == result){
            result = c.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }
}
