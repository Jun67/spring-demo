package com.bailiban.day6.socket.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("开启服务器，等待客户端连接...");
        Socket socket = serverSocket.accept();
        System.out.println("客户端已连接。");
        // read
        new ReceiveThread("Client", socket).start();
        // write
        new SendThread("Server", socket).start();
    }
}
