package repo.db.impl;

import domain.Gender;
import domain.Member;
import domain.Trainer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import repo.*;
import repo.db.DatabaseConnectionFactory;
import repo.db.DatabaseRepository;

public class DbRepositoryTrainer implements DatabaseRepository<Trainer>{
    @Override
    public void insert(Trainer trainer) throws Exception {
        try{
        String query = "INSERT INTO Trainer(firstName, lastName, hireDate, username, password) "
                                + "VALUES(?, ?, ?, ?, ?)";
        Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
        
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, trainer.getFirstName());
        ps.setString(2, trainer.getLastName());
        ps.setDate(3, Date.valueOf(trainer.getHireDate()));
        ps.setString(4, trainer.getUsername());
        ps.setString(5, trainer.getPassword());
        
        ps.executeUpdate();
        System.out.println("Trainer  [" + trainer + "] succesfully inserted.");
        
        ps.close();
        } catch (Exception e){
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    
    @Override
    public void update(Trainer trainer) throws Exception {
        try {
            String query = "UPDATE Trainer "
                                    + "SET firstName = ?, lastName = ?, hireDate = ?, username = ?, password = ? "
                                    + "WHERE trainerID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, trainer.getFirstName());
            ps.setString(2, trainer.getLastName());
            ps.setDate(3, Date.valueOf(trainer.getHireDate()));
            ps.setString(4, trainer.getUsername());
            ps.setString(5, trainer.getPassword());
            ps.setInt(6, trainer.getTrainerID());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected != 0) System.out.println("Trainer  [" + trainer + "] succesfully updated.");

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    
    @Override
    public void delete(Trainer trainer) throws Exception {
       try {
            String query = "DELETE FROM Trainer "
                                    + "WHERE trainerID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, trainer.getTrainerID());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected != 0) System.out.println("Trainer  [" + trainer + "] succesfully deleted.");

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }        
    }
    
    @Override
    public Trainer find(int id) throws Exception {        
        try {
            String query = "SELECT * "
                                    + "FROM Trainer "
                                    + "WHERE trainerID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Trainer trainer = new Trainer();
                trainer.setTrainerID(rs.getInt("trainerID"));
                trainer.setFirstName(rs.getString("firstName"));
                trainer.setLastName(rs.getString("lastName"));
                trainer.setHireDate(rs.getDate("hireDate").toLocalDate());
                trainer.setUsername(rs.getString("username"));
                trainer.setPassword(rs.getString("password"));
                
                System.out.println("Succesfully found trainer [" + trainer + "].");
                return trainer;
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        System.out.println("Trainer with ID [" + id + "] was not found.");
        return null;
    }
    
    @Override
    public ArrayList<Trainer> getAll() {
        ArrayList<Trainer> trainers = new ArrayList<>();

        try {
            String query = "SELECT * "
                                    + "FROM Trainer ";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Trainer trainer = new Trainer();
                trainer.setTrainerID(rs.getInt("trainerID"));
                trainer.setFirstName(rs.getString("firstName"));
                trainer.setLastName(rs.getString("lastName"));
                trainer.setHireDate(rs.getDate("hireDate").toLocalDate());
                trainer.setUsername(rs.getString("username"));
                trainer.setPassword(rs.getString("password"));

                trainers.add(trainer);
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        System.out.println("Retrieved " + trainers.size() + " row(s).");
        return trainers;
    }
}
