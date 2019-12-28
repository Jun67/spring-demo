package com.bailiban.day6.socket.chat.ui;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread {

    private String from;
    private JTextArea message;
    private BufferedReader bufferedReader;

    public ReceiveThread(String from, JTextArea message, Socket socket) {
        this.from = from;
        this.message = message;
        try {
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (!line.isEmpty())
                    message.append(String.format(" %s: %s\r\n", from, line));
            } catch (IOException e) {
//                e.printStackTrace();
                break;
            }
        }
    }
}
