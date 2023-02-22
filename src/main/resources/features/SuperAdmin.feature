Feature: Super Admin
  @run1
  Scenario Outline: Master Management's Product Master Screen (Super Admin user)
#      Given Login as superAdmin
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then validate the Logo
    Then Navigate to Master  Management
    Then Click on <tab> and check that it got highlighted
    Then verify Hamburger button on top to minimize side bar.
    Then Navigate to Product Masters
    Then Check Product Masters Label is present and back arrow < should be visible and clickable
    Then check whether All the column names are displayed

    Then Check the Create Product Master Functionality
    Then Check the Edit functionality
    Then Check the Delete Functionality for product masters
#      Then validate Pagination functionality for Master Management
    Examples:
      |Validate_txt|username|password|tab|
      |Home        |deepak.kumar@geminisolutions.com|Asdf@1234|Master Management|


  Scenario Outline: GOPS Enquiry(Super Admin User)
#    Given enter email ID and password
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
#    Then click on Captcha,Login and GOPS Enquiry
    Then validate the Logo
    Then validate tabs
    Then validate GOPS tab
    Then To validate Hamburger button
    Then validate GOPS Enquiry Tab is highlighted and displayed
    Then enter text to validate GOPS Filter
    Then validate filter with inplace text partner
    Then validate status filter with inplace text
    Then validate Date field
    Then validate search field
    Then validate Table Columns
#    Then validate pagination of GoPS table
    Then validate Scroll bar
    Then Verify Customer Details Label and Fields.
    Then Verify LOAN DETAILS Label and Fields
    Then Verify POLICY DETAILS Label and Fields.
    Then verify export to excel button is present.
    Examples:
      |Validate_txt|username|password|
      |Home        |deepak.kumar@geminisolutions.com|Asdf@1234|

  @run1
  Scenario Outline: Super Admin Login
    Given  Enter Username and Password and validate <Validate_txt>,<username>,<password>
#    Given Login as superAdmin
  Examples:
    |Validate_txt|username|password|
    |Home        |deepak.kumar@geminisolutions.com|Asdf@1234|


  @run1
  Scenario Outline: Partner Product (Super Admin user)
#    Given Login as superAdmin
    Given  Enter Username and Password and validate <Validate_txt>,<username>,<password>

    Then Navigate to Partner Product
    Then Validate Partner Product Screen
    Examples:
      |Validate_txt|username|password|
      |Home        |deepak.kumar@geminisolutions.com|Asdf@1234|

  @run1
  Scenario Outline: Partner Management (Super Admin User)
#    Given Login as superAdmin
  Given  Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Navigate to Partner Management
    Then Validate Partner Management Screen
    Examples:
      |Validate_txt|username|password|
      |Home        |deepak.kumar@geminisolutions.com|Asdf@1234|


  @run1
  Scenario Outline: Home - SuperAdmin user
#    Given Login as superAdmin
    Given  Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Navigate to Home
    Then Validate Home UI Elements
    Examples:
      |Validate_txt|username|password|
      |Home        |deepak.kumar@geminisolutions.com|Asdf@1234|






  #Scenario Outline: Master Management Card Validation->Salutation->Gender->Occupation->Age_Proof->Marital_Status->Type_Of_Loan
@run1
  Scenario Outline: Roles (Super Admin User)
#    Given Login as superAdmin
  Given  Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Navigate to Roles
    Then Validate Roles Screen
  Examples:
    |Validate_txt|username|password|
    |Home        |deepak.kumar@geminisolutions.com|Asdf@1234|

  @run1
  Scenario Outline: Generate IG File
#      Given Login as superAdmin
  Given  Enter Username and Password and validate <Validate_txt>,<username>,<password>
      Then Navigate to Generate Ig File
      Then Validate Generate Ig File Screen
    Examples:
      |Validate_txt|username|password|
      |Home        |deepak.kumar@geminisolutions.com|Asdf@1234|


  @run1
  Scenario Outline: Master Management (Super Admin user)
#       Given Login as superAdmin
  Given  Enter Username and Password and validate <Validate_txt>,<username>,<password>
      Then Navigate to Master Management
      Then Click on Covid Questions and Validate
      Then Click on Medical Questions and Validate
    Examples:
      |Validate_txt|username|password|
      |Home        |deepak.kumar@geminisolutions.com|Asdf@1234|

@run1

  Scenario Outline: User Management screen (super Admin user)
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Validate that Home page opens and logo is visible
    Then Click on <tab> and check that it got highlighted
    Then Check whether hamburgher button is present or not and clicking it minimizes the side bar
    Then Validate Logout button is present
    Then Validate whether <tab> label is present
    Then Validate whether Create User button is present and clickable
    Then Verify whether new user cannot be created or not with name <name1> , email <email>,mobile No <mobile1>
    Then Check whether user was created or not with correct field values
    Then Validate whether search button is present and working properly
    Then Check whether edit button works properly or not
    Then Validate whether Create User button is present and clickable
    Then Verify whether new user cannot be created or not with name <name2> , email <email>,mobile No <mobile2>
    Then Validate that user will not be able to create for the same email ID
    Then Check whether delete button works properly or not
    Then Click on the reset password button and check whether password email was sent


    Examples:
      |tab| name1| email| mobile1| name2| mobile2 |Validate_txt|username|password|
      |User Management| ABCD | tripta.sahni@geminisolutions.com|  9999999999  | BCDF | 8888888888|Home|deepak.kumar@geminisolutions.com|Asdf@1234|

  Scenario Outline: Master Management

    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then  Navigate to Master Management Tab and validate logo
    Then  Navigate Cards and validate all functionality <username>

    Examples:
      | Validate_txt | username                            | password |
      | Home         | deepak.kumar@geminisolutions.com|Asdf@1234|


  Scenario Outline: Master Management Card Validation->Appointee_Nominee->Nominee_Applicant->Appointee_Applicant->Cover_Basis
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then  Navigate to Master Management Tab and validate logo
    Then  Validate Relationship card and its functionality <username>


    Examples:
      | Validate_txt | username                            | password |
      | Home         | deepak.kumar@geminisolutions.com |Asdf@1234|



  Scenario: Roles (Super admin user)
    Given Login as superAdmin
    Then Navigate to Roles
    Then Validate Roles Screen

