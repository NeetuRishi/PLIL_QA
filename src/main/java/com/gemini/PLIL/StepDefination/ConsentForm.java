package com.gemini.PLIL.StepDefination;

import com.gemini.PLIL.Locators.ConsentLocators;
import com.gemini.PLIL.Locators.GopsUser_Locators;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ConsentForm {
    @Then("^Hit the given URL (.+) to open the login form$")
    public void consent(String url)
    {

      DriverManager.getWebDriver().get(url);
        WebDriverWait wait=new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConsentLocators.heading));
        if(DriverAction.getElement(ConsentLocators.heading).isDisplayed())
            GemTestReporter.addTestStep("Navigate to the given url to open the consent form","Navigated successfully", STATUS.PASS,DriverAction.takeSnapShot());
else
            GemTestReporter.addTestStep("Navigate to the given url to open the consent form","Could not navigate", STATUS.FAIL,DriverAction.takeSnapShot());

//        if()



    }
    @Then("^Verify that consent form got opened and all the sub-headings are visible$")
    public void formPage()
    {
        List<WebElement> subheading=DriverAction.getElements(ConsentLocators.subheadings);
        boolean check=false;
        for(int i=0;i<subheading.size();i++)
        {
            if(subheading.get(i).getText()==null)
            {
            check=true;
            break;
            }
        }
        if(check==true)
            GemTestReporter.addTestStep("Check whether all sub-headings (Primary Insured,Nominee Details,etc) of the consent form was displayed or not","Headings are not displayed properly",STATUS.FAIL,DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether all sub-headings (Primary Insured,Nominee Details,etc) of the consent form was displayed or not","Headings are displayed successfully",STATUS.PASS,DriverAction.takeSnapShot());

    }
    @Then("Check whether Next button is present and click on it")
    public void next()
    {
       if(DriverAction.getElement(GopsUser_Locators.selectValue("Next")).isDisplayed()) {
           GemTestReporter.addTestStep("Verify whether Next button is present or not", "Next Button is present", STATUS.PASS, DriverAction.takeSnapShot());
       DriverAction.getElement(GopsUser_Locators.selectValue("Next")).click();
       DriverAction.waitSec(4);
       GemTestReporter.addTestStep("Click on the Next button","Clicked successfuly",STATUS.PASS,DriverAction.takeSnapShot());


       }
       else
           GemTestReporter.addTestStep("Verify whether Next button is present or not","Next Button is not present",STATUS.FAIL,DriverAction.takeSnapShot());

    }
    @Then("^Check whether (.+) got opened or not$")
    public void page(String page)
    {
        String check="";
if(page.equals("2"))
{
  check=" Medical Details ";
}
else if(page.equals("3"))
{
    check="";
}
if(DriverAction.getElement(GopsUser_Locators.selectValue(check)).isDisplayed())
    GemTestReporter.addTestStep("Check whether user got navigated to the second page or not","Navigated successfully",STATUS.PASS,DriverAction.takeSnapShot());
else
    GemTestReporter.addTestStep("Check whether user got navigated to the second page or not","Could not navigate",STATUS.FAIL,DriverAction.takeSnapShot());

    }
@Then("^Check that on clicking Proceed without filling the mandatory fields,error is thrown$")
    public void checkForError()
{
    DriverAction.getElement(GopsUser_Locators.selectValue("Proceed")).click();
    GemTestReporter.addTestStep("Click on the proceed button without filling in the mandatory fields","Clicked successfully",STATUS.PASS,DriverAction.takeSnapShot());
    WebElement elem=DriverAction.getElement(ConsentLocators.checkMandatoryFieldsError);
    List<WebElement> elemts=elem.findElements(By.xpath("./child::*"));
    if(elemts.size()>0)
        GemTestReporter.addTestStep("Validate whether error was thrown or not or clicking proceed without filling mandatory fields or not","Error was thrown",STATUS.PASS,DriverAction.takeSnapShot());
    else
        GemTestReporter.addTestStep("Validate whether error was thrown or not or clicking proceed without filling mandatory fields or not","Error was not thrown",STATUS.FAIL,DriverAction.takeSnapShot());

}
}
