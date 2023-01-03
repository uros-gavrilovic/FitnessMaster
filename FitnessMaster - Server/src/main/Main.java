package main;

import domain.BodyPart;
import domain.Category;
import domain.Exercise;
import gui.ServerForm;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repo.db.DatabaseRepository;
import repo.db.impl.DbRepositoryExercise;
import server.Server;

public class Main {
    public static void main(String[] args) throws Exception {
//        try {
//            Server server = new Server();
//            server.startServer();
//        } catch (IOException ex) {
//            System.err.println("ERROR: Failed to start server!");
//        }


          new ServerForm().setVisible(true);
    }
}
