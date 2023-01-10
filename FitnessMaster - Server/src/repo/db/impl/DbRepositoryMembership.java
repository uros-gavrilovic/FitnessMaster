package repo.db.impl;

import domain.Exercise;
import domain.Member;
import domain.Membership;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repo.*;
import repo.db.DatabaseConnectionFactory;
import repo.db.DatabaseRepository;

public class DbRepositoryMembership implements DatabaseRepository<Membership>{
    @Override
    public void insert(Membership membership) throws Exception {
       try{
        String query = "INSERT INTO Membership(memberID, packageID, startDate, endDate) "
                                + "VALUES(?, ?, ?, ?)";
        Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
        
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1,  membership.getMember().getMemberID());
        ps.setInt(2, membership.getMembershipPackage().getPackageID());
        ps.setDate(3, Date.valueOf(membership.getStartDate()));
        ps.setDate(4, Date.valueOf(membership.getEndDate()));
        
        ps.executeUpdate();
        System.out.println("Membership  [" + membership + "] succesfully inserted.");
        
        ps.close();
        } catch (Exception e){
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    
    @Override
    public void update(Membership membership) throws Exception {
        try {
            String query = "UPDATE Membership "
                                    + "SET startDate = ?, endDate = ? "
                                    + "WHERE memberID = ? AND packageID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDate(1, Date.valueOf(membership.getStartDate()));
            ps.setDate(2, Date.valueOf(membership.getEndDate()));
            ps.setInt(3, membership.getMember().getMemberID());
            ps.setInt(4, membership.getMembershipPackage().getPackageID());
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0) {
                System.out.println("Membership  [" + membership + "] succesfully updated.");
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    
    @Override
    public void delete(Membership membership) throws Exception {
        try {
            String query = "DELETE FROM Membership "
                                    + "WHERE memberID = ? AND packageID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, membership.getMember().getMemberID());
            ps.setInt(2, membership.getMembershipPackage().getPackageID());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected != 0) {
                System.out.println("Membership  [" + membership + "] succesfully deleted.");
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    
    @Override
    public Membership find(Membership membership) throws Exception {
        // TODO: Implement function.
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
    @Override
    public ArrayList<Membership> getAll() {
        ArrayList<Membership> memberships = new ArrayList<>();

        try {
            String query = "SELECT * "
                                + "FROM Membership ";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Membership membership = new Membership();
                membership.setMember(new DbRepositoryMember().find(new Member(rs.getInt("memberID"))));
                membership.setMembershipPackage(new DbRepositoryPackage().find(new domain.Package(rs.getInt("packageID"))));
                membership.setStartDate(rs.getDate("startDate").toLocalDate());
                membership.setEndDate(rs.getDate("endDate").toLocalDate());
                
                memberships.add(membership);
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        System.out.println("Retrieved " + memberships.size() + " row(s).");
        return memberships;
    }
}
