Feature: PLILHomepage


  @Login-page
  Scenario: Launch->PLIL
    Given Validate UI Elements




  @Login/Logout
  Scenario Outline: Login->PILI
    Given Enter username and password
    Then Click on Login button and Validate <Validate_text>
    Then Logout and verify
    Then Enter  password without Username <Password>,<Validate_Error_Text>,<Error_msg>
    Then Enter Username without Password <Username>,<Validate_Error_Text1>,<Error_msg1>
    Then Enter wrong username and correct password and validate <Wrong_Username>,<Password>
    Then Enter correct username and wrong password and validate <Username>,<Wrong_Password>
    Then Enter username and Password and login without selecting captcha <Error_mgs3>
    Examples:
      | Username                         | Password  |Validate_text|Validate_Error_Text|Error_msg|Validate_Error_Text1|Error_msg1|Wrong_Username|Wrong_Password|Error_mgs3|
      | deepak.kumar@geminisolutions.com | Asdf@1234 |Home |Email Id is required       |Email Id is required|Password is required |Password is required|deepakk.kumar@geminisolutions.com|Asdf@12335|Verification required|


  @Forgot
  Scenario Outline: Forgot_Password->Validation
    Given Click on Forgot Password Link and verify
    Then verify Here Link on Forgot Password screen
    Then Enter Username and validate  <Wrong_Username>
    Then Verify Logo,Forgot Password Label <Username>
    Then Verification Screen Ui validation
    Then Username is Entered <Username>
    Then Validating Click Here Button Functionality on Verfication Screen
    Then Enter Invalid  Username and verify <invalid_Username>,<Error_msg>

    Examples:
      |Username|Wrong_Username|invalid_Username|Error_msg|
      |deepak.kumar@geminisolutions.com|deepakk.kumar@geminisolutions.com|deepak.kumargeminisolutions.com|Please enter a valid email address|






  @First_Time_Login
  Scenario Outline: Login->PILI->once
    Given Enter username and password
    Then Click on Login button and Validate <Validate_text>
    Then Navigate to subtab <Subtab>
    Then Create User <Name_inp>,<Email_inp>,<Mobile_inp>,<Name_val>,<Email_val>,<Mobile_val>,<val1>,<val2>
    Then Logout and verify
    Then Enter new Username <Email_val>
    Then validate set new password ui
    Then Set New Password and validate <new_Pass>
    Then Login with Wrong Password <Wrong_Pass>
    Examples:
      |Validate_text|Subtab|Name_inp|Email_inp|Mobile_inp|Name_val|Email_val|Mobile_val|val1|val2|new_Pass|Wrong_Pass|
      |Home         | User Management |name|email|mobile |Rahul   |rahul.adhikari@geminisolutions.com|9501209019|superAdmin|Pramerica Life Insurance Limited|Gemini1334|gemini123|



  @Reset/Update @beta
  Scenario Outline: Reset/Update_Password->OTP->Set_New_Password->Validation
    Given Click on Forgot Password Link and verify
    Then Username is Entered  <Username>
    Then validate set new password screen <New_Password>,<Confirm_Password>,<Required_Label>,<Home_Label>

    Examples:
      |Username|New_Password|Confirm_Password|Required_Label|Home_Label|
      |rahul.adhikari@geminisolutions.com|Asdf@12347|Asdf@12347|Set New Password|Welcome|