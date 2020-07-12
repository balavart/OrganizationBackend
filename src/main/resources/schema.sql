CREATE TABLE IF NOT EXISTS organization (
  id INT NOT NULL AUTO_INCREMENT,
  version INT NOT NULL DEFAULT 0,
  name VARCHAR(100) NOT NULL,
  full_name VARCHAR(200) NOT NULL,
  inn VARCHAR(30) NOT NULL UNIQUE,
  kpp VARCHAR(30) NOT NULL,
  address VARCHAR(200) NOT NULL,
  phone_number VARCHAR(30) NULL,
  is_active BOOL NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS office (
  id INT NOT NULL AUTO_INCREMENT,
  version INT NOT NULL DEFAULT 0,
  organization_id INT NOT NULL,
  name VARCHAR(200) NOT NULL,
  address VARCHAR(200) NOT NULL,
  phone_number VARCHAR(30) NULL,
  is_active BOOL NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_organization_id FOREIGN KEY (organization_id)
    REFERENCES organization (id)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);
  CREATE INDEX idx_organization_id ON office (organization_id ASC);

CREATE TABLE IF NOT EXISTS document_type (
  id INT NOT NULL AUTO_INCREMENT,
  version INT NOT NULL DEFAULT 0,
  name VARCHAR(100) NULL,
  code CHAR(4) NULL UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS document (
  id INT NOT NULL AUTO_INCREMENT,
  version INT NOT NULL DEFAULT 0,
  number CHAR(10) NULL UNIQUE,
  date DATE NULL,
  document_type_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_document_type_id FOREIGN KEY (document_type_id)
    REFERENCES document_type (id)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);
  CREATE INDEX idx_document_type_id ON document (document_type_id ASC);

CREATE TABLE IF NOT EXISTS citizenship (
  id INT NOT NULL AUTO_INCREMENT,
  version INT NOT NULL DEFAULT 0,
  name VARCHAR(100) NULL,
  code CHAR(4) NULL UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user (
  id INT NOT NULL AUTO_INCREMENT,
  version INT NOT NULL DEFAULT 0,
  office_id INT NOT NULL,
  first_name VARCHAR(50) NOT NULL,
  second_name VARCHAR(50) NULL,
  middle_name VARCHAR(50) NULL,
  position VARCHAR(150) NOT NULL,
  phone_number VARCHAR(30) NULL,
  document_id INT NOT NULL,
  citizenship_id INT NOT NULL,
  is_identified BOOL NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_office_id FOREIGN KEY (office_id)
    REFERENCES office (id)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT fk_document_id FOREIGN KEY (document_id)
    REFERENCES document (id)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT fk_citizenship_id FOREIGN KEY (citizenship_id)
    REFERENCES citizenship (id)
    ON DELETE SET NULL
    ON UPDATE CASCADE);
  CREATE INDEX idx_office_id ON user (office_id ASC);
  CREATE INDEX idx_document_id ON user (document_id ASC);
  CREATE INDEX idx_citizenship_id ON user (citizenship_id ASC);
