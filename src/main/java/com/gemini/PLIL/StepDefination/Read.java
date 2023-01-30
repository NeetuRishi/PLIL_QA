package com.gemini.PLIL.StepDefination;

import com.gemini.PLIL.Locators.Locator;
import com.gemini.PLIL.Locators.Read_Locators;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class Read {
    Logger logger = LoggerFactory.getLogger(StepDefination.class);
    @Given("^Enter Username and Password and validate (.+)$")
    public void Enter_Username_Password(String Validate_txt) throws IOException {
try {
    DriverAction.typeText(Locator.Email_Input_Field, "shubham.a.kumar@geminisolutions.com");
    DriverAction.setImplicitTimeOut(2);
    // DriverAction.typeText(Locator.Password_Input_Field,"Test@123");
    WebElement ele = DriverManager.getWebDriver().findElement(Locator.Password_Input_Field);
    ele.sendKeys("Test@123");
    GemTestReporter.addTestStep("Password", "****", STATUS.PASS, DriverAction.takeSnapShot());
    DriverAction.waitSec(10);
    DriverAction.click(Locator.LoginBtn);
    DriverAction.setImplicitTimeOut(15);
    WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20));
    WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(Locator.HomeScreen));
    String Home = DriverAction.getElement(Locator.HomeScreen).getText();
    Boolean isPassed = false;
    if (Home.equals(Validate_txt)) {
        isPassed = true;
    }
    if (isPassed) {
        GemTestReporter.addTestStep("Validating weather user able to login or not", "User Successfully login and by default user is on Home sub screen", STATUS.PASS, DriverAction.takeSnapShot());
    } else {
        GemTestReporter.addTestStep("Validating weather user able to login or not", "User not able to login", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    if (DriverAction.getElement(Locator.Logo).isDisplayed()) {
        GemTestReporter.addTestStep("Validating weather Logo is Visible on Home page", "Logo is visible on Home screen", STATUS.PASS, DriverAction.takeSnapShot());
    } else {
        GemTestReporter.addTestStep("Validating weather Logo is Visible on Home page", "Logo is not visible on Home screen", STATUS.FAIL, DriverAction.takeSnapShot());
    }
    if (DriverAction.getElement(Locator.HomeScreen).isDisplayed()) {
        GemTestReporter.addTestStep("Validating weather Home Lable is Visible on Home page", "Home Label is visible on Home screen", STATUS.PASS, DriverAction.takeSnapShot());
    } else {
        GemTestReporter.addTestStep("Validating weather Home Lable is Visible on Home page", "Home Label is not visible on Home screen", STATUS.FAIL, DriverAction.takeSnapShot());
    }
}
catch (Exception e) {
    logger.info("An exception occurred!", e);
    GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
}
    }
    @Then("^validate weather the (.+),(.+),(.+) tab are present and are clickable$")
    public void validatetab(String home,String enquiry,String report) throws IOException {
        try {
            DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(3))));
            for (int i = 1; i <= 3; i++) {
                String tab = DriverAction.getElement(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(i)))).getText();
                if (tab.equals(home)) {
                    GemTestReporter.addTestStep("Validating weather Home tab is present on side bar of Home page", "Home tab is present on Screen", STATUS.PASS, DriverAction.takeSnapShot());
                    DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(i))));
                    if (DriverAction.getElement(By.xpath(Read_Locators.Read_tab.replace("tab", home))).isDisplayed()) {
                        GemTestReporter.addTestStep("Validating weather Home tab is Clickable on side bar of Home page", "Home tab is clickable and navigate to Home subscreen", STATUS.PASS, DriverAction.takeSnapShot());

                    } else {
                        GemTestReporter.addTestStep("Validating weather Home tab is Clickable on side bar of Home page", "Home tab is not clickable and not able to navigate to Home subscreen", STATUS.FAIL, DriverAction.takeSnapShot());

                    }

                } else if (tab.equals(enquiry)) {
                    GemTestReporter.addTestStep("Validating weather Enquiry tab is present on side bar of Home page", "Enquiry tab is present on Screen", STATUS.PASS, DriverAction.takeSnapShot());
                    DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(i))));
                    if (DriverAction.getElement(By.xpath(Read_Locators.Read_tab.replace("tab", enquiry))).isDisplayed()) {
                        GemTestReporter.addTestStep("Validating weather Enquiry tab is Clickable on side bar of Home page", "Enquiry tab is clickable and navigate to Enquiry subscreen", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Validating weather Enquiry tab is Clickable on side bar of Home page", "Enquiry tab is not clickable and not able to navigate to Enquiry subscreen", STATUS.FAIL, DriverAction.takeSnapShot());

                    }
                } else if (tab.equals(report)) {
                    GemTestReporter.addTestStep("Validating weather Report tab is present on side bar of Home page", "Report tab is present on Screen", STATUS.PASS, DriverAction.takeSnapShot());
                    DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(i))));
                    if (DriverAction.getElement(By.xpath(Read_Locators.Read_tab.replace("tab", "Generate"))).isDisplayed()) {
                        GemTestReporter.addTestStep("Validating weather Report tab is Clickable on side bar of Home page", "Report tab is clickable and navigate to Report subscreen", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("VValidating weather Report tab is Clickable on side bar of Home page", "Report tab is not clickable and not able to navigate to Report subscreen", STATUS.FAIL, DriverAction.takeSnapShot());

                    }
                }

            }
        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }

    }

    @Then("^validate Home screen ui$")
    public void validateHomeui() throws IOException {
     try {
         DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(1))));
         Boolean isPassed = false;
         for (int i = 1; i <= 3; i++) {
             String uiData = DriverAction.getElement(By.xpath(Read_Locators.ui_data.replace("itr", String.valueOf(i)))).getText();
             if (uiData.contains("@") && !uiData.isEmpty()) {
                 GemTestReporter.addTestStep("Validating weather Email Id field is present on Home page", "Email Id Field is present on Home page", STATUS.PASS, DriverAction.takeSnapShot());
                 isPassed = true;
             } else if ((uiData.contains("9") || uiData.contains("1")) && !uiData.isEmpty()) {
                 GemTestReporter.addTestStep("Validating weather Mobile Number field is present on Home page", "Mobile Number Field is present on Home page", STATUS.PASS, DriverAction.takeSnapShot());
                 isPassed = true;
             } else {
                 if (!uiData.isEmpty()) {
                     GemTestReporter.addTestStep("Validating weather Name field is present on Home page", "Name Field is present on Home page", STATUS.PASS, DriverAction.takeSnapShot());
                     isPassed = true;
                 }
             }
         }
         if (!isPassed) {
             GemTestReporter.addTestStep("Validating weather Required field is present on Home page", "some Field are not present on Home page", STATUS.FAIL, DriverAction.takeSnapShot());

         }
         if (DriverAction.getElement(Read_Locators.hamburgerbtn).isDisplayed()) {
             GemTestReporter.addTestStep("Validating weather Hamburger button is present on Home page", "Hamburger button is present on Home page", STATUS.PASS, DriverAction.takeSnapShot());
         } else {
             GemTestReporter.addTestStep("Validating weather Hamburger button is present on Home page", "Hamburger button is not present on Home page", STATUS.FAIL, DriverAction.takeSnapShot());

         }
     }
     catch (Exception e) {
         logger.info("An exception occurred!", e);
         GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
     }
    }

    @Then("^validate Enquiry and Report card on Home Screen$")
    public void validatecards() throws IOException {
        try {
            if (DriverAction.getElement(Read_Locators.Enquiry_card).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Enquiry Card is Visible on Home page", "Enquiry Card is visible on Home screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Enquiry Card is Visible on Home page", "Enquiry Card is not visible on Home screen", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Report_card).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Report Card is Visible on Home page", "Report Card is visible on Home screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Report Card is Visible on Home page", "Report Card is not visible on Home screen", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @Then("^validate excel button functionality (.+)$")
    public void ValidateExcelbutton(String filepath) throws IOException {
        try{
            if (DriverAction.getElement(Read_Locators.Exportbtn).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Export Button is present on Enquiry page", "Export Button is present on Enquiry page", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Export Button is present on Enquiry page", "Export Button is not present on Enquiry page", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            DriverAction.click(Read_Locators.Exportbtn);
DriverAction.waitSec(10);
            File file =new File(filepath);
            File file1=getLastModified(filepath);
            System.out.print(filepath);
            Scanner sc=new Scanner(file1);
        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }

    }
public File getLastModified(String directoryFilePath)
{
    File directory = new File(directoryFilePath);
    File[] files = directory.listFiles(File::isFile);
    long lastModifiedTime = Long.MIN_VALUE;
    File chosenFile=null;
    if(files != null)
    {
        for(File file:files)
        {
            if(file.lastModified()>lastModifiedTime)
            {
                chosenFile=file;
                lastModifiedTime=file.lastModified();
            }
        }
    }
  return chosenFile;
}
    @Then("^validate Date Field and user able to select date$")
    public void ValidateDateField() throws IOException {
        try {
            DriverManager.getWebDriver().navigate().refresh();
            DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(2))));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String str = formatter.format(date);
            String nDate = date.toString();
            String[] arr = str.split("/");
            System.out.println(arr);
            int length = arr.length;
            System.out.println(length);
            List<String> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                list.add(arr[i]);
            }
            System.out.println(list);
            int year = Integer.parseInt(list.get(2));
            int month = Integer.parseInt(list.get(1));
            int mdate = Integer.parseInt(list.get(0));
            Map<Integer, String> map = new HashMap<>();
            map.put(1, " JAN ");
            map.put(2, " FEB ");
            map.put(3, " MAR ");
            map.put(4, " APR ");
            map.put(5, " MAY ");
            map.put(6, " JUN ");
            map.put(7, " JUL ");
            map.put(8, " AUG ");
            map.put(9, " SEP ");
            map.put(10, " OCT ");
            map.put(11, " NOV ");
            map.put(12, " DEC ");
            String mD = null;
            if (map.containsKey(month)) {
                mD = map.get(month);
            }
            System.out.println(mD);
            DriverAction.click(Read_Locators.dateButton);
            DriverAction.click(Read_Locators.yearDropDown);
            DriverAction.click(By.xpath("//div[contains(text(),\'" + year + "\')]"));
            DriverAction.click(By.xpath("//div[contains(text(),\'" + mD + "\')]"));
            DriverAction.click(By.xpath("//div[contains(text(),\'" + mdate + "\')]"));
            Actions act=new Actions(DriverManager.getWebDriver());
            act.sendKeys(Keys.ENTER).build().perform();
           // WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20));
          //  wait.until(ExpectedConditions.textToBe(Read_Locators.Startdate,"27-01-2023"));
            DriverAction.waitSec(10);
            String Startdate=DriverManager.getWebDriver().findElement(By.xpath("//div[@class='mat-date-range-input-container']")).getAttribute("text");

        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }


    }
        @Then("^Validate Enquiry Tab ui$")
    public void ValidateEnquiryui() throws IOException {
        try {
            DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(2))));

            if (DriverAction.getElement(Read_Locators.EnquiryLabel).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Enquiry Label is present on Home page", "Enquiry Label is present on Home page", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Enquiry Label is present on Home page", "Enquiry Label is present on Home page", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.hamburgerbtn).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Hamburger button is present on Home page", "Hamburger button is present on Home page", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Hamburger button is present on Home page", "Hamburger button is not present on Home page", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.FilterByLabel).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Filter By Label  is present on Enquiry Tab", "Filter By Label  is present on Enquiry Tab", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Filter By Label  is present on Enquiry Tab", "Filter By Label  is not present on Enquiry Tab", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            String FilterByDropdown_value = DriverAction.getElement(Read_Locators.FilterByDropdownText).getText();
            if (FilterByDropdown_value.equals("Status")) {
                GemTestReporter.addTestStep("Validating weather Status Placeholder in FilterBy Dropdown", "Status Placeholder is present  in FilterBy Dropdown", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Status Placeholder in FilterBy Dropdown", "Status Placeholder is not present  in FilterBy Dropdown", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            DriverAction.click(Read_Locators.FilterByDropdownicon);

            if (DriverAction.getElement(Read_Locators.FilterByDropdownValues).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Data is Present in FilterBy Dropdown", "Data is Present in FilterBy Dropdown", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Data is Present in FilterBy Dropdown", "Data is not Present in FilterBy Dropdown", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }

    }

        @Then("^Navigate to Enquiry tab and validate logo$")
    public void Navigateandvalidate() throws IOException {
            try {
                DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(2))));
                if (DriverAction.getElement(Locator.Logo).isDisplayed()) {
                    GemTestReporter.addTestStep("Validating weather Logo is Visible on Enquiry tab", "Logo is visible on Enquiry tab", STATUS.PASS, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Validating weather Logo is Visible on Enquiry tab", "Logo is not visible on Enquiry tab", STATUS.FAIL, DriverAction.takeSnapShot());
                }

                String tab = DriverAction.getElement(Read_Locators.Enquirytab).getAttribute("class");
                if (tab.contains("active")) {
                    GemTestReporter.addTestStep("Validating weather Enquiry tab is highlighted", "Enquiry tab is highlighted", STATUS.PASS, DriverAction.takeSnapShot());

                } else {
                    GemTestReporter.addTestStep("Validating weather Enquiry tab is highlighted", "Enquiry tab is not highlighted", STATUS.FAIL, DriverAction.takeSnapShot());

                }
            }

            catch (Exception e) {
                logger.info("An exception occurred!", e);
                GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
            }

        }

    }
