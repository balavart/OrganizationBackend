package ru.balayan.organizationbackend.model.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author Vardan Balaian
 * @created 12.07.2020
 * @since 1.8
 */
@Entity
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
@Data
public class Document implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  Integer id;

  @Version
  @Getter(AccessLevel.NONE)
  Integer version;

  @Column(length = 10, unique = true)
  String number;

  @Column
  @Temporal(TemporalType.DATE)
  Date date;

  @ManyToOne(targetEntity = DocumentType.class, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "document_type_id", nullable = false)
  @ToString.Exclude
  DocumentType documentType;

  @OneToMany(
      targetEntity = User.class,
      mappedBy = "document",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  @ToString.Exclude
  List<User> users;
}
