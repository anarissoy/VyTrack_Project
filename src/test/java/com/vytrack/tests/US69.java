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

public class US69 {
    /**
     *As a user, I should see error messages when I enter an invalid integer into the calendar repeat day input box.
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
         * Description:  users enter an INVALID integer in the repeat day input box
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Users are on the homepage
         * Click the “Calendar Events” under the Activities
         * Click the “Create Calendar Event” button
         * Check the Repeat checkbox
         * Users enter an INVALID integer (x<1 || x>99)
         * Verify users get 2 error messages
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        vyTrackProject.loginBtn.click();
        BrowserUtils.sleep(2);
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.activitiesBtnAsDriver.click();
        BrowserUtils.sleep(1);
        vyTrackProject.calendarEventsUnderActivitiesBtn.click();
        BrowserUtils.sleep(2);

        vyTrackProject.creatCalendarEvent.click();
        BrowserUtils.sleep(2);
        vyTrackProject.repeatCheckBox.click();

        vyTrackProject.verifyOneOnRepeatCheckBox.clear();
        BrowserUtils.sleep(1);
        vyTrackProject.verifyOneOnRepeatCheckBox.sendKeys(faker.numerify("1##"));

        Assert.assertEquals(vyTrackProject.repeatCheckBoxOver99ErrMsg.getText(),"The value have not to be more than 99.");
        System.out.println(vyTrackProject.repeatCheckBoxOver99ErrMsg.getText() + " :is Displayed");
        BrowserUtils.sleep(1);

        vyTrackProject.verifyOneOnRepeatCheckBox.clear();
        BrowserUtils.sleep(1);
        vyTrackProject.verifyOneOnRepeatCheckBox.sendKeys(faker.numerify("-###"));

        Assert.assertEquals(vyTrackProject.repeatCheckBoxLess1ErrMsg.getText(),"The value have not to be less than 1.");
        System.out.println(vyTrackProject.repeatCheckBoxLess1ErrMsg.getText() + " :is Displayed");
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
        BrowserUtils.sleep(2);

        vyTrackProject.creatCalendarEvent.click();
        BrowserUtils.sleep(2);
        vyTrackProject.repeatCheckBox.click();

        vyTrackProject.verifyOneOnRepeatCheckBox.clear();
        BrowserUtils.sleep(1);
        vyTrackProject.verifyOneOnRepeatCheckBox.sendKeys(faker.numerify("1##"));

        Assert.assertEquals(vyTrackProject.repeatCheckBoxOver99ErrMsg.getText(),"The value have not to be more than 99.");
        System.out.println(vyTrackProject.repeatCheckBoxOver99ErrMsg.getText() + " :is Displayed");
        BrowserUtils.sleep(1);

        vyTrackProject.verifyOneOnRepeatCheckBox.clear();
        BrowserUtils.sleep(1);
        vyTrackProject.verifyOneOnRepeatCheckBox.sendKeys(faker.numerify("-###"));

        Assert.assertEquals(vyTrackProject.repeatCheckBoxLess1ErrMsg.getText(),"The value have not to be less than 1.");
        System.out.println(vyTrackProject.repeatCheckBoxLess1ErrMsg.getText() + " :is Displayed");
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
        BrowserUtils.sleep(2);

        vyTrackProject.creatCalendarEvent.click();
        BrowserUtils.sleep(2);
        vyTrackProject.repeatCheckBox.click();

        vyTrackProject.verifyOneOnRepeatCheckBox.clear();
        BrowserUtils.sleep(1);
        vyTrackProject.verifyOneOnRepeatCheckBox.sendKeys(faker.numerify("1##"));

        Assert.assertEquals(vyTrackProject.repeatCheckBoxOver99ErrMsg.getText(),"The value have not to be more than 99.");
        System.out.println(vyTrackProject.repeatCheckBoxOver99ErrMsg.getText() + " :is Displayed");
        BrowserUtils.sleep(1);

        vyTrackProject.verifyOneOnRepeatCheckBox.clear();
        BrowserUtils.sleep(1);
        vyTrackProject.verifyOneOnRepeatCheckBox.sendKeys(faker.numerify("-###"));

        Assert.assertEquals(vyTrackProject.repeatCheckBoxLess1ErrMsg.getText(),"The value have not to be less than 1.");
        System.out.println(vyTrackProject.repeatCheckBoxLess1ErrMsg.getText() + " :is Displayed");
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
