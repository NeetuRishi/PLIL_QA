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
Scenario Outline: Gops Enquiry (Gops User)
Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
#    Then click on Captcha,Login and GOPS Enquiry
Then validate the Logo
#Then validate tabs
Then validate GOPS tab
Then To validate Hamburger button
Then validate GOPS Enquiry Tab is highlighted and displayed
Then enter text to validate GOPS Filter
Then validate filter with inplace text partner
Then validate status filter with inplace text
Then validate Date field
Then validate search field
Then validate Table Columns
#    Then validate pagination of GoPS table
Then validate Scroll bar
Then Verify Customer Details Label and Fields.
Then Verify LOAN DETAILS Label and Fields
Then Verify POLICY DETAILS Label and Fields.
Then verify export to excel button is present.
Examples:
|Validate_txt|username|password|
|Home        | skmr9896@gmail.com|Test@123|

    Scenario Outline: Reverse Feed Upload (Gops User)
      Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
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
      |tab| Validate_txt| username| password|
      |Reverse Feed Upload|Home|skmr9896@gmail.com|Test@123|