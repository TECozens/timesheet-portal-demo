ReadMe.md

Login Info 

Contractor
After logging in will take you to make a new timesheet
Username:Mo password:password

Manager
After logging in you will be taken to the manager dash board view where time sheets waiting for approval can be seen and delt with 
Username:Tomas password:tomtsp


Admin
After logging in wil take you to the admin dash board view where time sheets can be seen and delt with as invoices
Username:Laura password:ltsp

    Setting up Database For Use:

     1. Open the DB Panel and select `New`
     2. Select Datasource "MySQL"
     3. Set the username and password for your localhost database server (root / comsc was ours, use yours)
     4. If neccessary, download any required drivers
     5. Go to src/main/resources, right click on `Team10_script.sql`
     6. Then click `run Team10_script.sql`, then select the localhost connection you created
     7. Right click on the @localhost database connection and select properties
     9. Go to the Schema page, and select the `tsap` schema to ticked, and only that schema
     10. Go to General then set the Database to `tsap`, then click OK
	 11. Turn Annotation Processing On, Build / Assemble , Visit Project on https://localhost:8081




