Feature: Consent Form

  Scenario Outline:
#    Given Enter the Username and password for GOPS User and login
#    Then Hit the given URL <url> to open the login form
    Then Verify that consent form got opened and all the sub-headings are visible
    Then Check that all the fields under each sub-headings are autofilled
    Then Check whether Next button is present and click on it
    Then Check whether <Page2> got opened or not
    Then Check that on clicking Proceed without filling the mandatory fields,error is thrown for <Page2>
    Then Check whether user has opted for Primary Insured or Joint Life,Then check whether height and weight input boxes are present
    Then Check whether user is able to type into the input boxes or not
    Then Check whether all medical history questions are present or not
    Then Check that when user clicks on Yes radio button of any medical question,few input boxes start appearing below the question
    Then Check that user when clicks on the check box to enable all No Radio buttons for <Page2>
    Then Check that user clicks on each Yes radio button one by one and few input boxes get added to the DOM and check that user is able to type text into the input box

    Then Click on Proceed button
    Then Check whether <Page3> got opened or not
    Then Check that user when clicks on the check box to enable all No Radio buttons for <Page3>
#    Then Check that user clicks on 'Please select, in case response to all above questions is No.' check box of <Page3> and then all the No radio boxes are enabled
    Then Check that two reason input boxes start appearing
    Then Check that on clicking Proceed without filling the mandatory fields,error is thrown for <Page3>
    Then Type in some value in the input boxes and click on proceed
    Then Check whether <Page4> got opened or not
    Then Check that on clicking Proceed without Checking the mandatory fields,The text adjacent to the input box turns red
    Then Check the mandatory boxes and click on proceed
    Then Check that Consent Approval card pops up
    Then Check that Resend OTP , Submit and Cancel button appears
    Then Check that OTP input boxes are present and are able to take input
    Examples:
      | url                                                                                                                                                                                                                                                                      | Page2 | Page3 | Page4 |
      | https://uatconsent.pramericalife.in/user-consent/GCSPCH000003397?key=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXlsb2FkIjp7ImFwcGxpY2F0aW9uTnVtYmVyIjoiR0NTUENIMDAwMDAzMzk3In0sImlhdCI6MTY3NjM2Mjg3NSwiZXhwIjoxNzA3ODk4ODc1fQ.N8oOnkXE4RFnf4nR0t-x0jwjx_bpntwaJnGVWrjWn04 | 2     | 3     | 4     |



