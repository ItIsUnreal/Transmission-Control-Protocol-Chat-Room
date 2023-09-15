package org.rotariu.client;

import java.io.IOException;

public class ClientApp {

    public static void main(String[] args) throws IOException {
        ClientHandler client = new ClientHandler();
        client.run();
    }
}
