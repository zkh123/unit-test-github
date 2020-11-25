package com.example.unit.test.github;

public class HljTest {
    public static void main(String[] args) {
        test01();
        test02();
    }

    private static void test01(){
        System.out.println("HljStep01 我搞点事情！");
        String startVersion = "3.2.0";
        String appVersion = "3.1.9";
        if(appVersion.compareToIgnoreCase(startVersion)>=0){
            System.out.println(false);
        }else {
            System.out.println(true);
        }
    }

    private static void test02(){
        System.out.println("HljStep01 我搞点事情！");
        String startVersion = "3.2.0";
        String appVersion = "3.1.9";
        if(appVersion.compareToIgnoreCase(startVersion)>=0){
            System.out.println(false);
        }else {
            System.out.println(true);
        }
    }

}
