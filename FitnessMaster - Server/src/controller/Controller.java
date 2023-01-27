package controller;

import domain.Exercise;
import domain.GenericEntity;
import domain.Member;
import domain.Trainer;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import operation.member.*;
import operation.exercise.*;
import operation.trainer.*;
import repo.Repository;
import repo.db.*;
import repo.db.impl.DbRepositoryGeneric;

public class Controller {

    static Controller controller;

    final Repository repoExercise;
    final Repository repoMember;
    final Repository repoMembership;
    final Repository repoPackage;
    final Repository repoTrainer;
    final Repository repoActivity;
    final Repository repoPlan;

    public Controller() {
        this.repoExercise = new DbRepositoryGeneric();
        this.repoMember = new DbRepositoryGeneric();
        this.repoMembership = new DbRepositoryGeneric();
        this.repoPackage = new DbRepositoryGeneric();
        this.repoTrainer = new DbRepositoryGeneric();
        this.repoActivity = new DbRepositoryGeneric();
        this.repoPlan = new DbRepositoryGeneric();
    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public void addMember(Member member) throws Exception {
        AbstractGenericOperation operation = new InsertMember();
        operation.execute(member);        
    }
    public void addExercise(Exercise exercise) throws Exception {
        AbstractGenericOperation operation = new InsertExercise();
        operation.execute(exercise);
    }
    public void addTrainer(Trainer trainer) throws Exception {
        AbstractGenericOperation operation = new InsertTrainer();
        operation.execute(trainer);
    }

    public void deleteMember(Member member) throws Exception {
        AbstractGenericOperation operation = new DeleteMember();
        operation.execute(member);
    }
    public void deleteExercise(Exercise exercise) throws Exception {
         AbstractGenericOperation operation = new DeleteExercise();
         operation.execute(exercise);
    }
    public void deleteTrainer(Trainer trainer) throws Exception {
        AbstractGenericOperation operation = new DeleteTrainer();
        operation.execute(trainer);
    }
        
    public void updateMember(Member member) throws Exception {
         AbstractGenericOperation operation = new UpdateMember();
         operation.execute(member);            
    }
    public void updateExercise(Exercise exercise) throws Exception {
         AbstractGenericOperation operation = new UpdateExercise();
         operation.execute(exercise);
    }
    public void updateTrainer(Trainer trainer) throws Exception {
        AbstractGenericOperation operation = new UpdateTrainer();
        operation.execute(trainer);
    }
    
    public ArrayList<Member> getMembers() throws Exception {
         AbstractGenericOperation operation = new GetAllMembers();
         operation.execute((GenericEntity) new Member());
         return ((GetAllMembers)operation).getMembers();
    }
    public ArrayList<Exercise> getExercises() throws Exception {
         AbstractGenericOperation operation = new GetAllMembers();
         operation.execute((GenericEntity) new Exercise());
         return ((GetAllExercises)operation).getExercises();
    }
    public ArrayList<Trainer> getTrainers() throws Exception {
        AbstractGenericOperation operation = new GetAllTrainers();
        operation.execute((GenericEntity) new Trainer());
        return ((GetAllTrainers) operation).getTrainers();
    }

    public Trainer login(String username, String password) throws Exception {
        ArrayList<Trainer> trainers = getTrainers();
        
        for (Trainer t : trainers) {
            System.err.println("Comparing username " + t.getUsername() + " typed " + username + " \n Comparing password " + t.getPassword() + " to typed: " + password);
            if (t.getUsername().matches(username) && t.getPassword().matches(password)) {
                return t;
            }
        }

        throw new Exception();
    }
    public void logout() throws Exception {
        try {
            ((DatabaseRepository) repoMember).disconnect();
            ((DatabaseRepository) repoMembership).disconnect();
            ((DatabaseRepository) repoPackage).disconnect();
            ((DatabaseRepository) repoTrainer).disconnect();
            ((DatabaseRepository) repoActivity).disconnect();
            ((DatabaseRepository) repoPlan).disconnect();
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
