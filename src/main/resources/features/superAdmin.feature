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