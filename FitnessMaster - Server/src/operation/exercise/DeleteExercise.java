package operation.exercise;

import domain.Exercise;
import operation.AbstractGenericOperation;

public class DeleteExercise extends AbstractGenericOperation{
     @Override
     protected void preconditions(Object param) throws Exception {
          // TODO
     }
     @Override
     protected void executeOperation(Object param) throws Exception {
          repository.delete((Exercise) param);
     }
}
