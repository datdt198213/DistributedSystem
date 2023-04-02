package com.hust.soict.dangdat.client_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket listener;
    private Socket client;

    public void start(int port) {
        try {
            listener = new ServerSocket(port);
            int clientNumber = 0;
            while (true) {
                client = listener.accept();
                new Sorter(client, clientNumber++).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        try {
            client.close();
            listener.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("The Sorter Server is running!");
        Server server = new Server();
        server.start(6666);
        server.stop();
    }
}
