package com.example.unit.test.github.threadTest.serverTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadPreWebServer {

    private static final int PORT = 80;

    /**
     * 每个请求 开启一个线程来处理
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(ThreadPreWebServer.PORT);
        while (true){
            Socket connection = serverSocket.accept();
            Runnable task = new Runnable(){
                @Override
                public void run() {
                    handlerRequest(connection);
                }
            };
            new Thread(task).start();
        }
    }

    private static void handlerRequest(Socket connection) {
        //TODO
    }

}
