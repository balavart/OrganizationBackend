package ru.balayan.organizationbackend.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

/**
 * ORM for organization table.
 *
 * @author Vardan Balaian
 * @created 10.07.2020
 * @since 1.8
 */
@Entity
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class Organization implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NonFinal
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  Integer id;

  @Version
  @NonFinal
  @Getter(AccessLevel.NONE)
  Integer version;

  @Column(length = 100, nullable = false)
  String name;

  @Column(length = 200, nullable = false)
  String fullName;

  @Column(length = 30, nullable = false, unique = true)
  String inn;

  @Column(length = 30, nullable = false)
  String kpp;

  @Column(length = 200, nullable = false)
  String address;

  @Column(length = 30)
  @NonFinal
  String phoneNumber;

  @Column
  @NonFinal
  Boolean isActive;

  @OneToMany(
      targetEntity = Office.class,
      mappedBy = "organization",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  @ToString.Exclude
  List<Office> offices;
}
