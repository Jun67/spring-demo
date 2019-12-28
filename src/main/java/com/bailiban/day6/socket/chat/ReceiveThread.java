package com.bailiban.day6.socket.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread {

    private String fromName;
    private Socket socket;

    public ReceiveThread(String fromName, Socket socket) {
        this.fromName = fromName;
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
            while (true) {
                String line = in.readLine();
                if (line == null || line.equals("bye"))
                    break;
                System.out.println(fromName + " > " + line);
            }
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
}
