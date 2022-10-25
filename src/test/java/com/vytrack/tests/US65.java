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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class US65 {
    /**
     * As a user, I want to view columns on the Vehicle models page.(web-table)
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
         * Description: manager has access the Vehicle models
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         *      Login as store and sales managers
         *      Click the Vehicle Model under the Fleet
         *      Verify managers see 10 columns in the web-table
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehiclesModelUnderFleet.click();

        vyTrackProject.modelNameBtn.isDisplayed();

        List<String> expected = new ArrayList<>(Arrays.asList("MODEL NAME", "MAKE", "CAN BE REQUESTED", "CVVI", "CO2 FEE (/MONTH)",
                "COST (DEPRECIATED)", "TOTAL COST (DEPRECIATED)", "CO2 EMISSIONS", "FUEL TYPE", "VENDORS"));

        List<WebElement> list = (vyTrackProject.vehicleModelsColumn);
        System.out.println("10 columns are Displayed");
        System.out.println("========================");

        for (int i = 1; i < 11; i++) {
            System.out.println(i + ". " + list.get(i - 1).getText() + " --> " + list.get(i - 1).isDisplayed());
            Assert.assertEquals(list.get(i - 1).getText(), expected.get(i - 1));
        }

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
        vyTrackProject.vehiclesModelUnderFleet.click();
        vyTrackProject.modelNameBtn.isDisplayed();

        List<String> expected = new ArrayList<>(Arrays.asList("MODEL NAME", "MAKE", "CAN BE REQUESTED", "CVVI", "CO2 FEE (/MONTH)",
                "COST (DEPRECIATED)", "TOTAL COST (DEPRECIATED)", "CO2 EMISSIONS", "FUEL TYPE", "VENDORS"));

        List<WebElement> list = new ArrayList<>(vyTrackProject.vehicleModelsColumn);
        System.out.println("10 columns are Displayed");
        System.out.println("========================");

        for (int i = 1; i < 11; i++) {
            System.out.println(i + ". " + list.get(i - 1).getText() + " --> " + list.get(i - 1).isDisplayed());
            Assert.assertEquals(list.get(i - 1).getText(), expected.get(i - 1));
        }
    }

    @Test (priority = 3)
    public void TC2_Driver() {
        /**
         * Test cases #2
         * Description: Drivers can NOT access the Vehicle models page
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Login as store and sales managers
         * Click the Vehicle Model under the Fleet
         * Verify the drivers see the error message “You do not have permission to perform this action.”
         *
         * BUG REPORT - USER AS A DRIVER SHOULD NOT BE ACCESS TO VEHICLES MODELS PAGE
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtnAsDriver.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehiclesModelUnderFleetDriver.click();

        Assert.assertFalse(false, "Verify the drivers see the error message “You do not have permission to perform this action.");
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}


/*
//        vyTrackProject.makeBtn.isDisplayed();
//        vyTrackProject.canBeRequestedBtn.isDisplayed();
//        vyTrackProject.cvviBtn.isDisplayed();
//        vyTrackProject.co2FeeBtn.isDisplayed();
//        vyTrackProject.costDepreciatedBtn.isDisplayed();
//        vyTrackProject.totalCostDepreciated.isDisplayed();
//        vyTrackProject.emissionsBtn.isDisplayed();
//        vyTrackProject.fuelTypeBtn.isDisplayed();
//        vyTrackProject.vendorsBtn.isDisplayed();


        WebElement test1 = Driver.getDriver().findElement(By.xpath("//span[.='Model Name']"));
        WebElement test2 = Driver.getDriver().findElement(By.xpath("//span[.='Make']"));
        WebElement test3 = Driver.getDriver().findElement(By.xpath("//span[.='Can be requested']"));
        WebElement test4 = Driver.getDriver().findElement(By.xpath("//span[.='CVVI']"));
        WebElement test5 = Driver.getDriver().findElement(By.xpath("//span[.='CO2 Fee (/month)']"));
        WebElement test6 = Driver.getDriver().findElement(By.xpath("//span[.='Cost (Depreciated)']"));
        WebElement test7 = Driver.getDriver().findElement(By.xpath("//span[.='Total Cost (Depreciated)']"));
        WebElement test8 = Driver.getDriver().findElement(By.xpath("//span[.='CO2 Emissions']"));
        WebElement test9 = Driver.getDriver().findElement(By.xpath("//span[.='Fuel Type']"));
        WebElement test10 = Driver.getDriver().findElement(By.xpath("//span[.='Vendors']"));
 */
