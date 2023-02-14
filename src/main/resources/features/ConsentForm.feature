Feature: Consent Form
  Scenario Outline:
    Given Enter the Username and password for GOPS User and login
    Then Hit the given URL <url> to open the login form
    Then Verify that consent form got opened and all the sub-headings are visible
    Then Check whether Next button is present and click on it
    Then Check whether <Page2> got opened or not
    Then Check that on clicking Proceed without filling the mandatory fields,error is thrown
    Examples:
    | url | Page2|
    |https://uatconsent.pramericalife.in/user-consent/GCSPCH000003397?key=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXlsb2FkIjp7ImFwcGxpY2F0aW9uTnVtYmVyIjoiR0NTUENIMDAwMDAzMzk3In0sImlhdCI6MTY3NjM2Mjg3NSwiZXhwIjoxNzA3ODk4ODc1fQ.N8oOnkXE4RFnf4nR0t-x0jwjx_bpntwaJnGVWrjWn04|2|


