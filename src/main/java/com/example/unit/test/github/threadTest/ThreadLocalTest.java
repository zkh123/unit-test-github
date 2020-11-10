package com.example.unit.test.github.threadTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ThreadLocalTest {

    private static final String DB_URL = "";

    private static ThreadLocal<Connection> connectionHolder
            = new ThreadLocal<Connection>(){
        @Override
        protected Connection initialValue() {
            try {
                return DriverManager.getConnection(ThreadLocalTest.DB_URL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    };


    public static Connection getConnection(){
        return connectionHolder.get();
    }



}
