package com.gemini.PLIL.Locators;

import org.openqa.selenium.By;

public class Locator {

    public static By Email = By.xpath("//input[@placeholder='Email Id']");
    public static By LoginBtn = By.xpath("//span[text()='Login']");
    //span[text()='Login']
    public static By Password = By.xpath("//input[@placeholder='Password']");
    //input[@placeholder='Email Id']
    public static String otp ="(//div[@class='ng-otp-input-wrapper wrapper ng-star-inserted']//input)[itr]";
    public static By invalidotp_error = By.xpath("//small[text()=' The code that you have entered is invalid']");

    public static By Time = By.xpath("//div[@class='mt-2 mb-2']");
    //div[@class='ng-otp-input-wrapper wrapper ng-star-inserted']//input
    public static By Logo = By.xpath("//img");
    public static By Welcome = By.xpath("//h2[contains(text(),'Welcome')]");
    public static By Email_Id = By.xpath("//input[@placeholder='Email Id']");
    public static By Password_Id = By.xpath("//input[@placeholder='Password']");
    public static By RequestOtpBtn = By.xpath("//span[text()='Request OTP']");
    public static By Verification = By.xpath("//h3[text()='Verification']");

    //h3[text()='Verification']
    //public static By Captcha = By.xpath("//*[contains(text(),'not a robot')]");
    public static By Login = By.xpath("//span[contains(text(),'Login')]");
    public static By Click_Here = By.xpath("//a[contains(text(),'Here')]");
    public static By Click_Here_Link = By.xpath("//a");
    public static By Email_Doest_Not_msg = By.xpath("//p[contains(text(),'Email Id')]");

    //p[contains(text(),'Email Id')]

    public static By Forgot_Label = By. xpath("//p[contains(text(),' Forgot Password? Click ')]");
    public static By ForgotPassword_Label = By.xpath("//h3[text()='Forgot Password']");

    public static By Password_Eye_Before_Click = By.xpath("//mat-icon[contains(text(),'visibility_off')]");
    public static By Password_Eye_After_Click = By.xpath("//mat-icon[contains(text(),'visibility')]");
    public static By HomeScreen = By.xpath("//h2[text()='Home']");
    public static By Captcha = By.xpath("//*[@id='recaptcha-anchor']/div[1]");
    public static By Logout = By.xpath(" //span[text()='Logout']");
    public static By Herebtn = By.xpath("//button[text()=' Here']");

    public static By OtpResendMsg = By.xpath("//span[text()='OTP sent successfully']");


    public static String Error = "//mat-error[text()=' Error_msg ']";
    public static By InvalidMailError = By.xpath("//mat-error[text()=' Please enter a valid email address ']");

    public static By Verifybtn = By.xpath("//span[text()='Verify']");

    public static By ForgotPassword_Text = By.xpath("//h3[text()='Forgot Password']");

    //h3[text()='Forgot Password']
    public static By InvalidPassword = By.xpath("//span[text()='Incorrect email or password']");

//mat-error[text()=' Password is required ']
//mat-error[text()=' Email Id is required ']
    //div[@class='recaptcha-checkbox-spinner']

    //h2[text()='Home']

}
