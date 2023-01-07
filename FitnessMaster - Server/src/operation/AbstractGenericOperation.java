package operation;

import repo.Repository;
import repo.db.DatabaseRepository;
import repo.db.impl.DbRepositoryGeneric;

public abstract class AbstractGenericOperation {
     protected final Repository repository;

     public AbstractGenericOperation() {
          this.repository = new DbRepositoryGeneric();
     }

     protected abstract void preconditions(Object param) throws Exception;
     protected abstract void executeOperation(Object param) throws Exception;
          
     public final void execute(Object param) throws Exception {
          try {
               preconditions(param);
               startTransaction();
               executeOperation(param);
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
