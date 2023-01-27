package operation;

import domain.GenericEntity;
import repo.Repository;
import repo.db.DatabaseRepository;
import repo.db.impl.DbRepositoryGeneric;

public abstract class AbstractGenericOperation {
     protected final DbRepositoryGeneric repository;

     public AbstractGenericOperation() {
          this.repository = new DbRepositoryGeneric();
     }

     protected abstract void preconditions(GenericEntity entity) throws Exception;
     protected abstract void executeOperation(GenericEntity entity) throws Exception;
          
     public final void execute(GenericEntity entity) throws Exception {
          try {
               preconditions(entity);
               startTransaction();
               executeOperation(entity);
               commitTransaction();
          } catch (Exception ex) {
               ex.printStackTrace();
               rollbackTransaction();
               throw ex;
          } finally {
               disconnect();
          }
     }   
     private void startTransaction() throws Exception {
          ((DatabaseRepository) repository).connect();
     }
     private void commitTransaction() throws Exception {
          ((DatabaseRepository) repository).commit();
     }
     private void rollbackTransaction() throws Exception {
          ((DatabaseRepository) repository).rollback();
     }
     private void disconnect() throws Exception {
          ((DatabaseRepository) repository).disconnect();
     }
}
