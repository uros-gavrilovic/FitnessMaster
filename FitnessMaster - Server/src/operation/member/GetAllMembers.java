package operation.member;

import domain.GenericEntity;
import domain.Member;
import java.util.ArrayList;
import operation.AbstractGenericOperation;

public class GetAllMembers extends AbstractGenericOperation{
    ArrayList<GenericEntity> genericMembers = new ArrayList();
    
    @Override
    protected void preconditions(GenericEntity entity) throws Exception {
          // NONE
    }
    @Override
    protected void executeOperation(GenericEntity entity) throws Exception {
        genericMembers = repository.getAll(entity);
    }

    public ArrayList<Member> getMembers() {
        ArrayList<Member> members = new ArrayList<>();
        for (GenericEntity entity : genericMembers) {
            members.add((Member) entity);
        }
        
        return members;
    }
}
