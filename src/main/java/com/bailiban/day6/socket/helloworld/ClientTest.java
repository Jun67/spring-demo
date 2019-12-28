package com.bailiban.day6.socket.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTest {

    public static void main(String[] args) throws IOException {

        // 新建客户端连接
        Socket socket = new Socket("localhost", 8080);
        System.out.println("成功连接服务器。");
        try (BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            // 向服务器端发送信息
            String line = sin.readLine();
            out.println(line);
            out.flush();
            // 获取服务器端信息
            System.out.println("Server：" + in.readLine());
        }
    }
}
