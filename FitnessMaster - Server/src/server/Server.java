package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import thread.ClientHandler;

public class Server {
    public void startServer() throws IOException {
        System.out.println("SERVER: Starting server...");
        ServerSocket serverSocket = new ServerSocket(9000);
        while(true){
            System.out.println("SERVER: Waiting for a client...");
            Socket socket = serverSocket.accept();
            System.out.println("SERVER: Client connected!");

            handleClient(socket);
        }

    }
    private void handleClient(Socket socket) {
        ClientHandler clientHandler = new ClientHandler(socket);
        clientHandler.start();
    }
}