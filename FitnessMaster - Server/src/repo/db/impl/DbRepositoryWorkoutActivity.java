package repo.db.impl;

import domain.Exercise;
import domain.WorkoutActivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repo.*;
import repo.db.DatabaseConnectionFactory;
import repo.db.DatabaseRepository;

public class DbRepositoryWorkoutActivity implements DatabaseRepository<WorkoutActivity>{
    @Override
    public void insert(WorkoutActivity activity) throws Exception {
        try {
            String query = "INSERT INTO WorkoutActivity(workoutPlanID, exerciseID, sets, reps) "
                                    + "VALUES(?, ?, ?, ?)";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, activity.getWorkoutPlan().getWorkoutPlanID());
            ps.setInt(2,  activity.getExercise().getExerciseID());
            ps.setInt(3, activity.getSets());
            ps.setInt(4, activity.getReps());

            ps.executeUpdate();
            System.out.println("Activity  [" + activity + "] succesfully inserted.");

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        } 
    }
    
    @Override
    public void update(WorkoutActivity activity) throws Exception {
        try {
            String query = "UPDATE Exercise "
                                    + "SET reps = ?, sets = ?, exerciseID = ? "
                                    + "WHERE ordinalNumber = ? AND workoutPlanID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, activity.getReps());
            ps.setInt(2, activity.getSets());
            ps.setInt(3, activity.getExercise().getExerciseID());
            ps.setInt(4, activity.getOrdinalNumber());
            ps.setInt(5, activity.getWorkoutPlan().getWorkoutPlanID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0) {
                System.out.println("Activity  [" + activity + "] succesfully updated.");
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    
    @Override
    public void delete(WorkoutActivity activity) throws Exception {
        try {
            String query = "DELETE FROM WorkoutActivity "
                                    + "WHERE workoutPlanID = ? AND ordinalNumber = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, activity.getWorkoutPlan().getWorkoutPlanID());
            ps.setInt(2, activity.getOrdinalNumber());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0) {
                System.out.println("Activity  [" + activity + "] succesfully deleted.");
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }     
    }
    
    @Override
    public WorkoutActivity find(int id) throws Exception {
        // TODO: Implement function.
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public ArrayList<WorkoutActivity> getAll() {
        ArrayList<WorkoutActivity> activities = new ArrayList<>();

        try {
            String query = "SELECT * "
                                    + "FROM WorkoutActivity ";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                WorkoutActivity activity = new WorkoutActivity();
                activity.setWorkoutPlan(new DbRepositoryWorkoutPlan().find(rs.getInt("workoutPlanID")));
                activity.setOrdinalNumber(rs.getInt("ordinalNumber"));
                activity.setSets(rs.getInt("sets"));
                activity.setReps(rs.getInt("reps"));
                activity.setExercise(new DbRepositoryExercise().find(rs.getInt("exerciseID")));

                activities.add(activity);
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        System.out.println("Retrieved " + activities.size() + " row(s).");
        return activities;
    }
}
