Feature: Write-User
Scenario Outline: Bulk Upload
  Given  Enter the Username and password for GOPS User and login
  Then Validate that Home page opens and logo is visible
  Then Click on <tab> and check that it got highlighted
  Then Check whether hamburgher button is present or not and clicking it minimizes the side bar
  Then Validate Logout button is present
  Then Check whether Type dropdown is present and working properly or not
  Then check whether Click Here,Discard,Upload button are present or not
  Then check that Upload button is not enabled until a file is selected
#  Then click on Click here and check whether excel got downloaded or not
  Then select <value1> from dropdown and then upload the <fileName1> file
  Then select <value2> from dropdown and then upload the <fileName2> file
Then check whether record got added corresponding to the uploaded file <fileName1> in Bulk Upload Report or not
  Then check whether record got added corresponding to the uploaded file <fileName2> in Bulk Upload Report or not

  Examples:
  |tab|value1|fileName1|value2|fileName2|
  |Bulk Upload|1|uploadDemo|2|F3|
