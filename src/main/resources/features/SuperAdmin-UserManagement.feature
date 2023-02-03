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
