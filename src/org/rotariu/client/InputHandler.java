package org.rotariu.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class InputHandler implements Runnable {

    private Client client;

    public InputHandler(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader inReader = new BufferedReader(new InputStreamReader((System.in)));
            PrintWriter printer = client.getPrinter();
            while (true) {
                String message = inReader.readLine();
                if (message.equals("/quit")) {
                    printer.println(message);
                    inReader.close();
                    client.setActive(false);
                    break;
                } else {
                    printer.println(message);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
