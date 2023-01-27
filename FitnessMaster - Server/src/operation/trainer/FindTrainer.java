package operation.trainer;

import domain.GenericEntity;
import domain.Trainer;
import operation.AbstractGenericOperation;

public class FindTrainer extends AbstractGenericOperation{
    Trainer trainer;
    
    @Override
    protected void preconditions(GenericEntity entity) throws Exception {
        // NONE
    }
     @Override
     protected void executeOperation(GenericEntity entity) throws Exception {
           trainer = (Trainer) repository.find(entity);
     }

     public Trainer getTrainer() {
          return trainer;
     }
}
