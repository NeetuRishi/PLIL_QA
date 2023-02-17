package com.gemini.PLIL.StepDefination;
import com.gemini.PLIL.Locators.GopsUser_Locators;
import com.gemini.PLIL.Locators.writeUserLocator;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.hu.De;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

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




