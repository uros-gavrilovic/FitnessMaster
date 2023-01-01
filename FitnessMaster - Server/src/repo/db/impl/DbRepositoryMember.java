package repo.db.impl;

import domain.Gender;
import repo.db.*;
import domain.Member;
import java.util.List;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import lib.generators.RandomMemberGenerator;

public class DbRepositoryMember implements DatabaseRepository<Member>{
    @Override
    public void insert(Member member) throws Exception {
        try{
        String query = "INSERT INTO Member(firstName, lastName, gender, address, phoneNumber, dateOfBirth) "
                                + "VALUES(?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
        
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, member.getFirstName());
        ps.setString(2, member.getLastName());
        ps.setString(3, member.getGender().toString());
        ps.setString(4, member.getAddress());
        ps.setString(5, member.getPhoneNumber());
        ps.setDate(6, Date.valueOf(member.getDateOfBirth()));
        
        ps.executeUpdate();
        System.out.println("Member  [" + member + "] succesfully inserted.");
        
        ps.close();
        } catch (Exception e){
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    @Override
    public void update(Member member) throws Exception {
        try {
            String query = "UPDATE Member "
                                    + "SET firstName = ?, lastName = ?, gender = ?, address = ?, phoneNumber = ?, dateOfBirth = ?"
                                    + "WHERE memberID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, member.getFirstName());
            ps.setString(2, member.getLastName());
            ps.setString(3, member.getGender().toString());
            ps.setString(4, member.getAddress());
            ps.setString(5, member.getPhoneNumber());
            ps.setDate(6, Date.valueOf(member.getDateOfBirth()));
            ps.setInt(7, member.getMemberID());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected != 0) System.out.println("Member  [" + member + "] succesfully updated.");
            
            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
    @Override
    public void delete(Member member) throws Exception {
        try {
            String query = "DELETE FROM Member "
                                    + "WHERE memberID = ?";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, member.getMemberID());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected != 0) System.out.println("Member  [" + member + "] succesfully deleted.");
            
            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }        
    }
    @Override
    public Member find(int id) throws Exception {     
        try{
        String query = "SELECT * "
                                + "FROM Member "
                                + "WHERE memberID = ?";
        Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
        
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
       
        ResultSet rs = ps.executeQuery();
        while(rs.next()){   
            Member member = new Member();
            member.setMemberID(rs.getInt("memberID"));
            member.setFirstName(rs.getString("firstName"));
            member.setLastName(rs.getString("lastName"));
            member.setGender(Gender.valueOf(rs.getString("gender")));
            member.setAddress(rs.getString("address"));
            member.setPhoneNumber(rs.getString("phoneNumber"));
            member.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
            
            System.out.println("Succesfully found member [" + member + "].");
            return member;
        }
        
        ps.close();
        } catch (Exception e){
            System.err.println("ERROR: " + e.getMessage());
        }
        
        System.out.println("Member with ID [" + id + "] was not found.");
        return null;
    }
    @Override
    public ArrayList<Member> getAll() {
        ArrayList<Member> members = new ArrayList<>();

        try {
            String query = "SELECT * "
                                    + "FROM Member ";
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Member member = new Member();
                member.setMemberID(rs.getInt("memberID"));
                member.setFirstName(rs.getString("firstName"));
                member.setLastName(rs.getString("lastName"));
                member.setGender(Gender.valueOf(rs.getString("gender")));
                member.setAddress(rs.getString("address"));
                member.setPhoneNumber(rs.getString("phoneNumber"));
                member.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());

                members.add(member);
            }

            ps.close();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        
        System.out.println("Retrieved " + members.size() + " row(s).");
        return members;
    }

//    public static void main(String[] args) throws Exception {
//        DatabaseRepository dbRepo = new DbRepositoryMember();
//        RandomMemberGenerator rmg = new RandomMemberGenerator();
//
//        for (int i = 0; i < 25; i++) {
//            dbRepo.insert(rmg.getRandomMember());
//        }
//        dbRepo.commit();
//    }
}
