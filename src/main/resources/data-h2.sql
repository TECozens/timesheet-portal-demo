

INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (1,'Mo','Muhammad','Ahmad','AhmadM@Admiral.co.uk',
'{bcrypt}$2a$10$B188I9BfwGLsWGU9eF4wPOV6O6z.MgEbNxcErNEKb8xwM.4ChBT7G'); -- password
INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (2,'Laura','Laura','Camilleri','CamilleriL@Admiral.co.uk',
'{bcrypt}$2a$10$hF/OfRLdgRqSdUyhaezAWe5YzlnSN71dbitw8DGQEBXyI5cp2U5yG'); -- ltsp
INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (3,'Tomas','Tomas','Cozens','CozensT@Admiral.co.uk',
'{bcrypt}$2a$10$1qtcvCeJFhq9EdQmWhurn.CVAgslKWug0sAOlJ3Z7HwwDoYcIY5/S'); -- tomtsp
INSERT INTO user (id, username, firstname, surname, email, password)
VALUES (4,'Tzavier','Tzavier','Randle-Jolliffe','Randle-JolliffeT@Admiral.co.uk',
'{bcrypt}$2a$10$NZNWWhljpNuBnjH9hEDW6OTRlXmZCaFChaWdlA5imyuxPzL/VxjUG'); -- tzatsp


INSERT INTO agency (id, agency_name, email) VALUES (1L, 'agency1', 'xxx@hotmail.com');
INSERT INTO agency (id, agency_name, email) VALUES (2L, 'agency2', 'xxx@sky.com');


INSERT INTO contractor (id, user_id, agency_id) VALUES (1L, 1, 1);

INSERT INTO timesheet (id, contractor_id, days_worked, overtime, week_finish) VALUES (1L, 1, 5, 1, '2019-11-10');
INSERT INTO timesheet (id, contractor_id, days_worked, overtime, week_finish) VALUES (2L, 1, 4, 2, '2019-11-17');

INSERT INTO user_role (userid, role) VALUES (001, 'ROLE_CONTRACTOR');
INSERT INTO user_role (userid, role) VALUES (002, 'ROLE_ADMIN');
INSERT INTO user_role (userid, role) VALUES (003, 'ROLE_MANAGER');
INSERT INTO user_role (userid, role) VALUES (004, 'ROLE_ADMIN');