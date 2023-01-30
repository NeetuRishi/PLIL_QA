package com.gemini.PLIL.StepDefination;

import com.gemini.PLIL.Locators.Locator;
import com.gemini.PLIL.Locators.superAdmin_Locators;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class superAdmin {

    @Given("^Login as superAdmin$")
    public void Login_as_superAdmin()
    {
        DriverAction.typeText(Locator.Email_Input_Field, "deepak.kumar@geminisolutions.com");
        DriverAction.waitSec(2);
        DriverAction.typeText(Locator.Password_Input_Field, "Asdf@1234");
        DriverAction.waitSec(10);
        DriverAction.click(Locator.Login);
        DriverAction.waitSec(5);
    }

    @Then("^Validate Common UI Elements$")
    public void validate_ui_elements()
    {
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
        Boolean isPassed = false;
        if(DriverAction.getElement(superAdmin_Locators.Partner_Product_Tab_Highlighted).getText().equals("Partner Product"))
        {
            isPassed = true;
            GemTestReporter.addTestStep("Click on Partner Product Tab", "Partner Product Tab is Highlighted", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            isPassed = false;
            GemTestReporter.addTestStep("CLick on Partner Product Tab","Partner Product Tab is Highlighted",STATUS.FAIL,DriverAction.takeSnapShot());
        }

        if (DriverAction.getElement(superAdmin_Locators.Label_Partner_Product).isDisplayed())
        {
            isPassed = true;
            GemTestReporter.addTestStep("Verify Partner Product Label", "Partner Product Label is present", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            isPassed = false;
            GemTestReporter.addTestStep("Verify Partner Product Label","Partner Product Label is present",STATUS.FAIL,DriverAction.takeSnapShot());
        }

        if(DriverAction.getElement(superAdmin_Locators.Partner_Name).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Product_Name).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Policy_No).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Plan_No).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Type).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Created_On).isDisplayed() && DriverAction.getElement(superAdmin_Locators.Action).isDisplayed())
        {
            isPassed = true;
            GemTestReporter.addTestStep("Verify Table Columns","Following columns are present in table : Partner Name, Product Name, Policy No., Plan No., Type, Created On, Action",STATUS.PASS,DriverAction.takeSnapShot());
        }
        else
        {
            isPassed = false;
            GemTestReporter.addTestStep("Verify Table Columns","Following columns are present in table : Partner Name, Product Name, Policy No., Plan No., Type, Created On, Action",STATUS.FAIL,DriverAction.takeSnapShot());
        }

        if(DriverAction.getElement(superAdmin_Locators.Pagination).isDisplayed())
        {
            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination).getText();
            isPassed = true;
            GemTestReporter.addTestStep("Verify Pagination", "Pagination is present : "+pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            isPassed = false;
            GemTestReporter.addTestStep("Verify Pagination", "Pagination is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Right).isDisplayed()) {
            isPassed = true;
            DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Right).click();
            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination).getText();
            GemTestReporter.addTestStep("Verify Next Page Navigation", "Navigate to Next Page is working : "+pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            isPassed = false;
            GemTestReporter.addTestStep("Verify Next Page Pagination", "Next Page Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if(DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Left).isDisplayed())
        {
            isPassed = true;
            DriverAction.getElement(superAdmin_Locators.Pagination_Angle_Left).click();
            String pag_text = DriverAction.getElement(superAdmin_Locators.Pagination).getText();
            GemTestReporter.addTestStep("Verify Previous Page Navigation", "Navigate to Previous Page is working : "+pag_text, STATUS.PASS, DriverAction.takeSnapShot());
        }
        else {
            isPassed = false;
            GemTestReporter.addTestStep("Verify Previous Page Pagination", "Previous Page Pagination is not working", STATUS.FAIL, DriverAction.takeSnapShot());
        }

        DriverAction.waitSec(2);
        if(DriverAction.getElement(superAdmin_Locators.eye_button).isDisplayed())
        {
            isPassed = true;
            DriverAction.getElement(superAdmin_Locators.eye_button).click();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Verify Eye / View Button", "User is able to see partner product details", STATUS.PASS, DriverAction.takeSnapShot());
        }
        else
        {
            isPassed = false;
            GemTestReporter.addTestStep("Verify Eye / View Button", "User is not able to see partner product details", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        DriverAction.navigateBack();
        DriverAction.waitSec(4);
        if(DriverAction.getElement(superAdmin_Locators.edit_button).isDisplayed())
        {
            isPassed = true;
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
            isPassed = false;
            GemTestReporter.addTestStep("Verify Update Partner", "Partner Product is not updated.", STATUS.FAIL, DriverAction.takeSnapShot());
            DriverAction.waitSec(2);
        }

        DriverAction.getElement(superAdmin_Locators.edit_button).click();
        if(DriverAction.getElement(superAdmin_Locators.Discard_Button).isDisplayed())
        {
            isPassed=true;
            DriverAction.getElement(superAdmin_Locators.Discard_Button).click();
            GemTestReporter.addTestStep("Verify Update Partner Discard Button", "Discard Button is clickable.", STATUS.PASS,DriverAction.takeSnapShot());

        }

        DriverAction.waitSec(5);
        if(DriverAction.getElement(superAdmin_Locators.Create_Partner_Product_Button).isDisplayed())
        {
            isPassed = true;
            DriverAction.getElement(superAdmin_Locators.Create_Partner_Product_Button).click();
            DriverAction.waitSec(5);

            if(DriverAction.getElement(superAdmin_Locators.Label_Create_Partner_Product).isDisplayed()) isPassed = true;
            else isPassed = false;
            if(DriverAction.getElement(superAdmin_Locators.Text_Line_Create_Partner_Product).isDisplayed()) isPassed = true;
            else isPassed = false;
            DriverAction.waitSec(5);
            if(DriverAction.getElement(superAdmin_Locators.Select_Partner_DropDown).isDisplayed())
            {
                isPassed = true;
                DriverAction.getElement(superAdmin_Locators.Select_Partner_DropDown).click();
                DriverAction.waitSec(2);
                DriverAction.getElement(superAdmin_Locators.Select_Partner_Value).click();
            }
            else isPassed = false;

            DriverAction.waitSec(7);

            if(DriverAction.getElement(superAdmin_Locators.Select_Product_DropDown).isDisplayed())
            {
                isPassed = true;
                DriverAction.getElement(superAdmin_Locators.Select_Product_DropDown).click();
                DriverAction.waitSec(3);
                DriverAction.getElement(superAdmin_Locators.Select_Product_Value).click();
            }
            else isPassed = false;
            if(DriverAction.getElement(superAdmin_Locators.Label_Medical_Questions).isDisplayed()) isPassed = true;
            else isPassed = false;
            DriverAction.waitSec(5);
            if(DriverAction.getElement(superAdmin_Locators.Select_Medical_Questions).isDisplayed())
            {
                isPassed = true;
                DriverAction.getElement(superAdmin_Locators.Select_Medical_Questions).click();
            }
            else isPassed = false;
            if(DriverAction.getElement(superAdmin_Locators.Label_Covid_Questions).isDisplayed()) isPassed = true;
            else isPassed = false;
            DriverAction.waitSec(5);
            if(DriverAction.getElement(superAdmin_Locators.Select_Covid_Questions).isDisplayed())
            {
                isPassed = true;
                DriverAction.waitSec(2);
                DriverAction.getElement(superAdmin_Locators.Select_Covid_Questions).click();
            }
            else isPassed = false;
            if(DriverAction.getElement(superAdmin_Locators.Create_Partner_Product_Btn).isDisplayed())
            {
                isPassed = true;
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
            else isPassed = false;
            DriverAction.waitSec(2);

        }
        else isPassed = false;

        DriverAction.getElement(superAdmin_Locators.Create_Partner_Product_Button).click();
        DriverAction.waitSec(4);
        if(DriverAction.getElement(superAdmin_Locators.Discard_Button).isDisplayed())
        {
            isPassed = true;
            DriverAction.getElement(superAdmin_Locators.Discard_Button).click();
            DriverAction.waitSec(2);
            GemTestReporter.addTestStep("Create Partner Product - Discard", "Discard Button is clickable ", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.waitSec(2);
        }
        else isPassed = false;

        DriverAction.waitSec(10);

        if(isPassed){
            GemTestReporter.addTestStep("Validation", "Partner Product Updated / Created Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        }
    }

  // PARTNER MANAGEMENT

    @Then("^Navigate to Partner Management$")
    public void Navigate_to_partner_management()
    {
        DriverAction.getElement(superAdmin_Locators.Partner_Management_Tab).click();
    }

    @Then("^Validate Partner Management Screen$")
    public void Validate_Partner_Management_Screen()
    {
        Boolean isPassed = false;
        if (DriverAction.getElement(superAdmin_Locators.Hamburger_Partner_Management).isDisplayed()) isPassed = true;
        else isPassed = false;

        if (DriverAction.getElement(superAdmin_Locators.Label_Partner_Management).isDisplayed()) isPassed = true;
        else isPassed = false;

        if(DriverAction.getElement(superAdmin_Locators.Partner_Name).isDisplayed()) isPassed = true;
        else isPassed = false;

        if(DriverAction.getElement(superAdmin_Locators.Prefix_Partner_Management).isDisplayed()) isPassed = true;
        else isPassed = false;

        if(DriverAction.getElement(superAdmin_Locators.Created_On_Partner_Management).isDisplayed()) isPassed = true;
        else isPassed = false;

        if(DriverAction.getElement(superAdmin_Locators.Action_Partner_Management).isDisplayed()) isPassed = true;
        else isPassed = false;

        if(DriverAction.getElement(superAdmin_Locators.edit_Partner_Management).isDisplayed()) isPassed = true;
        else isPassed = false;

    }

}
