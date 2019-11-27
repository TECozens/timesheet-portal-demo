

INSERT INTO contractor (id, contractor_name, email, agency_id) VALUES (1L,'Joe Doe', 'xxx@gmail.com', 1);
INSERT INTO contractor (id, contractor_name, email, agency_id) VALUES (2L,'John Smith', '123@gmail.com', 2);

INSERT INTO agency (id, agency_name, email) VALUES (1L,'agency1', 'xxx@hotmail.com');
INSERT INTO agency (id, agency_name, email) VALUES (2L,'agency2', 'xxx@sky.com');


INSERT INTO timesheet (id, contractor_id, agency_id, days_worked, overtime, week_finish) VALUES (1L, 1, 1, 5, 1, '2019-11-11');
INSERT INTO timesheet (id, contractor_id, agency_id, days_worked, overtime, week_finish) VALUES (2L, 2, 2, 4, 2, '2019-11-12');

INSERT INTO user (username, password) VALUES ('Mo','{bcrypt}$2a$10$B188I9BfwGLsWGU9eF4wPOV6O6z.MgEbNxcErNEKb8xwM.4ChBT7G'); -- password
INSERT INTO user (username, password) VALUES ('Laura','{bcrypt}$2a$10$hF/OfRLdgRqSdUyhaezAWe5YzlnSN71dbitw8DGQEBXyI5cp2U5yG'); -- ltsp
INSERT INTO user (username, password) VALUES ('Tomas','{bcrypt}$2a$10$1qtcvCeJFhq9EdQmWhurn.CVAgslKWug0sAOlJ3Z7HwwDoYcIY5/S'); -- tomtsp
INSERT INTO user (username, password) VALUES ('Tzavier', '{bcrypt}$2a$10$NZNWWhljpNuBnjH9hEDW6OTRlXmZCaFChaWdlA5imyuxPzL/VxjUG'); -- tzatsp

INSERT INTO user_role (userid, role) VALUES (001, 'ROLE_CONTRACTOR');
INSERT INTO user_role (userid, role) VALUES (002, 'ROLE_ADMIN');
INSERT INTO user_role (userid, role) VALUES (003, 'ROLE_MANAGER');
INSERT INTO user_role (userid, role) VALUES (004, 'ROLE_ADMIN');