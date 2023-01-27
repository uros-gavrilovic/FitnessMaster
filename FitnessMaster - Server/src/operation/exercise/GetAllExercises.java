package operation.exercise;

import domain.BodyPart;
import domain.Category;
import domain.Exercise;
import domain.GenericEntity;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import java.sql.ResultSet;

public class GetAllExercises extends AbstractGenericOperation {
     private ArrayList<Exercise> exercises = new ArrayList<>();

     @Override
     protected void preconditions(GenericEntity entity) throws Exception {
          // NONE
     }
     @Override
     protected void executeOperation(GenericEntity entity) throws Exception {
          ResultSet rs = repository.getAll(entity);
          
         while (rs.next()) {
             Exercise e = new Exercise();
             e.setExerciseID(rs.getInt("exerciseID"));
             e.setName(rs.getString("name"));
             e.setBodyPart(BodyPart.valueOf(rs.getString("bodyPart")));
             e.setCategory(Category.valueOf(rs.getString("category")));

             exercises.add(e);
         }
     }

     public ArrayList<Exercise> getExercises() {
          return exercises;
     }
}
