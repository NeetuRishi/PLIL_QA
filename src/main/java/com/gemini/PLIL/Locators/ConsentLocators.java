package com.gemini.PLIL.Locators;

import org.openqa.selenium.By;

public class ConsentLocators {
    public static By heading=By.xpath("//*[@class='bs-stepper-header']");
    public static By subheadings=By.xpath("//div[@class='mb-3 header d-flex align-items-center']");
public static By checkMandatoryFieldsError=By.xpath("//*[@class='cdk-overlay-container']");
public static By primaryIssuedHeight=By.xpath("//input[@formcontrolname='heightOfPrimaryInsured']");
public static By primaryIssuedWeight=By.xpath("//input[@formcontrolname='weightOfPrimaryInsured']");
public static By jointLifeHeight=By.xpath("//input[@formcontrolname='heightOfJointLife']");
public static By jointLifeWeight=By.xpath("//input[@formcontrolname='weightOfJointLife']");
public static By medicalQuestions=By.xpath("//span[text()='*']");
public static By firstYesRadio=By.xpath("//mat-radio-button[@class='mat-radio-button distance mat-accent'][1]");
public static By allEnabledNoOptions=By.xpath("//input[@tabindex='0']");
public static By CheckBoxPage2=By.xpath("//mat-checkbox[@id='mat-checkbox-1']");
public static By checkBoxPage3=By.xpath("//mat-checkbox[@id='mat-checkbox-2']");
public static By allNoOptions=By.xpath("//input[@value='false']");
public static By reasonsPI=By.xpath("//input[@id='mat-input-15']");
    public static By reasonsJL=By.xpath("//input[@id='mat-input-16']");
    public static By errorLine=By.xpath("//div[@class='pt-3']/div");
    public static By autofilledTitle=By.xpath("//div[@class='col-5 col-title']");
    public static By autofilledValue=By.xpath("//div[@class=\"col-7 col-value\"]");
//    public static By checkBoxPage4=By.xpath("//input[@id='mat-checkbox-3-input']");
    public static By proceed1=By.xpath("(//*[text()='Proceed'])[1]");
    public static By proceed2=By.xpath("(//*[text()='Proceed'])[2]");
    public static By proceed3=By.xpath("(//*[text()='Proceed'])[3]");
    public static By checkBoxPage4=By.xpath("//mat-checkbox[@id='mat-checkbox-3']");
    public static By YesRadioButtons=By.xpath("//mat-radio-button[@ng-reflect-value='true']");
    public static By yesInput=By.xpath("//input[@value='true']");
    public static By illnessInjury(int i) {
      return   By.xpath("(//input[@placeholder=\"Illness, Injury or Tests\"])["+(i)+"]");
    }

    public static By quantity(int i)
    {
        return By.xpath("(//input[@placeholder=\"Quantity\"])["+(i)+"]");
    }
    public static By title=By.xpath("//div[@class='title pt-1']");
     public static By otpInputBox=By.xpath("//mat-dialog-container//input");
    public static By typeOfTreatment(int i){return By.xpath("(//input[@placeholder=\"Type Of Treatment\"])["+(i)+"]");}
    public static By datedCommenced(int i){return By.xpath("(//input[@placeholder=\"DD/MM/YYYY\"])["+(i)+"]");}
    public static By currentCondition(int i){ return By.xpath("(//input[@placeholder=\"Current Condition\"])["+i+"]");}
    public static By durationOfIllness(int i) {return By.xpath("(//input[@placeholder=\"Duration of Illness/Injury\"])["+i+"]");}
    public static By dateOfLastSymptoms(int i) { return By.xpath("(//input[@placeholder=\"DD/MM/YYYY\"])["+(i)+"]");}
    public static By address(int i){ return By.xpath("(//input[@placeholder=\"Full Name and Address of Doctor or Hospital (If any)\"])["+i+"]");}
}
