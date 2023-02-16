package domain;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercise implements Serializable, GenericEntity {
     int exerciseID;
     String name;
     Category category;
     BodyPart bodyPart;

     public Exercise() {
     }
     public Exercise(int exerciseID) {
          this.exerciseID = exerciseID;
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
          return exerciseID + " - " + name + " (" + bodyPart + " / " + category + ")";
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
     public HashSet<String> getIdNames() {
          return  new HashSet(Arrays.asList("exerciseID"));
     }
     @Override
     public void setId(int id) {
          setExerciseID(id);
     }
}
