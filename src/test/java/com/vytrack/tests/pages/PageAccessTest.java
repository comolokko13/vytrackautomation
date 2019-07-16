package com.vytrack.tests.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PageAccessTest {


    @BeforeMethod
    public void setUp() {

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @Test
    public void verifyAccesToConstactsPageAsAStoreManager() {


        LoginPage loginPage = new LoginPage();

        DriverHomepage driverHomepage = new DriverHomepage();

        loginPage.login(ConfigurationReader.getProperty("store_manager_user_name"), ConfigurationReader.getProperty("default_password"));

        BrowserUtils.clickWithJS( driverHomepage.fleetModul);
        System.out.println("Clicked to Fleet Modul");
        BrowserUtils.clickWithJS(  driverHomepage.vehicleContacts);
        BrowserUtils.waitForPageTitle("All - Vehicle Contract - Entities - System - Car - Entities - System");
        BrowserUtils.verifyPageTitle("All - Vehicle Contract - Entities - System - Car - Entities - System");


    }

    @Test
    public void verifyAccesToConstactsPageAsASalesManager() {


        LoginPage loginPage = new LoginPage();

        DriverHomepage driverHomepage = new DriverHomepage();

        loginPage.login(ConfigurationReader.getProperty("sales_manager_user_name"), ConfigurationReader.getProperty("default_password"));

        BrowserUtils.clickWithJS( driverHomepage.fleetModul);
        System.out.println("Clicked to Fleet Modul");
        BrowserUtils.clickWithJS(  driverHomepage.vehicleContacts);
        BrowserUtils.waitForPageTitle("All - Vehicle Contract - Entities - System - Car - Entities - System");
        BrowserUtils.verifyPageTitle("All - Vehicle Contract - Entities - System - Car - Entities - System");


    }
    @Test
    public void verifyAccesToConstactsPageAsADriver() {


        LoginPage loginPage = new LoginPage();

        DriverHomepage driverHomepage = new DriverHomepage();

        loginPage.login(ConfigurationReader.getProperty("driver_user_name"), ConfigurationReader.getProperty("default_password"));

        BrowserUtils.clickWithJS( driverHomepage.fleetModul);
        System.out.println("Clicked to Fleet Modul");
        BrowserUtils.clickWithJS(  driverHomepage.vehicleContacts);
        Assert.assertTrue(driverHomepage.permisssionAlert.isDisplayed());


    }


    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("****** In After Method tear down *********");
        System.out.println("Removing driver instance from current thread and closing all sesions");
        Driver.closeDriver();
    }
}