package gui.models;

import javax.swing.table.AbstractTableModel;
import domain.Exercise;
import java.util.ArrayList;
import java.util.List;

public class ExerciseTableModel extends AbstractTableModel{
    List<Exercise> exercises;
    String headers[] = {"EXERCISE ID", "NAME", "CATEGORY", "BODY PART"};

    public ExerciseTableModel(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }
    
    @Override
    public int getRowCount() {
        return exercises.size();
    }
    @Override
    public int getColumnCount() {
        return headers.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Exercise exercise = exercises.get(rowIndex);
        
        try {
            switch (columnIndex) {
                case 0: return exercise.getExerciseID();
                case 1: return exercise.getName();
                case 2: return exercise.getCategory().toString();
                case 3: return exercise.getBodyPart().toString();
                default: return "N/A";
            }
        } catch (NullPointerException e) {
            return "N/A";
        }
    }
    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
    
    public Exercise getExerciseAt(int row){
        return exercises.get(row);
    }
    public void addExercise(Exercise exercise){
        exercises.add(exercise);
        fireTableRowsInserted(exercises.size() - 1, exercises.size() - 1);
    }
}
