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
import java.util.Random;

public class UserManagementStepDefination {

    @Then("verify logo on User management page.")
    public void verify_logo_on_user_management_page() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='expandLogo']")));
        boolean isPassed;
        if (DriverAction.getElement(By.xpath("//img[@class='expandLogo']")).isDisplayed()) {
            isPassed = true;
        } else {
            isPassed = false;
        }

        if (isPassed) {
            GemTestReporter.addTestStep("PLIL logo validation", "PLIL Logo is visible", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("PLIL logo validation", "PLIL logo is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("verify User Management Tab is highlighted or not.")
    public void verifyUserManagementTabIsHighlightedOrNot() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(5));
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(superAdmin_Locators.usmgt));
        ele.click();

        Boolean isPassed = false;
        DriverAction.click(superAdmin_Locators.gopshomeButton);

        if (DriverAction.getElement(superAdmin_Locators.usermgtHm).isDisplayed()) isPassed = true;
        else isPassed = false;

        if (isPassed) {
            GemTestReporter.addTestStep("UserManagement validation", "UserManagement Home Button visible", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("UserManagement validation", "UserManagement Home Button is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("verify create user button is visible or clickable.")
    public void verifyCreateUserButtonIsVisibleOrClickable() {
        DriverManager.getWebDriver().navigate().refresh();
        DriverAction.click(superAdmin_Locators.usmgt);
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(10));
       WebElement ele =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Create User ']")));
       ele.click();


    }

    @Then("verify search text box with icon is present.")
    public void verifySearchTextBoxWithIconIsPresent() {
        DriverManager.getWebDriver().navigate().refresh();
        DriverAction.click(superAdmin_Locators.usmgt);
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='fa fa-search form-control-feedback']")));
       String text = DriverAction.getElementText(By.xpath("(//table//tbody//tr[1]//td)[1]"));
       DriverAction.typeText(By.xpath("//input[@type='text']"),text);
       DriverAction.waitSec(5);


    }

    @Then("verify all the table column field names.")
    public void verifyAllTheTableColumnFieldNames() {

        ArrayList<String>actuallist = new ArrayList<>();
        ArrayList<String>expectedlist = new ArrayList<>();
        List<WebElement> datalist = DriverAction.getElements(By.xpath("//table//thead/tr/th"));
        for (WebElement usmgdata : datalist) {
            String reversefeedColumsData = usmgdata.getText();
            System.out.println(reversefeedColumsData);
            actuallist.add(reversefeedColumsData);

        }
        expectedlist.add("Name");
        expectedlist.add("Email ID");
        expectedlist.add("Mobile No.");
        expectedlist.add("Partner");
        expectedlist.add("Role");
        expectedlist.add("Action");

        if (actuallist.equals(expectedlist) == true) {
            // System.out.println(" Array List are equal");
            GemTestReporter.addTestStep("User Management Header Column Valuation", "User Management Header Data Matched", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            // System.out.println(" Array List are not equal");
            GemTestReporter.addTestStep("User Management Header Column Valuation", "User Management Header Data didn't Match", STATUS.FAIL, DriverAction.takeSnapShot());
        }



        //ArrayList<String>actuallist = DriverAction.getElementsText(By.xpath("//table//thead/tr/th"));
    }

    @Then("verify create user fields")
    public void verifyCreateUserFields() {
        DriverManager.getWebDriver().navigate().refresh();
        DriverAction.click(superAdmin_Locators.usmgt);
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(10));
        WebElement ele =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Create User ']")));
        ele.click();
        DriverAction.typeText(By.xpath("//input[@formcontrolname='name']"),"testuser");
        String myEmailAddress = "testuser" + System.nanoTime() + "@gmail.com";
        DriverAction.typeText(By.xpath("//input[@type='email']"),myEmailAddress);
        DriverAction.typeText(By.xpath("//input[@formcontrolname='mobile']"),"9914325679");
        DriverAction.click(By.xpath("(//mat-select/div/div[2])[1]"));
        List<WebElement>list = DriverAction.getElements(By.xpath("//mat-option//span"));
        System.out.println(list.size());
        Random rand = new Random();
        int num = rand.nextInt(list.size());
        System.out.println(num);
        DriverAction.click(By.xpath("(//mat-option//span)["+num+"]"));
        DriverAction.click(By.xpath("(//mat-select/div/div[2])[2]"));
        List<WebElement>list1 = DriverAction.getElements(By.xpath("//mat-option//span"));
        list1.size();
        System.out.println(list1.size());
        Random rand1 = new Random();
        int num1 = rand.nextInt(list1.size());
        System.out.println(list.size());
        DriverAction.click(By.xpath("(//mat-option//span)["+num+"]"));
        DriverAction.waitSec(10);
        DriverAction.click(By.xpath("//button[text()=' Create User ']"));
    }

    @Then("verify user should get created and also visible on user management screen.")
    public void verifyUserShouldGetCreatedAndAlsoVisibleOnUserManagementScreen() {

        //DriverAction.typeText(By.xpath("//input[@type='text']"),"Testuser");
        String text = DriverAction.getElementText(By.xpath("(//table//tbody/tr/td)[1]"));
        Assert.assertEquals(text,"Testuser");



    }
}
