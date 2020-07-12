package ru.balayan.organizationbackend.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.balayan.organizationbackend.model.entities.Document;

/**
 * @author Vardan Balaian
 * @created 12.07.2020
 * @since 1.8
 */
@Repository
@Transactional
public class DocumentDaoImpl implements DocumentDao {

  @PersistenceContext EntityManager entityManager;

  @Override
  public List<Document> findAll() {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Document> documentCriteria = builder.createQuery(Document.class);
    Root<Document> documentRoot = documentCriteria.from(Document.class);

    documentCriteria.select(documentRoot);

    return entityManager.createQuery(documentCriteria).getResultList();
  }
}
