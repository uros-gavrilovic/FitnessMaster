package domain;

import java.io.Serializable;
import java.util.Objects;

public class WorkoutActivity implements Serializable  {
    int ordinalNumber;
    int sets;
    int reps;
    Exercise exercise;
    WorkoutPlan workoutPlan;

    public WorkoutActivity() {
    }
    public WorkoutActivity(int ordinalNumber, int sets, int reps, Exercise exercise, WorkoutPlan workoutPlan) {
        this.ordinalNumber = ordinalNumber;
        this.sets = sets;
        this.reps = reps;
        this.exercise = exercise;
        this.workoutPlan = workoutPlan;
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
        final WorkoutActivity other = (WorkoutActivity) obj;
        if (this.ordinalNumber != other.ordinalNumber) {
            return false;
        }
        if (this.sets != other.sets) {
            return false;
        }
        if (this.reps != other.reps) {
            return false;
        }
        if (!Objects.equals(this.exercise, other.exercise)) {
            return false;
        }
        return Objects.equals(this.workoutPlan, other.workoutPlan);
    }
    public String toString() {
        return "WorkoutActivity{" + "ordinalNumber=" + ordinalNumber + ", sets=" + sets + ", reps=" + reps + ", exercise=" + exercise + ", workoutPlan=" + workoutPlan + '}';
    }

    public int getOrdinalNumber() {
        return ordinalNumber;
    }
    public void setOrdinalNumber(int ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }
    public int getSets() {
        return sets;
    }
    public void setSets(int sets) {
        this.sets = sets;
    }
    public int getReps() {
        return reps;
    }
    public void setReps(int reps) {
        this.reps = reps;
    }
    public Exercise getExercise() {
        return exercise;
    }
    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
    public WorkoutPlan getWorkoutPlan() {
        return workoutPlan;
    }
    public void setWorkoutPlan(WorkoutPlan workoutPlan) {
        this.workoutPlan = workoutPlan;
    }
}
