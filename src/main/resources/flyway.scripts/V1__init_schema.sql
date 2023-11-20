-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema space_travel
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema space_travel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `space_travel` DEFAULT CHARACTER SET utf8 ;
USE `space_travel` ;

-- -----------------------------------------------------
-- Table `space_travel`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `space_travel`.`clients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `space_travel`.`planets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `space_travel`.`planets` (
  `id` VARCHAR(10) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `space_travel`.`tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `space_travel`.`tickets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created_at` TIMESTAMP NOT NULL,
  `client_id` INT NOT NULL,
  `from_planet_id` VARCHAR(10) NOT NULL,
  `to_planet_id` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `client_key_idx` (`client_id` ASC) VISIBLE,
  INDEX `planet_to_idx` (`to_planet_id` ASC) VISIBLE,
  INDEX `planet_from_key_idx` (`from_planet_id` ASC) VISIBLE,
  CONSTRAINT `client_key`
    FOREIGN KEY (`client_id`)
    REFERENCES `space_travel`.`clients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `planet_to_key`
    FOREIGN KEY (`to_planet_id`)
    REFERENCES `space_travel`.`planets` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `planet_from_key`
    FOREIGN KEY (`from_planet_id`)
    REFERENCES `space_travel`.`planets` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
