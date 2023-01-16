Feature: PLILHomepage

  Scenario: PLIL Login
    Given Enter username and password
    Then Click on Login button

  Scenario Outline: Launch PLIL
    Given Validate UI Elements <Logo>,<Welcome_Label>,<Email>,<Password>,<Login_Button>,<Captcha>,<ClickHere_Link>

Examples:
    |Logo|Welcome_Label|Email|Password|Login_Button|Captcha|ClickHere_Link|
    |True|True         |True |True    |True        |True   |True          |
