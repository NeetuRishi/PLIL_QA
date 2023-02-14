package com.gemini.PLIL.Locators;

import org.openqa.selenium.By;

public class writeUserLocator {
    public static By searchBox=By.xpath("//input[@placeholder='Search']");
    public static By bulkUploadReport=By.xpath("//a[@href='/dashboard/bulk-upload-reports']");
    public static By typeDropdown= By.xpath("//div/mat-select[@formcontrolname='type']");
    public static By dropdownValue=By.xpath("//span[@class='mat-select-min-line ng-tns-c79-3 ng-star-inserted']");
}
