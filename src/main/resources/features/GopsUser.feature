Feature: GopsUser
#
#  Scenario:Login through GOPS user-->Home
#    Given Enter the Username and password for GOPS User and login
#    Then Validate that Home page opens and logo is visible
#    Then Validate Hamburger Button is present
#    Then Validate Name,Email ID, Mobile Number are present
#    Then Validate Navigate To label is present
#    Then Validate Gops Enquiry Card and Reverse Feed Enquiry Card is present
#    Then Validate Logout button is present
#
#  Scenario:Login through GOPS user-->GOPS Enquiry
#    Given Enter the Username and password for GOPS User and login
#    Then Validate that Home page opens and logo is visible
#    Then Click on GOPS Enquiry Tab and validate that Gops Enquiry tab is highlighted
#    Then Check whether hamburgher button is present or not and clicking it minimizes the side bar
#    Then Validate Logout button is present
#    Then Validate Filter By Label is present
#    Then Check whether Filter partner and status dropdown are working fine or not
#    Then Check whether date functionality is working properly or not
#    Then Check whether clear button is present or not and is working fine
#    Then Check whether search button is present and is working properly or not
#    Then Check whether export button is present and is working fine or not


    Scenario Outline: Login through GOPS user--->Reverse Feed Upload
      Given Enter the Username and password for GOPS User and login
      Then Validate that Home page opens and logo is visible
      Then Click on <tab> and check that it got highlighted
      Then Check whether hamburgher button is present or not and clicking it minimizes the side bar
      Then Check if No partner is selected from dropdown and cliked on Upload, then error is thrown
      Then Check whether Select Partner name dropdown is present and working properly
      Then Check whether Reverse Feed Upload label appears on the homepage
      Then check whether Click Here,Discard,Upload button is present or not
      Then click on Click here and check whether excel got downloaded or not
      Then click on choose button and select a file from the file manager

      Then Click on Upload File button and check if file got uploaded successfully and message got displayed
      Examples:
      |tab|
      |Reverse Feed Upload|