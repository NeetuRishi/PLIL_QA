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
    @Given("^Enter username and password")
    public void Enter_Username_Paasword() throws IOException {
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


    }
