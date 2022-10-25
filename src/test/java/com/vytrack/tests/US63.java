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

public class US63 {
    /**
     * As a user, I want to learn how to use the pinbar.
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
         * Description: users learn how to use the pinbar
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Users are on the homepage
         * Click the Learn how to use this space message
         * Verify the users see 2 messages:
         * “How To Use Pinbar”  and
         * ====> “Use ((the) is extra) pin icon on the right top corner of the page to create fast access link in the pinbar.”
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.learnHowToUseSpace.click();

        Assert.assertEquals(vyTrackProject.howToUsePinbarMsg.getText(),"How To Use Pinbar");

        Assert.assertFalse(Boolean.parseBoolean(vyTrackProject.usePinIconMsg.getText()),"Use the pin icon on the right top corner of the page to create fast access link in the pinbar.");

        Assert.assertTrue(vyTrackProject.howToUsePinbarMsg.isDisplayed()&&vyTrackProject.usePinIconMsg.isDisplayed());

        System.out.println("How To Use Pinbar is displayed: " + vyTrackProject.howToUsePinbarMsg.getText());
        System.out.println();
        System.out.println("Use the pin icon on the right top corner of the page to create fast access link in the pinbar. is displayed as expected:  " + Boolean.parseBoolean(vyTrackProject.usePinIconMsg.getText()));
        System.out.println(vyTrackProject.usePinIconMsg.getText() + "  :is actual message");
    }

    @Test (priority = 2)
    public void TC1_Storemanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.learnHowToUseSpace.click();

        Assert.assertEquals(vyTrackProject.howToUsePinbarMsg.getText(),"How To Use Pinbar");

        Assert.assertFalse(Boolean.parseBoolean(vyTrackProject.usePinIconMsg.getText()),"Use the pin icon on the right top corner of the page to create fast access link in the pinbar.");

        Assert.assertTrue(vyTrackProject.howToUsePinbarMsg.isDisplayed()&&vyTrackProject.usePinIconMsg.isDisplayed());

        System.out.println("How To Use Pinbar is displayed: " + vyTrackProject.howToUsePinbarMsg.getText());
        System.out.println();
        System.out.println("Use the pin icon on the right top corner of the page to create fast access link in the pinbar. is displayed as expected:  " + Boolean.parseBoolean(vyTrackProject.usePinIconMsg.getText()));
        System.out.println(vyTrackProject.usePinIconMsg.getText() + "  :is actual message");
    }

    @Test (priority = 3)
    public void TC1_Salesmanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.learnHowToUseSpace.click();

        Assert.assertEquals(vyTrackProject.howToUsePinbarMsg.getText(),"How To Use Pinbar");

        Assert.assertFalse(Boolean.parseBoolean(vyTrackProject.usePinIconMsg.getText()),"Use the pin icon on the right top corner of the page to create fast access link in the pinbar.");

        Assert.assertTrue(vyTrackProject.howToUsePinbarMsg.isDisplayed()&&vyTrackProject.usePinIconMsg.isDisplayed());

        System.out.println("How To Use Pinbar is displayed: " + vyTrackProject.howToUsePinbarMsg.getText());
        System.out.println();
        System.out.println("Use the pin icon on the right top corner of the page to create fast access link in the pinbar. is displayed as expected:  " + Boolean.parseBoolean(vyTrackProject.usePinIconMsg.getText()));
        System.out.println(vyTrackProject.usePinIconMsg.getText() + "  :is actual message");
    }

    @Test (priority = 4)
    public void TC2_Driver() {
        /**
         * Test cases #2
         * Description: users see an image on the pinbar page
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Users are on the homepage
         * Click the Learn how to use this space message
         * Verify users see an image
         * (manual testing - screenshot proof
         * Automation testing - verify image source)
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.learnHowToUseSpace.click();

        Assert.assertEquals(vyTrackProject.howToUsePinbarImgSource.getAttribute("src"),"https://qa2.vytrack.com/bundles/oronavigation/images/pinbar-location.jpg");
        System.out.println("This -->  " + vyTrackProject.howToUsePinbarImgSource.getAttribute("src"));
    }

    @Test (priority = 5)
    public void TC2_Storemanager() {
        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.learnHowToUseSpace.click();

        Assert.assertEquals(vyTrackProject.howToUsePinbarImgSource.getAttribute("src"),"https://qa2.vytrack.com/bundles/oronavigation/images/pinbar-location.jpg");
        System.out.println("This -->  " + vyTrackProject.howToUsePinbarImgSource.getAttribute("src"));
    }

    @Test (priority = 6)
    public void TC2_Salesmanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.learnHowToUseSpace.click();

        Assert.assertEquals(vyTrackProject.howToUsePinbarImgSource.getAttribute("src"),"https://qa2.vytrack.com/bundles/oronavigation/images/pinbar-location.jpg");
        System.out.println("This -->  " + vyTrackProject.howToUsePinbarImgSource.getAttribute("src"));
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
