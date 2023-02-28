Feature: UserManagement

  Scenario: UserManagement
    Given enter email ID and password
    Then click on Captcha,Login
    Then verify logo on User management page.
    Then validate PLIL tabs
    Then verify User Management Tab is highlighted or not.
    Then verify hamburger button on the screen.
    Then verify create user button is visible or clickable.
    Then verify search text box with icon is present.
    Then verify all the table column field names.
    Then verify create user fields
    Then verify user should get created and also visible on user management screen.


  Scenario Outline: User Management screen (super Admin user)
    Given Enter Username and Password and validate <Validate_txt>,<username>,<password>
    Then Validate that Home page opens and logo is visible
    Then Click on <tab> and check that it got highlighted
    Then Check whether hamburgher button is present or not and clicking it minimizes the side bar
    Then Validate Logout button is present
    Then Validate whether <tab> label is present
    Then Validate whether Create User button is present and clickable
    Then Verify whether new user cannot be created or not with name <name1> , email <email>,mobile No <mobile1>
    Then Check whether user was created or not with correct field values
    Then Validate whether search button is present and working properly
    Then Check whether edit button works properly or not
    Then Validate whether Create User button is present and clickable
    Then Verify whether new user cannot be created or not with name <name2> , email <email>,mobile No <mobile2>
    Then Validate that user will not be able to create for the same email ID
    Then Check whether delete button works properly or not
    Then Click on the reset password button and check whether password email was sent


    Examples:
      |tab| name1| email| mobile1| name2| mobile2 |Validate_txt|username|password|
      |User Management| ABCD | tripta.sahni@geminisolutions.com|  9999999999  | BCDF | 8888888888|Home|deepak.kumar@geminisolutions.com|Asdf@1234|

