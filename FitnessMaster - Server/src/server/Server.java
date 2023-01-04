package server;

import domain.Trainer;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;
import thread.ClientHandler;

public class Server {
     boolean alive;
     ServerSocket serverSocket;
     Socket socket;
     ArrayList<ClientHandler> activeClients;

     public Server() {
          this.alive = false;
          activeClients = new ArrayList<>();
     }

     public boolean isAlive() {
          return alive;
     }
     public void setAlive(boolean alive) {
          this.alive = alive;
     }
     public ServerSocket getServerSocket() {
          return serverSocket;
     }
     public void setServerSocket(ServerSocket serverSocket) {
          this.serverSocket = serverSocket;
     }
     public Socket getSocket() {
          return socket;
     }
     public void setSocket(Socket socket) {
          this.socket = socket;
     }

     public void startServer() throws IOException {
          Properties serverProperties = new Properties();
          serverProperties.load(new FileInputStream("config/serverConfig.properties"));

          String serverPort = serverProperties.getProperty("port");
          
          System.out.println("SERVER: Starting server on port " + serverPort + "...");
          serverSocket = new ServerSocket(Integer.valueOf(serverPort));
          alive = true;

//          while (true) {
               System.out.println("SERVER: Waiting for a client...");
               socket = serverSocket.accept();
               System.out.println("SERVER: Client connected!");

               handleClient(socket);
//          }

     }
     public void stopServer() throws IOException {
          System.out.println("SERVER: Stopping server...");
          socket.close();
          serverSocket.close();
     }
     private void handleClient(Socket socket) {
          ClientHandler clientHandler = new ClientHandler(socket);
          clientHandler.start();
     }
}
