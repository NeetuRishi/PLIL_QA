Feature: superAdmin

  Scenario: Super Admin Common Screen Elements
    Given Login as superAdmin
    Then Validate Common UI Elements

  Scenario: Partner Product
    Given Login as superAdmin
    Then Navigate to Partner Product
    Then Validate Partner Product Screen


  Scenario: Partner Management
    Given Login as superAdmin
    Then Navigate to Partner Management
    Then Validate Partner Management Screen
@beta1
  Scenario: Home - SuperAdmin
    Given Login as superAdmin
    Then Navigate to Home
    Then Validate Home UI Elements

  Scenario Outline: Master Management
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then  Navigate to Master Management Tab and validate logo
    Then  Navigate to Salutation Card and validate the Ui
    Then  Validate Create Button functionality


    Examples:
      |Validate_txt|username|password|
      |Home        |shubham.a.kumar@geminisolutions.com|Test@123|

