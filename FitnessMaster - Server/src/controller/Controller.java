package controller;

import domain.Exercise;
import domain.Member;
import domain.Trainer;
import java.util.ArrayList;
import repo.Repository;
import repo.db.*;
import repo.db.impl.DbRepositoryExercise;
import repo.db.impl.DbRepositoryMember;
import repo.db.impl.DbRepositoryMembership;
import repo.db.impl.DbRepositoryPackage;
import repo.db.impl.DbRepositoryTrainer;
import repo.db.impl.DbRepositoryWorkoutActivity;
import repo.db.impl.DbRepositoryWorkoutPlan;

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
        this.repoExercise = new DbRepositoryExercise();
        this.repoMember = new DbRepositoryMember();
        this.repoMembership = new DbRepositoryMembership();
        this.repoPackage = new DbRepositoryPackage();
        this.repoTrainer = new DbRepositoryTrainer();
        this.repoActivity = new DbRepositoryWorkoutActivity();
        this.repoPlan = new DbRepositoryWorkoutPlan();
    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public void addMember(Member member) throws Exception {
        ((DatabaseRepository) repoMember).connect();
        try {
            repoMember.insert(member);
            ((DatabaseRepository) repoMember).commit();
        } catch (Exception ex) {
            ((DatabaseRepository) repoMember).rollback();
        } finally {
            ((DatabaseRepository) repoMember).disconnect();
        }
    }
    public void addExercise(Exercise exercise) throws Exception {
        ((DatabaseRepository) repoExercise).connect();
        try {
            repoExercise.insert(exercise);
            ((DatabaseRepository) repoExercise).commit();
        } catch (Exception ex) {
            ((DatabaseRepository) repoExercise).rollback();
        } finally {
            ((DatabaseRepository) repoExercise).disconnect();
        }
    }

    public void deleteMember(Member member) throws Exception {
        ((DatabaseRepository) repoMember).connect();
        try {
            repoMember.delete(member);
            ((DatabaseRepository) repoMember).commit();
        } catch (Exception ex) {
            ((DatabaseRepository) repoMember).rollback();
        } finally {
            ((DatabaseRepository) repoMember).disconnect();
        }
    }
    public void deleteExercise(Exercise exercise) throws Exception {
        ((DatabaseRepository) repoExercise).connect();
        try {
            repoExercise.delete(exercise);
            ((DatabaseRepository) repoExercise).commit();
        } catch (Exception ex) {
            ((DatabaseRepository) repoExercise).rollback();
        } finally {
            ((DatabaseRepository) repoExercise).disconnect();
        }
    }
    
    public void updateMember(Member member) throws Exception {
        ((DatabaseRepository) repoMember).connect();
        try {
            repoMember.update(member);
            ((DatabaseRepository) repoMember).commit();
        } catch (Exception ex) {
            ((DatabaseRepository) repoMember).rollback();
        } finally {
            ((DatabaseRepository) repoMember).disconnect();
        }
    }
    public void updateExercise(Exercise exercise) throws Exception {
        ((DatabaseRepository) repoExercise).connect();
        try {
            repoExercise.update(exercise);
            ((DatabaseRepository) repoExercise).commit();
        } catch (Exception ex) {
            ((DatabaseRepository) repoExercise).rollback();
        } finally {
            ((DatabaseRepository) repoExercise).disconnect();
        }
    }
    
    public ArrayList<Member> getMembers() throws Exception {
        ((DatabaseRepository) repoMember).connect();
        return repoMember.getAll();
    }
    public ArrayList<Exercise> getExercises() throws Exception {
        ((DatabaseRepository) repoExercise).connect();
        return repoExercise.getAll();
    }

    public Trainer login(String username, String password) throws Exception {
        ArrayList<Trainer> trainers = controller.repoTrainer.getAll();

        for (Trainer t : trainers) {
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
