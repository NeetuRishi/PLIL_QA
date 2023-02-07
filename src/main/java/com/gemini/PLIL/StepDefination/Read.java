package com.gemini.PLIL.StepDefination;

import com.gemini.PLIL.Locators.Locator;
import com.gemini.PLIL.Locators.Read_Locators;
import com.gemini.PLIL.Locators.superAdmin_Locators;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class Read {

    // driver.manage().window().maximize();
    Logger logger = LoggerFactory.getLogger(StepDefination.class);

    @Given("^Enter Username and Password and validate (.+),(.+),(.+)$")
    public void Enter_Username_Password(String Validate_txt,String username,String Password) throws IOException {
        try {
            DriverManager.getWebDriver().manage().window().maximize();
            DriverAction.typeText(Locator.Email_Input_Field, username);
            DriverAction.setImplicitTimeOut(2);
            WebElement ele = DriverManager.getWebDriver().findElement(Locator.Password_Input_Field);
            ele.sendKeys(Password);
            GemTestReporter.addTestStep("Password", "****", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.click(Locator.LoginBtn);
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20));
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//mat-error[text()=' Verification required ']"), "Verification required"));
            DriverAction.click(Locator.LoginBtn);
            DriverAction.setImplicitTimeOut(15);
            wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20));
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
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @Then("^validate weather the (.+),(.+),(.+) tab are present and are clickable$")
    public void validatetab(String home, String enquiry, String report) throws IOException {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @Then("^validate excel button functionality (.+)$")
    public void ValidateExcelbutton(String filepath) throws IOException {
        try {
            if (DriverAction.getElement(Read_Locators.Exportbtn).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Export Button is present on Enquiry page", "Export Button is present on Enquiry page", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Export Button is present on Enquiry page", "Export Button is not present on Enquiry page", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            DriverAction.click(Read_Locators.Exportbtn);
            DriverAction.setImplicitTimeOut(10);

            File file = new File(filepath);
            File file1 = getLastModified(filepath);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String str = formatter.format(date);
            String nDate = date.toString();
            String[] arr = str.split("/");
            if (String.valueOf(file1).contains(arr[0])) {
                GemTestReporter.addTestStep("Validating weather User able to download excel file", "User successfully able to download the excel file", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather User able to download excel file", "User not able to download the excel file", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            // System.out.print(filepath);


        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }

    }

    public File getLastModified(String directoryFilePath) {
        File directory = new File(directoryFilePath);
        File[] files = directory.listFiles(File::isFile);
        long lastModifiedTime = Long.MIN_VALUE;
        File chosenFile = null;
        if (files != null) {
            for (File file : files) {
                if (file.lastModified() > lastModifiedTime) {
                    chosenFile = file;
                    lastModifiedTime = file.lastModified();
                }
            }
        }
        return chosenFile;
    }

    @Then("^validate Enquiry Tab Columns$")
    public void ValidateEnquiryColumns() throws IOException {
        DriverManager.getWebDriver().navigate().refresh();
        DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(2))));

        List<String> list1 = new ArrayList<>();
        list1.add("Product Name");
        list1.add("Application No.");
        list1.add("Loan No.");
        list1.add("PAN No.");
        list1.add("Mobile No.");
        list1.add("Policy No.");
        list1.add("Premium");
        list1.add("Customer Name");
        list1.add("Status");
        list1.add("Action");
        int c = 0;
        for (int i = 0; i < list1.size(); i++) {
            String Columns = DriverAction.getElement(By.xpath(Read_Locators.Enquiry_Tab_Col.replace("itr", String.valueOf(i + 1)))).getText();
            if (Columns.equals(list1.get(i))) {
                c++;
            }
        }
        if (c == list1.size()) {
            GemTestReporter.addTestStep("Validating weather all the required columns are present in Enquiry Table", "All Columns are there in Enquiry Table", STATUS.PASS, DriverAction.takeSnapShot());

        } else {
            GemTestReporter.addTestStep("Validating weather all the required columns are present in Enquiry Table", "All Columns are not there in Enquiry Table", STATUS.FAIL, DriverAction.takeSnapShot());

        }
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
            Actions act = new Actions(DriverManager.getWebDriver());
            act.sendKeys(Keys.ENTER).build().perform();
            // WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20));
            //  wait.until(ExpectedConditions.textToBe(Read_Locators.Startdate,"27-01-2023"));
            DriverAction.setImplicitTimeOut(10);
            String Startdate = DriverManager.getWebDriver().findElement(By.xpath("//div[@class='mat-date-range-input-container']")).getAttribute("text");

        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }


    }

    @Then("^Download PDF and validate (.+)$")
    public void validatepdfdownload(String filepath) {
        DriverAction.click(Read_Locators.Action_Download_icon);
        DriverAction.waitSec(10);

        File file = new File(filepath);
        File file1 = getLastModified(filepath);

        if (String.valueOf(file1).contains("pdf")) {
            GemTestReporter.addTestStep("Validating weather User able to download PDF file", "User successfully able to download the PDF file", STATUS.PASS, DriverAction.takeSnapShot());

        } else {
            GemTestReporter.addTestStep("Validating weather User able to download PDF file", "User not able to download the PDF file", STATUS.FAIL, DriverAction.takeSnapShot());

        }


    }

    @Then("^validate Pagination functionality in Enquiry Tab")
    public void validatePagination() {
        DriverManager.getWebDriver().navigate().refresh();
        DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(2))));

        //JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
        // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        if (DriverAction.getElement(Read_Locators.Pagination).isDisplayed()) {
            String pag_text = DriverAction.getElement(Read_Locators.Pagination).getText();
            GemTestReporter.addTestStep("Verify Pagination", "Pagination is present : " + pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verify Pagination", "Pagination is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Right).isDisplayed()) {
            DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Right).click();
            DriverAction.waitSec(2);
            String pag_text = DriverAction.getElement(Read_Locators.Pagination).getText();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Next Page Navigation", "Navigate to Next Page is working : " + pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verify Next Page Pagination", "Next Page Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Left).isDisplayed()) {
            DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Left).click();
            DriverAction.waitSec(2);
            String pag_text = DriverAction.getElement(Read_Locators.Pagination).getText();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Previous Page Navigation", "Navigate to Previous Page is working : " + pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verify Previous Page Pagination", "Previous Page Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @Then("^validate Application Column ui$")
    public void validateapplicationui() {
        try {
            DriverAction.click(Read_Locators.Application_No);
            String Application_No = DriverAction.getElement(Read_Locators.Application_No).getText();
            String Application_Label1=DriverAction.getElement(By.xpath(Read_Locators.Application_Label.replace("no", Application_No))).getText();
            String arr[]=Application_Label1.split("-");
            System.out.print(arr[1]);
            if(arr[1].contains(Application_No))
            {
                GemTestReporter.addTestStep("Validating weather Application Detail Label is present on Application Popup", "Application Detail Label is present on Application Pop", STATUS.PASS, DriverAction.takeSnapShot());

            }
            else {
                GemTestReporter.addTestStep("Validating weather Application Detail Label is present on Application Popup", "Application Detail Label is not present on Application Pop", STATUS.FAIL, DriverAction.takeSnapShot());

            }


            /*  if (DriverAction.getElement(By.xpath(Read_Locators.Application_Label.replace("no", Application_No))).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Application Detail Label is present on Application Popup", "Application Detail Label is present on Application Pop", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Application Detail Label is present on Application Popup", "Application Detail Label is not present on Application Pop", STATUS.FAIL, DriverAction.takeSnapShot());

            }*/
            if (DriverAction.getElement(Read_Locators.CUSTOMER_DETAILS_Label).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Customer Detail Label is present on Application Popup", "Customer Detail Label is present on Application Pop", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Customer Detail Label is present on Application Popup", "Customer Detail Label is not present on Application Pop", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Name_Col_Customer_Details).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Name Column is present in Customer Detail Table  on Application Popup", "Name Column is present in Customer Detail Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Name Column is present in Customer Detail Table  on Application Popup", "Name Column is not present in Customer Detail Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Mobile_No_Col_Customer_Details).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Mobile No Column is present in Customer Detail Table  on Application Popup", "Mobile No Column is present in Customer Detail Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Name Column is present in Customer Detail Table  on Application Popup", "Mobile No Column is not present in Customer Detail Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Email_Col_Customer_Details).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Email Column is present in Customer Detail Table  on Application Popup", "Email Column is present in Customer Detail Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Email Column is present in Customer Detail Table  on Application Popup", "Email Column is not present in Customer Detail Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Loan_Details_Label).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Loan Detail Label is present on Application Popup", "Loan Detail Label is present on Application Pop", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Loan Detail Label is present on Application Popup", "Loan Detail Label is not present on Application Pop", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Loan_Col_Loan_Details).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Loan Number Column is present in Loan Detail Table  on Application Popup", "Loan No Column is present in Loan Detail Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Loan Number Column is present in Loan Detail Table  on Application Popup", "Loan No Column is not present in Loan Detail Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Loan_Amount_Col_Loan_Details).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Loan Amount Column is present in Loan Detail Table  on Application Popup", "Loan Amount Column is present in Loan Detail Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Loan Amount Column is present in Loan Detail Table  on Application Popup", "Loan Amount Column is not present in Loan Detail Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Loan_Term_Col_Loan_Details).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Loan Term Column is present in Loan Detail Table  on Application Popup", "Loan Term Column is present in Loan Detail Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Loan Term Column is present in Loan Detail Table  on Application Popup", "Loan Term Column is not present in Loan Detail Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Loan_Disbursement_Col_Loan_Details).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Loan Disbursement Column is present in Loan Detail Table  on Application Popup", "Loan Disbursement Column is present in Loan Detail Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Loan Disbursement Column is present in Loan Detail Table  on Application Popup", "Loan Disbursement Column is not present in Loan Detail Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Policy_Details).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Policy Details Label is present on Application Popup", "Policy Details Label is present on Application Popup", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Policy Details Label is present on Application Popup", "Policy Details Label is not present on Application Popup", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Sum_Assured).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Sum Assured Column is present in Policy Detail Table  on Application Popup", "Sum Assured Column is present in Policy Detail Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Sum Assured Column is present in Policy Detail Table  on Application Popup", "Sum Assured Column is not present in Policy Detail Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Premium).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Premium Column is present in Policy Detail Table  on Application Popup", "Premium Column is present in Policy Detail Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Premium Column is present in Policy Detail Table  on Application Popup", "Premium Column is not present in Policy Detail Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Payment_Frequency).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Premium Frequency Column is present in Policy Detail Table  on Application Popup", "Premium Frequency Column is present in Policy Detail Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Premium Frequency Column is present in Policy Detail Table  on Application Popup", "Premium Frequency Column is not present in Policy Detail Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Policy_Term).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Policy Term Column is present in Policy Detail Table  on Application Popup", "Policy Term Column is present in Policy Detail Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Policy Term Column is present in Policy Detail Table  on Application Popup", "Policy Term Column is not present in Policy Detail Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Policy_Terms).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Policy Terms Column is present in Policy Detail Table  on Application Popup", "Policy Terms Column is present in Policy Detail Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Policy Terms Column is present in Policy Detail Table  on Application Popup", "Policy Terms Column is not present in Policy Detail Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.DOB).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather DOB Column is present in Policy Detail Table  on Application Popup", "DOB Column is present in Policy Detail Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather DOB Column is present in Policy Detail Table  on Application Popup", "DOB Column is present in Policy Detail Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Insured_Name).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Insured Name Column is present in Policy Detail Table  on Application Popup", "Insured Name Column is present in Policy Detail Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Insured Name Column is present in Policy Detail Table  on Application Popup", "Insured Name Column is not present in Policy Detail Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Cross_Icon_Application_Popup).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Cross icon is present  on Application Popup", "Cross icon is  present  on Application Popup", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.click(Read_Locators.Cross_Icon_Application_Popup);
                GemTestReporter.addTestStep("Validating weather Application Popup Exit successfully", " Application Pop is not exit successfully", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Cross icon is present  on Application Popup", "Cross icon is not present  on Application Popup", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            DriverAction.click(Read_Locators.Application_No);
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
            js.executeScript("arguments[0].scrollIntoView(true);",DriverManager.getWebDriver().findElement(Read_Locators.Gender) );

            if (DriverAction.getElement(Read_Locators.Gender).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Scroll is working on Application Popup", "Scroll bar is working fine Application Popup", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Scroll is working on Application Popup", "Scroll bar is not working fine Application Popup", STATUS.FAIL, DriverAction.takeSnapShot());

            }



        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }

    }
    @Then("^validate Wib Report Ui with functionality$")
    public void validateWibReport() throws IOException{
        try{
            DriverAction.click(Read_Locators.Wip_Report_Tab);
            if (DriverAction.getElement(Read_Locators.Download_Report_Button).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Wip Tab is clickable on Wip Report screen", "Wip Tab is clickable on Wip Report screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Wip Tab is clickable on Wip Report screen", "Wip Tab is not clickable on Wip Report screen", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Wip_Report_Tab_Label).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Select report type and date to generate report Label is Visible  on Wip Report screen", "Select report type and date to generate report Label is Visible  on Wip Report screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Select report type and date to generate report Label is Visible  on Wip Report screen", "Select report type and date to generate report Label is not Visible  on Wip Report screen", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Calendar_icon).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Calendar icon is Visible  on Wip Report screen", "Calendar icon is Visible  on Wip Report screen", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.click(Read_Locators.dateButton);
               // DriverAction.click(Read_Locators.yearDropDown);
                DriverAction.waitSec(4);
                DriverAction.click(Read_Locators.Calendar_left_arrow_icon);
                DriverAction.waitSec(4);
                DriverAction.click(Read_Locators.SampleDate);
               Actions act = new Actions(DriverManager.getWebDriver());
               act.sendKeys(Keys.ENTER).build().perform();
                GemTestReporter.addTestStep("Validating weather User able to select the date from calendar icon", "User able to select the date from calender icon", STATUS.PASS, DriverAction.takeSnapShot());


            } else {
                GemTestReporter.addTestStep("Validating weather Calendar icon is Visible  on Wip Report screen", "Calendar icon is not Visible  on Wip Report screen", STATUS.FAIL, DriverAction.takeSnapShot());

            }

        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @Then("^Download Report and validate (.+)$")
    public void DownloadReportValidate(String filepath) throws IOException {
        try{

            if (DriverAction.getElement(Read_Locators.Download_Report_Validate).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Download Report button is visible on WIP Report screen", "Download Report button is visible on WIP Report screen", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.waitSec(5);
                DriverAction.click(Read_Locators.Download_Report_Validate);
                DriverAction.waitSec(5);
                File file = new File(filepath);
                File file1 = getLastModified(filepath);
                if (String.valueOf(file1).contains("xlsx")) {
                    GemTestReporter.addTestStep("Validating weather User able to download Excel file", "User successfully able to download the Excel file", STATUS.PASS, DriverAction.takeSnapShot());

                } else {
                    GemTestReporter.addTestStep("Validating weather User able to download Excel file", "User not able to download the Excel file", STATUS.FAIL, DriverAction.takeSnapShot());

                }

            } else {
                GemTestReporter.addTestStep("Validating weather Download Report button is visible on WIP Report screen", "Download Report button is not visible on WIP Report screen", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }
    @Then("^validate Send Via Email Button functionality$")
    public void validate_Send_ViaEmail() throws IOException {
        try{
            if (DriverAction.getElement(Read_Locators.Send_Via_Email_btn).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Send Via Email button is visible on WIP Report screen", "Send Via Email button is visible on WIP Report screen", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.click(Read_Locators.Send_Via_Email_btn);
                WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20));
                wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//span[text()='Report sent Via Email..']"), "Verification required"));
                if (DriverAction.getElement(Read_Locators.send_email_popup).isDisplayed()) {
                    GemTestReporter.addTestStep("Validating weather send email pop appear on Report screen", "Send Email pop up appear on Report Screen", STATUS.PASS, DriverAction.takeSnapShot());
                }
                else
                {
                    GemTestReporter.addTestStep("Validating weather send email pop appear on Report screen", "Send Email pop up not appear on Report Screen", STATUS.FAIL, DriverAction.takeSnapShot());
                }
               }
            else {
                GemTestReporter.addTestStep("Validating weather Send Via Email button is visible on WIP Report screen", "Send Via Email button is not visible on WIP Report screen", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }
    @Then("^validate Report page ui$")
    public void validateReportpageui() throws IOException {
        try {
            if (DriverAction.getElement(Read_Locators.Generate_Label).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Generate Label  is Present on Report screen", "Generate Label is present on Report Screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Generate Label  is Present on Report screen", "Generate Label is not present on Report Screen", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Wip_Report_Tab).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Wip Report tab is Present on Report screen", "Wip Report tab is present on Report Screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Wip Report tab is Present on Report screen", "Wip Report tab is not present on Report Screen", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.IIB_Report_Tab).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather IIB Report tab is Present on Report screen", "IIB Report tab is present on Report Screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather IIB Report tab is Present on Report screen", "IIB Report tab is not present on Report Screen", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.Wip_Report_RightArrow).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Wip Report Arrow icon  is Present on Wib Report Tab", "Wip tab Arrow icon is present on Wib Report Tab", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Wip Report Arrow icon  is Present on Wib Report Tab", "Wip tab Arrow icon is not present on Wib Report Tab", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.IIB_Report_RightArrow).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather IIB Report Arrow icon  is Present on Wib Report Tab", "IIB tab Arrow icon is present on IIB Report Tab", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather IIB Report Arrow icon  is Present on Wib Report Tab", "IIB tab Arrow icon is not present on IIB Report Tab", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if(DriverAction.getElement(superAdmin_Locators.Hamburger).isDisplayed())
            {
                GemTestReporter.addTestStep("Verify Hamburger is visible"," Hamburger button is visible",STATUS.PASS,DriverAction.takeSnapShot());
                DriverAction.getElement(superAdmin_Locators.Hamburger).click();
                GemTestReporter.addTestStep("Verify Hamburger is clickable"," Hamburger button is clickable",STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Hamburger is visible"," Hamburger button is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }
    @Then("^Navigate to Report tab and validate logo$")
    public void Navigateandvalidate1() throws IOException {
        try {
            DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(3))));
            if (DriverAction.getElement(Locator.Logo).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Logo is Visible on Report tab", "Logo is visible on Report tab", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Logo is Visible on Report tab", "Logo is not visible on Report tab", STATUS.FAIL, DriverAction.takeSnapShot());
            }

            String tab = DriverAction.getElement(Read_Locators.ReportTab).getAttribute("class");
            if (tab.contains("active")) {
                GemTestReporter.addTestStep("Validating weather Report tab is highlighted", "Report tab is highlighted", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Report tab is highlighted", "Report tab is not highlighted", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }

    }

}
