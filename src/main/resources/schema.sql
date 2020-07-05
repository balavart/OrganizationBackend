DROP TABLE IF EXISTS address;
CREATE TABLE IF NOT EXISTS address (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS phone;
CREATE TABLE IF NOT EXISTS phone (
  id INT NOT NULL AUTO_INCREMENT,
  number VARCHAR(30) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS organization_info;
CREATE TABLE IF NOT EXISTS organization_info (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  full_name VARCHAR(100) NOT NULL,
  inn BIGINT NOT NULL,
  kpp BIGINT NOT NULL,
  phone_id INT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_phone_id
    FOREIGN KEY (phone_id)
    REFERENCES phone (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);
  CREATE INDEX idx_phone_id ON organization_info (phone_id ASC);

DROP TABLE IF EXISTS organization;
CREATE TABLE IF NOT EXISTS organization (
  id INT NOT NULL AUTO_INCREMENT,
  organization_info_id INT NOT NULL,
  address_id INT NOT NULL,
  is_active BOOL NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_organization_info_id FOREIGN KEY (organization_info_id)
    REFERENCES organization_info (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT fk_address_id FOREIGN KEY (address_id)
    REFERENCES address (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);
  CREATE INDEX idx_organization_info_id ON organization (organization_info_id ASC);
  CREATE INDEX idx_address_id ON organization (address_id ASC);

DROP TABLE IF EXISTS office;
CREATE TABLE IF NOT EXISTS office (
  id INT NOT NULL AUTO_INCREMENT,
  organization_id INT NOT NULL,
  name VARCHAR(50) NOT NULL,
  address_id INT NOT NULL,
  phone_id INT NULL,
  is_active BOOL NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_organization_id FOREIGN KEY (organization_id)
    REFERENCES organization (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_office_address_id FOREIGN KEY (address_id)
    REFERENCES address (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_office_phone_id FOREIGN KEY (phone_id)
    REFERENCES phone (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
  CREATE INDEX idx_organization_id ON office (organization_id ASC);
  CREATE INDEX idx_office_address_id ON office (address_id ASC);
  CREATE INDEX idx_office_phone_id ON office (phone_id ASC);

DROP TABLE IF EXISTS document;
CREATE TABLE IF NOT EXISTS document (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NULL,
  code CHAR(3) NULL,
  number CHAR(10) NULL,
  date DATE NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS citizenship;
CREATE TABLE IF NOT EXISTS citizenship (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NULL,
  code CHAR(4) NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS user_info;
CREATE TABLE IF NOT EXISTS user_info (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  second_name VARCHAR(50) NULL,
  middle_name VARCHAR(50) NULL,
  position VARCHAR(100) NOT NULL,
  phone_id INT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_user_info_phone_id FOREIGN KEY (phone_id)
    REFERENCES phone (id)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);
  CREATE INDEX idx_user_info_phone_id ON user_info (phone_id ASC);

DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user (
  id INT NOT NULL AUTO_INCREMENT,
  office_id INT NOT NULL,
  user_info_id INT NOT NULL,
  document_id INT NULL,
  citizenship_id INT NULL,
  is_identified BOOL NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_office_id FOREIGN KEY (office_id)
    REFERENCES office (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_user_info_id FOREIGN KEY (user_info_id)
    REFERENCES user_info (id)
    ON DELETE CASCADE
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
  CREATE INDEX idx_user_info_id ON user (user_info_id ASC);
  CREATE INDEX idx_document_id ON user (document_id ASC);
  CREATE INDEX idx_citizenship_id ON user (citizenship_id ASC);
