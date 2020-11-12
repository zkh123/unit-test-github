package com.example.unit.test.github;

public class HljTest {
    public static void main(String[] args) {
        String startVersion = "3.2.0";

        String appVersion = "3.1.9";
        if(appVersion.compareToIgnoreCase(startVersion)>=0){
            System.out.println(false);
        }else {
            System.out.println(true);
        }

    }
}
