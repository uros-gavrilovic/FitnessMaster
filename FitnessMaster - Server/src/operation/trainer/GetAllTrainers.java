package operation.trainer;

import domain.GenericEntity;
import domain.Trainer;
import java.util.ArrayList;
import operation.AbstractGenericOperation;
import java.sql.ResultSet;

public class GetAllTrainers extends AbstractGenericOperation{
    private ArrayList<Trainer> trainers = new ArrayList();
    
    @Override
    protected void preconditions(GenericEntity entity) throws Exception {
        // NONE
    }
    @Override
    protected void executeOperation(GenericEntity entity) throws Exception {
        ResultSet rs = repository.getAll(entity);
        while (rs.next()) {
            Trainer t = new Trainer();

            t.setId(rs.getInt("trainerID"));
            t.setFirstName(rs.getString("firstName"));
            t.setLastName(rs.getString("lastName"));
            t.setHireDate(rs.getDate("hireDate").toLocalDate());
            t.setUsername(rs.getString("username"));
            t.setPassword(rs.getString("password"));

            trainers.add(t);
        }
    }

    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }
}
