package com.vytrack.tests;

import com.github.javafaker.Faker;
import com.vytrack.pages.VyTrackProject;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class US62 {
    /**
     * As a user, I should be accessed to the Oroinc Documentation page. (Window handle)
     */

    VyTrackProject vyTrackProject;
    Faker faker;

    @BeforeMethod
    public void setUp() {

        vyTrackProject = new VyTrackProject();
        faker = new Faker();
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }

    @Test (priority = 1)
    public void TC1_Driver() {
        /**
         * Test cases #1
         * Description: users access the Oronic Documentation page
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Users are on the homepage
         * Click the question icon on the right top of the homepage
         * Verify the users access to the Oronic Documentation page
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("driver1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.questionOnTop.click();

        Set<String> allWindows = Driver.getDriver().getWindowHandles();

        for (String each : allWindows) {
            Driver.getDriver().switchTo().window(each);
            System.out.println(each);
        }

        String actual = Driver.getDriver().getTitle();
        System.out.println("Actual: " + actual);

        Assert.assertEquals(actual, "Welcome to Oro Documentation");
    }

    @Test (priority = 2)
    public void TC1_Storemanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.questionOnTop.click();

        Set<String> allWindows = Driver.getDriver().getWindowHandles();

        for (String each : allWindows) {
            Driver.getDriver().switchTo().window(each);
            System.out.println(each);
        }

        String actual = Driver.getDriver().getTitle();
        System.out.println("Actual: " + actual);

        Assert.assertEquals(actual, "Welcome to Oro Documentation");
    }

    @Test (priority = 3)
    public void TC1_Salesmanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("salesmanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.questionOnTop.click();

        Set<String> allWindows = Driver.getDriver().getWindowHandles();

        for (String each : allWindows) {
            Driver.getDriver().switchTo().window(each);
            System.out.println(each);
        }

        String actual = Driver.getDriver().getTitle();
        System.out.println("Actual: " + actual);

        Assert.assertEquals(actual, "Welcome to Oro Documentation");
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
