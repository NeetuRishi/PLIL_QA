package com.gemini.PLIL.StepDefination;

import com.gemini.PLIL.Locators.superAdmin_Locators;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MasterManagementStepDefination {

    @Then("verify Navigate to label should be visible.")
    public void verify_navigate_to_label_should_be_visible() {
        DriverAction.click(superAdmin_Locators.mastermgtButton);
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(10));
        WebElement element = DriverAction.getElement(By.xpath("//h4[text()='Navigate to']"));
        wait.until(ExpectedConditions.textToBePresentInElement(element,"Navigate to"));
        DriverAction.waitSec(10);
    }


    @Then("verify side abs should be visible on left side.")
    public void verifySideAbsShouldBeVisibleOnLeftSide() {
        Boolean isPassed = false;
        if (DriverAction.getElement(superAdmin_Locators.gopshomeButton).isDisplayed()) isPassed = true;
        else isPassed = false;

        if (DriverAction.getElement(superAdmin_Locators.roleshomeButton).isDisplayed()) isPassed = true;
        else isPassed = false;

        if (DriverAction.getElement(superAdmin_Locators.mastermgtButton).isDisplayed()) isPassed = true;
        else isPassed = false;

        if (DriverAction.getElement(superAdmin_Locators.partnerproduct).isDisplayed()) isPassed = true;
        else isPassed = false;

        if (DriverAction.getElement(superAdmin_Locators.usmgt).isDisplayed()) isPassed = true;
        else isPassed = false;
        if (DriverAction.getElement(superAdmin_Locators.patmgt).isDisplayed()) isPassed = true;
        else isPassed = false;
        if (DriverAction.getElement(superAdmin_Locators.gopsEnquiry).isDisplayed()) isPassed = true;
        else isPassed = false;


        if (isPassed) {
            GemTestReporter.addTestStep("PLIL Tabs Validation", "PLIL Tabs are visible", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("PLIL Tabs Validation", "PLIL Tabs are not visible", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("verify Hamburger button on top to minimize side bar.")
    public void verifyHamburgerButtonOnTopToMinimizeSideBar() {

        Boolean isPassed = false;
        if (DriverAction.getElement(superAdmin_Locators.hamBurgerBtn).isDisplayed())
            isPassed = true;
        else isPassed = false;

        if (isPassed) {
            GemTestReporter.addTestStep("HamBurgerValidation", "Ham Burger is present on Screen", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("HamBurgerValidation", "Ham Burger is present on Screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(10));
        WebElement hamBurgerButton = wait.until(ExpectedConditions.elementToBeClickable(superAdmin_Locators.hamBurgerBtn));
        hamBurgerButton.click();
    }


    @Then("verify salutation card on master management screen.")
    public void verifySalutationCardOnMasterManagementScreen() {

       // DriverAction.click(superAdmin_Locators.mastermgtButton);
        DriverAction.click(By.xpath("//span[text()='Salutation']"));
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(10));
      //  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/h2/i")));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()='Salutation'])[2]")));
        Boolean isPassed = false;
        if (DriverAction.getElement(By.xpath("(//*[text()='Salutation'])[2]")).isDisplayed())
            isPassed = true;
        else isPassed = false;

        if (isPassed) {
            GemTestReporter.addTestStep("Salutation visibility Validation", "Salutation text is present on Screen", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Salutation visibility Validation", "Salutation text  is not present on Screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @Then("verify create button is visible and it is clickable.")
    public void verifyCreateButtonIsVisibleAndItIsClickable() {

        DriverAction.click(By.xpath("//button[text()=' Create ']"));
      //  DriverAction.click(By.xpath("//span[text()='Salutation']"));

    }

    @Then("verify Salutation table columns are present.")
    public void verifySalutationTableColumnsArePresent() {
        DriverManager.getWebDriver().navigate().refresh();
        DriverAction.click(superAdmin_Locators.mastermgtButton);
        DriverAction.click(By.xpath("//span[text()='Salutation']"));
        ArrayList<String>expectedlist = new ArrayList<>();
        ArrayList<String>actuallist = new ArrayList<>();
        List<WebElement> list = DriverAction.getElements(By.xpath("//table//thead//tr/th"));

        for(WebElement data: list)
        {
            String mgtdata = data.getText();
            System.out.println(mgtdata);
            actuallist.add(mgtdata);
        }
        expectedlist.add("Code");
        expectedlist.add("Value");
        expectedlist.add("Created On");
        expectedlist.add("Created By");
        expectedlist.add("Action");

        if (actuallist.equals(expectedlist) == true) {
            // System.out.println(" Array List are equal");
            GemTestReporter.addTestStep("Salutation header Column Validation", "Salutation Header Data Matched", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            // System.out.println(" Array List are not equal");
            GemTestReporter.addTestStep("Salutation header Column Validation", "Salutation Header Data didn't Match", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("verify pagination is visible and working")
    public void verifyPaginationIsVisibleAndWorking() {

        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='angle-left']")));
        Boolean isPassed = false;
        if (DriverAction.getElement(By.xpath("//span[@class='angle-left']")).isDisplayed())
            isPassed = true;
        else isPassed = false;

        if (isPassed) {
            GemTestReporter.addTestStep("left Arrow Validation", "left Arrow is present on Screen", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("left Arrow Validation", "left Arrow is not present on Screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='angle-right']")));
        if (DriverAction.getElement(By.xpath("//span[@class='angle-left']")).isDisplayed())
            isPassed = true;
        else isPassed = false;

        if (isPassed) {
            GemTestReporter.addTestStep("Right Arrow  Validation", "Right Arrow is present on Screen", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Right Arrow  Validation", "Right Arrow is not present on Screen", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @Then("verify Gender card on master management screen.")
    public void verifyGenderCardOnMasterManagementScreen() {
        DriverManager.getWebDriver().navigate().refresh();
        DriverAction.click(superAdmin_Locators.mastermgtButton);
        DriverAction.click(By.xpath("//span[text()='Gender']"));
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(20));
      wait.until(ExpectedConditions.textToBe(By.xpath("//i[@class='fa fa-angle-left arrow']"), "<"));
         String text = DriverAction.getElementText(By.xpath("//i[@class='fa fa-angle-left arrow']"));
        Assert.assertEquals(text,'<');

    }
}
