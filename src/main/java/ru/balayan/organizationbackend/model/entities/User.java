package ru.balayan.organizationbackend.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Vardan Balaian
 * @created 12.07.2020
 * @since 1.8
 */
@Entity
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class User {

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

  @ManyToOne(targetEntity = Office.class, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "office_id", nullable = false)
  @ToString.Exclude
  Office office;

  @Column(length = 50, nullable = false)
  String firstName;

  @Column(length = 50)
  @NonFinal
  String secondName;

  @Column(length = 50)
  @NonFinal
  String middleName;

  @Column(length = 150, nullable = false)
  String position;

  @Column(length = 30)
  @NonFinal
  String phoneNumber;

  @ManyToOne(targetEntity = Document.class, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "document_id", nullable = false)
  @ToString.Exclude
  Document document;

  @ManyToOne(targetEntity = Citizenship.class, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "citizenship_id", nullable = false)
  @ToString.Exclude
  Citizenship citizenship;

  @Column
  @NonFinal
  Boolean isIdentified;
}
