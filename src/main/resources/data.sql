insert into contractor (id, contractor_name, agency_id, timesheet_id ) values (1,'Joe',1,1);
insert into contractor (id, contractor_name, agency_id, timesheet_id  ) values (2,'Bill',2,2);
//
insert into agency (id, agency_name ) values (1,'Agency1');
insert into agency (id, agency_name ) values (2,'Agency2');
//

insert into days_worked (id, monday, tuesday, wednesday, thursday, friday  ) values (1, '2016-07-28', '2016-07-29', '2016-07-30', '2016-08-24', '2016-08-22');
insert into days_worked (id, monday, tuesday, wednesday, thursday, friday  ) values (2, '2016-08-28', '2016-08-29', '2016-08-30', '2016-09-15', '2016-09-23');

//

insert into timesheet (id, contractor_id ,agency_id, days_worked_id, approved ) values (1,1,1,1,null);
insert into timesheet (id, contractor_id ,agency_id, days_worked_id, approved ) values (2,2,2,2,null);