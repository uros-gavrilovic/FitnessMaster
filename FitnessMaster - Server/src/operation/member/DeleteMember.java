package operation.member;

import domain.GenericEntity;
import domain.Member;
import operation.AbstractGenericOperation;

public class DeleteMember extends AbstractGenericOperation{
    @Override
    protected void preconditions(GenericEntity entity) throws Exception {
        // TODO
    }

    @Override
    protected void executeOperation(GenericEntity entity) throws Exception {
          repository.delete((Member) entity);
    }
    
}
