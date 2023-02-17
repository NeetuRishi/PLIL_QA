package com.gemini.PLIL.StepDefination;

import org.openqa.selenium.interactions.Actions;
import com.gemini.PLIL.Locators.GopsUser_Locators;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class GopsUser {
    //GOPS user login
    @Given("^Enter the Username and password for GOPS User and login$")
    public void login_as_gopsUser() {
        DriverAction.typeText(Locator.Email_Input_Field, "deepakmalhotra2070@gmail.com");
        WebElement ele = DriverManager.getWebDriver().findElement(Locator.Password_Input_Field);
        ele.sendKeys("Asdf@1234");
        GemTestReporter.addTestStep("Password", "****", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.click(By.xpath("//button[@type='submit']"));
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(50));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//mat-error[text()=' Verification required ']"), "Verification required"));
        DriverAction.click(Locator.Login);
//        DriverAction.waitSec(15);
    }

    @Then("^Validate that Home page opens and logo is visible$")
    public void validateHomePage() {
        if (DriverAction.getElement(GopsUser_Locators.homeTab).isDisplayed())
            GemTestReporter.addTestStep("Verify whether Home Page Opens", "Home Page Opened Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        if (DriverAction.getElement(GopsUser_Locators.PLIL_logo).isDisplayed())
            GemTestReporter.addTestStep("Check whether PLIL Logo is present or not", "Logo is found successfully", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @Then("^Validate Hamburger Button is present$")
    public void validateHamburgerButton() {
        if (DriverAction.getElement(GopsUser_Locators.hamburgerButton).isDisplayed())
            GemTestReporter.addTestStep("Verify whether Hamburger Button is present or not", "Hamburger button is found", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @Then("^Validate Name,Email ID, Mobile Number are present$")
    public void validateDifferentOptions() {
        if (DriverAction.getElement(GopsUser_Locators.selectValue("Name")).isDisplayed())
            GemTestReporter.addTestStep("Verify whether Name Field is displayed", "Name is displayed", STATUS.PASS, DriverAction.takeSnapShot());
        if (DriverAction.getElement(GopsUser_Locators.selectValue("Email ID")).isDisplayed())
            GemTestReporter.addTestStep("Verify whether Email ID Field is displayed", "Email ID is displayed", STATUS.PASS, DriverAction.takeSnapShot());
        if (DriverAction.getElement(GopsUser_Locators.selectValue("Mobile No.")).isDisplayed())
            GemTestReporter.addTestStep("Verify whether Mobile No. Field is displayed", "Mobile No. is displayed", STATUS.PASS, DriverAction.takeSnapShot());

    }

    @Then("^Validate Navigate To label is present$")
    public void NavigateTo() {
        if (DriverAction.getElement(GopsUser_Locators.selectValue("Navigate to")).isDisplayed())
            GemTestReporter.addTestStep("Verify Navigate to label is present or not", "Navigate to label is present", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @Then("^Validate Gops Enquiry Card and Reverse Feed Enquiry Card is present$")
    public void validateDifferentCards() {
        if (DriverAction.getElement(GopsUser_Locators.card1).getText().equals("Reverse Feed Upload"))
            GemTestReporter.addTestStep("verify whether Reverse Feed Upload card is present", "Reverse Feed Upload card is present", STATUS.PASS, DriverAction.takeSnapShot());
        if (DriverAction.getElement(GopsUser_Locators.card2).getText().equals("Gops Enquiry"))
            GemTestReporter.addTestStep("verify whether Gops Enquiry card is present", "Gops Enquiry card is present", STATUS.PASS, DriverAction.takeSnapShot());

    }

    @Then("^Validate Logout button is present$")
    public void logoutValidation() {
        if (DriverAction.getElement(GopsUser_Locators.selectValue("Logout")).isDisplayed())
            GemTestReporter.addTestStep("verify whether Logout Button is present", "Logout button found ", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @Then("^Click on GOPS Enquiry Tab and validate that Gops Enquiry tab is highlighted$")
    public void clickOnGopsEnquiry() {
        if (DriverAction.getElement(GopsUser_Locators.GopsTab).isDisplayed())
            GemTestReporter.addTestStep("Check whether Gops Enquiry Tab is present or not", "Gops Enquiry Tab found successfully", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.getElement(GopsUser_Locators.GopsTab).click();
        DriverAction.waitSec(5);
        GemTestReporter.addTestStep("Navigate to the Gops Enquiry Tab", "Navigated successfully", STATUS.PASS, DriverAction.takeSnapShot());
        if (DriverAction.getElement(By.xpath("//a[@href='/admin/groupOps']")).getAttribute("class").equals("nav-link active"))
            GemTestReporter.addTestStep("Check whether Gops Enquiry Tab got highlighted or not", "Gops Enquiry Tab got highlighted", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether Gops Enquiry Tab got highlighted or not", "It did not get highlighted", STATUS.FAIL, DriverAction.takeSnapShot());

    }

    @Then("^Check whether hamburgher button is present or not and clicking it minimizes the side bar$")
    public void clickHamburger() {
        if (DriverAction.getElement(GopsUser_Locators.hamburgerButton).isDisplayed())
            GemTestReporter.addTestStep("Check whether hamburger button is present or not", "Hamburhger button found successfully", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.getElement(GopsUser_Locators.hamburgerButton).click();
        GemTestReporter.addTestStep("Click on the Hamburger button", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());
        if (DriverAction.getElements(GopsUser_Locators.checkTabNames).size() == 0)
            GemTestReporter.addTestStep("Verify whether left pane tabs got minimized", "Left pane got minimized successfully", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify whether left pane tabs got minimized", "Could not minimize the left pane", STATUS.PASS, DriverAction.takeSnapShot());

    }

    @Then("^Validate Filter By Label is present$")
    public void filter() {
        if (DriverAction.getElement(GopsUser_Locators.selectValue("Filter by")).isDisplayed())
            GemTestReporter.addTestStep("Check whether Filter by label is present or not", "Filter By label found successfully", STATUS.PASS, DriverAction.takeSnapShot());

    }

    @Then("^Check whether Filter partner and status dropdown are working fine or not$")
    public void checkVariousFilters() {
        //check for the presence of partner dropdown and check its functionality
        if (DriverAction.getElement(GopsUser_Locators.selectValue("Partner")).isDisplayed()) {
            GemTestReporter.addTestStep("Check whether drop down with partner placeholder is present or not", " found successfully", STATUS.PASS, DriverAction.takeSnapShot());
        }
        DriverAction.waitSec(4);
        DriverAction.getElement(GopsUser_Locators.partnerDropdown).click();
        GemTestReporter.addTestStep("click on the partner filter dropdown", "clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.getElement(GopsUser_Locators.dropdownMenu("1")).click();
        GemTestReporter.addTestStep("Select the first option 'Aadhar Housing Finance' from the drodown menu", "selected successfully", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.waitSec(10);
        List<WebElement> li = DriverAction.getElements(By.xpath("//table/tbody/tr"));
        int i = 0;
        for (i = 0; i < li.size(); i++) {
            if (!(DriverAction.getElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]")).getText().equals("Aadhar Housing Finance"))) {
                GemTestReporter.addTestStep("Check whether the correct partner filter was applied and is working or not", "The applied filter is not working properly", STATUS.FAIL, DriverAction.takeSnapShot());
                break;
            }
        }
        if (i == li.size())
            GemTestReporter.addTestStep("Check whether the correct partner filter was applied and is working or not", "The applied filter is working properly", STATUS.PASS, DriverAction.takeSnapShot());
//check for the presence of status dropdown and check its functionality
        if (DriverAction.getElement(GopsUser_Locators.statusDropdown).isDisplayed())
            GemTestReporter.addTestStep("Check whether status dropdown is present or not", " found successfully", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.getElement(GopsUser_Locators.statusDropdown).click();
        GemTestReporter.addTestStep("Click on the status dropdown to open it's menu", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.getElement(GopsUser_Locators.dropdownMenu("4")).click();
        GemTestReporter.addTestStep("Select any filter from the status dropdown", "filter 'Uploaded to System' selected successfully", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.waitSec(10);
        List<WebElement> li1 = DriverAction.getElements(By.xpath("//table/tbody/tr"));
        int j = 0;
        for (j = 0; j < li1.size(); j++) {
            if (!(DriverAction.getElement(By.xpath("//table/tbody/tr[" + (j + 1) + "]/td[10]")).getText().equals(" Uploaded To System"))) {
                GemTestReporter.addTestStep("Check whether the correct status filter was applied and is working or not", "The applied filter is not working properly", STATUS.FAIL, DriverAction.takeSnapShot());
                break;
            }
        }
        if (j == li1.size())
            GemTestReporter.addTestStep("Check whether the correct status filter was applied and is working or not", "The applied filter is working properly", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @Then("^Check whether date functionality is working properly or not$")
    public void checkDate() {

    }

    @Then("^Check whether clear button is present or not and is working fine$")
    public void clearButton() {
        if (DriverAction.getElement(GopsUser_Locators.selectValue("Clear")).isDisplayed())
            GemTestReporter.addTestStep("Check whether clear button is present or not", "found successfully", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether clear button is present or not", "could not find the clear button", STATUS.FAIL, DriverAction.takeSnapShot());
        DriverAction.getElement(GopsUser_Locators.selectValue("Clear")).click();
        GemTestReporter.addTestStep("Click on the clear Button", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.waitSec(4);
        //Now check the functionality of clear button
        if ((DriverAction.getElement(GopsUser_Locators.inputBoxText("Aadhar Housing Finance")) == null)
                && (DriverAction.getElement(GopsUser_Locators.inputBoxText("Uploaded To System")) == null)
                && (DriverAction.getElement(GopsUser_Locators.inputBoxText("Start date")) != null))
            GemTestReporter.addTestStep("Check whether Clear button is working properly or not", "Clear button is working properly", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether Clear button is working properly or not", "Clear button is not working properly", STATUS.FAIL, DriverAction.takeSnapShot());

    }

    @Then("^Check whether search button is present and is working properly or not$")
    public void checkSearch() {
        if (DriverAction.getElement(GopsUser_Locators.searchBox).isDisplayed())
            GemTestReporter.addTestStep("Check whether Search bar is present or not", "found successfully", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether Search bar is present or not", "could not find the search bar", STATUS.FAIL, DriverAction.takeSnapShot());
        DriverAction.getElement(GopsUser_Locators.searchBox).sendKeys("0002" + Keys.ENTER);
        DriverAction.waitSec(4);
        List<WebElement> li1 = DriverAction.getElements(By.xpath("//table/tbody/tr"));
        int j = 0;
        for (j = 0; j < li1.size(); j++) {
            if (!(DriverAction.getElement(By.xpath("//table/tbody/tr[" + (j + 1) + "]/td[3]")).getText().contains("0002"))) {
                GemTestReporter.addTestStep("Check whether the Search functionality is working properly or not", "it is giving wrong data", STATUS.FAIL, DriverAction.takeSnapShot());
                break;
            }
        }
        if (j == li1.size())
            GemTestReporter.addTestStep("Check whether the Search functionality is working properly or not", "it is working properly and giving correct data", STATUS.PASS, DriverAction.takeSnapShot());

    }

    @Then("Check whether export button is present and is working fine or not")
    public void checkWhetherExportButtonIsPresentAndIsWorkingFineOrNot() {
        try {
            if (DriverAction.getElement(Read_Locators.Exportbtn).isDisplayed()) {
                GemTestReporter.addTestStep("Validating whether Export Button is present ", "Export Button is present ", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating whether Export Button is present ", "Export Button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.click(Read_Locators.Exportbtn);
            DriverAction.waitSec(10);
            File file = new File("Downloads");
            File file1 = getLastModified("Downloads");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String str = formatter.format(date);
            String nDate = date.toString();
            String[] arr = str.split("/");
            if (String.valueOf(file1).contains(arr[0])) {
                GemTestReporter.addTestStep("Validating whether User is able to download excel file", "User successfully able to download the excel file", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating whether User is able to download excel file", "User not able to download the excel file", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {

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

    @Then("^Click on (.+) and check that it got highlighted$")
    public void clickOnTabAndCheckThatItGotHighlighted(String tab) {
        String text = "", href = "";
        if (tab.equals("Reverse Feed Upload")) {
            text = "1";
            href = "//a[@href='/dashboard/reverse-feed-upload']";
        } else if (tab.equals("Gops Enquiry")){
            text = "2";
            href = "//a[@href='/admin/groupOps']";
        }
        else if(tab.equals("User Management"))
        {

            href="//a[@href='/admin/manage-user']";
        }
        else if(tab.equals("Bulk Upload"))
        {
            href="//a[@href='/dashboard/bulk-upload']";
        }
        if (DriverAction.getElement(By.xpath(href)).isDisplayed())
            GemTestReporter.addTestStep("Check whether " + tab + " is present or not", tab + " tab found successfully", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.getElement(By.xpath(href)).click();
        DriverAction.waitSec(5);
        GemTestReporter.addTestStep("Navigate to the " + tab + " tab", "Navigated successfully", STATUS.PASS, DriverAction.takeSnapShot());
        if (DriverAction.getElement(By.xpath(href)).getAttribute("class").equals("nav-link active"))
            GemTestReporter.addTestStep("Check whether " + tab + " tab got highlighted or not", tab + " tab got highlighted", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether " + tab + " Tab got highlighted or not", "It did not get highlighted", STATUS.FAIL, DriverAction.takeSnapShot());

    }

    @Then("Check whether Reverse Feed Upload label appears on the homepage")
    public void checkWhetherTabLabelAppearsOnTheHomepage() {
        if (DriverAction.getElement(By.xpath("//h4[text()='Reverse Feed Upload']")).isDisplayed())
            GemTestReporter.addTestStep("Check whether Reverse Feed Upload label got displayed on the homescreen ", " Label Found successfully", STATUS.PASS, DriverAction.takeSnapShot());

    }

    @Then("Check if No partner is selected from dropdown and cliked on Upload, then error is thrown")
    public void errorThrown() {
        WebElement ele = DriverManager.getWebDriver().findElement(By.xpath("//input[@formcontrolname='fileUpload']"));
        ele.sendKeys("C:/Users/tr.sahni/Downloads/rev.xlsx");
        GemTestReporter.addTestStep("Click on the choose file button", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());

        GemTestReporter.addTestStep("Select a file from file manager", "Selected successfully", STATUS.PASS, DriverAction.takeSnapShot());


        DriverAction.getElement(GopsUser_Locators.UploadButton).click();
        if (DriverAction.getElement(GopsUser_Locators.error).isDisplayed())
            GemTestReporter.addTestStep("Check whether error is thrown or not  with no partner name", "Error is thrown successfully", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether error is thrown or not with no partner name", "Error is not thrown", STATUS.FAIL, DriverAction.takeSnapShot());

    }

    @Then("^Check whether Select Partner name dropdown is present and working properly$")
    public void checkDropdown() {
        if (DriverAction.getElement(GopsUser_Locators.partnerNameDropdown).isDisplayed())
            GemTestReporter.addTestStep("Check whether partner name dropdown is present or not", " Partner Name dropdown found successfully", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether partner name dropdown is present or not", " Partner Name dropdown is not found", STATUS.FAIL, DriverAction.takeSnapShot());
        DriverAction.getElement(GopsUser_Locators.partnerNameDropdown).click();
        GemTestReporter.addTestStep("Click on the dropdown to open the context menu", "Dropdown opned successfully", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.getElement(GopsUser_Locators.dropdownMenu("4")).click();
        GemTestReporter.addTestStep("Select the first option 'Piramal Capital and Housing Finance ' from the context menu", "Selected Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        if (DriverAction.getElement(By.xpath("//span[text()=' Piramal Capital and Housing Finance ']")) != null)
            GemTestReporter.addTestStep("Check whether filter got applied successfully or not", "Filter was applied successfully", STATUS.PASS, DriverAction.takeSnapShot());

    }

    @Then("check whether Click Here,Discard,Upload button is present or not")
    public void checkWhetherClickHereLinkIsPresentOrNot() {
        if (DriverAction.getElement(GopsUser_Locators.selectValue(" Click here")).isDisplayed())
            GemTestReporter.addTestStep("Check whether 'Click Here' button is present or not", "Found successfully", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether 'Click Here' button is present or not", "Not Found ", STATUS.FAIL, DriverAction.takeSnapShot());

        if (DriverAction.getElement(GopsUser_Locators.selectValue(" Upload ")).isDisplayed())
            GemTestReporter.addTestStep("Check whether 'Upload' button is present or not", "Found successfully", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether 'Upload' button is present or not", "Not Found", STATUS.FAIL, DriverAction.takeSnapShot());
        if (DriverAction.getElement(GopsUser_Locators.selectValue("Discard")).isDisplayed())
            GemTestReporter.addTestStep("Check whether 'Discard' button is present or not", "Found successfully", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether 'Discard' button is present or not", "Not Found", STATUS.FAIL, DriverAction.takeSnapShot());
    }
    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().contains(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }

    @Then("^click on Click here and check whether excel got downloaded or not$")
    public void checkClickFunctionality() {
        DriverAction.waitSec(5);
        DriverAction.getElement(GopsUser_Locators.clickHere).click();
        DriverAction.waitSec(10);

        Month month=java.time.LocalDate.now().getMonth();
        int d=0,year=0;
DayOfWeek day =java.time.LocalDate.now().getDayOfWeek();
d=java.time.LocalDate.now().getDayOfMonth();
year=java.time.LocalDate.now().getYear();

String filename=day.toString().substring(0,1)+day.toString().substring(1,3).toLowerCase()+" "+month.toString().substring(0,1)+month.toString().substring(1,2).toLowerCase();
        boolean result=isFileDownloaded("C:\\Users\\tr.sahni\\Downloads",filename);
if(result==true)
    GemTestReporter.addTestStep("Validating whether User is able to download excel file", "User successfully able to download the excel file", STATUS.PASS, DriverAction.takeSnapShot());
else
    GemTestReporter.addTestStep("Validating whether User is able to download excel file", "User was not able to download the excel file", STATUS.FAIL, DriverAction.takeSnapShot());
//            DriverAction.click(GopsUser_Locators.selectValue(" Click here"));
//

//            File file = new File("C:\\Users\\tr.sahni\\Downloads");
//            File file1 = getLastModified("Downloads");
//            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//            Date date = new Date();
//            String str = formatter.format(date);
//            String nDate = date.toString();
//            String[] arr = str.split("/");
//            if (String.valueOf(file1).contains(arr[0])) {
//                GemTestReporter.addTestStep("Validating whether User is able to download excel file", "User successfully able to download the excel file", STATUS.PASS, DriverAction.takeSnapShot());
//            } else {
//                GemTestReporter.addTestStep("Validating whether User is able to download excel file", "User not able to download the excel file", STATUS.FAIL, DriverAction.takeSnapShot());
//            }
//        } catch (Exception e) {
//
//            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
//        }
    }

    @Then("^click on choose button and select a file from the file manager$")
    public void chooseFile() throws AWTException {
        WebElement ele = DriverManager.getWebDriver().findElement(GopsUser_Locators.chooseFile);
        ele.sendKeys("C:/Users/tr.sahni/Downloads/rev.xlsx");


        GemTestReporter.addTestStep("Click on the choose file button", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());


        if (DriverAction.getElement(GopsUser_Locators.chooseFile).getAttribute("class").contains("valid"))
            GemTestReporter.addTestStep("Select a file from file manager", "Selected successfully", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Select a file from file manager", "Could not select the file ", STATUS.FAIL, DriverAction.takeSnapShot());

    }

    @Then("Click on Upload File button and check if file got uploaded successfully and message got displayed")
    public void fileUpload() {
        DriverAction.getElement(GopsUser_Locators.UploadButton).click();
        GemTestReporter.addTestStep("Click on the upload button to upload the file", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(GopsUser_Locators.selectValue("Data Uploaded")));
        if (DriverAction.getElement(GopsUser_Locators.selectValue("Data Uploaded")).isDisplayed())
            GemTestReporter.addTestStep("Check whether Data got uploaded successfully or not", "Data got uploaded successfully and Upload message got displayed", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether Data got uploaded successfully or not", "data was not uploaded successfully", STATUS.FAIL, DriverAction.takeSnapShot());
    }

}
