package operation.member;

import domain.GenericEntity;
import domain.Member;
import operation.AbstractGenericOperation;

public class FindMember extends AbstractGenericOperation{
    Member member;
    
    @Override
    protected void preconditions(GenericEntity entity) throws Exception {
        // NONE
    }
    @Override
    protected void executeOperation(GenericEntity entity) throws Exception {
        member = (Member) repository.find(entity);
    }

    public Member getMember() {
        return member;
    }
}
