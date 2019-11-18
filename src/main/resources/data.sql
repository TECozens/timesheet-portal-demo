insert into contractor (id, contractor_name, agency_id, timesheet_id ) values (1,'Joe',1,1);
insert into contractor (id, contractor_name, agency_id, timesheet_id  ) values (2,'Bill',2,2);
//
insert into agency (id, agency_name ) values (1,'Agency1');
insert into agency (id, agency_name ) values (2,'Agency2');
//

insert into days_worked (id, monday, tuesday, wednesday, thursday, friday  ) values (1, 28/07/2016, 29/07/2016, 30/07/2016, 24/08/2016, 22/08/2016);
insert into days_worked (id, monday, tuesday, wednesday, thursday, friday  ) values (2, 28/08/2016, 29/08/2016, 30/08/2016, 15/09/2016, 23/09/2016);

//

insert into timesheet (id, contractor_id ,agency_id, days_worked_id, approved ) values (1,1,1,1,null);
insert into timesheet (id, contractor_id ,agency_id, days_worked_id, approved ) values (2,2,2,2,null);