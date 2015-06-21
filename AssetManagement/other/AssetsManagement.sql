SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema AssetsManagement
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `AssetsManagement` ;
USE `AssetsManagement` ;

-- -----------------------------------------------------
-- Table `AssetsManagement`.`COUNTRY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AssetsManagement`.`COUNTRY` (
  `ID_COUNTRY` BIGINT NOT NULL,
  `NAME` VARCHAR(225) NOT NULL,
  `COUNTRY_CODE` VARCHAR(225) NOT NULL,
  PRIMARY KEY (`ID_COUNTRY`),
  UNIQUE INDEX `NAME_UNIQUE` (`NAME` ASC),
  UNIQUE INDEX `COUNTRY_CODE_UNIQUE` (`COUNTRY_CODE` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AssetsManagement`.`DEPARTMENTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AssetsManagement`.`DEPARTMENTS` (
  `ID_DEPARTMENT` BIGINT NOT NULL AUTO_INCREMENT,
  `ID_COUNTRY` BIGINT NULL,
  `NAME` VARCHAR(225) NOT NULL,
  `LOCATION` VARCHAR(225) NULL,
  `ADDRESS` VARCHAR(225) NULL,
  PRIMARY KEY (`ID_DEPARTMENT`),
  INDEX `fk_Departments_Country1_idx` (`ID_COUNTRY` ASC),
  UNIQUE INDEX `NAME_UNIQUE` (`NAME` ASC),
  CONSTRAINT `fk_Departments_Country1`
    FOREIGN KEY (`ID_COUNTRY`)
    REFERENCES `AssetsManagement`.`COUNTRY` (`ID_COUNTRY`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AssetsManagement`.`USERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AssetsManagement`.`USERS` (
  `ID_USER` BIGINT NOT NULL AUTO_INCREMENT,
  `ID_DEPARTMENT` BIGINT NULL,
  `USERNAME` VARCHAR(225) NOT NULL,
  `FIRST_NAME` VARCHAR(225) NULL,
  `LAST_NAME` VARCHAR(225) NULL,
  `PASSWORD` VARCHAR(225) NULL,
  `EMAIL` VARCHAR(225) NOT NULL,
  `ROLE` VARCHAR(225) NULL,
  PRIMARY KEY (`ID_USER`),
  INDEX `fk_Users_Departments1_idx` (`ID_DEPARTMENT` ASC),
  UNIQUE INDEX `EMAIL_UNIQUE` (`EMAIL` ASC),
  UNIQUE INDEX `USERNAME_UNIQUE` (`USERNAME` ASC),
  CONSTRAINT `fk_Users_Departments1`
    FOREIGN KEY (`ID_DEPARTMENT`)
    REFERENCES `AssetsManagement`.`DEPARTMENTS` (`ID_DEPARTMENT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AssetsManagement`.`ORDERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AssetsManagement`.`ORDERS` (
  `ID_ORDER` BIGINT NOT NULL AUTO_INCREMENT,
  `PRICE` VARCHAR(45) NULL,
  `SUPPLIER_NAME` VARCHAR(225) NULL,
  `PURCHASE_DATE` DATE NULL,
  `IS_RECEIVED` TINYINT(1) NULL,
  PRIMARY KEY (`ID_ORDER`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AssetsManagement`.`ASSETS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AssetsManagement`.`ASSETS` (
  `ID_ASSET` BIGINT NOT NULL AUTO_INCREMENT,
  `ID_USER` BIGINT NULL,
  `ID_ORDER` BIGINT NULL,
  `NAME` VARCHAR(225) NULL,
  `TYPE` VARCHAR(225) NULL,
  `IS_AVAILABLE` TINYINT(1) NULL,
  `IS_ON_STOCK` TINYINT(1) NULL,
  PRIMARY KEY (`ID_ASSET`),
  INDEX `fk_Assets_Users1_idx` (`ID_USER` ASC),
  INDEX `fk_Assets_Orders1_idx` (`ID_ORDER` ASC),
  CONSTRAINT `fk_Assets_Users1`
    FOREIGN KEY (`ID_USER`)
    REFERENCES `AssetsManagement`.`USERS` (`ID_USER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Assets_Orders1`
    FOREIGN KEY (`ID_ORDER`)
    REFERENCES `AssetsManagement`.`ORDERS` (`ID_ORDER`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AssetsManagement`.`TRANSACTIONS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AssetsManagement`.`TRANSACTIONS` (
  `ID_TRANSACTION` BIGINT NOT NULL AUTO_INCREMENT,
  `ID_USER` BIGINT NULL,
  `ID_ASSET` BIGINT NULL,
  `DATE` DATE NULL,
  `STATUS` VARCHAR(225) NULL,
  PRIMARY KEY (`ID_TRANSACTION`),
  INDEX `fk_Transactions_Assets1_idx` (`ID_ASSET` ASC),
  INDEX `fk_Transactions_Users1_idx` (`ID_USER` ASC),
  CONSTRAINT `fk_Transactions_Assets1`
    FOREIGN KEY (`ID_ASSET`)
    REFERENCES `AssetsManagement`.`ASSETS` (`ID_ASSET`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transactions_Users1`
    FOREIGN KEY (`ID_USER`)
    REFERENCES `AssetsManagement`.`USERS` (`ID_USER`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AssetsManagement`.`REQUESTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AssetsManagement`.`REQUESTS` (
  `ID_REQUEST` BIGINT NOT NULL AUTO_INCREMENT,
  `ID_USER` BIGINT NULL,
  `ID_ASSET` BIGINT NULL,
  `START_DATE` DATE NULL,
  `END_DATE` DATE NULL,
  `STATUS` VARCHAR(45) NULL,
  PRIMARY KEY (`ID_REQUEST`),
  INDEX `fk_Requests_Assets1_idx` (`ID_ASSET` ASC),
  INDEX `fk_Requests_Users1_idx` (`ID_USER` ASC),
  CONSTRAINT `fk_Requests_Assets1`
    FOREIGN KEY (`ID_ASSET`)
    REFERENCES `AssetsManagement`.`ASSETS` (`ID_ASSET`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Requests_Users1`
    FOREIGN KEY (`ID_USER`)
    REFERENCES `AssetsManagement`.`USERS` (`ID_USER`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AssetsManagement`.`COMPLAINTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AssetsManagement`.`COMPLAINTS` (
  `ID_COMPLAINT` BIGINT NOT NULL AUTO_INCREMENT,
  `ID_USER` BIGINT NULL,
  `ID_ASSET` BIGINT NULL,
  `TITLE` VARCHAR(225) NULL,
  `DESCRIPTION` VARCHAR(225) NULL,
  `PRIORITY` VARCHAR(45) NULL,
  `STATUS` VARCHAR(45) NULL,
  PRIMARY KEY (`ID_COMPLAINT`),
  INDEX `fk_Complaints_Users1_idx` (`ID_USER` ASC),
  INDEX `fk_Complaints_Assets1_idx` (`ID_ASSET` ASC),
  CONSTRAINT `fk_Complaints_Users1`
    FOREIGN KEY (`ID_USER`)
    REFERENCES `AssetsManagement`.`USERS` (`ID_USER`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Complaints_Assets1`
    FOREIGN KEY (`ID_ASSET`)
    REFERENCES `AssetsManagement`.`ASSETS` (`ID_ASSET`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
