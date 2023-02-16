package thread;

import communication.*;
import controller.Controller;
import domain.Exercise;
import domain.Member;
import domain.Trainer;
import exceptions.ReceiverException;
import exceptions.SenderException;
import exceptions.UnknownOperationException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler extends Thread {
    Socket socket;
    Trainer client;
 
    Request request;
    Response response;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        
        this.request = new Request();
        this.response = new Response();
    }

    @Override
    public void run() {
        while (true) {
            try {
                request = (Request) new Receiver(socket).receive();
                System.err.println("aaaaa" + request); 

                if (request != null) {
                    switch (request.getOperation()) {
                        case LOG_IN:
                            logIn();
                            break;                          
                        case DISCONNECT:
                            disconnect();
                            return;
                            
                        case ADD_MEMBER:
                            addMember();
                            break;  
                        case UPDATE_MEMBER:
                            updateMember();
                            break;
                        case DELETE_MEMBER:
                            deleteMember();
                            break;
                        case GET_MEMBERS:
                            getMembers();
                            break;
                            
                        case ADD_EXERCISE:
                            addExercise();
                            break;     
                        case UPDATE_EXERCISE:
                            updateExercise();
                            break;
                        case DELETE_EXERCISE:
                            deleteExercise();
                            break;                                
                        case GET_EXERCISES:
                            getExercises();
                            break;
                            
                        default:
                            String errorMessage = "ERROR: Unknown operation requested.";
                            response.setResponseType(ResponseType.ERROR);
                            response.setException(new UnknownOperationException(errorMessage));
                    }
                    
                    try {
                        new Sender(socket).send(response);
                    } catch (SenderException ex) {
                        System.out.println("ERROR: Failed to send response.");
                    }
                }
            } catch (ReceiverException ex) {
                System.out.println("ERROR: Failed to receive request.");
            }
        }
    }

    private void getExercises() {
        try {
            ArrayList<Exercise> exercises = Controller.getInstance().getExercises();
            response.setResult(exercises);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
    }
    private void getMembers() {
        try {
            ArrayList<Member> members = Controller.getInstance().getMembers();
            response.setResult(members);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
    }
    private void updateExercise() {
        try {
            Exercise exercise = (Exercise) request.getArgument();
            Controller.getInstance().updateExercise(exercise);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
    }
    private void deleteExercise() {
        try {
            Exercise exercise = (Exercise) request.getArgument();
            Controller.getInstance().deleteExercise(exercise);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
    }
    private void addExercise() {
        try {
            Exercise exercise = (Exercise) request.getArgument();
            Controller.getInstance().addExercise(exercise);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
    }
    private void addMember() {
        try {
            Member member = ((Member) request.getArgument());
            Controller.getInstance().addMember(member);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
    }
    private void updateMember() {
        try {
            Member member = ((Member) request.getArgument());
            Controller.getInstance().updateMember(member);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
    }
    private void deleteMember() {
        try {
            Member member = ((Member) request.getArgument());
            Controller.getInstance().deleteMember(member);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
    }
    private void disconnect() {
        try {
            Controller.getInstance().logout();
            System.out.println("SERVER: Client disconnected!");
            return;
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
    }
    private void logIn() {
        try {
            String username = ((Trainer) request.getArgument()).getUsername();
            String password = ((Trainer) request.getArgument()).getPassword();
            
            Trainer trainer = Controller.getInstance().login(username, password);
            this.client = trainer;
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(trainer);
        } catch (Exception ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
    }

     public Socket getSocket() {
          return socket;
     }
     public void setSocket(Socket socket) {
          this.socket = socket;
     }
     public Trainer getClient() {
          return client;
     }
     public void setClient(Trainer client) {
          this.client = client;
     } 
}
