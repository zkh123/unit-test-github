package com.example.unit.test.github.threadTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListStreamTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java","Thread","Concurrency","Scala","Clojure");

//        Stream<String> stream = list.parallelStream();
        Stream<String> stream = list.stream();

        //操作过程
//        stream.map(String::toUpperCase).forEach(System.out::print);
        List<String> listNew = stream.map(String::toUpperCase).collect(Collectors.toList());
        listNew.forEach(System.out::print);  // JAVATHREADCONCURRENCYSCALACLOJURE

        System.out.println();
        System.out.println("--------------------");

        //操作之前的值
        list.forEach(System.out::print);  // JavaThreadConcurrencyScalaClojure
    }

}
