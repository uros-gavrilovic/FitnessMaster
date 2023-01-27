package repo.db.impl;

import domain.Exercise;
import domain.GenericEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import repo.db.DatabaseConnectionFactory;
import repo.db.DatabaseRepository;

public class DbRepositoryGeneric implements DatabaseRepository<GenericEntity>{
     @Override
     public void insert(GenericEntity entity) throws Exception {
          try {
               Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

               String query = "INSERT INTO " + entity.getTableName() + "(" + entity.getInsertColumnNames() + ")" +
                                         " VALUES (" + entity.getInsertColumnValues()+ ")";
               
               PreparedStatement ps = connection.prepareStatement(query);
               ps.executeUpdate(query, PreparedStatement.RETURN_GENERATED_KEYS);
               
               ResultSet rsKey = ps.getGeneratedKeys();
               if (rsKey.next()) {
                    int id = rsKey.getInt(1);
                    entity.setId(id);
               }
               ps.close();
               rsKey.close();
          } catch (SQLException ex) {
               throw ex;
          }
     }
     @Override
     public void update(GenericEntity entity) throws Exception {
          try {
               Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
               
               String query = "UPDATE " + entity.getTableName() +
                                          " SET " + entity.getUpdateSet() +
                                          " WHERE " + entity.getUpdateWhere();
               
               PreparedStatement ps = connection.prepareStatement(query);
               ps.executeUpdate(query, PreparedStatement.RETURN_GENERATED_KEYS);
               
               ResultSet rsKey = ps.getGeneratedKeys();
               if (rsKey.next()) {
                    int id = rsKey.getInt(1);
                    
                    entity.setId(id);
               }
               ps.close();
               rsKey.close();
          } catch (SQLException ex) {
               throw ex;
          }
     }
     @Override
     public void delete(GenericEntity entity) throws Exception {
          try {
               Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

               String query = "DELETE FROM " + entity.getTableName()
                                     + " WHERE " + entity.getUpdateWhere();

               PreparedStatement ps = connection.prepareStatement(query);
               ps.executeUpdate(query);
               ps.close();
          } catch (SQLException ex) {
               throw ex;
          }
     }
     @Override
     public ResultSet find(GenericEntity entity) throws Exception {
          try {
              GenericEntity result;
               Connection connection = DatabaseConnectionFactory.getInstance().getConnection();

               String query = "SELECT *" 
                                     + " FROM " + entity.getTableName()
                                     + " WHERE " + entity.getUpdateWhere();

               PreparedStatement ps = connection.prepareStatement(query);
               ResultSet rs = ps.executeQuery();
               
               while(rs.next()){
                   // if(entity instanceof Exercise) return new Exercise(rs.getString("naziv itd"), Category.OTHER, BodyPart.CORE)
                   
               }                  
                
               return null; // IZMENI
          } catch (SQLException ex) {
               throw ex;
          }
     }  // TODO
     @Override
     public ArrayList<GenericEntity> getAll(GenericEntity entity) throws Exception{
          try {
              ArrayList<GenericEntity> results = new ArrayList<>();
              
              Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
              String query = "SELECT *"
                                     + " FROM " + entity.getTableName();

              PreparedStatement ps = connection.prepareStatement(query);
              ResultSet rs = ps.executeQuery();

              while (rs.next()) {
                  
                  result.add(entity);
              }

              return result;
          } catch (SQLException ex) {
              throw ex;
          }
    }
}
