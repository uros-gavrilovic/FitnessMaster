package operation.exercise;

import domain.Exercise;
import operation.AbstractGenericOperation;

public class FindExercise extends AbstractGenericOperation{
     Exercise exercise;
     
     @Override
     protected void preconditions(Object param) throws Exception {
          // NONE
     }
     @Override
     protected void executeOperation(Object param) throws Exception {
          exercise = (Exercise) repository.find(((Exercise) param).getExerciseID());
     }

     public Exercise getExercise() {
          return exercise;
     }
}
