package communication;

import exceptions.ReceiverException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver {
    Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
    public Object receive() throws ReceiverException {
        try {
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            return in.readObject();
        } catch (IOException ex) {
            System.err.println("ERROR: Failed to handle input stream.\n" + ex.getMessage());
            throw new ReceiverException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR: Failed to find class.\n" + ex.getException());
            throw new ReceiverException(ex.getMessage(), ex);
        }
    }
}
