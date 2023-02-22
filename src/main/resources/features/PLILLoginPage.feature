Feature: PLILHomepage


  @Login-page @beta1
  Scenario: Launch PLIL
    Given Validate UI Elements




  @Login/Logout @beta1
  Scenario Outline: Launch PILI Login/Logout
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Logout and verify
    Then Enter  password without Username <password>,<Validate_Error_Text>,<Error_msg>
    Then Enter Username without Password <username>,<Validate_Error_Text1>,<Error_msg1>
    Then Enter wrong username and correct password and validate <Wrong_Username>,<password>
    Then Enter correct username and wrong password and validate <username>,<Wrong_Password>
    Then Enter username and Password and login without selecting captcha <Error_mgs3>
    Examples:
      | username                         | password  |Validate_txt|Validate_Error_Text|Error_msg|Validate_Error_Text1|Error_msg1|Wrong_Username|Wrong_Password|Error_mgs3|
      | deepak.kumar@geminisolutions.com | Asdf@1234 |Home |Email Id is required       |Email Id is required|Password is required |Password is required|deepakk.kumar@geminisolutions.com|Asdf@12335|Verification required|


  @Forgot @beta1
  Scenario Outline: Launch PLIL Forgot_Password Validation
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






  @First_Time_Login @beta1
  Scenario Outline: Launch PLIL Login once
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Navigate to subtab <Subtab>
    Then Create User <Name_inp>,<Email_inp>,<Mobile_inp>,<Name_val>,<Email_val>,<Mobile_val>,<val1>,<val2>
    Then Logout and verify
    Then Enter new Username <Email_val>
    Then validate set new password ui
    Then Set New Password and validate <new_Pass>
    Then Login with Wrong Password <Wrong_Pass>
    Examples:
      |Validate_txt|Subtab           |Name_inp|Email_inp|Mobile_inp|Name_val|Email_val|Mobile_val|val1|val2|new_Pass|Wrong_Pass|username|password|
      |Home         | User Management |name    |email    |mobile    |Rahul   |rahul.adhikari@geminisolutions.com|9501209019|Read|Pramerica Life Insurance Limited|Gemini1334|gemini123|deepak.kumar@geminisolutions.com|Asdf@1234|



  @Reset/Update @beta1
  Scenario Outline: Launch PLIL Reset/Update_Password OTP Set_New_Password Validation
    Given Click on Forgot Password Link and verify
    Then Username is Entered  <Username>
    Then validate set new password screen <New_Password>,<Confirm_Password>,<Required_Label>,<Home_Label>

    Examples:
      |Username|New_Password|Confirm_Password|Required_Label|Home_Label|
      |rahul.adhikari@geminisolutions.com|Asdf@12347|Asdf@12347|Set New Password|Welcome|