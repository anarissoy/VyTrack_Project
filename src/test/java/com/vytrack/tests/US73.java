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
import java.util.List;

public class US73 {
    /**
     * As a user, I want to manage filters on the Vehicle Costs page. (Web-table and checkbox)
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
         * Description: users see 3 columns on the Vehicle Model page
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Users are on the homepage
         * Click the Vehicle Costs under the Fleet
         * Verify there are 3 columns on the table:
         *  Expected Column names: TYPE, TOTAL PRICE, DATE
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtnAsDriver.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehicleCostsUnderFleet.click();

        List<WebElement> actualLinks = new ArrayList<>(Arrays.asList(vyTrackProject.verifyType, vyTrackProject.verifyTotalPrice, vyTrackProject.verifyDate));
        List<String> expectedLinks = new ArrayList<>(Arrays.asList("TYPE", "TOTAL PRICE", "DATE"));

        List<String> list = new ArrayList<>();
        for(int i = 0; i<3; i++){
            list.add(actualLinks.get(i).getText());
            Assert.assertEquals(actualLinks.get(i).getText(),expectedLinks.get(i),"FAILED");
        }
        System.out.println(list);
        System.out.println(expectedLinks);
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
        vyTrackProject.vehicleCostsUnderFleet.click();

        List<WebElement> actualLinks = new ArrayList<>(Arrays.asList(vyTrackProject.verifyType, vyTrackProject.verifyTotalPrice, vyTrackProject.verifyDate));
        List<String> expectedLinks = new ArrayList<>(Arrays.asList("TYPE", "TOTAL PRICE", "DATE"));

        List<String> list = new ArrayList<>();
        for(int i = 0; i<3; i++){
            list.add(actualLinks.get(i).getText());
            Assert.assertEquals(actualLinks.get(i).getText(),expectedLinks.get(i),"FAILED");
        }
        System.out.println(list);
        System.out.println(expectedLinks);
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
        vyTrackProject.vehicleCostsUnderFleet.click();

        List<WebElement> actualLinks = new ArrayList<>(Arrays.asList(vyTrackProject.verifyType, vyTrackProject.verifyTotalPrice, vyTrackProject.verifyDate));
        List<String> expectedLinks = new ArrayList<>(Arrays.asList("TYPE", "TOTAL PRICE", "DATE"));

        List<String> list = new ArrayList<>();
        for(int i = 0; i<3; i++){
            list.add(actualLinks.get(i).getText());
            Assert.assertEquals(actualLinks.get(i).getText(),expectedLinks.get(i),"FAILED");
        }
        System.out.println(list);
        System.out.println(expectedLinks);
    }

    @Test (priority = 4)
    public void TC2_Driver() {
        /**
         * Test cases #2
         * Description: users select all the vehicle costs
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Users are on the homepage
         * Click the Vehicle Costs under the Fleet
         * Click the first checkbox
         * Verify all the vehicle costs are checked
         *
         * BUG REPORT - All the vehicle costs are checked is FAILED for Driver Account
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtnAsDriver.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehicleCostsUnderFleet.click();

        System.out.println("BUG REPORT - All the vehicle costs are checked is FAILED for Driver account");
    }

    @Test (priority = 5)
    public void TC2_Storemanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehicleCostsUnderFleet.click();

        vyTrackProject.checkAllVehiclesPage.click();

        for (int i = 1; i <= 25; i++) {
            WebElement singleBox = vyTrackProject.checkSingleVehiclesPage1;
            Assert.assertTrue(singleBox.isSelected(),"FAILED!");
            System.out.println(i + "." + " Verify all the vehicle costs are checked is: " + singleBox.isSelected());
        }
    }

    @Test (priority = 6)
    public void TC2_Salesmanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.fleetBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.vehicleCostsUnderFleet.click();

        vyTrackProject.checkAllVehiclesPage.click();

        for (int i = 1; i <= 25; i++) {
            WebElement singleBox = vyTrackProject.checkSingleVehiclesPage1;
            Assert.assertTrue(singleBox.isSelected(),"FAILED!");
            System.out.println(i + "." + " Verify all the vehicle costs are checked is: " + singleBox.isSelected());
        }
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
