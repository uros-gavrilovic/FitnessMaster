package operation.member;

import domain.GenericEntity;
import domain.Member;
import operation.AbstractGenericOperation;

public class InsertMember extends AbstractGenericOperation{
    @Override
    protected void preconditions(GenericEntity entity) throws Exception {
        // TODO
    }
    @Override
    protected void executeOperation(GenericEntity entity) throws Exception {
          repository.insert((Member) entity);
    }
}
