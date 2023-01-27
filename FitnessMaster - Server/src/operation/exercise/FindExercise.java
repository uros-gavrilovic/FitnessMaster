package operation.exercise;

import domain.Exercise;
import domain.GenericEntity;
import operation.AbstractGenericOperation;

public class FindExercise extends AbstractGenericOperation{
     Exercise exercise;
     
     @Override
     protected void preconditions(GenericEntity entity) throws Exception {
          // NONE
     }
     @Override
     protected void executeOperation(GenericEntity entity) throws Exception {
           exercise = (Exercise) repository.find(entity);
     }

     public Exercise getExercise() {
          return exercise;
     }
}
