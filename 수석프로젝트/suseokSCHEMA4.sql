-- -----------------------------------------------------
-- Schema suseok
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `suseok` DEFAULT CHARACTER SET utf8 ;
USE `suseok` ;

-- -----------------------------------------------------
-- Table `suseok`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `suseok`.`User` (
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
  UNIQUE INDEX `user_id_UNIQUE` (`user_id`),
  UNIQUE INDEX `user_nick_UNIQUE` (`user_nick`),
  UNIQUE INDEX `email_UNIQUE` (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `suseok`.`Group`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `suseok`.`Group` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `group_name` VARCHAR(100) NOT NULL,
  `group_admin` INT NOT NULL,
  `goal_pace` DOUBLE NULL DEFAULT 0,
  `goal_frequency` DOUBLE NULL DEFAULT 0,
  `goal_total_distance` DOUBLE NULL DEFAULT 0,
  `pace` DOUBLE NULL DEFAULT 0,
  `total_distance` DOUBLE NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `group_name_UNIQUE` (`group_name`),
  INDEX `fk_Group_User1_idx` (`group_admin`),
  CONSTRAINT `fk_Group_User1`
    FOREIGN KEY (`group_admin`)
    REFERENCES `suseok`.`User` (`user_seq`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `suseok`.`Group_member_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `suseok`.`Group_member_info` (
  `group_id` INT NOT NULL,
  `user_seq` INT NOT NULL,
  PRIMARY KEY (`group_id`, `user_seq`),
  INDEX `fk_Group_member_info_User1_idx` (`user_seq`),
  CONSTRAINT `fk_Group_member_info_Group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `suseok`.`Group` (`id`),
  CONSTRAINT `fk_Group_member_info_User1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `suseok`.`User` (`user_seq`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `suseok`.`records`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `suseok`.`records` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `distance` DOUBLE NOT NULL,
  `run_time` DOUBLE NOT NULL,
  `pace` DOUBLE NOT NULL,
  `user_seq` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_records_User1_idx` (`user_seq`),
  CONSTRAINT `fk_records_User1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `suseok`.`User` (`user_seq`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `suseok`.`user_rank_record`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `suseok`.`user_rank_record` (
  `user_seq` INT NOT NULL,
  `frequency` DOUBLE NOT NULL,
  `total_distance` DOUBLE NOT NULL,
  `highest_speed` DOUBLE NOT NULL,
  PRIMARY KEY (`user_seq`),
  INDEX `fk_user_rank_record_User1_idx` (`user_seq`),
  CONSTRAINT `fk_user_rank_record_User1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `suseok`.`User` (`user_seq`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `suseok`.`Rival_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `suseok`.`Rival_info` (
  `user_seq` INT NOT NULL,
  `rival_seq` INT NOT NULL,
  PRIMARY KEY (`user_seq`, `rival_seq`),
  INDEX `fk_Rival_info_User2_idx` (`rival_seq`),
  CONSTRAINT `fk_Rival_info_User1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `suseok`.`User` (`user_seq`),
  CONSTRAINT `fk_Rival_info_User2`
    FOREIGN KEY (`rival_seq`)
    REFERENCES `suseok`.`User` (`user_seq`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `suseok`.`badge`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `suseok`.`badge` (
  `badge_name` VARCHAR(100) NOT NULL,
  `badge_type` VARCHAR(45) NOT NULL,
  INDEX `badge_name_badge_type_idx` (`badge_name`, `badge_type`),
  PRIMARY KEY (`badge_name`, `badge_type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `suseok`.`User_Badges`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `suseok`.`User_Badges` (
  `user_seq` INT NOT NULL,
  `badge_name` VARCHAR(100) NOT NULL,
  `badge_type` VARCHAR(45) NOT NULL,
	`obtained_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  INDEX `fk_User_Badges_User1_idx` (`user_seq`),
  INDEX `fk_User_Badges_badge1_idx` (`badge_name`, `badge_type`),
  CONSTRAINT `fk_User_Badges_User1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `suseok`.`User` (`user_seq`),
  CONSTRAINT `fk_User_Badges_badge1`
    FOREIGN KEY (`badge_name`, `badge_type`)
    REFERENCES `suseok`.`badge` (`badge_name`, `badge_type`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `suseok`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `suseok`.`board` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `group_id` INT NOT NULL,
  `writer_seq` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `content` TEXT NOT NULL,
  `img` VARCHAR(45) NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `notice` BIT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_board_User1_idx` (`writer_seq`),
  INDEX `fk_board_Group1_idx` (`group_id`),
  CONSTRAINT `fk_board_User1`
    FOREIGN KEY (`writer_seq`)
    REFERENCES `suseok`.`User` (`user_seq`),
  CONSTRAINT `fk_board_Group1`
    FOREIGN KEY (`group_id`)
    REFERENCES `suseok`.`Group` (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `suseok`.`reply`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `suseok`.`reply` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `board_id` INT NOT NULL,
  `writer_seq` INT NOT NULL,
  `content` TEXT NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `fk_reply_board1_idx` (`board_id`),
  INDEX `fk_reply_User1_idx` (`writer_seq`),
  CONSTRAINT `fk_reply_board1`
    FOREIGN KEY (`board_id`)
    REFERENCES `suseok`.`board` (`id`),
  CONSTRAINT `fk_reply_User1`
    FOREIGN KEY (`writer_seq`)
    REFERENCES `suseok`.`User` (`user_seq`))
ENGINE = InnoDB;

