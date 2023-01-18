package com.gemini.PLIL.Locators;

import org.openqa.selenium.By;

public class Locator {

    public static By Email = By.xpath("//input[@placeholder='Email Id']");
    public static By LoginBtn = By.xpath("//span[text()='Login']");
    //span[text()='Login']
    public static By Password = By.xpath("//input[@placeholder='Password']");
    //input[@placeholder='Email Id']


    public static By Logo = By.xpath("//img");
    public static By Welcome = By.xpath("//h2[contains(text(),'Welcome')]");
    public static By Email_Id = By.xpath("//input[@placeholder='Email Id']");
    public static By Password_Id = By.xpath("//input[@placeholder='Password']");

    //public static By Captcha = By.xpath("//*[contains(text(),'not a robot')]");
    public static By Login = By.xpath("//span[contains(text(),'Login')]");
    public static By Click_Here = By.xpath("//a[contains(text(),'Here')]");
    public static By Forgot_Label = By. xpath("//p[contains(text(),' Forgot Password? Click ')]");
    public static By Password_Eye_Before_Click = By.xpath("//mat-icon[contains(text(),'visibility_off')]");
    public static By Password_Eye_After_Click = By.xpath("//mat-icon[contains(text(),'visibility')]");
    public static By HomeScreen = By.xpath("//h2[text()='Home']");
    public static By Captcha = By.xpath("//*[@id='recaptcha-anchor']/div[1]");
    public static By Logout = By.xpath(" //span[text()='Logout']");


    //div[@class='recaptcha-checkbox-spinner']

    //h2[text()='Home']

}
