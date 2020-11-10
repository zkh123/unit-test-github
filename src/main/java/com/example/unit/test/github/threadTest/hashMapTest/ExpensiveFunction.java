package com.example.unit.test.github.threadTest.hashMapTest;

import java.math.BigInteger;

public class ExpensiveFunction implements Computable<String, BigInteger> {

    @Override
    public BigInteger compute(String arg) {
        return new BigInteger(arg);
    }

}
