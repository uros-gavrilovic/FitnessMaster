package domain;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise implements Serializable, GenericEntity {
    int exerciseID;
    String name;
    Category category;
    BodyPart bodyPart;

    public Exercise() {
    }
    public Exercise(String name, Category category, BodyPart bodyPart) {
        this.name = name;
        this.category = category;
        this.bodyPart = bodyPart;
    }
    public Exercise(int exerciseID, String name, Category category, BodyPart bodyPart) {
        this.exerciseID = exerciseID;
        this.name = name;
        this.category = category;
        this.bodyPart = bodyPart;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Exercise other = (Exercise) obj;
        if (this.exerciseID != other.exerciseID) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.category != other.category) {
            return false;
        }
        return this.bodyPart == other.bodyPart;
    }
    public String toString() {
        return exerciseID + " - " + name + " (" + bodyPart +" / " + category + ")";
    }
    
    public int getExerciseID() {
        return exerciseID;
    }
    public void setExerciseID(int exerciseID) {
        this.exerciseID = exerciseID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public BodyPart getBodyPart() {
        return bodyPart;
    }
    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }

    @Override
     public String getTableName() {
          return this.getClass().getSimpleName();
     }
     @Override
     public ArrayList<String> getColumnNames() {
         ArrayList<String> columnNames = new ArrayList();
         for(Field f : this.getClass().getDeclaredFields()){
              columnNames.add(f.getName());
         }
         return columnNames;
     }
     @Override
     public ArrayList<Object> getColumnValues() {
          ArrayList<Object> columnValues = new ArrayList<>();
          ArrayList<String> columnNames = getColumnNames();
          for(String columnName : columnNames){
               try {
                    Field field = this.getClass().getDeclaredField(columnName);
                    field.setAccessible(true);
                    Object value = field.get(this);
                    columnValues.add(value);
               } catch (Exception ex) {
                    Logger.getLogger(Exercise.class.getName()).log(Level.SEVERE, null, ex);
               } 
               
          }
          return columnValues;
     }
     @Override
     public void setId(int id) {
          setExerciseID(id);
     }
}
