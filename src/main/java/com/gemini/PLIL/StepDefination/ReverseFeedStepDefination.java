package com.gemini.PLIL.StepDefination;
import com.gemini.PLIL.Locators.Locator;
import com.gemini.PLIL.Locators.superAdmin_Locators;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

    public class ReverseFeedStepDefination {

        @Then("click on Captcha,Login")
        public void click_on_captcha_login() {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(30));
            WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            ele.click();
            WebDriverWait newwait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(30));
            newwait.until(ExpectedConditions.titleIs("Group Product"));


        }
        @Then("validate the PLIL Logo")
        public void validate_the_plil_logo() {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(15));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='expandLogo']")));
            boolean isPassed;
            if (DriverAction.getElement(By.xpath("//img[@class='expandLogo']")).isDisplayed()) {
                isPassed = true;
            } else {
                isPassed = false;
            }

            if (isPassed) {
                GemTestReporter.addTestStep("Validate the PLIL logo", "Logo is visible", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validate the PLIL logo", "Logo is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        }


        @Then("validate PLIL tabs")
        public void validate_plil_tabs() {
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
                GemTestReporter.addTestStep("Validation", "UI Elements are visible", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validation", "UI Elements are not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        }


        @Then("validate Reverse tab")
        public void validate_reverse_tab() {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(5));
            WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Reverse Feed')]")));
            ele.click();

            Boolean isPassed = false;
            DriverAction.click(superAdmin_Locators.gopshomeButton);

            if (DriverAction.getElement(superAdmin_Locators.reverseFeedHm).isDisplayed()) isPassed = true;
            else isPassed = false;

            if (isPassed) {
                GemTestReporter.addTestStep("Reverse Feed validation", "Reverse Feed Home Button visible", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Reverse Feed validation", "Reverse Feed Home Button visible is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
            }


        }

        @Then("verify hamburger button on the screen.")
        public void verify_hamburger_button_on_the_screen() {
            Boolean isPassed = false;
            if (DriverAction.getElement(superAdmin_Locators.hamBurgerBtn).isDisplayed())
                isPassed = true;
            else isPassed = false;

            if (isPassed) {
                GemTestReporter.addTestStep("HamBurgerValidation", "Ham Burger is present on Screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("HamBurgerValidation", "Ham Burger is present on Screen", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(10));
            WebElement hamBurgerButton = wait.until(ExpectedConditions.elementToBeClickable(superAdmin_Locators.hamBurgerBtn));
            hamBurgerButton.click();
        }

        @Then("verify filter by label.")
        public void verify_filter_by_label() {
            DriverManager.getWebDriver().navigate().refresh();
            DriverAction.click(superAdmin_Locators.reverseFeedBtn);
            String eString ="Filter by";
            String actualtext = DriverAction.getElementText(superAdmin_Locators.filtersearch);
            Assert.assertEquals(actualtext,eString,"Strings matched");
        }

        @Then("verify Status Field is present and clickable.")
        public void verify_status_field_is_present_and_clickable() {
            DriverManager.getWebDriver().navigate().refresh();
            DriverAction.click(superAdmin_Locators.reverseFeedBtn);
            DriverAction.click(superAdmin_Locators.statusfield);
            DriverAction.click(superAdmin_Locators.statusfieldslct);




        }
        @Then("verify Date Field is present and clickable.")
        public void verify_date_field_is_present_and_clickable() {
            Boolean isPassed = false;

            DriverAction.getElement(superAdmin_Locators.dateButton).isDisplayed();
            if (DriverAction.getElement(superAdmin_Locators.dateButton).isDisplayed())
                isPassed = true;
            else isPassed = false;

            if (isPassed) {
                GemTestReporter.addTestStep("Date field Validation", "Date field is present on Screen", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Date field Validation", "Date field is not  present on Screen", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        }
        @Then("verify user able to select date from calendar.")
        public void verify_user_able_to_select_date_from_calendar() {
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

            DriverAction.click(superAdmin_Locators.gopsEnquiry);
            DriverAction.click(superAdmin_Locators.dateButton);
            DriverAction.click(superAdmin_Locators.yearDropDown);
            DriverAction.click(By.xpath("//div[contains(text(),\'" + currentyear + "\')]"));
            DriverAction.click(By.xpath("//div[contains(text(),\'" + actualmonth + "\')]"));
            DriverAction.click(By.xpath("//div[contains(text(),\'" + currentdate + "\')]"));

        }

        @Then("verify search bar is present and user able to search.")
        public void verify_search_bar_is_present_and_user_able_to_search() {
            String applicationNo = DriverAction.getElementText(superAdmin_Locators.reversefeedsearchbar);
            DriverAction.typeText(superAdmin_Locators.reversefeedsearch,applicationNo);

        }


        @Then("verify Reverse Feed after login check table column names")
        public void verifyReverseFeedAfterLoginCheckTableColumnNames() {
            DriverManager.getWebDriver().navigate().refresh();
            ArrayList<String> expectedreversefeedData = new ArrayList<String>();
            ArrayList<String> actualreversefeedData = new ArrayList<String>();
            DriverAction.click(By.xpath("//span[text()='Reverse Feed']"));
            List<WebElement> reversedatalist = DriverAction.getElements(superAdmin_Locators.gopsTableHeader);

            for (WebElement reversedfeedata : reversedatalist) {
                String reversefeedColumsData = reversedfeedata.getText();
                actualreversefeedData.add(reversefeedColumsData);

            }
            //List<WebElement> list = DriverAction.getElements(superAdmin_Locators.gopsTableHeader);
            expectedreversefeedData.add("Policy No.");
            expectedreversefeedData.add("Partner Name");
            expectedreversefeedData.add("Application No.");
            expectedreversefeedData.add("Loan Account No.");
            expectedreversefeedData.add("COI Number");
            expectedreversefeedData.add("Application Status");
            expectedreversefeedData.add("Description");
            expectedreversefeedData.add("View");

            if (expectedreversefeedData.equals(actualreversefeedData) == true) {
                // System.out.println(" Array List are equal");
                GemTestReporter.addTestStep("Reverse Feed Header Column Valuation", "Reverse Feed Header Data Matched", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                // System.out.println(" Array List are not equal");
                GemTestReporter.addTestStep("Reverse Feed Header Column Valuation", "Reverse Feed Header Data didn't Match", STATUS.FAIL, DriverAction.takeSnapShot());
            }


        }

        @Then("verify eye option is working in View Details  Column.")
        public void verifyEyeOptionIsWorkingInViewDetailsColumn() {
            DriverAction.click(By.xpath("//span[text()='Reverse Feed']"));
            DriverAction.click(By.xpath("(//img[@class='download'])[1]"));
            String viewHeader = DriverAction.getElementText(By.xpath("//app-popup/mat-dialog-content/div/div[1]/div[1]/h2"));
            ArrayList<String>expectedviewHeader = new ArrayList<>();
            ArrayList<String>actualviewHeader = new ArrayList<>();
            List<String>viewHeaderData = DriverAction.getElementsText(By.xpath("//mat-dialog-content/div/div[2]/div/div/table/thead/tr/th"));
            for(String data :viewHeaderData)
            {
                actualviewHeader.add(data);
            }
            expectedviewHeader.add("Date");
            expectedviewHeader.add("Status");
            expectedviewHeader.add("Updated By");
            expectedviewHeader.add("Description");

            if (actualviewHeader.equals(expectedviewHeader) == true) {
                GemTestReporter.addTestStep("View Header Column Valuation", "View Header Column Valuation Data Matched", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("View Header Column Valuation", "View Header Column Valuation Data didn't Match", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        }

        @Then("verify pagination is visible and right & light buttons are working")
        public void verifyPaginationIsVisibleAndRightLightButtonsAreWorking() {
            DriverManager.getWebDriver().navigate().refresh();
            DriverAction.click(By.xpath("//span[text()='Reverse Feed']"));
            String paginationtext = DriverAction.getElementText(superAdmin_Locators.paginationText);
            System.out.println(paginationtext);
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(15));
            WebElement paginationele = wait.until(ExpectedConditions.elementToBeClickable(superAdmin_Locators.paginationRightButton));
            paginationele.click();
            String updatedpaginationtext = DriverAction.getElementText(superAdmin_Locators.paginationText);
            System.out.println(updatedpaginationtext);
            if (paginationtext.equalsIgnoreCase(updatedpaginationtext)) {
                GemTestReporter.addTestStep("Pagination Validation", "Failed to click on Pagination locator", STATUS.FAIL, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Pagination Validation", "Successfully clicked on Pagination locator", STATUS.PASS, DriverAction.takeSnapShot());
            }


        }

        @Then("verify Reverse Feed export to excel button is present")
        public void verifyReverseFeedExportToExcelButtonIsPresent() {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(10));
            WebElement excelbutton = wait.until(ExpectedConditions.elementToBeClickable(superAdmin_Locators.reversefeedExcelButton));
            excelbutton.click();
            GemTestReporter.addTestStep("Excel Button","Successfully clicked on excel",STATUS.PASS,DriverAction.takeSnapShot());
        }
        @Then("verify Logout Button is clickable.")
        public void verifyLogoutButtonIsClickable() {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(20));
            WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='logout']")));
            logout.click();


        }


    }
