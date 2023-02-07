package com.gemini.PLIL.StepDefination;

import com.gemini.PLIL.Locators.Locator;
import com.gemini.PLIL.Locators.superAdmin_Locators;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.List;

    public class GOPSStepDefination {

        public GOPSStepDefination() {
        }

        @Given("enter email ID and password")
        public void enter_email_id_and_password() {
            DriverAction.typeText(Locator.Email_Input_Field, "deepak.kumar@geminisolutions.com");
            WebElement ele=DriverManager.getWebDriver().findElement(Locator.Password_Input_Field);
            ele.sendKeys("Asdf@1234");
            GemTestReporter.addTestStep("Password","****",STATUS.PASS,DriverAction.takeSnapShot());
            //DriverAction.typeText(Locator.Password, "Asdf@1234","password");
            DriverAction.click(By.xpath("//button[@type='submit']"));
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20));
            //wait.until(ExpectedConditions.titleIs("Group Product"));
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//mat-error[text()=' Verification required ']"), "Verification required"));
            // wait.until(ExpectedConditions.urlMatches("https://groupuat.pramericalife.in/admin/"));

        }

        @Then("click on Captcha,Login and GOPS Enquiry")
        public void click_on_captcha_login_and_gops_enquiry() {

            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20));
            WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            ele.click();

        }

        @Then("validate the Logo")
        public void validate_the_logo() {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='expandLogo']")));
            boolean isPassed;
            if (DriverAction.getElement(By.xpath("//img[@class='expandLogo']")).isDisplayed()) {
                isPassed = true;
            } else {
                isPassed = false;
            }

            if (isPassed) {
                GemTestReporter.addTestStep("PLIL logo validation", "PLIL Logo is visible", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("PLIL logo validation", "PLIL logo is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        }

        @Then("validate tabs")
        public void validate_tabs() {
            Boolean isPassed = false;
            if (DriverAction.getElement(superAdmin_Locators.gopshomeButton).isDisplayed()) isPassed = true;
            else isPassed = false;

            if (DriverAction.getElement(superAdmin_Locators.roleshomeButton).isDisplayed()) isPassed = true;
            else isPassed = false;

            if (DriverAction.getElement(superAdmin_Locators.mastermgtButton).isDisplayed()) isPassed = true;
            else isPassed = false;

            if (DriverAction.getElement(superAdmin_Locators.partnerproduct).isDisplayed()) isPassed = true;
            else isPassed = false;

            if (DriverAction.getElement(superAdmin_Locators.usmgt).isDisplayed()) isPassed = true;
            else isPassed = false;
            if (DriverAction.getElement(superAdmin_Locators.patmgt).isDisplayed()) isPassed = true;
            else isPassed = false;
            if (DriverAction.getElement(superAdmin_Locators.gopsEnquiry).isDisplayed()) isPassed = true;
            else isPassed = false;


            if (isPassed) {
                GemTestReporter.addTestStep("PLIL Tabs Validation", "PLIL Tabs are visible", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("PLIL Tabs Validation", "PLIL Tabs are not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        }


        @Then("validate GOPS tab")
        public void validate_gops_tab() {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(20));
            WebElement gopsele = wait .until(ExpectedConditions.elementToBeClickable(superAdmin_Locators.gopsEnquiry));
            gopsele.click();

            Boolean isPassed = false;
            DriverAction.click(superAdmin_Locators.gopshomeButton);

            if (DriverAction.getElement(superAdmin_Locators.gopsEnquiryHm).isDisplayed()) isPassed = true;
            else isPassed = false;

            if (isPassed) {
                GemTestReporter.addTestStep("gopsEnquiry Button", "gopsEnquiry Button is visible", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("gopsEnquiry Button", "gopsEnquiry Button is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        }

        @Then("To validate Hamburger button")
        public void to_validate_hamburger_button() {
            Boolean isPassed = false;
            if (DriverAction.getElement(superAdmin_Locators.hamBurgerBtn).isDisplayed())
                isPassed = true;
            else isPassed = false;

            if (isPassed) {
                GemTestReporter.addTestStep("HamBurger button Validation", "Ham Burger button is present on Screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("HamBurger button Validation", "Ham Burger button is present on Screen", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        }

        @Then("validate GOPS Enquiry Tab is highlighted and displayed")
        public void validate_gops_enquiry_tab_is_highlighted_and_displayed() {
            String backcolor = DriverAction.getCSSValue(superAdmin_Locators.gopsEnquiry, "color");
            System.out.println(backcolor);
            Boolean isPassed = false;
            if (DriverAction.getElement(superAdmin_Locators.gopsEnquiryHm).isDisplayed()) isPassed = true;
            else isPassed = false;

            if (isPassed) {
                GemTestReporter.addTestStep("GOPS tab validation", "GOPS tab is visible", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("GOPS tab validation", "GOPS tab is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }


        }


  /*  @Then("I validate GOPS Enquiry Tab is diplayed")
    public void validate_gops_enquiry_tab_is_diplayed() {
        Boolean isPassed = false;
        if (DriverAction.getElement(superAdmin_Locators.gopsEnquiryHm).isDisplayed()) isPassed = true;
        else isPassed = false;

        if(isPassed){
            GemTestReporter.addTestStep("Validation", "UI Elements are visible", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Validation", "UI Elements are not visible", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }



    @Given("I validate logout button")
    public void i_validate_logout_button() {
        Boolean isPassed = false;
        if(DriverAction.getElement(Locator.Logout).isDisplayed())
            isPassed = true;
        else isPassed = false;
        if(isPassed){
            GemTestReporter.addTestStep("LogoutValidation", "UI Elements are visible", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("LogoutValidation", "UI Elements are not visible", STATUS.FAIL, DriverAction.takeSnapShot());
        }

        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(6));
       WebElement element = wait.until(ExpectedConditions.elementToBeClickable(DriverAction.getElement(Locator.Logout)));
       element.click();


    }*/

        @Then("enter text to validate GOPS Filter")
        public void enter_text_to_validate_gops_filter() {
            DriverAction.click(superAdmin_Locators.gopsEnquiry);
            WebElement ele = DriverAction.getElement(superAdmin_Locators.partnerSearch);
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(20));
            wait.until(ExpectedConditions.textToBePresentInElement(ele,"Partner"));
            DriverAction.click(superAdmin_Locators.partnerSearch);

            DriverAction.click(By.xpath("//span[contains(text(),'Piramal Capital and Housing Finance')]"));
        }

        @Then("validate filter with inplace text partner")
        public void validate_filter_with_inplace_text_partner() {
            DriverManager.getWebDriver().navigate().refresh();
            //DriverAction.click(superAdmin_Locators.gopsEnquiryHm);
            DriverAction.click(superAdmin_Locators.gopsEnquiry);
            String text = DriverAction.getElementText(superAdmin_Locators.partnerSearch);
            //System.out.println(text);
            if (text.equalsIgnoreCase("Partner")) {
                GemTestReporter.addTestStep("Partner Text Validation", "Partner Text Validation matched", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Partner Text Validation", "Partner Text Validation didn't match", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        }

        @Then("validate status filter with inplace text")
        public void validate_status_filter_with_inplace_text() {
            DriverManager.getWebDriver().navigate().refresh();
            DriverAction.click(superAdmin_Locators.gopsEnquiry);
            String text = DriverAction.getElementText(superAdmin_Locators.statusSearch);
            System.out.println(text);
            if (text.equalsIgnoreCase("Status")) {
                GemTestReporter.addTestStep("Status TextValidation", "Status Text Validation matched", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Status TextValidation", "Status Text Validation didn't match", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        }

        @Then("validate Date field")
        public void validate_date_field() {
            DriverManager.getWebDriver().navigate().refresh();
            //DriverAction.click(superAdmin_Locators.gopsEnquiryHm);
            // DriverAction.click(superAdmin_Locators.gopsEnquiry);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            String str = formatter.format(date);

            //String nDate = date.toString();
            String[] arr = str.split("/");
            //System.out.println(arr);
            int length = arr.length;
            System.out.println(length);
            List<String> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                list.add(arr[i]);
            }
            System.out.println(list);
            int currentyear = Integer.parseInt(list.get(2));
            int currentmonth = Integer.parseInt(list.get(1));
            int currentdate = Integer.parseInt(list.get(0));
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
            String actualmonth = null;
            if (map.containsKey(currentmonth)) {
                actualmonth = map.get(currentmonth);

            }

            System.out.println(actualmonth);
            DriverAction.click(superAdmin_Locators.gopsEnquiry);
            DriverAction.click(superAdmin_Locators.dateButton);
            DriverAction.click(superAdmin_Locators.yearDropDown);
            DriverAction.click(By.xpath("//div[contains(text(),\'" + currentyear + "\')]"));
            DriverAction.click(By.xpath("//div[contains(text(),\'" + actualmonth + "\')]"));
            DriverAction.click(By.xpath("//div[contains(text(),\'" + currentdate + "\')]"));

        }

        @Then("validate search field")
        public void validate_search_field() {
            DriverManager.getWebDriver().navigate().refresh();
            //DriverAction.click(superAdmin_Locators.gopsEnquiryHm);
            DriverAction.click(superAdmin_Locators.gopsEnquiry);
            //DriverAction.click(superAdmin_Locators.gopsEnquiry);
            // DriverAction.waitSec(5);
            String searchtext = DriverAction.getElementText(superAdmin_Locators.searchdata);
            System.out.println(searchtext);
            DriverAction.typeText(superAdmin_Locators.searchfield, "\'" + searchtext + "\'");
        }

        @Then("validate Table Columns")
        public void validate_table_columns() {
            DriverManager.getWebDriver().navigate().refresh();
            ArrayList<String> actgopsheaderdata = new ArrayList<String>();
            ArrayList<String> expgopsheaderdata = new ArrayList<String>();
            DriverAction.click(superAdmin_Locators.gopsEnquiry);
            List<WebElement> list = DriverAction.getElements(superAdmin_Locators.gopsTableHeader);
            actgopsheaderdata.add("Partner Name");
            actgopsheaderdata.add("Product Name");
            actgopsheaderdata.add("Application No.");
            actgopsheaderdata.add("Loan No.");
            actgopsheaderdata.add("PAN No.");
            actgopsheaderdata.add("Mobile No.");
            actgopsheaderdata.add("Policy No.");
            actgopsheaderdata.add("Premium");
            actgopsheaderdata.add("Customer Name");
            actgopsheaderdata.add("Status");
            actgopsheaderdata.add("Action");


            for (WebElement headerdata : list) {
                String data = headerdata.getText();
                System.out.println(data);
                expgopsheaderdata.add(data);

            }
            if (actgopsheaderdata.equals(expgopsheaderdata) == true) {
                System.out.println(" Array List are equal");
                GemTestReporter.addTestStep("GOPS Header Column Valuation", "GOPS Enquiry Header Data Matched", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                System.out.println(" Array List are not equal");
                GemTestReporter.addTestStep("GOPS Header Column Valuation", "GOPS Enquiry Header Data didn't Match", STATUS.FAIL, DriverAction.takeSnapShot());
            }


        }


        @Then("Verify Customer Details Label and Fields.")
        public void verify_customer_details_label_and_fields() {
            DriverAction.click(By.xpath("//table/tbody/tr[2]/td[3]"));
            DriverAction.getElementText(By.xpath("//div/h4[1]"));
            ArrayList<String> actcustheaderdetails = new ArrayList<>();
            ArrayList<String> expcustheaderdetails = new ArrayList<>();
            expcustheaderdetails.add("Name");
            expcustheaderdetails.add("Mobile No.");
            expcustheaderdetails.add("Email");

            for (int i = 2; i <= 4; i++) {
                String text = DriverAction.getElementText(By.xpath("//app-dialog/mat-dialog-content/div/div[2]/div[" + i + "]/span[1]"));
                actcustheaderdetails.add(text);
            }
            if (actcustheaderdetails.equals(expcustheaderdetails)) {
                GemTestReporter.addTestStep("Customer Details", "Customer Details matched", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                System.out.println(" Array List are not equal");
                GemTestReporter.addTestStep("Customer Details", "Customer Details didn't match", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        }

        @Then("Verify POLICY DETAILS Label and Fields.")
        public void verify_policy_details_label_and_fields() {
            String htext = DriverAction.getElementText(By.xpath("(//div//h4)[3]"));
            System.out.println(htext);
            ArrayList<String> actPolicyheaderdetails = new ArrayList<>();
            ArrayList<String> expPolicyheaderdetails = new ArrayList<>();
            actPolicyheaderdetails.add("Sum Assured");
            actPolicyheaderdetails.add("Premium");
            actPolicyheaderdetails.add("Payment Frequency");
            actPolicyheaderdetails.add("Policy Term");
            actPolicyheaderdetails.add("Payment Terms");
            actPolicyheaderdetails.add("Insured Name");
            actPolicyheaderdetails.add("DOB");
            actPolicyheaderdetails.add("Gender");
            for (int i = 11; i <= 18; i++) {
                String text = DriverAction.getElementText(By.xpath("//app-dialog/mat-dialog-content/div/div[2]/div[" + i + "]/span[1]"));

                expPolicyheaderdetails.add(text);

            }
            System.out.println(actPolicyheaderdetails);
            if (actPolicyheaderdetails.equals(expPolicyheaderdetails)) {
                GemTestReporter.addTestStep("Policy DETAILS", "Policy Header Details matched", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Policy DETAILS", "Policy Header Details matched", STATUS.FAIL, DriverAction.takeSnapShot());
            }


            DriverAction.click(By.xpath("(//button)[4]"), "Clicked on Close Button");
        }


        @Then("validate Scroll bar")
        public void validate_scroll_bar() throws AWTException {
            DriverAction.click(superAdmin_Locators.gopsEnquiry);
            DriverAction.click(superAdmin_Locators.gopsTableElement);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);

        }


        @Then("Verfify Customer Details Label and Fields.")
        public void verfify_customer_details_label_and_fields() {
            DriverAction.click(superAdmin_Locators.gopsEnquiry);
            DriverAction.click(superAdmin_Locators.customerheader);
            DriverAction.getElementText(superAdmin_Locators.customerHeaderdetails);
            ArrayList<String> actcustomerdetails = new ArrayList<>();
            ArrayList<String> expcustomerdetails = new ArrayList<>();
            expcustomerdetails.add("Name");
            expcustomerdetails.add("Mobile No.");
            expcustomerdetails.add("Email");

            for (int i = 2; i <= 4; i++) {
                String text = DriverAction.getElementText(By.xpath("//app-dialog/mat-dialog-content/div/div[2]/div[" + i + "]/span[1]"));
                actcustomerdetails.add(text);
            }
            if (expcustomerdetails.equals(actcustomerdetails)) {
                GemTestReporter.addTestStep("Customer Details", "Customer Details matched", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                System.out.println(" Array List are not equal");
                GemTestReporter.addTestStep("Customer Details", "Customer Details didn't match", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        }

        @Then("Verify LOAN DETAILS Label and Fields")
        public void verify_loan_details_label_and_fields() {
            String htext = DriverAction.getElementText(By.xpath("(//div//h4)[2]"));
            System.out.println(htext);
            ArrayList<String> actloandetails = new ArrayList<>();
            ArrayList<String> exploandetails = new ArrayList<>();
            for (int i = 6; i <= 9; i++) {
                String text = DriverAction.getElementText(By.xpath("//app-dialog/mat-dialog-content/div/div[2]/div[" + i + "]/span[1]"));

                actloandetails.add(text);

            }
            System.out.println(actloandetails);
            exploandetails.add("Loan No.");
            exploandetails.add("Loan Amount");
            exploandetails.add("Loan Term");
            exploandetails.add("Loan Disbursement Date");
            if (actloandetails.equals(exploandetails)) {
                GemTestReporter.addTestStep("LOAN Header DETAILS", "Loan Header Details matched", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("LOAN Header DETAILS", "Loan Header Details didn't match", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        }

        @Then("Verfify POLICY DETAILS Label and Fields.")
        public void verfify_policy_details_label_and_fields() {
            String htext = DriverAction.getElementText(By.xpath("(//div//h4)[3]"));
            System.out.println(htext);
            ArrayList<String> acpolicydetails = new ArrayList<>();
            ArrayList<String> expolicydetails = new ArrayList<>();
            expolicydetails.add("Sum Assured");
            expolicydetails.add("Premium");
            expolicydetails.add("Payment Frequency");
            expolicydetails.add("Policy Term");
            expolicydetails.add("Payment Terms");
            expolicydetails.add("Insured Name");
            expolicydetails.add("DOB");
            expolicydetails.add("Gender");
            for (int i = 11; i <= 18; i++) {
                String text = DriverAction.getElementText(By.xpath("//app-dialog/mat-dialog-content/div/div[2]/div[" + i + "]/span[1]"));

                acpolicydetails.add(text);

            }
            if (acpolicydetails.equals(expolicydetails)) {
                GemTestReporter.addTestStep("Policy DETAILS", "Policy Header Details matched", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Policy DETAILS", "Policy Header Details matched", STATUS.FAIL, DriverAction.takeSnapShot());
            }


            DriverAction.click(By.xpath("(//button)[4]"), "Clicked on Close Button");
        }

        @Then("validate pagination of GoPS table")
        public void validate_pagination_of_go_ps_table() {
            DriverManager.getWebDriver().navigate().refresh();
            DriverAction.click(superAdmin_Locators.gopsEnquiry);
            String paginationtext = DriverAction.getElementText(superAdmin_Locators.paginationText);
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 10);
            WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(superAdmin_Locators.paginationRightButton));
            ele.click();
            wait.until(ExpectedConditions.textToBe(superAdmin_Locators.paginationText,"11-20 of 254"));
            String pgtextafclick = DriverAction.getElementText(superAdmin_Locators.paginationText);

            if (paginationtext.equalsIgnoreCase(pgtextafclick )) {
                GemTestReporter.addTestStep("Pagination Validation", "Failed to click on Pagination locator", STATUS.FAIL, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Pagination Validation", "Successfully clicked on Pagination locator", STATUS.PASS, DriverAction.takeSnapShot());
            }


        }

        @Then("verify export to excel button is present.")
        public void verifyExportToExcelButtonIsPresent() {
            DriverManager.getWebDriver().navigate().refresh();
            DriverAction.click(superAdmin_Locators.gopsEnquiry);
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(10));
            WebElement excelbutton = wait.until(ExpectedConditions.elementToBeClickable(superAdmin_Locators.gopsExcelButton));
            excelbutton.click();
            DriverAction.waitSec(10);



        }
    }

