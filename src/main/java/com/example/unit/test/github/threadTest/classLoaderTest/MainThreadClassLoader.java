package com.example.unit.test.github.threadTest.classLoaderTest;

import java.util.ArrayList;
import java.util.List;

public class MainThreadClassLoader {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        // sun.misc.Launcher$AppClassLoader@18b4aac2

        List<String> list = new ArrayList<>();
        Object object = new Object();
                                                                                                   }

}
