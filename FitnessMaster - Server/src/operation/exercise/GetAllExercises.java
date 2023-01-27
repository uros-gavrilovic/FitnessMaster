package operation.exercise;

import domain.BodyPart;
import domain.Category;
import domain.Exercise;
import domain.GenericEntity;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import java.sql.ResultSet;

public class GetAllExercises extends AbstractGenericOperation {
     private ArrayList<Exercise> exercises;

     @Override
     protected void preconditions(GenericEntity entity) throws Exception {
          // NONE
     }
     @Override
     protected void executeOperation(GenericEntity entity) throws Exception {
          ArrayList<ResultSet> rsList = repository.getAll(entity);
          for(ResultSet rs: rsList){
              Exercise exercise = new Exercise();
              
              exercise.setId(rs.getInt("exerciseID"));
              exercise.setName(rs.getString("name"));
              exercise.setBodyPart(BodyPart.valueOf(rs.getString("bodyPart")));
              exercise.setCategory(Category.valueOf(rs.getString("category")));
              
              exercises.add(exercise);
          }
     }

     public ArrayList<Exercise> getExercises() {
          return exercises;
     }
}
