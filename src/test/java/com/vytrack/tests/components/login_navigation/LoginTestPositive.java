package com.vytrack.tests.components.login_navigation;

import com.vytrack.tests.pages.DriverHomepage;
import com.vytrack.tests.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTestPositive {


    @BeforeMethod
    public void setUp(){

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }



    @Test
    public void storeManegerLoginTestPos() {
        System.out.println("Store Manager Logs ");
        LoginPage loginPage = new LoginPage();
        DriverHomepage driverHomepage = new DriverHomepage();
        //1. Login	to	Vytrack	as	a	store	manager
        System.out.println("1. Login\tto\tVytrack\tas\ta\tstore\tmanager");

        loginPage.login(ConfigurationReader.getProperty("store_manager_user_name"),ConfigurationReader.getProperty("default_password"));
        //2. Verify	name	of	the	store	manager is	displayed	on	top	right
        System.out.println("Verify\tname\tof\tthe\tstore\tmanager is\tdisplayed\ton\ttop\tright");
        Driver.getDriver().findElement(By.xpath("")) ;
        String nameExpected = "Angie Hessel";
        Boolean isContains = nameExpected.contains(driverHomepage.nameOnTheLeft.getText()) ;
        System.out.println(nameExpected  + " === "  +driverHomepage.nameOnTheLeft.getText());
        Assert.assertTrue(isContains);

        //3. Verify	Dashboad	page	is	open
        System.out.println("Verify\tDashboad\tpage\tis\topen");

        BrowserUtils.verifyPageTitle("Dashboard");
        System.out.println("Log\tout");

        //4. Log	out

        BrowserUtils.clickWithJS(Driver.getDriver().findElement(By.xpath("//li[@id='user-menu']/a")));
        BrowserUtils.clickWithJS(Driver.getDriver().findElement(By.xpath("//a[text()='Logout']")));



        //5. Login	to	Vytrack	as	a	sales manager
        System.out.println("Login\tto\tVytrack\tas\ta\tsales manager");

        loginPage.login(ConfigurationReader.getProperty("store_manager_user_name"),ConfigurationReader.getProperty("default_password"));
        //6. Verify	Dashboad	page	is	open
        System.out.println(" Verify\tDashboad\tpage\tis\topen");

        BrowserUtils.verifyPageTitle("Dashboard");
       //7. A	different	name	should	be	displayed	on	top	right
        System.out.println("A\tdifferent\tname\tshould\tbe\tdisplayed\ton\ttop\tright");

        nameExpected = "Angie Hessel";
         isContains = nameExpected.contains(driverHomepage.nameOnTheLeft.getText()) ;
        System.out.println(driverHomepage.nameOnTheLeft.getText() + "=====????" + nameExpected);
        Assert.assertTrue(isContains);
        //8. Log	out
        System.out.println("Log\tout");
        BrowserUtils.clickWithJS(Driver.getDriver().findElement(By.xpath("//li[@id='user-menu']/a")));
        BrowserUtils.clickWithJS(Driver.getDriver().findElement(By.xpath("//a[text()='Logout']")));
        //9. Login	to	Vytrack	as	a	driver
        System.out.println("Login\tto\tVytrack\tas\ta\tdriver");

        loginPage.login(ConfigurationReader.getProperty("driver_user_name"),ConfigurationReader.getProperty("default_password"));
        //10. Verify	Dashboad/Quick	Launchpad page	is	open
        System.out.println("Verify\tDashboad/Quick\tLaunchpad page\tis\topen");

        BrowserUtils.verifyPageTitle("Dashboard");
        //11. A	different	name	should	be	displayed	on	top	right
        System.out.println("A\tdifferent\tname\tshould\tbe\tdisplayed\ton\ttop\tright");

        nameExpected = "Margot Huels";
        isContains = nameExpected.contains(driverHomepage.nameOnTheLeft.getText()) ;
        Assert.assertTrue(isContains);



    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("****** In After Method tear down *********");
        System.out.println("Removing driver instance from current thread and closing all sesions");
        Driver.closeDriver();
    }


}
