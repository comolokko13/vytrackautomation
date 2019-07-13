package com.vytrack.tests.smoke_tests;

import com.vytrack.tests.pages.DriverHomepage;
import com.vytrack.tests.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MenuOptionsTestAsDriver {


    LoginPage loginPage;
    DriverHomepage driverHomepage;

    @BeforeMethod
    public void setUp(){

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @Test
    public void verify_vehicles_page_title() throws InterruptedException {
        loginPage = new LoginPage();
        driverHomepage = new DriverHomepage();
        loginPage.login(ConfigurationReader.getProperty("driver_user_name"),ConfigurationReader.getProperty("default_password"));
        BrowserUtils.waitForClickablility(driverHomepage.fleetModul,5);
        driverHomepage.fleetModul.click();
        driverHomepage.vehiclesLink.click();
        BrowserUtils.waitForPageTitle("Car - Entities - System - Car - Entities - System");
        BrowserUtils.verifyPageTitle("Car - Entities - System - Car - Entities - System");
        Assert.assertEquals("Cars", driverHomepage.pageName.getText());
    }
    @Test
    public void verify_accounts_page_title() throws InterruptedException {
        loginPage = new LoginPage();
        driverHomepage = new DriverHomepage();
        loginPage.login(ConfigurationReader.getProperty("driver_user_name"),ConfigurationReader.getProperty("default_password"));
        BrowserUtils.waitForClickablility(driverHomepage.customerModul,5);
        driverHomepage.customerModul.click();
        driverHomepage.accountsLink.click();
        BrowserUtils.waitForPageTitle("Accounts - Customers");
        Assert.assertEquals("Accounts", driverHomepage.pageName.getText());

        BrowserUtils.verifyPageTitle("Accounts - Customers");
    }
    @Test
    public void verify_contacts_page_title() throws InterruptedException {
        loginPage = new LoginPage();
        driverHomepage = new DriverHomepage();
        loginPage.login(ConfigurationReader.getProperty("driver_user_name"),ConfigurationReader.getProperty("default_password"));
        BrowserUtils.waitForClickablility(driverHomepage.customerModul,5);
        driverHomepage.customerModul.click();
        driverHomepage.contactsLink.click();
        BrowserUtils.waitForPageTitle("Contacts - Customers");
        BrowserUtils.verifyPageTitle("Contacts - Customers");
        Assert.assertEquals("Contacts", driverHomepage.pageName.getText());
    }
    @Test
    public void verify_calendar_page_title() throws InterruptedException {
        loginPage = new LoginPage();
        driverHomepage = new DriverHomepage();
        loginPage.login(ConfigurationReader.getProperty("driver_user_name"),ConfigurationReader.getProperty("default_password"));
        BrowserUtils.waitForClickablility(driverHomepage.activitiesModul,5);
        driverHomepage.activitiesModul.click();
        driverHomepage.calendarLink.click();
        BrowserUtils.waitForPageTitle("Calendar Events - Activities");
        BrowserUtils.verifyPageTitle("Calendar Events - Activities");
        Assert.assertEquals("Calendar Events", driverHomepage.pageName.getText());
    }

    @AfterMethod

    public void teardown(){
        System.out.println("****** In After Method tear down *********");
        System.out.println("Removing driver instance from current thread and closing all sesions");
        Driver.closeDriver();
    }






}
