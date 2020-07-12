package ru.balayan.organizationbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.balayan.organizationbackend.dao.CitizenshipDao;
import ru.balayan.organizationbackend.dao.CitizenshipDaoImpl;
import ru.balayan.organizationbackend.dao.DocumentDao;
import ru.balayan.organizationbackend.dao.DocumentDaoImpl;
import ru.balayan.organizationbackend.dao.DocumentTypeDao;
import ru.balayan.organizationbackend.dao.DocumentTypeDaoImpl;
import ru.balayan.organizationbackend.dao.OfficeDao;
import ru.balayan.organizationbackend.dao.OfficeDaoImpl;
import ru.balayan.organizationbackend.dao.OrganizationDao;
import ru.balayan.organizationbackend.dao.OrganizationDaoImpl;
import ru.balayan.organizationbackend.dao.UserDao;
import ru.balayan.organizationbackend.dao.UserDaoImpl;

/**
 * The type Organization backend application.
 *
 * @author Vardan Balaian
 * @created 03.07.2020
 * @since 1.8
 */
@SpringBootApplication
public class OrganizationBackendApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext run =
        SpringApplication.run(OrganizationBackendApplication.class, args);

    OrganizationDao organizationDao = run.getBean("organizationDaoImpl", OrganizationDaoImpl.class);
    organizationDao.findAll().forEach(System.out::println);

    OfficeDao officeDao = run.getBean("officeDaoImpl", OfficeDaoImpl.class);
    officeDao.findAllOfficesWithOrganizations().forEach(System.out::println);

    DocumentTypeDao documentTypeDao = run.getBean("documentTypeDaoImpl", DocumentTypeDaoImpl.class);
    documentTypeDao.findAll().forEach(System.out::println);

    DocumentDao documentDao = run.getBean("documentDaoImpl", DocumentDaoImpl.class);
    documentDao.findAll().forEach(System.out::println);

    CitizenshipDao citizenshipDao = run.getBean("citizenshipDaoImpl", CitizenshipDaoImpl.class);
    citizenshipDao.findAll().forEach(System.out::println);

    UserDao userDao = run.getBean("userDaoImpl", UserDaoImpl.class);
    userDao.findAll().forEach(System.out::println);
  }
}
