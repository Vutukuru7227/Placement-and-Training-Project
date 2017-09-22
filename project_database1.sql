-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema placement
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema placement
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS `placement` DEFAULT CHARACTER SET latin1 ;
USE `placement` ;

-- -----------------------------------------------------
-- Table `placement`.`registration`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `placement`.`registration` (
  `email_id` VARCHAR(50) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `admin_status` INT NULL DEFAULT 0,
  `member_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `placement`.`employer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `placement`.`employer` (
  `email_id` VARCHAR(45) NULL,
  `company_name` VARCHAR(80) NOT NULL,
  `department` VARCHAR(80) NULL,
  `emp_id` INT NOT NULL AUTO_INCREMENT,
  INDEX `email_id_idx` (`email_id` ASC),
  PRIMARY KEY (`emp_id`),
  CONSTRAINT `email_id`
    FOREIGN KEY (`email_id`)
    REFERENCES `placement`.`registration` (`email_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `placement`.`job_postings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `placement`.`job_postings` (
  `job_id` INT NOT NULL AUTO_INCREMENT,
  `emp_id` INT NULL,
  `job_title` VARCHAR(150) NOT NULL,
  `job_description` VARCHAR(500) NULL,
  `deadline` DATE NULL,
  PRIMARY KEY (`job_id`),
  INDEX `emp_id_idx` (`emp_id` ASC),
  CONSTRAINT `emp_id`
    FOREIGN KEY (`emp_id`)
    REFERENCES `placement`.`employer` (`emp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `placement`.`user_primary`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `placement`.`user_primary` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `email_id` VARCHAR(45) NULL,
  `address` VARCHAR(200) NULL,
  `phone_no` VARCHAR(12) NOT NULL,
  `zip_code` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`),
  INDEX `email_id_idx` (`email_id` ASC),
  CONSTRAINT `email_id1`
    FOREIGN KEY (`email_id`)
    REFERENCES `placement`.`registration` (`email_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `placement`.`user_education`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `placement`.`user_education` (
  `user_id` INT NOT NULL,
  `institution` VARCHAR(100) NOT NULL,
  `level` VARCHAR(45) NOT NULL,
  `gpa` FLOAT NULL,
  `major` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `placement`.`user_primary` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `placement`.`category_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `placement`.`category_table` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`category_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `placement`.`skills_table`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `placement`.`skills_table` (
  `skill_id` INT NOT NULL,
  `skill_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`skill_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `placement`.`user_skills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `placement`.`user_skills` (
  `user_id` INT NULL,
  `category` VARCHAR(45) NULL,
  `skills` VARCHAR(100) NULL,
  `category_id` INT NULL,
  `skill_id` INT NULL,
  INDEX `user_id_idx` (`user_id` ASC),
  INDEX `category_id_idx` (`category_id` ASC),
  INDEX `skill_id_idx` (`skill_id` ASC),
  CONSTRAINT `user_id1`
    FOREIGN KEY (`user_id`)
    REFERENCES `placement`.`user_primary` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `placement`.`category_table` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `skill_id`
    FOREIGN KEY (`skill_id`)
    REFERENCES `placement`.`skills_table` (`skill_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `placement`.`application_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `placement`.`application_details` (
  `user_id` INT NULL,
  `job_id` INT NULL,
  PRIMARY KEY (`user_id`, `job_id`),
  INDEX `job_id_idx` (`job_id` ASC),
  CONSTRAINT `user_id2`
    FOREIGN KEY (`user_id`)
    REFERENCES `placement`.`user_primary` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `job_id`
    FOREIGN KEY (`job_id`)
    REFERENCES `placement`.`job_postings` (`job_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `placement`.`user_application`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `placement`.`user_application` (
  `application_id` INT NOT NULL,
  `user_id` INT NULL,
  `application_date` DATE NULL,
  PRIMARY KEY (`application_id`, `user_id`),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `user_id3`
    FOREIGN KEY (`user_id`)
    REFERENCES `placement`.`user_primary` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `placement`.`user_work_experience` (
  `user_id` INT NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `organization_name` VARCHAR(45) NOT NULL,
  `location` VARCHAR(50),
  `exp_from` INT,
  `exp_to` INT,
  `achievements` VARCHAR(200),
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_id5`
    FOREIGN KEY (`user_id`)
    REFERENCES `placement`.`user_primary` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
Alter table `placement`.`user_education` add column `edu_from` int,add column`edu_to` int;

Alter table `placement`.`employer` add column `comp_address` varchar(200),add column `comp_website` varchar(200), add column `comp_zip` varchar(45);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
