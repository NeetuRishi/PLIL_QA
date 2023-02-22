package com.gemini.PLIL.StepDefination;

import com.gemini.PLIL.Locators.AdminLocators;
import com.gemini.PLIL.Locators.GopsUser_Locators;
import com.gemini.PLIL.Locators.superAdmin_Locators;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.core.internal.com.fasterxml.jackson.core.Base64Variant;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Admin {
//    @Then("^Verify whether tabs in the left pane are present and working$")
//    public void checkLeftTabs()
//    {
//
//    }

    @Then("^Validate whether (.+) label is present$")
    public void validateWhetherTabLabelIsPresent(String tab) {
        if (DriverAction.getElement(AdminLocators.userManagement(tab)).isDisplayed()) {
            GemTestReporter.addTestStep("Validate whether " + tab + " label is displayed or not", "Label is displayed successfully", STATUS.PASS, DriverAction.takeSnapShot());

        } else
            GemTestReporter.addTestStep("Validate whether " + tab + " label is displayed or not", "Label is not displayed", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Then("Validate whether Create User button is present and clickable")
    public void validateWhetherCreateUserButtonIsPresentAndClickable() {
        if (DriverAction.getElement(GopsUser_Locators.selectValue(" Create User ")).isDisplayed()) {
            GemTestReporter.addTestStep("Validate whether Create User button is present or not", "Create User Button is found", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.getElement(GopsUser_Locators.selectValue(" Create User ")).click();
            GemTestReporter.addTestStep("Click on the button", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());

        } else
            GemTestReporter.addTestStep("Validate whether Create User Button is present or not", "Button could not be found", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @Then("Validate whether search button is present and working properly")
    public void validateWhetherSearchButtonIsPresentAndWorkingProperly() {
        if (DriverAction.getElement(AdminLocators.input("Search")).isDisplayed()) {
            GemTestReporter.addTestStep("Validate whether Search button is present or not", "Search Button is visible", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.getElement(AdminLocators.input("Search")).sendKeys("ABCD"+ Keys.ENTER);
            GemTestReporter.addTestStep("Type in the user ABCD in the search box and hit enter","Action performed successfully",STATUS.PASS,DriverAction.takeSnapShot());
            WebDriverWait wait=new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]")));
            GemTestReporter.addTestStep("Validate whether Search was successful or not","Search was successful",STATUS.PASS,DriverAction.takeSnapShot());
        } else
            GemTestReporter.addTestStep("Validate whether Search button is present or not", "Could not find Search button", STATUS.FAIL, DriverAction.takeSnapShot());

    }

    @Then("^Verify whether new user cannot be created or not with name (.+) , email (.+),mobile No (.+)$")
    public void verifyWhetherUserIsAbleToEnterDataInDifferentFieldsOfCreateUserScreenOrNot(String name,String email,String mobile)
    {
        if (DriverAction.getElement(GopsUser_Locators.selectValue(" Enter the User details for which has to be onboarded ")).isDisplayed())
            GemTestReporter.addTestStep("Validate whether ' Enter the User details for which has to be onboarded ' string is displayed or not", "Displayed successfully", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Validate whether ' Enter the User details for which has to be onboarded ' string is displayed or not", "Could not be displayed successfully", STATUS.FAIL, DriverAction.takeSnapShot());

        if (DriverAction.getElement(AdminLocators.input("Name")).isDisplayed())
        {
            GemTestReporter.addTestStep("Check whether Name input box is present or not", "Name input box is present", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.getElement(AdminLocators.input("Name")).sendKeys(name);
            GemTestReporter.addTestStep("Validate whether user is able to enter into the Name input box or not", "Text was entered successfully", STATUS.PASS, DriverAction.takeSnapShot());
        }

        if (DriverAction.getElement(AdminLocators.input("Email ID")).isDisplayed())
        {
            DriverAction.waitSec(3);
            GemTestReporter.addTestStep("Check whether Email ID input box is present or not", "Email ID input box is present", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.getElement(AdminLocators.input("Email ID")).sendKeys(email);

            GemTestReporter.addTestStep("Validate whether user is able to enter into the Email ID input box or not", "Text was entered successfully", STATUS.PASS, DriverAction.takeSnapShot());
        }

        if (DriverAction.getElement(AdminLocators.input("Mobile No.")).isDisplayed())
        {
            DriverAction.waitSec(3);
            GemTestReporter.addTestStep("Check whether Mobile No. input box is present or not", "Mobile No. Input box is present", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.getElement(AdminLocators.input("Mobile No.")).sendKeys(mobile);

            GemTestReporter.addTestStep("Validate whether user is able to enter into the Mobile No. input box or not", "Text was entered successfully", STATUS.PASS, DriverAction.takeSnapShot());
        }
            DriverAction.getElement(AdminLocators.roleDropdown).click();
        GemTestReporter.addTestStep("Click on the role dropdown","Clicked successfully",STATUS.PASS,DriverAction.takeSnapShot());
DriverAction.getElement(AdminLocators.roleDropdownMenu("GOPS")).click();
GemTestReporter.addTestStep("Select a value from dropdown","GOPS selected successfully",STATUS.PASS,DriverAction.takeSnapShot());
DriverAction.getElement(GopsUser_Locators.selectValue(" Create User ")).click();
GemTestReporter.addTestStep("Click on create user button","Clicked successfully",STATUS.PASS,DriverAction.takeSnapShot());
    }

    @Then("Check whether user was created or not with correct field values")
    public void checkWhetherUserWasCreatedOrNot() {
        if(DriverAction.getElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText().equals("tripta.sahni@geminisolutions.com"))
            GemTestReporter.addTestStep("Verify whether user was created or not","User got created successfully",STATUS.PASS,DriverAction.takeSnapShot());
    }

    @Then("Check whether edit button works properly or not")
    public void checkWhetherEditButtonWorksProperlyOrNot() {
        String beforeEdit=DriverAction.getElement(By.xpath("//table/tbody/tr[1]/td[5]")).getText();

           DriverAction.getElement(superAdmin_Locators.edit).click();
           GemTestReporter.addTestStep("Click on the edit button","Click action performed successfully",STATUS.PASS,DriverAction.takeSnapShot());
        DriverAction.getElement(AdminLocators.roleDropdown).click();
        GemTestReporter.addTestStep("Click on the role dropdown","Clicked successfully",STATUS.PASS,DriverAction.takeSnapShot());
        DriverAction.getElement(AdminLocators.roleDropdownMenu("Write")).click();
        GemTestReporter.addTestStep("Change the role of the user","Changed successfully",STATUS.PASS,DriverAction.takeSnapShot());
        DriverAction.getElement(GopsUser_Locators.selectValue(" Update User ")).click();
        GemTestReporter.addTestStep("Click on update user","Clicked successfully",STATUS.PASS,DriverAction.takeSnapShot());
        String afterEdit=DriverAction.getElement(By.xpath("//table/tbody/tr[1]/td[5]")).getText();
        if(beforeEdit!=afterEdit)
            GemTestReporter.addTestStep("Validate whether edit button is working fine or not","Role before edit was "+beforeEdit+" .Role after edit is "+afterEdit+". Hence ,Edit button works properly",STATUS.PASS,DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Validate whether edit button is working fine or not","Role before edit was "+beforeEdit+" .Role after edit is "+afterEdit+". Hence ,Edit button did not work properly",STATUS.FAIL,DriverAction.takeSnapShot());

    }

    @Then("Check whether delete button works properly or not")
    public void checkWhetherDeleteButtonWorksProperlyOrNot() {
        String firstRowBeforeDelete=DriverAction.getElement(AdminLocators.emailValue).getText();
        DriverAction.getElement(superAdmin_Locators.deleteButton).click();
        GemTestReporter.addTestStep("Click on the delete button of row 1st","Clicked successfully",STATUS.PASS,DriverAction.takeSnapShot());
        DriverAction.waitSec(5);
        String firstRowAfterDelete=DriverAction.getElement(AdminLocators.emailValue).getText();
        if(firstRowAfterDelete.equals(firstRowBeforeDelete))
            GemTestReporter.addTestStep("Check whether row got deleted or not","Row was not deleted ",STATUS.FAIL,DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether row got deleted or not","Row was deleted successfully",STATUS.PASS,DriverAction.takeSnapShot());
    }

    @Then("Validate that user will not be able to create for the same email ID")
    public void validateThatUserWillNotBeAbleToCreateForTheSameEmailID()
    {
        DriverAction.getElement(GopsUser_Locators.selectValue(" Create User ")).click();
        GemTestReporter.addTestStep("Click on create User","Clicked on Create User",STATUS.PASS,DriverAction.takeSnapShot());

        WebDriverWait wait=new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AdminLocators.emailAlreadyTaken));
        if(true)
            GemTestReporter.addTestStep("Check whether User with same Email ID was cretaed or not","User could not be created",STATUS.PASS,DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether User with same Email ID was cretaed or not","User was created",STATUS.FAIL,DriverAction.takeSnapShot());
            DriverAction.getElement(GopsUser_Locators.selectValue(" Discard ")).click();


    }

    @Then("Click on the reset password button and check whether password email was sent")
    public void clickOnTheResetPasswordButton() {
        DriverAction.getElement(AdminLocators.resetPassword).click();
        GemTestReporter.addTestStep("Click on the reset password button","Clicked successfully",STATUS.PASS,DriverAction.takeSnapShot());
        if(DriverAction.getElement(By.xpath("//span[text()='Password reset successfully']")).isDisplayed())
            GemTestReporter.addTestStep("Check whether password was reset successfully","Password email was sent",STATUS.PASS,DriverAction.takeSnapShot());
    }
}