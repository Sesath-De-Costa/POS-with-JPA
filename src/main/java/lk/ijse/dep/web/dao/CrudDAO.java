package lk.ijse.dep.web.dao;

import lk.ijse.dep.web.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;

public interface CrudDAO<T extends SuperEntity, K extends Serializable> extends SuperDAO {

     void save(T entity) throws Exception;

     void update(T entity) throws Exception;

     void delete(K key) throws Exception;

     List<T> getAll() throws Exception;

     T get(K key) throws Exception;
}
