SET MODE MySQL;
SET IGNORECASE=TRUE;

-- -----------------------------------------------------
-- Table `contractor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contractor` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `contractor_name` VARCHAR(45) NOT NULL,
    `company` VARCHAR(45) NOT NULL,
    `agency_id` INT UNSIGNED NOT NULL,
    `timesheet_id` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `agency`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `agency` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `agency_name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `timesheet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timesheet` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `contractor_id` INT UNSIGNED NOT NULL,
    `agency_id` INT UNSIGNED NOT NULL,
    `days_worked_id`INT UNSIGNED NOT NULL,
    `approved` INT,
     PRIMARY KEY (`id`))
 ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `daysWorked`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `days_worked` (
     `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
     `monday` Date,
     `tuesday` Date,
     `wednesday` Date,
     `thursday` Date,
     `friday` Date,
     PRIMARY KEY (`id`))
 ENGINE = InnoDB;