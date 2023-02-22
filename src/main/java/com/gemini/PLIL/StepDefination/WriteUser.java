package com.gemini.PLIL.StepDefination;
import com.gemini.PLIL.Locators.*;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.hu.De;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WriteUser {
    @Then("^Check whether Type dropdown is present and working properly or not$")
    public void checkDropdown()
    {
        if(DriverAction.getElement(writeUserLocator.typeDropdown).isDisplayed())
            GemTestReporter.addTestStep("Check whether Type dropdown is present or not","Dropdown found successfully", STATUS.PASS,DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether Type dropdown is present or not","Dropdown was not found", STATUS.FAIL,DriverAction.takeSnapShot());
        DriverAction.getElement(writeUserLocator.typeDropdown).click();
        GemTestReporter.addTestStep("Click on the dropdown","Clicked successfully",STATUS.PASS,DriverAction.takeSnapShot());
      DriverAction.getElement(GopsUser_Locators.dropdownMenu("1")).click();
      GemTestReporter.addTestStep("Select the dropdown's first option","Selected successfully",STATUS.PASS,DriverAction.takeSnapShot());
if(DriverAction.getElement(writeUserLocator.dropdownValue).getText().contains("Consent"))
    GemTestReporter.addTestStep("Verify whether dropdown works fine or not","Validated successfully",STATUS.PASS,DriverAction.takeSnapShot());
else
    GemTestReporter.addTestStep("Verify whether dropdown works fine or not","Validation failed",STATUS.FAIL,DriverAction.takeSnapShot());


    }

    @Then("check that Upload button is not enabled until a file is selected")
    public void checkThatUploadButtonIsNotEnabledUntilAFileIsSelected() {
        if (DriverAction.getElement(GopsUser_Locators.selectValue("Upload")).getAttribute("Disabled").equals("true"))
        {
            GemTestReporter.addTestStep("Check whther upload button is disabled until a file is selected","Verified successfully",STATUS.PASS,DriverAction.takeSnapShot());

        }
        else
            GemTestReporter.addTestStep("Check whther upload button is disabled until a file is selected","Verification Failed",STATUS.FAIL,DriverAction.takeSnapShot());
    }
    @Then("^Navigate to Rejected Case tab and validate logo$")
    public void Navigate_Rejected_Validate() throws IOException {
        try {
            DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(7))));
            if (DriverAction.getElement(Locator.Logo).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Logo is Visible on Rejected tab", "Logo is visible on Rejected tab", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Logo is Visible on Rejected tab", "Logo is not visible on Rejected tab", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            String tab = DriverAction.getElement(Read_Locators.RejectedTab).getAttribute("class");
            if (tab.contains("active")) {
                GemTestReporter.addTestStep("Validating weather Rejected tab is highlighted", "Rejected tab is highlighted", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Rejected tab is highlighted", "Rejected tab is not highlighted", STATUS.FAIL, DriverAction.takeSnapShot());

            }

        }
        catch (Exception e) {
//            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }
    @Then("validate Reversed Feed page ui for write user")
    public void rev()
    {
        try {
            DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(6))));
            if (DriverAction.getElement(Read_Locators.ReversedFeedLabel).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Reversed Feed Label  is Present on Reversed Feed screen", "Reversed Feed Label is present on Rejected Screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Reversed Feed Label  is Present on Reversed Feed screen", "Reversed Feed Label is not present on Rejected Screen", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.FilterByLable).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather FilterBy Label  is Present on Reversed Feed screen", "FilterBy Label is present on Reversed Feed Screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather FilterBy Label  is Present on Reversed Feed screen", "FilterBy Label is not present on Reversed Feed Screen", STATUS.FAIL, DriverAction.takeSnapShot());

            }

            if (DriverAction.getElement(Read_Locators.Clearbtn).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Create Button is Present on Reversed Feed screen", "Create Button is present on Reversed Feed Screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Create Button is Present on Reversed Feed screen", "Create Button is not present on Reversed Feed Screen", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            if (DriverAction.getElement(Read_Locators.StatusLabel).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Status Label  is Present on Reversed Feed screen", "Status Label is present on Reversed Feed Screen", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.getElement(Read_Locators.Status_Dropdown).click();
                if (DriverAction.getElement(Read_Locators.StatusDropdownDiv).isDisplayed()) {
                    GemTestReporter.addTestStep("Validating weather Status Dropdown is working fine on Reversed Feed screen", "Status Dropdown is working fine on Reversed Feed screen", STATUS.PASS, DriverAction.takeSnapShot());
                }
                else {
                    GemTestReporter.addTestStep("Validating weather Status Dropdown is working fine on Reversed Feed screen", "Status Dropdown is not working fine on Reversed Feed screen", STATUS.FAIL, DriverAction.takeSnapShot());
                }
                Actions act = new Actions(DriverManager.getWebDriver());
                act.sendKeys(Keys.ENTER).build().perform();

            } else {
                GemTestReporter.addTestStep("Validating weather Status Label  is Present on Reversed Feed screen", "Status Label is not present on Reversed Feed Screen", STATUS.FAIL, DriverAction.takeSnapShot());

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

        }
        catch (Exception e) {
//            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }
    @Then("validate Search Field on Reversed Feed write user Screen")
    public void rev3()
    {
        try{
            if (DriverAction.getElement(Read_Locators.SearchInput).isDisplayed()) {
                GemTestReporter.addTestStep("Verify Search Input is visible on Reversed Feed Screen", "Search Input is visible on Reversed Feed Screen" , STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify Search Input is visible on Reversed Feed Screen", "Search Input is not visible on Reversed Feed Screen", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            String FetchedApplicationNo = DriverAction.getElement(Read_Locators.SampleLoanNo).getText();
            DriverAction.typeText(Read_Locators.SearchInput, FetchedApplicationNo);
            Actions act = new Actions(DriverManager.getWebDriver());
            act.sendKeys(Keys.ENTER).build().perform();
            String FilteredApplicationNo = DriverAction.getElement(Read_Locators.SampleLoanNo).getText();
            if(FetchedApplicationNo.equals(FilteredApplicationNo))
            {
                GemTestReporter.addTestStep("Validate Data is Filtered Properly", "Data is Filtered successfully" , STATUS.PASS, DriverAction.takeSnapShot());

            }
            else {
                GemTestReporter.addTestStep("Validate Data is Filtered Properly", "Data is not Filtered successfully", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverManager.getWebDriver().navigate().refresh();
            DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(6))));



        }
        catch (Exception e) {
//            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }
    @Then("validate Reversed Feed for write user Tab Columns")
    public void rev2()
    {
        DriverManager.getWebDriver().navigate().refresh();
        DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(6))));

        List<String> list1 = new ArrayList<>();
        list1.add("Policy No.");
        list1.add("Partner Name");
        list1.add("Application No.");
        list1.add("Loan Account No.");
        list1.add("COI Number");
        list1.add("Application Status");
        list1.add("Description");
        list1.add("View");

        int c = 0;
        for (int i = 0; i < list1.size(); i++) {
            String Columns = DriverAction.getElement(By.xpath(Read_Locators.Enquiry_Tab_Col.replace("itr", String.valueOf(i + 1)))).getText();
            if (Columns.equals(list1.get(i))) {
                c++;
            }
        }
        if (c == list1.size()) {
            GemTestReporter.addTestStep("Validating weather all the required columns are present in Reversed Feed Table", "All Columns are there in Reversed Feed Table", STATUS.PASS, DriverAction.takeSnapShot());

        } else {
            GemTestReporter.addTestStep("Validating weather all the required columns are present in Reversed Feed Table", "All Columns are not there in Reversed Feed Table", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }
    @Then("Navigate to Reverse Feed tab and validate logo")
    public void reversed()
    {
        try {
            DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(6))));
            if (DriverAction.getElement(Locator.Logo).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Logo is Visible on Revered Feed tab", "Logo is visible on Reversed Feed tab", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Logo is Visible on Revered Feed tab", "Logo is not visible on Reversed Feed tab", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            String tab = DriverAction.getElement(Read_Locators.ReversedFeedTab).getAttribute("class");
            if (tab.contains("active")) {
                GemTestReporter.addTestStep("Validating weather Reversed Feed tab is highlighted", "Reversed Feed tab is highlighted", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Rejected tab is highlighted", "Reversed Feed tab is not highlighted", STATUS.FAIL, DriverAction.takeSnapShot());

            }

        }
        catch (Exception e) {
//            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }
    @Then("validate Search Field on Rejected Case Screen")
    public void search()
    {
        try{
            if (DriverAction.getElement(Read_Locators.SearchInput).isDisplayed()) {
                GemTestReporter.addTestStep("Verify Search Input is visible on Rejected Screen", "Search Input is visible on Rejected Screen" , STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify Search Input is visible on Rejected Screen", "Search Input is not visible on Rejected Screen", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            String FetchedLoanNo = DriverAction.getElement(Read_Locators.SampleLoanNo).getText();
            DriverAction.typeText(Read_Locators.SearchInput, FetchedLoanNo);
            Actions act = new Actions(DriverManager.getWebDriver());
            act.sendKeys(Keys.ENTER).build().perform();
            String FilteredLoanNo = DriverAction.getElement(Read_Locators.SampleLoanNo).getText();
            if(FetchedLoanNo.equals(FilteredLoanNo))
            {
                GemTestReporter.addTestStep("Validate Data is Filtered Properly", "Data is Filtered successfully" , STATUS.PASS, DriverAction.takeSnapShot());

            }
            else {
                GemTestReporter.addTestStep("Validate Data is Filtered Properly", "Data is not Filtered successfully", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverManager.getWebDriver().navigate().refresh();
            DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(7))));



        }
        catch (Exception e) {
//            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }
    @Then("validate Rejected Case Tab Columns")
    public void tabColumns()
    {
        DriverManager.getWebDriver().navigate().refresh();
        DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(7))));

        List<String> list1 = new ArrayList<>();
        list1.add("Product Name");
        list1.add("Application No.");
        list1.add("Loan No.");
        list1.add("PAN No.");
        list1.add("Mobile No.");
        list1.add("Policy No.");
        list1.add("Premium");
        list1.add("Customer Name");

        int c = 0;
        for (int i = 0; i < list1.size(); i++) {
            String Columns = DriverAction.getElement(By.xpath(Read_Locators.Enquiry_Tab_Col.replace("itr", String.valueOf(i + 1)))).getText();
            if (Columns.equals(list1.get(i))) {
                c++;
            }
        }
        if (c == list1.size()) {
            GemTestReporter.addTestStep("Validating weather all the required columns are present in Rejected Table", "All Columns are there in Rejected Table", STATUS.PASS, DriverAction.takeSnapShot());

        } else {
            GemTestReporter.addTestStep("Validating weather all the required columns are present in Rejected Table", "All Columns are not there in Rejected Table", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }
    @Then("check whether Click Here,Discard,Upload button are present or not")
    public void checkWhetherClickHereDiscardUploadButtonArePresentOrNot() {

            if (DriverAction.getElement(GopsUser_Locators.selectValue(" Click here")).isDisplayed())
                GemTestReporter.addTestStep("Check whether 'Click Here' button is present or not", "Found successfully", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Check whether 'Click Here' button is present or not", "Not Found ", STATUS.FAIL, DriverAction.takeSnapShot());

            if (DriverAction.getElement(GopsUser_Locators.selectValue("Upload")).isDisplayed())
                GemTestReporter.addTestStep("Check whether 'Upload' button is present or not", "Found successfully", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Check whether 'Upload' button is present or not", "Not Found", STATUS.FAIL, DriverAction.takeSnapShot());
            if (DriverAction.getElement(GopsUser_Locators.selectValue("Discard")).isDisplayed())
                GemTestReporter.addTestStep("Check whether 'Discard' button is present or not", "Found successfully", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Check whether 'Discard' button is present or not", "Not Found", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        @Then("^select (.+) from dropdown and then upload the (.+) file$")
    public void checkFiles(String value,String fileName) {
            DriverAction.getElement(writeUserLocator.typeDropdown).click();
            GemTestReporter.addTestStep("Click on the dropdown", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.getElement(GopsUser_Locators.dropdownMenu(value)).click();
            GemTestReporter.addTestStep("Select the "+value+" option from dropdown", "Selected successfully", STATUS.PASS, DriverAction.takeSnapShot());
            WebElement ele = DriverManager.getWebDriver().findElement(GopsUser_Locators.chooseFile);
            ele.sendKeys("C:/Users/tr.sahni/Downloads/"+fileName+".xlsx");
            GemTestReporter.addTestStep("Select a file from the file manager to upload", "Selected successfully", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.getElement(GopsUser_Locators.selectValue("Upload")).click();
            GemTestReporter.addTestStep("Click on the upload button", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(GopsUser_Locators.selectValue("Data Uploaded")));
            if (DriverAction.getElement(GopsUser_Locators.selectValue("Data Uploaded")).isDisplayed())
                GemTestReporter.addTestStep("Check whether Data got uploaded successfully or not", "Data got uploaded successfully and Upload message got displayed", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Check whether Data got uploaded successfully or not", "data was not uploaded successfully", STATUS.FAIL, DriverAction.takeSnapShot());
            DriverAction.getElement(By.xpath("//button[@class='close']")).click();
        }
        @Then("validate Rejected Case page ui")
        public void rejected()
        {
            try {
                DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(7))));
                if (DriverAction.getElement(Read_Locators.RejectedLabel).isDisplayed()) {
                    GemTestReporter.addTestStep("Validating weather Rejected Label  is Present on Rejected screen", "Rejected Label is present on Rejected Screen", STATUS.PASS, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Validating weather Rejected Label  is Present on Rejected screen", "Rejected Label is not present on Rejected Screen", STATUS.FAIL, DriverAction.takeSnapShot());

                }
                if (DriverAction.getElement(Read_Locators.FilterByLable).isDisplayed()) {
                    GemTestReporter.addTestStep("Validating weather FilterBy Label  is Present on Rejected screen", "FilterBy Label is present on Rejected Screen", STATUS.PASS, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Validating weather FilterBy Label  is Present on Rejected screen", "FilterBy Label is not present on Rejected Screen", STATUS.FAIL, DriverAction.takeSnapShot());

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

            }
            catch (Exception e) {
//                logger.info("An exception occurred!", e);
                GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
            }
        }
        @Then("^check whether record got added corresponding to the uploaded file (.+) in Bulk Upload Report or not$")
    public void checkReport(String filename)
        {
 DriverAction.getElement(writeUserLocator.bulkUploadReport).click();
 GemTestReporter.addTestStep("Navigate to the Bulk Upload Report screen","Navigated successfully",STATUS.PASS,DriverAction.takeSnapShot());
            DriverAction.getElement(writeUserLocator.searchBox).clear();
DriverAction.getElement(writeUserLocator.searchBox).sendKeys(filename+ Keys.ENTER);
DriverAction.waitSec(5);
if(DriverAction.getElement(By.xpath("//table/tbody/tr[1]"))!=null)
    GemTestReporter.addTestStep("Check whether record is added or not for file "+filename,"Record added successfully",STATUS.PASS,DriverAction.takeSnapShot());
else
    GemTestReporter.addTestStep("Check whether record is added or not for file "+filename,"Record was not added ",STATUS.FAIL,DriverAction.takeSnapShot());

        }



}




