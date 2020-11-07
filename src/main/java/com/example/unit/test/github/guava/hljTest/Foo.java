package com.example.unit.test.github.guava.hljTest;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

public class Foo {
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
            new Color("yellow","yellow","yellow"));

    public static void main(String[] args) {
        System.out.println(Foo.COLOR_NAMES.toString());
        ImmutableSet<String> copyOf = ImmutableSet.copyOf(Foo.COLOR_NAMES);
        System.out.println(copyOf.toString());

        ImmutableMap<String,Object> map = ImmutableMap.of("key1",123,"key2","1234565");
        System.out.println(map.toString());


        ImmutableSet<Color> GOOGLE_COLORS_02 = ImmutableSet.<Color>builder()
                .addAll(Foo.COLOR_NAMES_01)
                .add(new Color("aa","bb","cc"))
                .build();

        System.out.println(GOOGLE_COLORS_02.toString());

    }

}
