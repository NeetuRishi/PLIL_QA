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

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepDefination {
    Logger logger = LoggerFactory.getLogger(StepDefination.class);
    @Given("^Enter username and password$")
    public void Enter_Username_Paasword() throws IOException {
        try {
            DriverAction.typeText(Locator.Email_Input_Field, "deepak.kumar@geminisolutions.com");
            DriverAction.setImplicitTimeOut(2);
            WebElement ele = DriverManager.getWebDriver().findElement(Locator.Password_Input_Field);
            ele.sendKeys("Asdf@1234");
            GemTestReporter.addTestStep("Password", "****", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.waitSec(10);
        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }

    }
    @Then("^Enter username and Password and login without selecting captcha (.+)$")
    public void Enterwithoutcaptcha(String Req_Error) throws IOException, AWTException {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_F5);
            robot.keyRelease(KeyEvent.VK_F5);
            DriverAction.typeText(Locator.Email_Input_Field, "deepak.kumar@geminisolutions.com");
            DriverAction.setImplicitTimeOut(2);
            //   DriverAction.typeText(Locator.Password_Input_Field,"Asdf@1234");
            WebElement ele = DriverManager.getWebDriver().findElement(Locator.Password_Input_Field);
            ele.sendKeys("Asdf@1234");
            GemTestReporter.addTestStep("Password", "****", STATUS.PASS, DriverAction.takeSnapShot());

            DriverAction.click(Locator.LoginBtn);
            if (DriverAction.getElement(By.xpath(Locator.Error.replace("Error_msg", Req_Error))).isDisplayed()) {
                GemTestReporter.addTestStep("Validating  without selecting captcha the required error mesaage pop up", "Required error of captcha appear on screen", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating  without selecting captcha the required error mesaage pop up", "Required error of captcha not appear on screen", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

        @Then("^Enter correct username and wrong password and validate (.+),(.+)$")
    public void Enter_Username_wrongPassword(String Username, String Password) throws IOException, AWTException {
          try {
              DriverAction.typeText(Locator.Email_Input_Field, Username);
              DriverAction.setImplicitTimeOut(2);
              //  DriverAction.typeText(Locator.Password_Input_Field, Password);
              WebElement ele = DriverManager.getWebDriver().findElement(Locator.Password_Input_Field);
              ele.sendKeys(Password);
              GemTestReporter.addTestStep("Password", "****", STATUS.PASS, DriverAction.takeSnapShot());
              DriverAction.waitSec(10);
              DriverAction.click(Locator.LoginBtn);
              if (DriverAction.isExist(Locator.InvalidPassword_msg)) {
                  GemTestReporter.addTestStep("Validating  entering wrong password the required error mesaage pop up", "Required error of invalid password appear on screen", STATUS.PASS, DriverAction.takeSnapShot());
              } else {
                  GemTestReporter.addTestStep("Validating  entering wrong password the required error mesaage pop up", "Required error of invalid password not appear on screen", STATUS.FAIL, DriverAction.takeSnapShot());
              }
          }
          catch (Exception e) {
              logger.info("An exception occurred!", e);
              GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
          }
    }
        @Then("^Enter wrong username and correct password and validate (.+),(.+)$")
    public void Enter_WrongUsername_Paasword(String Username, String Password) throws IOException, AWTException {
try {
    DriverAction.typeText(Locator.Email_Input_Field, Username);
    DriverAction.setImplicitTimeOut(2);
    //  DriverAction.typeText(Locator.Password_Input_Field, Password);
    WebElement ele = DriverManager.getWebDriver().findElement(Locator.Password_Input_Field);
    ele.sendKeys(Password);
    GemTestReporter.addTestStep("Password", "****", STATUS.PASS, DriverAction.takeSnapShot());

    DriverAction.waitSec(10);
    DriverAction.click(Locator.LoginBtn);
    // String EmailError = DriverAction.getElement(By.xpath(Locator.Error.replace("Error_msg", Req_Error))).getText();
    if (DriverAction.isExist(Locator.InvalidPassword_msg)) {
        GemTestReporter.addTestStep("Validating  entering wrong username the required error mesaage pop up", "Required error of invalid password appear on screen", STATUS.PASS, DriverAction.takeSnapShot());
    } else {
        GemTestReporter.addTestStep("Validating  entering wrong username the required error mesaage pop up", "Required error of invalid password not appear  on screen", STATUS.FAIL, DriverAction.takeSnapShot());
    }
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_F5);
    robot.keyRelease(KeyEvent.VK_F5);
}
catch (Exception e) {
    logger.info("An exception occurred!", e);
    GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
}
    }
    @Then("^Enter  password without Username (.+),(.+),(.+)$")
    public void Enter_Paasword_WithoutUsername(String Password,String Req_Error,String Validate_txt1) throws IOException {
       // DriverManager.getWebDriver().navigate().back();
        try {
            DriverAction.waitSec(10);
            // DriverAction.typeText(Locator.Password_Input_Field, Password);
            WebElement ele = DriverManager.getWebDriver().findElement(Locator.Password_Input_Field);
            ele.sendKeys(Password);
            GemTestReporter.addTestStep("Password", "****", STATUS.PASS, DriverAction.takeSnapShot());

            DriverAction.waitSec(15);
            DriverAction.click(Locator.LoginBtn);
            String EmailError = DriverAction.getElement(By.xpath(Locator.Error.replace("Error_msg", Req_Error))).getText();
            if (EmailError.equals(Validate_txt1)) {
                GemTestReporter.addTestStep("Validating without entering username the required error mesaage pop up", "Requird Error Message -> " + Validate_txt1 + " Actual Error Message-> " + Req_Error, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating without entering username the required error mesaage pop up", "Requird Error Message not matched" + Validate_txt1 + " Actual Error Message-> " + Req_Error, STATUS.FAIL, DriverAction.takeSnapShot());
            }
        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @Then("^Enter Username without Password (.+),(.+),(.+)$")
    public void Enter_Username_WithoutPassword(String Username,String Req_Error,String Validate_txt1) throws IOException, AWTException {
       try {
           Robot robot = new Robot();
           robot.keyPress(KeyEvent.VK_F5);
           robot.keyRelease(KeyEvent.VK_F5);

           DriverAction.typeText(Locator.Email_Input_Field, Username);
           DriverAction.waitSec(15);
           DriverAction.click(Locator.LoginBtn);
           String EmailError = DriverAction.getElement(By.xpath(Locator.Error.replace("Error_msg", Req_Error))).getText();
           if (EmailError.equals(Validate_txt1)) {
               GemTestReporter.addTestStep("Validating without entering password the required error mesaage pop up", "Requird Error Message -> " + Validate_txt1 + " Actual Error Message-> " + Req_Error, STATUS.PASS, DriverAction.takeSnapShot());
           } else {
               GemTestReporter.addTestStep("Validating without entering password the required error mesaage pop up", "Requird Error Message not matched" + Validate_txt1 + " Actual Error Message-> " + Req_Error, STATUS.FAIL, DriverAction.takeSnapShot());
           }
           robot.keyPress(KeyEvent.VK_F5);
           robot.keyRelease(KeyEvent.VK_F5);
       }
       catch (Exception e) {
           logger.info("An exception occurred!", e);
           GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
       }
    }


    @Then("^Navigate to subtab (.+)$")
    public void NavigateToSubtab(String subtab) throws IOException {
        try {
            DriverAction.click(By.xpath(Locator.sub_tab.replace("tab", subtab)));
            DriverAction.setImplicitTimeOut(2);
        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @Then("^Enter new Username (.+)$")
    public void EnterNewUser(String New_User) throws Exception {
        try {
            DriverAction.typeText(Locator.Email_Input_Field, New_User);
            DriverAction.waitSec(65);
            DriverAction.click(Locator.LoginBtn);
        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }

    }

    @Then("^Create User (.+),(.+),(.+),(.+),(.+),(.+),(.+),(.+)$")
    public void CreateUser(String Name,String Email,String Mobile,String Name_val,String Email_val,String Mobile_val,String val1,String val2) throws IOException {
     try {
         DriverAction.click(Locator.Createbtn);
         DriverAction.setImplicitTimeOut(5);
         DriverAction.typeText(By.xpath(Locator.inputbox.replace("input_name", Name)), Name_val);
         DriverAction.typeText(By.xpath(Locator.inputbox.replace("input_name", Email)), Email_val);
         DriverAction.typeText(By.xpath(Locator.inputbox.replace("input_name", Mobile)), Mobile_val);
         DriverAction.click(By.xpath(Locator.dropdown.replace("itr", String.valueOf(1))));
         DriverAction.click(By.xpath(Locator.dropdown_val.replace("val", val1)));
         DriverAction.click(By.xpath(Locator.dropdown.replace("itr", String.valueOf(2))));
         DriverAction.setImplicitTimeOut(4);
         DriverAction.click(By.xpath(Locator.dropdown_val.replace("val", val2)));
         DriverAction.click(Locator.Createbtn);
         Boolean isPassed = false;
         for (int i = 1; i <= 4; i++) {
             String val = DriverAction.getElement(By.xpath(Locator.FirstRow.replace("itr", String.valueOf(i)))).getText();
             if (val.equals(Name_val)) {
                 isPassed = true;
             } else if (val.equals(Email_val)) {
                 isPassed = true;
             } else if (val.equals(Mobile_val)) {
                 isPassed = true;
             } else if (val.equals(val2)) {
                 isPassed = true;
             }

         }
         if (isPassed) {
             GemTestReporter.addTestStep("Validation", "User is created successfully", STATUS.PASS, DriverAction.takeSnapShot());
         } else {
             GemTestReporter.addTestStep("Validation", "User is not created successfully", STATUS.FAIL, DriverAction.takeSnapShot());
         }
     }
     catch (Exception e) {
         logger.info("An exception occurred!", e);
         GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
     }
    }



    @Then("^Click on Login button and Validate (.+)$")
    public void ClickLogin(String Validate_txt) throws IOException {
        try {
            DriverAction.waitSec(15);
            DriverAction.click(Locator.LoginBtn);
            DriverAction.setImplicitTimeOut(15);
            String Home = DriverAction.getElement(Locator.HomeScreen).getText();
            Boolean isPassed = false;
            if (Home.equals(Validate_txt)) {
                isPassed = true;
            }
            if (isPassed) {
                GemTestReporter.addTestStep("Validating weather user able to login or not", "User Successfully login", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather user able to login or not", "User not able to login", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }

    }



    @Then("^Logout and verify$")
    public void LogoutandVerify() throws IOException {
        try {
            DriverAction.click(Locator.Logout);
            DriverAction.setImplicitTimeOut(15);
            String str_Logout = DriverAction.getCurrentURL();
            Boolean isPassed = false;
            if (str_Logout.contains("login")) {
                isPassed = true;
            }
            if (isPassed) {
                GemTestReporter.addTestStep("Validating weather user able to logout from Home page", "User Successfully logout", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather user able to logout from Home page", "User not able to logout", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @Given("^Validate UI Elements$")
    public void Validate_Ui_Elements() throws AWTException {
        try {

            Boolean isPassed = false;

            if (DriverAction.getElement(Locator.Logo).isDisplayed()) {

                GemTestReporter.addTestStep("Validating Presence of Required Logo on Login Page", " Required Logo is present on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
            } else {

                GemTestReporter.addTestStep("Validating Presence of Required Logo on Login Page", "Required Logo is not present on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.getElement(Locator.Welcome_Label).isDisplayed()) {

                GemTestReporter.addTestStep("Validating Presence of Required Welcome Label on Login Page", "Welcome Label is present on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
            } else {

                GemTestReporter.addTestStep("Validating Presence of Required Welcome Label on Login Page", "Welcome Label is not present on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
            }

            if (DriverAction.getElement(Locator.Email_Id).isDisplayed()) {

                GemTestReporter.addTestStep("Validating Presence of Required Email Input feild on Login Page", "Email Input is present on Login Page", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                isPassed = false;
                GemTestReporter.addTestStep("Validating Presence of Required Email Input feild on Login Page", "Email Input is not present on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Locator.Password_Id).isDisplayed()) {
                isPassed = true;
                GemTestReporter.addTestStep("Validating Presence of Required Password Input feild on Login Page", "Password Input is present on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                isPassed = false;
                GemTestReporter.addTestStep("Validating Presence of Required Password Input feild on Login Page", "Password Input is not present on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.getElement(Locator.Password_Eye_Before_Click).isDisplayed()) {
                String str_before_click = DriverAction.getElement(Locator.Password_Eye_Before_Click).getText();
                String str_after_click = "";
                DriverAction.click(Locator.Password_Eye_Before_Click);
                DriverAction.setImplicitTimeOut(2);
                str_after_click = DriverAction.getElement(Locator.Password_Eye_After_Click).getText();
                if (!str_before_click.equals(str_after_click))
                    GemTestReporter.addTestStep("Validating weather the eye icon is clickable or not on Login Page", "Eye icon is clickable on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather the eye icon is clickable or not on Login Page", "Eye icon is not clickable  on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.getElement(Locator.Forgot_Label).isDisplayed()) {
                GemTestReporter.addTestStep("Validating Presence of Required Forgot Label on Login Page", "Forgot Label is present on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
            } else {

                GemTestReporter.addTestStep("Validating Presence of Required Forgot Label on Login Page", "Forgot Label is not present   on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.getElement(Locator.Click_Here).isDisplayed()) {
                String str_before = DriverAction.getCurrentURL();
                String str_after = "";
                System.out.print("Before Click ->:" + str_before);
                DriverAction.click(Locator.Click_Here);
                str_after = DriverAction.getCurrentURL();
                System.out.print("After Click -> " + str_after);
                if (!str_after.equals(str_before)) {
                    GemTestReporter.addTestStep("Validating weather the Click here link is clickable or not on Login Page", "Click Here is clickable on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Validating weather the Click here link is clickable or not on Login Page", "Click Here is not clickable  on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
                }
            } else {
                isPassed = false;
                GemTestReporter.addTestStep("Validating Click Here link is present on Login page", "Click Here is not present   on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
            }

            DriverManager.getWebDriver().navigate().back();
            /////LOgin
            if (DriverAction.getElement(Locator.Login).isDisplayed()) {
                String str_before_login = DriverAction.getCurrentURL();
                DriverAction.typeText(Locator.Email_Input_Field, "deepak.kumar@geminisolutions.com");
                DriverAction.setImplicitTimeOut(2);
                DriverAction.typeText(Locator.Password_Input_Field, "Asdf@1234");
                DriverAction.waitSec(15);
                String str_after_login = "";
                System.out.print("Before Login Click ->:" + str_before_login);
                DriverAction.doubleClick(Locator.Login);
                DriverAction.setImplicitTimeOut(10);
                str_after_login = DriverAction.getCurrentURL();
                System.out.print("After Login Click -> " + str_after_login);
                if (!str_after_login.equals(str_before_login)) {
                    GemTestReporter.addTestStep("Validating weather the Login Button is clickable or not on Login Page", "Login button is clickable on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Validating weather the Login Button is clickable or not on Login Page", "Login button is not clickable  on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
                }
            } else {
                isPassed = false;
                GemTestReporter.addTestStep("Validating Login Button is Visible on Login Screen", "Login button is not present   on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }

    }



//upto this
            @Given("^Click on Forgot Password Link and verify$")
    public void ForgotPassword_And_Verify() throws IOException {
        try {
            if (DriverAction.getElement(Locator.Click_Here).isDisplayed()) {
                GemTestReporter.addTestStep("Validating the presence of ClicK Here Link on Login Screen", "Here Link is present on Login Screen", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.click(Locator.Click_Here);
            } else {
                GemTestReporter.addTestStep("Validating the presence of ClicK Here Link on Login Screen", "Here Link is not present on Login screen", STATUS.FAIL, DriverAction.takeSnapShot());
            }

            DriverAction.waitSec(3);
            if (DriverAction.getElement(Locator.ForgotPassword_Text).isDisplayed()) {

                GemTestReporter.addTestStep("Validating weather Forgot Password Label present  on Forgot Password screen", "Forgot Password Label is present on Forgot Password Screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {

                GemTestReporter.addTestStep("Validating weather Forgot Password Label present  on Forgot Password screen", "Forgot Password Label is not present on Forgot Password Screen", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @Then("^Verify Logo,Forgot Password Label (.+)$")
    public void VerifyForgotPasswordUi(String Username) throws IOException {
try {
    Boolean isPassed = false;
    DriverAction.waitSec(4);
    if (DriverAction.getElement(Locator.Logo).isDisplayed()) {

        GemTestReporter.addTestStep("Validating weather Required Logo is present on Forgot password screen", "Required Logo is present on Forgot password screen", STATUS.PASS, DriverAction.takeSnapShot());
    } else {

        GemTestReporter.addTestStep("Validating weather Required Logo is present on Forgot password screen", "Required Logo is not present on Forgot Password screen", STATUS.FAIL, DriverAction.takeSnapShot());
    }
    if (DriverAction.getElement(Locator.ForgotPassword_Label).isDisplayed()) {

        GemTestReporter.addTestStep("Validating weather Forgot Password Label is present on Forgot password screen", "Forgot Password Label is present on Forgot password screen", STATUS.PASS, DriverAction.takeSnapShot());
    } else {

        GemTestReporter.addTestStep("Validating weather Forgot Password Label is present on Forgot password screen", "Forgot Password Label is not present on Forgot Password screen", STATUS.FAIL, DriverAction.takeSnapShot());
    }
    if (DriverAction.getElement(Locator.Email_Id).isDisplayed()) {

        GemTestReporter.addTestStep("Validating weather Email input is present on Forgot password screen", "Email Input is present on Forgot password screen", STATUS.PASS, DriverAction.takeSnapShot());
    } else {

        GemTestReporter.addTestStep("Validating weather Email input is present on Forgot password screen", "Email Input is not present on Forgot Password screen", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    if (DriverAction.getElement(Locator.RequestOtpBtn).isDisplayed()) {
        isPassed = true;
        GemTestReporter.addTestStep("Validating weather Request Oyp button is present on Forgot password screen", "Request Otp button is present on Forgot password screen", STATUS.PASS, DriverAction.takeSnapShot());

        if (isPassed) {
            DriverAction.typeText(Locator.Email_Input_Field, Username);
            DriverAction.click(Locator.RequestOtpBtn);
            if (DriverAction.getElement(Locator.Verification).isDisplayed()) {

                GemTestReporter.addTestStep("Validating weather Verification label is present on Verification screen", "Verification label is present on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {

                GemTestReporter.addTestStep("Validating weather Verification label is present on Verification screen", "Verification label is not present on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());

            }

        }

    }
}
catch (Exception e) {
    logger.info("An exception occurred!", e);
    GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
}
    }
    @Then("^validate set new password ui$")
    public void VerifySetNewPasswordui() throws IOException {
        try {
            if (DriverAction.getElement(Locator.Logo).isDisplayed()) {

                GemTestReporter.addTestStep("Validating Presence of Required Logo on Login Page", " Required Logo is present on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
            } else {

                GemTestReporter.addTestStep("Validating Presence of Required Logo on Login Page", "Required Logo is not present on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.getElement(Locator.setnewpassword_label).isDisplayed()) {

                GemTestReporter.addTestStep("Validating Presence of Required Set New Password Label on Set New Password screen", "Set new Password  Label is present on Set New Password screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {

                GemTestReporter.addTestStep("Validating Presence of Required Set New Password Label on Set New Password screen", "Set new Password  Label is not present on Set New Password screen", STATUS.FAIL, DriverAction.takeSnapShot());
            }

            if (DriverAction.getElement(Locator.Password_Id).isDisplayed()) {

                GemTestReporter.addTestStep("Validating Presence of Required Password Input feild on Set New Password screen", "Password Input is present on Set New Password screen", STATUS.PASS, DriverAction.takeSnapShot());

            } else {

                GemTestReporter.addTestStep("Validating Presence of Required Password Input feild on Set New Password screen", "Password Input is not present on Set New Password screen", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Locator.confirmpassword).isDisplayed()) {

                GemTestReporter.addTestStep("Validating Presence of Required Confirm password Input feild on Set New Password screen", "Confirm Password Input is Set New Password screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {

                GemTestReporter.addTestStep("Validating Presence of Required Confirm password Input feild on Set New Password screen", "Confirm Password Input is Set New Password screen", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }

    }

    @Then("^Set New Password and validate (.+)$")
    public void Enter_New_Cred(String NewPass) throws IOException {
        try {
            DriverAction.typeText(Locator.Password_Id, NewPass.trim());
            DriverAction.typeText(Locator.confirmpassword, NewPass.trim());
            DriverAction.waitSec(15);
            if (DriverAction.getElement(Locator.set_passwordbtn).isDisplayed()) {
                GemTestReporter.addTestStep("Validating Presence of Required Set Password Button on Set New Password screen", "Set Password button  is present on Set New Password screen", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.click(Locator.set_passwordbtn);
                if (DriverAction.getElement(Locator.New_Password_Created).isDisplayed()) {
                    GemTestReporter.addTestStep("Validating weather Set Password button is clickable", "Set Password button is Clickable", STATUS.PASS, DriverAction.takeSnapShot());

                } else {
                    GemTestReporter.addTestStep("Validating weather Set Password button is clickable", "Set Password button is not Clickable", STATUS.FAIL, DriverAction.takeSnapShot());

                }

            } else {

                GemTestReporter.addTestStep("Validating Presence of Required Set Password Button on Set New Password screen", "Set Password button  is not present on Set New Password screen", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.getElement(Locator.Click_Here_Link).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Back to Login Link is Visible on Succesfully Created Popup", "Back to Login Link is Visible on Succesfully Created Popup", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.click(Locator.Click_Here_Link);
                if (DriverAction.getElement(Locator.Welcome_Label).isDisplayed()) {
                    GemTestReporter.addTestStep("Validating weather Back to Login Link is Clickable and Navigate to Login SCreen", "Back to Login Link is Clickable and Navigate to Login SCreen", STATUS.PASS, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Validating weather Back to Login Link is Clickable and Navigate to Login SCreen", "Back to Login Link is not Clickable ", STATUS.FAIL, DriverAction.takeSnapShot());

                }
            } else {
                GemTestReporter.addTestStep("Validating weather Back to Login Link is Visible on Succesfully Created Popup", "Back to Login Link is not Visible on Succesfully Created Popup", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }

    }
    @Then("^verify Here Link on Forgot Password screen$")
    public void VerifyHereLink() throws IOException {
try {
    if (DriverAction.getElement(Locator.Click_Here_Link).isDisplayed()) {
        GemTestReporter.addTestStep("Validating Click Here Link present on Forgot Password Screen", "Click Here Link is available on Forgot Password ui", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.click(Locator.Click_Here_Link);
        if (DriverAction.getElement(Locator.LoginBtn).isDisplayed()) {
            GemTestReporter.addTestStep("Validating weather user able to navigate to Login Page", "User succesfully navigate to Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validating weather user able to navigate to Login Page", "User not able to navigate to Login Page", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    } else {
        GemTestReporter.addTestStep("Validating Click Here Link present on Forgot Password Screen", "Click Here Link is not  available on Forgot Password ui", STATUS.FAIL, DriverAction.takeSnapShot());

    }
    DriverManager.getWebDriver().navigate().back();
}
catch (Exception e) {
    logger.info("An exception occurred!", e);
    GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
}

    }

    @Then("^Login with Wrong Password (.+)$")
    public void LoginWrongPass(String Wrong_Pass) throws IOException {
        // DriverAction.click(By.xpath("//*[@id=\"app-container\"]/div/div[3]/div[2]/div/div/div[1]/div"));
       try {
           DriverAction.typeText(Locator.Email_Input_Field, "rahul.adhikari@geminisolutions.com");
           DriverAction.setImplicitTimeOut(2);
           //  DriverAction.typeText(Locator.Password_Input_Field,Wrong_Pass);
           WebElement ele = DriverManager.getWebDriver().findElement(Locator.Password_Input_Field);
           ele.sendKeys(Wrong_Pass);
           GemTestReporter.addTestStep("Password", "****", STATUS.PASS, DriverAction.takeSnapShot());

           DriverAction.waitSec(15);
           DriverAction.click(Locator.LoginBtn);
           DriverAction.waitSec(2);
           if (DriverAction.getElement(Locator.InvalidPassword_msg).isDisplayed()) {
               GemTestReporter.addTestStep("Validating weather Invalid Password Message Poped up", "Invalid Password Message Poped up", STATUS.PASS, DriverAction.takeSnapShot());

           } else {
               GemTestReporter.addTestStep("Validating weather Invalid Password Message Poped up", " No Message Poped up", STATUS.FAIL, DriverAction.takeSnapShot());

           }
       }
       catch (Exception e) {
           logger.info("An exception occurred!", e);
           GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
       }
    }

    @Then("^validate set new password screen (.+),(.+),(.+),(.+)$")
    public void EnterUsername(String new_pass,String confirm_pass,String Req_Label,String Home_Screen_Label) throws IOException {
       try {
           DriverAction.waitSec(30);
           DriverAction.click(Locator.Verifybtn);
           Boolean isPassed = false;
           if (DriverAction.getElement(Locator.setnewpassword_label).isDisplayed()) {
               isPassed = true;
               String Fetched_Label = DriverAction.getElement(Locator.setnewpassword_label).getText();
               if (Fetched_Label.equals(Req_Label)) {
                   GemTestReporter.addTestStep("Validating navigation to set new password screen and also checking weather Requied Label is present or not", "Successfully  navigate to set new password screen and Expected Label-> " + Req_Label + " Actual Label-> " + Fetched_Label, STATUS.PASS, DriverAction.takeSnapShot());
               } else {
                   GemTestReporter.addTestStep("Validating navigation to set new password screen and also checking weather Requied Label is present or not", "Successfully navigate to set new password screen but There is Mismatch of <br> Expected Label-> " + Req_Label + " Actual Label-> " + Fetched_Label, STATUS.FAIL, DriverAction.takeSnapShot());

               }
           } else {
               GemTestReporter.addTestStep("Validating navigation to set new password screen", "Not able to navigate to set new password screen ", STATUS.FAIL, DriverAction.takeSnapShot());
           }
           if (DriverAction.getElement(Locator.New_Password_Field).isDisplayed()) {
               isPassed = true;
               GemTestReporter.addTestStep("Validating weather New Password input is visible on set new password screen ", "New Password input is visible on set new password screen", STATUS.PASS, DriverAction.takeSnapShot());
               DriverAction.typeText(Locator.New_Password_Field, new_pass);
           } else {
               isPassed = false;
               GemTestReporter.addTestStep("Validating weather New Password input is visible on set new password screen", "New Password input is not visible on set new password screen", STATUS.FAIL, DriverAction.takeSnapShot());
           }
           if (DriverAction.getElement(Locator.Confirm_Password_Field).isDisplayed()) {
               isPassed = true;
               GemTestReporter.addTestStep("Validating weather Confirm Password input is visible on set new password screen", "Confirm Password input is visible on set new password screen", STATUS.PASS, DriverAction.takeSnapShot());
               DriverAction.typeText(Locator.Confirm_Password_Field, confirm_pass);
           } else {
               isPassed = false;
               GemTestReporter.addTestStep("Validating weather Confirm Password input is visible on set new password screen", "Confirm Password input is not visible on set new password screen", STATUS.FAIL, DriverAction.takeSnapShot());

           }
           if (DriverAction.getElement(Locator.SetNewPassword_btn).isDisplayed()) {
               isPassed = true;
               GemTestReporter.addTestStep("Validating weather Set new Password button  is visible on set new password screen", "Set new Password button  is visible on set new password screen", STATUS.PASS, DriverAction.takeSnapShot());
               DriverAction.waitSec(15);
               DriverAction.click(Locator.SetNewPassword_btn);
           }
           if (DriverAction.getElement(Locator.Password_Updated_Label).isDisplayed()) {
               isPassed = true;
               GemTestReporter.addTestStep("Validating weather Password Updated label is visible on set new password screen", "Password Updated label is visible on set new password screen", STATUS.PASS, DriverAction.takeSnapShot());
           } else {
               isPassed = false;
               GemTestReporter.addTestStep("Validating weather Password Updated label is visible on set new password screen", "Password Updated label is not visible on set new password screen", STATUS.FAIL, DriverAction.takeSnapShot());
           }
           if (DriverAction.getElement(Locator.Tick_img).isDisplayed()) {
               isPassed = true;
               GemTestReporter.addTestStep("Validating weather Green Tick is visible on set new password updated popup screen", "Green Tick is visible on set new password updated popup screen", STATUS.PASS, DriverAction.takeSnapShot());
           } else {
               isPassed = false;
               GemTestReporter.addTestStep("Validating weather Green Tick is visible on set new password updated popup screen", "Green Tick is not visible on set new password updated popup screen", STATUS.FAIL, DriverAction.takeSnapShot());
           }
           if (DriverAction.getElement(Locator.Login_Link).isDisplayed()) {
               isPassed = true;
               GemTestReporter.addTestStep("Validating weather Login Link is visible on set new password updated popup screen", "Login Link is visible on set new password updated popup screen", STATUS.PASS, DriverAction.takeSnapShot());
               DriverAction.click(Locator.Login_Link);
           } else {
               isPassed = false;
               GemTestReporter.addTestStep("Validating weather Login Link is visible on set new password updated popup screen", "Login Link is not visible on set new password  updated popup screen", STATUS.FAIL, DriverAction.takeSnapShot());
           }
           if (DriverAction.getElement(Locator.Welcome_Label).isDisplayed()) {
               isPassed = true;
               String Fetched_Label = DriverAction.getElement(Locator.Welcome_Label).getText();
               if (Fetched_Label.equals(Home_Screen_Label)) {
                   GemTestReporter.addTestStep("Validating weather User navigated to Home screen", "User navigated to Home screen  and Expected Label->" + Home_Screen_Label + "Actual Label->" + Fetched_Label, STATUS.PASS, DriverAction.takeSnapShot());
               } else {
                   GemTestReporter.addTestStep("Validating weather User navigated to Home screen", "User navigated to Home screen  but There is Mismatch of Expected Label->" + Home_Screen_Label + "Actual Label->" + Fetched_Label, STATUS.FAIL, DriverAction.takeSnapShot());

               }
           } else {
               isPassed = false;
               GemTestReporter.addTestStep("Validating weather User navigated to Home screen", "User is not navigated to Home screen", STATUS.FAIL, DriverAction.takeSnapShot());


           }
       }
       catch (Exception e) {
           logger.info("An exception occurred!", e);
           GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
       }

    }
        @Then("^Username is Entered (.+)$")
    public void EnterUsername(String Username) throws IOException {
try {
    Boolean isPassed = false;
    if (DriverAction.getElement(Locator.Email_Id).isDisplayed()) {
        DriverAction.click(Locator.Email_Input_Field);
        DriverManager.getWebDriver().findElement(Locator.Email_Input_Field).clear();
        DriverAction.typeText(Locator.Email_Input_Field, Username.trim());
        DriverAction.click(Locator.RequestOtpBtn);

        isPassed = true;
    }
    if (isPassed) {
        GemTestReporter.addTestStep("Validating weather Username is typed and it navigate to respective screen", "Username is typed and it navigate to respective screen", STATUS.PASS, DriverAction.takeSnapShot());
    } else {
        GemTestReporter.addTestStep("Validating weather Username is typed and it navigate to respective screen", "Username is not typed and it has not navigate to respective screen", STATUS.FAIL, DriverAction.takeSnapShot());
    }
}
catch (Exception e) {
    logger.info("An exception occurred!", e);
    GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
}
    }
    @Then("^Enter Username and validate (.+)$")
    public void EnterUsernameWrongvalidate(String Username) throws IOException, AWTException {
try {
    Boolean isPassed = false;
    if (DriverAction.getElement(Locator.Email_Id).isDisplayed()) {
        DriverAction.click(Locator.Email_Input_Field);
        DriverManager.getWebDriver().findElement(Locator.Email_Input_Field).clear();
        DriverAction.typeText(Locator.Email_Input_Field, Username.trim());
        DriverAction.click(Locator.RequestOtpBtn);
    }
    if (DriverAction.getElement(Locator.Email_Doest_Not_msg).isDisplayed()) {
        GemTestReporter.addTestStep("Validating Required Email Error poped up", "Required Error message ->Email Id does not exist appear ", STATUS.PASS, DriverAction.takeSnapShot());
    } else {
        GemTestReporter.addTestStep("Validating Required Email Error poped up", "Required Error message ->Email Id does not exist  not appear", STATUS.FAIL, DriverAction.takeSnapShot());
    }
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_F5);
    robot.keyRelease(KeyEvent.VK_F5);
}
catch (Exception e) {
    logger.info("An exception occurred!", e);
    GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
}
    }

    @Then("^Verification Screen Ui validation$")
    public void VerifyForgotPasswordUi() throws IOException, AWTException {
try {
    if (DriverAction.getElement(Locator.Logo).isDisplayed()) {
        GemTestReporter.addTestStep("Validating weather Required Logo is present on Verification screen", "Required Logo is present on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
    } else {
        GemTestReporter.addTestStep("Validating weather Required Logo is present on Verification screen", "Required Logo is not  present on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    if (DriverAction.getElement(Locator.Verification).isDisplayed()) {
        GemTestReporter.addTestStep("Validating weather Verification label is present on Verification screen", "Required Verification label is present on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
    } else {
        GemTestReporter.addTestStep("Validating weather Verification label is present on Verification screen", "Required Verification label is not present on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    List<WebElement> list = DriverAction.getElements(By.xpath("//div[@class='ng-otp-input-wrapper wrapper ng-star-inserted']//input"));
    if (list.size() == 4) {

        GemTestReporter.addTestStep("Validating weather Otp Input is present on Verification screen", "Otp input is present on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
    } else {

        GemTestReporter.addTestStep("Validating weather Otp Input is present on Verification screen", "Otp input is not present on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());

    }
    if (DriverAction.getElement(Locator.Time).isDisplayed()) {
        GemTestReporter.addTestStep("Validating weather Timer is present on Verification screen", "Timer is present on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
    } else {
        GemTestReporter.addTestStep("Validating weather Timer is present on Verification screen", "Timer is not present on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    if (DriverAction.getElement(Locator.Verifybtn).isDisplayed()) {
        GemTestReporter.addTestStep("Validating weather Verify button is present on Verification screen", "Verify button present on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
    } else {
        GemTestReporter.addTestStep("Validating weather Verify button is present on Verification screen", "Verify button not present on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    for (int i = 1; i < list.size() + 1; i++) {
        String str = Integer.toString(i);
        DriverAction.typeText(By.xpath(Locator.otp.replace("itr", String.valueOf(i))), String.valueOf(i));
    }
    DriverAction.click(Locator.Verifybtn);
    if (DriverAction.getElement(Locator.invalidotp_error).isDisplayed()) {
        GemTestReporter.addTestStep("Validating weather Required Message Pop up  on Verification screen", "Required message poped up on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
    } else {
        GemTestReporter.addTestStep("Validating weather Required Message Pop up  on Verification screen", "Required message does not poped up on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());
    }
    System.out.println(list.size());
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_F5);
    robot.keyRelease(KeyEvent.VK_F5);
}
catch (Exception e) {
    logger.info("An exception occurred!", e);
    GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
}
}

    @Then("^Validating Click Here Button Functionality on Verfication Screen$")
    public void ClickHereBtnandValidate() throws IOException, AWTException {
try {
    if (DriverAction.getElement(Locator.Herebtn).isDisplayed()) {
        GemTestReporter.addTestStep("Validating weather Here link is present on Verification screen", "Here link is present on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.waitSec(61);
        DriverAction.click(Locator.Herebtn);
        if (DriverAction.getElement(Locator.OtpResendMsg).isDisplayed()) {
            GemTestReporter.addTestStep("Validating weather Otp Resent message poped up on Verification screen", "Otp Resent message poped up on Verification screen", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validating weather Otp Resent message poped up on Verification screen", "Otp Resent message not poped up  on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    } else {
        GemTestReporter.addTestStep("Validating weather Here link is present on Verification screen", "Here Link  is not present on Verification screen", STATUS.FAIL, DriverAction.takeSnapShot());
    }
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_F5);
    robot.keyRelease(KeyEvent.VK_F5);
}
catch (Exception e) {
    logger.info("An exception occurred!", e);
    GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
}
    }

    @Then("^Enter Invalid  Username and verify (.+),(.+)$")
    public void EnterInvalidUsernameValidation(String Username,String Req_msg) throws IOException {
        try {
            if (DriverAction.getElement(Locator.Email_Id).isDisplayed()) {
                DriverAction.typeText(Locator.Email_Input_Field, Username);
                DriverAction.click(Locator.RequestOtpBtn);
            }
            String EmailError = DriverAction.getElement(Locator.InvalidMailError).getText();
            if (EmailError.equals(Req_msg)) {
                GemTestReporter.addTestStep("Validating weather Required Poped up message appear on Verification screen", "Required pop up message appear on Verification screen ->Required Message->" + EmailError + " Actual Message-> " + Req_msg, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Required Poped up message appear on Verification screen", "Required pop up message  appear not appear  on Verification screen ->Required Message->" + EmailError + " Actual Message-> " + Req_msg, STATUS.FAIL, DriverAction.takeSnapShot());
            }
        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    }
