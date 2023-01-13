package com.gemini.PLIL.Locators;

import org.openqa.selenium.By;

public class Locator {
    public static By Email = By.xpath("//input[@placeholder='Email Id']");
    public static By LoginBtn = By.xpath("//span[text()='Login']");
    //span[text()='Login']
    public static By Password = By.xpath("//input[@placeholder='Password']");
    //input[@placeholder='Email Id']
}
