package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WorkoutPlan implements Serializable, GenericEntity {
     int workoutPlanID;
     LocalDate date;
     Member member;
     Trainer trainer;

     public WorkoutPlan() {
     }
     public WorkoutPlan(int workoutPlanID) {
          this.workoutPlanID = workoutPlanID;
     }
     public WorkoutPlan(LocalDate date, Member member, Trainer trainer) {
          this.date = date;
          this.member = member;
          this.trainer = trainer;
     }
     public WorkoutPlan(int workoutPlanID, LocalDate date, Member member, Trainer trainer) {
          this.workoutPlanID = workoutPlanID;
          this.date = date;
          this.member = member;
          this.trainer = trainer;
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
          final WorkoutPlan other = (WorkoutPlan) obj;
          if (this.workoutPlanID != other.workoutPlanID) {
               return false;
          }
          if (!Objects.equals(this.date, other.date)) {
               return false;
          }
          if (!Objects.equals(this.member, other.member)) {
               return false;
          }
          return Objects.equals(this.trainer, other.trainer);
     }
     public String toString() {
          return "WorkoutPlan{" + "workoutPlanID=" + workoutPlanID + ", date=" + date + ", member=" + member + ", trainer=" + trainer + '}';
     }

     public int getWorkoutPlanID() {
          return workoutPlanID;
     }
     public void setWorkoutPlanID(int workoutPlanID) {
          this.workoutPlanID = workoutPlanID;
     }
     public LocalDate getDate() {
          return date;
     }
     public void setDate(LocalDate date) {
          this.date = date;
     }
     public Member getMember() {
          return member;
     }
     public void setMember(Member member) {
          this.member = member;
     }
     public Trainer getTrainer() {
          return trainer;
     }
     public void setTrainer(Trainer trainer) {
          this.trainer = trainer;
     }

    @Override
    public ArrayList<String> getColumnNames() {
        return (ArrayList<String>) List.of("workoutPlanID", "date", "memberID", "trainerID");
    }
    @Override
    public ArrayList<Object> getColumnValues() {
        List<Object> columnValues = List.of(workoutPlanID, date, member.getMemberID(), trainer.getTrainerID());
        return (ArrayList<Object>) columnValues;
    }
    @Override
    public ArrayList<String> getIdNames() {
        return (ArrayList<String>) List.of("workoutPlanID");
    }
    @Override
    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
