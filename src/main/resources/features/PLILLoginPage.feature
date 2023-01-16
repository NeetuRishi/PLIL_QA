Feature: PLILHomepage


  @SuperAdmin @Login
  Scenario Outline:Login PILI
    Given Enter username and password <Username>,<Password>
    Then Click on Login button and Validate <Validate_text>

    Examples:
      | Username                         | Password  |Validate_text|
      | deepak.kumar@geminisolutions.com | Asdf@1234 |Home |

 
  Scenario: PLIL Login
    Given Enter username and password
    Then Click on Login button


  Scenario Outline: Launch PLIL
    Given Validate UI Elements <Logo>,<Welcome_Label>,<Email>,<Password>,<Login_Button>,<Captcha>,<ClickHere_Link>


    Examples:
      |Logo|Welcome_Label|Email|Password|Login_Button|Captcha|ClickHere_Link|
      |True|True         |True |True    |True        |True   |True          |






