package operation.exercise;

import domain.Exercise;
import domain.GenericEntity;
import operation.AbstractGenericOperation;

public class DeleteExercise extends AbstractGenericOperation{
     @Override
     protected void preconditions(GenericEntity entity) throws Exception {
          // TODO
     }
     @Override
     protected void executeOperation(GenericEntity entity) throws Exception {
          repository.delete((Exercise) entity);
     }
}
