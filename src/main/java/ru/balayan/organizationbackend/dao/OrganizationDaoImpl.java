package ru.balayan.organizationbackend.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.balayan.organizationbackend.model.entities.Organization;

/**
 * @author Vardan Balaian
 * @created 12.07.2020
 * @since 1.8
 */
@Repository
@Transactional
public class OrganizationDaoImpl implements OrganizationDao {

  @PersistenceContext EntityManager entityManager;

  @Override
  public List<Organization> findAll() {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Organization> orgCriteria = builder.createQuery(Organization.class);
    Root<Organization> organizationRoot = orgCriteria.from(Organization.class);

    orgCriteria.select(organizationRoot);

    return entityManager.createQuery(orgCriteria).getResultList();
  }
}
