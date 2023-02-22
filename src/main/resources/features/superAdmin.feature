Feature: superAdmin

  @beta
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



  Scenario: Roles
    Given Login as superAdmin
    Then Navigate to Roles
    Then Validate Roles Screen

  Scenario: Generate IG File
      Given Login as superAdmin
      Then Navigate to Generate Ig File
      Then Validate Generate Ig File Screen


    Scenario: Master Management
       Given Login as superAdmin
      Then Navigate to Master Management
      Then Click on Covid Questions and Validate
      Then Click on Medical Questions and Validate

  Scenario Outline: Master Management->card->validation

    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then  Navigate to Master Management Tab and validate logo
    Then  Navigate Cards and validate all functionality <username>

    Examples:
      | Validate_txt | username                            | password |
      | Home         | shubham.a.kumar@geminisolutions.com | Test@123 |


  Scenario Outline: Master Management Card Validation->Appointee_Nominee->Nominee_Applicant->Appointee_Applicant->Cover_Basis
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then  Navigate to Master Management Tab and validate logo
    Then  Validate Relationship card and its functionality <username>


    Examples:
      | Validate_txt | username                            | password |
      | Home         | shubham.a.kumar@geminisolutions.com | Test@123 |



  Scenario: Roles
    Given Login as superAdmin
    Then Navigate to Roles
    Then Validate Roles Screen

