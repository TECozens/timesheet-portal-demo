

INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (1,'Mo','Muhammad','Ahmad','AhmadM@Admiral.co.uk',
'{bcrypt}$2a$10$B188I9BfwGLsWGU9eF4wPOV6O6z.MgEbNxcErNEKb8xwM.4ChBT7G'); # password
INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (2,'Laura','Laura','Camilleri','CamilleriL@Admiral.co.uk',
'{bcrypt}$2a$10$hF/OfRLdgRqSdUyhaezAWe5YzlnSN71dbitw8DGQEBXyI5cp2U5yG'); # ltsp
INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (3,'Tomas','Tomas','Cozens','CozensT@Admiral.co.uk',
'{bcrypt}$2a$10$1qtcvCeJFhq9EdQmWhurn.CVAgslKWug0sAOlJ3Z7HwwDoYcIY5/S'); # tomtsp
INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (4,'Tzavier','Tzavier','Randle-Jolliffe','Randle-JolliffeT@Admiral.co.uk',
'{bcrypt}$2a$10$NZNWWhljpNuBnjH9hEDW6OTRlXmZCaFChaWdlA5imyuxPzL/VxjUG'); # tzatsp
INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (5,'Carl','Jones','Carl-Jones','Carl-Jones@Admiral.co.uk',
'{bcrypt}$2a$10$B188I9BfwGLsWGU9eF4wPOV6O6z.MgEbNxcErNEKb8xwM.4ChBT7G'); # password
INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (6,'Reggie','Mikes','Reggie-Mikes','Reggie-Mikes@Admiral.co.uk',
'{bcrypt}$2a$10$B188I9BfwGLsWGU9eF4wPOV6O6z.MgEbNxcErNEKb8xwM.4ChBT7G'); # password
INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (7,'Kevin','Kevin','Anstead','AnsteadK@Admiral.co.uk',
'{bcrypt}$2a$10$B188I9BfwGLsWGU9eF4wPOV6O6z.MgEbNxcErNEKb8xwM.4ChBT7G'); # password



INSERT INTO agency (id, agency_name, email) VALUES (1, 'agency1', 'xxx@hotmail.com');
INSERT INTO agency (id, agency_name, email) VALUES (2, 'agency2', 'xxx@sky.com');
INSERT INTO agency (id, agency_name, email) VALUES (3, 'agency3', 'xxx@hotmail.com');
INSERT INTO agency (id, agency_name, email) VALUES (4, 'agency4', 'xxx@sky.com');


INSERT INTO contractor (id, user_id, agency_id, manager_id) VALUES (1, 1, 1, 3);
INSERT INTO contractor (id, user_id, agency_id, manager_id) VALUES (2, 7, 3, 5);

INSERT INTO timesheet (id, contractor_id, days_worked, overtime, week_finish) VALUES (1, 1, 5, 1, '2019-11-10');
INSERT INTO timesheet (id, contractor_id, days_worked, overtime, week_finish) VALUES (2, 1, 4, 2, '2019-11-17');
INSERT INTO timesheet (id, contractor_id, days_worked, overtime, week_finish) VALUES (3, 2, 2, 2, '2019-11-10');
INSERT INTO timesheet (id, contractor_id, days_worked, overtime, week_finish) VALUES (4, 2, 1, 4, '2019-11-17');

INSERT INTO review (id, timesheet_id, approved, paid, message, communication_rating, tech_skills_rating,
                    quality_rating, initiative_rating, productivity_rating, working_relationships_rating)
            VALUES (1, 1, TRUE, FALSE , 'Fake message cos this is perfectly fine', 3, 3, 3, 3, 3, 3);

INSERT INTO review (id, timesheet_id, approved, paid, message, communication_rating, tech_skills_rating,
                    quality_rating, initiative_rating, productivity_rating, working_relationships_rating)
            VALUES (2, 3, TRUE, FALSE , 'Fake message cos this is perfectly fine', 3, 3, 3, 3, 3, 3);

INSERT INTO user_role (userid, role) VALUES (001, 'ROLE_CONTRACTOR');
INSERT INTO user_role (userid, role) VALUES (002, 'ROLE_ADMIN');
INSERT INTO user_role (userid, role) VALUES (003, 'ROLE_MANAGER');
INSERT INTO user_role (userid, role) VALUES (004, 'ROLE_ADMIN');
INSERT INTO user_role (userid, role) VALUES (005, 'ROLE_MANAGER');
INSERT INTO user_role (userid, role) VALUES (006, 'ROLE_MANAGER');
INSERT INTO user_role (userid, role) VALUES (007, 'ROLE_CONTRACTOR');
