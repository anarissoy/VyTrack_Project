package com.vytrack.tests;

import com.github.javafaker.Faker;
import com.vytrack.pages.VyTrackProject;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US74 {
    /**
     * As a user, I want to manage filters on the Marketing page.
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
         * Description: managers see default checked filters on the Campaigns page
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Users are on the homepage
         * Click the Campaigns under the Marketing
         * Click the Manage filters button
         * Verify 5 options are checked by default
         *
         * BUG REPORT - Verify 5 options are checked by default is FAILED for Storemanager account
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.marketingBtn.click();
        BrowserUtils.sleep(1);
        vyTrackProject.campaignsBtnUnderMarketing.click();

        System.out.println("BUG REPORT - Verify 5 options are checked by default is FAILED");
    }

    @Test (priority = 2)
    public void TC1_Salesmanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.marketingBtn.click();
        BrowserUtils.sleep(1);
        vyTrackProject.campaignsBtnUnderMarketing.click();

        System.out.println("BUG REPORT - Verify 5 options are checked by default is FAILED");
    }

    @Test (priority = 3)
    public void TC2_Storemanager() {
        /**
         * Test cases #2
         * Description: managers can uncheck any filter options
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Users are on the homepage
         * Click the Campaigns under the Marketing
         * Click the Manager filters button
         * Uncheck one or more filter options
         * Verify one or more options are unchecked
         *
         * BUG REPORT - Click the Manager filters button is FAILED
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.marketingBtn.click();
        BrowserUtils.sleep(1);
        vyTrackProject.campaignsBtnUnderMarketing.click();

        System.out.println("BUG REPORT - Click the Manager filters button is FAILED");
    }

    @Test (priority = 4)
    public void TC2_Salesmanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.marketingBtn.click();
        BrowserUtils.sleep(1);
        vyTrackProject.campaignsBtnUnderMarketing.click();

        System.out.println("BUG REPORT - Click the Manager filters button is FAILED");
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
