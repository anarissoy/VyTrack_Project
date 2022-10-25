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

public class US61 {
    /***
     * As a user, I should be accessing all the main modules of the app.
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
    public void TC1_Storemanager() {
        /**
         * Test cases #1
         * Description: Managers access to main modules
         * Environment: https://qa2.vytrack.com/user/login
         * Steps: 1. login as a salesmanager or storemanagers
         *        2. Verify the users see 8 modules: Dashboards, Fleet, Customers, Sales, Activities, Marketing,
         *           Reports & Segments, System
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        BrowserUtils.verifyTitle(Driver.getDriver(),"Dashboard");

        Assert.assertTrue(vyTrackProject.dashboardsBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.dashboardsBtn.isDisplayed());
        Assert.assertTrue(vyTrackProject.fleetBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.fleetBtn.isDisplayed());
        Assert.assertTrue(vyTrackProject.customersBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.customersBtn.isDisplayed());
        Assert.assertTrue(vyTrackProject.salesBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.salesBtn.isDisplayed());
        Assert.assertTrue(vyTrackProject.activitiesBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.activitiesBtn.isDisplayed());
        Assert.assertTrue(vyTrackProject.marketingBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.marketingBtn.isDisplayed());
        Assert.assertTrue(vyTrackProject.reportAndSegmentsBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.reportAndSegmentsBtn.isDisplayed());
        Assert.assertTrue(vyTrackProject.systemBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.systemBtn.isDisplayed());
    }

    @Test (priority = 2)
    public void TC1_Salesmanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        BrowserUtils.verifyTitle(Driver.getDriver(),"Dashboard");

        Assert.assertTrue(vyTrackProject.dashboardsBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.dashboardsBtn.isDisplayed());
        Assert.assertTrue(vyTrackProject.fleetBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.fleetBtn.isDisplayed());
        Assert.assertTrue(vyTrackProject.customersBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.customersBtn.isDisplayed());
        Assert.assertTrue(vyTrackProject.salesBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.salesBtn.isDisplayed());
        Assert.assertTrue(vyTrackProject.activitiesBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.activitiesBtn.isDisplayed());
        Assert.assertTrue(vyTrackProject.marketingBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.marketingBtn.isDisplayed());
        Assert.assertTrue(vyTrackProject.reportAndSegmentsBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.reportAndSegmentsBtn.isDisplayed());
        Assert.assertTrue(vyTrackProject.systemBtn.isDisplayed());
        System.out.println("Dashboards is displayed: " + vyTrackProject.systemBtn.isDisplayed());
    }

    @Test (priority = 3)
    public void TC2_Driver() {
        /**
         * Test cases #2
         * Description: Drivers access to main modules
         * Environment:  https://qa2.vytrack.com/user/login
         * Steps:: 1. login as a driver
         *         2. Verify the users see 4 modules: Fleet, Customers, Activities, System
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        BrowserUtils.verifyTitle(Driver.getDriver(),"Dashboard");
        
        Assert.assertTrue(vyTrackProject.fleetBtnAsDriver.isDisplayed());
        System.out.println("Fleet is displayed: " + vyTrackProject.fleetBtnAsDriver.isDisplayed());
        Assert.assertTrue(vyTrackProject.customersBtnAsDriver.isDisplayed());
        System.out.println("Customers is displayed: " + vyTrackProject.customersBtnAsDriver.isDisplayed());
        Assert.assertTrue(vyTrackProject.activitiesBtnAsDriver.isDisplayed());
        System.out.println("Activities is displayed: " + vyTrackProject.activitiesBtnAsDriver.isDisplayed());
        Assert.assertTrue(vyTrackProject.systemBtnAsDriver.isDisplayed());
        System.out.println("System is displayed: " + vyTrackProject.systemBtnAsDriver.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
