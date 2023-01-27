package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Trainer implements Serializable, GenericEntity{
     int trainerID;
     String firstName;
     String lastName;
     LocalDate hireDate;
     String username;
     String password;

     public Trainer() {
     }
     public Trainer(int trainerID) {
          this.trainerID = trainerID;
     }
     public Trainer(String firstName, String lastName, LocalDate hireDate, String username, String password) {
          this.firstName = firstName;
          this.lastName = lastName;
          this.hireDate = hireDate;
          this.username = username;
          this.password = password;
     }
     public Trainer(int trainerID, String firstName, String lastName, LocalDate hireDate, String username, String password) {
          this.trainerID = trainerID;
          this.firstName = firstName;
          this.lastName = lastName;
          this.hireDate = hireDate;
          this.username = username;
          this.password = password;
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
          final Trainer other = (Trainer) obj;
          if (this.trainerID != other.trainerID) {
               return false;
          }
          if (!Objects.equals(this.firstName, other.firstName)) {
               return false;
          }
          if (!Objects.equals(this.lastName, other.lastName)) {
               return false;
          }
          if (!Objects.equals(this.username, other.username)) {
               return false;
          }
          if (!Objects.equals(this.password, other.password)) {
               return false;
          }
          return Objects.equals(this.hireDate, other.hireDate);
     }
     public String toString() {
          return "Trainer{" + "trainerID=" + trainerID + ", firstName=" + firstName + ", lastName=" + lastName + ", hireDate=" + hireDate + '}';
     }

     public int getTrainerID() {
          return trainerID;
     }
     public void setTrainerID(int trainerID) {
          this.trainerID = trainerID;
     }
     public String getFirstName() {
          return firstName;
     }
     public void setFirstName(String firstName) {
          this.firstName = firstName;
     }
     public String getLastName() {
          return lastName;
     }
     public void setLastName(String lastName) {
          this.lastName = lastName;
     }
     public LocalDate getHireDate() {
          return hireDate;
     }
     public void setHireDate(LocalDate hireDate) {
          this.hireDate = hireDate;
     }
     public String getUsername() {
          return username;
     }
     public void setUsername(String username) {
          this.username = username;
     }
     public String getPassword() {
          return password;
     }
     public void setPassword(String password) {
          this.password = password;
     }

    @Override
    public ArrayList<String> getIdNames() {
        return new ArrayList<>(Arrays.asList("trainerID"));
    }
    @Override
    public void setId(int id) {
        setTrainerID(id);
    }
}
