Feature: superAdmin

  Scenario: Super Admin Login
    Given Login as superAdmin

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

<<<<<<< HEAD
    Scenario: Master Management
      Given Login as superAdmin
      Then Navigate to Master Management
      Then Navigate to Product Masters
      Then Check Product Masters Label is present and back arrow < should be visible and clickable
      Then check whether All the column names are displayed
      Then Check the Create Product Master Functionality
      Then Check the Edit functionality
      Then Check the Delete Functionality
      Then Check the pagination functionality
=======
  Scenario Outline: Master Management
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then  Navigate to Master Management Tab and validate logo
    Then  Navigate to Salutation Card and validate the Ui
    Then  Validate Create Button functionality


    Examples:
      |Validate_txt|username|password|
      |Home        |shubham.a.kumar@geminisolutions.com|Test@123|


    Scenario: Roles
      Given Login as superAdmin
      Then Navigate to Roles
      Then Validate Roles Screen

>>>>>>> c47e087d93b9250f442a976f46dabdded246790e
