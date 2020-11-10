package com.example.unit.test.github.threadTest.hashMapTest;

/**
 * 入参类型为A
 * 出参类型为V
 * @param <A>
 * @param <V>
 */
public interface Computable<A,V> {
    V compute(A arg) throws Exception;
}
