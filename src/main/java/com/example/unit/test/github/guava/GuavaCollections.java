package com.example.unit.test.github.guava;

import com.example.unit.test.github.guava.hljTest.Color;
import com.example.unit.test.github.guava.hljTest.TypeThatsTooLongForItsOwnGood;
import com.google.common.collect.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 集合
 */
public class GuavaCollections {
    public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
            "red",
            "orange",
            "yellow",
            "green",
            "blue",
            "purple",
            "red");

    public static final ImmutableSet<Color> COLOR_NAMES_01 = ImmutableSet.of(
            new Color("red","red","red"),
            new Color("orange","orange","orange"),
            new Color("yellow","yellow","yellow")
    );

    public static void main(String[] args) {
//        test01();
//        test02();
        test03();
    }

    private static void test03(){
        List<TypeThatsTooLongForItsOwnGood> list01 = new ArrayList<TypeThatsTooLongForItsOwnGood>();
        Map<String,TypeThatsTooLongForItsOwnGood> map01 = new HashMap<String,TypeThatsTooLongForItsOwnGood>();

        List<TypeThatsTooLongForItsOwnGood> list02 = Lists.newArrayList();
        List<String> list03 = Lists.newArrayList("aa","bb","cc");
        Map<String,TypeThatsTooLongForItsOwnGood> map02 = Maps.newLinkedHashMap();
    }

    /**
     * 统计一个字典中  每个单词出现的次数
     */
    private static void test02(){
        String[] dictionary = new String[]{"a","ab","c","d","e","ff","aa","ab","c","kk","kkk","d","d","mm"};
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (String temp:dictionary) {
            Integer value = map.get(temp);
            if (null == value){
                map.put(temp,1);
            }else {
                map.put(temp,++value);
            }
        }
        System.out.println(map.toString());
    }

    private static void test01(){
        System.out.println(GuavaCollections.COLOR_NAMES.toString());
        ImmutableSet<String> copyOf = ImmutableSet.copyOf(GuavaCollections.COLOR_NAMES);
        System.out.println(copyOf.toString());

        ImmutableMap<String,Object> map = ImmutableMap.of("key1",123,"key2","1234565");
        System.out.println(map.toString());


        ImmutableSet<Color> GOOGLE_COLORS_02 = ImmutableSet.<Color>builder()
                .addAll(GuavaCollections.COLOR_NAMES_01)
                .add(new Color("aa","bb","cc"))
                .build();

        System.out.println(GOOGLE_COLORS_02.toString());
    }
}
