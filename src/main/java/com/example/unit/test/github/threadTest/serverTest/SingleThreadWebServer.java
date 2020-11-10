package com.example.unit.test.github.threadTest.serverTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadWebServer {

    private static final int PORT = 80;

    /**
     * 单线程
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SingleThreadWebServer.PORT);
        while (true){
            Socket connection = serverSocket.accept();
            handlerRequest(connection);
        }
    }

    private static void handlerRequest(Socket connection) {
        //TODO
    }

}
