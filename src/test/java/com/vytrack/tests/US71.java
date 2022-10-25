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

public class US71 {
    /**
     * As a user, I want to view car odometer info on the Vehicles Odometers page.
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
         * Description:  manager can NOT access the Vehicle Odometer
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Log in as store or sales managers
         * Click the “Vehicle Odometers” under the Fleet
         * Verify the managers see “You do not have permission to perform this action.”
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehicleOdometerUnderFleet.click();

        System.out.println(vyTrackProject.vehicleOdometerErrMsg.getText());
        Assert.assertEquals(vyTrackProject.vehicleOdometerErrMsg.getText(),"You do not have permission to perform this action.","FAILED!");
    }

    @Test (priority = 2)
    public void TC1_Salesmanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehicleOdometerUnderFleet.click();

        System.out.println(vyTrackProject.vehicleOdometerErrMsg.getText());
        Assert.assertEquals(vyTrackProject.vehicleOdometerErrMsg.getText(),"You do not have permission to perform this action.","FAILED!");
    }

    @Test (priority = 3)
    public void TC2_Driver() {
        /**
         * Test cases #2
         * Description:  Drivers should see the default page number as 1
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Log in as drivers
         * Click the “Vehicle Odometers” under the Fleet
         * Verify the default page number is 1
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtnAsDriver.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehicleOdometerUnderFleet.click();

        Assert.assertTrue(vyTrackProject.verify1OnVehicleOdometerPage.isDisplayed(),"The default page number is 1 - FAILED!");
        System.out.println("The default page number is 1 - " + vyTrackProject.verify1OnVehicleOdometerPage.isDisplayed());
    }

    @Test (priority = 4)
    public void T3_Driver() {
        /**
         * Test cases #3
         * Description:   Divers should see the View Per Page is 25 by default.
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Log in as drivers
         * Click the “Vehicle Odometers” under the Fleet
         * Verify the default view per page is 25
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtnAsDriver.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehicleOdometerUnderFleet.click();

        Assert.assertTrue(vyTrackProject.verify25OnVehicleOdometerPage.isDisplayed(),"The default page number is 1 - FAILED!");
        System.out.println("The default view per page is 25 - " + vyTrackProject.verify25OnVehicleOdometerPage.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
