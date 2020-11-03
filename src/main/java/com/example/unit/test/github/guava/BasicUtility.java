package com.example.unit.test.github.guava;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Optional;

import java.util.ArrayList;
import java.util.List;

/**
 * 基本工具
 */
public class BasicUtility {
    public static void main(String[] args) {
        Integer invalidInput = null;
//        Optional<Integer> a = Optional.of(invalidInput);  //at com.example.unit.test.github.guava.BasicUtility.main(BasicUtility.java:14) java.lang.NullPointerException
//        System.out.println(test01(a,Optional.of(new Integer(10))));

//        System.out.println(test02(Optional.of(""),Optional.of(null))); // Optional.of(null) java.lang.NullPointerException

        test05();
    }

    public static void test05(){
//        Integer a = null;
        Integer a = 1;
        Optional<Integer> optional = Optional.of(a);
        System.out.println(optional.get());

        Integer kk = 1;
        Optional<Integer> optional1 = Optional.of(kk);
        System.out.println(optional1.isPresent());

        Optional absent = Optional.absent();
        System.out.println(absent.isPresent());

//        Integer b = null;
        Integer b = 1;
        Optional optional2 = Optional.fromNullable(b);
        System.out.println(optional2.isPresent());


        Integer param = 10;
        Optional<Integer> optional3 = Optional.of(param);
        Optional.absent();

        System.out.println(optional3.isPresent());
        System.out.println(optional3.get());
        System.out.println(optional3.asSet());
        System.out.println(optional3.or(10));
        System.out.println(optional3.orNull());
        System.out.println(optional3.toJavaUtil().get());

    }

    public static Integer test01(Optional<Integer> a, Optional<Integer> b){
        if (a.isPresent() && b.isPresent()){
            return a.get() + b.get();
        }
        return 0;
    }

    public static String test02(Optional<String> a, Optional<String> b){
        String param01 = "";
        String param02 = null;

        return a.get() + "--" + b.get();
    }

    public static Long test03(Optional<Long> a, Optional<Long> b){
        return a.get() + b.get();
    }

    public static List test04(Optional<List> a, Optional<List> b){
        System.out.println(JSONObject.toJSONString(a));
        System.out.println(JSONObject.toJSONString(b));
        return a.get();
    }

}