Feature: PLILHomepage

  @Hello
  Scenario Outline:Launch PILI
    Given Enter username and password <Username>,<Password>
    Then Click on Login button
    Examples:
      | Username                       |Password |
      |deepak.kumar@geminisolutions.com|Asdf@1234|






