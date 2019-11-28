SET MODE MySQL;
SET IGNORECASE=TRUE;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user`
(
    `id`       int(11)      NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45)  NOT NULL,
    `firstname` VARCHAR(45)  NOT NULL,
    `surname` VARCHAR(45)  NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`)
)
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
-- Table `contractor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contractor` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `user_id` INT UNSIGNED NOT NULL,
    `agency_id` INT UNSIGNED NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    FOREIGN KEY (`agency_id`) REFERENCES `agency`(`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `timesheet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `timesheet` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `contractor_id` INT UNSIGNED NOT NULL,
    `days_worked` INT NOT NULL,
    `overtime` INT,
    `week_finish` DATE NOT NULL,
     PRIMARY KEY (`id`))
 ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `User Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_role`
(
    `id`     int(11)     NOT NULL AUTO_INCREMENT,
    `userid` int(11)     NOT NULL,
    `role`   varchar(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;
