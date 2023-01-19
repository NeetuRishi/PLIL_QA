Feature: PLILHomepage

  @SuperAdmin @Login @Hello
  Scenario Outline:Login->PILI
    Given Enter username and password <Username>,<Password>
    Then Click on Login button and Validate <Validate_text>

    Examples:
      | Username                         | Password  |Validate_text|
      | deepak.kumar@geminisolutions.com | Asdf@1234 |Home |

  @Hello
  Scenario Outline:Login->PILI->WithoutEmail->Validation
    Given Enter  password without Username <Password>
    Then Validate  Error after login <Validate_text>,<Error_msg>

    Examples:
      |Password  |Validate_text|Error_msg|
       | Asdf@1234 |Email Id is required |Email Id is required|

  @Hello
  Scenario Outline:Login->PILI->WithoutPassword->Validation
    Given Enter Username without Password <Username>
    Then Validate  Error after login <Validate_text>,<Error_msg>

    Examples:
      |Username  |Validate_text|Error_msg|
      | deepak.kumar@geminisolutions.com |Password is required |Password is required|

  @Hello
  Scenario Outline:Login->WrongEmail->PILI
    Given Enter username and password <Username>,<Password>
    Then Login and validate <Validate_text>,<Error_msg>

    Examples:
      | Username                         | Password  |Validate_text|Error_msg|
      | deepak.kumargeminisolutions.com | Asdf@1234 | Please enter a valid email address  |Please enter a valid email address|

  @Hello
  Scenario Outline:Login->WrongPassword->PILI
    Given Enter username and password <Username>,<Password>
    Then Login and validate wrong Password message

    Examples:
      | Username                         | Password  |
      | deepak.kumar@geminisolutions.com | Asdf@123445 |

  @Hello
  Scenario Outline:Login->WithoutSelectingCaptcha->PILI
    Given Enter username and password <Username>,<Password>
    Then Login and validate <Validate_text>,<Error_msg>

    Examples:
      | Username                         | Password  |Validate_text|Error_msg|
      | deepak.kumar@geminisolutions.com | Asdf@1234 |  Verification required   | Verification required |

  @Hello
  Scenario Outline:Logout->PILI
    Given Enter username and password <Username>,<Password>
    Then Click on Login button and Validate <Validate_text>
    Then Logout and verify

    Examples:
      | Username                         | Password  |Validate_text|
      | deepak.kumar@geminisolutions.com | Asdf@1234 |Home |

  @Hello
  Scenario Outline: Launch->PLIL
    Given Validate UI Elements <Logo>,<Welcome_Label>,<Email>,<Password>,<Login_Button>,<Captcha>,<ClickHere_Link>

    Examples:
      |Logo|Welcome_Label|Email|Password|Login_Button|Captcha|ClickHere_Link|
      |True|True         |True |True    |True        |True   |True          |


  Scenario: Forgot_Password->Validation
    Given Click on Forgot Password Link and verify

  Scenario Outline: Forgot_Password->Forgot_Password_Ui>Validation
    Given Click on Forgot Password Link and verify
    Then Verify Logo,Forgot Password Label <Username>

    Examples:
    |Username|
    |deepak.kumar@geminisolutions.com|

  Scenario Outline: Forgot_Password->Here_Link>Validation
    Given Click on Forgot Password Link and verify
    Then verify Here Link

    Examples:
      |Username|
      |deepak.kumar@geminisolutions.com|

  Scenario Outline: Forgot_Password->WrongEmail->Validation
    Given Click on Forgot Password Link and verify
    Then Enter Username and validate  <Username>

    Examples:
      |Username|
  |deepakk.kumar@geminisolutions.com|

  Scenario Outline: Forgot_Password->ui->Validation
    Given Click on Forgot Password Link and verify
    Then Username is Entered <Username>
    Then verify Forgot Password Ui


    Examples:
      |Username|
      |deepak.kumar@geminisolutions.com|

  Scenario Outline: Forgot_Password->ui->Here_Btn->Validation
    Given Click on Forgot Password Link and verify
    Then Username is Entered <Username>
    Then Click Here Button and Validate


    Examples:
      |Username|
      |deepak.kumar@geminisolutions.com|

  Scenario Outline: Forgot_Password->Invalid_Email->Validation
    Given Click on Forgot Password Link and verify
    Then Enter Invalid  Username and verify <Username>,<Error_msg>

    Examples:
      |Username|Error_msg|
      |deepak.kumargeminisolutions.com|Enter Invalid  Username and verify|

  Scenario Outline: Reset/Update_Password->OTP->Set_New_Password->Validation
    Given Click on Forgot Password Link and verify
    Then Username is Entered  <Username>
    Then validate set new password screen <New_Password>,<Confirm_Password>,<Required_Label>,<Home_Label>

    Examples:
      |Username|New_Password|Confirm_Password|Required_Label|Home_Label|
      |rahul.adhikari@geminisolutions.com|Asdf@12340|Asdf@12340|Set New Password|Welcome|



