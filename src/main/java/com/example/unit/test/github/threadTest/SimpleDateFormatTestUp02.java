package com.example.unit.test.github.threadTest;

import com.example.unit.test.github.config.InitThreadPool;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleDateFormatTestUp02 {

    private static DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");



    public  void test(){
        int i = 1;
        while (i<500){
            InitThreadPool.getThreadPool().execute(()->{
                /**
                 * LocalDateTime  线程不安全
                 * ZonedDateTime  线程安全
                 */
//                LocalDateTime localDateTime = LocalDateTime.now();
                ZonedDateTime zonedDateTime = ZonedDateTime.now();
                String dateString = zonedDateTime.format(dateTimeFormatter);

                try {
                    ZonedDateTime parseDate = zonedDateTime.parse(dateString,dateTimeFormatter);
                    String dateString2 = dateTimeFormatter.format(parseDate);
                    System.out.println(dateString.equals(dateString2));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
            i++;
        }
    }

    public static void main(String[] args) {
        new SimpleDateFormatTest().test();
    }
}
