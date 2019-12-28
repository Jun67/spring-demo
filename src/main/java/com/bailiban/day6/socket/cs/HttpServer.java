package com.bailiban.day6.socket.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpServer extends Thread {

    private Socket socket;

    public HttpServer(Socket socket) {
        this.socket = socket;
    }

    private static Map<String, String> contentMap = new HashMap<>();

    static {
        contentMap.put("index", "Welcome!");
        contentMap.put("hello", "How are you?");
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            while (true) {
                String line = in.readLine();
                if (line == null || line.equals("bye")) {
                    break;
                }
                String content = contentMap.get(line.trim());
                out.println(content != null ? content : "404");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("客户端断开。" + this.getName());
        }
    }
}
