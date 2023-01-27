package operation.exercise;

import domain.Exercise;
import domain.GenericEntity;
import java.util.ArrayList;
import operation.AbstractGenericOperation;

public class GetAllExercises extends AbstractGenericOperation {
     ArrayList<GenericEntity> genericExercises;

     @Override
     protected void preconditions(GenericEntity entity) throws Exception {
          // NONE
     }
     @Override
     protected void executeOperation(GenericEntity entity) throws Exception {
          genericExercises = repository.getAll(entity);
     }

     public ArrayList<Exercise> getExercises() {
         ArrayList<Exercise> exercises = new ArrayList<>();
         for(GenericEntity entity: genericExercises){
             exercises.add((Exercise) entity);
         }
          return exercises;
     }
}
