package com.gemini.PLIL.Locators;

import org.openqa.selenium.By;

public class AdminLocators {
    public static By userManagement(String tab)
    {
        return By.xpath("//h2[text()='User Management']");

    }
    public static By input(String input)
    {
        return By.xpath("//input[@placeholder='"+input+"']");
    }
 public static By roleDropdown=By.xpath("//div/mat-select[@formcontrolname='role']");
    public static By roleDropdownMenu(String dropdownValue) {
        return By.xpath("//div[@role='listbox']/mat-option/span[text()='" + dropdownValue + "']");
    }
public static By emailValue=By.xpath("//table/tbody/tr[1]/td[2]");
    public static By emailAlreadyTaken=By.xpath("//span[text()='Email already taken']");
    public static By resetPassword=By.xpath("//img[@class='ml-1'][1]");
}
