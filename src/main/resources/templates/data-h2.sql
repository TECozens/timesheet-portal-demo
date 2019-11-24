

INSERT INTO contractor (id, contractor_name, email, agency_id) VALUES (1,'Joe Doe', 'xxx@gmail.com', 1);
INSERT INTO contractor (id, contractor_name, email, agency_id) VALUES (2,'John Smith', '123@gmail.com', 2);

INSERT INTO agency (id, agency_name, email) VALUES (1,'agency1', 'xxx@hotmail.com');
INSERT INTO agency (id, agency_name, email) VALUES (2,'agency2', 'xxx@sky.com');


INSERT INTO timesheet (id, contractor_id, agency_id, days_worked, overtime, week_finish) VALUES (1, 1, 1, 5, 1, '12/12/2019');
INSERT INTO timesheet (id, contractor_id, agency_id, days_worked, overtime, week_finish) VALUES (2, 2, 2, 4, 2, '12/11/2019');

INSERT INTO user (username, password) VALUES ('Mo','{bcrypt}$2a$10$uNPfREQnwmaFYwWpyNWXIOCivEO3JlRa.lBUKg05VwUxph1L6muUy'); -- motsp
INSERT INTO user (username, password) VALUES ('Laura','{bcrypt}$2a$10$hF/OfRLdgRqSdUyhaezAWe5YzlnSN71dbitw8DGQEBXyI5cp2U5yG'); -- ltsp
INSERT INTO user (username, password) VALUES ('Tomas','{bcrypt}$2a$10$1qtcvCeJFhq9EdQmWhurn.CVAgslKWug0sAOlJ3Z7HwwDoYcIY5/S'); -- tomtsp
INSERT INTO user (username, password) VALUES ('Tzavier', '{bcrypt}$2a$10$NZNWWhljpNuBnjH9hEDW6OTRlXmZCaFChaWdlA5imyuxPzL/VxjUG'); -- tzatsp

INSERT INTO user_role (userid, role) VALUES (001, 'ROLE_USER');
INSERT INTO user_role (userid, role) VALUES (002, 'ROLE_ADMIN');
INSERT INTO user_role (userid, role) VALUES (003, 'ROLE_USER');
INSERT INTO user_role (userid, role) VALUES (004, 'ROLE_ADMIN');

