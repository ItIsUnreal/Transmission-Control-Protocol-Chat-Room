package org.rotariu.client;

import java.io.IOException;

public class ClientApp {

    public static void main(String[] args) {
        ClientHandler client = null;
        try {
            client = new ClientHandler();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        client.run();
    }
}
