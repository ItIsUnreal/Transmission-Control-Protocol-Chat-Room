package org.rotariu.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private final String host;
    private final int port;

    private BufferedReader reader;
    private PrintWriter printer;

    private final Socket socket;
    private boolean isActive;

    public Client(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        this.socket = new Socket(host, port);
        printer = new PrintWriter(socket.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        isActive = true;
    }

    public Client() throws IOException {
        this("127.0.01", 9989);
    }

    public BufferedReader getReader() {
        return reader;
    }

    public PrintWriter getPrinter() {
        return printer;
    }

    public boolean isClosed() {
        return socket.isClosed();
    }

    public void close() {
        try {
            reader.close();
            printer.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
