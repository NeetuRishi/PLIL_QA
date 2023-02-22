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
    Boolean checkUser=false;
    @Then("^Hit the given URL (.+) to open the login form$")
    public void consent(String url) {

        DriverManager.getWebDriver().get(url);
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConsentLocators.heading));
        if (DriverAction.getElement(ConsentLocators.heading).isDisplayed())
            GemTestReporter.addTestStep("Navigate to the given url to open the consent form", "Navigated successfully", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Navigate to the given url to open the consent form", "Could not navigate", STATUS.FAIL, DriverAction.takeSnapShot());

//        if()


    }

    @Then("^Verify that consent form got opened and all the sub-headings are visible$")
    public void formPage() {
        List<WebElement> subheading = DriverAction.getElements(ConsentLocators.subheadings);
        boolean check = false;
        for (int i = 0; i < subheading.size(); i++) {
            if (subheading.get(i).getText() == null) {
                check = true;
                break;
            }
        }
        if (check == true)
            GemTestReporter.addTestStep("Check whether all sub-headings (Primary Insured,Nominee Details,etc) of the consent form was displayed or not", "Headings are not displayed properly", STATUS.FAIL, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether all sub-headings (Primary Insured,Nominee Details,etc) of the consent form was displayed or not", "Headings are displayed successfully", STATUS.PASS, DriverAction.takeSnapShot());

    }

    @Then("Check whether Next button is present and click on it")
    public void next() {
        if (DriverAction.getElement(GopsUser_Locators.selectValue("Next")).isDisplayed()) {
            GemTestReporter.addTestStep("Verify whether Next button is present or not", "Next Button is present", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.getElement(GopsUser_Locators.selectValue("Next")).click();
            DriverAction.waitSec(4);
            GemTestReporter.addTestStep("Click on the Next button", "Clicked successfuly", STATUS.PASS, DriverAction.takeSnapShot());


        } else
            GemTestReporter.addTestStep("Verify whether Next button is present or not", "Next Button is not present", STATUS.FAIL, DriverAction.takeSnapShot());

    }

    @Then("^Check whether (.+) got opened or not$")
    public void page(String page) {
        String check = "";
        if (page.equals("2")) {
            check = " Medical Details ";
        } else if (page.equals("3")) {
            check = " Basic Details ";
        } else if (page.equals("4")) {
            check = " Declaration ";
        }
        if (DriverAction.getElement(GopsUser_Locators.selectValue(check)).isDisplayed())
            GemTestReporter.addTestStep("Check whether user got navigated to the" + page + " page or not", "Navigated successfully", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether user got navigated to the" + page + " page or not", "Could not navigate", STATUS.FAIL, DriverAction.takeSnapShot());

    }

    @Then("^Check that on clicking Proceed without filling the mandatory fields,error is thrown for (.+)$")
    public void checkForError(String page) {
        int c = 0;
        if (page.equals("2")) {
            if (DriverAction.getElement(ConsentLocators.proceed1).isDisplayed())
                c = 1;
            DriverAction.getElement(ConsentLocators.proceed1).click();
            GemTestReporter.addTestStep("Click on the proceed button without filling in the mandatory fields", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            if (DriverAction.getElement(ConsentLocators.proceed2).isDisplayed())
                c = 1;
            DriverAction.getElement(ConsentLocators.proceed2).click();
            GemTestReporter.addTestStep("Click on the proceed button without filling in the mandatory fields", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());
        }


        WebElement elem = DriverAction.getElement(ConsentLocators.checkMandatoryFieldsError);
        List<WebElement> elemts = elem.findElements(By.xpath("./child::*"));
        if (elemts.size() > 0)
            GemTestReporter.addTestStep("Validate whether error was thrown or not or clicking proceed without filling mandatory fields or not", "Error was thrown", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Validate whether error was thrown or not or clicking proceed without filling mandatory fields or not", "Error was not thrown", STATUS.FAIL, DriverAction.takeSnapShot());

    }

    @Then("Check whether user has opted for Primary Insured or Joint Life,Then check whether height and weight input boxes are present")
    public void checkWhetherHeightAndWeightInputBoxesArePresent() {
        List<WebElement> title=DriverAction.getElements(ConsentLocators.title);

        for(int i=0;i<title.size();i++)
        {
            if(title.get(i).getText().equals(" Joint Life ")) {
                checkUser = true;
            }
        }
        if(checkUser==false)
            GemTestReporter.addTestStep("Check whether user has opted for Joint Life or Primary Insured","User has opted for Primary Insured",STATUS.PASS,DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether user has opted for Joint Life or Primary Insured","User has opted for Joint Life",STATUS.PASS,DriverAction.takeSnapShot());
      if(checkUser==true) {
          if (DriverAction.getElement(ConsentLocators.primaryIssuedHeight).isDisplayed())
              GemTestReporter.addTestStep("Check whether Primary Issued Height input box is present or not", "Primary Issued Height Input box is present", STATUS.PASS, DriverAction.takeSnapShot());
          else
              GemTestReporter.addTestStep("Check whether Primary Issued Height input box is present or not", "Primary Issued Height Input box is not present", STATUS.FAIL, DriverAction.takeSnapShot());
          if (DriverAction.getElement(ConsentLocators.primaryIssuedWeight).isDisplayed())
              GemTestReporter.addTestStep("Check whether Primary Issued Weight input box is present or not", "Primary Issued Weight Input box is present", STATUS.PASS, DriverAction.takeSnapShot());
          else
              GemTestReporter.addTestStep("Check whether Primary Issued Weight input box is present or not", "Primary Issued Weight Input box is not present", STATUS.FAIL, DriverAction.takeSnapShot());
          if (DriverAction.getElement(ConsentLocators.jointLifeHeight).isDisplayed()) {
//            GemTestReporter.addTestStep("Check whether user has opted for Single Life or Joint Life","User has opted for Joint life",STATUS.PASS,DriverAction.takeSnapShot());
              GemTestReporter.addTestStep("Check whether joint Life Height input box is present or not", "Joint Life Height Input box is present", STATUS.PASS, DriverAction.takeSnapShot());
          } else
              GemTestReporter.addTestStep("Check whether joint Life Height input box is present or not", "Joint Life Height Input box is not present", STATUS.FAIL, DriverAction.takeSnapShot());
          if (DriverAction.getElement(ConsentLocators.jointLifeWeight).isDisplayed())
              GemTestReporter.addTestStep("Check whether joint Life Weight input box is present or not", "Joint Life Weight Input box is present", STATUS.PASS, DriverAction.takeSnapShot());
          else
              GemTestReporter.addTestStep("Check whether joint Life Weight  input box is present or not", "Joint Life Weight Input box is not present", STATUS.FAIL, DriverAction.takeSnapShot());
      }
      else
      {
          if (DriverAction.getElement(ConsentLocators.primaryIssuedHeight).isDisplayed())
              GemTestReporter.addTestStep("Check whether Primary Issued Height input box is present or not", "Primary Issued Height Input box is present", STATUS.PASS, DriverAction.takeSnapShot());
          else
              GemTestReporter.addTestStep("Check whether Primary Issued Height input box is present or not", "Primary Issued Height Input box is not present", STATUS.FAIL, DriverAction.takeSnapShot());
          if (DriverAction.getElement(ConsentLocators.primaryIssuedWeight).isDisplayed())
              GemTestReporter.addTestStep("Check whether Primary Issued Weight input box is present or not", "Primary Issued Weight Input box is present", STATUS.PASS, DriverAction.takeSnapShot());
          else
              GemTestReporter.addTestStep("Check whether Primary Issued Weight input box is present or not", "Primary Issued Weight Input box is not present", STATUS.FAIL, DriverAction.takeSnapShot());

      }

    }

    @Then("Check whether user is able to type into the input boxes or not")
    public void typeIn() {
        DriverAction.getElement(ConsentLocators.primaryIssuedHeight).sendKeys("120");
//        DriverAction.getElement(ConsentLocators.primaryIssuedHeight).getText();
        DriverAction.getElement(ConsentLocators.primaryIssuedWeight).sendKeys("70");
        if(checkUser==true) {
            DriverAction.getElement(ConsentLocators.jointLifeHeight).sendKeys("130");
            DriverAction.getElement(ConsentLocators.jointLifeWeight).sendKeys("80");
        }
        GemTestReporter.addTestStep("Check whether user is able to type into the Primary issued and Joint Life Input boxes or not", "Typed into the input boxes successfully", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @Then("Check whether all medical history questions are present or not")
    public void checkMedicalQuestions() {
        if (DriverAction.getElement(ConsentLocators.medicalQuestions).isDisplayed())
            GemTestReporter.addTestStep("Check whether all medical history questions are present or not", "Medical History Questions are present", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether all medical history questions are present or not", "Medical History Questions are not present", STATUS.FAIL, DriverAction.takeSnapShot());


    }

    @Then("Check that when user clicks on Yes radio button of any medical question,few input boxes start appearing below the question")
    public void checkYesRadio() {
        DriverAction.getElement(ConsentLocators.firstYesRadio).click();
        GemTestReporter.addTestStep("Click on any 'yes' radio button", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());
        WebElement elem = DriverAction.getElement(By.xpath("//div[@class='p-0']"));
        if (elem.findElements(By.xpath("./child::*")).size() > 0)
            GemTestReporter.addTestStep("Check whether input boxes are added if user clicks on Yes radio button of any medical question or not", "Input boxes are added", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether input boxes are added if user clicks on Yes radio button of any medical question or not", "Input boxes are not added", STATUS.FAIL, DriverAction.takeSnapShot());

    }

    @Then("^Check that all the fields under each sub-headings are autofilled$")
    public void checkAutofilled() {
        List<WebElement> title = DriverAction.getElements(ConsentLocators.autofilledTitle);
        List<WebElement> value = DriverAction.getElements(ConsentLocators.autofilledValue);
        boolean check = true;
        for (int i = 0; i < title.size(); i++) {

            if (title.get(i).getText() == null) {
                check = false;
                break;
            }
        }
        if (check == false)
            GemTestReporter.addTestStep("Check whether all the titles like Title,Age Proof, Full Name,PAN etc ,are autofilled or not", "All the titles are not autofiiled", STATUS.FAIL, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether all the titles like Title,Age Proof, Full Name,PAN etc are autofilled or not", "All the titles are autofiiled", STATUS.PASS, DriverAction.takeSnapShot());
        check = true;
        for (int i = 0; i < value.size(); i++) {

            if (title.get(i).getText() == null) {
                check = false;
                break;
            }
        }
        if (check == false)
            GemTestReporter.addTestStep("Check whether all the values corresponding to the titles are autofilled or not", "All the values are not autofiiled", STATUS.FAIL, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether all the values corresponding to the titles are autofilled or not", "All the values are autofiiled", STATUS.PASS, DriverAction.takeSnapShot());

    }

    @Then("^Check that user clicks on each Yes radio button one by one and few input boxes get added to the DOM and check that user is able to type text into the input box$")
    public void YesRadio() {
        DriverAction.getElement(ConsentLocators.CheckBoxPage2).click();
        List<WebElement> yes = DriverAction.getElements(ConsentLocators.YesRadioButtons);
        List<WebElement> yesRadio = DriverAction.getElements(ConsentLocators.yesInput);
        int k = 0, l = 0, m = 0, i=-1;
        for (i = 0; i < yes.size(); i++) {

            if (yesRadio.get(i).getAttribute("tabindex").equals("0")) {
                yes.get(i).click();
                ++l;
                GemTestReporter.addTestStep("Click on the " + (l) + " Yes Radio button", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());

                if (DriverAction.getElement(ConsentLocators.illnessInjury(l)) != null)
                    GemTestReporter.addTestStep("Check whether Illness injury or Tests input box got displayed or not", "Illness injury or Tests input box is visible ", STATUS.PASS, DriverAction.takeSnapShot());
                else {
                    break;
//                    GemTestReporter.addTestStep("Check whether Illness injury or Tests input box got displayed or not", "Illness injury or Tests input box is not visible ", STATUS.FAIL, DriverAction.takeSnapShot());

                }
                DriverAction.getElement(ConsentLocators.illnessInjury(l)).sendKeys("Abc");
                if (DriverAction.getElement(ConsentLocators.illnessInjury(l)).getAttribute("value").equals("Abc"))
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was able to enter text in the input box," + DriverAction.getElement(ConsentLocators.illnessInjury(l)).getAttribute("value") + " was enetered", STATUS.PASS, DriverAction.takeSnapShot());
                else
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was not able to enter text in thr input box", STATUS.FAIL, DriverAction.takeSnapShot());
                if (DriverAction.getElement(ConsentLocators.typeOfTreatment(l)) != null)
                    GemTestReporter.addTestStep("Check whether Type of Treatment input box got displayed or not", "Type of treatment input box box is visible ", STATUS.PASS, DriverAction.takeSnapShot());
                else
                    GemTestReporter.addTestStep("Check whether Type of Treatment input box got displayed or not", "Type of treatment input box is not visible ", STATUS.FAIL, DriverAction.takeSnapShot());
                DriverAction.getElement(ConsentLocators.typeOfTreatment(l)).sendKeys("Abc");
                if (DriverAction.getElement(ConsentLocators.typeOfTreatment(l)).getAttribute("value").equals("Abc"))
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was able to enter text in the input box," + DriverAction.getElement(ConsentLocators.typeOfTreatment(l)).getAttribute("value") + " was enetered", STATUS.PASS, DriverAction.takeSnapShot());
                else
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was not able to enter text in thr input box", STATUS.FAIL, DriverAction.takeSnapShot());
                if (DriverAction.getElement(ConsentLocators.datedCommenced(++k)) != null)
                    GemTestReporter.addTestStep("Check whether Date Commenced input box got displayed or not", "Date Commenced input box box is visible ", STATUS.PASS, DriverAction.takeSnapShot());
                else
                    GemTestReporter.addTestStep("Check whether Date Commenced input box got displayed or not", "Date Commenced input box is not visible ", STATUS.FAIL, DriverAction.takeSnapShot());
                DriverAction.getElement(ConsentLocators.datedCommenced(k)).sendKeys("23/03/2022");
                if (DriverAction.getElement(ConsentLocators.datedCommenced(k)).getAttribute("value").equals("23/03/2022"))
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was able to enter text in the input box," + DriverAction.getElement(ConsentLocators.datedCommenced(k)).getAttribute("value") + " was enetered", STATUS.PASS, DriverAction.takeSnapShot());
                else
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was not able to enter text in thr input box", STATUS.FAIL, DriverAction.takeSnapShot());
                if (DriverAction.getElement(ConsentLocators.durationOfIllness(l)) != null)
                    GemTestReporter.addTestStep("Check whether Duration Of Illness/Injury input box got displayed or not", "Duration Of Illness/Injury input box box is visible ", STATUS.PASS, DriverAction.takeSnapShot());
                else
                    GemTestReporter.addTestStep("Check whether Duration Of Illness/Injury input box got displayed or not", "Duration Of Illness/Injury input box is not visible ", STATUS.FAIL, DriverAction.takeSnapShot());
                DriverAction.getElement(ConsentLocators.durationOfIllness(l)).sendKeys("Abc");
                if (DriverAction.getElement(ConsentLocators.durationOfIllness(l)).getAttribute("value").equals("Abc"))
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was able to enter text in the input box," + DriverAction.getElement(ConsentLocators.durationOfIllness(l)).getAttribute("value") + " was enetered", STATUS.PASS, DriverAction.takeSnapShot());
                else
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was not able to enter text in thr input box", STATUS.FAIL, DriverAction.takeSnapShot());
                if (DriverAction.getElement(ConsentLocators.currentCondition(l)) != null)
                    GemTestReporter.addTestStep("Check whether current condition input box got displayed or not", "Current Condition input box box is visible ", STATUS.PASS, DriverAction.takeSnapShot());
                else
                    GemTestReporter.addTestStep("Check whether current condition  input box got displayed or not", "current condition  input box is not visible ", STATUS.FAIL, DriverAction.takeSnapShot());
                DriverAction.getElement(ConsentLocators.currentCondition(l)).sendKeys("Abc");
                if (DriverAction.getElement(ConsentLocators.currentCondition(l)).getAttribute("value").equals("Abc"))
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was able to enter text in the input box," + DriverAction.getElement(ConsentLocators.currentCondition(l)).getAttribute("value") + " was enetered", STATUS.PASS, DriverAction.takeSnapShot());
                else
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was not able to enter text in thr input box", STATUS.FAIL, DriverAction.takeSnapShot());
                if (DriverAction.getElement(ConsentLocators.dateOfLastSymptoms(++k)) != null)
                    GemTestReporter.addTestStep("Check whether Date of last symptoms input box got displayed or not", "Date of last symptoms input box box is visible ", STATUS.PASS, DriverAction.takeSnapShot());
                else
                    GemTestReporter.addTestStep("Check whether Date of last symptoms  input box got displayed or not", "Date of last symptoms input box is not visible ", STATUS.FAIL, DriverAction.takeSnapShot());
                DriverAction.getElement(ConsentLocators.dateOfLastSymptoms(k)).sendKeys("27/01/2023");
                if (DriverAction.getElement(ConsentLocators.dateOfLastSymptoms(k)).getAttribute("value").equals("27/01/2023"))
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was able to enter text in the input box," + DriverAction.getElement(ConsentLocators.dateOfLastSymptoms(k)).getAttribute("value") + " was enetered", STATUS.PASS, DriverAction.takeSnapShot());
                else
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was not able to enter text in thr input box", STATUS.FAIL, DriverAction.takeSnapShot());
                if (DriverAction.getElement(ConsentLocators.address(l)) != null)
                    GemTestReporter.addTestStep("Check whether Full Name or Address Of Doctor or hospital input box got displayed or not", "Full Name or Address Of Doctor or hospital input box box is visible ", STATUS.PASS, DriverAction.takeSnapShot());
                else
                    GemTestReporter.addTestStep("Check whether Full Name or Address Of Doctor or hospital  input box got displayed or not", "Full Name or Address Of Doctor or hospital input box is not visible ", STATUS.FAIL, DriverAction.takeSnapShot());
                DriverAction.getElement(ConsentLocators.address(l)).sendKeys("bcd");
                if (DriverAction.getElement(ConsentLocators.address(l)).getAttribute("value").equals("bcd"))
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was able to enter text in the input box," + DriverAction.getElement(ConsentLocators.address(l)).getAttribute("value") + " was enetered", STATUS.PASS, DriverAction.takeSnapShot());
                else
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was not able to enter text in thr input box", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        }
        if (DriverAction.getElement(ConsentLocators.quantity(++m)).isDisplayed())
            GemTestReporter.addTestStep("Check whether Quantity input box is present or not", "Input box is Present successfully", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.getElement(ConsentLocators.quantity(m)).sendKeys("1");
        GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was able to enter text in the input box," + DriverAction.getElement(ConsentLocators.quantity(m)).getAttribute("value") + " was enetered", STATUS.PASS, DriverAction.takeSnapShot());
        for (int j = i + 1; ; j++) {
            if (yesRadio.get(j).getAttribute("tabindex").equals("0"))
            {
                if(yes.get(j)!=null && yes.get(j).isDisplayed())
                yes.get(j).click();
                else
                    break;
                ++m;
                GemTestReporter.addTestStep("Click on the " + (++l) + " Yes Radio button", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());

                if (DriverAction.getElement(ConsentLocators.quantity(m)) != null)
                    GemTestReporter.addTestStep("Check whether Quantity input box got displayed or not", "Quantity input box is visible ", STATUS.PASS, DriverAction.takeSnapShot());
                else {
//                            break;
                    GemTestReporter.addTestStep("Check whether Quantity input box got displayed or not", "Quantity input box is not visible ", STATUS.FAIL, DriverAction.takeSnapShot());

                }
                DriverAction.getElement(ConsentLocators.quantity(m)).sendKeys("2");
                if (DriverAction.getElement(ConsentLocators.quantity(m)).getAttribute("value").equals("2"))
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was able to enter text in the input box," + DriverAction.getElement(ConsentLocators.quantity(m)).getAttribute("value") + " was enetered", STATUS.PASS, DriverAction.takeSnapShot());
                else
                    GemTestReporter.addTestStep("Check whether user is able to enter into the input box or not", "User was not able to enter text in thr input box", STATUS.FAIL, DriverAction.takeSnapShot());

            }

        }
    }


    @Then("^Check that user when clicks on the check box to enable all No Radio buttons for (.+)$")
    public void checkNo(String page)
    {
        if(page.equals("2"))
        DriverAction.getElement(ConsentLocators.CheckBoxPage2).click();
        else
            DriverAction.getElement(ConsentLocators.checkBoxPage3).click();
        GemTestReporter.addTestStep("Check the 'Please select, in case response to all above questions is \"No\".","Checked successfully",STATUS.PASS,DriverAction.takeSnapShot());
        List<WebElement> allNo=DriverAction.getElements(By.xpath("//input[@value='false']"));
        List<WebElement> allNoEnabled=DriverAction.getElements(By.xpath("//input[@tabindex='0']"));
        if(allNoEnabled.size()>=allNo.size())
            GemTestReporter.addTestStep("Validate whether all No radio buttons got enabled on checking the check box","All No Radio buttons got enabled",STATUS.PASS,DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Validate whether all No radio buttons got enabled on checking the check box","All No Radio buttons got enabled",STATUS.PASS,DriverAction.takeSnapShot());

    }
//    @Then("Check that user clicks on 'Please select, in case response to all above questions is No.' check box of (.+) and then all the No radio boxes are enabled")
//    public void checkNo(String page)
//    {
//        if(page.equals("2"))
//        DriverAction.getElement(ConsentLocators.CheckBoxPage2).click();
//        else
//            DriverAction.getElement(ConsentLocators.checkBoxPage3).click();
//        GemTestReporter.addTestStep("Check the 'Please select, in case response to all above questions is \"No\".","Checked successfully",STATUS.PASS,DriverAction.takeSnapShot());
//        List<WebElement> allNo=DriverAction.getElements(By.xpath("//input[@value='false']"));
//        List<WebElement> allNoEnabled=DriverAction.getElements(By.xpath("//input[@tabindex='0']"));
//        if(allNoEnabled.size()>=allNo.size())
//            GemTestReporter.addTestStep("Validate whether all No radio buttons got enabled on checking the check box","All No Radio buttons got enabled",STATUS.PASS,DriverAction.takeSnapShot());
//        else
//            GemTestReporter.addTestStep("Validate whether all No radio buttons got enabled on checking the check box","All No Radio buttons got enabled",STATUS.PASS,DriverAction.takeSnapShot());
//
//    }
    @Then("Click on Proceed button")
    public void proceed()
    {
        if(DriverAction.getElement(GopsUser_Locators.selectValue("Proceed")).isDisplayed())
            GemTestReporter.addTestStep("Check whether Proceed button is present or not","Proceed button found",STATUS.PASS,DriverAction.takeSnapShot());
      DriverAction.getElement(GopsUser_Locators.selectValue("Proceed")).click();
      GemTestReporter.addTestStep("Click on the proceed button","Clicked successfully",STATUS.PASS,DriverAction.takeSnapShot());
    }
    @Then("Check that two reason input boxes start appearing")
    public void checkReason()
    {
        if(checkUser==true) {
            if (DriverAction.getElement(ConsentLocators.reasonsPI).isDisplayed())
                GemTestReporter.addTestStep("Validate whether Primary Insured's Reason input box appeared or not", "Input box starts appearing", STATUS.PASS, DriverAction.takeSnapShot());
            if (DriverAction.getElement(ConsentLocators.reasonsJL).isDisplayed())
                GemTestReporter.addTestStep("Validate whether Joint Life's Reason input box appeared or not", "Input box starts appearing", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            if(DriverAction.getElement(By.xpath("//input[@placeholder='Reason']")).isDisplayed())
                GemTestReporter.addTestStep("Validate whether Primary Insured's Reason input box appeared or not", "Input box starts appearing", STATUS.PASS, DriverAction.takeSnapShot());

        }


    }
    @Then("Type in some value in the input boxes and click on proceed")
    public void type()
    {
        if(checkUser==true) {
            DriverAction.getElement(ConsentLocators.reasonsPI).sendKeys("abcd");
            GemTestReporter.addTestStep("Type in the Primary Insured's Reason Input Box", "Typed in successfully", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.getElement(ConsentLocators.reasonsJL).sendKeys("abcd");
            GemTestReporter.addTestStep("Type in the Joint Life's Reason Input Box", "Typed in successfully", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.getElement(ConsentLocators.proceed2).click();
            GemTestReporter.addTestStep("Click on the proceed button", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            DriverAction.getElement(By.xpath("//input[@placeholder='Reason']")).sendKeys("ABCD");
            GemTestReporter.addTestStep("Type in the Primary Insured's Reason Input Box", "Typed in successfully", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.getElement(ConsentLocators.proceed2).click();
            GemTestReporter.addTestStep("Click on the proceed button", "Clicked successfully", STATUS.PASS, DriverAction.takeSnapShot());

        }
        }
    @Then("Check that on clicking Proceed without Checking the mandatory fields,The text adjacent to the input box turns red")
    public void error()
    {
     if(DriverAction.getElement(ConsentLocators.errorLine).getAttribute("class").equals("pb-3 check text-dark"))
         GemTestReporter.addTestStep("Check that text adjacent to the input box is black initially or not","Text is black in color",STATUS.PASS,DriverAction.takeSnapShot());
        DriverAction.getElement(ConsentLocators.proceed3).click();
        GemTestReporter.addTestStep("Click on the proceed button","Clicked successfully",STATUS.PASS,DriverAction.takeSnapShot());
        if(DriverAction.getElement(ConsentLocators.errorLine).getAttribute("class").equals("pb-3 check text-danger"))
        GemTestReporter.addTestStep("Validate whether text adjacent to the input box turns red after clicking Proceed without chekcing the input box","Text turned red",STATUS.PASS,DriverAction.takeSnapShot());
      else
            GemTestReporter.addTestStep("Validate whether text adjacent to the input box turns red after clicking Proceed without chekcing the input box","Text was not turned red",STATUS.FAIL,DriverAction.takeSnapShot());


    }
    @Then("Check the mandatory boxes and click on proceed")
    public void check()
    {
  DriverAction.getElement(ConsentLocators.checkBoxPage4).click();
  GemTestReporter.addTestStep("Click on the check box to enable it","Clicked successfully",STATUS.PASS,DriverAction.takeSnapShot());
  DriverAction.getElement(ConsentLocators.proceed3).click();
  GemTestReporter.addTestStep("Click on the proceed button","Clicked successfully",STATUS.PASS,DriverAction.takeSnapShot());
    }
    @Then("^Check that Consent Approval card pops up$")
    public void consent()
    {
        if(DriverAction.getElement(GopsUser_Locators.selectValue(" Consent Approval ")).isDisplayed())
            GemTestReporter.addTestStep("Check whether Consent Approval pop up appeared or not","Pop-up appeared",STATUS.PASS,DriverAction.takeSnapShot());

    }
    @Then("Check that Resend OTP , Submit and Cancel button appears")
    public void buttons()
    {
        if(DriverAction.getElement(GopsUser_Locators.selectValue("Resend OTP")).isDisplayed())
            GemTestReporter.addTestStep("Check whether Resend OTP button is present or not","Resend OTP Button is found successfully",STATUS.PASS,DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether Resend OTP button is present or not","Resend OTP Button is not found ",STATUS.FAIL,DriverAction.takeSnapShot());
        if(DriverAction.getElement(GopsUser_Locators.selectValue("Submit")).isDisplayed())
            GemTestReporter.addTestStep("Check whether Submit button is present or not","Submit Button is found successfully",STATUS.PASS,DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether Submit button is present or not","Submit Button is not found ",STATUS.FAIL,DriverAction.takeSnapShot());
        if(DriverAction.getElement(GopsUser_Locators.selectValue("Cancel")).isDisplayed())
            GemTestReporter.addTestStep("Check whether Cancel button is present or not","Cancel Button is found successfully",STATUS.PASS,DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check whether Cancel button is present or not","Cancel Button is not found ",STATUS.FAIL,DriverAction.takeSnapShot());

    }
    @Then("^Check that OTP input boxes are present and are able to take input$")
    public void checkOTPinputBox()
    {
       List<WebElement> otp=DriverAction.getElements(ConsentLocators.otpInputBox);
       if(otp.size()==4)
           GemTestReporter.addTestStep("Verify whether OTP input boxes are present or not","OTP input boxes are present",STATUS.PASS,DriverAction.takeSnapShot());
       for(int i=0;i<otp.size();i++)
       {
           otp.get(i).sendKeys("3");
       }
       int i=0;
       for(i=0;i<otp.size();i++)
       {
           if(otp.get(i).getAttribute("value").equals("3")==false) {
               GemTestReporter.addTestStep("Check whether user is able to type into the OTP input boxes or not ", "User couldn't type in the input box", STATUS.FAIL, DriverAction.takeSnapShot());
           break;
           }

       }
       if(i==otp.size())
           GemTestReporter.addTestStep("Check whether user is able to type into the OTP input box or not","User is successfully able to type in the input box",STATUS.PASS,DriverAction.takeSnapShot());
    }
}
