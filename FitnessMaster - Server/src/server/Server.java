package server;

import domain.Trainer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.CustomConsoleStream;
import thread.ClientHandler;

public class Server extends Thread{
     ServerSocket serverSocket;
     Socket socket;
     ArrayList<ClientHandler> activeClients;

     public Server() throws FileNotFoundException, IOException {
          CustomConsoleStream ccs = new CustomConsoleStream();
          
          Properties serverProperties = new Properties();
          serverProperties.load(new FileInputStream("config/serverConfig.properties"));
          String serverPort = serverProperties.getProperty("port");

          System.out.println("SERVER: Starting server on port " + serverPort + "...");
          serverSocket = new ServerSocket(Integer.valueOf(serverPort));
          
          activeClients = new ArrayList<>();
     }

     @Override
     public void run() {
          while (!serverSocket.isClosed()) {
               try {
                    System.out.println("SERVER: Waiting for a client...");
                    socket = serverSocket.accept();
                    System.out.println("SERVER: Client connected!");
                    handleClient(socket);
               } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
               }
          }
          
          try {
               stopServer();
          } catch (IOException ex) {
               Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
          }
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

     public void stopServer() throws IOException {
          System.out.println("SERVER: Stopping server...");

          for (ClientHandler ch : activeClients) {
               try {
                    ch.getSocket().close();
                    activeClients.remove(ch);
               } catch (IOException ex) {
                    ex.printStackTrace();
               }
          }
          
          //serverSocket.close();
     }
     private void handleClient(Socket socket) {
          ClientHandler clientHandler = new ClientHandler(socket);
          activeClients.add(clientHandler);
          clientHandler.start();
     }
}
