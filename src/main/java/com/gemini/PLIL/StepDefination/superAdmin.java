package com.gemini.PLIL.StepDefination;

import com.gemini.PLIL.Locators.Locator;
import com.gemini.PLIL.Locators.Read_Locators;
import com.gemini.PLIL.Locators.superAdmin_Locators;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.*;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class superAdmin {
    Logger logger = LoggerFactory.getLogger(StepDefination.class);

    // SUPER ADMIN LOGIN
    @Given("^Login as superAdmin$")
    public void Login_as_superAdmin() {

        DriverAction.typeText(Locator.Email_Input_Field, "deepak.kumar@geminisolutions.com");
        WebElement ele = DriverManager.getWebDriver().findElement(Locator.Password_Input_Field);
        ele.sendKeys("Asdf@1234");
        GemTestReporter.addTestStep("Password", "****", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.click(By.xpath("//button[@type='submit']"));
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//mat-error[text()=' Verification required ']"), "Verification required"));
        DriverAction.click(Locator.Login);
    }



    // PARTNER PRODUCT
    @Then("^Navigate to Partner Product$")
    public void Navigate_to_partner_product()
    {
        DriverAction.getElement(superAdmin_Locators.Partner_Product_Tab).click();
    }
    @Then("^Validate Partner Product Screen$")
    public void validate_partner_product_screen()
        {
        if(DriverAction.getElement(superAdmin_Locators.Partner_Product_Tab_Highlighted).getText().equals("Partner Product"))
        {
            GemTestReporter.addTestStep("Click on Partner Product Tab", "Partner Product Tab is Highlighted", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("CLick on Partner Product Tab","Partner Product Tab is not Highlighted",STATUS.FAIL,DriverAction.takeSnapShot());
        }

        if (DriverAction.getElement(superAdmin_Locators.Label_Partner_Product).isDisplayed())
        {
            GemTestReporter.addTestStep("Verify Partner Product Label", "Partner Product Label is present", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Partner Product Label","Partner Product Label is present",STATUS.FAIL,DriverAction.takeSnapShot());
        }

        if(DriverAction.getElement(superAdmin_Locators.Partner_Name).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Product_Name).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Policy_No).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Plan_No).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Type).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Created_On).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Action).isDisplayed())
        {
            GemTestReporter.addTestStep("Verify Table Columns","Following columns are present in table : Partner Name, Product Name, Policy No., Plan No., Type, Created On, Action",STATUS.PASS,DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Table Columns","Following columns are present in table : Partner Name, Product Name, Policy No., Plan No., Type, Created On, Action",STATUS.FAIL,DriverAction.takeSnapShot());
        }

        if(DriverAction.getElement(superAdmin_Locators.Pagination).isDisplayed())
        {
            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination).getText();
            GemTestReporter.addTestStep("Verify Pagination", "Pagination is present : "+pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Pagination", "Pagination is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Right).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Right).click();
            DriverAction.waitSec(2);
            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination).getText();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Next Page Navigation", "Navigate to Next Page is working : "+pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Next Page Pagination", "Next Page Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Left).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Left).click();
            DriverAction.waitSec(2);
            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination).getText();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Previous Page Navigation", "Navigate to Previous Page is working : "+pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Previous Page Pagination", "Previous Page Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());
        }

        DriverAction.waitSec(2);
        if(DriverAction.getElement(superAdmin_Locators.eye_button).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.eye_button).click();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Eye / View Button", "User is able to see partner product details", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Eye / View Button", "User is not able to see partner product details", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        DriverAction.navigateBack();
        DriverAction.waitSec(4);
        if(DriverAction.getElement(superAdmin_Locators.edit_button).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.edit_button).click();
            DriverAction.waitSec(2);
            DriverAction.getElement(superAdmin_Locators.Select_Medical_Questions).click();
            DriverAction.waitSec(2);
            DriverAction.getElement(superAdmin_Locators.Select_Covid_Questions).click();
            DriverAction.waitSec(4);
            DriverAction.getElement(superAdmin_Locators.update_partner_product_btn).click();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Update Partner", "Partner Product Updated Successfully.", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.waitSec(2);
        }
        else
        {
            GemTestReporter.addTestStep("Verify Update Partner", "Partner Product is not updated.", STATUS.FAIL, DriverAction.takeSnapShot());
            DriverAction.waitSec(2);
        }

        DriverAction.getElement(superAdmin_Locators.edit_button).click();
        if(DriverAction.getElement(superAdmin_Locators.Discard_Button).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Discard_Button).click();
            GemTestReporter.addTestStep("Verify Update Partner Discard Button", "Discard Button is clickable.", STATUS.PASS,DriverAction.takeSnapShot());

        }

        DriverAction.waitSec(5);
        if(DriverAction.getElement(superAdmin_Locators.Create_Partner_Product_Button).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Create_Partner_Product_Button).click();
            DriverAction.waitSec(5);

            if(DriverAction.getElement(superAdmin_Locators.Label_Create_Partner_Product).isDisplayed())
            {
                GemTestReporter.addTestStep("Verify Create Partner Product Label", "Create Partner Product Label is visible.", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Create Partner Product Label", "Create Partner Product Label is not visible.", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if(DriverAction.getElement(superAdmin_Locators.Text_Line_Create_Partner_Product).isDisplayed())
            {
                GemTestReporter.addTestStep("Verify Create Partner Product Text Line", "Create Partner Product Text Line is visible.", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Create Partner Product Text Line", "Create Partner Product Text Line is not visible.", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.waitSec(5);
            if(DriverAction.getElement(superAdmin_Locators.Select_Partner_DropDown).isDisplayed())
            {
                DriverAction.getElement(superAdmin_Locators.Select_Partner_DropDown).click();
                GemTestReporter.addTestStep("Verify Select Partner Dropdown", "Partner DropDown is visible", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.waitSec(2);
                DriverAction.getElement(superAdmin_Locators.Select_Partner_Value).click();
                GemTestReporter.addTestStep("Verify Select Partner Dropdown Options", "User is able to select partner from dropdown", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Select Partner Dropdown", "Partner DropDown is not visible / user is not able to select partner", STATUS.PASS, DriverAction.takeSnapShot());
            }

            DriverAction.waitSec(7);

            if(DriverAction.getElement(superAdmin_Locators.Select_Product_DropDown).isDisplayed())
            {
                DriverAction.getElement(superAdmin_Locators.Select_Product_DropDown).click();
                GemTestReporter.addTestStep("Verify Select Product Dropdown", "Partner Product DropDown is visible", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.waitSec(3);
                DriverAction.getElement(superAdmin_Locators.Select_Product_Value).click();
                GemTestReporter.addTestStep("Verify Select Product Dropdown Options", "User is able to select product from dropdown", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Select Product Dropdown", "Product DropDown is not visible / user is not able to select product", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if(DriverAction.getElement(superAdmin_Locators.Label_Medical_Questions).isDisplayed())
            {
                GemTestReporter.addTestStep("Verify Label Medical Questions", "Label Medical Questions is visible", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Label Medical Questions", "Label Medical Questions is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.waitSec(5);
            if(DriverAction.getElement(superAdmin_Locators.Select_Medical_Questions).isDisplayed())
            {
                DriverAction.getElement(superAdmin_Locators.Select_Medical_Questions).click();
                GemTestReporter.addTestStep("Verify Selection of Medical Questions", "User is able to select Medical Questions", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Selection of Medical Questions", "User is not able to select Medical Questions", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if(DriverAction.getElement(superAdmin_Locators.Label_Covid_Questions).isDisplayed())
            {
                GemTestReporter.addTestStep("Verify Label Covid Questions", "Label Covid Questions is visible", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Label Covid Questions", "Label Covid Questions is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.waitSec(5);
            if(DriverAction.getElement(superAdmin_Locators.Select_Covid_Questions).isDisplayed())
            {
                DriverAction.waitSec(2);
                DriverAction.getElement(superAdmin_Locators.Select_Covid_Questions).click();
                GemTestReporter.addTestStep("Verify Selection of Covid Questions", "User is able to select Covid Questions", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Selection of Covid Questions", "User is not able to select Covid Questions", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if(DriverAction.getElement(superAdmin_Locators.Create_Partner_Product_Btn).isDisplayed())
            {
                String str1 = DriverAction.getCurrentURL();
                DriverAction.getElement(superAdmin_Locators.Create_Partner_Product_Btn).click();
                String str2 = DriverAction.getCurrentURL();
                if(!str1.equals(str2))
                {
                    GemTestReporter.addTestStep("Create Partner Product", "Partner Created Successfully "+"URL before click"+str1+"URL after click"+str2, STATUS.PASS, DriverAction.takeSnapShot());
                }
                else
                {   DriverAction.waitSec(2);
                    String error = DriverAction.getElement(By.xpath("/html/body/div[3]")).getText();
                    GemTestReporter.addTestStep("Error on Create Partner Button",""+error,STATUS.FAIL,DriverAction.takeSnapShot());
                    DriverAction.navigateBack();
                }
                DriverAction.waitSec(10);
            }
            else
            {
                GemTestReporter.addTestStep("Verify Create Partner Product Button is clickable", "Create Button is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.waitSec(2);
        }
        else
        {
            GemTestReporter.addTestStep("Verify Create Partner Product Button", "Create Button is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
        }

        DriverAction.getElement(superAdmin_Locators.Create_Partner_Product_Button).click();
        DriverAction.waitSec(4);
        if(DriverAction.getElement(superAdmin_Locators.Discard_Button).isDisplayed())
        {
            GemTestReporter.addTestStep("Verify Discard Button on Create Partner Product Screen", "Discard Button is visible ", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.getElement(superAdmin_Locators.Discard_Button).click();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Discard Button on Create Partner Product Screen is clickable", "Discard Button is clickable ", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.waitSec(2);
        }
        else
        {
            GemTestReporter.addTestStep("Verify Discard Button on Create Partner Product Screen", "Discard Button is not visible ", STATUS.PASS, DriverAction.takeSnapShot());
        }

        GemTestReporter.addTestStep("Validation", "All Partner Product Test Cases Executed Successfully", STATUS.PASS, DriverAction.takeSnapShot());
    }

    // PARTNER MANAGEMENT
    @Then("^Navigate to Partner Management$")
    public void Navigate_to_partner_management()
    {
        DriverAction.getElement(superAdmin_Locators.Partner_Management_Tab).click();
    }

    @Then("^Validate Partner Management Screen$")
    public void Validate_Partner_Management_Screen() {

        if (DriverAction.getElement(superAdmin_Locators.Label_Partner_Management).isDisplayed()) {
            GemTestReporter.addTestStep("Verify Partner Management Label", "Partner Management Label is visible", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verify Partner Management Label", "Partner Management Label is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
        }

        if (DriverAction.getElement(superAdmin_Locators.Name_Partner_Management).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Prefix_Partner_Management).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Created_On_Partner_Management).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Action_Partner_Management).isDisplayed())
        {
            GemTestReporter.addTestStep("Verify ALl Table Columns", "All these columns should be present : Partner Name, Prefix, Created On, Action", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify ALl Table Columns", "Tables columns are not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }

        if (DriverAction.getElement(superAdmin_Locators.edit_Partner_Management).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.edit_Partner_Management).click();
            if (DriverAction.getElement(superAdmin_Locators.Label_Update_Partner).isDisplayed()) {
                GemTestReporter.addTestStep("Verify Update Partner Label", "Update Partner Label is visible", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify Update Partner Label", "Update Partner Label is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.getElement(superAdmin_Locators.Text_Line_Update_Partner).isDisplayed()) {
                GemTestReporter.addTestStep("Verify Text Line - Enter the partner details for which has to be onboarded", "Text Line - Enter the partner details for which has to be onboarded - is visible", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify Text Line - Enter the partner details for which has to be onboarded", "Text Line is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.getElement(superAdmin_Locators.Update_Partner_Name_Field).isDisplayed()) {
                DriverAction.typeText(superAdmin_Locators.Update_Partner_Name_Field, "Pramerica Life Insurance Test ");
            }
            if (DriverAction.getElement(superAdmin_Locators.Update_Prefix_Uneditable).isDisplayed()) {
                DriverAction.typeText(superAdmin_Locators.Update_Prefix_Uneditable, "PLI");
                GemTestReporter.addTestStep("Verify Prefix is not editable on update", "User is not able to edit", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Prefix not editable on update", "User is able to edit", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.getElement(superAdmin_Locators.Update_Partner_Button).isDisplayed())
            {
                DriverAction.getElement(superAdmin_Locators.Update_Partner_Button).click();
                GemTestReporter.addTestStep("Verify Update Partner Button", "Update Partner Button is clickable", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Update Partner Button", "Update Partner Button is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.getElement(superAdmin_Locators.edit_Partner_Management).click();
            if (DriverAction.getElement(superAdmin_Locators.Discard_Update_Partner_Button).isDisplayed())
            {
                DriverAction.getElement(superAdmin_Locators.Discard_Update_Partner_Button).click();
                GemTestReporter.addTestStep("Verify UpdatePartner Discard Button", "Discard Button is clickable", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify UpdatePartner Discard Button", "Discard Button is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            GemTestReporter.addTestStep("Verify Partner Updated Successfully ", "Partner Updated Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Partner Updated Successfully ", "Partner Not Updated Successfully", STATUS.FAIL, DriverAction.takeSnapShot());

        }
        if(DriverAction.getElement(superAdmin_Locators.Create_Partner_Button_Partner_Management).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Create_Partner_Button_Partner_Management).click();
            if (DriverAction.getElement(superAdmin_Locators.Label_Create_Partner).isDisplayed())
            {
                GemTestReporter.addTestStep("Verify Create Partner Label", "Create Partner Label is visible", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Create Partner Label", "Create Partner Label is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.getElement(superAdmin_Locators.Text_Line_Create_Partner).isDisplayed())
            {
                GemTestReporter.addTestStep("Verify Text Line of Create Partner", "Create Partner Text Line is visible", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Text Line of Create Partner", "Create Partner Text Line is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.getElement(superAdmin_Locators.Enter_Partner_Name).isDisplayed())
            {
                DriverAction.typeText(superAdmin_Locators.Enter_Partner_Name, "Testing Partner Name");
                GemTestReporter.addTestStep("Verify Text Field Partner Name", "User is able to enter partner name", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Text Field Partner Name", "Partner Name Text Field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.getElement(superAdmin_Locators.Enter_Partner_Prefix).isDisplayed())
            {
                DriverAction.typeText(superAdmin_Locators.Enter_Partner_Prefix, "TTP");
                GemTestReporter.addTestStep("Verify Text Field Partner Prefix", "User is able to enter partner prefix", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Text Field Partner Prefix", "Partner Prefix Text Field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if(DriverAction.getElement(superAdmin_Locators.Create_Partner_Btn).isDisplayed())
            {
                DriverAction.getElement(superAdmin_Locators.Create_Partner_Btn).click();
                GemTestReporter.addTestStep("Verify Create Partner Button", "Create Partner Button is Clickable", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Create Partner Button", "Create Partner Button is not Visible / Clickable", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            GemTestReporter.addTestStep("Verify Partner Created Successfully","Partner Created Successfully",STATUS.PASS,DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Partner Created Successfully","Partner is not created successfully",STATUS.FAIL,DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Create_Partner_Button_Partner_Management).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Create_Partner_Button_Partner_Management).click();
            if(DriverAction.getElement(superAdmin_Locators.Discard_Create_Partner_Button).isDisplayed())
            {
                DriverAction.getElement(superAdmin_Locators.Discard_Create_Partner_Button).click();
                GemTestReporter.addTestStep("Verify Discard Partner Creation Successfully","Discard Partner button is clickable",STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Discard Partner Creation Successfully","Discard Partner button is not clickable",STATUS.FAIL,DriverAction.takeSnapShot());
            }
        }
        if(DriverAction.getElement(superAdmin_Locators.Pagination_Partner_Management).isDisplayed())
        {
            String str1 = DriverAction.getElement(superAdmin_Locators.Pagination_Partner_Management).getText();
            GemTestReporter.addTestStep("Verify Pagination of Partner Management", "Pagination is visible : "+str1, STATUS.PASS, DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Right_Partner_Management).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Right_Partner_Management).click();
            DriverAction.waitSec(2);
            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination_Partner_Management).getText();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Next Page Navigation", "Navigate to Next Page is working : "+pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Next Page Pagination", "Next Page Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Left_Partner_Management).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Left_Partner_Management).click();
            DriverAction.waitSec(2);
            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination_Partner_Management).getText();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Previous Page Navigation", "Navigate to Previous Page is working : "+pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Previous Page Pagination", "Previous Page Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());
        }

        }

    // HOME SCREEN - COVER ALL UI ELEMENTS - LOGOUT, HAMBURGER, SIDE NAV BAR, CARDS

    @Then("^Validate Create Button functionality (.+),(.+),(.+),(.+)$")
    public void validateCreateFunctionality(String code,String value,String Card,String username) {
        try {
            if(DriverAction.getElement(superAdmin_Locators.Create_btn).isDisplayed()) {
                GemTestReporter.addTestStep("Validate Create Button is visible on Salutation Screen", "Create button is visible on Salutation Screen", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.getElement(superAdmin_Locators.Create_btn).click();
                DriverAction.typeText(superAdmin_Locators.value_inp,value);
                DriverAction.typeText(superAdmin_Locators.code_inp,code);
                DriverAction.getElement(superAdmin_Locators.Create_btn).click();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                String str = formatter.format(date);
                String nDate = date.toString();
                int c=0;
                for (int i = 1; i <=4; i++) {
                    c++;
                    String Columns = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(i)))).getText();
                    if(Columns.equals(value))
                    {
                        GemTestReporter.addTestStep("Validating value after Creating"+Card, "Required Value -> " +value + " Actual value-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                    }
                    if(Columns.equals(code))
                    {
                        GemTestReporter.addTestStep("Validating code after Creating"+Card, "Required code -> " +code+ " Actual code-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                    }
                    if(Columns.equals(str))
                    {
                        GemTestReporter.addTestStep("Validating Created Date after Creating"+Card, "Required Date -> " +str+ " Actual date-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                    }
                    if(Columns.equals(username))
                    {
                        GemTestReporter.addTestStep("Validating Created by after Creating"+Card, "Required user -> " +username+ " Actual user-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                    }

                }
                if(c!=4)
                {
                    GemTestReporter.addTestStep("Validating weather"+Card+" is created successfully", Card+"is not created successfully", STATUS.FAIL, DriverAction.takeSnapShot());

                }



            }


        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }

    @Then("^Edit the card and validate (.+),(.+)$")
    public void EditandValidate(String UpadtedCode ,String Updatedvalue) {

        try {
            String Code = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(1)))).getText();
            String Value = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(2)))).getText();
            DriverAction.getElement(superAdmin_Locators.edit_icon).click();
            DriverAction.getElement(superAdmin_Locators.value_inp).click();
            Robot rb=new Robot();
            Actions act =new Actions(DriverManager.getWebDriver());
            act.sendKeys(Keys.CONTROL+"a").build().perform();
            act.sendKeys(Keys.BACK_SPACE).build().perform();
            DriverAction.typeText(superAdmin_Locators.value_inp,Updatedvalue);
            act.sendKeys(Keys.TAB).build().perform();
            DriverAction.waitSec(5);
            DriverAction.getElement(superAdmin_Locators.code_inp).click();
            act.sendKeys(Keys.CONTROL+"a").build().perform();
            act.sendKeys(Keys.BACK_SPACE).build().perform();
            DriverAction.typeText(superAdmin_Locators.code_inp,UpadtedCode);
            DriverAction.getElement(superAdmin_Locators.update_button).click();
            DriverAction.waitSec(5);
            String UpdatedCode = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(1)))).getText();
            String UpdatedValue = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(2)))).getText();

            if(!Code.equals(UpdatedCode)&&!Value.equals(UpdatedValue))
            {
                GemTestReporter.addTestStep("Validating Updation of card", "Card is updated successfully", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Validating Updation of card","Card is updated successfully", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        }
        catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }

    }
    @Then("^validate Pagination functionality for Master Management")
    public void validatePagination() {

        if (DriverAction.getElement(superAdmin_Locators.Pagination1).isDisplayed()) {
            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination1).getText();
            GemTestReporter.addTestStep("Verify Pagination", "Pagination is present : " + pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verify Pagination", "Pagination is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Right).isDisplayed()) {
            DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Right).click();
            DriverAction.waitSec(2);
            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination1).getText();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Next Page Navigation", "Navigate to Next Page is working : " + pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verify Next Page Pagination", "Next Page Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Left).isDisplayed()) {
            DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Left).click();
            DriverAction.waitSec(2);
            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination1).getText();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Previous Page Navigation", "Navigate to Previous Page is working : " + pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verify Previous Page Pagination", "Previous Page Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @Then("^Navigate to Master Management Tab and validate logo$")
    public void Navigate_MasterManagement()
    {
        try {
            DriverAction.click(By.xpath(Read_Locators.Side_bar_tab.replace("itr", String.valueOf(3))));
            if (DriverAction.getElement(Locator.Logo).isDisplayed()) {
                GemTestReporter.addTestStep("Validating weather Logo is Visible on Master Management Tab", "Logo is visible on Master Management Tab", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating weather Logo is Visible on Master Management Tab", "Logo is not visible on Master Management Tab", STATUS.FAIL, DriverAction.takeSnapShot());
            }

            String tab = DriverAction.getElement(Read_Locators.MasterManagementtab).getAttribute("class");
            if (tab.contains("active")) {
                GemTestReporter.addTestStep("Validating weather Master Management Tab is highlighted", "Master Management Tab is highlighted", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather Master Management Tab is highlighted", "Master Management Tab is not highlighted", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }

    }

    @Then("^Navigate Cards and validate all functionality (.+)$")
    public void validateCardFunationality(String username) {
        try {
            Map<Integer, List<String>> map = new HashMap<>();
            map.put(1, Arrays.asList("Salutation", "demo", "demo_value", " DFFR", "UpdatedDemo"));
            map.put(2, Arrays.asList("Gender", "N", "Newly", "N1", "Newly1"));
            map.put(3, Arrays.asList("Occupation", "S03", "Latest_Occupation", "S04", "Updated_Occupation"));
            map.put(4, Arrays.asList("Age Proof", "99", "Test_Ageproof", "100", "Updated_Ageproof"));
            map.put(5, Arrays.asList("Marital Status", "MM", "Married123", "MN", "Not_Married"));
            map.put(6, Arrays.asList("Type of Loan", "TTT", "Carrr_Loan", "TTY", "Homme_Loan"));



            for (int i = 1; i <7; i++) {
                if (DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Card.replace("itr", map.get(i).get(0)))).isDisplayed())
                {
                    GemTestReporter.addTestStep("Verify" + map.get(i).get(0) + " Card is present on Master Management screen", map.get(i).get(0) + " card is visible on Master Management screen", STATUS.PASS, DriverAction.takeSnapShot());
                    DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Card.replace("itr", map.get(i).get(0)))).click();
                    if(map.get(i).get(0)=="Type of Loan") {
                        if (DriverAction.getElement(superAdmin_Locators.LoanType).isDisplayed()) {
                            GemTestReporter.addTestStep("Verify  Loan Type Label is present on Type of Loan  screen", "Loan Type Label is present on Type of Loan  screen", STATUS.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep("Verify  Loan Type Label is present on Type of Loan screen", "Loan Type Label is not present on Type of Loan screen", STATUS.FAIL, DriverAction.takeSnapShot());
                        }
                    }
                    else {
                        if (DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Label.replace("itr", map.get(i).get(0)))).isDisplayed()) {
                            GemTestReporter.addTestStep("Verify" + map.get(i).get(0) + "Label is present on "+ map.get(i).get(0) +" screen", map.get(i).get(0) + "Label is present on "+ map.get(i).get(0)+" screen", STATUS.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep("Verify" + map.get(i).get(0) + "Label is present on "+ map.get(i).get(0)+" screen", map.get(i).get(0) + "Label is not present on"+ map.get(i).get(0)+" screen", STATUS.FAIL, DriverAction.takeSnapShot());
                        }
                    }

                } else {
                    GemTestReporter.addTestStep("Verify" + map.get(i).get(0) + "Card is present on Master Management screen", map.get(i).get(0) + " card is not visible on Master Management screen", STATUS.FAIL, DriverAction.takeSnapShot());
                }
                List<String> list1 = new ArrayList<>();
                list1.add("Code");
                list1.add("Value");
                list1.add("Created On");
                list1.add("Created By");
                list1.add("Action");
                int c = 0;
                for (int j = 0; j < list1.size(); j++) {
                    String Columns = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Col.replace("itr", String.valueOf(j + 1)))).getText();
                    if (Columns.equals(list1.get(j))) {
                        c++;
                    }
                }
                if (c == list1.size()) {
                    GemTestReporter.addTestStep("Validating weather all the required columns are present in" + map.get(i).get(0) + "Table", "All Columns are there in" + map.get(i).get(0) + "Table", STATUS.PASS, DriverAction.takeSnapShot());

                } else {
                    GemTestReporter.addTestStep("Validating weather all the required columns are present in" + map.get(i).get(0) + "Table", "All Columns are not there in" + map.get(i).get(0) + "Table", STATUS.FAIL, DriverAction.takeSnapShot());

                }
                //create
                if (String.valueOf(map.get(i).get(0)).equals("Salutation") || String.valueOf(map.get(i).get(0)).equals("Gender") || String.valueOf(map.get(i).get(0)).equals("Occupation")||String.valueOf(map.get(i).get(0)).equals("Type of Loan"))
                {
                    if (DriverAction.getElement(superAdmin_Locators.Create_btn).isDisplayed()) {
                        GemTestReporter.addTestStep("Validate Create Button is visible on Salutation Screen", "Create button is visible on Salutation Screen", STATUS.PASS, DriverAction.takeSnapShot());
                        DriverAction.getElement(superAdmin_Locators.Create_btn).click();
                        DriverAction.typeText(superAdmin_Locators.value_inp, map.get(i).get(2));
                        DriverAction.typeText(superAdmin_Locators.code_inp, map.get(i).get(1));
                        DriverAction.getElement(superAdmin_Locators.Create_btn).click();
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        Date date = new Date();
                        String str = formatter.format(date);
                        String nDate = date.toString();
                        c = 0;
                        for (int j = 1; j <= 4; j++) {
                            c++;
                            String Columns = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(j)))).getText();
                            if (Columns.equals("demo_value")) {
                                GemTestReporter.addTestStep("Validating value after Creating" + map.get(i).get(0), "Required Value -> " + " Actual value-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                            }
                            if (Columns.equals("demo")) {
                                GemTestReporter.addTestStep("Validating code after Creating" + map.get(i).get(0), "Required code -> " + " Actual code-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                            }
                            if (Columns.equals(str)) {
                                GemTestReporter.addTestStep("Validating Created Date after Creating" + map.get(i).get(0), "Required Date -> " + str + " Actual date-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                            }
                            if (Columns.equals(username)) {
                                GemTestReporter.addTestStep("Validating Created by after Creating" + map.get(i).get(0), "Required user -> " + username + " Actual user-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                            }

                        }
                        if (c != 4) {
                            GemTestReporter.addTestStep("Validating weather" + map.get(i).get(0) + " is created successfully", map.get(i).get(0) + "is not created successfully", STATUS.FAIL, DriverAction.takeSnapShot());

                        }

                    }
                   //update
                    String Code = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(1)))).getText();
                    String Value = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(2)))).getText();
                    DriverAction.getElement(superAdmin_Locators.edit_icon).click();
                    DriverAction.getElement(superAdmin_Locators.value_inp).click();
                    Actions act = new Actions(DriverManager.getWebDriver());
                    act.sendKeys(Keys.CONTROL + "a").build().perform();
                    act.sendKeys(Keys.BACK_SPACE).build().perform();
                    DriverAction.typeText(superAdmin_Locators.value_inp, map.get(i).get(4));
                    act.sendKeys(Keys.TAB).build().perform();
                    DriverAction.waitSec(5);
                    DriverAction.getElement(superAdmin_Locators.code_inp).click();
                    act.sendKeys(Keys.CONTROL + "a").build().perform();
                    act.sendKeys(Keys.BACK_SPACE).build().perform();
                    DriverAction.typeText(superAdmin_Locators.code_inp, map.get(i).get(3));
                    DriverAction.getElement(superAdmin_Locators.update_button).click();
                    DriverAction.waitSec(5);
                    String UpdatedCode = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(1)))).getText();
                    String UpdatedValue = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(2)))).getText();

                    if (!Code.equals(UpdatedCode) && !Value.equals(UpdatedValue)) {
                        GemTestReporter.addTestStep("Validating Updation of card", "Card is updated successfully", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Validating Updation of card", "Card is updated successfully", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                }
                else {
                        if (DriverAction.getElement(superAdmin_Locators.Create_btn1).isDisplayed()) {
                            GemTestReporter.addTestStep("Validate Create Button is visible on Salutation Screen", "Create button is visible on Salutation Screen", STATUS.PASS, DriverAction.takeSnapShot());
                            DriverAction.getElement(superAdmin_Locators.Create_btn1).click();
                            DriverAction.typeText(superAdmin_Locators.value_inp, map.get(i).get(2));
                            DriverAction.typeText(superAdmin_Locators.code_inp, map.get(i).get(1));
                            DriverAction.getElement(superAdmin_Locators.Create_btn).click();
                            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                            Date date = new Date();
                            String str = formatter.format(date);
                            String nDate = date.toString();
                            c = 0;
                            for (int j = 1; j <= 4; j++) {
                                c++;
                                String Columns = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(j)))).getText();
                                if (Columns.equals("demo_value")) {
                                    GemTestReporter.addTestStep("Validating value after Creating" + map.get(i).get(0), "Required Value -> " + " Actual value-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                                }
                                if (Columns.equals("demo")) {
                                    GemTestReporter.addTestStep("Validating code after Creating" + map.get(i).get(0), "Required code -> " + " Actual code-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                                }
                                if (Columns.equals(str)) {
                                    GemTestReporter.addTestStep("Validating Created Date after Creating" + map.get(i).get(0), "Required Date -> " + str + " Actual date-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                                }
                                if (Columns.equals(username)) {
                                    GemTestReporter.addTestStep("Validating Created by after Creating" + map.get(i).get(0), "Required user -> " + username + " Actual user-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                                }

                            }
                            if (c != 4) {
                                GemTestReporter.addTestStep("Validating weather" + map.get(i).get(0) + " is created successfully", map.get(i).get(0) + "is not created successfully", STATUS.FAIL, DriverAction.takeSnapShot());

                            }

                        }
                        //update
                    String Code = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(1)))).getText();
                    String Value = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(2)))).getText();
                    DriverAction.getElement(superAdmin_Locators.edit_icon1).click();
                    DriverAction.getElement(superAdmin_Locators.value_inp).click();
                    Actions act = new Actions(DriverManager.getWebDriver());
                    act.sendKeys(Keys.CONTROL + "a").build().perform();
                    act.sendKeys(Keys.BACK_SPACE).build().perform();
                    DriverAction.typeText(superAdmin_Locators.value_inp, map.get(i).get(4));
                    act.sendKeys(Keys.TAB).build().perform();
                    DriverAction.waitSec(5);
                    DriverAction.getElement(superAdmin_Locators.code_inp).click();
                    act.sendKeys(Keys.CONTROL + "a").build().perform();
                    act.sendKeys(Keys.BACK_SPACE).build().perform();
                    DriverAction.typeText(superAdmin_Locators.code_inp, map.get(i).get(3));
                    if(String.valueOf(map.get(i).get(0)).equals("Age Proof")) {
                        DriverAction.getElement(superAdmin_Locators.update_button).click();
                    }
                    else {
                        DriverAction.getElement(superAdmin_Locators.update_button1).click();
                    }
                    DriverAction.waitSec(5);
                    String UpdatedCode = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(1)))).getText();
                    String UpdatedValue = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(2)))).getText();

                    if (!Code.equals(UpdatedCode) && !Value.equals(UpdatedValue)) {
                        GemTestReporter.addTestStep("Validating Updation of card", "Card is updated successfully", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Validating Updation of card", "Card is updated successfully", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                    }


                        //pagination
                        if (DriverAction.getElement(superAdmin_Locators.Pagination1).isDisplayed()) {
                            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination1).getText();
                            GemTestReporter.addTestStep("Verify Pagination", "Pagination is present : " + pag_text, STATUS.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep("Verify Pagination", "Pagination is not present", STATUS.FAIL, DriverAction.takeSnapShot());
                        }
                        if (DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Right).isDisplayed()) {
                            DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Right).click();
                            DriverAction.waitSec(2);
                            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination1).getText();
                            DriverAction.waitSec(2);
                            GemTestReporter.addTestStep("Verify Next Page Navigation", "Navigate to Next Page is working : " + pag_text, STATUS.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep("Verify Next Page Pagination", "Next Page Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());
                        }
                        if (DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Left).isDisplayed()) {
                            DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Left).click();
                            DriverAction.waitSec(2);
                            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination1).getText();
                            DriverAction.waitSec(2);
                            GemTestReporter.addTestStep("Verify Previous Page Navigation", "Navigate to Previous Page is working : " + pag_text, STATUS.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep("Verify Previous Page Pagination", "Previous Page Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());
                        }

                DriverAction.waitSec(10);
                        //delete
                String firstRowBeforeDelete=DriverAction.getElement(superAdmin_Locators.deleteRow).getText();
                        //Marital Status
                        if(String.valueOf(map.get(i).get(0)).equals("Age Proof")||String.valueOf(map.get(i).get(0)).equals("Marital Status"))
                        {
                            DriverAction.getElement(superAdmin_Locators.deleteButton2).click();
                        }
                        else {
                            DriverAction.getElement(superAdmin_Locators.deleteButton).click();
                        }
                DriverAction.waitSec(10);
                        String firstRowAfterDelete=DriverAction.getElement(superAdmin_Locators.deleteRow).getText();
                        if(firstRowAfterDelete.equals(firstRowBeforeDelete))
                            GemTestReporter.addTestStep("Check whether row got deleted or not","Row was not deleted ",STATUS.FAIL,DriverAction.takeSnapShot());
                        else
                            GemTestReporter.addTestStep("Check whether row got deleted or not","Row was deleted successfully",STATUS.PASS,DriverAction.takeSnapShot());

                    DriverAction.getElement(superAdmin_Locators.navigate_Back).click();




            }
        }
        catch(Exception e){
                logger.info("An exception occurred!", e);
                GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
            }

    }

    @Then("^Validate Relationship card and its functionality (.+)$")
    public void ValidateRelationship(String username)
    {
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(1, Arrays.asList("Appointee-Nominee ", "demo", "demo_value", " DFFR", "UpdatedDemo"));
        map.put(2, Arrays.asList("Nominee-Applicant ", "N", "Newly", "N1", "Newly1"));
        map.put(3, Arrays.asList("Appointee-Applicant ", "S03", "Latest_Occupation", "S04", "Updated_Occupation"));
        map.put(4, Arrays.asList("Cover basis ", "99", "Test_Ageproof", "100", "Updated_Ageproof"));
        for(int i=1;i<=4;i++) {
            if (DriverAction.getElement(By.xpath(superAdmin_Locators.Relationship_Card.replace("itr", map.get(i).get(0)))).isDisplayed()) {
                GemTestReporter.addTestStep("Verify" + map.get(i).get(0) + " Card is present on Master Management screen", map.get(i).get(0) + " card is visible on Master Management screen", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.getElement(By.xpath(superAdmin_Locators.Relationship_Card.replace("itr", map.get(i).get(0)))).click();
                if (map.get(i).get(0) == "Appointee-Nominee ") {
                    if (DriverAction.getElement(superAdmin_Locators.Appointee_Nominee_Lable).isDisplayed()) {
                        GemTestReporter.addTestStep("Verify  Appointee Relation with Nominee Label is present on Appointee-Nominee Relationship  screen", "Appointee Relation with Nominee Label is present on Appointee-Nominee Relationship  screen", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Verify  Appointee Relation with Nominee Label is present on Appointee-Nominee Relationship  screen", "Appointee Relation with Nominee Label is not present on Appointee-Nominee Relationship  screen", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } else if (map.get(i).get(0) == "Nominee-Applicant ") {
                    if (DriverAction.getElement(superAdmin_Locators.Nominee_Relation_Lable).isDisplayed()) {
                        GemTestReporter.addTestStep("Verify  Loan Type Label is present on Type of Loan  screen", "Loan Type Label is present on Type of Loan  screen", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Verify  Loan Type Label is present on Type of Loan screen", "Loan Type Label is not present on Type of Loan screen", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } else if (map.get(i).get(0) == "Appointee-Applicant ") {
                    if (DriverAction.getElement(superAdmin_Locators.Appointee_Relation_Lable).isDisplayed()) {
                        GemTestReporter.addTestStep("Verify  Loan Type Label is present on Type of Loan  screen", "Loan Type Label is present on Type of Loan  screen", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Verify  Loan Type Label is present on Type of Loan screen", "Loan Type Label is not present on Type of Loan screen", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } else {
                    if (DriverAction.getElement(superAdmin_Locators.Cover_Basis_Lable).isDisplayed()) {
                        GemTestReporter.addTestStep("Verify  Loan Type Label is present on Type of Loan  screen", "Loan Type Label is present on Type of Loan  screen", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Verify  Loan Type Label is present on Type of Loan screen", "Loan Type Label is not present on Type of Loan screen", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                }

            } else {
                GemTestReporter.addTestStep("Verify" + map.get(i).get(0) + "Card is present on Master Management screen", map.get(i).get(0) + " card is not visible on Master Management screen", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            List<String> list1 = new ArrayList<>();
            list1.add("Code");
            list1.add("Value");
            list1.add("Created On");
            list1.add("Created By");
            list1.add("Action");
            int c = 0;
            for (int j = 0; j < list1.size(); j++) {
                String Columns = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Col.replace("itr", String.valueOf(j + 1)))).getText();
                if (Columns.equals(list1.get(j))) {
                    c++;
                }
            }
            if (c == list1.size()) {
                GemTestReporter.addTestStep("Validating weather all the required columns are present in" + map.get(i).get(0) + "Table", "All Columns are there in" + map.get(i).get(0) + "Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather all the required columns are present in" + map.get(i).get(0) + "Table", "All Columns are not there in" + map.get(i).get(0) + "Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }
            //create
            if(map.get(i).get(0) == "Appointee-Nominee ")
            {
            if (DriverAction.getElement(superAdmin_Locators.Create_btn1).isDisplayed()) {
                GemTestReporter.addTestStep("Validate Create Button is visible on Salutation Screen", "Create button is visible on Salutation Screen", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.getElement(superAdmin_Locators.Create_btn1).click();
                DriverAction.typeText(superAdmin_Locators.value_inp, map.get(i).get(2));
                DriverAction.typeText(superAdmin_Locators.code_inp, map.get(i).get(1));
                DriverAction.getElement(superAdmin_Locators.Create_btn).click();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                String str = formatter.format(date);
                String nDate = date.toString();
                c = 0;
                for (int j = 1; j <= 4; j++) {
                    c++;
                    String Columns = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(j)))).getText();
                    if (Columns.equals("demo_value")) {
                        GemTestReporter.addTestStep("Validating value after Creating" + map.get(i).get(0), "Required Value -> " + " Actual value-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                    }
                    if (Columns.equals("demo")) {
                        GemTestReporter.addTestStep("Validating code after Creating" + map.get(i).get(0), "Required code -> " + " Actual code-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                    }
                    if (Columns.equals(str)) {
                        GemTestReporter.addTestStep("Validating Created Date after Creating" + map.get(i).get(0), "Required Date -> " + str + " Actual date-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                    }
                    if (Columns.equals(username)) {
                        GemTestReporter.addTestStep("Validating Created by after Creating" + map.get(i).get(0), "Required user -> " + username + " Actual user-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                    }

                }
                if (c != 4) {
                    GemTestReporter.addTestStep("Validating weather" + map.get(i).get(0) + " is created successfully", map.get(i).get(0) + "is not created successfully", STATUS.FAIL, DriverAction.takeSnapShot());

                }
            }


            }
            else if(map.get(i).get(0) == "Nominee-Applicant ")
            {
                if (DriverAction.getElement(superAdmin_Locators.Create_btn).isDisplayed()) {
                    GemTestReporter.addTestStep("Validate Create Button is visible on Salutation Screen", "Create button is visible on Salutation Screen", STATUS.PASS, DriverAction.takeSnapShot());
                    DriverAction.getElement(superAdmin_Locators.Create_btn).click();
                    DriverAction.typeText(superAdmin_Locators.value_inp, map.get(i).get(2));
                    DriverAction.typeText(superAdmin_Locators.code_inp, map.get(i).get(1));
                    DriverAction.getElement(superAdmin_Locators.Create_btn).click();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = new Date();
                    String str = formatter.format(date);
                    String nDate = date.toString();
                    c = 0;
                    for (int j = 1; j <= 4; j++) {
                        c++;
                        String Columns = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(j)))).getText();
                        if (Columns.equals("demo_value")) {
                            GemTestReporter.addTestStep("Validating value after Creating" + map.get(i).get(0), "Required Value -> " + " Actual value-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                        }
                        if (Columns.equals("demo")) {
                            GemTestReporter.addTestStep("Validating code after Creating" + map.get(i).get(0), "Required code -> " + " Actual code-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                        }
                        if (Columns.equals(str)) {
                            GemTestReporter.addTestStep("Validating Created Date after Creating" + map.get(i).get(0), "Required Date -> " + str + " Actual date-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                        }
                        if (Columns.equals(username)) {
                            GemTestReporter.addTestStep("Validating Created by after Creating" + map.get(i).get(0), "Required user -> " + username + " Actual user-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                        }

                    }
                    if (c != 4) {
                        GemTestReporter.addTestStep("Validating weather" + map.get(i).get(0) + " is created successfully", map.get(i).get(0) + "is not created successfully", STATUS.FAIL, DriverAction.takeSnapShot());

                    }
                }
            }
            else if (map.get(i).get(0) == "Appointee-Applicant ")
            {
                if (DriverAction.getElement(superAdmin_Locators.Create_btn1).isDisplayed()) {
                    GemTestReporter.addTestStep("Validate Create Button is visible on Salutation Screen", "Create button is visible on Salutation Screen", STATUS.PASS, DriverAction.takeSnapShot());
                    DriverAction.getElement(superAdmin_Locators.Create_btn1).click();
                    DriverAction.typeText(superAdmin_Locators.value_inp, map.get(i).get(2));
                    DriverAction.typeText(superAdmin_Locators.code_inp, map.get(i).get(1));
                    DriverAction.getElement(superAdmin_Locators.Create_btn).click();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = new Date();
                    String str = formatter.format(date);
                    String nDate = date.toString();
                    c = 0;
                    for (int j = 1; j <= 4; j++) {
                        c++;
                        String Columns = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(j)))).getText();
                        if (Columns.equals("demo_value")) {
                            GemTestReporter.addTestStep("Validating value after Creating" + map.get(i).get(0), "Required Value -> " + " Actual value-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                        }
                        if (Columns.equals("demo")) {
                            GemTestReporter.addTestStep("Validating code after Creating" + map.get(i).get(0), "Required code -> " + " Actual code-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                        }
                        if (Columns.equals(str)) {
                            GemTestReporter.addTestStep("Validating Created Date after Creating" + map.get(i).get(0), "Required Date -> " + str + " Actual date-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                        }
                        if (Columns.equals(username)) {
                            GemTestReporter.addTestStep("Validating Created by after Creating" + map.get(i).get(0), "Required user -> " + username + " Actual user-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                        }

                    }
                    if (c != 4) {
                        GemTestReporter.addTestStep("Validating weather" + map.get(i).get(0) + " is created successfully", map.get(i).get(0) + "is not created successfully", STATUS.FAIL, DriverAction.takeSnapShot());

                    }
                }
            }
            else
            {
                if (DriverAction.getElement(superAdmin_Locators.Create_btn1).isDisplayed()) {
                    GemTestReporter.addTestStep("Validate Create Button is visible on Salutation Screen", "Create button is visible on Salutation Screen", STATUS.PASS, DriverAction.takeSnapShot());
                    DriverAction.getElement(superAdmin_Locators.Create_btn1).click();
                    DriverAction.typeText(superAdmin_Locators.value_inp, map.get(i).get(2));
                    DriverAction.typeText(superAdmin_Locators.code_inp, map.get(i).get(1));
                    DriverAction.getElement(superAdmin_Locators.Create_btn).click();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = new Date();
                    String str = formatter.format(date);
                    String nDate = date.toString();
                    c = 0;
                    for (int j = 1; j <= 4; j++) {
                        c++;
                        String Columns = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(j)))).getText();
                        if (Columns.equals("demo_value")) {
                            GemTestReporter.addTestStep("Validating value after Creating" + map.get(i).get(0), "Required Value -> " + " Actual value-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                        }
                        if (Columns.equals("demo")) {
                            GemTestReporter.addTestStep("Validating code after Creating" + map.get(i).get(0), "Required code -> " + " Actual code-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                        }
                        if (Columns.equals(str)) {
                            GemTestReporter.addTestStep("Validating Created Date after Creating" + map.get(i).get(0), "Required Date -> " + str + " Actual date-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                        }
                        if (Columns.equals(username)) {
                            GemTestReporter.addTestStep("Validating Created by after Creating" + map.get(i).get(0), "Required user -> " + username + " Actual user-> " + Columns, STATUS.PASS, DriverAction.takeSnapShot());

                        }

                    }
                    if (c != 4) {
                        GemTestReporter.addTestStep("Validating weather" + map.get(i).get(0) + " is created successfully", map.get(i).get(0) + "is not created successfully", STATUS.FAIL, DriverAction.takeSnapShot());

                    }
                }
            }
            //update
            String Code = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(1)))).getText();
            String Value = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(2)))).getText();
            if(map.get(i).get(0) == "Nominee-Applicant ") {
                DriverAction.getElement(superAdmin_Locators.edit_icon).click();
            }
            else {
                DriverAction.getElement(superAdmin_Locators.edit_icon1).click();
            }
            DriverAction.getElement(superAdmin_Locators.value_inp).click();
            Actions act = new Actions(DriverManager.getWebDriver());
            act.sendKeys(Keys.CONTROL + "a").build().perform();
            act.sendKeys(Keys.BACK_SPACE).build().perform();
            DriverAction.typeText(superAdmin_Locators.value_inp, map.get(i).get(4));
            act.sendKeys(Keys.TAB).build().perform();
            DriverAction.waitSec(5);
            DriverAction.getElement(superAdmin_Locators.code_inp).click();
            act.sendKeys(Keys.CONTROL + "a").build().perform();
            act.sendKeys(Keys.BACK_SPACE).build().perform();
            DriverAction.typeText(superAdmin_Locators.code_inp, map.get(i).get(3));
            if(String.valueOf(map.get(i).get(0)).equals("Nominee-Applicant ")) {
                DriverAction.getElement(superAdmin_Locators.update_button).click();
            }
            else if(map.get(i).get(0) == "Cover basis ") {
                DriverAction.getElement(superAdmin_Locators.update_button1).click();
            }
            else {
                DriverAction.getElement(superAdmin_Locators.update_button2).click();
            }
            DriverAction.waitSec(5);
            String UpdatedCode = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(1)))).getText();
            String UpdatedValue = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Column.replace("itr", String.valueOf(2)))).getText();

            if (!Code.equals(UpdatedCode) && !Value.equals(UpdatedValue)) {
                GemTestReporter.addTestStep("Validating Updation of card", "Card is updated successfully", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validating Updation of card", "Card is updated successfully", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.waitSec(10);
            //delete
            String firstRowBeforeDelete=DriverAction.getElement(superAdmin_Locators.deleteRow).getText();
            //Nominee-Applicant
            if(String.valueOf(map.get(i).get(0)).equals("Nominee-Applicant "))
            {
                DriverAction.getElement(superAdmin_Locators.deleteButton).click();
            }
            else {
                DriverAction.getElement(superAdmin_Locators.deleteButton2).click();
            }
            DriverAction.waitSec(10);
            String firstRowAfterDelete=DriverAction.getElement(superAdmin_Locators.deleteRow).getText();
            if(firstRowAfterDelete.equals(firstRowBeforeDelete))
                GemTestReporter.addTestStep("Check whether row got deleted or not","Row was not deleted ",STATUS.FAIL,DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Check whether row got deleted or not","Row was deleted successfully",STATUS.PASS,DriverAction.takeSnapShot());


            DriverAction.getElement(superAdmin_Locators.navigate_Back).click();
        }

    }
    @Then("^Navigate to (.+) and validate the Ui$")
    public void validateSalutationUi(String Card)
    {
        try {
            if(DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Card.replace("itr",Card))).isDisplayed())
            {
                GemTestReporter.addTestStep("Verify"+Card+" Card is present on Master Management screen",Card+" card is visible on Master Management screen",STATUS.PASS,DriverAction.takeSnapShot());
                DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Card.replace("itr",Card))).click();
                if(DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Label.replace("itr",Card))).isDisplayed()) {
                    GemTestReporter.addTestStep("Verify"+Card+"Label is present on Salutation screen",Card+"Label is present on Salutation screen",STATUS.PASS,DriverAction.takeSnapShot());
                }
                else
                {
                    GemTestReporter.addTestStep("Verify"+Card+"Label is present on Salutation screen",Card+"Label is not present on Salutation screen",STATUS.FAIL,DriverAction.takeSnapShot());

                }

            }
            else
            {
                GemTestReporter.addTestStep("Verify"+Card+"Card is present on Master Management screen",Card+" card is not visible on Master Management screen",STATUS.FAIL,DriverAction.takeSnapShot());
            }
            List<String> list1 = new ArrayList<>();
            list1.add("Code");
            list1.add("Value");
            list1.add("Created On");
            list1.add("Created By");
            list1.add("Action");
            int c = 0;
            for (int i = 0; i < list1.size(); i++) {
                String Columns = DriverAction.getElement(By.xpath(superAdmin_Locators.Salutation_Col.replace("itr", String.valueOf(i + 1)))).getText();
                if (Columns.equals(list1.get(i))) {
                    c++;
                }
            }
            if (c == list1.size()) {
                GemTestReporter.addTestStep("Validating weather all the required columns are present in"+Card+"Table", "All Columns are there in"+Card+"Table", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Validating weather all the required columns are present in"+Card+"Table", "All Columns are not there in"+Card+"Table", STATUS.FAIL, DriverAction.takeSnapShot());

            }


        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL);
        }
    }
    @Then("^Navigate to Home$")
    public void navigate_to_home()
    {
        if(DriverAction.getElement(superAdmin_Locators.SideBar_Logo).isDisplayed())
        {
            GemTestReporter.addTestStep("Verify Logo on Screen","Logo is visible on left side bar",STATUS.PASS,DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Logo on Screen","Logo is not visible on left side bar",STATUS.FAIL,DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Home_Tab).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Roles_Tab).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Master_Management_Tab).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Partner_Product_Tab).isDisplayed() && DriverAction.getElement(superAdmin_Locators.User_Management_Tab).isDisplayed() && DriverAction.getElement(superAdmin_Locators.GOPS_Enquiry_Tab).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Reverse_Feed_Tab).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Generate_IG_File_Tab).isDisplayed())
        {
            GemTestReporter.addTestStep("Verify All Tabs on Side Nav Bar"," All these tabs Home, Roles, Master Management, Partner Product, User Management, Partner Management, Gops Enquiry, Reverse Feed, Generate Ig File should visible on left side nav bar",STATUS.PASS,DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify All Tabs on Side Nav Bar"," All Tabs are not visible on left side nav bar",STATUS.FAIL,DriverAction.takeSnapShot());
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
        if(DriverAction.getElement(superAdmin_Locators.Home_Label).isDisplayed())
        {
            GemTestReporter.addTestStep("Verify Home Label is visible"," Home Label is visible",STATUS.PASS,DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Home Label is visible"," Home Label is not visible",STATUS.PASS,DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Name_Label).isDisplayed())
        {
         GemTestReporter.addTestStep("Verify Name Label is visible","Name label is visible",STATUS.PASS,DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Name Label is visible","Name label is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Name_Value).isDisplayed())
        {
            GemTestReporter.addTestStep("Verify Name is visible", "Name is visible", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Name is visible","Name is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Email_Label).isDisplayed())
        {
            GemTestReporter.addTestStep("Verify Email Label is visible","Email label is visible",STATUS.PASS,DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Email Label is visible","Email label is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Email_Value).isDisplayed())
        {
            GemTestReporter.addTestStep("Verify Email ID is visible","Email ID is visible",STATUS.PASS,DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Email ID is visible","Email ID is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Mobile_Label).isDisplayed())
        {
            GemTestReporter.addTestStep("Verify Mobile Label is visible","Mobile label is visible",STATUS.PASS,DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Mobile Label is visible","Mobile label is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
        }
        if( DriverAction.getElement(superAdmin_Locators.Mobile_Value).isDisplayed())
        {
            GemTestReporter.addTestStep("Verify Mobile Number is visible","Mobile Number  is visible",STATUS.PASS,DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Mobile Number is visible","Mobile Number is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }
    @Then("^Validate Home UI Elements$")
    public void validate_home_ui_cards()
    {   DriverAction.getElement(superAdmin_Locators.Hamburger).click();
        //DriverAction.setImplicitTimeOut(2);
        if(DriverAction.getElement(superAdmin_Locators.Home_Tab).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Roles_Tab).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Master_Management_Tab).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Partner_Product_Tab).isDisplayed() && DriverAction.getElement(superAdmin_Locators.User_Management_Tab).isDisplayed() && DriverAction.getElement(superAdmin_Locators.GOPS_Enquiry_Tab).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Reverse_Feed_Tab).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Generate_IG_File_Tab).isDisplayed())
        {

            DriverAction.getElement(superAdmin_Locators.Roles_Tab).click();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Roles Tab is clickable","Roles tab is clickable",STATUS.PASS,DriverAction.takeSnapShot());

            DriverAction.getElement(superAdmin_Locators.Home_Tab).click();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Home Tab is clickable","Home tab is clickable",STATUS.PASS,DriverAction.takeSnapShot());

            DriverAction.getElement(superAdmin_Locators.Master_Management_Tab).click();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Master Management Tab is clickable","Master Management tab is clickable",STATUS.PASS,DriverAction.takeSnapShot());

            DriverAction.getElement(superAdmin_Locators.Partner_Product_Tab).click();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Partner Product Tab is clickable","Partner Product tab is clickable",STATUS.PASS,DriverAction.takeSnapShot());

            DriverAction.getElement(superAdmin_Locators.User_Management_Tab).click();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify User Management Tab is clickable","User Management tab is clickable",STATUS.PASS,DriverAction.takeSnapShot());

            DriverAction.getElement(superAdmin_Locators.GOPS_Enquiry_Tab).click();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify GOPS Enquiry Tab is clickable","Gops Enquiry tab is clickable",STATUS.PASS,DriverAction.takeSnapShot());

            DriverAction.getElement(superAdmin_Locators.Reverse_Feed_Tab).click();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Reverse Feed Tab is clickable","Reverse Feed tab is clickable",STATUS.PASS,DriverAction.takeSnapShot());

            DriverAction.getElement(superAdmin_Locators.Generate_IG_File_Tab).click();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Generate Ig File Tab is clickable","Generate Ig File tab is clickable",STATUS.PASS,DriverAction.takeSnapShot());


            GemTestReporter.addTestStep("Verify Side Tabs are clickable","Side Bar tabs are clickable",STATUS.PASS,DriverAction.takeSnapShot());

            DriverAction.getElement(superAdmin_Locators.Home_Tab).click();
            // NAVIGATE TO CARDS
            if(DriverAction.getElement(superAdmin_Locators.Navigate_to_Label).isDisplayed())
            {
                GemTestReporter.addTestStep("Verify Navigate to Label","Navigate to Label is visible",STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Navigate to Label","Navigate to Label is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
            }
            if(DriverAction.getElement(superAdmin_Locators.Roles_Card).isDisplayed())
            {
                if(DriverAction.getElement(superAdmin_Locators.Roles_Card_Img).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Roles_Card_Angle).isDisplayed())
                {
                    GemTestReporter.addTestStep("Verify Role Card Image & Angle Right Icons","Role Card Image & Angle Right Icons are visible",STATUS.PASS,DriverAction.takeSnapShot());
                }
                else
                {
                    GemTestReporter.addTestStep("Verify Role Card Image & Angle Right Icons","Role Card Image & Angle Right Icons are not visible",STATUS.FAIL,DriverAction.takeSnapShot());
                }
                DriverAction.getElement(superAdmin_Locators.Roles_Card).click();
                GemTestReporter.addTestStep("Verify Role Card is clickable","Role Card is clickable",STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Role Card is clickable","Role Card is not clickable",STATUS.FAIL,DriverAction.takeSnapShot());
            }
            DriverAction.navigateBack();
            if(DriverAction.getElement(superAdmin_Locators.Master_Management_Card).isDisplayed())
            {
                if(DriverAction.getElement(superAdmin_Locators.Master_Management_Card_Img).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Master_Management_Card_Angle).isDisplayed())
                {
                    GemTestReporter.addTestStep("Verify Master Management Card Image & Angle Right Icons","Master Management Card Image & Angle Right Icons are visible",STATUS.PASS,DriverAction.takeSnapShot());
                }
                else
                {
                    GemTestReporter.addTestStep("Verify Master Management Card Image & Angle Right Icons","Master Management Card Image & Angle Right Icons are not visible",STATUS.FAIL,DriverAction.takeSnapShot());
                }
                DriverAction.getElement(superAdmin_Locators.Master_Management_Card).click();
                GemTestReporter.addTestStep("Verify Master Management Card is clickable","Master Management is clickable",STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Master Management Card is clickable","Master Management Card is not clickable",STATUS.FAIL,DriverAction.takeSnapShot());
            }
            DriverAction.navigateBack();
            if(DriverAction.getElement(superAdmin_Locators.Partner_Product_Card).isDisplayed())
            {
                if(DriverAction.getElement(superAdmin_Locators.Partner_Product_Card_Img).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Partner_Product_Card_Angle).isDisplayed())
                {
                    GemTestReporter.addTestStep("Verify Partner Product Card Image & Angle Right Icons","Partner Product Card Image & Angle Right Icons are visible",STATUS.PASS,DriverAction.takeSnapShot());
                }
                else
                {
                    GemTestReporter.addTestStep("Verify Partner Product Card Image & Angle Right Icons","Partner Product Card Image & Angle Right Icons are not visible",STATUS.FAIL,DriverAction.takeSnapShot());
                }
                DriverAction.getElement(superAdmin_Locators.Partner_Product_Card).click();
                GemTestReporter.addTestStep("Verify Partner Product Card is clickable","Partner Product is clickable",STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Partner Product Card is clickable","Partner Product Card is not clickable",STATUS.FAIL,DriverAction.takeSnapShot());
            }
            DriverAction.navigateBack();
            if(DriverAction.getElement(superAdmin_Locators.User_Management_Card).isDisplayed())
            {
                if(DriverAction.getElement(superAdmin_Locators.User_Management_Card_Img).isDisplayed() && DriverAction.getElement(superAdmin_Locators.User_Management_Card_Angle).isDisplayed())
                {
                    GemTestReporter.addTestStep("Verify User Management Card Image & Angle Right Icons","User Management Card Image & Angle Right Icons are visible",STATUS.PASS,DriverAction.takeSnapShot());
                }
                else
                {
                    GemTestReporter.addTestStep("Verify User Management Card Image & Angle Right Icons","User Management Card Image & Angle Right Icons are not visible",STATUS.FAIL,DriverAction.takeSnapShot());
                }
                DriverAction.getElement(superAdmin_Locators.User_Management_Card).click();
                GemTestReporter.addTestStep("Verify User Management Card is clickable","User Management is clickable",STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify User Management Card is clickable","User Management Card is not clickable",STATUS.FAIL,DriverAction.takeSnapShot());
            }
            DriverAction.navigateBack();
            if(DriverAction.getElement(superAdmin_Locators.Partner_Management_Card).isDisplayed())
            {
                if(DriverAction.getElement(superAdmin_Locators.Partner_Management_Card_Img).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Partner_Management_Card_Angle).isDisplayed())
                {
                    GemTestReporter.addTestStep("Verify Partner Management Card Image & Angle Right Icons","Partner Management Card Image & Angle Right Icons are visible",STATUS.PASS,DriverAction.takeSnapShot());
                }
                else
                {
                    GemTestReporter.addTestStep("Verify Partner Management Card Image & Angle Right Icons","Partner Management Card Image & Angle Right Icons are not visible",STATUS.FAIL,DriverAction.takeSnapShot());
                }
                DriverAction.getElement(superAdmin_Locators.Partner_Management_Card).click();
                GemTestReporter.addTestStep("Verify Partner Management Card is clickable","MCaster Management ard is clickable",STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Partner Management Card is clickable","Partner Management Card is not clickable",STATUS.FAIL,DriverAction.takeSnapShot());
            }
            DriverAction.navigateBack();
            if(DriverAction.getElement(superAdmin_Locators.Gops_Enquiry_Card).isDisplayed())
            {
                if(DriverAction.getElement(superAdmin_Locators.Gops_Enquiry_Card_Img).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Gops_Enquiry_Card_Angle).isDisplayed())
                {
                    GemTestReporter.addTestStep("Verify Gops Enquiry Card Image & Angle Right Icons","Gops Enquiry Card Image & Angle Right Icons are visible",STATUS.PASS,DriverAction.takeSnapShot());
                }
                else
                {
                    GemTestReporter.addTestStep("Verify Gops Enquiry Card Image & Angle Right Icons","Gops Enquiry Card Image & Angle Right Icons are not visible",STATUS.FAIL,DriverAction.takeSnapShot());
                }
                DriverAction.getElement(superAdmin_Locators.Gops_Enquiry_Card).click();
                GemTestReporter.addTestStep("Verify Gops Enquiry Card is clickable","MCaster Management ard is clickable",STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Gops Enquiry Card is clickable","Gops Enquiry Card is not clickable",STATUS.FAIL,DriverAction.takeSnapShot());
            }
            DriverAction.navigateBack();
            if(DriverAction.getElement(superAdmin_Locators.Reverse_Feed_Card).isDisplayed())
            {
                if(DriverAction.getElement(superAdmin_Locators.Reverse_Feed_Card_Img).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Reverse_Feed_Card_Angle).isDisplayed())
                {
                    GemTestReporter.addTestStep("Verify Reverse Feed Card Image & Angle Right Icons","Reverse Feed Card Image & Angle Right Icons are visible",STATUS.PASS,DriverAction.takeSnapShot());
                }
                else
                {
                    GemTestReporter.addTestStep("Verify Reverse Feed Card Image & Angle Right Icons","Reverse Feed Card Image & Angle Right Icons are not visible",STATUS.FAIL,DriverAction.takeSnapShot());
                }
                DriverAction.getElement(superAdmin_Locators.Reverse_Feed_Card).click();
                GemTestReporter.addTestStep("Verify Reverse Feed Card is clickable","MCaster Management ard is clickable",STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Reverse Feed Card is clickable","Reverse Feed Card is not clickable",STATUS.FAIL,DriverAction.takeSnapShot());
            }
            DriverAction.navigateBack();
            if(DriverAction.getElement(superAdmin_Locators.Generate_Ig_File_Card).isDisplayed())
            {
                if(DriverAction.getElement(superAdmin_Locators.Generate_Ig_File_Card_Img).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Generate_Ig_File_Card_Angle).isDisplayed())
                {
                    GemTestReporter.addTestStep("Verify Generate Ig File Card Image & Angle Right Icons","Generate Ig File Card Image & Angle Right Icons are visible",STATUS.PASS,DriverAction.takeSnapShot());
                }
                else
                {
                    GemTestReporter.addTestStep("Verify Generate Ig File Card Image & Angle Right Icons","Generate Ig File Card Image & Angle Right Icons are not visible",STATUS.FAIL,DriverAction.takeSnapShot());
                }
                DriverAction.getElement(superAdmin_Locators.Generate_Ig_File_Card).click();
                GemTestReporter.addTestStep("Verify Generate Ig File Card is clickable","MCaster Management ard is clickable",STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Generate Ig File Card is clickable","Generate Ig File Card is not clickable",STATUS.FAIL,DriverAction.takeSnapShot());
            }

            // LOGOUT
            if(DriverAction.getElement(superAdmin_Locators.Logout_Image).isDisplayed())
            {
                GemTestReporter.addTestStep("Verify Logout Image Icon","Logout Icon is visible",STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Logout Image Icon","Logout Icon is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
            }

            if(DriverAction.getElement(superAdmin_Locators.Logout_Btn).isDisplayed())
            {
                GemTestReporter.addTestStep("Verify Logout Button is visible","Logout Button is visible",STATUS.PASS,DriverAction.takeSnapShot());
                DriverAction.getElement(superAdmin_Locators.Logout_Btn).click();
                GemTestReporter.addTestStep("Verify Logout Button is Clickable","Logout Button is clickable",STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Logout Button is visible/clickable","Logout Button is not visible/clickable",STATUS.FAIL,DriverAction.takeSnapShot());
            }
        }

    }

    // ROLES SCREEN

    @Then("^Navigate to Roles$")
    public void navigate_to_roles()
    {
        DriverAction.getElement(superAdmin_Locators.Roles_Tab).click();
    }
    @Then("^Validate Roles Screen$")
    public void validate_roles_screen()
    {
        if(DriverAction.getElement(superAdmin_Locators.Roles_label).isDisplayed())
        {
            GemTestReporter.addTestStep("Verify Roles Label","Roles Label is visible",STATUS.PASS,DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Roles Label","Roles Label is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Role_Name_Label).isDisplayed() &&
                DriverAction.getElement(superAdmin_Locators.Created_on_Roles_Label).isDisplayed() &&
                DriverAction.getElement(superAdmin_Locators.Permissions_Roles_Label).isDisplayed() &&
        DriverAction.getElement(superAdmin_Locators.Created_By_Roles_Label).isDisplayed() &&
                DriverAction.getElement(superAdmin_Locators.Action_Roles_Label).isDisplayed())
        {
            GemTestReporter.addTestStep("Verify Table Columns","Table with following columns (Role Name, Created On, Permissions, Created By, Action) are visible",STATUS.PASS,DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Table Columns","Table with following columns (Role Name, Created On, Permissions, Created By, Action) are not visible",STATUS.PASS,DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Create_Role_button).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Create_Role_button).click();
            DriverAction.waitSec(2);
            DriverAction.getElement(superAdmin_Locators.Create_Role_Inside_button).click();
            DriverAction.waitSec(2);
            String str = DriverAction.getElement(superAdmin_Locators.Role_Name_Validation_Message).getText();
            GemTestReporter.addTestStep("Verify Error for Empty Role Name","Error : "+str,STATUS.PASS,DriverAction.takeSnapShot());
            DriverAction.typeText(superAdmin_Locators.Text_Field_Role_Name,"Tesstng Roles");
            DriverAction.getElement(superAdmin_Locators.Create_Role_Inside_button).click();
            String str1 = DriverAction.getElement(superAdmin_Locators.Permission_Required_Validation_Message).getText();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Error for Permission is required","Error : "+str1,STATUS.PASS,DriverAction.takeSnapShot());
            DriverAction.getElement(superAdmin_Locators.Reverse_Feed_Permission).click();
            DriverAction.waitSec(2);
            DriverAction.getElement(superAdmin_Locators.Create_Role_Inside_button).click();
        }
        else
        {
            GemTestReporter.addTestStep("Verify Error for Empty Field and Permission","No error occurred",STATUS.FAIL,DriverAction.takeSnapShot());
        }

        // CREATE ROLE BUTTON
        if(DriverAction.getElement(superAdmin_Locators.Create_Role_button).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Create_Role_button).click();
            if(DriverAction.getElement(superAdmin_Locators.Text_Line_Update_Role).isDisplayed()) {
                GemTestReporter.addTestStep("Verify Text Line : Enter the role details for which role has to be created", "Text Line is visible", STATUS.PASS, DriverAction.takeSnapShot());
            }
            else {
                GemTestReporter.addTestStep("Verify Text Line : Enter the role details for which role has to be created", "Text Line is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }

            if(DriverAction.getElement(superAdmin_Locators.Text_Field_Role_Name).isDisplayed())
            {
                DriverAction.typeText(superAdmin_Locators.Text_Field_Role_Name, "Test Role");
                GemTestReporter.addTestStep("Verify Text Field is working","user is able to enter role name",STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Text Field is working","user is not able to enter role name", STATUS.FAIL,DriverAction.takeSnapShot());
            }
            if(DriverAction.getElement(superAdmin_Locators.Text_Line_Select_Role).isDisplayed())
            {
                GemTestReporter.addTestStep("Verify Text Line : List of permissions which are to be given to this role.","Text Line is visible", STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify Text Line : List of permissions which are to be given to this role.","Text Line is not visible", STATUS.FAIL,DriverAction.takeSnapShot());
            }
            if(DriverAction.getElement(superAdmin_Locators.Generate_Ig_File_Permission).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Enquiry_Permission).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Report_Permission).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Bulk_Upload_Permission).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Bulk_Upload_Report_Permission).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Reverse_Feed_Permission).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Reverse_Feed_Upload_Permission).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Rejected_Case_Permission).isDisplayed())
            {
                DriverAction.getElement(superAdmin_Locators.Generate_Ig_File_Permission).click();
                DriverAction.getElement(superAdmin_Locators.Rejected_Case_Permission).click();
                DriverAction.getElement(superAdmin_Locators.Bulk_Upload_Report_Permission).click();
                DriverAction.getElement(superAdmin_Locators.Report_Permission).click();
                DriverAction.getElement(superAdmin_Locators.Enquiry_Permission).click();

            }
            else
            {
                GemTestReporter.addTestStep("Verify User is able to select permissions","Not able to select permissions", STATUS.FAIL,DriverAction.takeSnapShot());
            }
            if(DriverAction.getElement(superAdmin_Locators.Create_Role_Inside_button).isDisplayed())
            {
                String str1 = DriverAction.getCurrentURL();
                DriverAction.getElement(superAdmin_Locators.Create_Role_Inside_button).click();
                String str2 = DriverAction.getCurrentURL();
               // String str = DriverAction.getElement(superAdmin_Locators.Snack_Bar_Create_Role).getText();
                if(str1.equals(str2))
                {
                    GemTestReporter.addTestStep("Verify Role Name is already Taken","Role Name is already taken", STATUS.PASS,DriverAction.takeSnapShot());
                    DriverAction.navigateBack();
                }
                else
                {
                    GemTestReporter.addTestStep("Verify Role Created Successfully","Role Created Successfully", STATUS.PASS,DriverAction.takeSnapShot());
                }

            }
            else
            {
                GemTestReporter.addTestStep("Verify Create Role Button is working or not","Create Role Button Not Working", STATUS.FAIL,DriverAction.takeSnapShot());
            }

        }
        DriverAction.getElement(superAdmin_Locators.Create_Role_button).click();
        DriverAction.waitSec(2);
        if(DriverAction.getElement(superAdmin_Locators.Discard_Role_Inside_button).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Discard_Role_Inside_button).click();
            GemTestReporter.addTestStep("Verify Discard button is working","Discard button is visible and working", STATUS.PASS,DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Discard button is working","Discard button is not visible and working", STATUS.FAIL,DriverAction.takeSnapShot());
        }
        // EDIT ROLE
        if(DriverAction.getElement(superAdmin_Locators.Edit_Role_button).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Edit_Role_button).click();
            DriverAction.waitSec(2);
            if(DriverAction.getElement(superAdmin_Locators.Text_Line_Update_Role).isDisplayed()) {
                GemTestReporter.addTestStep("Verify Text Line : Enter the role details for which role has to be created", "Text Line is visible", STATUS.PASS, DriverAction.takeSnapShot());
            }
                else {
                GemTestReporter.addTestStep("Verify Text Line : Enter the role details for which role has to be created", "Text Line is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }

            if(DriverAction.getElement(superAdmin_Locators.Text_Field_Role_Name).isDisplayed())
            {
                DriverAction.typeText(superAdmin_Locators.Text_Field_Role_Name, "Edit Role");
                GemTestReporter.addTestStep("Verify Text Field not editable","Text Field is not editable", STATUS.PASS,DriverAction.takeSnapShot());
            }
           else
            {
                GemTestReporter.addTestStep("Verify Text Field not editable","Text Field is editable", STATUS.FAIL,DriverAction.takeSnapShot());
            }
           if(DriverAction.getElement(superAdmin_Locators.Text_Line_Select_Role).isDisplayed())
           {
               GemTestReporter.addTestStep("Verify Text Line : List of permissions which are to be given to this role.","Text Line is visible", STATUS.PASS,DriverAction.takeSnapShot());
           }
           else
           {
               GemTestReporter.addTestStep("Verify Text Line : List of permissions which are to be given to this role.","Text Line is not visible", STATUS.FAIL,DriverAction.takeSnapShot());
           }
           if(DriverAction.getElement(superAdmin_Locators.Generate_Ig_File_Permission).isDisplayed() &&
            DriverAction.getElement(superAdmin_Locators.Enquiry_Permission).isDisplayed() &&
            DriverAction.getElement(superAdmin_Locators.Report_Permission).isDisplayed() &&
            DriverAction.getElement(superAdmin_Locators.Bulk_Upload_Permission).isDisplayed() &&
                   DriverAction.getElement(superAdmin_Locators.Bulk_Upload_Report_Permission).isDisplayed() &&
            DriverAction.getElement(superAdmin_Locators.Reverse_Feed_Permission).isDisplayed() &&
            DriverAction.getElement(superAdmin_Locators.Reverse_Feed_Upload_Permission).isDisplayed() &&
                   DriverAction.getElement(superAdmin_Locators.Rejected_Case_Permission).isDisplayed())
           {
             DriverAction.getElement(superAdmin_Locators.Generate_Ig_File_Permission).click();
             DriverAction.getElement(superAdmin_Locators.Rejected_Case_Permission).click();
             DriverAction.getElement(superAdmin_Locators.Bulk_Upload_Report_Permission).click();
             DriverAction.getElement(superAdmin_Locators.Report_Permission).click();
             DriverAction.getElement(superAdmin_Locators.Enquiry_Permission).click();
             DriverAction.getElement(superAdmin_Locators.Report_Permission).click();
             DriverAction.getElement(superAdmin_Locators.Reverse_Feed_Upload_Permission).click();
           }
           else
           {
               GemTestReporter.addTestStep("Verify User is able to edit permissions","Not able to edit role", STATUS.FAIL,DriverAction.takeSnapShot());
           }
           if(DriverAction.getElement(superAdmin_Locators.Update_Role_button).isDisplayed())
           {
               DriverAction.getElement(superAdmin_Locators.Update_Role_button).click();
               DriverAction.waitSec(2);
               GemTestReporter.addTestStep("Verify Role Updated Successfully","Role Updated Successfully", STATUS.PASS,DriverAction.takeSnapShot());
           }
           else
           {
               GemTestReporter.addTestStep("Verify Role Updated Successfully","ROle Not Updated", STATUS.FAIL,DriverAction.takeSnapShot());
           }

        }
        DriverAction.getElement(superAdmin_Locators.Edit_Role_button).click();
        DriverAction.waitSec(2);
        if(DriverAction.getElement(superAdmin_Locators.Discard_button_Roles).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Discard_button_Roles).click();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Discard button is working","Discard button is visible and working", STATUS.PASS,DriverAction.takeSnapShot());
        }
        else {
            GemTestReporter.addTestStep("Verify Discard button is working","Discard button is not visible and working", STATUS.PASS,DriverAction.takeSnapShot());

        }
        DriverAction.waitSec(2);
        if(DriverAction.getElement(superAdmin_Locators.Delete_Role_button).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Delete_Role_button).click();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Delete button is working","Delete button is visible and working", STATUS.PASS,DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Delete button is working","Delete button is not visible and working", STATUS.FAIL,DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.pagination_roles).isDisplayed())
        {
            String str = DriverAction.getElement(superAdmin_Locators.pagination_roles).getText();
            GemTestReporter.addTestStep("Verify Pagination is working", "Pagination is working"+str, STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Pagination is working", "Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());

        }
        if(DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Right_roles).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Right_roles).click();
            DriverAction.waitSec(2);
            String str2 = DriverAction.getElement(superAdmin_Locators.pagination_roles).getText();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Right Pagination is working", "Right Pagination is working :"+str2, STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Right Pagination is working", "Right Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());

        }
        if(DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Left_roles).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Left_roles).click();
            DriverAction.waitSec(2);
            String str4 = DriverAction.getElement(superAdmin_Locators.pagination_roles).getText();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Left Pagination is working", "Left Pagination is working:"+str4, STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Left Pagination is working", "Left Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

}

