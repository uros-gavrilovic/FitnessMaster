package repo;

import java.util.ArrayList;
import java.sql.ResultSet;

public interface Repository<GenericEntity> {
    void insert(GenericEntity entity) throws Exception;
    void update(GenericEntity entity) throws Exception;
    void delete(GenericEntity entity) throws Exception;
    ResultSet find(GenericEntity entity) throws Exception;
    ResultSet getAll(GenericEntity entity) throws Exception;
}
