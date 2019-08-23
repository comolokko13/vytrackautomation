package com.vytrack.tests.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='#']//span[contains(text(),'Fleet')]")
    public WebElement fleetModul;
    @FindBy(xpath = "//a[@href='#']//span[contains(text(),'Customer')]")
    public WebElement customerModul;
    @FindBy(xpath = "//a[@href='#']//span[contains(text(),'Activities')]")
    public  WebElement activitiesModul;
    @FindBy(xpath = "//a[@href='#']//span[contains(text(),'Dashboard')]")
    public WebElement dashboardModul ;
    @FindBy(xpath = "//a[@href='#']//span[contains(text(),'Sales')]")
    public WebElement salesModul;


    @FindBy(xpath = "//span[text()='Vehicles']")
    public  WebElement vehiclesLink;
    @FindBy(xpath = "//span[text()='Accounts']")
    public  WebElement accountsLink;
    @FindBy(xpath = "//span[text()='Contacts']")
    public  WebElement contactsLink;
    @FindBy(xpath = "//span[text()='Calendar Events']")
    public  WebElement calendarLink;
    @FindBy(xpath = "//span[text()='Dashboard']")
    public WebElement dashboardPage;
    @FindBy(xpath = "//span[text()='Opportunities']")
    public WebElement opportunitiesPage;
    @FindBy(xpath = "//span[text()='Calls']")
    public WebElement callsPage;
    @FindBy(xpath = "//span[text()='Vehicle Contracts']")
    public WebElement vehicleContacts;
}
