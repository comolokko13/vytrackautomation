package com.vytrack.tests.smoke_tests;

import com.vytrack.tests.pages.DriverHomepage;
import com.vytrack.tests.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MenuOptionsTestAsStoreManager {

    LoginPage loginPage;
    DriverHomepage driverHomepage;

    @BeforeMethod
    public void setUp(){

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }
    @Test
    public void verify_dashboard_page_title() {
        loginPage = new LoginPage();
        driverHomepage = new DriverHomepage();
        loginPage.login(ConfigurationReader.getProperty("store_manager_user_name"),ConfigurationReader.getProperty("default_password"));
        BrowserUtils.clickWithJS(driverHomepage.dashboardModul);
        BrowserUtils.clickWithJS(driverHomepage.dashboardPage);
        BrowserUtils.waitForPageTitle("Dashboard");
        Assert.assertEquals("Dashboard", driverHomepage.pageName.getText());
       BrowserUtils.verifyPageTitle("Dashboard");
    }
    @Test
    public void verify_vehicles_page_title() {
        loginPage = new LoginPage();
        driverHomepage = new DriverHomepage();
        loginPage.login(ConfigurationReader.getProperty("store_manager_user_name"),ConfigurationReader.getProperty("default_password"));
        BrowserUtils.waitForClickablility(driverHomepage.fleetModul,5);
        BrowserUtils.clickWithJS(driverHomepage.fleetModul);
        BrowserUtils.clickWithJS(driverHomepage.vehiclesLink);
        BrowserUtils.waitForPageTitle("Car - Entities - System - Car - Entities - System");
        BrowserUtils.verifyPageTitle("Car - Entities - System - Car - Entities - System");
        Assert.assertEquals("Cars", driverHomepage.pageName.getText());

    }

    @Test
    public void verify_accounts_page_title() {
        loginPage = new LoginPage();
        driverHomepage = new DriverHomepage();
        loginPage.login(ConfigurationReader.getProperty("store_manager_user_name"),ConfigurationReader.getProperty("default_password"));
        BrowserUtils.waitForClickablility(driverHomepage.customerModul,5);
        BrowserUtils.clickWithJS(driverHomepage.customerModul);
        BrowserUtils.clickWithJS(driverHomepage.accountsLink);
        BrowserUtils.waitForPageTitle("Accounts - Customers");
        Assert.assertEquals("Accounts", driverHomepage.pageName.getText());
        BrowserUtils.verifyPageTitle("Accounts - Customers");

    }

    @Test
    public void verify_contacts_page_title() {
        loginPage = new LoginPage();
        driverHomepage = new DriverHomepage();
        loginPage.login(ConfigurationReader.getProperty("store_manager_user_name"),ConfigurationReader.getProperty("default_password"));
        BrowserUtils.waitForClickablility(driverHomepage.customerModul,5);
        BrowserUtils.clickWithJS(driverHomepage.customerModul);
        BrowserUtils.clickWithJS(driverHomepage.contactsLink);
        BrowserUtils.waitForPageTitle("Contacts - Customers");
        BrowserUtils.verifyPageTitle("Contacts - Customers");
        Assert.assertEquals("Contacts", driverHomepage.pageName.getText());

    }

    @Test
    public void verify_sales_page_title() {
        loginPage = new LoginPage();
        driverHomepage = new DriverHomepage();
        loginPage.login(ConfigurationReader.getProperty("store_manager_user_name"),ConfigurationReader.getProperty("default_password"));
        BrowserUtils.waitForClickablility(driverHomepage.salesModul,5);
        BrowserUtils.clickWithJS(driverHomepage.salesModul);
        BrowserUtils.clickWithJS(driverHomepage.opportunitiesPage);
        BrowserUtils.waitForPageTitle("Open Opportunities - Opportunities - Sales");
        BrowserUtils.verifyPageTitle("Open Opportunities - Opportunities - Sales");
        Assert.assertEquals("Open Opportunities", driverHomepage.pageName.getText());

    }

    @Test
    public void verify_calls_page_title() {
        loginPage = new LoginPage();
        driverHomepage = new DriverHomepage();
        loginPage.login(ConfigurationReader.getProperty("store_manager_user_name"),ConfigurationReader.getProperty("default_password"));
        BrowserUtils.waitForClickablility(driverHomepage.activitiesModul,5);
        BrowserUtils.clickWithJS(driverHomepage.activitiesModul);
        BrowserUtils.clickWithJS(driverHomepage.callsPage);
        BrowserUtils.waitForPageTitle("All - Calls - Activities");
        BrowserUtils.verifyPageTitle("All - Calls - Activities");
        Assert.assertEquals("All Calls", driverHomepage.pageName.getText());

    }
    @Test
    public void verify_calender_page_title() {
        loginPage = new LoginPage();
        driverHomepage = new DriverHomepage();
        loginPage.login(ConfigurationReader.getProperty("store_manager_user_name"),ConfigurationReader.getProperty("default_password"));
        BrowserUtils.waitForClickablility(driverHomepage.activitiesModul,5);
        BrowserUtils.clickWithJS(driverHomepage.activitiesModul);
        BrowserUtils.clickWithJS(driverHomepage.calendarLink);
        BrowserUtils.waitForPageTitle("All - Calendar Events - Activities");
        BrowserUtils.verifyPageTitle("All - Calendar Events - Activities");
        Assert.assertEquals("All\n" + "                        Calendar Events", driverHomepage.pageName.getText());

    }
    @AfterMethod

    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("****** In After Method tear down *********");
        System.out.println("Removing driver instance from current thread and closing all sesions");
        Driver.closeDriver();
    }

}
