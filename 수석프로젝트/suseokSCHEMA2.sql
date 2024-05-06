
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE database IF NOT EXISTS `mydb`;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `User` (
  `user_seq` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(100) NOT NULL,
  `user_pwd` VARCHAR(100) NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `user_nick` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `total_distance` DOUBLE NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_seq`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) ,
  UNIQUE INDEX `user_nick_UNIQUE` (`user_nick` ASC) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `group_name` VARCHAR(100) NOT NULL,
  `group_leader` int,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `group_name_UNIQUE` (`group_name` ASC),
  CONSTRAINT `fk_Group_User1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `mydb`.`User` (`user_seq`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Group_memeber_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Group_memeber_info` (
  `group_id` INT NOT NULL,
  `user_seq` INT NOT NULL,
  PRIMARY KEY (`group_id`, `user_seq`),
  INDEX `fk_Group_memeber_info_User1_idx` (`user_seq` ASC) ,
  CONSTRAINT `fk_Group_memeber_info_Group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `mydb`.`Group` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Group_memeber_info_User1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `mydb`.`User` (`user_seq`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`records`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `records` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `distance` DOUBLE NOT NULL,
  `run_time` DOUBLE NOT NULL,
  `pace` DOUBLE NOT NULL,
  `user_seq` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_records_User1_idx` (`user_seq` ASC) ,
  CONSTRAINT `fk_records_User1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `mydb`.`User` (`user_seq`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`user_record`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_record` (
  `user_seq` INT NOT NULL,
  `rank` INT NOT NULL,
  `currency` INT NOT NULL,
  `total_distance` DOUBLE NOT NULL,
  `highest_speed` DOUBLE NOT NULL,
  PRIMARY KEY (`user_seq`),
  INDEX `fk_record2_User1_idx` (`user_seq` ASC) ,
  UNIQUE INDEX `rank_UNIQUE` (`rank` ASC) ,
  CONSTRAINT `fk_record2_User1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `mydb`.`User` (`user_seq`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Rival_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Rival_info` (
  `user_seq` INT NOT NULL,
  `rival_seq` INT NOT NULL,
  PRIMARY KEY (`user_seq`, `rival_seq`),
  INDEX `fk_Rival_info_User2_idx` (`rival_seq` ASC) ,
  CONSTRAINT `fk_Rival_info_User1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `mydb`.`User` (`user_seq`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Rival_info_User2`
    FOREIGN KEY (`rival_seq`)
    REFERENCES `mydb`.`User` (`user_seq`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`badge`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `badge` (
  `id` VARCHAR(100) NOT NULL,
  `badge_name` VARCHAR(100) NOT NULL,
  `badge_type` VARCHAR(45) NOT NULL,
  `obtained_at` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `badge_name_UNIQUE` (`badge_name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User_Badges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `User_Badges` (
  `badges_id` VARCHAR(100) NOT NULL,
  `user_seq` INT NOT NULL,
  PRIMARY KEY (`badges_id`, `user_seq`),
  INDEX `fk_User_Badges_badges1_idx` (`badges_id` ASC) ,
  INDEX `fk_User_Badges_user_record1_idx` (`user_seq` ASC) ,
  CONSTRAINT `fk_User_Badges_badges1`
    FOREIGN KEY (`badges_id`)
    REFERENCES `mydb`.`badge` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_User_Badges_user_record1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `mydb`.`user_record` (`user_seq`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

select * from badge;
select * from `group`;
select * from group_member_info;
select * from records;
select * from rival_info;
select * from user;
select * from user_badges;
select * from user_record;

