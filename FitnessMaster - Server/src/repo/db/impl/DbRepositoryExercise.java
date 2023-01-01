package repo.db.impl;

import domain.BodyPart;
import domain.Category;
import domain.Exercise;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import repo.db.*;

public class DbRepositoryExercise implements DatabaseRepository<Exercise> {
    @Override
    public void insert(Exercise exercise) throws Exception {
        try {
            String query = "INSERT INTO Exercise(name, bodyPart, category) "
                                    + "VALUES(?, ?, ?)";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, exercise.getName());
            ps.setString(2, exercise.getBodyPart().toString());
            ps.setString(3, exercise.getCategory().toString());

            int rowsAffected = ps.executeUpdate();
            System.out.println("rows: " + rowsAffected);
            System.out.println("Exercise  [" + exercise + "] succesfully inserted.");

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    @Override
    public void update(Exercise exercise) throws Exception {
        try {
            String query = "UPDATE Exercise "
                                    + "SET name = ?, bodyPart = ?, category = ? "
                                    + "WHERE exerciseID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, exercise.getName());
            ps.setString(2, exercise.getBodyPart().toString());
            ps.setString(3, exercise.getCategory().toString());
            ps.setInt(4, exercise.getExerciseID());

            System.out.println(ps.toString());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0) {
                System.out.println("Exercise  [" + exercise + "] succesfully updated.");
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    @Override
    public void delete(Exercise exercise) throws Exception {
        try {
            String query = "DELETE FROM Exercise "
                                    + "WHERE exerciseID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, exercise.getExerciseID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0) {
                System.out.println("Exercise  [" + exercise + "] succesfully deleted.");
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    @Override
    public Exercise find(int id) throws Exception {
        try {
            String query = "SELECT * "
                                    + "FROM Exercise "
                                    + "WHERE exerciseID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Exercise exercise = new Exercise();
                exercise.setExerciseID(rs.getInt("exerciseID"));
                exercise.setName(rs.getString("name"));
                exercise.setBodyPart(BodyPart.valueOf(rs.getString("bodyPart")));
                exercise.setCategory(Category.valueOf(rs.getString("bodyPart")));

                System.out.println("Succesfully found exercise [" + exercise + "].");
                return exercise;
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        System.out.println("Exercise with ID [" + id + "] was not found.");
        return null;
    }
    @Override
    public ArrayList<Exercise> getAll() {
        ArrayList<Exercise> exercises = new ArrayList<>();

        try {
            String query = "SELECT * "
                                    + "FROM Exercise ";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Exercise exercise = new Exercise();
                exercise.setExerciseID(rs.getInt("exerciseID"));
                exercise.setName(rs.getString("name"));
                exercise.setBodyPart(BodyPart.valueOf(rs.getString("bodyPart")));
                exercise.setCategory(Category.valueOf(rs.getString("category")));

                exercises.add(exercise);
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        System.out.println("Retrieved " + exercises.size() + " row(s).");
        return exercises;
    }
}
