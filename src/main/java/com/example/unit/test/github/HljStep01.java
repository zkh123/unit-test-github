package com.example.unit.test.github;

public class HljStep01 {
    public static void main(String[] args) {
        test01();
    }

    private static void test01(){
        String base = "Hello World!";
        String step01 = "step01";
        String result = base + step01;
        System.out.println("*********************");
        System.out.println("result: " + result);
    }
}
