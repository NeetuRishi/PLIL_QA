package com.gemini.PLIL.StepDefination;

import com.gemini.PLIL.Locators.Locator;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.sql.Driver;

public class StepDefination {
    @Given("^Enter username and password")
    public void Enter_Username_Password() throws IOException {
        // DriverAction.click(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div/div/div[1]/div"));
        DriverAction.typeText(Locator.Email, "deepak.kumar@geminisolutions.com");
        DriverAction.typeText(Locator.Password, "Asdf@1234");
        DriverAction.waitSec(10);
        // DriverAction.click(Locator.LoginBtn);
    }

    @Then("Click on Login button")
    public void ClickLogin() throws IOException {
        DriverAction.click(Locator.LoginBtn);
        DriverAction.waitSec(10);
    }
    @Given ("^Validate UI Elements (.+),(.+),(.+),(.+),(.+),(.+),(.+)$")
    public void Validate_Ui_Elements(Boolean Logo,Boolean Welcome_Label,Boolean Email,Boolean Password,Boolean Login_Button,Boolean Captcha,Boolean ClickHere_Link) {

        Boolean isPassed = false;

        if (DriverAction.getElement(Locator.Logo).isDisplayed()) isPassed = true;
        else isPassed = false;

        if (DriverAction.getElement(Locator.Welcome).isDisplayed()) isPassed = true;
        else isPassed = false;

        if(DriverAction.getElement(Locator.Email_Id).isDisplayed()) isPassed = true;
        else isPassed = false;

        if(DriverAction.getElement(Locator.Password_Id).isDisplayed()) isPassed = true;
        else isPassed = false;

        if(DriverAction.getElement(Locator.Password_Eye_Before_Click).isDisplayed())
        {
            String str_before_click = DriverAction.getElement(Locator.Password_Eye_Before_Click).getText();
            String str_after_click ="";
            isPassed = true;
            if(isPassed)
            {
                DriverAction.click(Locator.Password_Eye_Before_Click);
                DriverAction.waitSec(2);
                str_after_click = DriverAction.getElement(Locator.Password_Eye_After_Click).getText();
            }
            if(!str_before_click.equals(str_after_click)) isPassed= true;
            else isPassed = false;
        }
        else isPassed = false;
        if(DriverAction.getElement(Locator.Login).isDisplayed())
        {
            isPassed = true;
            String str_before_login = DriverAction.getCurrentURL();
            String str_after_login="";
            System.out.print("Before Login Click ->:"+str_before_login);
            if(isPassed)
            {
                DriverAction.click(Locator.Login);
                str_after_login = DriverAction.getCurrentURL();
                System.out.print("After Login Click -> "+str_after_login);
            }
            if(!str_after_login.equals(str_before_login))  isPassed = true;
            else isPassed = false;
        }
        else isPassed = false;

        if(DriverAction.getElement(Locator.Forgot_Label).isDisplayed()) isPassed = true;
        else isPassed = false;

        if(DriverAction.getElement(Locator.Click_Here).isDisplayed())
        {
            isPassed = true;
            String str_before = DriverAction.getCurrentURL();
            String str_after="";
            System.out.print("Before Click ->:"+str_before);
            if(isPassed)
            {
                DriverAction.click(Locator.Click_Here);
                str_after = DriverAction.getCurrentURL();
                System.out.print("After Click -> "+str_after);
            }
            if(!str_after.equals(str_before))  isPassed = true;
            else isPassed = false;
        }
        else isPassed = false;

        if(isPassed){
            GemTestReporter.addTestStep("Validation", "UI Elements are visible", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "UI Elements are not visible", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

}

