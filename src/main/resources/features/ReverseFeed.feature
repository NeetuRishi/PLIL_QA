Feature: Reverse Feed

  Scenario: Reverse Feed Login
    Given enter email ID and password
    Then click on Captcha,Login
    Then validate the PLIL Logo
    Then validate PLIL tabs
    Then validate Reverse tab
    Then verify hamburger button on the screen.
    Then verify filter by label.
    Then verify Status Field is present and clickable.
    Then verify Date Field is present and clickable.
    Then verify user able to select date from calendar.
    Then verify search bar is present and user able to search.
    Then verify Reverse Feed after login check table column names
    Then verify eye option is working in View Details  Column.
    Then verify pagination is visible and right & light buttons are working
    Then verify Reverse Feed export to excel button is present