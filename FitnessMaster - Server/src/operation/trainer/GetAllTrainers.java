package operation.trainer;

import domain.GenericEntity;
import domain.Trainer;
import java.util.ArrayList;
import operation.AbstractGenericOperation;

public class GetAllTrainers extends AbstractGenericOperation{
    ArrayList<GenericEntity> genericTrainers;
    
    @Override
    protected void preconditions(GenericEntity entity) throws Exception {
        // NONE
    }
    @Override
    protected void executeOperation(GenericEntity entity) throws Exception {
          genericTrainers = repository.getAll(entity);
    }

    public ArrayList<Trainer> getTrainers() {
        ArrayList<Trainer> trainers = new ArrayList<>();
        for (GenericEntity entity : genericTrainers) {
            trainers.add((Trainer) entity);
        }
        return trainers;
    }
}
