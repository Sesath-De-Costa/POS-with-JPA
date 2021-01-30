package lk.ijse.dep.web.dao;

import lk.ijse.dep.web.entity.SuperEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class CrudDAOImpl<T extends SuperEntity, K extends Serializable> implements CrudDAO<T, K> {

  private EntityManager em;
  private Class<T> entityClass;

  public CrudDAOImpl() {
    entityClass = (Class<T>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
  }

  protected EntityManager getEntityManager() {
    return this.em;
  }

  @Override
  public void setEntityManager(EntityManager entityManager) throws Exception {
    this.em = entityManager;
  }

  @Override
  public void save(T entity) throws Exception {
    em.persist(entity);
  }

  @Override
  public void update(T entity) throws Exception {
    em.merge(entity);
  }

  @Override
  public void delete(K key) throws Exception {
    em.remove(em.find(entityClass, key));
  }

  @Override
  public List<T> getAll() throws Exception {
    return em.createQuery("FROM " + entityClass.getName()).getResultList();
  }

  @Override
  public T get(K key) throws Exception {
    return em.find(entityClass, key);
  }

}
