package com.example.unit.test.github.threadTest;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class CollectionsTest {

    /**
     * getLast,deleteLast 在多线程情况下  Vector是线程安全的 但是可能出现Vector删除了末尾原始 Vector又被读取原来末尾原始
     * 导致出现角标越界的异常
     * @param vector
     * @return
     */
    private Object getLast(Vector vector){
        int lastIndex = vector.size() - 1;
        return vector.get(lastIndex);
    }

    private void deleteLast(Vector vector){
        int lastIndex = vector.size() -1;
        vector.remove(lastIndex);
    }

    private void test(){
        /**
         * Collections.emptyList()
         * Collections.emptySet()
         * Collections.emptyMap()
         * 不可变的集合
         * 不能put()  add()操作  只能进行赋值操作
         */
        List<String> list = Collections.emptyList();
        Set set = Collections.emptySet();
        Map<String,Object> map = Collections.emptyMap();

        Map<String,Object> temp = new HashMap<>();
        temp.put("key1","value1");
        temp.put("key2","value2");

        map = temp;

        System.out.println(JSONObject.toJSONString(map));

    }

    public static void main(String[] args) {
        new CollectionsTest().test();
    }
}
