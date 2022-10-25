package com.vytrack.tests;

import com.github.javafaker.Faker;
import com.vytrack.pages.VyTrackProject;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US66 {
    /**
     * As a user, I want to see edit car info icons from the Vehicle page.
     */

    VyTrackProject vyTrackProject;
    Faker faker;

    @BeforeMethod
    public void setUp() {

        vyTrackProject = new VyTrackProject();
        faker = new Faker();
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }

    @Test (priority = 2)
    public void TC1_Storemanager() {
        /**
         * Test cases #1
         * Description: users see the car edited options on the Vehicle page
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Users are on the homepage
         * Click the Vehicles under the Fleet
         * Verify any car info has 3 dots “...”, and there are “view, edit, delete” icons.
         */


        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehiclesUnderFleet.click();
        BrowserUtils.sleep(2);

        vyTrackProject.threeDot.click();

        Assert.assertTrue(vyTrackProject.threeDotVerify.isDisplayed());
        System.out.println(vyTrackProject.threeDotVerify.getText());
    }

    @Test (priority = 3)
    public void TC1_Salesmanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("salesmanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehiclesUnderFleet.click();
        BrowserUtils.sleep(2);

        vyTrackProject.threeDot.click();

        Assert.assertTrue(vyTrackProject.threeDotVerify.isDisplayed());
        System.out.println(vyTrackProject.threeDotVerify.getText());

    }

    @Test (priority = 1)
    public void TC1_Driver() {
        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("driver1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtnAsDriver.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehiclesUnderFleet.click();
        BrowserUtils.sleep(2);

        vyTrackProject.threeDot.click();

        Assert.assertTrue(vyTrackProject.threeDotVerify.isDisplayed());
        System.out.println(vyTrackProject.threeDotVerify.getText());
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
