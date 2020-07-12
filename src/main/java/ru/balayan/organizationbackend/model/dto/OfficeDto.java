package ru.balayan.organizationbackend.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author Vardan Balaian
 * @created 12.07.2020
 * @since 1.8
 */
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class OfficeDto {

  Integer officeId;

  String orgName;

  String fullOrgName;

  String inn;

  String kpp;

  String orgAddress;

  String orgPhoneNumber;

  Boolean isOrgActive;

  String officeName;

  String officeAddress;

  String officePhoneNumber;

  Boolean isOfficeActive;
}
