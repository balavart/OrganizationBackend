package ru.balayan.organizationbackend.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.balayan.organizationbackend.model.dto.OfficeDto;
import ru.balayan.organizationbackend.model.entities.Office;
import ru.balayan.organizationbackend.model.entities.Organization;

/**
 * @author Vardan Balaian
 * @created 11.07.2020
 * @since 1.8
 */
@Repository
@Transactional
public class OfficeDaoImpl implements OfficeDao {

  @PersistenceContext EntityManager entityManager;

  @Override
  public List<OfficeDto> findAllOfficesWithOrganizations() {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<OfficeDto> query = builder.createQuery(OfficeDto.class);
    Root<Office> officeRoot = query.from(Office.class);
    Root<Organization> orgRoot = query.from(Organization.class);

    List<Predicate> filterPredicates = new ArrayList<>();
    filterPredicates.add(builder.equal(officeRoot.get("organization"), orgRoot.get("id")));
    query
        .select(
            builder.construct(
                OfficeDto.class,
                officeRoot.get("id"),
                orgRoot.get("name"),
                orgRoot.get("fullName"),
                orgRoot.get("inn"),
                orgRoot.get("kpp"),
                orgRoot.get("address"),
                orgRoot.get("phoneNumber"),
                orgRoot.get("isActive"),
                officeRoot.get("name"),
                officeRoot.get("address"),
                officeRoot.get("phoneNumber"),
                officeRoot.get("isActive")))
        .where(builder.and(filterPredicates.toArray(new Predicate[0])));

    return entityManager.createQuery(query).getResultList();
  }
}
