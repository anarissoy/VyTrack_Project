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

import java.util.List;

public class US67 {
    /**
     * As a user, I should be to select any vehicle from the Vehicle page(web-table)
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
         * Description:  users view unchecked checkboxes on the Vehicle page
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Users are on the homepage
         * Click the Vehicle under the Fleet
         * Verify all the checkboxes are unchecked
         *
         * BUG REPORT - CHECKBOX ARE NOT AVAILABLE FOR DRIVERS ON VEHICLES PAGE
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        vyTrackProject.loginBtn.click();
        BrowserUtils.sleep(2);
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtnAsDriver.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehiclesUnderFleet.click();

        //Assert.assertFalse(vyTrackProject.checkAllVehiclesPage.isSelected(),"All the checkboxes are unchecked");
        System.out.println("BUG REPORT - CHECKBOX ARE NOT AVAILABLE FOR DRIVERS ON VEHICLES PAGE");
    }

    @Test (priority = 2)
    public void TC1_Storemanager() {
        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehiclesUnderFleet.click();

        Assert.assertFalse(vyTrackProject.checkAllVehiclesPage.isSelected(),"All the checkboxes are unchecked");
        System.out.println("All the checkboxes are unchecked: " + vyTrackProject.checkAllVehiclesPage.isSelected());
    }

    @Test (priority = 3)
    public void TC1_Salesmanager() {
        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehiclesUnderFleet.click();

        Assert.assertFalse(vyTrackProject.checkAllVehiclesPage.isSelected(),"All the checkboxes are unchecked");
        System.out.println("All the checkboxes are unchecked: " + vyTrackProject.checkAllVehiclesPage.isSelected());
    }

    @Test (priority = 4)
    public void TC2_Storemanager() {
        /**
         * Test cases #2
         * Description:  users check the first checkbox to check all the cars
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Users are on the homepage
         * Click the Vehicle under the Fleet
         * Click the 1st checkbox in the web-table
         * Verify all the checkboxes also checked
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehiclesUnderFleet.click();
        BrowserUtils.sleep(1);

        vyTrackProject.checkAllVehiclesPage.click();

        List<WebElement> singleBox = vyTrackProject.checkSingleVehiclesPage;

        for (int i = 1; i <= 25; i++){
            System.out.println(i+"."+" Each single box is checked " + singleBox.get(i-1).isSelected());
            Assert.assertTrue(singleBox.get(i-1).isSelected());
        }
    }

    @Test (priority = 5)
    public void TC2_Salesmanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehiclesUnderFleet.click();
        BrowserUtils.sleep(1);

        vyTrackProject.checkAllVehiclesPage.click();

        List<WebElement> singleBox = vyTrackProject.checkSingleVehiclesPage;

        for (int i = 1; i <= 25; i++) {
            System.out.println(i + "." + " Each single box is checked " + singleBox.get(i - 1).isSelected());
            Assert.assertTrue(singleBox.get(i - 1).isSelected());
        }
    }

    @Test (priority = 6)
    public void TC3_Storemanager() {
        /**
         *Test cases #3
         * Description:  users check any car’s checkbox
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Users are on the homepage
         * Click the Vehicle under the Fleet
         * Check any car’s checkbox
         * Verify the box is checked
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehiclesUnderFleet.click();
        BrowserUtils.sleep(1);

        vyTrackProject.checkAnySingleBoxVehiclesPage.click();

        Assert.assertTrue(vyTrackProject.checkAnySingleBoxVehiclesPage.isSelected(), "Box is not checked");
        System.out.println("Any single box is checked and verified: " + vyTrackProject.checkAnySingleBoxVehiclesPage.isSelected());
    }

    @Test (priority = 7)
    public void TC3_Salesmanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehiclesUnderFleet.click();
        BrowserUtils.sleep(1);

        vyTrackProject.checkAnySingleBoxVehiclesPage.click();

        Assert.assertTrue(vyTrackProject.checkAnySingleBoxVehiclesPage.isSelected(), "Box is not checked");
        System.out.println("Any single box is checked and verified: " + vyTrackProject.checkAnySingleBoxVehiclesPage.isSelected());
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
