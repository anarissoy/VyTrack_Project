package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VyTrackProject {

    public VyTrackProject(){
        /**
         * PageFactory class is a Selenium class that support POM
         * It has method called initElements. Once it`s called it will store all elements specified using @FindBy
         * annotation with locator, and it will give elements to the classes when they called
         * initElements method accept 2 arg.
         */
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@id='prependedInput']")
    public WebElement usernameInput;

    @FindBy (xpath="//input[@id='prependedInput2']")
    public WebElement passwordInput;

    @FindBy (xpath = "//button[@id='_submit']")
    public WebElement loginBtn;

    @FindBy (xpath = "//span[.='Log out']")
    public WebElement logOutBtn;

    @FindBy (xpath = "(//span[@class='title title-level-1'])[1]")
    public WebElement dashboardsBtn;

    @FindBy (xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement fleetBtn;

    @FindBy (xpath = "(//span[@class='title title-level-1'])[3]")
    public WebElement customersBtn;

    @FindBy (xpath = "(//span[@class='title title-level-1'])[4]")
    public WebElement salesBtn;

    @FindBy (xpath = "(//span[@class='title title-level-1'])[5]")
    public WebElement activitiesBtn;

    @FindBy (xpath = "(//span[@class='title title-level-1'])[6]")
    public WebElement marketingBtn;

    @FindBy (xpath = "(//span[@class='title title-level-1'])[7]")
    public WebElement reportAndSegmentsBtn;

    @FindBy (xpath = "(//span[@class='title title-level-1'])[8]")
    public WebElement systemBtn;

    @FindBy (xpath = "(//span[@class='title title-level-1'])[1]")
    public WebElement fleetBtnAsDriver;

    @FindBy (xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement customersBtnAsDriver;

    @FindBy (xpath = "(//span[@class='title title-level-1'])[3]")
    public WebElement activitiesBtnAsDriver;

    @FindBy (xpath = "(//span[@class='title title-level-1'])[4]")
    public WebElement systemBtnAsDriver;

    @FindBy (xpath = "//a[.='Learn how to use this space']")
    public WebElement learnHowToUseSpace;

    @FindBy (xpath = "//h3[.='How To Use Pinbar']")
    public WebElement  howToUsePinbarMsg;

    @FindBy (xpath = "//p[1]")
    public WebElement usePinIconMsg;

    //@FindBy (xpath = "//img[@src='/bundles/oronavigation/images/pinbar-location.jpg']")
    @FindBy (xpath = "//p[2]/img")
    public WebElement howToUsePinbarImgSource;

    @FindBy (xpath = "//a[@href='/entity/Extend_Entity_VehicleContract']/span")
    public WebElement vehicleContractsBtn;

    @FindBy (xpath = "//h1[normalize-space()='All Vehicle Contract']")
    public WebElement verifyAllVehicleContractPage;

    @FindBy (xpath = "//div[.='You do not have permission to perform this action.']")
    public WebElement vehicleContractsBtnAsDriver;

    @FindBy (xpath = "//span[@class='grid-header-cell__label']")
    public List<WebElement> vehicleModelsColumn;

    @FindBy (xpath = "//div[@id='main-menu']/ul/li[2]/div/div/ul/li[9]/a/span")  // Announcement //Workflow
    public WebElement vehiclesModelUnderFleet;

    @FindBy (xpath = "//span[.='Vehicles Model']")
    public WebElement vehiclesModelUnderFleetDriver;

    @FindBy (xpath = "//span[.='Model Name']")
    public WebElement modelNameBtn;

    @FindBy (xpath = "//span[.='Make']")
    public WebElement makeBtn;

    @FindBy (xpath = "//span[.='Can be requested']")
    public WebElement canBeRequestedBtn;

    @FindBy (xpath = "//span[.='CVVI']")
    public WebElement cvviBtn;

    @FindBy (xpath = "//span[.='CO2 Fee (/month)']")
    public WebElement co2FeeBtn;

    @FindBy (xpath = "//span[.='Cost (Depreciated)']")
    public WebElement costDepreciatedBtn;

    @FindBy (xpath = "//span[.='Total Cost (Depreciated)']")
    public WebElement totalCostDepreciated;

    @FindBy (xpath = "//span[.='CO2 Emissions']")
    public WebElement emissionsBtn;

    @FindBy (xpath = "//span[.='Fuel Type']")
    public WebElement fuelTypeBtn;

    @FindBy (xpath = "//span[.='Vendors']")
    public WebElement vendorsBtn;

    @FindBy (xpath = "//span[.='Vehicles']")
    public WebElement vehiclesUnderFleet;

    @FindBy (xpath = "//td[@data-column-label='test']/div/div/a")
    public WebElement threeDot;

    @FindBy (xpath = "(//div[@class='more-bar-holder']/div)[1]")
    public WebElement threeDotVerify;

    @FindBy (xpath = "//button[@class='btn btn-default btn-small dropdown-toggle']/input")
    public WebElement checkAllVehiclesPage; ////div[@id='grid-custom-entity-grid-722947697']/div[2]/div[2]/div[2]/div/table/thead[1]/tr/th[1]/div/button/input

    @FindBy (xpath = "//input[@tabindex='-1']")
    public List<WebElement> checkSingleVehiclesPage;

    @FindBy (xpath = "//input[@tabindex='-1']")
    public WebElement checkSingleVehiclesPage1;

    @FindBy (xpath = "(//input[@tabindex='-1'])[1]")
    public WebElement checkAnySingleBoxVehiclesPage;

    @FindBy (xpath = "//span[.='Calendar Events']")
    public WebElement calendarEventsUnderActivitiesBtn;

    @FindBy (xpath = "//a[@title='Create Calendar event']")
    public WebElement creatCalendarEvent;

    @FindBy (xpath = "//input[@data-name='recurrence-repeat']")
    public WebElement repeatCheckBox;

    @FindBy (xpath = "(//input[@value='1'])[2]")
    public WebElement verifyOneOnRepeatCheckBox;

    @FindBy (xpath = "//span[starts-with(@id,'temp-validation-name')]/span[.='This value should not be blank.']")
    public WebElement repeatCheckBoxEmptyErrMsg;

    @FindBy (xpath = "//span[starts-with(@id,'temp-validation-name')]/span[.='The value have not to be more than 99.']")
    public WebElement repeatCheckBoxOver99ErrMsg;

    @FindBy (xpath = "//span[starts-with(@id,'temp-validation-name')]/span[.='The value have not to be less than 1.']")
    public WebElement repeatCheckBoxLess1ErrMsg;

    @FindBy (xpath = "//div[@id='mceu_24']/iframe")
    public WebElement calendarEventDescFrame;

    @FindBy (xpath = "//body[@id='tinymce']")
    public WebElement calendarEventDescTextArea;

    @FindBy (xpath = "//span[.='Accounts']")
    public WebElement accountsBtnUnderCustomer;

    @FindBy (xpath = "//span[.='Contact name']")
    public WebElement contactNameColumn;

    @FindBy (xpath = "//span[.='Account name']")
    public WebElement accountNameColumn;

    @FindBy (xpath = "//span[.='Contact email']")
    public WebElement contactEmailColumn;

    @FindBy (xpath = "//span[.='Contact phone']")
    public WebElement contactPhoneColumn;

    @FindBy (xpath = "//span[.='Owner']")
    public WebElement ownerColumn;

    @FindBy (xpath = "//span[.='Created At']")
    public WebElement createdAtColumn;

    @FindBy (xpath = "//span[.='Updated At']")
    public WebElement updatedAtColumn;

    @FindBy (xpath = "//span[.='Vehicle Odometer']")
    public WebElement vehicleOdometerUnderFleet;

    @FindBy (xpath = "//div[.='You do not have permission to perform this action.']")
    public WebElement vehicleOdometerErrMsg;

    @FindBy (xpath = "//input[@value='1']")
    public WebElement verify1OnVehicleOdometerPage;

    @FindBy (xpath = "//div[@class='btn-group']/button")
    public WebElement verify25OnVehicleOdometerPage;


    @FindBy (xpath = "//span[.='Vehicle Costs']")
    public WebElement vehicleCostsUnderFleet;

    @FindBy (xpath = "//span[.='Type']")
    public WebElement verifyType;

    @FindBy (xpath = "//span[.='Total Price']")
    public WebElement verifyTotalPrice;

    @FindBy (xpath = "//span[.='Date']")
    public WebElement verifyDate;

    @FindBy (xpath = "(//span[.='Campaigns'])[1]")
    public WebElement campaignsBtnUnderMarketing;

    @FindBy (xpath = "//a[.='Fleet Management']")
    public WebElement fleetManagement;

    @FindBy (xpath = "//a[@href='http://www.oroinc.com/doc']/i")
    public WebElement questionOnTop;






}
