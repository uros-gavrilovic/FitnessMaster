package operation.exercise;

import domain.BodyPart;
import domain.Category;
import domain.Exercise;
import domain.GenericEntity;
import operation.AbstractGenericOperation;
import java.sql.ResultSet;

public class FindExercise extends AbstractGenericOperation{
     private Exercise exercise;
     
     @Override
     protected void preconditions(GenericEntity entity) throws Exception {
          // NONE
     }
     @Override
     protected void executeOperation(GenericEntity entity) throws Exception {
           ResultSet rs = repository.find(entity);
           exercise = new Exercise();
           
           exercise.setId(rs.getInt("exerciseID"));
           exercise.setName(rs.getString("name"));
           exercise.setBodyPart(BodyPart.valueOf(rs.getString("bodyPart")));
           exercise.setCategory(Category.valueOf(rs.getString("category")));
     }

     public Exercise getExercise() {
          return exercise;
     }
}
