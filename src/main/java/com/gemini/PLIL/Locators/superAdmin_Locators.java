package com.gemini.PLIL.Locators;

import org.openqa.selenium.By;

public class superAdmin_Locators {


    // Home Screen Locators
    public static By Home_Label =By.xpath("//h2[@class='header']");
    public static By Name_Label = By.xpath("//label[contains(text(),'Name')]");
    public static By Name_Value = By.xpath("//div[1]/h3");
    public static By Email_Label = By.xpath("//label[contains(text(),'Email')]");
    public static By Email_Value = By.xpath("//div[2]/h3");
    public static By Mobile_Label = By.xpath("//label[contains(text(),'Mobile')]");
    public static By Mobile_Value = By.xpath("//div[3]/h3");

    public static By Logout_Image = By.xpath("//span[@class='logout']/img");
    public static By Logout_btn = By.xpath("//span[contains(text(),'Logout')]");
    public static By Navigate_to_Label = By.xpath("//div/h4[text()='Navigate to']");

    public static By Roles_Card= By.xpath("//div/span[contains(text(),'Roles')]");
    public static By Roles_Card_Img = By.xpath("//div[@class='row user-navigate']/div[1]/div/span[1]");
    public static By Roles_Card_Angle = By.xpath("//div[@class='row user-navigate']/div[1]/div/i");

    public static By Master_Management_Card = By.xpath("//div/span[contains(text(),'Master Management')]");
    public static By Master_Management_Card_Img = By.xpath("//div[@class='row user-navigate']/div[2]/div/span[1]");
    public static By Master_Management_Card_Angle = By.xpath("//div[@class='row user-navigate']/div[2]/div/i");

    public static By Partner_Product_Card = By.xpath("//div/span[contains(text(),'Partner Product')]");
    public static By Partner_Product_Card_Img = By.xpath("//div[@class='row user-navigate']/div[3]/div/span[1]");
    public static By Partner_Product_Card_Angle = By.xpath("//div[@class='row user-navigate']/div[3]/div/i");

    public static By User_Management_Card = By.xpath("//div/span[contains(text(),'User')]");
    public static By User_Management_Card_Img = By.xpath("//div[@class='row user-navigate']/div[4]/div/span[1]");
    public static By User_Management_Card_Angle = By.xpath("//div[@class='row user-navigate']/div[4]/div/i");

    public static By Partner_Management_Card = By.xpath("//div/span[contains(text(),'Partner Management')]");
    public static By Partner_Management_Card_Img = By.xpath("//div[@class='row user-navigate']/div[5]/div/span[1]");
    public static By Partner_Management_Card_Angle = By.xpath("//div[@class='row user-navigate']/div[5]/div/i");

    public static By Gops_Enquiry_Card = By.xpath("//div/span[contains(text(),'Gops Enquiry')]");
    public static By Gops_Enquiry_Card_Img = By.xpath("//div[@class='row user-navigate']/div[6]/div/span[1]");
    public static By Gops_Enquiry_Card_Angle = By.xpath("//div[@class='row user-navigate']/div[6]/div/i");

    public static By Reverse_Feed_Card = By.xpath("//div/span[contains(text(),'Reverse Feed')]");
    public static By Reverse_Feed_Card_Img = By.xpath("//div[@class='row user-navigate']/div[7]/div/span[1]");
    public static By Reverse_Feed_Card_Angle = By.xpath("//div[@class='row user-navigate']/div[7]/div/i");

    public static By Generate_Ig_File_Card = By.xpath("//div/span[contains(text(),'Generate Ig File')]");
    public static By Generate_Ig_File_Card_Img = By.xpath("//div[@class='row user-navigate']/div[8]/div/span[1]");
    public static By Generate_Ig_File_Card_Angle = By.xpath("//div[@class='row user-navigate']/div[8]/div/i");


    // Side Navigation Super Admin Locators

    public static By SideBar_Logo = By.xpath("//img[@class='expandLogo']");
    public static By Home_Tab = By.xpath("//div[@class='sideBar']/ul/li[1]");
    public static By Roles_Tab = By.xpath("//div[@class='sideBar']/ul/li[2]");
    public static By Master_Management_Tab = By.xpath("//div[@class='sideBar']/ul/li[3]");
    public static By Partner_Product_Tab = By.xpath("//div[@class='sideBar']/ul/li[4]");
    public static By User_Management_Tab = By.xpath("//div[@class='sideBar']/ul/li[5]");
    public static By Partner_Management_Tab = By.xpath("//div[@class='sideBar']/ul/li[6]");
    public static By GOPS_Enquiry_Tab = By.xpath("//div[@class='sideBar']/ul/li[7]");
    public static By Reverse_Feed_Tab = By.xpath("//div[@class='sideBar']/ul/li[8]");
    public static By Generate_IG_File_Tab = By.xpath("//div[@class='sideBar']/ul/li[9]");
    public static By Hamburger = By.xpath("//i[@class = 'fa fa-bars']");
    public static By Logout_Btn = By.xpath("//span[text()='Logout']");

    // Partner Product Screen Locators

    public static By Partner_Product_Tab_Highlighted = By.xpath("//a[@class='nav-link active']");
    public static By Label_Partner_Product =By.xpath("//h2[contains(text(),'Partner Product')]");
    public static By Partner_Name = By.xpath("//table[@class='mat-table cdk-table']/thead/tr/th[1]");
    public static By Product_Name = By.xpath("//table[@class='mat-table cdk-table']/thead/tr/th[2]");
    public static By Policy_No = By.xpath("//table[@class='mat-table cdk-table']/thead/tr/th[3]");
    public static By Plan_No = By.xpath("//table[@class='mat-table cdk-table']/thead/tr/th[4]");
    public static By Type = By.xpath("//table[@class='mat-table cdk-table']/thead/tr/th[5]");
    public static By Created_On = By.xpath("//table[@class='mat-table cdk-table']/thead/tr/th[6]");
    public static By Action = By.xpath("//table[@class='mat-table cdk-table']/thead/tr/th[7]");
    public static By Pagination = By.xpath("//div[@class='pageOf']");
    public static By Pagination_Angle_Left = By.xpath("//span[@class='angle-left']");
    public static By Pagination_Angle_Right = By.xpath("//span[@class='angle-right']");
    public static By Create_Partner_Product_Button = By.xpath("//button[contains(text(),'Partner Product')]");
    public static By eye_button = By.xpath("//table/tbody/tr[1]/td[7]/div/i");
    public static By edit_button = By.xpath("//table/tbody/tr[4]/td[7]/div/span");
    public  static By update_partner_product_btn = By.xpath("//button[contains(text(),'Update Partner Product')]");

    // Create Partner Product Locators

    public static By Label_Create_Partner_Product = By.xpath("//h2[contains(text(),'Create Partner Product')]");
    public static By Text_Line_Create_Partner_Product = By.xpath("//p[contains(text(),'User details')]");
    public static By Select_Partner_DropDown = By.xpath("//*[@formcontrolname='partner']");
    public static By Select_Partner_Value = By.xpath("//*[@role='listbox']/mat-option[1]");
    public static By Select_Product_DropDown = By.xpath("//*[@formcontrolname='product']");
    public static By Select_Product_Value = By.xpath("//*[@role='listbox']/mat-option[2]");
    public static By Label_Medical_Questions = By.xpath("//h2[contains(text(),'Medical Questions')]");
    public static By Select_Medical_Questions = By.xpath("//mat-card[@formarrayname='medicalQues']/mat-card-content/div[2]/div/span[1]");
    public static By Label_Covid_Questions = By.xpath("//h2[contains(text(),'Covid Questions')]");
    public static By Select_Covid_Questions = By.xpath("//mat-card[@formarrayname='covidQues']/mat-card-content/div[2]/div/span[1]");

    public static By Discard_Button = By.xpath("//button[text()='Discard']");
    public static By Create_Partner_Product_Btn = By.xpath("//button[text()=' Create Partner Product ']");

    // Partner Management Locators

    public static By Hamburger_Partner_Management = By.xpath("//i[@class = 'fa fa-bars']");
    public static By Label_Partner_Management =By.xpath("//h2[contains(text(),'Partner Management')]");
    public static By Name_Partner_Management = By.xpath("//table[@class='mat-table cdk-table mat-sort']/thead/tr/th[1]");
    public static By Prefix_Partner_Management = By.xpath("//table[@class='mat-table cdk-table mat-sort']/thead/tr/th[2]");
    public static By Created_On_Partner_Management = By.xpath("//table[@class='mat-table cdk-table mat-sort']/thead/tr/th[3]");
    public static By Action_Partner_Management = By.xpath("//table[@class='mat-table cdk-table mat-sort']/thead/tr/th[4]");
    public static By Pagination_Partner_Management = By.xpath("//div[@class='pageOf']");
    public static By Pagination_Angle_Left_Partner_Management = By.xpath("//span[@class='angle-left']");
    public static By Pagination_Angle_Right_Partner_Management = By.xpath("//span[@class='angle-right']");

    public static By Create_Partner_Button_Partner_Management = By.xpath("//button[contains(text(),'Create Partner')]");
    public static By edit_Partner_Management = By.xpath("//tbody/tr[1]/td[4]/div/i");
    public static By Label_Update_Partner = By.xpath("//h2[contains(text(),'Update Partner')]");
    public static By Text_Line_Update_Partner = By.xpath("//p[contains(text(),'partner details')]");
    public static By Update_Partner_Name_Field = By.xpath("//input[@placeholder='Partner Name']");
    public static By Update_Prefix_Uneditable = By.xpath("//input[@placeholder='Prefix']");
    public static By Update_Partner_Button = By.xpath("//button[text()='Update Partner']");
    public static By Discard_Update_Partner_Button = By.xpath("//button[text()='Discard']");

    // Create Partner Locators

    public static By Label_Create_Partner = By.xpath("//h2[contains(text(),'Create Partner')]");
    public static By Text_Line_Create_Partner = By.xpath("//p[contains(text(),'partner details')]");
    public static By Enter_Partner_Name= By.xpath("//*[@placeholder='Partner Name']");
    public static By Enter_Partner_Prefix = By.xpath("//*[@placeholder='Prefix']");
    public static By Discard_Create_Partner_Button = By.xpath("//button[text()='Discard']");
    public static By Create_Partner_Btn = By.xpath("//button[text()='Create Partner']");

    public static By Salutation_Label = By.xpath("//h2[text()='Salutation']");

    public static String Salutation_Col = "(//table[@class='mat-table cdk-table mat-sort']/thead/tr/th/div)[itr]";


    public static By Salutation_Card = By.xpath("//span[text()='Salutation']");

    public static By Create_btn = By.xpath("//button[text()=' Create ']");

    public static By value_inp = By.xpath("//div[contains(@class,'mat-form-field-infix ng-tns')]//input");
    public static By code_inp = By.xpath("(//div[contains(@class,'mat-form-field-infix ng-tns')]//input)[2]");

    //div[contains(@class,'mat-form-field-infix ng-tns')]//input
    public static String Salutation_Column = "(//table[@class='mat-table cdk-table mat-sort']/tbody/tr/td)[itr]";



    //button[text()=' Create ']



}
