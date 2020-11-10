package com.example.unit.test.github.threadTest;

import com.example.unit.test.github.config.InitThreadPool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat 线程不安全类
 */
public class SimpleDateFormatTest {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public  void test(){
        while (true){
            InitThreadPool.getThreadPool().execute(()->{
                String dateString = simpleDateFormat.format(new Date());

                try {
                    Date parseDate = simpleDateFormat.parse(dateString);
                    String dateString2 = simpleDateFormat.format(parseDate);
                    System.out.println(dateString.equals(dateString2));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            });
        }
    }

    public static void main(String[] args) {
        new SimpleDateFormatTest().test();
    }

    /**
     * true
     * false
     * true
     * true
     * true
     * true
     * true
     * true
     * true
     * false
     * true
     * true
     * true
     */
}
