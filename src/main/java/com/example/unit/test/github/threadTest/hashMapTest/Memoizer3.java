package com.example.unit.test.github.threadTest.hashMapTest;

import java.util.Map;
import java.util.concurrent.*;

public class Memoizer3<A,V> implements Computable<A,V> {

    private final Map<A, Future<V>> cache = new <A,V>ConcurrentHashMap<A,Future<V>>();  //线程安全的map集合
    private final Computable<A,V> c;

    public Memoizer3(Computable<A, V> c) {
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
    public V compute(A arg) throws Exception {
        Future<V> result = cache.get(arg);
        if (null == result){
            Callable<V> eval = new Callable<V>(){
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<V>(eval);
            result = ft;
//            cache.put(arg,result);
            cache.putIfAbsent(arg,result); //ConcurrentHashMap的原子操作
            ft.run();
        }
        try {
            return result.get();
        } catch (Exception e) {
            throw new Exception(e.getCause());
        }
    }
}
