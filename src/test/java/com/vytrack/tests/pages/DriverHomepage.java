package com.vytrack.tests.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DriverHomepage extends  BasePage{

    public DriverHomepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//div[contains(text(),'You do not have permission to perform this action.')]")
    public WebElement permisssionAlert;



    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement pageName;

    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement nameOnTheLeft;

    @FindBy(xpath = "//a[text()='Logout']")
    public  WebElement logoutButton;


}
