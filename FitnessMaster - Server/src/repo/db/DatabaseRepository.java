package repo.db;

import repo.Repository;

public interface DatabaseRepository<T> extends Repository<T>{
    default public void connect() throws Exception{
        DatabaseConnectionFactory.getInstance().getConnection();
    }
    default public void disconnect() throws Exception{
        DatabaseConnectionFactory.getInstance().getConnection().close();
    }
    default public void commit() throws Exception{
        DatabaseConnectionFactory.getInstance().getConnection().commit();
    }
    default public void rollback() throws Exception{
        DatabaseConnectionFactory.getInstance().getConnection().rollback();
    }
}
