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

  Scenario: Home - SuperAdmin
    Given Login as superAdmin
    Then Navigate to Home
    Then Validate Home UI Elements

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
