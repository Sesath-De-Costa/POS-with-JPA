package lk.ijse.dep.web.business;

import javax.persistence.EntityManager;

public interface SuperBO {

  void setEntityManager(EntityManager entityManager) throws Exception;

}
