package com.vytrack.tests.components.login_navigation;

import com.vytrack.tests.pages.DriverHomepage;
import com.vytrack.tests.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTestNegative {


    @BeforeMethod
    public void setUp(){

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }
    @Test
    public void loginTestWithInvalidPassword() throws InterruptedException {


        LoginPage loginPage = new LoginPage();
        DriverHomepage driverHomepage = new DriverHomepage();

        loginPage.login(ConfigurationReader.getProperty("store_manager_user_name"),ConfigurationReader.getProperty("default_password") + "abc");

        Assert.assertTrue(loginPage.allertMessage.isDisplayed(),"Alert Message didn't displayed!!!");
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("****** In After Method tear down *********");
        System.out.println("Removing driver instance from current thread and closing all sesions");
        Driver.closeDriver();
    }


}
