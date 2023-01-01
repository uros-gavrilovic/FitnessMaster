package domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class WorkoutPlan implements Serializable  {
    int workoutPlanID;
    LocalDate date;
    Member member;
    Trainer trainer;

    public WorkoutPlan() {
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
}
