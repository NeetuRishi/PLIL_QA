package com.gemini.PLIL.Locators;

import org.openqa.selenium.By;

public class Read_Locators {

    public static String Side_bar_tab = "(//div[@class='sideBar']//a)[itr]";

    public static   String Read_tab = "//h2[text()='tab']";

    public static By side_bar_collapse = By.xpath("//span[@class='navLinkCollepse']");

    public static By side_bar_expand = By.xpath("//span[@class='navLinkExpand animated fadeInRight']");
    public static By hamburgerbtn = By.xpath("//i");
    public static   String ui_data = "(//h3)[itr]";
    public static By Enquiry_card = By.xpath("//div[@class='navigateIcon']//span[text()='Enquiry']");
    public static By Report_card = By.xpath("//div[@class='navigateIcon']//span[text()='Report']");
    public static By Enquirytab = By.xpath("//span[text()='Enquiry']//parent::a[contains(@class,'nav-link')]");
    //span[text()='Enquiry']//parent::a[contains(@class,'nav-link')]
    //h2[text()='Enquiry']
    public static By EnquiryLabel = By.xpath("//h2[text()='Enquiry']");
    public static By FilterByLabel = By.xpath("//label[text()='Filter by']");
//div[@class='cdk-overlay-pane']
public static By FilterByDropdownValues = By.xpath("//div[@class='cdk-overlay-pane']");
public static By FilterByDropdownText = By.xpath("//mat-label[text()='Status']");
    public static By FilterByDropdownicon = By.xpath("//div[contains(@class,'mat-form-field-flex')]");
    public static By dateButton = By.xpath("//mat-datepicker-toggle/button");
    public static By yearDropDown= By.xpath("(//span[@class='mat-button-wrapper'])[2]");
    public static By Startdate = By.xpath("//span[@class='mat-date-range-input-mirror']");
    public static By Exportbtn = By.xpath("//button[text()=' Export']");
    //button[text()=' Export']
    //input[@placeholder='Start date']

    //mat-label[text()='Status']
    //div[contains(@class,'mat-form-field-flex')]
}

