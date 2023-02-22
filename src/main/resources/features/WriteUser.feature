Feature: Write-User
#
#Scenario Outline: Bulk Upload (Write User)
#  Given  Enter Username and Password and validate <Validate_txt>,<username>,<password>
#  Then Validate that Home page opens and logo is visible
#  Then Click on <tab> and check that it got highlighted
#  Then Check whether hamburgher button is present or not and clicking it minimizes the side bar
#  Then Validate Logout button is present
#  Then Check whether Type dropdown is present and working properly or not
#  Then check whether Click Here,Discard,Upload button are present or not
#  Then check that Upload button is not enabled until a file is selected
##  Then click on Click here and check whether excel got downloaded or not
#  Then select <value1> from dropdown and then upload the <fileName1> file
#  Then select <value2> from dropdown and then upload the <fileName2> file
#Then check whether record got added corresponding to the uploaded file <fileName1> in Bulk Upload Report or not
#  Then check whether record got added corresponding to the uploaded file <fileName2> in Bulk Upload Report or not
#
#  Examples:
#  |tab|value1|fileName1|value2|fileName2|Validate_txt|username|password|
#  |Bulk Upload|1|check12|2|check13|Home                |mr.malhotra1@gmail.com|Asdf@1234|


  Scenario Outline: Enquiry (Write User)
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Navigate to Enquiry tab and validate logo
    Then validate weather the <Home>,<Enquiry>,<Report>,<Reverse Feed>,<Rejected> tab are present and are clickable
    Then Validate Enquiry Tab ui
    Then validate Date Field and user able to select date <index>
    Then validate excel button functionality <Filepath>
    Then validate Enquiry Tab Columns
    Then Download PDF and validate <Filepath>
    Then validate Pagination functionality in Enquiry Tab <index>
    Then validate Application Column ui


    Examples:
      |Validate_txt|Home|Enquiry|Report|Filepath|username|password|Reverse Feed|Rejected|index|
      |Home        |Home|Enquiry|Report|C:\Users\tr.sahni\Downloads|mr.malhotra1@gmail.com|Asdf@1234|Reverse Feed|Rejected Case|2|



  Scenario Outline: Report (Write User)
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Navigate to Report tab and validate logo
    Then validate weather the <Home>,<Enquiry>,<Report>,<Reverse Feed>,<Rejected> tab are present and are clickable
    Then validate Report page ui
    Then validate Wib Report Ui with functionality
    Then validate Send Via Email Button functionality
    Then Download Report and validate <Filepath>
    Then Logout and verify


    Examples:
      |Validate_txt|Home|Enquiry|Report|Filepath|username|password|Reverse Feed|Rejected|
      |Home        |Home|Enquiry|Report|C:\Users\tr.sahni\Downloads|mr.malhotra1@gmail.com|Asdf@1234|Reverse Feed|Rejected Case|



  Scenario Outline: Rejected Case (Write User)
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Navigate to Rejected Case tab and validate logo
    Then validate weather the <Home>,<Enquiry>,<Report>,<Reverse Feed>,<Rejected> tab are present and are clickable
    Then validate Rejected Case page ui
    Then validate Date Field and user able to select date <index>
    Then validate excel button functionality <Filepath>
    Then validate Rejected Case Tab Columns
    Then validate Search Field on Rejected Case Screen
    Then validate Application Column ui
    Then validate Pagination functionality in Enquiry Tab <index>
    Then Logout and verify


    Examples:
      |Validate_txt|Home|Enquiry|Report|Filepath|username|password|Reverse Feed|Rejected|index|
      |Home        |Home|Enquiry|Report|C:\Users\tr.sahni\Downloads|mr.malhotra1@gmail.com|Asdf@1234|Reverse Feed|Rejected Case|7|


  @Read-User-ReverseFeed-Login
  Scenario Outline: Reverse Feed(Write user)
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Navigate to Reverse Feed tab and validate logo
    Then validate weather the <Home>,<Enquiry>,<Report>,<Reverse Feed>,<Rejected> tab are present and are clickable
    Then validate Reversed Feed page ui for write user
    Then validate Date Field and user able to select date <index>
    Then validate excel button functionality <Filepath>
    Then validate Reversed Feed for write user Tab Columns
    Then validate Search Field on Reversed Feed write user Screen
    Then validate Application Status Table Data
    Then validate Pagination functionality in Enquiry Tab <index>
    Then Logout and verify

    Examples:
      |Validate_txt|Home|Enquiry|Report|Filepath|username|password|Reverse Feed|Rejected|index|
      |Home        |Home|Enquiry|Report|C:\Users\tr.sahni\Downloads|mr.malhotra1@gmail.com|Asdf@1234|Reverse Feed|Rejected Case|6|
