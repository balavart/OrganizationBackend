package ru.balayan.organizationbackend.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.balayan.organizationbackend.model.entities.User;

/**
 * @author Vardan Balaian
 * @created 12.07.2020
 * @since 1.8
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

  @PersistenceContext EntityManager entityManager;

  @Override
  public List<User> findAll() {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<User> userCriteria = builder.createQuery(User.class);
    Root<User> userRoot = userCriteria.from(User.class);

    userCriteria.select(userRoot);

    return entityManager.createQuery(userCriteria).getResultList();
  }
}
