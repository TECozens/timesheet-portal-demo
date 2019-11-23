SET MODE MySQL;
SET IGNORECASE=TRUE;

-- -----------------------------------------------------
-- Table `contractor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contractor` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `contractor_name` VARCHAR(45) NOT NULL,
    `email` VARCHAR(50) NOT NULL, --
    `agency_id` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `agency`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agency` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `agency_name` VARCHAR(45) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Timesheet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timesheet` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `contractor_id` INT UNSIGNED NOT NULL,
    `agency_id` INT UNSIGNED NOT NULL,
    `days_worked` INT NOT NULL,
    `overtime` INT,
    `week_finish` DATE NOT NULL,
     PRIMARY KEY (`id`))
 ENGINE = InnoDB;

