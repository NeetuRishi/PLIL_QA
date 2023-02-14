package com.gemini.PLIL.Locators;

import org.openqa.selenium.By;

public class GopsUser_Locators {
public static By homeTab= By.xpath("//h2[text()='Home']");
public static By PLIL_logo=By.xpath("//*[@class='expandLogo']");
public static By hamburgerButton=By.xpath("//*[@class='fa fa-bars']");
public static By UploadButton=By.xpath("//button[text()=' Upload ']");
public static By clickHere=By.xpath("//p/button[text()=' Click here']");
    public static By selectValue(String text){

        return By.xpath("//*[text()='"+text+"']");
    }
    public static By error=By.xpath("//mat-error");

    public static By chooseFile=By.xpath("//input[@formcontrolname='fileUpload']");
    public static By tabName(String t)
    {
        return By.xpath("//li[@class='nav-item ng-star-inserted']["+t+"]");
    }
public static By card1=By.xpath("//div[@class='navigateIcon']//following::span[1]");
    public static By card2=By.xpath("//div[@class='navigateIcon']//following::span[3]");
public static By GopsTab=By.xpath("//li[@class='nav-item ng-star-inserted'][2]");
public static By ReverseFeedUpload=By.xpath("//li[@class='nav-item ng-star-inserted'][1]");
public static   By checkTabNames=By.xpath("//span[@class='navLinkExpand animated fadeInRight']");
public static By partnerDropdown=By.xpath("//div/mat-select[@formcontrolname='partner']");
public static By dropdownMenu(String index){return By.xpath("//div[@role='listbox']/mat-option["+index+"]");}
public static By statusDropdown=By.xpath("//div/mat-select[@formcontrolname='status']");
public static By partnerNameDropdown=By.xpath("//div/mat-select[@formcontrolname='partnerId']");
public static By inputBoxText(String text)
{
    return By.xpath("//span[text()='"+text+"']");
}
public static By searchBox=By.xpath("//input[@class='form-control']");


}
