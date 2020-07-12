package ru.balayan.organizationbackend.dao;

import java.util.List;
import ru.balayan.organizationbackend.model.entities.Organization;

/**
 * @author Vardan Balaian
 * @created 12.07.2020
 * @since 1.8
 */
public interface OrganizationDao {

  List<Organization> findAll();
}
