package com.gemini.PLIL.StepDefination;

import com.gemini.PLIL.Locators.Locator;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import java.io.IOException;

public class StepDefination {
    @Given("^Enter username and password (.+),(.+)$")
    public void Enter_Username_Paasword(String Username, String Password) throws IOException {
        // DriverAction.click(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div/div/div[1]/div"));
        DriverAction.typeText(Locator.Email, Username);
        DriverAction.waitSec(2);
        DriverAction.typeText(Locator.Password, Password);
        DriverAction.waitSec(10);

    }

    @Then("^Click on Login button and Validate (.+)$")
    public void ClickLogin(String Validate_txt) throws IOException {
        DriverAction.click(Locator.LoginBtn);
        DriverAction.waitSec(15);
        String Home = DriverAction.getElement(Locator.HomeScreen).getText();
        Boolean isPassed=false;
        if(Home.equals(Validate_txt))
        {
            isPassed=true;
        }
        if(isPassed){
            GemTestReporter.addTestStep("Validation", "User Successfully login", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "User not able to login", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @Then("^Logout and verify$")
    public void LogoutandVerify() throws IOException {
        DriverAction.click(Locator.Logout);
        DriverAction.waitSec(15);
        String str_Logout = DriverAction.getCurrentURL();
        Boolean isPassed=false;
        if(str_Logout.contains("login"))
        {
            isPassed=true;
        }
        if(isPassed){
            GemTestReporter.addTestStep("Validation", "User Successfully logout", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "User not able to logout", STATUS.FAIL, DriverAction.takeSnapShot());
        }

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
