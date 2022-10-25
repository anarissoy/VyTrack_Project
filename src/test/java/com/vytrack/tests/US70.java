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

public class US70 {
    /**
     * As a user, I want to write the “Description” when I create a calendar event. (Iframe)
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
         * Description:  users write a description to create a calendar event
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Users are on the homepage
         * Click the “Calendar Events” under the Activities
         * Click the “Create Calendar Event” button
         * Write a message in the Description field
         * Verify the message is written in the input box
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        vyTrackProject.loginBtn.click();
        BrowserUtils.sleep(2);
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.activitiesBtnAsDriver.click();
        BrowserUtils.sleep(2);
        vyTrackProject.calendarEventsUnderActivitiesBtn.click();
        BrowserUtils.sleep(2);

        vyTrackProject.creatCalendarEvent.click();
        BrowserUtils.sleep(2);

        Driver.getDriver().switchTo().frame(vyTrackProject.calendarEventDescFrame);
        vyTrackProject.calendarEventDescTextArea.sendKeys(faker.bothify("I love Java"));
        Assert.assertEquals(vyTrackProject.calendarEventDescTextArea.getText(),"I love Java");
        System.out.println(vyTrackProject.calendarEventDescTextArea.getText() + " - is Displayed");
    }

    @Test (priority = 2)
    public void TC1_Storemanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.activitiesBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.calendarEventsUnderActivitiesBtn.click();
        BrowserUtils.sleep(2);

        vyTrackProject.creatCalendarEvent.click();
        BrowserUtils.sleep(2);

        Driver.getDriver().switchTo().frame(vyTrackProject.calendarEventDescFrame);
        vyTrackProject.calendarEventDescTextArea.sendKeys(faker.bothify("I love Java"));
        Assert.assertEquals(vyTrackProject.calendarEventDescTextArea.getText(),"I love Java");
        System.out.println(vyTrackProject.calendarEventDescTextArea.getText() + " - is Displayed");
    }

    @Test (priority = 3)
    public void TC1_Salesperson() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.activitiesBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.calendarEventsUnderActivitiesBtn.click();
        BrowserUtils.sleep(2);

        vyTrackProject.creatCalendarEvent.click();
        BrowserUtils.sleep(2);

        Driver.getDriver().switchTo().frame(vyTrackProject.calendarEventDescFrame);
        vyTrackProject.calendarEventDescTextArea.sendKeys(faker.bothify("I love Java"));
        Assert.assertEquals(vyTrackProject.calendarEventDescTextArea.getText(),"I love Java");
        System.out.println(vyTrackProject.calendarEventDescTextArea.getText() + " - is Displayed");
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
