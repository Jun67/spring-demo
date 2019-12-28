package com.bailiban.day6.socket.chat.ui;

import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

public class QQClient {
    private JPanel Client;
    private JTextArea message;
    private JTextArea input;

    public QQClient() throws IOException {
        Socket socket = new Socket("localhost", 8080);
        input.addKeyListener(new InputKeyAdapter(input, message, socket));
        new ReceiveThread("Server", message, socket).start();
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("QQClient");
        frame.setContentPane(new QQClient().Client);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
