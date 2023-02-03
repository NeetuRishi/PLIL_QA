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

  Scenario: Home - SuperAdmin
    Given Login as superAdmin
    Then Navigate to Home
    Then Validate Home UI Elements

    Scenario: Roles
      Given Login as superAdmin
      Then Navigate to Roles
      Then Validate Roles Screen