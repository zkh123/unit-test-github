package com.example.unit.test.github.threadTest.serverTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutorWebServer {

    private static final int NTHREADE = 100;
    private static final int PORT = 80;
    private static final Executor exec = Executors.newFixedThreadPool(TaskExecutorWebServer.NTHREADE);


    public static void main(String[] args) throws IOException {

    }

    private static void test03() throws IOException {
        ServerSocket serverSocket = new ServerSocket(TaskExecutorWebServer.PORT);
        while (true){
            final Socket connection = serverSocket.accept();
            exec.execute(() -> handlerRequest(connection));
        }
    }

    private static void test02() throws IOException {
        ServerSocket serverSocket = new ServerSocket(TaskExecutorWebServer.PORT);
        while (true){
            final Socket connection = serverSocket.accept();
            Runnable task = () -> handlerRequest(connection);
            exec.execute(task);
        }
    }

    private static void test01() throws IOException {
        ServerSocket serverSocket = new ServerSocket(TaskExecutorWebServer.PORT);
        while (true){
            final Socket connection = serverSocket.accept();
            /**
             * Runnable就是创建一个任务 Task
             */
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    handlerRequest(connection);
                }
            };
            /**
             * 用线程池去处理上面请求task
             */
            exec.execute(task);
        }
    }

    private static void handlerRequest(Socket connection) {
        //TODO
    }

}
