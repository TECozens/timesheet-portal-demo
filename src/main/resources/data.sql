insert into contractor (id, name, agency_id, timesheet_id ) values (1,'Joe',1,1);
insert into contractor (id, name ) values (2,'Bill');
//
insert into agency (id, name ) values (1,'Agency1');
insert into agency (id, name ) values (2,'Agency2');
//

insert into daysWorked (id, monday, tuesday, wednesday, thursday, friday  ) values (1, 28/07/2016, 29/07/2016, 30/07/2016, 01/08/2016, 02/08/2016);
insert into daysWorked (id, monday, tuesday, wednesday, thursday, friday  ) values (2, 28/08/2016, 29/08/2016, 30/08/2016, 01/09/2016, 02/09/2016);

//

insert into timesheet (id, contractor_id ,agency_id, days_worked_id, approved ) values (1,1,1,1,null);
insert into timesheet (id, contractor_id ,agency_id, days_worked_id, approved ) values (2,2,2,2,null);