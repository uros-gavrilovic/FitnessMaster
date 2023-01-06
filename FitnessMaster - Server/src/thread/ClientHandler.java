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
                System.out.println(request); 
                
                response = new Response();
                
                if (request != null) {
                    switch (request.getOperation()) {
                        case LOG_IN:
                            try {
                                String username = ((Trainer) request.getArgument()).getUsername();
                                String password = ((Trainer) request.getArgument()).getPassword();

                                Trainer trainer = Controller.getInstance().login(username, password);
                                response.setResponseType(ResponseType.SUCCESS);
                                response.setResult(trainer);
                            } catch (Exception ex) {
                                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                                response.setResponseType(ResponseType.ERROR);
                                response.setException(ex);
                            }
                            break;
                            
                        case DISCONNECT:
                            try{
                                Controller.getInstance().logout();
                                System.out.println("SERVER: Client disconnected!");
                                return;
                            } catch (Exception ex){
                                response.setResponseType(ResponseType.ERROR);
                                response.setException(ex);
                            }
                            break;
                            
                        case ADD_MEMBER:
                            try{
                                Member member = ((Member) request.getArgument());
                                
                                Controller.getInstance().addMember(member);
                                response.setResponseType(ResponseType.SUCCESS);
                            } catch (Exception ex) {
                                response.setResponseType(ResponseType.ERROR);
                                response.setException(ex);
                            }
                            break;
                            
                        case ADD_EXERCISE:
                            try{
                               Exercise exercise = (Exercise) request.getArgument();
                               
                               Controller.getInstance().addExercise(exercise);
                               response.setResponseType(ResponseType.SUCCESS);
                            } catch (Exception ex) {
                                response.setResponseType(ResponseType.ERROR);
                                response.setException(ex);
                            }
                            break;
                            
                        case DELETE_EXERCISE:
                            try{
                               Exercise exercise = (Exercise) request.getArgument();
                               
                               Controller.getInstance().deleteExercise(exercise);
                               response.setResponseType(ResponseType.SUCCESS);
                            } catch (Exception ex) {
                                response.setResponseType(ResponseType.ERROR);
                                response.setException(ex);
                            }                            
                            break;
                            
                        case UPDATE_EXERCISE:
                             try{
                               Exercise exercise = (Exercise) request.getArgument();
                               
                               Controller.getInstance().updateExercise(exercise);
                               response.setResponseType(ResponseType.SUCCESS);
                            } catch (Exception ex) {
                                response.setResponseType(ResponseType.ERROR);
                                response.setException(ex);
                            }                           
                            break;
                            
                        case GET_MEMBERS:
                                try{
                                    ArrayList<Member> members = Controller.getInstance().getMembers();
                                    response.setResult(members);
                                    response.setResponseType(ResponseType.SUCCESS);
                                } catch (Exception ex) {
                                    response.setResponseType(ResponseType.ERROR);
                                    response.setException(ex);
                                }
                                break;
                                
                        case GET_EXERCISES:
                            try{
                                ArrayList<Exercise> exercises = Controller.getInstance().getExercises();
                                response.setResult(exercises);
                                response.setResponseType(ResponseType.SUCCESS);
                            } catch (Exception ex) {
                                response.setResponseType(ResponseType.ERROR);
                                response.setException(ex);
                            }
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

     public Socket getSocket() {
          return socket;
     }
     public void setSocket(Socket socket) {
          this.socket = socket;
     }
     public Request getRequest() {
          return request;
     }
     public void setRequest(Request request) {
          this.request = request;
     }
     public Response getResponse() {
          return response;
     }
     public void setResponse(Response response) {
          this.response = response;
     }
}
