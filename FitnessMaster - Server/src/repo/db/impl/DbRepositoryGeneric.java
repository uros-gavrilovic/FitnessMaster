package repo.db.impl;

import com.mysql.cj.xdevapi.DbDoc;
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
     public GenericEntity find(int id) throws Exception {
//          try {
//               Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
//
//               String query = "SELECT *" + entity.getTableName()
//                       + " FROM " + entity.get()
//                       + " WHERE " + entity.getUpdateWhere();
//
//               PreparedStatement ps = connection.prepareStatement(query);
//               ps.executeUpdate(query, PreparedStatement.RETURN_GENERATED_KEYS);
//
//               ResultSet rsKey = ps.getGeneratedKeys();
//               if (rsKey.next()) {
//                    int id = rsKey.getInt(1);
//
//                    entity.setId(id);
//               }
//               ps.close();
//               rsKey.close();
//          } catch (SQLException ex) {
//               throw ex;
//          }

          throw new UnsupportedOperationException();
     } // TODO
     @Override
     public ArrayList<GenericEntity> getAll() {
          throw new UnsupportedOperationException();
     }  // TODO
}
