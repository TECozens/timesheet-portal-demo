

INSERT INTO contractor (id, contractor_name, email, agency_id) VALUES (1L,'Joe Doe', 'xxx@gmail.com', 1);
INSERT INTO contractor (id, contractor_name, email, agency_id) VALUES (2L,'John Smith', '123@gmail.com', 2);

INSERT INTO agency (id, agency_name, email) VALUES (1L,'agency1', 'xxx@hotmail.com');
INSERT INTO agency (id, agency_name, email) VALUES (2L,'agency2', 'xxx@sky.com');


INSERT INTO timesheet (id, contractor_id, agency_id, days_worked, overtime, week_finish) VALUES (1L, 1, 1, 5, 1, '2019-11-11');
INSERT INTO timesheet (id, contractor_id, agency_id, days_worked, overtime, week_finish) VALUES (2L, 2, 2, 4, 2, '2019-11-12');