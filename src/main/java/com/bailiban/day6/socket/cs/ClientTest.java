package com.bailiban.day6.socket.cs;

import java.io.IOException;
import java.net.Socket;

public class ClientTest {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8080);
        System.out.println("成功连接服务器。");
        new HttpClient(socket).start();
    }
}
