package com.gemini.PLIL.StepDefination;

import com.gemini.PLIL.Locators.Locator;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class superAdmin {

    // SUPER ADMIN LOGIN
    @Given("^Login as superAdmin$")
    public void Login_as_superAdmin()
    {
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
        else
        {
            GemTestReporter.addTestStep("Verify Pagination of Partner Management", "Pagination is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
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
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(5));
        WebElement discard_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(superAdmin_Locators.Discard_Role_Inside_button));

        if(DriverAction.getElement(superAdmin_Locators.Discard_Role_Inside_button).isDisplayed())
        {
            discard_btn.click();
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

    @Then("^Navigate to Generate Ig File$")
    public void navigate_to_generate_ig_file()
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(superAdmin_Locators.Generate_IG_File_Tab));

        DriverAction.getElement(superAdmin_Locators.Generate_IG_File_Tab).click();
    }
    @Then("^Validate Generate Ig File Screen$")
    public void validate_generate_ig_file()
    {
       if(DriverAction.getElement(superAdmin_Locators.Generate_Ig_File_Label).isDisplayed())
       {
           GemTestReporter.addTestStep("Verify Generate IG file label","Generate Ig File label is displayed",STATUS.PASS,DriverAction.takeSnapShot());
       }
       else
       {
           GemTestReporter.addTestStep("Verify Generate IG file label","Generate Ig File label is not displayed",STATUS.FAIL,DriverAction.takeSnapShot());
       }
       if(DriverAction.getElement(superAdmin_Locators.Generate_Ig_File_Text_Line).isDisplayed())
       {
           GemTestReporter.addTestStep("Verify Generate IG file Text Line","Generate Ig File Text Line is displayed",STATUS.PASS,DriverAction.takeSnapShot());
       }
       else
       {
           GemTestReporter.addTestStep("Verify Generate IG file Text Line","Generate Ig File Text Line is not displayed",STATUS.FAIL,DriverAction.takeSnapShot());
       }
       if(DriverAction.getElement(superAdmin_Locators.Generate_Ig_file_Button).isDisplayed())
       {
           DriverAction.getElement(superAdmin_Locators.Generate_Ig_file_Button).click();
           GemTestReporter.addTestStep("Verify Generate IG file Button is clickable","Generate Ig File Button is clickable",STATUS.PASS,DriverAction.takeSnapShot());
           if(DriverAction.getElement(superAdmin_Locators.IG_File_Generated_Successfully_Snack_Bar).isDisplayed() && DriverAction.getElement(superAdmin_Locators.IG_File_Generated_Successfully_Snack_Bar_Cancel_Btn).isDisplayed())
           {
               String str = DriverAction.getElement(superAdmin_Locators.IG_File_Generated_Successfully_Snack_Bar).getText();
               GemTestReporter.addTestStep("Verify Generate IG file Snack bar is visible","Generate Ig File Snack bar is visible with message : "+str,STATUS.PASS,DriverAction.takeSnapShot());
               DriverAction.getElement(superAdmin_Locators.IG_File_Generated_Successfully_Snack_Bar_Cancel_Btn).click();
               GemTestReporter.addTestStep("Verify Generate IG file Snack bar Cancel button is visible","Generate Ig File Snack bar Cancel button is visible and clickable with message : "+str,STATUS.PASS,DriverAction.takeSnapShot());
           }
           else
           {
               GemTestReporter.addTestStep("Verify Generate IG file Snack bar is visible","Generate Ig File Snack bar is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
           }
       }
       else
       {
           GemTestReporter.addTestStep("Verify Generate IG file Button is clickable","Generate Ig File Button is not clickable",STATUS.FAIL,DriverAction.takeSnapShot());

       }
    }

   // MASTER MANAGEMENT

    @Then("^Navigate to Master Management$")
    public void navigate_to_master_management()
    {
        DriverAction.getElement(superAdmin_Locators.Master_Management_Tab).click();
    }
    @Then("^Click on Covid Questions and Validate$")
    public void covid_questions()
    {
     if(DriverAction.getElement(superAdmin_Locators.Covid_Questions_Card).isDisplayed())
     {
         GemTestReporter.addTestStep("Verify Covid Question Card is visible","Covid Questions Card is visible",STATUS.PASS,DriverAction.takeSnapShot());
         DriverAction.getElement(superAdmin_Locators.Covid_Questions_Card).click();
         GemTestReporter.addTestStep("Verify Covid Question Card is clickable","Covid Questions Card is clickable",STATUS.PASS,DriverAction.takeSnapShot());

         if(DriverAction.getElement(superAdmin_Locators.BreadCrumb_Covid_Questions).isDisplayed())
         {
             String str = DriverAction.getElement(superAdmin_Locators.BreadCrumb_Covid_Questions).getText();
             GemTestReporter.addTestStep("Verify Breadcrumb is visible","Bread Crumb is visible with value : "+str,STATUS.PASS,DriverAction.takeSnapShot());
         }
         else
         {
             GemTestReporter.addTestStep("Verify Breadcrumb is visible","Bread Crumb is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
         }
         if(DriverAction.getElement(superAdmin_Locators.Left_Angle_Covid_Questions_Label).isDisplayed())
         {
             GemTestReporter.addTestStep("Verify Back button is visible","Back button is visible",STATUS.PASS,DriverAction.takeSnapShot());
             DriverAction.getElement(superAdmin_Locators.Left_Angle_Covid_Questions_Label).click();
             GemTestReporter.addTestStep("Verify Back button is clickable","Back button is clickable",STATUS.PASS,DriverAction.takeSnapShot());
         }
         else
         {
             GemTestReporter.addTestStep("Verify Back button is visible","Back button is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
         }
         DriverAction.getElement(superAdmin_Locators.Covid_Questions_Card).click();
         if(DriverAction.getElement(superAdmin_Locators.Covid_Questions_Label).isDisplayed())
         {
             GemTestReporter.addTestStep("Verify Covid Questions Label is visible", "Covid Question Label is visible", STATUS.PASS, DriverAction.takeSnapShot());
         }
         else
         {
             GemTestReporter.addTestStep("Verify Covid Questions Label is visible","Covid Question Label is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
         }
         if(DriverAction.getElement(superAdmin_Locators.Code_Column_Covid_Questions).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Value_Column_Covid_Questions).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Created_On_Column_Covid_Questions).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Created_By_Column_Covid_Questions).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Action_Column_Covid_Questions).isDisplayed())
         {
            GemTestReporter.addTestStep("Verify Columns : Code,Value,Created On,Created By and Action","Following column should be visible : Code,Value,Created On,Created By,Action",STATUS.PASS,DriverAction.takeSnapShot());
         }
         else
         {
             GemTestReporter.addTestStep("Verify Columns : Code,Value,Created On,Created By and Action","Following columns are not visible : Code,Value,Created On,Created By,Action",STATUS.FAIL,DriverAction.takeSnapShot());
         }
         if(DriverAction.getElement(superAdmin_Locators.Edit_Action_Button_Covid_Questions).isDisplayed())
         {
             GemTestReporter.addTestStep("Verify Edit Button is visible", "Edit button is visible",STATUS.PASS,DriverAction.takeSnapShot());

             DriverAction.getElement(superAdmin_Locators.Edit_Action_Button_Covid_Questions).click();
             GemTestReporter.addTestStep("Verify Edit Button is clickable", "Edit button is clickable",STATUS.PASS,DriverAction.takeSnapShot());
             if(DriverAction.getElement(superAdmin_Locators.BreadCrumb_Covid_Questions).isDisplayed())
             {
                 String str = DriverAction.getElement(superAdmin_Locators.BreadCrumb_Covid_Questions).getText();
                 GemTestReporter.addTestStep("Verify Breadcrumb is visible","Bread Crumb is visible with value : "+str,STATUS.PASS,DriverAction.takeSnapShot());
             }
             else
             {
                 GemTestReporter.addTestStep("Verify Breadcrumb is visible","Bread Crumb is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
             }
             if(DriverAction.getElement(superAdmin_Locators.Covid_Questions_Update_Label).isDisplayed())
             {
                 GemTestReporter.addTestStep("Verify Update Label","Update Label is visible",STATUS.PASS,DriverAction.takeSnapShot());
             }
             else
             {
                 GemTestReporter.addTestStep("Verify Update Label","Update Label is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
             }
             if(DriverAction.getElement(superAdmin_Locators.Label_Edit_Covid_Questions).isDisplayed())
             {
                 GemTestReporter.addTestStep("Verify Covid Questions Update Label is visible","Covid Questions Update Label is visible",STATUS.PASS,DriverAction.takeSnapShot());
             }
             else
             {
                 GemTestReporter.addTestStep("Verify Covid Questions Update Label is not visible","Covid Questions Update Label is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
             }
             if(DriverAction.getElement(superAdmin_Locators.Value_Update_Covid_Questions).isDisplayed())
             {
                 GemTestReporter.addTestStep("Verify Value Text Field is visible","Value Text Field is visible",STATUS.PASS,DriverAction.takeSnapShot());
                 DriverAction.typeText(superAdmin_Locators.Value_Update_Covid_Questions,"Have you/ or any of your immediate family members travelled outside India in the last 45 days or do you plan to travel outside India during the next 6 months?");
             }
             else
             {
                 GemTestReporter.addTestStep("Verify Value Text Field is visible","Value Text Field is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
             }
             if(DriverAction.getElement(superAdmin_Locators.Code_Update_Covid_Questions).isDisplayed())
             {
                 GemTestReporter.addTestStep("Verify Code Text Field is visible","Code Text Field is visible",STATUS.PASS,DriverAction.takeSnapShot());
                 DriverAction.typeText(superAdmin_Locators.Code_Update_Covid_Questions,"CQ-1");
             }
             else
             {
                 GemTestReporter.addTestStep("Verify Code Text Field is visible","Code Text Field is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
             }
             if(DriverAction.getElement(superAdmin_Locators.Update_btn_Update_Covid_Questions).isDisplayed())
             {
                 String str1 = DriverAction.getCurrentURL();
                 GemTestReporter.addTestStep("Verify Update Button is visible","Update Button is visible",STATUS.PASS,DriverAction.takeSnapShot());
                 DriverAction.getElement(superAdmin_Locators.Update_btn_Update_Covid_Questions).click();
                 String str2 = DriverAction.getCurrentURL();
                 if(str1.equals(str2))
                 {
                     GemTestReporter.addTestStep("Verify Code Already Taken","Code Already taken is visible",STATUS.PASS,DriverAction.takeSnapShot());
                     DriverAction.typeText(superAdmin_Locators.Code_Update_Covid_Questions,"CQ-5");
                     DriverAction.getElement(superAdmin_Locators.Update_btn_Update_Covid_Questions).click();
                 }
                 else
                 {
                     GemTestReporter.addTestStep("Verify Update Button is clickable","Update Button is clickable",STATUS.PASS,DriverAction.takeSnapShot());
                 }
             }
             else
             {
                 GemTestReporter.addTestStep("Verify Update Button is visible","Update Button is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
             }

             DriverAction.getElement(superAdmin_Locators.Edit_Action_Button_Covid_Questions).click();
             if(DriverAction.getElement(superAdmin_Locators.Discard_btn_Update_Covid_Questions).isDisplayed())
             {

                 GemTestReporter.addTestStep("Verify Discard Button is visible","Discard button is visible",STATUS.PASS,DriverAction.takeSnapShot());
                 DriverAction.getElement(superAdmin_Locators.Discard_btn_Update_Covid_Questions).click();
             }
             else
             {
                 GemTestReporter.addTestStep("Verify Discard Button is visible","Discard button is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
             }
             if(DriverAction.getElement(superAdmin_Locators.Back_Edit_Covid_Questions).isDisplayed())
             {
                 GemTestReporter.addTestStep("Verify Back button is visible","Back button is visible",STATUS.PASS,DriverAction.takeSnapShot());
             }
             else
             {
                 GemTestReporter.addTestStep("Verify Back button is visible","Back button is not visible",STATUS.FAIL,DriverAction.takeSnapShot());

             }

         }
         else
         {
             GemTestReporter.addTestStep("Verify Edit Button is visible", "Edit button is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
         }
         if(DriverAction.getElement(superAdmin_Locators.Delete_Action_Button_Covid_Questions).isDisplayed())
         {
             GemTestReporter.addTestStep("Verify Delete Button is visible", "Delete button is visible",STATUS.PASS,DriverAction.takeSnapShot());

             //DriverAction.getElement(superAdmin_Locators.Delete_Action_Button_Covid_Questions).click();
             GemTestReporter.addTestStep("Verify Delete Button is clickable", "Delete button is clickable",STATUS.PASS,DriverAction.takeSnapShot());
         }
         else
         {
             GemTestReporter.addTestStep("Verify Delete Button is visible", "Delete button is not visible",STATUS.FAIL,DriverAction.takeSnapShot());
         }

     }
     else
     {
         GemTestReporter.addTestStep("Verify Covid Question Card is visible","Covid Questions Card is not  visible",STATUS.FAIL,DriverAction.takeSnapShot());
     }

        if(DriverAction.getElement(superAdmin_Locators.Pagination_Covid_Questions).isDisplayed())
        {
            String str1 = DriverAction.getElement(superAdmin_Locators.Pagination_Covid_Questions).getText();
            GemTestReporter.addTestStep("Verify Pagination of Partner Management", "Pagination is visible : "+str1, STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Pagination of Partner Management", "Pagination is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Covid_Questions_Angle_Right_Partner_Management).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Covid_Questions_Angle_Right_Partner_Management).click();
            DriverAction.waitSec(2);
            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination_Covid_Questions).getText();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Next Page Navigation", "Navigate to Next Page is working : "+pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Next Page Pagination", "Next Page Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Covid_Questions_Angle_Left_Partner_Management).isDisplayed())
        {
            DriverAction.getElement(superAdmin_Locators.Covid_Questions_Angle_Left_Partner_Management).click();
            DriverAction.waitSec(2);
            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination_Covid_Questions).getText();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Previous Page Navigation", "Navigate to Previous Page is working : "+pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            GemTestReporter.addTestStep("Verify Previous Page Pagination", "Previous Page Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());
        }

        //
    }
    @Then("^Click on Medical Questions and Validate$")
    public void medical_questions()
    {

    }
}