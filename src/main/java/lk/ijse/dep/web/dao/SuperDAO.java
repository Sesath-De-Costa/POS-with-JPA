package lk.ijse.dep.web.dao;

import javax.persistence.EntityManager;
import java.sql.Connection;

public interface SuperDAO {

  void setEntityManager(EntityManager entityManager) throws Exception;
  void setConnection(Connection connection) throws Exception;

}
