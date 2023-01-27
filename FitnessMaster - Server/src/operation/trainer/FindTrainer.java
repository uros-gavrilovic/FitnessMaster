package operation.trainer;

import domain.GenericEntity;
import domain.Trainer;
import java.sql.ResultSet;
import java.util.ArrayList;
import operation.AbstractGenericOperation;

public class FindTrainer extends AbstractGenericOperation{
    private Trainer trainer;
    
    @Override
    protected void preconditions(GenericEntity entity) throws Exception {
        // NONE
    }
     @Override
     protected void executeOperation(GenericEntity entity) throws Exception {
         ResultSet rs = repository.find(entity);
         Trainer trainer = new Trainer();

         trainer.setId(rs.getInt("trainerID"));
         trainer.setFirstName(rs.getString("firstName"));
         trainer.setLastName(rs.getString("lastName"));
         trainer.setHireDate(rs.getDate("hireDate").toLocalDate());
         trainer.setUsername(rs.getString("username"));
         trainer.setPassword(rs.getString("password"));
     }

     public Trainer getTrainer() {
          return trainer;
     }
}
