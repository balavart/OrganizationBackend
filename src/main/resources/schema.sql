CREATE TABLE IF NOT EXISTS organization (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  full_name VARCHAR(100) NOT NULL,
  inn VARCHAR(30) NOT NULL,
  kpp VARCHAR(30) NOT NULL,
  address VARCHAR(100) NOT NULL,
  phone_number VARCHAR(30) NULL,
  is_active BOOL NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS office (
  id INT NOT NULL AUTO_INCREMENT,
  organization_id INT NOT NULL,
  name VARCHAR(50) NOT NULL,
  address VARCHAR(100) NOT NULL,
  phone_number VARCHAR(30) NULL,
  is_active BOOL NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_organization_id FOREIGN KEY (organization_id)
    REFERENCES organization (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
  CREATE INDEX idx_organization_id ON office (organization_id ASC);

CREATE TABLE IF NOT EXISTS document_type (
  id INT NOT NULL AUTO_INCREMENT,
  number CHAR(10) NULL,
  date DATE NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS document (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NULL,
  code CHAR(3) NULL,
  document_type_id INT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_document_type_id FOREIGN KEY (document_type_id)
    REFERENCES document_type (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);
  CREATE INDEX idx_ocument_type_id ON document (document_type_id ASC);

CREATE TABLE IF NOT EXISTS citizenship (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NULL,
  code CHAR(4) NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user (
  id INT NOT NULL AUTO_INCREMENT,
  office_id INT NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  second_name VARCHAR(50) NULL,
  middle_name VARCHAR(50) NULL,
  position VARCHAR(100) NOT NULL,
  phone_number VARCHAR(30) NULL,
  document_id INT NULL,
  citizenship_id INT NULL,
  is_identified BOOL NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_office_id FOREIGN KEY (office_id)
    REFERENCES office (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_document_id FOREIGN KEY (document_id)
    REFERENCES document (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT fk_citizenship_id FOREIGN KEY (citizenship_id)
    REFERENCES citizenship (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);
  CREATE INDEX idx_office_id ON user (office_id ASC);
  CREATE INDEX idx_document_id ON user (document_id ASC);
  CREATE INDEX idx_citizenship_id ON user (citizenship_id ASC);
