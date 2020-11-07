package com.example.unit.test.github.guava;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * 字符串处理
 */
public class GuavaString {

    public static void main(String[] args) {
//        test01();
        test02();
    }


    /**
     * 连接器 Joiner
     * 可以去掉其中的 null
     */
    private static void test01(){
        String result = Joiner
                .on(",")  //连接符号是 ","
                .skipNulls() //如果有null 连接  直接将其忽略
                .join(Arrays.asList("a","",null,"b","","c"," ","d"));
        System.out.println("result=" +result); // result=a,,b,,c, ,d
    }

    /**
     * 拆分器
     */
    public static void test02(){
        Iterable<String> iterable = Splitter
                .on(",")  // 切割符号是 ","
                .trimResults() // 移除结果字符串的 前后空白
                .omitEmptyStrings() // 结果中有空字符串  就直接忽略
                .split("foo,bar,,               qux");

        for (String param:iterable){
            System.out.print(param); //foobarqux
        }
    }

    /**
     *
     */
    private static void test03(){
        String string = "";
        string.getBytes(Charsets.UTF_8);
    }

}
