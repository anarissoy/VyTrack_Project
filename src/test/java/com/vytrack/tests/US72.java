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

public class US72 {
    /**
     * As a user, I want to filter customers’ info on the Account page.
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
         * Description:  users see 8 account name filter options
         * Environment: https://qa2.vytrack.com/user/login
         * Steps:
         * Log in as store or sales managers
         * Click the “Accounts” under the Customers
         * Verify there are 8 filter options
         * Account Name, Contact Name, Contact Email, Contact Phone, Owner,  Business Unit, Created At, Updated At
         */

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        vyTrackProject.customersBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.accountsBtnUnderCustomer.click();

        List<String> expectedLinks = new ArrayList<>(Arrays.asList("ACCOUNT NAME", "CONTACT NAME", "CONTACT EMAIL", "CONTACT PHONE",
                "OWNER","BUSINESS UNIT","CREATED AT", "UPDATED AT"));

        String expectedList = "";
        for (String each : expectedLinks){
            expectedList += each + ", ";
        }
        System.out.println(expectedList + "-->> " + expectedLinks.size() + " filter options on expected links");


        List<String> actualLinks = new ArrayList<>(Arrays.asList(vyTrackProject.accountNameColumn.getText(), vyTrackProject.contactNameColumn.getText(), vyTrackProject.contactEmailColumn.getText(),
                vyTrackProject.contactPhoneColumn.getText(), vyTrackProject.ownerColumn.getText(), vyTrackProject.createdAtColumn.getText(), vyTrackProject.updatedAtColumn.getText()));

        List<String> list = new ArrayList<>();

        for (int i = 0; i < actualLinks.size(); i++){
            list.add(actualLinks.get(i));
        }
        String actualList = "";

        for (String each:list){
            actualList += each + ", ";
        }
        System.out.println(actualList + "-->> " + actualLinks.size() + " filter options on actual links");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        if(actualLinks.size() == expectedLinks.size()){
            System.out.println("Actual size " + actualLinks.size() + " is equal to " + expectedLinks.size());
        }else{
            System.out.println("BUG REPORT:  Actual size " + actualLinks.size() + " is different than " + expectedLinks.size()+"(expected size)");
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Assert.assertEquals(actualLinks.size(),(expectedLinks.size()),"There are 7 filter options instead of 8 (BUSINESS UNIT is missed)");
    }

    @Test (priority = 2)
    public void TC1_Salesmanager() {

        vyTrackProject.usernameInput.sendKeys(ConfigurationReader.getProperty("storemanager1"));
        vyTrackProject.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        BrowserUtils.sleep(1);
        vyTrackProject.loginBtn.click();
        BrowserUtils.waitForVisibilityOf(vyTrackProject.fleetManagement, 10);

        BrowserUtils.waitForVisibilityOf(vyTrackProject.customersBtn, 10);

        vyTrackProject.customersBtn.click();
        BrowserUtils.sleep(2);
        vyTrackProject.accountsBtnUnderCustomer.click();

        List<String> expectedLinks = new ArrayList<>(Arrays.asList("ACCOUNT NAME", "CONTACT NAME", "CONTACT EMAIL", "CONTACT PHONE",
                "OWNER","BUSINESS UNIT","CREATED AT", "UPDATED AT"));

        String expectedList = "";
        for (String each : expectedLinks){
            expectedList += each + ", ";
        }
        System.out.println(expectedList + "-->> " + expectedLinks.size() + " filter options on expected links");


       List<String> actualLinks = new ArrayList<>(Arrays.asList(vyTrackProject.accountNameColumn.getText(), vyTrackProject.contactNameColumn.getText(), vyTrackProject.contactEmailColumn.getText(),
                vyTrackProject.contactPhoneColumn.getText(), vyTrackProject.ownerColumn.getText(), vyTrackProject.createdAtColumn.getText(), vyTrackProject.updatedAtColumn.getText()));

        List<String> list = new ArrayList<>();

        for (int i = 0; i < actualLinks.size(); i++){
            list.add(actualLinks.get(i));
        }
        String actualList = "";

        for (String each:list){
            actualList += each + ", ";
        }
        System.out.println(actualList + "-->> " + actualLinks.size() + " filter options on actual links");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        if(actualLinks.size() == expectedLinks.size()){
            System.out.println("Actual size " + actualLinks.size() + " is equal to " + expectedLinks.size());
        }else{
            System.out.println("BUG REPORT:  Actual size " + actualLinks.size() + " is different than " + expectedLinks.size()+"(expected size)");
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Assert.assertEquals(actualLinks.size(),(expectedLinks.size()),"There are 7 filter options instead of 8 (BUSINESS UNIT is missed)");
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}




//        for (int i = 0; i < actualList.size(); i++){
//            System.out.println(i+1+". "+actualList.get(i));
//        }
//        System.out.println();
//        for (int j = 0; j < expectedList.size(); j++){
//            System.out.println(j+1+". "+expectedList.get(j));
//        }


//        Assert.assertEquals(actualList.size(),(expectedList.size()),"There are 7 filter options instead of 8");

//        a[@class='grid-header-cell__link']/span  //  //span[@class='grid-header-cell__label']

//        WebElement top = Driver.getDriver().findElement(By.xpath("//a[@class='grid-header-cell__link']/span"));
//        WebElement top1 = Driver.getDriver().findElement(By.xpath("(//a[@class='grid-header-cell__link']/span)[1]"));
//        WebElement top2 = Driver.getDriver().findElement(By.xpath("(//a[@class='grid-header-cell__link']/span)[3]"));
//        WebElement top3 = Driver.getDriver().findElement(By.xpath("(//a[@class='grid-header-cell__link']/span)[5]"));
//        WebElement top4 = Driver.getDriver().findElement(By.xpath("(//a[@class='grid-header-cell__link']/span)[7]"));
//        WebElement top5 = Driver.getDriver().findElement(By.xpath("(//a[@class='grid-header-cell__link']/span)[9]"));
//        WebElement top6 = Driver.getDriver().findElement(By.xpath("(//a[@class='grid-header-cell__link']/span)[15]"));
//
//        System.out.println("+++++++++++++++++++++");
//        //System.out.println("0 " + top.getText());
//        System.out.println("1 " + top1.getText());
//        System.out.println("2 " + top2.getText());
//        System.out.println("3 " + top3.getText());
//        System.out.println("4 " + top4.getText());
//        System.out.println("5 " + top5.getText());
//        System.out.println("6 " + top6.getText());
//
//        System.out.println(actualLinks.size());

//        Assert.assertEquals(actualLinks.size(), 6);
//
//        List<String> expectedLinkTexts = new ArrayList<>(Arrays.asList("Used Cars", "New Cars", "Certified Cars", "Dealerships Near Me", "Delivery", "Buying a Car During Coronavirus"));
//
//        for (int i = 0; i < actualLinks.size(); i++) {
//            Assert.assertEquals(actualLinks.get(i).getText(), expectedLinkTexts.get(i));
//        }