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
    public static By MasterManagementtab = By.xpath("//span[text()='Master Management']//parent::a[contains(@class,'nav-link')]");

    //span[text()='Master Management']//parent::a[contains(@class,'nav-link')]
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

    public static By CUSTOMER_DETAILS_Label  = By.xpath("//h4[text()='CUSTOMER DETAILS']");

    public static By Name_Col_Customer_Details  = By.xpath("//span[text()='Name ']");

    public static By Mobile_No_Col_Customer_Details  = By.xpath("//span[text()='Mobile No. ']");

    public static By Email_Col_Customer_Details  = By.xpath("//span[text()='Email ']");

    public static By Loan_Details_Label  = By.xpath("//h4[text()='LOAN DETAILS']");

    public static By Loan_Col_Loan_Details  = By.xpath("//span[text()='Loan No.']");

    public static By Loan_Amount_Col_Loan_Details  = By.xpath("//span[text()='Loan Amount ']");

    public static By Loan_Term_Col_Loan_Details  = By.xpath("//span[text()='Loan Term']");

    public static By Loan_Disbursement_Col_Loan_Details  = By.xpath("//span[text()='Loan Disbursement Date']");
    public static By Policy_Details  = By.xpath("//h4[text()='POLICY DETAILS']");
    public static By Sum_Assured  = By.xpath("//span[text()='Sum Assured']");
    public static By Premium  = By.xpath("//span[text()='Premium']");
    public static By Payment_Frequency  = By.xpath("//span[text()='Payment Frequency']");
    public static By Policy_Term  = By.xpath("//span[text()='Policy Term']");
    public static By Policy_Terms  = By.xpath("//span[text()='Payment Terms']");
    public static String Enquiry_Tab_Col = "//table[@class='mat-table cdk-table mat-sort custom']/thead/tr/th[itr]";

    public static String ApplicationStatusCol = "(//table[@class='mat-table cdk-table']/thead/tr/th)[itr]";
    public static String rows = "(//table[@class='mat-table cdk-table mat-sort custom']/tbody/tr)";

    public static String StatusCol = "(//table[@class='mat-table cdk-table mat-sort custom']/tbody/tr)[itr]//td[9]";
    public static String Action = "(//table[@class='mat-table cdk-table mat-sort custom']/tbody/tr)[itr]//td[10]//img";
 //   (//table[@class='mat-table cdk-table mat-sort custom']/tbody/tr)[10]//td[10]

    //(//table[@class='mat-table cdk-table mat-sort custom']/tbody/tr)[10]//td[9]


    public static By Pagination = By.xpath("//div[@class='paginator']//span");

    public static By Cross_Icon_Application_Popup= By.xpath("//button[@class='close']//img");
    //button[@class='close']//img
    public static By Action_Download_icon = By.xpath("(//img[@class='download ng-star-inserted'])[7]");

    public static By Application_No = By.xpath("(//table[@class='mat-table cdk-table mat-sort custom']/tbody/tr/td)[2]");
    public static By SampleLoanNo  = By.xpath("(//table[@class='mat-table cdk-table mat-sort custom']/tbody/tr/td)[3]");

    public static By ApplicationStatusIcon  = By.xpath("(//table[@class='mat-table cdk-table mat-sort custom']/tbody/tr/td)//img");
    public static String ApplicationStatusNo = "//h2[text()='Application Status - @status']";

//h2[text()='Application Status - @status']

    public static String Application_Label = "//h2[text()='Application Details - no']";
    public static By Gender  = By.xpath("//span[text()='Gender']");

    public static By DOB  = By.xpath("//span[text()='DOB']");
    public static By Insured_Name  = By.xpath("//span[text()='Insured Name']");

    public static By ReportTab = By.xpath("//span[text()='Report']//parent::a[contains(@class,'nav-link')]");

    //span[text()='Rejected Case']//parent::a[contains(@class,'nav-link')]
    public static By RejectedTab = By.xpath("//span[text()='Rejected Case']//parent::a[contains(@class,'nav-link')]");
    public static By ReversedFeedTab = By.xpath("//span[text()='Reverse Feed']//parent::a[contains(@class,'nav-link')]");

    //label[text()='Filter by']
    public static By SampleDate1  = By.xpath("//div[text()=' 8 ']");
    public static By SearchInput  = By.xpath("//input[@placeholder='Search']");

    //input[@placeholder='Search']


    public static By FilterByLable  = By.xpath("//label[text()='Filter by']");
    public static By RejectedLabel  = By.xpath("//h2[text()='Rejected Case']");

    public static By ReversedFeedLabel  = By.xpath("//h2[text()='Reverse Feed Enquiry']");

    public static By Status_Dropdown  = By.xpath("//div[contains(@class,'mat-select-arrow-wrapper')]");
    //div[contains(@class,'mat-select-arrow-wrapper')]

    //h2[text()='Reverse Feed Enquiry']
    public static By StatusLabel  = By.xpath("//mat-label[text()='Status']");

    public static By Clearbtn  = By.xpath("//button[text()='Clear']");

    //button[text()='Clear']
    public static By StatusDropdownDiv  = By.xpath("//div[@class='cdk-overlay-pane']");
    //div[@class='cdk-overlay-pane']

    public static By Generate_Label  = By.xpath("//h2[text()='Generate']");


    public static By Wip_Report_Tab  = By.xpath("//span[text()='WIP Report']");

    public static By IIB_Report_Tab  = By.xpath("//span[text()='IIB Report']");

    public static By Wip_Report_RightArrow  = By.xpath("//span[text()='IIB Report']");

    public static By IIB_Report_RightArrow  = By.xpath("//i[@class='fa fa-angle-right']");

    public static By Download_Report_Button  = By.xpath("//button[text()='Download Report']");

    public static By Wip_Report_Tab_Label  = By.xpath("//p[text()='Select Date Range to generate WIP report.']");

    public static By Calendar_icon  = By.xpath("//button//span[@class='mat-button-wrapper']");

    public static By Send_Via_Email_btn  = By.xpath("//button[text()='Send Via Email']");

    public static By Download_Report_Validate  = By.xpath("//button[text()='Download Report']");
    public static By Calendar_left_arrow_icon  = By.xpath("//button[@class='mat-focus-indicator mat-calendar-previous-button mat-icon-button mat-button-base']");
    public static By SampleDate  = By.xpath("//div[text()=' 2 ']");

    public static By send_email_popup  = By.xpath("//span[text()='Report sent Via Email..']");

    //div[@class='pageOf']

    //span[text()='Report sent Via Email..']


    //button[text()='Send Via Email']

    //p[text()='Select Date Range to generate WIP report.']



    //i[@class='fa fa-angle-right']



    //span[text()='IIB Report']
    //span[text()='WIP Report']
    //h2[text()='Generate']


//span[text()='Gender']


}

