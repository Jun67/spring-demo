package com.bailiban.day6.socket.chat.ui;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class InputKeyAdapter extends KeyAdapter {

    private JTextArea input;
    private JTextArea message;
    private PrintWriter out;

    public InputKeyAdapter(JTextArea input, JTextArea message, Socket socket) {
        this.input = input;
        this.message = message;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        if (e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            String inputMsg = input.getText();
            if (!inputMsg.isEmpty()) {
                message.append(" 我: " + inputMsg);
                out.println(inputMsg);
            }
            input.setText("");
        }
    }
}
