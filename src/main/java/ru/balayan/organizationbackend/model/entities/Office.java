package ru.balayan.organizationbackend.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * ORM for office table.
 *
 * @author Vardan Balaian
 * @created 11.07.2020
 * @since 1.8
 */
@Entity
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class Office implements Serializable {

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

  @ManyToOne(targetEntity = Organization.class, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "organization_id", nullable = false)
  @ToString.Exclude
  Organization organization;

  @Column(length = 200, nullable = false)
  String name;

  @Column(length = 200, nullable = false)
  String address;

  @Column(length = 30)
  @NonFinal
  String phoneNumber;

  @Column
  @NonFinal
  Boolean isActive;

  @OneToMany(
      targetEntity = User.class,
      mappedBy = "office",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  @ToString.Exclude
  List<User> users;
}
