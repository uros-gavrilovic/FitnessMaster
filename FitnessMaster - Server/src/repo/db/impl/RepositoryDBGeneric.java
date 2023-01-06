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

public class RepositoryDBGeneric implements DatabaseRepository<GenericEntity>{
     @Override
     public void insert(GenericEntity entity) throws Exception {
          try {
               Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
               StringBuilder sb = new StringBuilder();
               sb.append("INSERT INTO " + entity.getTableName())
                       .append(" (").append(entity.getColumnNamesForInsert()).append(")")
                       .append(" VALUES (" + entity.getColumnValuesForInsert() + ")");
               
               String query = sb.toString();
               
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
               StringBuilder sb = new StringBuilder();
               
               sb.append("UPDATE " + entity.getTableName())
                       .append(" SET ")
                       .append(" WHERE (" + entity.getColumnValuesForInsert() + ")");
               
               String query = sb.toString();
               System.out.println(query);
               
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
     public void delete(GenericEntity param) throws Exception {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }
     @Override
     public GenericEntity find(int id) throws Exception {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }
     @Override
     public ArrayList<GenericEntity> getAll() {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     }    
}
