package com.gemini.PLIL.StepDefination;

import com.gemini.PLIL.Locators.Locator;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.sun.jdi.connect.Connector;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.checkerframework.common.value.qual.StringVal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.io.IOException;
import java.util.List;

public class StepDefination {
    @Given("^Enter username and password (.+),(.+)$")
    public void Enter_Username_Paasword(String Username, String Password) throws IOException {
        // DriverAction.click(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div/div/div[1]/div"));
        DriverAction.typeText(Locator.Email, Username);
        DriverAction.waitSec(2);
        DriverAction.typeText(Locator.Password, Password);
        DriverAction.waitSec(10);

    }

    @Given("^Enter  password without Username (.+)$")
    public void Enter_Paasword_WithoutUsername(String Password) throws IOException {
        DriverAction.typeText(Locator.Password, Password);
        DriverAction.waitSec(10);
    }

    @Given("^Enter Username without Password (.+)$")
    public void Enter_Username_WithoutPassword(String Username) throws IOException {
        DriverAction.typeText(Locator.Email, Username);
        DriverAction.waitSec(10);
    }

    @Then("^Login and validate (.+),(.+)$")
    public void LoginandValidate(String Validate_txt, String Req_Error) throws IOException {
        DriverAction.waitSec(15);
        DriverAction.click(Locator.LoginBtn);
        String EmailError = DriverAction.getElement(By.xpath(Locator.Error.replace("Error_msg", Req_Error))).getText();
        Boolean isPassed = false;
        if (EmailError.equals(Validate_txt)) {
            isPassed = true;
        }
        if (isPassed) {
            GemTestReporter.addTestStep("Validation", "User Successfully login", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "User not able to login", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("^Login and validate wrong Password message$")
    public void LoginandValidateWrongPassword() throws IOException {
        DriverAction.waitSec(15);
        DriverAction.click(Locator.LoginBtn);
        //String EmailError = DriverAction.getElement(By.xpath(Locator.Error.replace("Error_msg",Req_Error))).getText();
        Boolean isPassed = false;
        if (DriverAction.isExist(Locator.InvalidPassword)) {
            isPassed = true;
        }

        if (isPassed) {
            GemTestReporter.addTestStep("Validation", "User Successfully login", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "User not able to login", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("^Click on Login button and Validate (.+)$")
    public void ClickLogin(String Validate_txt) throws IOException {
        DriverAction.click(Locator.LoginBtn);
        DriverAction.waitSec(15);
        String Home = DriverAction.getElement(Locator.HomeScreen).getText();
        Boolean isPassed = false;
        if (Home.equals(Validate_txt)) {
            isPassed = true;
        }
        if (isPassed) {
            GemTestReporter.addTestStep("Validation", "User Successfully login", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "User not able to login", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @Then("^Validate  Error after login (.+),(.+)$")
    public void ClickLoginWithoutEmail(String Validate_txt1, String Req_Error) throws IOException {
        DriverAction.waitSec(15);
        DriverAction.click(Locator.LoginBtn);
        String EmailError = DriverAction.getElement(By.xpath(Locator.Error.replace("Error_msg", Req_Error))).getText();
        Boolean isPassed = false;
        if (EmailError.equals(Validate_txt1)) {
            isPassed = true;
        }
        if (isPassed) {
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
        Boolean isPassed = false;
        if (str_Logout.contains("login")) {
            isPassed = true;
        }
        if (isPassed) {
            GemTestReporter.addTestStep("Validation", "User Successfully logout", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "User not able to logout", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @Given("^Validate UI Elements (.+),(.+),(.+),(.+),(.+),(.+),(.+)$")
    public void Validate_Ui_Elements(Boolean Logo, Boolean Welcome_Label, Boolean Email, Boolean Password, Boolean Login_Button, Boolean Captcha, Boolean ClickHere_Link) {

        Boolean isPassed = false;

        if (DriverAction.getElement(Locator.Logo).isDisplayed()){
            isPassed = true;
            GemTestReporter.addTestStep("Validation", "Logo is present on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else {
            isPassed = false;
            GemTestReporter.addTestStep("Validation", "Logo is not present on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (DriverAction.getElement(Locator.Welcome).isDisplayed()) {
            isPassed = true;
            GemTestReporter.addTestStep("Validation", "Welcome Label is present on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else {
            isPassed = false;
            GemTestReporter.addTestStep("Validation", "Welcome Label is not present on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
        }

        if (DriverAction.getElement(Locator.Email_Id).isDisplayed()){
            isPassed = true;
            GemTestReporter.addTestStep("Validation", "Email Input is present on Login Page", STATUS.PASS, DriverAction.takeSnapShot());

        }
        else {
            isPassed = false;
            GemTestReporter.addTestStep("Validation", "Email Input is not present on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());

        }
            if (DriverAction.getElement(Locator.Password_Id).isDisplayed()){
                isPassed = true;
                GemTestReporter.addTestStep("Validation", "Password Input is present on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else {
                isPassed = false;
                GemTestReporter.addTestStep("Validation", "Password Input is not present on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        if (DriverAction.getElement(Locator.Password_Eye_Before_Click).isDisplayed()) {
            String str_before_click = DriverAction.getElement(Locator.Password_Eye_Before_Click).getText();
            String str_after_click = "";
            DriverAction.click(Locator.Password_Eye_Before_Click);
            DriverAction.waitSec(2);
            str_after_click = DriverAction.getElement(Locator.Password_Eye_After_Click).getText();
            if (!str_before_click.equals(str_after_click))
                GemTestReporter.addTestStep("Validation", "Eye icon is clickable on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else {
            isPassed = false;
            GemTestReporter.addTestStep("Validation", "Eye icon is not clickable  on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (DriverAction.getElement(Locator.Login).isDisplayed()) {
            String str_before_login = DriverAction.getCurrentURL();
            String str_after_login = "";
            System.out.print("Before Login Click ->:" + str_before_login);
            DriverAction.click(Locator.Login);
            str_after_login = DriverAction.getCurrentURL();
            System.out.print("After Login Click -> " + str_after_login);
            if (!str_after_login.equals(str_before_login)) {
                GemTestReporter.addTestStep("Validation", "Login button is clickable on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validation", "Login button is not clickable  on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        }else {
            isPassed = false;
            GemTestReporter.addTestStep("Validation", "Login button is not present   on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
        }


        if (DriverAction.getElement(Locator.Forgot_Label).isDisplayed()) {
            isPassed = true;
            GemTestReporter.addTestStep("Validation", "Forgot Label is present on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else {
            isPassed = false;
            GemTestReporter.addTestStep("Validation", "Forgot Label is not present   on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
        }

        if (DriverAction.getElement(Locator.Click_Here).isDisplayed()) {
            String str_before = DriverAction.getCurrentURL();
            String str_after = "";
            System.out.print("Before Click ->:" + str_before);
            DriverAction.click(Locator.Click_Here);
            str_after = DriverAction.getCurrentURL();
            System.out.print("After Click -> " + str_after);
            if (!str_after.equals(str_before))
            {
                GemTestReporter.addTestStep("Validation", "Click Here is clickable on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "Click Here is not clickable  on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        } else {
            isPassed = false;
            GemTestReporter.addTestStep("Validation", "Click Here is not present   on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (isPassed) {
            GemTestReporter.addTestStep("Validation", "UI Elements are visible", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "UI Elements are not visible", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @Given("^Click on Forgot Password Link and verify$")
    public void ForgotPassword_And_Verify() throws IOException {
        if (DriverAction.getElement(Locator.Click_Here).isDisplayed()) {
            DriverAction.click(Locator.Click_Here);
        }
        Boolean isPassed = false;
        DriverAction.waitSec(3);
        if (DriverAction.getElement(Locator.ForgotPassword_Text).isDisplayed()) {
            isPassed = true;
        }

        if (isPassed) {
            GemTestReporter.addTestStep("Validation", "Successfully Navigate to Reset Password screen", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "Not able to Navigate to Reset Password screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("^Verify Logo,Forgot Password Label (.+)$")
    public void VerifyForgotPasswordUi(String Username) throws IOException {

        Boolean isPassed = false;
        if (DriverAction.getElement(Locator.Logo).isDisplayed()) {
            isPassed = true;
        }
        if (DriverAction.getElement(Locator.ForgotPassword_Label).isDisplayed()) {
            isPassed = true;
        }
        if (DriverAction.getElement(Locator.Email_Id).isDisplayed()) {
            isPassed = true;
        }
        if (DriverAction.getElement(Locator.RequestOtpBtn).isDisplayed()) {
            isPassed = true;
            if (isPassed) {
                DriverAction.typeText(Locator.Email, Username);
                DriverAction.click(Locator.RequestOtpBtn);
                if (DriverAction.getElement(Locator.Verification).isDisplayed()) {
                    isPassed = true;
                }

            }
        }


        if (isPassed) {
            GemTestReporter.addTestStep("Validation", "Required data is available on Forgot Password ui", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "Required data is not  available on Forgot Password ui", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("^verify Here Link$")
    public void VerifyHereLink() throws IOException {

        Boolean isPassed = false;
        if (DriverAction.getElement(Locator.Click_Here_Link).isDisplayed()) {
            isPassed = true;
            if (isPassed) {
                DriverAction.click(Locator.Click_Here_Link);
                if (DriverAction.getElement(Locator.LoginBtn).isDisplayed()) {
                    isPassed = true;
                }
            }

        }

        if (isPassed) {
            GemTestReporter.addTestStep("Validation", "Required data is available on Forgot Password ui", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "Required data is not  available on Forgot Password ui", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("^validate set new password screen (.+),(.+),(.+),(.+)$")
    public void EnterUsername(String new_pass,String confirm_pass,String Req_Label,String Home_Screen_Label) throws IOException {
        DriverAction.waitSec(30);
        DriverAction.click(Locator.Verifybtn);
        Boolean isPassed=false;
        if (DriverAction.getElement(Locator.setnewpassword_label).isDisplayed()) {
            isPassed=true;
            String Fetched_Label = DriverAction.getElement(Locator.setnewpassword_label).getText();
            if(Fetched_Label.equals(Req_Label)) {
                GemTestReporter.addTestStep("Validation", "Successfully  navigate to set new password screen and Expected Label-> " + Req_Label + " Actual Label-> " + Fetched_Label, STATUS.PASS, DriverAction.takeSnapShot());
            }
            else {
                GemTestReporter.addTestStep("Validation", "Successfully navigate to set new password screen but There is Mismatch of <br> Expected Label-> " + Req_Label + " Actual Label-> " + Fetched_Label, STATUS.FAIL, DriverAction.takeSnapShot());

            }
            }
        else
        {
            GemTestReporter.addTestStep("Validation", "Not able to navigate to set new password screen ", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (DriverAction.getElement(Locator.New_Password).isDisplayed()) {
            isPassed=true;
            GemTestReporter.addTestStep("Validation", "New Password input is visible on set new password screen", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.typeText(Locator.New_Password,new_pass);
        }
        else
        {
            isPassed = false;
            GemTestReporter.addTestStep("Validation", "New Password input is not visible on set new password screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (DriverAction.getElement(Locator.Confirm_Password).isDisplayed()) {
            isPassed=true;
            GemTestReporter.addTestStep("Validation", "Confirm Password input is visible on set new password screen", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.typeText(Locator.Confirm_Password,confirm_pass);
        }
        else
        {
            isPassed = false;
            GemTestReporter.addTestStep("Validation", "Confirm Password input is not visible on set new password screen", STATUS.FAIL, DriverAction.takeSnapShot());

        }
        if (DriverAction.getElement(Locator.SetNewPassword_btn).isDisplayed()) {
            isPassed=true;
            GemTestReporter.addTestStep("Validation", "Set new Password button  is visible on set new password screen", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.waitSec(15);
            DriverAction.click(Locator.SetNewPassword_btn);
        }
        if (DriverAction.getElement(Locator.Password_Updated_Label).isDisplayed()) {
            isPassed=true;
            GemTestReporter.addTestStep("Validation", "Password Updated label is visible on set new password screen", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            isPassed = false;
            GemTestReporter.addTestStep("Validation", "Password Updated label is not visible on set new password screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (DriverAction.getElement(Locator.Tick_img).isDisplayed()) {
            isPassed=true;
            GemTestReporter.addTestStep("Validation", "Green Tick is visible on set new password updated popup screen", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            isPassed = false;
            GemTestReporter.addTestStep("Validation", "Green Tick is not visible on set new password updated popup screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (DriverAction.getElement(Locator.Login_Link).isDisplayed()) {
            isPassed=true;
            GemTestReporter.addTestStep("Validation", "Login Link is visible on set new password updated popup screen", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.click(Locator.Login_Link);
        }
        else
        {
            isPassed = false;
            GemTestReporter.addTestStep("Validation", "Login Link is not visible on set new password  updated popup screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (DriverAction.getElement(Locator.Welcome).isDisplayed()) {
            isPassed=true;
            String Fetched_Label = DriverAction.getElement(Locator.Welcome).getText();
            if(Fetched_Label.equals(Home_Screen_Label)) {
                GemTestReporter.addTestStep("Validation", "User navigated to Home screen  and Expected Label->" + Home_Screen_Label + "Actual Label->" + Fetched_Label, STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Validation", "User navigated to Home screen  but There is Mismatch of Expected Label->" + Home_Screen_Label + "Actual Label->" + Fetched_Label, STATUS.FAIL, DriverAction.takeSnapShot());

            }
            }
        else {
            isPassed = false;
            GemTestReporter.addTestStep("Validation", "User is not navigated to Home screen", STATUS.FAIL, DriverAction.takeSnapShot());


        }


    }
        @Then("^Username is Entered (.+)$")
    public void EnterUsername(String Username) throws IOException {

        Boolean isPassed = false;
        if (DriverAction.getElement(Locator.Email_Id).isDisplayed()) {
            DriverAction.click(Locator.Email);
            DriverManager.getWebDriver().findElement(Locator.Email).clear();
            DriverAction.typeText(Locator.Email,Username.trim());
            DriverAction.click(Locator.RequestOtpBtn);

            isPassed=true;
        }
        if (isPassed) {
            GemTestReporter.addTestStep("Validation", "Username is typed and it navigate to respective screen", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "Username is not typed and it has not navigate to respective screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
    @Then("^Enter Username and validate (.+)$")
    public void EnterUsernameWrongvalidate(String Username) throws IOException {

        Boolean isPassed = false;
        if (DriverAction.getElement(Locator.Email_Id).isDisplayed()) {
            DriverAction.click(Locator.Email);
            DriverManager.getWebDriver().findElement(Locator.Email).clear();
            DriverAction.typeText(Locator.Email,Username.trim());
            DriverAction.click(Locator.RequestOtpBtn);
        }
        if (DriverAction.getElement(Locator.Email_Doest_Not_msg).isDisplayed()) {
            isPassed = true;

        }
        if (isPassed) {
            GemTestReporter.addTestStep("Validation", "Required Error message appear at Forgot Password ui", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "Required Error message is not appear at Forgot Password ui", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("^verify Forgot Password Ui$")
    public void VerifyForgotPasswordUi() throws IOException {

        Boolean isPassed = false;
        if (DriverAction.getElement(Locator.Logo).isDisplayed()){
            isPassed=true;
            if (isPassed) {
                GemTestReporter.addTestStep("Validation", "Required Logo is present on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validation", "Required Logo is present on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());
            }

    }
        isPassed = false;
        if (DriverAction.getElement(Locator.Verification).isDisplayed()){
            isPassed=true;
            if (isPassed) {
                GemTestReporter.addTestStep("Validation", "Required Verification label is present on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
            }
        }
        else {
            GemTestReporter.addTestStep("Validation", "Required Verification label is not present on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        isPassed = false;
        List<WebElement> list= DriverAction.getElements(By.xpath("//div[@class='ng-otp-input-wrapper wrapper ng-star-inserted']//input"));
if(list.size()==4)
{
    isPassed=true;
}
        if (DriverAction.getElement(Locator.Time).isDisplayed()){
            isPassed=true;
            if (isPassed) {
                GemTestReporter.addTestStep("Validation", "Time is present on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
            }
        }
        else {
            GemTestReporter.addTestStep("Validation", "Time is not present on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        isPassed = false;
        if (DriverAction.getElement(Locator.Verifybtn).isDisplayed()){
            isPassed=true;
            if (isPassed) {
                GemTestReporter.addTestStep("Validation", "Verify button present on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
            }
        }
        else {
            GemTestReporter.addTestStep("Validation", "Verify button not present on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        isPassed = false;
        for(int i=1;i<list.size()+1;i++)
        {
           String str =Integer.toString(i);
            DriverAction.typeText(By.xpath(Locator.otp.replace("itr",String.valueOf(i))),String.valueOf(i));
        }
        DriverAction.click(Locator.Verifybtn);
        if (DriverAction.getElement(Locator.invalidotp_error).isDisplayed()){
            isPassed=true;
            if (isPassed) {
                GemTestReporter.addTestStep("Validation", "Required message appear on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
            }
        }
        else {
            GemTestReporter.addTestStep("Validation", "Required message appear does not on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }
System.out.println(list.size());
}

    @Then("^Click Here Button and Validate$")
    public void ClickHereBtnandValidate() throws IOException {

        Boolean isPassed = false;
        if (DriverAction.getElement(Locator.Herebtn).isDisplayed()) {
            isPassed = true;
            if (isPassed) {
                GemTestReporter.addTestStep("Validation", "Here link is present on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
            }
            DriverAction.waitSec(61);
            if (isPassed) {
                DriverAction.click(Locator.Herebtn);
            }
            isPassed=false;
           if( DriverAction.getElement(Locator.OtpResendMsg).isDisplayed())
            {
                isPassed=true;
                if (isPassed) {
                    GemTestReporter.addTestStep("Validation", "Otp Resent message appear on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
                }
            }
           else {
               GemTestReporter.addTestStep("Validation", "Otp Resent message not appear  on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());
           }
        }
        else {
            GemTestReporter.addTestStep("Validation", "Here Link Logo is present on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("^Enter Invalid  Username and verify (.+),(.+)$")
    public void EnterInvalidUsernameValidation(String Username,String Req_msg) throws IOException {

        Boolean isPassed = false;
        if (DriverAction.getElement(Locator.Email_Id).isDisplayed()) {
            DriverAction.typeText(Locator.Email, Username);
            DriverAction.click(Locator.RequestOtpBtn);
        }
        String EmailError = DriverAction.getElement(Locator.InvalidMailError).getText();
if(EmailError.equals(Req_msg))
{
    isPassed=true;
}
        if (isPassed) {
            GemTestReporter.addTestStep("Validation", "Required pop up message appear on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "Required pop up message  appear not appear  on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    }
