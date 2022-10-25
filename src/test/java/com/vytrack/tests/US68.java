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

public class US68 {
    /**
     * As a user, I want to create a recurring(repetitive) calendar event.
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
         * Description:  users see the default repeat day as 1
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Users are on the homepage
         * Click the “Calendar Events” under the Activities
         * Click the “Create Calendar Event” button
         * Check the Repeat checkbox
         * Verify the repeat number is 1
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        vyTrackProject.loginBtn.click();
        BrowserUtils.sleep(2);
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.activitiesBtnAsDriver.click();
        BrowserUtils.sleep(1);
        vyTrackProject.calendarEventsUnderActivitiesBtn.click();
        BrowserUtils.sleep(1);
        vyTrackProject.creatCalendarEvent.click();
        BrowserUtils.sleep(2);
        vyTrackProject.repeatCheckBox.click(); // //input[@id='recurrence-repeat-view896']

        Assert.assertEquals(vyTrackProject.verifyOneOnRepeatCheckBox.getAttribute("value"),"1");
        System.out.println("Verify the repeat number is: " + vyTrackProject.verifyOneOnRepeatCheckBox.getAttribute("value"));
    }

    @Test (priority = 2)
    public void TC1_Storemanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.activitiesBtn.click();
        BrowserUtils.sleep(1);
        vyTrackProject.calendarEventsUnderActivitiesBtn.click();
        BrowserUtils.sleep(1);
        vyTrackProject.creatCalendarEvent.click();
        BrowserUtils.sleep(2);
        vyTrackProject.repeatCheckBox.click(); // //input[@id='recurrence-repeat-view896']

        Assert.assertEquals(vyTrackProject.verifyOneOnRepeatCheckBox.getAttribute("value"),"1");
        System.out.println("Verify the repeat number is: " + vyTrackProject.verifyOneOnRepeatCheckBox.getAttribute("value"));
    }

    @Test (priority = 3)
    public void TC1_Salesmanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.activitiesBtn.click();
        BrowserUtils.sleep(1);
        vyTrackProject.calendarEventsUnderActivitiesBtn.click();
        BrowserUtils.sleep(1);
        vyTrackProject.creatCalendarEvent.click();
        BrowserUtils.sleep(2);
        vyTrackProject.repeatCheckBox.click(); // //input[@id='recurrence-repeat-view896']

        Assert.assertEquals(vyTrackProject.verifyOneOnRepeatCheckBox.getAttribute("value"),"1");
        System.out.println("Verify the repeat number is: " + vyTrackProject.verifyOneOnRepeatCheckBox.getAttribute("value"));
    }

    @Test (priority = 4)
    public void TC2_Driver() {
        /**
         * Test cases #2
         * Description:  users clear the repat day and see an error message
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Users are on the homepage
         * Click the “Calendar Events” under the Activities
         * Click the “Create Calendar Event” button
         * Check the Repeat checkbox
         * Clear(delete) the number 1
         * Verify the app displays “This value should not be blank.”
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.activitiesBtnAsDriver.click();
        BrowserUtils.sleep(1);
        vyTrackProject.calendarEventsUnderActivitiesBtn.click();
        BrowserUtils.sleep(1);
        vyTrackProject.creatCalendarEvent.click();
        BrowserUtils.sleep(2);
        vyTrackProject.repeatCheckBox.click();
        vyTrackProject.verifyOneOnRepeatCheckBox.clear();

        Assert.assertEquals(vyTrackProject.repeatCheckBoxEmptyErrMsg.getText(), "This value should not be blank.");

        System.out.println(vyTrackProject.repeatCheckBoxEmptyErrMsg.getText() + " is Displayed");
    }

    @Test (priority = 5)
    public void TC2_Storemanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.activitiesBtn.click();
        BrowserUtils.sleep(1);
        vyTrackProject.calendarEventsUnderActivitiesBtn.click();
        BrowserUtils.sleep(1);
        vyTrackProject.creatCalendarEvent.click();
        BrowserUtils.sleep(2);
        vyTrackProject.repeatCheckBox.click();
        vyTrackProject.verifyOneOnRepeatCheckBox.clear();

        Assert.assertEquals(vyTrackProject.repeatCheckBoxEmptyErrMsg.getText(), "This value should not be blank.");

        System.out.println(vyTrackProject.repeatCheckBoxEmptyErrMsg.getText() + " is Displayed");
    }

    @Test (priority = 6)
    public void TC2_Salesmanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.activitiesBtn.click();
        BrowserUtils.sleep(1);
        vyTrackProject.calendarEventsUnderActivitiesBtn.click();
        BrowserUtils.sleep(1);
        vyTrackProject.creatCalendarEvent.click();
        BrowserUtils.sleep(2);
        vyTrackProject.repeatCheckBox.click();
        vyTrackProject.verifyOneOnRepeatCheckBox.clear();

        Assert.assertEquals(vyTrackProject.repeatCheckBoxEmptyErrMsg.getText(), "This value should not be blank.");

        System.out.println(vyTrackProject.repeatCheckBoxEmptyErrMsg.getText() + " is Displayed");
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
