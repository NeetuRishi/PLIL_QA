Feature: Read_User


  @Login-User-Home @beta
  Scenario Outline: Launch->PLIL
    Given Enter Username and Password and validate <Validate_txt>
    Then validate weather the <Home>,<Enquiry>,<Report> tab are present and are clickable
    Then validate Home screen ui
    Then validate Enquiry and Report card on Home Screen
    Then Logout and verify

    Examples:
      |Validate_txt|Home|Enquiry|Report|
      |Home        |Home|Enquiry|Report|

  @Login-User-Enquiry
  Scenario Outline: Launch->PLIL->EnquiryTab->Validation
    Given Enter Username and Password and validate <Validate_txt>
    Then Navigate to Enquiry tab and validate logo
    Then validate weather the <Home>,<Enquiry>,<Report> tab are present and are clickable
    Then Validate Enquiry Tab ui
    Then validate Date Field and user able to select date
    Then validate excel button functionality <Filepath>




    Examples:
      |Validate_txt|Home|Enquiry|Report|Filepath|
      |Home        |Home|Enquiry|Report|Downloads|