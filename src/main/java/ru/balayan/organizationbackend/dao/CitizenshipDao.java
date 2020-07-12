package ru.balayan.organizationbackend.dao;

import java.util.List;
import ru.balayan.organizationbackend.model.entities.Citizenship;

/**
 * @author Vardan Balaian
 * @created 12.07.2020
 * @since 1.8
 */
public interface CitizenshipDao {

  List<Citizenship> findAll();
}
