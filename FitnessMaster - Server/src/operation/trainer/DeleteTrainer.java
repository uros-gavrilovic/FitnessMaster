package operation.trainer;

import domain.GenericEntity;
import domain.Trainer;
import operation.AbstractGenericOperation;

public class DeleteTrainer extends AbstractGenericOperation{
    @Override
    protected void preconditions(GenericEntity entity) throws Exception {
        // TODO
    }
    @Override
    protected void executeOperation(GenericEntity entity) throws Exception {
        repository.delete((Trainer) entity);
    }
}
