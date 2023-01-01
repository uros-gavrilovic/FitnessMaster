package client;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public Socket connect() {
        try {
            Socket socket = new Socket("127.0.0.1", 9000);
            System.out.println("Connected to the server [" + socket.getInetAddress() + ":" + socket.getPort() + "].");
            return socket;
        } catch (IOException ex) {
            System.err.println("ERROR: Unable to connect to the server!");
            return null;
        }
    }
}
