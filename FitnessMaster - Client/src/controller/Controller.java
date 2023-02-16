package controller;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import communication.Sender;
import domain.BodyPart;
import domain.Category;
import domain.Exercise;
import domain.Gender;
import domain.GenericEntity;
import domain.Member;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JOptionPane;

public class Controller {
    private Socket socket;
    private static Controller instance;
    
    private Controller(Socket socket) {
        this.socket = socket;
    }
    public static Controller getInstance(Socket socket) {
        if (instance == null) {
            instance = new Controller(socket);
        }
        return instance;
    }

    private Response sendRequest(Operation operation, Object parameter) throws Exception {
        Request request = new Request(operation, parameter);

        new Sender(socket).send(request);
        Response response = (Response) new Receiver(socket).receive();

        return response;
    }

    // --- MEMBER ---
    public Response saveMember(HashMap memberData) throws Exception {
        Member m = buildMember(memberData);
        return sendRequest(Operation.ADD_MEMBER, m);
    }
    public Response updateMember(HashMap memberData) throws Exception {
        Member m = buildMember(memberData);
        return sendRequest(Operation.UPDATE_MEMBER, m);
    }
    public Response deleteMember(Member member) throws Exception {
        return sendRequest(Operation.DELETE_MEMBER, member);
    }
    public Response getMembers() throws Exception {
        return sendRequest(Operation.GET_MEMBERS, null);
    }
    // ------------------
    
    // --- EXERCISE ---
    public Response saveExercise(HashMap exerciseData) throws Exception {
        Exercise e = new Exercise();

        e.setName((String) exerciseData.get("name"));
        e.setCategory((Category) exerciseData.get("category"));
        e.setBodyPart((BodyPart) exerciseData.get("bodyPart"));

        return sendRequest(Operation.ADD_EXERCISE, e);
    }
    public Response updateExercise(HashMap exerciseData) throws Exception{
        Exercise e = new Exercise();
        
        e.setId(Integer.parseInt((String) exerciseData.get("id")));
        e.setName((String) exerciseData.get("name"));
        e.setCategory((Category) exerciseData.get("category"));
        e.setBodyPart((BodyPart) exerciseData.get("bodyPart"));
        
        return sendRequest(Operation.UPDATE_EXERCISE, e);
    }
    public Response deleteExercise(Exercise exercise) throws Exception {
        return sendRequest(Operation.DELETE_EXERCISE, exercise);
    }
    public Response getExercises() throws Exception {
        return sendRequest(Operation.GET_EXERCISES, null);
    }
    // ------------------
    
    private Member buildMember(HashMap memberData){
        Member m = new Member();
      
        System.out.println(memberData.get("id"));
        if(memberData.get("id") != null){
            m.setMemberID(Integer.parseInt(memberData.get("id").toString()));
        }
        
        m.setFirstName((String) memberData.get("firstName"));
        m.setLastName((String) memberData.get("lastName"));

        Gender genderData = (Gender) memberData.get("gender");
        Gender gender = genderData != null ?  genderData : null;
        m.setGender(gender);

        String addressData = (String) memberData.get("address");
        String address = addressData != null ? addressData : null;
        m.setAddress(address);
        
        String phoneNumberData = (String) memberData.get("phoneNumber");
        String phoneNumber;
        if (phoneNumberData.matches("___/__-__-___")) { // TODO: Postoji li bolji nacin da se vidi da li je korisnik ostavio prazno
            phoneNumber = phoneNumberData;
        } else {
            phoneNumber = null;
        }
        m.setPhoneNumber(phoneNumber);
        
        String birthDateData = (String) memberData.get("dateOfBirth");
        LocalDate birthDate;
        if (birthDateData != null && !birthDateData.isBlank()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
            birthDate = LocalDate.parse(birthDateData, formatter);
        } else {
            birthDate = null;
        }
        m.setDateOfBirth(birthDate);
        
        return m;
    }
}
