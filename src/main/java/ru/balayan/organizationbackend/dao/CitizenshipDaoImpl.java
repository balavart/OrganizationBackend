package ru.balayan.organizationbackend.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.balayan.organizationbackend.model.entities.Citizenship;

/**
 * @author Vardan Balaian
 * @created 12.07.2020
 * @since 1.8
 */
@Repository
@Transactional
public class CitizenshipDaoImpl implements CitizenshipDao {

  @PersistenceContext EntityManager entityManager;

  @Override
  public List<Citizenship> findAll() {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Citizenship> citizenshipCriteria = builder.createQuery(Citizenship.class);
    Root<Citizenship> citizenshipRoot = citizenshipCriteria.from(Citizenship.class);

    citizenshipCriteria.select(citizenshipRoot);

    return entityManager.createQuery(citizenshipCriteria).getResultList();
  }
}
