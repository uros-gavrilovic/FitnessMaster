package operation.trainer;

import domain.GenericEntity;
import domain.Trainer;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import java.sql.ResultSet;

public class GetAllTrainers extends AbstractGenericOperation{
    private ArrayList<Trainer> trainers = new ArrayList();
    
    @Override
    protected void preconditions(GenericEntity entity) throws Exception {
        // NONE
    }
    @Override
    protected void executeOperation(GenericEntity entity) throws Exception {
          ArrayList<ResultSet> rsList = repository.getAll(entity);
          
          for(ResultSet rs: rsList){
              System.err.println(rs);
              Trainer trainer = new Trainer();
              
              while (rs.next()) {                  
                  trainer.setId(rs.getInt("trainerID"));
                  trainer.setFirstName(rs.getString("firstName"));
                  trainer.setLastName(rs.getString("lastName"));
                  trainer.setHireDate(rs.getDate("hireDate").toLocalDate());
                  trainer.setUsername(rs.getString("username"));
                  trainer.setPassword(rs.getString("password"));

                  System.err.println(trainer);
                  trainers.add(trainer);
              }

          }
    }

    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }
}
