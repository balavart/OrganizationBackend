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
public class DocumentType implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter(AccessLevel.NONE)
  @Setter(AccessLevel.NONE)
  Integer id;

  @Version
  @Getter(AccessLevel.NONE)
  Integer version;

  @Column(length = 100)
  String name;

  @Column(length = 4, unique = true)
  String code;

  @OneToMany(
      targetEntity = Document.class,
      mappedBy = "documentType",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  @ToString.Exclude
  List<Document> documents;
}
