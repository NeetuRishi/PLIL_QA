Feature: Read_User


  @Login-User-Home @beta
  Scenario Outline: Launch->PLIL
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then validate weather the <Home>,<Enquiry>,<Report> tab are present and are clickable
    Then validate Home screen ui
    Then validate Enquiry and Report card on Home Screen
    Then Logout and verify

    Examples:
      |Validate_txt|Home|Enquiry|Report|username|password|
      |Home        |Home|Enquiry|Report|shubham.a.kumar@geminisolutions.com|Test@123|

  @Login-User-Enquiry
  Scenario Outline: Launch->PLIL->EnquiryTab->Validation
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Navigate to Enquiry tab and validate logo
    Then validate weather the <Home>,<Enquiry>,<Report> tab are present and are clickable
    Then Validate Enquiry Tab ui
    Then validate Date Field and user able to select date
    Then validate excel button functionality <Filepath>
    Then validate Enquiry Tab Columns
    Then Download PDF and validate <Filepath>
    Then validate Pagination functionality in Enquiry Tab
    Then validate Application Column ui


    Examples:
      |Validate_txt|Home|Enquiry|Report|Filepath|username|password|
      |Home        |Home|Enquiry|Report|C:\Users\Rahul Adhikari\Downloads|shubham.a.kumar@geminisolutions.com|Test@123|

  @Login-User-Report
  Scenario Outline: Launch->PLIL->ReportTab->Validation
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Navigate to Report tab and validate logo
    Then validate weather the <Home>,<Enquiry>,<Report> tab are present and are clickable
    Then validate Report page ui
    Then validate Wib Report Ui with functionality
    Then validate Send Via Email Button functionality
    Then Download Report and validate <Filepath>
    Then Logout and verify


    Examples:
      |Validate_txt|Home|Enquiry|Report|Filepath|username|password|
      |Home        |Home|Enquiry|Report|C:\Users\Rahul Adhikari\Downloads|deepakread@gmail.com |Asdf@1234|