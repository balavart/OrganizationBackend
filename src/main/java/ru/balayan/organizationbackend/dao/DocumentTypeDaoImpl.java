package ru.balayan.organizationbackend.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.balayan.organizationbackend.model.entities.DocumentType;

/**
 * @author Vardan Balaian
 * @created 12.07.2020
 * @since 1.8
 */
@Repository
@Transactional
public class DocumentTypeDaoImpl implements DocumentTypeDao {

  @PersistenceContext EntityManager entityManager;

  @Override
  public List<DocumentType> findAll() {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<DocumentType> docTypeCriteria = builder.createQuery(DocumentType.class);
    Root<DocumentType> documentTypeRoot = docTypeCriteria.from(DocumentType.class);

    docTypeCriteria.select(documentTypeRoot);

    return entityManager.createQuery(docTypeCriteria).getResultList();
  }
}
