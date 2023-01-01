package communication;

import exceptions.SenderException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender{
    Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }

    public void send(Object object) throws SenderException{
        try {
            ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            out.writeObject(object);
            out.flush();
        } catch (IOException ex) {
            System.err.println("ERROR: Failed to handle output stream.\n" + ex.getMessage());
            throw new SenderException(ex.getMessage(), ex);
        }
   }
}
