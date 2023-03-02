Feature: Super Admin

  @run1
  Scenario Outline: Home - SuperAdmin user

    Given  Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Navigate to Home
    Then Validate Home UI Elements
    Examples:
      |Validate_txt|username|password|
      |Home        |deepak.kumar@geminisolutions.com|Asdf@1234|

  @run1
  Scenario Outline: Roles (Super Admin User)

    Given  Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Navigate to Roles
    Then Validate Roles Screen
    Examples:
      |Validate_txt|username|password|
      |Home        |deepak.kumar@geminisolutions.com|Asdf@1234|


  @run1
  Scenario Outline: Master Management (Super Admin User)

    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then  Navigate to Master Management Tab and validate logo
    Then  Navigate Cards and validate all functionality <username>
    Then  Validate Relationship card and its functionality <username>
    Then  Validate Product Master Card and its functionality <username>
    Then  Click on Covid Questions and Validate
    Then  Click on Medical Questions and Validate

    Examples:
      | Validate_txt | username                            | password |
      | Home         | deepak.kumar@geminisolutions.com|Asdf@1234|

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
  Scenario Outline: Partner Product (Super Admin user)

    Given  Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Navigate to Partner Product
    Then Validate Partner Product Screen
    Examples:
      |Validate_txt|username|password|
      |Home        |deepak.kumar@geminisolutions.com|Asdf@1234|


  Scenario Outline: GOPS Enquiry(Super Admin User)

    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
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
    Then validate Scroll bar
    Then Verify Customer Details Label and Fields.
    Then Verify LOAN DETAILS Label and Fields
    Then Verify POLICY DETAILS Label and Fields.
    Then verify export to excel button is present.
    Examples:
      |Validate_txt|username|password|
      |Home        |deepak.kumar@geminisolutions.com|Asdf@1234|


  Scenario: Reverse Feed Login (Super Admin User)

    Given enter email ID and password
    Then click on Captcha,Login
    Then validate the PLIL Logo
    Then validate PLIL tabs
    Then validate Reverse tab
    Then verify hamburger button on the screen.
    Then verify filter by label.
    Then verify Status Field is present and clickable.
    Then verify Date Field is present and clickable.
    Then verify user able to select date from calendar.
    Then verify search bar is present and user able to search.
    Then verify Reverse Feed after login check table column names
    Then verify eye option is working in View Details  Column.
    Then verify pagination is visible and right & light buttons are working
    Then verify Reverse Feed export to excel button is present



  @run1
  Scenario Outline: Generate IG File

      Given  Enter Username and Password and validate <Validate_txt>,<username>,<password>
      Then Navigate to Generate Ig File
      Then Validate Generate Ig File Screen
    Examples:
      |Validate_txt|username|password|
      |Home        |deepak.kumar@geminisolutions.com|Asdf@1234|



  Scenario: Roles (Super admin user)
    Given Login as superAdmin
    Then Navigate to Roles
    Then Validate Roles Screen

  Scenario Outline: UserManagement
   # Given enter email ID and password
   # Then click on Captcha,Login
    Given  Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then verify logo on User management page.
    Then validate PLIL tabs
    Then verify User Management Tab is highlighted or not.
    Then verify hamburger button on the screen.
    Then verify create user button is visible or clickable.
    Then verify search text box with icon is present.
    Then verify all the table column field names.
    Then verify create user fields
    Then verify user should get created and also visible on user management screen.

    Examples:
      |Validate_txt|username|password|
      |Home        |deepak.kumar@geminisolutions.com|Asdf@1234|


