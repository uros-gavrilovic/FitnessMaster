package repo.db.impl;

import domain.Exercise;
import repo.*;
import  domain.WorkoutPlan;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repo.db.DatabaseConnectionFactory;
import repo.db.DatabaseRepository;

public class DbRepositoryWorkoutPlan implements DatabaseRepository<WorkoutPlan>{
    @Override
    public void insert(WorkoutPlan plan) throws Exception {
       try{
        String query = "INSERT INTO WorkoutPlan(date, memberID, trainerID) "
                                + "VALUES(?, ?, ?)";
        Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
        
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setDate(1, Date.valueOf(plan.getDate()));
        ps.setInt(2, plan.getMember().getMemberID());
        ps.setInt(3, plan.getTrainer().getTrainerID());
        
        ps.executeUpdate();
        System.out.println("Workout plan  [" + plan + "] succesfully inserted.");
        
        ps.close();
        } catch (Exception e){
            System.err.println("ERROR: " + e.getMessage());
        }        
    }

    @Override
    public void update(WorkoutPlan plan) throws Exception {
        try {
            String query = "UPDATE WorkoutPlan "
                                    + "SET date = ?, memberID = ?, trainerID = ? "
                                    + "WHERE workoutPlanID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, Date.valueOf(plan.getDate()));
            ps.setInt(2, plan.getMember().getMemberID());
            ps.setInt(3, plan.getTrainer().getTrainerID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0) {
                System.out.println("Workout plan  [" + plan + "] succesfully updated.");
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    @Override
    public void delete(WorkoutPlan plan) throws Exception {
        try {
            String query = "DELETE FROM WorkoutPlan "
                                    + "WHERE workoutPlanID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, plan.getWorkoutPlanID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0) {
                System.out.println("Workout plan  [" + plan + "] succesfully deleted.");
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    @Override
    public WorkoutPlan find(int id) throws Exception {
        try {
            String query = "SELECT * "
                                    + "FROM WorkoutPlan "
                                    + "WHERE workoutPlanID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                WorkoutPlan plan = new WorkoutPlan();
                plan.setWorkoutPlanID(rs.getInt("workoutPlanID"));
                plan.setDate(rs.getDate("date").toLocalDate());
                plan.setMember(new DbRepositoryMember().find(rs.getInt("memberID")));
                plan.setTrainer(new DbRepositoryTrainer().find(rs.getInt("trainerID")));

                System.out.println("Succesfully found workout plan [" + plan + "].");
                return plan;
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        System.out.println("Workout plan with ID [" + id + "] was not found.");
        return null;
    }

    @Override
    public ArrayList<WorkoutPlan> getAll() {
        ArrayList<WorkoutPlan> plans = new ArrayList<>();

        try {
            String query = "SELECT * "
                                    + "FROM WorkoutPlan ";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                WorkoutPlan plan = new WorkoutPlan();
                plan.setWorkoutPlanID(rs.getInt("workoutPlanID"));
                plan.setDate(rs.getDate("date").toLocalDate());
                plan.setMember(new DbRepositoryMember().find(rs.getInt("memberID")));
                plan.setTrainer(new DbRepositoryTrainer().find(rs.getInt("trainerID")));

                plans.add(plan);
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        System.out.println("Retrieved " + plans.size() + " row(s).");
        return plans;
    }
}
