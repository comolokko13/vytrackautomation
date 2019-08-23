package com.vytrack.tests.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "prependedInput")
    public WebElement userNameTextbox;
    @FindBy(id = "prependedInput2")
    public WebElement passwordTextbox;
    @FindBy(id = "_submit")
    public WebElement loginButton;
    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement allertMessage;




    public void login(String userName,String password){

        userNameTextbox.sendKeys(userName);
        passwordTextbox.sendKeys(password);
        loginButton.click();

    }
}
