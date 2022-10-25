package com.vytrack.tests;

import com.github.javafaker.Faker;
import com.vytrack.pages.VyTrackProject;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US64 {
    /**
     * As a user, I want to access to Vehicle contracts page
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
         * Description: Managers access the Vehicle contracts page
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Login as store or salesmanager
         * Click the Vehicle contracts under the Fleet
         * Verify managers can access the Vehicle contracts page
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtn.click();

        vyTrackProject.vehicleContractsBtn.click();

        Assert.assertTrue(vyTrackProject.verifyAllVehicleContractPage.isDisplayed());
        System.out.println("All Vehicle Contract Page is displayed: " + vyTrackProject.verifyAllVehicleContractPage.isDisplayed());
        System.out.println(vyTrackProject.verifyAllVehicleContractPage.getText());
    }

    @Test (priority = 2)
    public void TC1_Salesmanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtn.click();

        vyTrackProject.vehicleContractsBtn.click();

        Assert.assertTrue(vyTrackProject.verifyAllVehicleContractPage.isDisplayed());
        System.out.println("All Vehicle Contract Page is displayed: " + vyTrackProject.verifyAllVehicleContractPage.isDisplayed());
        System.out.println(vyTrackProject.verifyAllVehicleContractPage.getText());
    }

    @Test (priority = 3)
    public void TC2_Driver() {
        /**
         * Test cases #2
         * Description: Drivers can NOT access the Vehicle contracts page
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Login as drivers
         * Click the Vehicle contracts under the Fleet
         * Verify users see an error message: “You do not have permission to perform this action.”
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtnAsDriver.click();

        vyTrackProject.vehicleContractsBtn.click();

        Assert.assertTrue(vyTrackProject.vehicleContractsBtnAsDriver.isDisplayed());
        System.out.println("All Vehicle Contract Page is not displayed: " + vyTrackProject.vehicleContractsBtnAsDriver.isDisplayed());
        System.out.println(vyTrackProject.vehicleContractsBtnAsDriver.getText());
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
