package operation.exercise;

import domain.Exercise;
import java.util.ArrayList;
import operation.AbstractGenericOperation;

public class GetAllExercises extends AbstractGenericOperation {
     ArrayList<Exercise> exercises;

     @Override
     protected void preconditions(Object param) throws Exception {
          // NONE
     }
     @Override
     protected void executeOperation(Object param) throws Exception {
          exercises = repository.getAll();
     }

     public ArrayList<Exercise> getExercises() {
          return exercises;
     }
}
