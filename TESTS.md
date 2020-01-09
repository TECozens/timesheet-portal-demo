TEST 1 - Reviews:

Ensure the database has been set up correctly as specified by the README.md
Run the system

Go to the page "http://localhost:8080"
- Expect a Login page

Login with the credentials for an admin as specified in README.md
- Expect a page titled Invoices

Enter "Kevin" into the name entrybox, and clear once done
- Expect the list to filter all records without Kevin automatically as it's typed
- then re-appear once removed

Enter any value into any text inputs
- Expect it to filter any record which the search is not a substring of it's column
- then re-appear once removed

Enter a date before 10th of November 2019 for the top date entry box
- Expect it to not filter any of the two dates

Enter a date after 10th of November 2019 for the bottom date entry box
- Expect it to not filter any of the two dates

Enter a date after the same day on the top date entry box, then before it on the bottom one
- Expect in both cases the date to be filtered

Click the "Confirm invoice" button for one of the invoices
- The invoice should dissapear

Refresh the page and filter multiple things then clear the filters
- No matter what, the confirmed invoice stays removed from the list


TEST 2 - Contractor List:

Ensure the database has been set up correctly as specified by the README.md
Run the system

Go to the page "http://localhost:8080"
- Expect a Login page

Login with these credentials - Username: "Tomas", Password: "tomtsp"
- Expect a page with a table of records relating to timesheets

Click on the Menu button on the top right of the website once logged in then select "View Contractors"
- A different table with contractor names and agencies, but no days worked or dates should appear

Use the search boxes to check if the filter for each column works
- If you type something into a search bar, each field below that entry box must contain that substring
- The filter updates when entered

Click logout, and login with these credentials - Username: "Carl", Password: "password"
Go to the same "View Contractors" page
- A different Contractor should show up as you are now logged in as a different manager, with different contractors.
