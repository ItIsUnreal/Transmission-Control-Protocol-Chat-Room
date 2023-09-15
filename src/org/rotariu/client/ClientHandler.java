package org.rotariu.client;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientHandler implements Runnable {

    private final Client client;

    public ClientHandler() throws IOException {
        this.client = new Client();
    }

    public ClientHandler(String host, int port) throws IOException {
        this.client = new Client(host, port);
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = client.getReader();

            InputHandler inHandler = new InputHandler(client);
            Thread t = new Thread(inHandler);
            t.start();

            String inMessage;
            while ((inMessage = reader.readLine()) != null && client.isActive()) {
                System.out.println(inMessage);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            shutdown();
        }
    }

    public void shutdown() {
        if (!client.isClosed()) {
            client.close();
        }
    }
}
