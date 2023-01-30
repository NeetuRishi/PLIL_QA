package com.gemini.PLIL.Locators;

import org.openqa.selenium.By;

public class Locator {

    public static By Email_Input_Field = By.xpath("//input[@placeholder='Email Id']");
    public static By Confirm_Password_Field = By.xpath("//input[@formcontrolname='confirmPassword']");
    public static By New_Password_Field = By.xpath("//input[@formcontrolname='password']");
    public static By SetNewPassword_btn = By.xpath("//span[text()='Set Password']");
    public static By Password_Updated_Label = By.xpath("//div[text()='Password Updated']");
    public static By Login_Link = By.xpath("//a");
    public static By Tick_img = By.xpath("//img");
    public static By LoginBtn = By.xpath("//span[text()='Login']");
    public static By Password_Input_Field = By.xpath("//input[@placeholder='Password']");

    public static String otp ="(//div[@class='ng-otp-input-wrapper wrapper ng-star-inserted']//input)[itr]";
    public static By invalidotp_error = By.xpath("//small[text()=' The code that you have entered is invalid']");

    public static By Time = By.xpath("//div[@class='mt-2 mb-2']");
    //div[@class='ng-otp-input-wrapper wrapper ng-star-inserted']//input
    public static By Logo = By.xpath("//img");
    public static By Welcome_Label = By.xpath("//h2[contains(text(),'Welcome')]");
    public static By Email_Id = By.xpath("//input[@placeholder='Email Id']");
    public static By Password_Id = By.xpath("//input[@placeholder='Password']");
    public static By confirmpassword = By.xpath(" //input[@placeholder='Confirm Password']");
    public static By New_Password_Created = By.xpath(" //div[text()='Password Created']");
    public static By set_passwordbtn = By.xpath(" //button[text()='Set Password ']");
    public static By RequestOtpBtn = By.xpath("//span[text()='Request OTP']");
    public static By Verification = By.xpath("//h3[text()='Verification']");
    public static By Login = By.xpath("//span[contains(text(),'Login')]");
    public static By Click_Here = By.xpath("//a[contains(text(),'Here')]");
    public static By Click_Here_Link = By.xpath("//a");
    public static By Email_Doest_Not_msg = By.xpath("//p[contains(text(),'Email Id')]");
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
    public static String dropdown_val = "//span[text()='val']";
    public static String sub_tab = "//span[text()='tab']";
    public static String inputbox = "//input[@formcontrolname='input_name']";
    public static String dropdown = "(//div[contains(@class,'mat-select-value')])[itr]";
    public static String FirstRow = "(//table[contains(@class,'mat-table cdk-table')]/tbody/tr/td)[itr]";
    public static By Createbtn = By.xpath("//button[text()=' Create User ']");
    public static By InvalidMailError = By.xpath("//mat-error[text()=' Please enter a valid email address ']");
    public static By Verifybtn = By.xpath("//span[text()='Verify']");
    public static By setnewpassword_label = By.xpath("//h3[text()='Set New Password']");
    public static By ForgotPassword_Text = By.xpath("//h3[text()='Forgot Password']");
    public static By InvalidPassword_msg = By.xpath("//span[text()='Incorrect email or password']");

}
