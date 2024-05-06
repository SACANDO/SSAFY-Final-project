-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `user_seq` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(100) NOT NULL,
  `user_pwd` VARCHAR(100) NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `user_nick` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `total_distance` DOUBLE NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_seq`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ) ,
  UNIQUE INDEX `user_nick_UNIQUE` (`user_nick` ) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `group_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `group_seq_UNIQUE` (`id` ) ,
  UNIQUE INDEX `group_name_UNIQUE` (`group_name` ) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Group_memeber_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Group_memeber_info` (
  `group_id` INT NOT NULL,
  `user_seq` INT NOT NULL,
  PRIMARY KEY (`group_id`, `user_seq`),
  INDEX `fk_Group_memeber_info_User1_idx` (`user_seq` ) ,
  CONSTRAINT `fk_Group_memeber_info_Group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `mydb`.`Group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Group_memeber_info_User1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `mydb`.`User` (`user_seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`records`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`records` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `distance` DOUBLE NOT NULL,
  `run_time` DOUBLE NOT NULL,
  `pace` DOUBLE NOT NULL,
  `user_seq` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_records_User1_idx` (`user_seq` ) ,
  CONSTRAINT `fk_records_User1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `mydb`.`User` (`user_seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user_record`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user_record` (
  `user_seq` INT NOT NULL,
  `rank` INT NOT NULL,
  `currency` INT NOT NULL,
  `total_distance` DOUBLE NOT NULL,
  `highest_speed` DOUBLE NOT NULL,
  PRIMARY KEY (`user_seq`),
  INDEX `fk_record2_User1_idx` (`user_seq` ) ,
  UNIQUE INDEX `rank_UNIQUE` (`rank` ) ,
  UNIQUE INDEX `User_seq_UNIQUE` (`user_seq` ) ,
  CONSTRAINT `fk_record2_User1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `mydb`.`User` (`user_seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Rival_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Rival_info` (
  `user_seq` INT NOT NULL,
  `rival_seq` INT NOT NULL,
  PRIMARY KEY (`user_seq`, `rival_seq`),
  INDEX `fk_Rival_info_User2_idx` (`rival_seq` ) ,
  CONSTRAINT `fk_Rival_info_User1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `mydb`.`User` (`user_seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Rival_info_User2`
    FOREIGN KEY (`rival_seq`)
    REFERENCES `mydb`.`User` (`user_seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`badge`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`badge` (
  `id` VARCHAR(100) NOT NULL,
  `badge_name` VARCHAR(100) NOT NULL,
  `badge_type` VARCHAR(45) NOT NULL,
  `obtained_at` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `badge_name_UNIQUE` (`badge_name` ) ,
  UNIQUE INDEX `id_UNIQUE` (`id` ) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User_Badges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User_Badges` (
  `badges_id` VARCHAR(100) NOT NULL,
  `user_seq` INT NOT NULL,
  PRIMARY KEY (`badges_id`, `user_seq`),
  INDEX `fk_User_Badges_badges1_idx` (`badges_id` ) ,
  INDEX `fk_User_Badges_user_record1_idx` (`user_seq` ) ,
  CONSTRAINT `fk_User_Badges_badges1`
    FOREIGN KEY (`badges_id`)
    REFERENCES `mydb`.`badge` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Badges_user_record1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `mydb`.`user_record` (`user_seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
