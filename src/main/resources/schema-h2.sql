SET MODE MySQL;
SET IGNORECASE=TRUE;

-- -----------------------------------------------------
-- Table `contractor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contractor` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `contractor_name` VARCHAR(45) NOT NULL,
    `email` VARCHAR(50) NOT NULL, -- TODO Email ?
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
    `email` VARCHAR(50) NOT NULL, -- TODO Email ?
    PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Timesheet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timesheet` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `contractor_id` INT UNSIGNED NOT NULL,
    `agency_id` INT UNSIGNED NOT NULL,
    `days_worked_id`INT UNSIGNED NOT NULL,
    `overtime` INT UNSIGNED, -- TODO Make sure this is on form/entity
    `week_finish` DATE NOT NULL, -- TODO Is this needed?
    `approved` BOOLEAN, -- TODO Alter attributes for this
     PRIMARY KEY (`id`))
 ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DaysWorked`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `days_worked` (
     `id` INT UNSIGNED NOT NULL AUTO_INCREMENT, -- TODO Make these INT ?
     `monday` DATE,
     `tuesday` DATE,
     `wednesday` DATE,
     `thursday` DATE,
     `friday` DATE,
     PRIMARY KEY (`id`))
 ENGINE = InnoDB;