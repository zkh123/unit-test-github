package com.example.unit.test.github.threadTest;

import com.example.unit.test.github.config.InitThreadPool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTestUp01 {


    /**
     * ThreadLocal副本
     */
    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };


    public  void test(){
        int i = 1;
        while (i < 500){
            InitThreadPool.getThreadPool().execute(()->{
                String dateString = threadLocal.get().format(new Date());

                try {
                    Date parseDate = threadLocal.get().parse(dateString);
                    String dateString2 = threadLocal.get().format(parseDate);
                    System.out.println(dateString.equals(dateString2));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            });
            i++;
        }
    }

    public static void main(String[] args) {
        new SimpleDateFormatTestUp01().test();
    }

}
