package com.example.unit.test.github.threadTest;

import java.util.HashMap;
import java.util.Map;

public class DieTest {

    Map<String,String> map = new HashMap<String,String>();

    public void add(String key, String value){
        this.map.put(key,value);
    }

    public static void main(String[] args) {
        DieTest dieTest = new DieTest();

        for (int i = 0 ; i < 10 ; i++){
            new Thread(){
                @Override
                public void run() {
                    for (int k = 0 ; k < Integer.MAX_VALUE; k++){
                        dieTest.add(String.valueOf(k),String.valueOf(k));
                    }
                }
            }.start();
        }

    }

}
