SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
/* Determines whether the server should check that a referenced table exists when
 defining a foreign key. Due to potential circular references, this check must
 be turned off for the duration of the import, to permit defining foreign keys. */
 
DROP SCHEMA IF EXISTS tsap;

CREATE SCHEMA IF NOT EXISTS tsap;

USE tsap;

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
    `user_id` INT (11) NOT NULL,
    `agency_id` INT UNSIGNED NOT NULL,
    `manager_id` INT (11) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`),
    FOREIGN KEY (`manager_id`) REFERENCES `user`(`id`),
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
     PRIMARY KEY (`id`)
     )
 ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `review`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `review`
(
    `id`       int(11)      NOT NULL AUTO_INCREMENT,
    `timesheet_id` INT UNSIGNED NOT NULL,
    `approved` BIT,
    `paid` BIT,
    `message` VARCHAR (70),
    `communication_rating` INT UNSIGNED,
    `tech_skills_rating` INT UNSIGNED,
    `quality_rating` INT UNSIGNED,
    `initiative_rating` INT UNSIGNED,
    `productivity_rating` INT UNSIGNED,
    `working_relationships_rating` INT UNSIGNED,
    FOREIGN KEY (`timesheet_id`) REFERENCES `timesheet`(`id`),
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `user role`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `user_role`
(
    `id`     int(11)     NOT NULL AUTO_INCREMENT,
    `userid` int(11)     NOT NULL,
    `role`   varchar(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `confirmation token`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `confirmation_token`
(
    `token_id`       int(11)      NOT NULL AUTO_INCREMENT,
    `confirmation_token` VARCHAR(100),
    `created` DATE,
    `user_id` int(11),
    PRIMARY KEY (`token_id`)
)
    ENGINE = InnoDB;

-- Inserting new users into the user table 

TRUNCATE TABLE user;

INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (1,'Mo','Muhammad','Ahmad','HajiAhmadmm@cardiff.ac.uk',
'{bcrypt}$2a$10$B188I9BfwGLsWGU9eF4wPOV6O6z.MgEbNxcErNEKb8xwM.4ChBT7G'); # password
INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (2,'Laura','Laura','Camilleri','CamilleriL2@cardiff.ac.uk',
'{bcrypt}$2a$10$hF/OfRLdgRqSdUyhaezAWe5YzlnSN71dbitw8DGQEBXyI5cp2U5yG'); # ltsp
INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (3,'Tomas','Tomas','Cozens','CozensTE@cardiff.ac.uk',
'{bcrypt}$2a$10$1qtcvCeJFhq9EdQmWhurn.CVAgslKWug0sAOlJ3Z7HwwDoYcIY5/S'); # tomtsp
INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (4,'Tzavier','Tzavier','Randle-Jolliffe','Randle-JolliffeT@Cardiff.ac.uk',
'{bcrypt}$2a$10$NZNWWhljpNuBnjH9hEDW6OTRlXmZCaFChaWdlA5imyuxPzL/VxjUG'); # tzatsp
INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (5,'Carl','Jones','Carl-Jones','Randle-JolliffeT@Cardiff.ac.uk',
'{bcrypt}$2a$10$B188I9BfwGLsWGU9eF4wPOV6O6z.MgEbNxcErNEKb8xwM.4ChBT7G'); # password
INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (6,'Reggie','Mikes','Reggie-Mikes','Randle-JolliffeT@Cardiff.ac.uk',
'{bcrypt}$2a$10$B188I9BfwGLsWGU9eF4wPOV6O6z.MgEbNxcErNEKb8xwM.4ChBT7G'); # password
INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (7,'Kevin','Kevin','Anstead','Randle-JolliffeT@Cardiff.ac.uk',
'{bcrypt}$2a$10$B188I9BfwGLsWGU9eF4wPOV6O6z.MgEbNxcErNEKb8xwM.4ChBT7G'); # password
INSERT INTO user(id,username,firstname,surname,email,password)
VALUES (8,'Robot','Robert','Stone','hajiahmadmm@gmail.com',
        '{bcrypt}$2a$10$B188I9BfwGLsWGU9eF4wPOV6O6z.MgEbNxcErNEKb8xwM.4ChBT7G');

-- Inserting new agencies into the agency table--

TRUNCATE TABLE agency;

INSERT INTO agency (id, agency_name, email) VALUES (1, 'agency1', 'xxx@hotmail.com');
INSERT INTO agency (id, agency_name, email) VALUES (2, 'agency2', 'xxx@sky.com');
INSERT INTO agency (id, agency_name, email) VALUES (3, 'agency3', 'xxx@hotmail.com');
INSERT INTO agency (id, agency_name, email) VALUES (4, 'agency4', 'xxx@sky.com');

-- Inserting new contractors into the contractor table--

TRUNCATE TABLE contractor;

INSERT INTO contractor (id, user_id, agency_id, manager_id) VALUES (1, 1, 1, 3);
INSERT INTO contractor (id, user_id, agency_id, manager_id) VALUES (2, 7, 3, 5);

-- Inserting new time sheets into the timesheet table--

TRUNCATE TABLE timesheet;

INSERT INTO timesheet (id, contractor_id, days_worked, overtime, week_finish) VALUES (1, 1, 5, 1, '2019-11-10');
INSERT INTO timesheet (id, contractor_id, days_worked, overtime, week_finish) VALUES (2, 1, 4, 2, '2019-11-17');
INSERT INTO timesheet (id, contractor_id, days_worked, overtime, week_finish) VALUES (3, 2, 2, 2, '2019-11-10');
INSERT INTO timesheet (id, contractor_id, days_worked, overtime, week_finish) VALUES (4, 2, 1, 4, '2019-11-17');

-- Inserting new reviews into the review table--

TRUNCATE TABLE review;

INSERT INTO review (id, timesheet_id, approved, paid, message, communication_rating, tech_skills_rating,
                    quality_rating, initiative_rating, productivity_rating, working_relationships_rating)
            VALUES (1, 1, TRUE, FALSE , 'Fake message cos this is perfectly fine', 3, 3, 3, 3, 3, 3);

INSERT INTO review (id, timesheet_id, approved, paid, message, communication_rating, tech_skills_rating,
                    quality_rating, initiative_rating, productivity_rating, working_relationships_rating)
            VALUES (2, 3, TRUE, FALSE , 'Fake message cos this is perfectly fine', 3, 3, 3, 3, 3, 3);

-- Inserting a new user roles to users into the user role table--

TRUNCATE TABLE user_role;

INSERT INTO user_role (userid, role) VALUES (001, 'ROLE_CONTRACTOR');
INSERT INTO user_role (userid, role) VALUES (002, 'ROLE_ADMIN');
INSERT INTO user_role (userid, role) VALUES (003, 'ROLE_MANAGER');
INSERT INTO user_role (userid, role) VALUES (004, 'ROLE_ADMIN');
INSERT INTO user_role (userid, role) VALUES (005, 'ROLE_MANAGER');
INSERT INTO user_role (userid, role) VALUES (006, 'ROLE_MANAGER');
INSERT INTO user_role (userid, role) VALUES (007, 'ROLE_CONTRACTOR');
INSERT INTO user_role (userid, role) VALUES (008, 'ROLE_CONTRACTOR');

-- This query finds all timesheets where less than 3 days have been worked --

SELECT * FROM timeSheet 
WHERE days_worked < 3;

-- This test query finds all contractors under the agency with an id of 1 --

SELECT * FROM contractor WHERE agency_id = 1; 

-- This test query finds the userids of all managers --

SELECT * FROM user_role WHERE role = 'ROLE_MANAGER'; 

-- Stored procedure to find all agencies --

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `FIND_AGENCY_ALL`()
BEGIN
    SELECT *
    FROM agency;
END $$

-- Stored procedure to find all contractors --

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `FIND_CONTRACTOR_ALL`()
BEGIN
    SELECT *
    FROM contractor;
END $$

-- Stored procedure to find all reviews --

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `FIND_REVIEW_ALL`()
BEGIN
    SELECT *
    FROM review;
END $$

-- Stored procedure to find all time sheets --

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `FIND_TIMESHEET_ALL`()
BEGIN
    SELECT *
    FROM timesheet;
END $$

-- Stored procedure to find all users --

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `FIND_USER_ALL`()
BEGIN
    SELECT *
    FROM user;
END $$

-- Stored procedure, trigger and error handling for email --

DROP TRIGGER IF EXISTS validateEmailAddressOnInsert;

DELIMITER $$
CREATE TRIGGER validateEmailAddressOnInsert
BEFORE INSERT ON user FOR EACH ROW
	BEGIN
		   IF NEW.email = '' THEN
				SIGNAL SQLSTATE VALUE '45000'
				SET MESSAGE_TEXT = 'Email address provided is empty. Please check your entry and try again.';
			ELSEIF NEW.email NOT LIKE '%_@%_.__%' THEN
				SIGNAL SQLSTATE VALUE '45000'
				SET MESSAGE_TEXT = 'Email address is not valid. Please check your entry and try again.';
			END IF;
	END$$
DELIMITER ;

-- Stored procedure, trigger and error handling for new user --

DROP PROCEDURE IF EXISTS validate_user;

DELIMITER $$
CREATE PROCEDURE validate_user(
	IN username VARCHAR(45),
	IN firstname VARCHAR(45),
	IN surname VARCHAR(45),
	IN email VARCHAR(50),
	IN password VARCHAR (100)
)
DETERMINISTIC
NO SQL
BEGIN
		IF username = null THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Must have a username';
		END IF;
		IF NOT (SELECT email REGEXP '$[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$') THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Wrong email';
		END IF;
	END $$
DELIMITER ;

DROP TRIGGER IF EXISTS validate_user_insert;

DELIMITER $$
CREATE TRIGGER validate_user_insert
BEFORE INSERT ON user FOR EACH ROW
BEGIN
	CALL validate_user(NEW.username, NEW.firstname, NEW.surname, NEW.email, NEW.password);
END $$
DELIMITER ;

DROP TRIGGER IF EXISTS validate_user_update;

DELIMITER $$
CREATE TRIGGER validate_user_update
BEFORE UPDATE ON user FOR EACH ROW
BEGIN
	CALL validate_user(NEW.username, NEW.firstname, NEW.surname, NEW.email, NEW.password);
END $$
DELIMITER ;

-- Function to find how many users there are in the system --

DROP FUNCTION IF EXISTS numberOfUsers;

DELIMITER $$

CREATE FUNCTION numberOfUsers()
RETURNS INTEGER
DETERMINISTIC
BEGIN
    
    RETURN (SELECT COUNT(id) FROM user);
    
END $$

DELIMITER ;

Select numberOfUsers() as 'Number of Users';

-- Function fo find how many contractors are assigned to a manager --

DROP FUNCTION IF EXISTS numberOfContractorsAssignedToAManager;

DELIMITER $$

CREATE FUNCTION numberOfContractorsAssignedToAManager()
RETURNS INTEGER
DETERMINISTIC
BEGIN
    
    RETURN (SELECT COUNT(id) FROM contractor WHERE manager_id = 5);
    
END $$

DELIMITER ;

Select numberOfContractorsAssignedToAManager() as 'Number of Contractors';