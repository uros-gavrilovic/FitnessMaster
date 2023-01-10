package repo.db.impl;

import domain.Exercise;
import java.util.List;
import repo.*;
import domain.Package;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import repo.db.DatabaseConnectionFactory;
import repo.db.DatabaseRepository;

public class DbRepositoryPackage implements DatabaseRepository<Package>{
    @Override
    public void insert(Package membershipPackage) throws Exception {
        try {
            String query = "INSERT INTO Package(name, price) "
                                    + "VALUES(?, ?)";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, membershipPackage.getName());
            ps.setDouble(2, membershipPackage.getPrice());

            ps.executeUpdate();
            System.out.println("Package  [" + membershipPackage + "] succesfully inserted.");

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    
    @Override
    public void update(Package membershipPackage) throws Exception {
        try {
            String query = "UPDATE Package "
                                    + "SET name = ?, price = ? "
                                    + "WHERE packageID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, membershipPackage.getName());
            ps.setDouble(2, membershipPackage.getPrice());
            ps.setInt(3, membershipPackage.getPackageID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0) {
                System.out.println("Package  [" + membershipPackage + "] succesfully updated.");
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    
    @Override
    public void delete(Package membershipPackage) throws Exception {
        try {
            String query = "DELETE FROM Package "
                                    + "WHERE packageID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, membershipPackage.getPackageID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0) {
                System.out.println("Package  [" + membershipPackage + "] succesfully deleted.");
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }        
    }
    
    @Override
    public Package find(Package membershipPackage) throws Exception {
         int id = membershipPackage.getPackageID();
        try{
        String query = "SELECT * "
                             + "FROM Package "
                             + "WHERE packageID = ?";
        Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
        
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
       
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Package mp = new Package();
            mp.setPackageID(rs.getInt("packageID"));
            mp.setName(rs.getString("name"));
            mp.setPrice(rs.getDouble("price"));
            
            System.out.println("Succesfully found package [" + mp + "].");
            return mp;
        }
        
        ps.close();
        } catch (Exception e){
            System.err.println("ERROR: " + e.getMessage());
        }
        
        System.out.println("Package with ID [" + id + "] was not found.");
        return null;        
    }
    
    @Override
    public ArrayList<Package> getAll() {
        ArrayList<Package> packages = new ArrayList<>();

        try {
            String query = "SELECT * "
                                    + "FROM Package ";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Package membershipPackage = new Package();
                membershipPackage.setPackageID(rs.getInt("packageID"));
                membershipPackage.setName(rs.getString("name"));
                membershipPackage.setPrice(rs.getDouble("price"));

                packages.add(membershipPackage);
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        System.out.println("Retrieved " + packages.size() + " row(s).");
        return packages;
    }
}
