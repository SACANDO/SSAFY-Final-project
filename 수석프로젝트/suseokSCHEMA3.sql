
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
  `user_nick` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
  `address` VARCHAR(150) NULL,
  `img` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `exposure` BIT NOT NULL,
  PRIMARY KEY (`user_seq`),
  UNIQUE INDEX `Usercol_UNIQUE` (`user_id` ASC) ,
  UNIQUE INDEX `user_nick_UNIQUE` (`user_nick` ASC) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `group_name` VARCHAR(100) NOT NULL,
  `group_admin` INT NOT NULL,
  `goal_pace` DOUBLE NULL DEFAULT 0,
  `goal_currency` DOUBLE NULL DEFAULT 0,
  `goal_total_distance` DOUBLE NULL DEFAULT 0,
  `con_pace` DOUBLE NULL DEFAULT 0,
  `con_currency` DOUBLE NULL DEFAULT 0,
  `con_total_distance` DOUBLE NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `group_name_UNIQUE` (`group_name` ASC) ,
  INDEX `fk_Group_User1_idx` (`group_leader` ASC) ,
  CONSTRAINT `fk_Group_User1`
    FOREIGN KEY (`group_leader`)
    REFERENCES `mydb`.`User` (`user_seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Group_memeber_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Group_memeber_info` (
  `group_id` INT NOT NULL,
  `user_seq` INT NOT NULL,
  PRIMARY KEY (`group_id`, `user_seq`),
  INDEX `fk_Group_memeber_info_User1_idx` (`user_seq` ASC) ,
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
  INDEX `fk_records_User1_idx` (`user_seq` ASC) ,
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
  `currency` DOUBLE NOT NULL,
  `total_distance` DOUBLE NOT NULL,
  `highest_speed` DOUBLE NOT NULL,
  PRIMARY KEY (`user_seq`),
  INDEX `fk_record2_User1_idx` (`user_seq` ASC) ,
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
  INDEX `fk_Rival_info_User2_idx` (`rival_seq` ASC) ,
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
  UNIQUE INDEX `badge_name_UNIQUE` (`badge_name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User_Badges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User_Badges` (
  `badges_id` VARCHAR(100) NOT NULL,
  `user_seq` INT NOT NULL,
  PRIMARY KEY (`badges_id`, `user_seq`),
  INDEX `fk_User_Badges_badges1_idx` (`badges_id` ASC) ,
  INDEX `fk_User_Badges_user_record1_idx` (`user_seq` ASC) ,
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


-- -----------------------------------------------------
-- Table `mydb`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`board` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `writer_seq` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `img` VARCHAR(45) NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `notice` BIT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_board_User1_idx` (`writer_seq` ASC) ,
  CONSTRAINT `fk_board_User1`
    FOREIGN KEY (`writer_seq`)
    REFERENCES `mydb`.`User` (`user_seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`reply`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`reply` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `board_id` INT NOT NULL,
  `writer_seq` INT NOT NULL,
  `content` TEXT NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_reply_board1_idx` (`board_id` ASC) ,
  INDEX `fk_reply_User1_idx` (`writer_seq` ASC) ,
  CONSTRAINT `fk_reply_board1`
    FOREIGN KEY (`board_id`)
    REFERENCES `mydb`.`board` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reply_User1`
    FOREIGN KEY (`writer_seq`)
    REFERENCES `mydb`.`User` (`user_seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

